package com.multimedia_pj.was.socket;

import com.multimedia_pj.was.model.BtcData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;

public class Connector extends Thread {
    private Socket socket;
    private FileInputStream fis;
    private BufferedOutputStream bos;

    private String timeInterval;

    private OutputStream os;

    private InputStream is;
    private BufferedInputStream bis;

    private double result;
    private List<BtcData> pastData;

    public Connector(Socket socket, String timeInterval) {
        this.socket = socket;
        this.timeInterval = timeInterval;
        try {
            // 데이터 스트림 생성
            this.os = socket.getOutputStream();
            bos = new BufferedOutputStream(os);
            this.is = socket.getInputStream();
            bis = new BufferedInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean sendTimeInterval(String timeInterval) throws IOException {
        bos.write(timeInterval.getBytes());
        bos.flush();
        System.out.println("send time interval : " + timeInterval);
        return true;
    }

    public String receiveData(int buffer_size) throws IOException {
        byte[] tmp = new byte[buffer_size];
        int len = bis.read(tmp);
        String ret = new String(tmp, StandardCharsets.UTF_8);

        System.out.println("RESPONSE FROM SERVER : " + ret);
        return ret;
    }

    public double getResult() {
        return result;
    }

    public List<BtcData> getPastData() {
        return pastData;
    }

    public void close() {
        try {
            bos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // "yyyy-MM-dd HH:mm:00" 형태로 UTC 시간 반환
    public static String getTime() {
        String time = Instant.now().toString();
        time = time.replace('T', ' ');
        time = time.substring(0, 17);
        time = time.concat("00");

        return time;
    }

    @Override
    public void run() {

        JSONParser parser = new JSONParser();
        JSONObject obj;

        try {
            sendTimeInterval(timeInterval);
            String byteData = receiveData(100);

            System.out.println("CONNECTOR RECIEVED BYTEDATA : " + byteData);
            result = Double.parseDouble(byteData);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

}


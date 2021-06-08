package com.multimedia_pj.was.socket;

import com.multimedia_pj.was.model.BtcData;

import java.net.Socket;
import java.util.List;

public class Client {
    Socket socket = null;
    String serverIp = "127.0.0.1";
    int serverPort = 5005;

    String timeInterval;    // 가격봉의 간격 ex) 1분봉, 5분봉, 15분봉...
    double result;  // 예측 가격
    List<BtcData> pastData;

    public Client(String timeInterval) {
        this.timeInterval = timeInterval;

        try {
            // 서버 연결
            socket = new Socket(serverIp, serverPort); // socket(),connect();
            System.out.println("서버에 연결되었습니다.");
            System.out.println(serverIp + " : " + serverPort);

            Connector c = new Connector(socket, timeInterval);
            c.start();
            c.join();
            result = c.getResult();

        } catch (Exception e) {
            e.printStackTrace();
        }// catch
    }

    public double getResult() {
        return result;
    }

    public List<BtcData> getPastData() {
        return pastData;
    }
}

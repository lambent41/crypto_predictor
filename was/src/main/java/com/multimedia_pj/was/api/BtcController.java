package com.multimedia_pj.was.api;

import com.google.gson.Gson;
import com.multimedia_pj.was.model.BtcData;
import com.multimedia_pj.was.model.Response;
import com.multimedia_pj.was.service.BtcDataService;
import com.multimedia_pj.was.socket.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BtcController {

    private final BtcDataService btcDataService;

    @Autowired
    public BtcController(BtcDataService btcDataService) {
        this.btcDataService = btcDataService;
    }

    @RequestMapping(path="{timeInterval}", produces="text/plain;charset=UTF-8")
    public @ResponseBody String getPrediction(@PathVariable("timeInterval") String timeInterval) {

        // 클라이언트 객체
        Client client = new Client(timeInterval);
        double result = client.getResult();

        return Double.toString(result);
    }

}

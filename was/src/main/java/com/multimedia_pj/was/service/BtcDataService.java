package com.multimedia_pj.was.service;

import com.multimedia_pj.was.dao.BtcDataDao;
import com.multimedia_pj.was.model.BtcData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BtcDataService {
    private final BtcDataDao btcDataDao;

    @Autowired
    public BtcDataService(@Qualifier("mysql_btc") BtcDataDao btcDataDao) {
        this.btcDataDao = btcDataDao;
    }

}

package com.multimedia_pj.was.service;

import com.multimedia_pj.was.dao.BinanceKeyDao;
import com.multimedia_pj.was.model.BinanceKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BinanceKeyService {

    private final BinanceKeyDao binanceKeyDao;

    @Autowired
    public BinanceKeyService(@Qualifier("mysql") BinanceKeyDao binanceKeyDao) {
        this.binanceKeyDao = binanceKeyDao;
    }

    public int addBinanceKey(BinanceKey binanceKey){
        return binanceKeyDao.insertBinanceKey(binanceKey);
    }

    public List<BinanceKey> getAllBinanceKey(){
        return binanceKeyDao.selectAllBinanceKey();
    }

    public Optional<BinanceKey> getBinanceKeyByApiKey(String apiKey){
        return binanceKeyDao.selectBinanceKeyByApiKey(apiKey);
    }

    public int deleteBinanceKey(String apiKey){
        return binanceKeyDao.deleteBinanceKeyByApiKey(apiKey);
    }

    public int updateBinanceKey(BinanceKey binanceKey){
        return binanceKeyDao.updateBinanceKeyByApiKey(binanceKey);
    }
}

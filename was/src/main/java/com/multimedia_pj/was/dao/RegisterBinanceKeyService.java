package com.multimedia_pj.was.dao;

import com.multimedia_pj.was.model.BinanceKey;
import com.multimedia_pj.was.service.BinanceKeyService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("registerDao")
public class RegisterBinanceKeyService implements BinanceKeyDao{

    private static List<BinanceKey> DB = new ArrayList<>();

    @Override
    public int insertBinanceKey(BinanceKey binanceKey) {
        DB.add(new BinanceKey(binanceKey.getApiKey(), binanceKey.getSecretKey()));
        return 1;
    }

    @Override
    public List<BinanceKey> selectAllBinanceKey() {
        return DB;
    }

    @Override
    public Optional<BinanceKey> selectBinanceKeyByApiKey(String apiKey) {
        return DB.stream()
                .filter(binanceKey -> binanceKey.getApiKey().equals(apiKey))
                .findFirst();
    }

    @Override
    public int deleteBinanceKeyByApiKey(String apiKey) {
        Optional<BinanceKey> binanceKeyMaybe = selectBinanceKeyByApiKey(apiKey);
        if(binanceKeyMaybe.isEmpty()){
            return 0;
        }
        DB.remove(binanceKeyMaybe.get());
        return 1;
    }

    @Override
    public int updateBinanceKeyByApiKey(BinanceKey binanceKey) {
        return selectBinanceKeyByApiKey(binanceKey.getApiKey())
                .map(b -> {
                    int indexOfBinanceKeyToUpdate = DB.indexOf(b);
                    if(indexOfBinanceKeyToUpdate >= 0) {
                        DB.set(indexOfBinanceKeyToUpdate, new BinanceKey(binanceKey.getApiKey(), binanceKey.getSecretKey()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}

package com.multimedia_pj.was.dao;

import com.multimedia_pj.was.model.BinanceKey;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BinanceKeyDao {

    int insertBinanceKey(BinanceKey binanceKey);

    List<BinanceKey> selectAllBinanceKey();

    Optional<BinanceKey> selectBinanceKeyByApiKey(String apiKey);

    int deleteBinanceKeyByApiKey(String apiKey);

    int updateBinanceKeyByApiKey(BinanceKey binanceKey);

}

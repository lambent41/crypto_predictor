package com.multimedia_pj.was.dao;

import com.multimedia_pj.was.model.BtcData;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface BtcDataDao {

    int insertBtcData(BtcData btcData);

    List<BtcData> selectOneSequenceBtcData();

    Optional<BtcData> selectBinanceKeyByTimestamp(Timestamp timestamp);

}

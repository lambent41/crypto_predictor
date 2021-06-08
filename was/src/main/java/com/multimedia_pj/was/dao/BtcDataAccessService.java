package com.multimedia_pj.was.dao;

import com.multimedia_pj.was.model.BinanceKey;
import com.multimedia_pj.was.model.BtcData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository("mysql_btc")
public class BtcDataAccessService implements BtcDataDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BtcDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertBtcData(BtcData btcData) {
        return 0;
    }

    @Override
    public List<BtcData> selectOneSequenceBtcData() {
        final String sql = "SELECT timeStamp, open, high, low, close, volume FROM btcData WHERE timeStamp >= ";

//        return jdbcTemplate.query(sql, (resultSet, i) -> {
//            String apiKey = resultSet.getString("apiKey");
//            String secretKey = resultSet.getString("secretKey");
//
//            return new BinanceKey(apiKey, secretKey);
//        });
        return null;
    }

    @Override
    public Optional<BtcData> selectBinanceKeyByTimestamp(Timestamp timestamp) {
        return Optional.empty();
    }

}

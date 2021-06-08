package com.multimedia_pj.was.dao;

import com.multimedia_pj.was.model.BinanceKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class BinanceKeyDataAccessService implements BinanceKeyDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BinanceKeyDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertBinanceKey(BinanceKey binanceKey) {
        final String sql = "INSERT INTO binancekey(apiKey, secretKey) value(?, ?)";

        jdbcTemplate.update(sql, new Object[]{binanceKey.getApiKey(), binanceKey.getSecretKey()});

        System.out.println("innserting done");

        return 1;
    }

    @Override
    public List<BinanceKey> selectAllBinanceKey() {
        final String sql = "SELECT apiKey, secretKey FROM binancekey";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            String apiKey = resultSet.getString("apiKey");
            String secretKey = resultSet.getString("secretKey");

            return new BinanceKey(apiKey, secretKey);
        });
    }

    @Override
    public Optional<BinanceKey> selectBinanceKeyByApiKey(String apiKey) {
        final String sql = "SELECT apiKey, secretKey FROM binancekey WHERE apiKey = ?";

        BinanceKey binanceKey =  jdbcTemplate.queryForObject(
                sql,
                new Object[]{apiKey},
                (resultSet, i)->{
            String secretKey = resultSet.getString("secretKey");

            return new BinanceKey(apiKey, secretKey);
        });

        return Optional.ofNullable(binanceKey);
    }

    @Override
    public int deleteBinanceKeyByApiKey(String apiKey) {
        return 0;
    }

    @Override
    public int updateBinanceKeyByApiKey(BinanceKey binanceKey) {
        return 0;
    }
}

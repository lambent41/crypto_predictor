CREATE TABLE binanceKey (
                            apiKey VARCHAR(100) NOT NULL PRIMARY KEY,
                            secretKey VARCHAR(100)
);

CREATE TABLE btcData(
    timestamp TIMESTAMP NOT NULL PRIMARY KEY,
    open DOUBLE,
    high DOUBLE,
    low DOUBLE,
    close DOUBLE,
    volume DOUBLE
);

-- LOAD DATA INFILE 'btc_usdt.csv' INTO TABLE btcData FIELDS TERMINATED BY ',' LINES TERMINATED BY '\r\n';
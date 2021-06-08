# -*- coding: utf-8 -*-
import predict
import os
from tensorflow.keras import layers, models
import pandas as pd
import numpy as np
import ccxt
import time
from datetime import datetime
import pandas as pd


class Connect:
    def __init__(self, timeInterval):
        self.timeInterval = timeInterval
        self.modelName = 'model_final_' + str(timeInterval) + '.h5'
        self.binance = ccxt.binance({
            'enableRateLimit': True
        })

    def predict(self):
        model = models.load_model(self.modelName)
        ohlcv = self.binance.fetch_ohlcv('BTC/USDT', timeframe=self.timeInterval)
        df = pd.DataFrame(ohlcv, columns=['datetime', 'open', 'high', 'low', 'close', 'volume'])
        df['datetime'] = pd.to_datetime(df['datetime'], unit='ms')
        df.set_index('datetime', inplace=True)
        timeNow = df.index[-1]

        btc_data = df.to_numpy()
        btc_data_scaled, minVec, maxVec = self.MinMaxScaler(btc_data)

        btc_data_x = btc_data_scaled
        btc_data_x = btc_data_x[-120:, :]

        dataX = []
        dataX.append(btc_data_x)
        dataX = np.array(dataX)

        pred = model.predict(dataX, verbose=1)
        pred_origin = minVec[-2] + pred * (maxVec[-2] - minVec[-2])

        print(timeNow, "UTC시각 다음의 예측 가격은: ", pred_origin[0][0], " USDT 입니다.")
        return pred_origin[0][0]

    def MinMaxScaler(self, data):
        numerator = data - np.min(data, axis=0)
        denominator = np.max(data, 0) - np.min(data, axis=0)
        # 0으로 나누는 걸 방지하기 위해 노이즈 추가
        return numerator / (denominator + 1e-7), np.min(data, axis=0), np.max(data, 0)

#
# if __name__ == '__main__':
#     predictor = Connect('1m')
#     predictor.predict()

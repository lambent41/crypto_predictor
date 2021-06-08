package com.multimedia_pj.was.api;

import com.multimedia_pj.was.model.BinanceKey;
import com.multimedia_pj.was.service.BinanceKeyService;
import com.multimedia_pj.was.service.BtcDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/binanceKey")
@RestController
public class BinanceKeyController {

    private final BinanceKeyService binanceKeyService;
    private final BtcDataService btcDataService;

    @Autowired
    public BinanceKeyController(BinanceKeyService binanceKeyService, BtcDataService btcDataService) {
        this.binanceKeyService = binanceKeyService;
        this.btcDataService = btcDataService;
    }

    @PostMapping
    public void addBinanceKey(@Valid @NonNull @RequestBody BinanceKey binanceKey){
        binanceKeyService.addBinanceKey(binanceKey);
    }

    @GetMapping
    public List<BinanceKey> getAllBinanceKey(){
        return binanceKeyService.getAllBinanceKey();
    }

    @GetMapping(path = "{apiKey}")
    public BinanceKey getBinanceKeyByApiKey(@PathVariable("apiKey") String apiKey){
        return binanceKeyService.getBinanceKeyByApiKey(apiKey)
                .orElse(null);
    }

    @PostMapping(path = "{apiKey}")
    public void deleteBinanceKeyById(@PathVariable("apiKey") String apiKey){
        binanceKeyService.deleteBinanceKey(apiKey);
    }

    @PutMapping(path = "/update")
    public void updateBinanceKey(@Valid @NonNull @RequestBody BinanceKey binanceKeyToUpdate){
        binanceKeyService.updateBinanceKey(binanceKeyToUpdate);
    }

}

package com.Crypto.controller;

import com.Crypto.model.Coin;
import com.Crypto.model.User;
import com.Crypto.model.WatchList;
import com.Crypto.service.CoinService;
import com.Crypto.service.UserService;
import com.Crypto.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/watchlist")
public class WatchListController {
    @Autowired
    private WatchListService watchlistService;
    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;

    @Autowired
    public WatchListController(WatchListService watchlistService,
                               UserService userService) {
        this.watchlistService = watchlistService;
        this.userService=userService;
    }

    @GetMapping("/user")
    public ResponseEntity<WatchList> getUserWatchlist(
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user=userService.findUserProfileByJwt(jwt);
        WatchList watchlist = watchlistService.findUserWatchlist(user.getId());
        return ResponseEntity.ok(watchlist);

    }

//    @PostMapping("/create")
//    public ResponseEntity<WatchList> createWatchlist(
//            @RequestHeader("Authorization") String jwt) throws Exception {
//        User user=userService.findUserProfileByJwt(jwt);
//        WatchList createdWatchlist = watchlistService.createWatchList(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdWatchlist);
//    }

    @GetMapping("/{watchlistId}")
    public ResponseEntity<WatchList> getWatchlistById(
            @PathVariable Long watchlistId) throws Exception {

        WatchList watchlist = watchlistService.findById(watchlistId);
        return ResponseEntity.ok(watchlist);

    }

    @PatchMapping("/add/coin/{coinId}")
    public ResponseEntity<Coin> addItemToWatchlist(
            @RequestHeader("Authorization") String jwt,
            @PathVariable String coinId) throws Exception {


        User user=userService.findUserProfileByJwt(jwt);
        Coin coin=coinService.findById(coinId);
        Coin addedCoin = watchlistService.addItemToWatchlist(coin, user);
        return ResponseEntity.ok(addedCoin);

    }
}

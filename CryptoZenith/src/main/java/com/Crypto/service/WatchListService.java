package com.Crypto.service;

import com.Crypto.model.Coin;
import com.Crypto.model.User;
import com.Crypto.model.WatchList;

public interface WatchListService {
    WatchList findUserWatchlist(Long userId) throws Exception;

    WatchList createWatchList(User user);

    WatchList findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin, User user) throws Exception;
}

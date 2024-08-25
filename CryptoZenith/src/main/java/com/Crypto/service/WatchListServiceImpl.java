package com.Crypto.service;

import com.Crypto.model.Coin;
import com.Crypto.model.User;
import com.Crypto.model.WatchList;
import com.Crypto.repository.WatchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WatchListServiceImpl implements WatchListService{
    @Autowired
    private WatchListRepository watchListRepository;


    @Override
    public WatchList findUserWatchlist(Long userId) throws Exception {
        WatchList watchlist=watchListRepository.findByUserId(userId);
        if(watchlist==null){
            throw new Exception("watchList not found");
        }
        return watchlist;
    }

    @Override
    public WatchList createWatchList(User user) {
        WatchList watchlist=new WatchList();
        watchlist.setUser(user);
        return watchListRepository.save(watchlist);
    }

    @Override
    public WatchList findById(Long id) throws Exception {
        Optional<WatchList> optionalWatchlist = watchListRepository.findById(id);
        if(optionalWatchlist.isEmpty()){
            throw new Exception("watch list not found");
        }
        return optionalWatchlist.get();
    }

    @Override
    public Coin addItemToWatchlist(Coin coin, User user) throws Exception {
        WatchList watchlist=findUserWatchlist(user.getId());

        if(watchlist.getCoins().contains(coin)){
            watchlist.getCoins().remove(coin);
        }
        else watchlist.getCoins().add(coin);
        watchListRepository.save(watchlist);
        return coin;
    }
}

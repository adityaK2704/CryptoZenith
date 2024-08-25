package com.Crypto.service;

import com.Crypto.model.Order;
import com.Crypto.model.User;
import com.Crypto.model.Wallet;
import org.springframework.stereotype.Service;

@Service
public interface WalletService
{
    Wallet getUserWallet(User user);
    Wallet addBalanceToWallet(Wallet wallet, Long money);
    Wallet findWalletById(Long id) throws Exception;
    Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws Exception;
    Wallet payOrderPayment(Order order, User user) throws Exception;

}

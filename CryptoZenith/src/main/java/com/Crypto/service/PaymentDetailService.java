package com.Crypto.service;

import com.Crypto.model.PaymentDetails;
import com.Crypto.model.User;

public interface PaymentDetailService {
    public PaymentDetails addPaymentDetails(String accountNumber,
                                            String accountHolderName,
                                            String ifsc,
                                            String bankName,
                                            User user);

    public PaymentDetails getUsersPaymentDetails(User user);
}

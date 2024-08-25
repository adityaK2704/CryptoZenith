package com.Crypto.service;

import com.Crypto.domain.VerificationType;
import com.Crypto.model.ForgetPasswordToken;
import com.Crypto.model.User;

public interface ForgetPasswordService {

    ForgetPasswordToken createToken(User user,
                                    String id, String otp,
                                    VerificationType verificationType,
                                    String sendTo);

    ForgetPasswordToken findById(String id);

    ForgetPasswordToken findByUser(Long userId);

    void deleteToken(ForgetPasswordToken token);

}

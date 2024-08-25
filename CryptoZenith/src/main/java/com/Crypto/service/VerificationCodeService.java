package com.Crypto.service;

import com.Crypto.domain.VerificationType;
import com.Crypto.model.User;
import com.Crypto.model.VerificationCode;
import org.springframework.stereotype.Service;

@Service
public interface VerificationCodeService {
    VerificationCode sendVerificationCode(User user, VerificationType verificationType);

    VerificationCode getVerificationCodeById(Long id) throws Exception;

    VerificationCode getVerificationCodeByUser(Long userId);

    void deleteVerificationCodeById(VerificationCode verificationCode);


}

package com.hxc.interview.userservice.service;


import com.hxc.interView.common.entity.User;
import com.hxc.interView.common.result.ServiceResult;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface UserService {

    ServiceResult getUserByCondition(User user);

    ServiceResult addUser(User user) throws IllegalAccessException;

    ServiceResult login(User user) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException;
}

package com.wy.iocanno.service;

/**
 * @author wy
 */
public interface TransferService {

    void transfer(String fromCardNo,String toCardNo,int money) throws Exception;
}

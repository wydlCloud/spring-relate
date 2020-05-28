package com.wy.springtransfer.service;

/**
 * @author wy
 */
public interface TransferService {

    void transfer(String fromCardNo,String toCardNo,int money) throws Exception;
}

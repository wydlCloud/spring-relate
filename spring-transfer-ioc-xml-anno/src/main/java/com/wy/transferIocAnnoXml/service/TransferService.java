package com.wy.transferIocAnnoXml.service;

/**
 * @author wy
 */
public interface TransferService {

    void transfer(String fromCardNo,String toCardNo,int money) throws Exception;
}

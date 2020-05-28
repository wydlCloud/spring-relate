package com.spring.transferiocxml.dao;

import com.spring.transferiocxml.pojo.Account;

/**
 * @author wy
 */
public interface AccountDao {

    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;
}

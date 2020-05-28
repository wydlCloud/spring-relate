package com.wy.springtransfer.dao;

import com.wy.springtransfer.pojo.Account;

/**
 * @author wy
 */
public interface AccountDao {

    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;
}

package com.wy.iocanno.dao;

import com.wy.iocanno.pojo.Account;

/**
 * @author wy
 */
public interface AccountDao {

    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;
}

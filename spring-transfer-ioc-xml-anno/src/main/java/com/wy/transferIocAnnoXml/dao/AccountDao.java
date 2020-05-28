package com.wy.transferIocAnnoXml.dao;

import com.wy.transferIocAnnoXml.pojo.Account;

/**
 * @author wy
 */
public interface AccountDao {

    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;
}

package com.wy.transferIocAnnoXml.service.impl;

import com.wy.transferIocAnnoXml.dao.AccountDao;
import com.wy.transferIocAnnoXml.pojo.Account;
import com.wy.transferIocAnnoXml.service.TransferService;
import com.wy.transferIocAnnoXml.utils.ConnectionUtils;
import com.wy.transferIocAnnoXml.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



/**
 * @author wy
 */
@Service("transferService")
public class TransferServiceImpl implements TransferService {


    // 最佳状态
    // @Autowired 按照类型注入 ,如果按照类型无法唯一锁定对象，可以结合@Qualifier指定具体的id
    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;




    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

        /*try{
            // 开启事务(关闭事务的自动提交)
            TransactionManager.getInstance().beginTransaction();*/
            System.out.println("执行转账业务逻辑");
            Account from = accountDao.queryAccountByCardNo(fromCardNo);
            Account to = accountDao.queryAccountByCardNo(toCardNo);

            from.setMoney(from.getMoney()-money);
            to.setMoney(to.getMoney()+money);

            accountDao.updateAccountByCardNo(to);
            //int c = 1/0;
            accountDao.updateAccountByCardNo(from);

        /*    // 提交事务

            TransactionManager.getInstance().commit();
        }catch (Exception e) {
            e.printStackTrace();
            // 回滚事务
            TransactionManager.getInstance().rollback();

            // 抛出异常便于上层servlet捕获
            throw e;

        }*/




    }

    @Override
    public void success(String fromCardNo, String toCardNo) {
        System.out.println("success");
    }
}

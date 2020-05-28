package com.spring.transferiocxml.factory;

import com.spring.transferiocxml.pojo.Account;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname CompanyFactoryBean
 *
 * BeanFactory 接口是容器的顶级接口，定义了容器的一些基础行为，负责生产和管理bean的一个工厂，具体使用它下面的子接口类型，
 * eg：ApplicaitonContext： 这里我们分析一下FactoryBean
 * spring中的bean 有两种  一种是普通bean  一种是工厂bean（FactoryBean），Factory可以生成某一个类型的Bean实例（返回给我们），
 * 也就是说我们可以借助于它自定义bean的创建过程
 * Bean创建的三种方式中的静态方法和实例化方法
 *
 *
 * 可以让我们自定义bean的创建过程（完成复杂bean的定义）
 *  * 返回FactoryBean创建的bean实例，如果isSigleton返回teue，则该实例会放到spring容器的单例缓存池map中
 *  @Nullable
 *  T getObject() throws Exception;
 *
 *     @Nullable
 *     返回FactoryBean创建的bean类型
 *     Class<?> getObjectType();
 *是单例还是多例
 *     default boolean isSingleton() {
 *         return true;
 *     }
 * @Description TODO
 */

public class AccountFactoryBean implements FactoryBean<Account> {
//    private String cardNo;
//    private String name;
//    private int money;
    private String accountInfo;

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    @Override
    public Account getObject() throws Exception {
        // 创建复杂对象 Account
        Account account=new Account();
        String[] split = accountInfo.split(",");
        account.setCardNo(split[0]);
        account.setMoney(Integer.parseInt(split[1]));
        account.setName(split[2]);
        return account;
    }

    @Override
    public Class<?> getObjectType() {
        return Account.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

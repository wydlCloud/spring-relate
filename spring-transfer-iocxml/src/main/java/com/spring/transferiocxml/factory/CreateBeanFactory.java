package com.spring.transferiocxml.factory;

import com.spring.transferiocxml.utils.ConnectionUtils;

/**
 * @author wy
 */
public class CreateBeanFactory {



    public static ConnectionUtils getInstanceStatic() {
        return new ConnectionUtils();
    }


    public ConnectionUtils getInstance() {
        return new ConnectionUtils();
    }
}

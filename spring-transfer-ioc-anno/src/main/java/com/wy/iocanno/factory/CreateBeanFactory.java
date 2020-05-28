package com.wy.iocanno.factory;

import com.wy.iocanno.utils.ConnectionUtils;

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

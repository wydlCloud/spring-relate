package com.wy.transferIocAnnoXml.factory;

import com.wy.transferIocAnnoXml.utils.ConnectionUtils;

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

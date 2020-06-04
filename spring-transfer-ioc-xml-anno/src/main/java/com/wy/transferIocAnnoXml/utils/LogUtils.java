package com.wy.transferIocAnnoXml.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author wy
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class LogUtils {

    // 如果想进行接口层的入参和返回参数进行数据拦截的话，可以在此处定义就可以了，以及异常捕获，都可以在此处进行，从我的理解看就是所有的异常也都像上层派出，
    // 在最上层进行异常捕获，这样，就可以拦截到各种操作，比如入参打印，返回参数打印， 异常日志打印，都可以进行全局打印，日常开发只需要关注代码和业务界别
    // 不需要在关心日志和异常的打印，目前浅显的理解是这样的。而且在业务中的业务日志打印当然还是需要做的，在这里可以进行定义，也可以定义业务异常等其他异常
    // 当然通过xml的方式也可以进行配置，在此处进行的话，属于是纯注解的方式来进行的。这是使用的spring提供的aop的功能。
    // 其实自己也可以基于动态代理实现方法的增强，对于service中方法的增强，因为是通过最上层进行调用的，可以生成service的代理类，来进行方法的调用，这个时候，会走
    // 代理类中的方法，进行方法的增强，并且调用原方法，即可，对于最上层的后续还需要加深知识体系的理解，我的理解最上层自己实现的话，需要要依赖于servlet的知识体系
    // 或者这么说需要和spring mvc进行整合，来完成对服务层的实现。
    @Pointcut("execution(* com.wy.transferIocAnnoXml.service.impl.TransferServiceImpl.*(..))")
    public void pt1() {

    }


    /**
     * 业务逻辑开始之前执行
     */
    public void beforeMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            System.out.println(arg);
        }
        System.out.println("业务逻辑开始执行之前执行.......");
    }


    /**
     * 业务逻辑结束时执行（无论异常与否）
     */
    public void afterMethod() {
        System.out.println("业务逻辑结束时执行，无论异常与否都执行.......");
    }


    /**
     * 异常时时执行
     */
    public void exceptionMethod() {
        System.out.println("异常时执行.......");
    }


    /**
     * 业务逻辑正常时执行
     */
    public void successMethod(Object retVal) {
        System.out.println("业务逻辑正常时执行.......");
    }


    /**
     * 环绕通知
     */
    @Around("pt1()")
    public Object arroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知中的beforemethod....");

        Object result = null;
        try {
            // 控制原有业务逻辑是否执行
            // result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Exception e) {
            System.out.println("环绕通知中的exceptionmethod....");
        } finally {
            System.out.println("环绕通知中的after method....");
        }

        return result;
    }

}

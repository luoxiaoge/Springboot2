package com.luoc.AopLog;

import com.luoc.annotation.Auth;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author luoc
 * @date 2018/11/19 0019
 * @Time 10:47
 */
@Aspect
@Configuration
public class AopLog {

     private static final Logger logger = LoggerFactory.getLogger(AopLog.class);


     @Pointcut("@annotation(com.luoc.annotation.Auth)")
     public void aopPoint() {
     }


     @Before("aopPoint()")
     public void doRoute(JoinPoint jp) throws Throwable {
          Method method = getMethod(jp);
          Auth auth = method.getAnnotation(Auth.class);
          boolean isAuth = auth.auth();
          if(isAuth == true){
              logger.info("该用户是否登录:{}",method.getName());
          }
      }


     private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
          Signature sig = jp.getSignature();
          MethodSignature msig = (MethodSignature) sig;
          return getClass(jp).getMethod(msig.getName(), msig.getParameterTypes());
     }


     private Class<? extends Object> getClass(JoinPoint jp)
             throws NoSuchMethodException {
          return jp.getTarget().getClass();
     }



}

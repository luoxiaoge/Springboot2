package com.luoc.shiro.domain.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author luoc
 * @date 2018/11/21 0021
 * @Time 14:48
 */
@Configuration
public class ShiroConfig {

    /**
     *  凭证匹配器
     * @return
     */
     @Bean
     public HashedCredentialsMatcher hashedCredentialsMatcher(){
            HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
            // MD5加密1次
            hashedCredentialsMatcher.setHashAlgorithmName("md5");
            hashedCredentialsMatcher.setHashIterations(1);
            return  hashedCredentialsMatcher;
     }


    /**
     *  自定义realm
     * @return
     */
    @Bean
    public  UserRealm userRealm(){
         UserRealm userRealm = new UserRealm();
         userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
         return userRealm;
     }

    /**
     *  安全管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
          DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
          securityManager.setRealm(userRealm());
          return  securityManager;

     }

    /**
     *  设置过滤规则
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");

        //注意此处使用的是LinkedHashMap，是有顺序的，shiro会按从上到下的顺序匹配验证，匹配了就不再继续验证
        //所以上面的url要苛刻，宽松的url要放在下面，尤其是"/**"要放到最下面，如果放前面的话其后的验证规则就没作用了。
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // anon 表示不过滤这些这些链接
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/captcha.jpg", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
         // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        //authc 表示过其他接口都需要过滤 value 是过滤器的名字 也可以自定义过滤器
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

}

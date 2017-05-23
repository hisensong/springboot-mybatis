package cn.no7player;

import cn.no7player.service.RetryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2017/5/23 17:19
 */
@Configuration
@EnableRetry
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RetryServiceMain {
    @Bean
    public RetryService retryService(){
        return new RetryService();
    }
    public static void main(String[] args) throws Exception{
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RetryServiceMain.class);
        final RetryService retryService = applicationContext.getBean(RetryService.class);
        retryService.retryTest();
    }

}

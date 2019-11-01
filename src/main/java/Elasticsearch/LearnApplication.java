package Elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 1.spring boot 默认支持两种技术和es交互
 *    Jest(默认不生效，需要导入io.searchbox.client.JestClient包)
 *    SpringData ElasticSearch
 *          1. Client  ClusterNodes ClusterName
 *          2. ElasticSearchTemplate 操作es
 *
 *          3. ！！！ElasticSearch 7.0版本后一个索引只允许一个type！！！
 *
 * 2.异步任务测试 YibuService
 *    1. 主类添加@EnableAsync
 *    2. 在要使用异步的方法上添加@Async   //标注为异步方法，异步执行，不会等待
 *
 * 3.定时任务 ScheduledService
 *    1. 主类添加 @EnableScheduling
 *    2. 要使用异步任务的方法上添加@Scheduled
 *    3. cron定时表达式
 *
 * 4.邮件任务
 */
@EnableScheduling  //开启定时任务
@EnableAsync       //开启异步任务
@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}

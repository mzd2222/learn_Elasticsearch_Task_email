package Elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.spring boot 默认支持两种技术和es交互
 *    Jest(默认不生效，需要导入io.searchbox.client.JestClient包)
 *    SpringData ElasticSearch
 *          1. Client  ClusterNodes ClusterName
 *          2. ElasticSearchTemplate 操作es
 *
 *
 */

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}

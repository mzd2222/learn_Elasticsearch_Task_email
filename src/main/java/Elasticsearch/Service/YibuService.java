package Elasticsearch.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//异步任务测试
@Service
public class YibuService {

    @Async   //标注为异步方法，异步执行，不会等待
    public void hello(){
        try {
            Thread.sleep(3000);  //睡觉3s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("处理数据中...");

    }

}

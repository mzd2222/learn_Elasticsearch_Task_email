package Elasticsearch.Controller;

//测试异步同步

import Elasticsearch.Service.YibuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AsyncController {

    @Autowired
    YibuService yibuService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        yibuService.hello();
        return "asd";
    }

}

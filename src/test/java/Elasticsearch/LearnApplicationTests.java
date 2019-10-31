package Elasticsearch;

import Elasticsearch.Bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class LearnApplicationTests {

    @Autowired
    JestClient jestClient;

    //给es中保存索引
    @Test
    void contextLoads() {

        Article article = new Article();
        article.setId(1);
        article.setAuthor("mzd");
        article.setTitle("test ar");
        article.setContent("aa asd sds asf ward");
        //构建一个索引
        Index index = new Index.Builder(article).index("article").type("news").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试搜索   全文搜索

    @Test
    void search(){
        //创建搜索表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"title\" : \"test ar\"\n" +
                "        }\n" +
                "    }\n" +
                "}\n";

        //构建搜索操作
        Search build = new Search.Builder(json).addIndex("article").addType("news").build();

        try {
            SearchResult searchResult =  jestClient.execute(build);
            System.out.println(searchResult.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

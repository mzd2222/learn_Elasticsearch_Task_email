package Elasticsearch;

import Elasticsearch.Bean.Article;
import Elasticsearch.Bean.Book;
import Elasticsearch.Repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class LearnApplicationTests {

    /*    测试testBookRepository     */

    @Autowired
    BookRepository bookRepository;

    //testBookRepository
    @Test
    void testBookRepository(){
        Book book = new Book();
        book.setId(2);
        book.setAuthor("mzd2");
        book.setName("jia");
//        bookRepository.save(book);
        bookRepository.index(book);
    }

    //测试模糊查询
    @Test
    void test22(){
        List<Book> jia_li = bookRepository.findBookByNameLike("jia");
        for (Book a:jia_li) {
            System.out.println(a);
        }
    }



/*    测试jest *************        */

    @Autowired
    JestClient jestClient;

    //用jest给es中保存索引
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


/*  *******************  测试邮箱******          */
//测试邮箱

    @Autowired
    JavaMailSender javaMailSender;

//    简单邮件
    @Test
    void testMail(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("这是标题");
        mailMessage.setText("这首邮件内容");

        mailMessage.setTo("496190329@qq.com");
        mailMessage.setFrom("2659277880@qq.com");

        javaMailSender.send(mailMessage);
    }

//    复杂邮件
    @Test
    void testMail2() throws MessagingException {
        //创建复杂消息邮件
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject("这是标题");
        helper.setText("<h1 style='color:red'>今天 七点 开年级会</h1>",true);

        helper.setTo("496190329@qq.com");
        helper.setFrom("2659277880@qq.com");

        //上传文件
        helper.addAttachment("pom.xml",new File("pom.xml"));
        helper.addAttachment(".gitignore",new File(".gitignore"));

        javaMailSender.send(message);

    }

}

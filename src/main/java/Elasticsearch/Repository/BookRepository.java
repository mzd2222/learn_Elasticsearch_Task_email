package Elasticsearch.Repository;

import Elasticsearch.Bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

//spring-data的实现参考官网
//ElasticSearch操作ES
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    public List<Book> findBookByNameLike(String bookName);//模糊查询

}

package com.app.data;

import com.alibaba.fastjson.JSON;
import com.app.core.BaseTestCase;
import com.app.data.mongo.document.Book;
import com.app.data.mongo.repository.BookRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 */
public class TestMongo extends BaseTestCase {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void test() {
        // bookDao.deleteAll();

//        Book book1 = new Book("ggdj", "918293819283", "shenzhen");
//        Book book2 = new Book("jack", "123", "beijing");
//        Book book3 = new Book("andy", "123", "hubei");

//        bookRepository.insert(book1);
        // bookRepository.insert(book2);
        // bookRepository.insert(book3);

//        List<Book> books = new ArrayList<>();
//        books.add(book1);
//        books.add(book2);
//        books.add(book3);
//
//        bookRepository.insert(books);

        // bookDao.insert();

        List<Book> books = bookRepository.findAll();
        System.out.println(JSON.toJSONString(books));

        // Example<Book> example = Example.of(book1);
        // Book bookTemp = bookDao.findOne(example);

        // System.out.println("================================================");
        // System.out.println(JSON.toJSONString(bookTemp));
        // System.out.println("================================================");
        //
        // bookTemp.setPwd("918293819283");
        // bookTemp.setName("ggdj");
        //
        // bookTemp = bookDao.save(bookTemp);
        // ObjectId objectId = new ObjectId();


        // System.out.println("================================================");
        // System.out.println(JSON.toJSONString(bookTemp));
        // System.out.println(objectId.toString());
        // System.out.println(objectId.toHexString());
        // System.out.println("================================================");

        // bookDao.save();
    }

}
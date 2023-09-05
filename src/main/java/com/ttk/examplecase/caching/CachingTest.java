package com.ttk.examplecase.caching;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CachingTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CachingConfig.class);
        ctx.refresh();
        Book book = ctx.getBean(Book.class);

        System.out.println(book.getCachedData("1"));
        System.out.println();

        System.out.println(book.getCachedData("2"));
        System.out.println();

        book.updateCachedData("1", "Book 3");
        System.out.println();

        book.updateCachedData("2", "Book 4");
        System.out.println();

        System.out.println(book.getCachedData("1"));
        System.out.println();

        System.out.println(book.getCachedData("2"));
        System.out.println();

        book.removeCachedData("1");

        System.out.println(book.getCachedData("1"));
        System.out.println();

        System.out.println(book.getCachedData("2"));
        System.out.println();

        ctx.close();
    }

}
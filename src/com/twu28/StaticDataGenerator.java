package com.twu28;

import java.util.*;

public class StaticDataGenerator {
    List bookList;
    Map userList;
    public StaticDataGenerator(){
        bookList = new ArrayList();
        userList = new HashMap();
        generateBooks();
        generateUsers();
    }

    private void generateUsers() {
        userList.put("u0001",new User("u0001","Arun"));
        userList.put("u0002", new User("u0002", "Silvio"));
        userList.put("u0003", new User("u0003", "Joseph"));
        userList.put("u0004", new User("u0004", "Martin"));
        userList.put("u0005", new User("u0005", "Thomas"));
    }

    private void generateBooks() {
        bookList.add(new Book(1,"Head First Java","Kathy Sierra","O'Reilly Publications",2010, 1234567890L,20.00));
        bookList.add(new Book(1,"Head First Design Patterns","Kathy Sierra","O'Reilly Publications",2010, 1234567891L,25.00));
        bookList.add(new Book(1,"Head First OOAD","Gary Pollice","O'Reilly Publications",2010, 1234567893L,20.00));
        bookList.add(new Book(1,"Java2 Complete Reference","Herbert Schildt","TMH Publications",2011, 1234567892L,21.00));
        bookList.add(new Book(1,"Let Us C","Yashavant kanetkar","GPB Publications",2009, 1234567894L,20.00));
        bookList.add(new Book(1,"Programming in ANSI C","Balagurusamy E","TMH Publications",2003, 1234567895L,20.00));
        bookList.add(new Book(1,"Let Us C++","Yashavant Kanetkar","GPB Publications",2010, 1234567896L,20.00));
        bookList.add(new Book(1,"Clean Code: A Handbook of Agile Software Craftsmanship","Robert C Martin","Prentice Hall Publications",2010, 1234567897L,20.00));
        bookList.add(new Book(1,"Art of Living","Osho","Ram Publications",2010, 1234567898L,20.00));
        bookList.add(new Book(1,"Core Java","Cav S Hostmann","Sun Publications",2012, 1234567899L,50.00));
    }
    public List getBookList() {
        return bookList;
    }

    public Map getUserList() {
        return userList;
    }
}

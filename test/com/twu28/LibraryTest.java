package com.twu28;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest extends junit.framework.TestCase {
    Library library;
    List bookList;
    LibraryTest(){
        library =  new Library();
        //bookList = new ArrayList();
        StaticDataGenerator generator = new StaticDataGenerator();
        bookList = generator.getBookList();
    }
    @Test
    public void should8mustbeInsideTheBoundof1to10(){
        assertTrue(library.isInsideTheBounds(8));
    }
    @Test
    public void should12mustbeOutsideTheBoundsof1to10(){
        assertTrue(library.isInsideTheBounds(12));
    }
    @Test
    public void shouldHeadFirstMatchesWithBookTitle(){
        assertTrue(library.doesSearchStringMatchWithTitle((Book)bookList.get(1),"Head First"));
    }
}

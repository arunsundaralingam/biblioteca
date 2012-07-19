package com.twu28;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest {
    Library library;
    List bookList;
    public LibraryTest(){
        library =  new Library();
        //bookList = new ArrayList();
        StaticDataGenerator generator = new StaticDataGenerator();
        bookList = generator.getBookList();
    }
    @Test
    public void should8mustbeInsideTheBoundof1to10(){
        assertTrue(library.isBookInsideTheBounds(8));
    }
    @Test
    public void should12mustbeOutsideTheBoundsof1to10(){
        assertFalse(library.isBookInsideTheBounds(12));
    }
    @Test
    public void shouldGetStartIndexOfBooksReturn1(){
        assertEquals(1,library.getStartIndexOfBooks());
    }
    @Test
    public void shouldGetStartIndexOfMoviesReturn1(){
        assertEquals(library.getStartIndexOfMovies(), 1);
    }
    @Test
    public void shouldReturnMinusOneForInvalidUserID(){
        assertEquals(-1,library.getUserIndexFromID(""));
    }
    @Test
    public void shouldReturnFalseForIsUserHasLoggedInMethod(){
        assertFalse(library.isUserHasLoggedIn());
    }
}

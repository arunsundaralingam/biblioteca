package com.twu28;

import org.junit.Test;

public class LibraryTest extends junit.framework.TestCase {
    Library library;
    LibraryTest(){
        library =  new Library();
    }
    @Test
    public void shouldReturnFalseWhenInvalidIdHasGiven(){
        assertEquals(false , library.doesUserIdExist("u888888"));
    }
    @Test
    public void shouldReturnTrueWhenValidIdHasGiven(){
        assertEquals(true,library.doesUserIdExist("u0001"));
    }
    @Test
    public void shouldReturnUserName(){
        assertEquals("Arun",library.getUserName("u0001"));

    }

}

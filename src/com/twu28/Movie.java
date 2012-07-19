package com.twu28;

public class Movie {
    String movieName;
    String directorName;
    String rating;
    public Movie(String movieName , String directorName , String rating){
        this.movieName = movieName;
        this.directorName = directorName;
        this.rating = rating;
    }
    public String toString(){
        return movieName+"\t"+directorName+"\t"+rating;
    }
}

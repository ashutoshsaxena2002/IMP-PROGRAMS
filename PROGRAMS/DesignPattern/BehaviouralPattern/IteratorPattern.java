package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;


// This provides the way of accessing elements sequentially without exposing the
// underlying representation of collection

// In simple language we need to provide object or class implementation
// through which we can access object or class list


// now suppose we have below list for Books and Students in Library
// Here Books and Students are entities and Library is aggregator
// We need to defined Student and Books class and we will be accessing those list
// from Library class which is aggregator class so we need to provide implementation to access student and book list

import java.util.List;

// Entity 1
class Student{
    private Integer rollNo;
    private String name;

    public  Student(Integer rollNo, String name){
        this.rollNo=rollNo;
        this.name=name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }
}

// Entity2
class Book{
    private Integer serialNo;
    private String name;

    public  Book(Integer serialNo, String name){
        this.serialNo=serialNo;
        this.name=name;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public String getName() {
        return name;
    }
}

// Below is implementation of student and book list iterator
interface Iterator<T>{
    Boolean hasNext();
    T next();
}
class BookIterator implements Iterator<Book>{

    private List<Book> books;
    private  Integer index=0;

    public  BookIterator(List<Book> books){
        this.books=books;
    }

    @Override
    public Boolean hasNext() {
        return index < books.size();
    }

    @Override
    public Book next() {
        if(this.hasNext()){
            return books.get(index++);
        }
        return  null;
    }
}
class StudentIterator implements Iterator<Student>{

    private List<Student> students;
    private  Integer index=0;

    public  StudentIterator(List<Student> students){
        this.students=students;
    }

    @Override
    public Boolean hasNext() {
        return index < students.size();
    }

    @Override
    public Student next() {
        if(this.hasNext()){
            return students.get(index++);
        }
        return  null;
    }
}
// Above is implementation of student and book list iterator

// Aggregator class
class Library{
    private List<Book> books;
    private List<Student> students;
    public Library(List<Book> books, List<Student> students){
        this.books=books;
        this.students=students;
    }

    // This methods provide iterator object for book list through which we can traverse the list of book
    public BookIterator getBookIterator(){
        return  new BookIterator(this.books);
    }

    // This methods provide iterator object for student list through which we can traverse the list of student
    public  StudentIterator getStudentIterator(){
        return  new StudentIterator(this.students);
    }
}


public class IteratorPattern {
    public  static  void main (String [] args){
        List<Book> books = List.of(new Book(1,"BOOK1"),new Book(2,"BOOK2"));
        List<Student> students = List.of(new Student(43,"STUDENT1"),new Student(56,"STUDENT2"));

        Library library = new Library(books, students);

        StudentIterator studentIterator=library.getStudentIterator();
        BookIterator bookIterator=library.getBookIterator();


        while(studentIterator.hasNext()){
            Student student=studentIterator.next();
            System.out.println(student.getRollNo()+"::"+student.getName());
        }

        System.out.println("____________________________________________");

        while(bookIterator.hasNext()){
            Book book=bookIterator.next();
            System.out.println(book.getSerialNo()+"::"+book.getName());
        }
    }
}

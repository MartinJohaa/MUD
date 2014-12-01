package com.ioopm;

import junit.framework.TestCase;

public class StudentTest extends TestCase {

    Room testRoom = new Room("testRoom", "N", "E", "S", "W",
            "X", "X", "X", "X");
    Student testStudent = new Student("testStudent", "testRoom");
    Book testBook = new Book("testBook", "testAuthor", 2222, 10);
    Book testBook2 = new Book("testBook2", "testAuthor2", 3333, 10);
    Course testCourse = new Course("testCourse", testBook, 10);

    public void testTalk() throws Exception {
        testStudent.setCourse(testCourse);
        testStudent.setCourseBook(testBook);
        //How to test system.out??
        }

    public void testWhichKindOfCreature() throws Exception {
        assertEquals(1, testStudent.whichKindOfCreature());
    }

    public void testTrade() throws Exception {
        testStudent.setCourseBook(testBook);
        assertEquals(testBook, testStudent.trade(testBook2));
    }
}
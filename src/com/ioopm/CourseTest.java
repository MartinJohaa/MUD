package com.ioopm;

import junit.framework.TestCase;

public class CourseTest extends TestCase {
    Avatar testAvatar = new Avatar("testAvatar");
    Course testCourse = new Course("testCourse", new Book ("testBook", "testAutor",2222,2), 10);

    public void testQuestion() throws Exception {
        //Klura ut ett sett att testa user-input!!
    }
}
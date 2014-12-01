package com.ioopm;

import junit.framework.TestCase;
import org.junit.Test;

public class AvatarTest extends TestCase {

    Avatar testAvatar = new Avatar("testAvatar");
    Book testBook = new Book("testCourseLiterature","testAuthor",2222,2);
    Course testCourse = new Course("testCourse",testBook,10);

    @Test
    public void testAddFinishedCourse() throws Exception {
        testAvatar.addFinishedCourse("testCourse");
        assertEquals(true, testAvatar.searchFinishedCourses("testCourse"));
    }

    public void testAddUnfinishedCourse() throws Exception {
        testAvatar.addUnfinishedCourse("testCourse");
        assertEquals(true,testAvatar.searchUnfinishedCourses("testCourse"));
    }

    public void testRemoveFinishedCourse() throws Exception {
        testAvatar.removeFinishedCourse("testCourse");
        assertEquals(false,testAvatar.searchFinishedCourses("testCourse"));
    }

    public void testSearchUnfinishedCourses() throws Exception {
        assertEquals(true,testAvatar.searchUnfinishedCourses("testCourse"));
    }

    public void testSearchFinishedCourses() throws Exception {
        assertEquals(false,testAvatar.searchFinishedCourses("testCourse"));
    }

    public void testAddItemToInventory() throws Exception {
        Key testKey = new Key();
        testAvatar.addItemToInventory(testKey);
        testAvatar.addItemToInventory(testBook);
        assertEquals(true, testAvatar.checkForLiterature("testCourseLiterature"));
        assertEquals(true, );

    }

    public void testRemoveItemFromInventory() throws Exception {

    }

    public void testUpdateHP() throws Exception {

    }

    public void testPrintCurrentLocation() throws Exception {

    }

    public void testPickupItem() throws Exception {

    }

    public void testDropItem() throws Exception {

    }

    public void testPrintInventory() throws Exception {

    }

    public void testCheckForKeyAndRemove() throws Exception {

    }

    public void testFindItemIndex() throws Exception {

    }

    public void testCheckForLiterature() throws Exception {

    }
}
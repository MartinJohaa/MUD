package com.ioopm;

import junit.framework.TestCase;
import org.junit.Test;

public class AvatarTest extends TestCase {

    Avatar testAvatar = new Avatar("testAvatar");
    Book testBook = new Book("testCourseLiterature","testAuthor",2222,2);
    Book testBookTwo = new Book("testCourseLiteratureTwo","testAuthorTwo",3333,3);
    Course testCourse = new Course("testCourse",testBook,10);

    @Test
    public void testAddFinishedCourse() throws Exception {
        testAvatar.addFinishedCourse("testCourse");
        assertEquals(true, testAvatar.searchFinishedCourses("testCourse"));
    }

    @Test
    public void testAddUnfinishedCourse() throws Exception {
        testAvatar.addUnfinishedCourse("testCourse");
        assertEquals(true,testAvatar.searchUnfinishedCourses("testCourse"));
    }

    @Test
    public void testRemoveFinishedCourse() throws Exception {
        testAvatar.removeFinishedCourse("testCourse");
        assertEquals(false,testAvatar.searchFinishedCourses("testCourse"));
    }

    @Test
    public void testSearchUnfinishedCourses() throws Exception {
        testAvatar.addUnfinishedCourse("testCourse");
        assertEquals(true,testAvatar.searchUnfinishedCourses("testCourse"));
    }

    @Test
    public void testSearchFinishedCourses() throws Exception {
        assertEquals(false,testAvatar.searchFinishedCourses("testCourse"));
    }

    @Test
    public void testAddItemToInventory() throws Exception {
        Key testKey = new Key();
        testAvatar.addItemToInventory(testKey);
        testAvatar.addItemToInventory(testBook);
        assertEquals(true, testAvatar.checkForLiterature("testCourseLiterature"));
        assertEquals(true, testAvatar.getItemList().contains(testKey));
        assertEquals(true, testAvatar.getItemList().contains(testBook));
    }

    @Test
    public void testRemoveItemFromInventory() throws Exception {
        testAvatar.addItemToInventory(testBook);
        testAvatar.removeItemFromInventory(0);
        assertEquals(false,testAvatar.getItemList().contains(testBook));
    }

    @Test
    public void testUpdateHP() throws Exception {
        testAvatar.updateHP(50);
        assertEquals(true, testAvatar.getHP() == 110);
    }

    @Test
    public void testCheckForKeyAndRemove() throws Exception {
        Key testKeyTwo = new Key();
        testAvatar.addItemToInventory(testKeyTwo);
        testAvatar.addItemToInventory(testBook);
        int lengthOfItemListBeforeTest = testAvatar.getItemList().size();
        testAvatar.checkForKeyAndRemove();
        assertEquals(false,lengthOfItemListBeforeTest==testAvatar.getItemList().size());
    }

    @Test
    public void testFindItemIndex() throws Exception {
        testAvatar.addItemToInventory(testBookTwo);
        testAvatar.printInventory();
        int testInt = testAvatar.findItemIndex("testcourseliteraturetwo");
        assertEquals(true, testInt>=0);
    }

    @Test
    public void testCheckForLiterature() throws Exception {
        testAvatar.addItemToInventory(testBookTwo);
        assertEquals(true,testAvatar.checkForLiterature("testCourseLiteratureTwo"));
    }
}
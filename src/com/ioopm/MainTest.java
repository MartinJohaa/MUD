package com.ioopm;

import junit.framework.*;
import org.junit.Test;

public class MainTest extends TestCase {

    @Test
    public void testGetSphinxRoomIndex() throws Exception {
        int indexNum = 5;
        int[] roomIndexArray = {1, 2, 3, 4, 5, 6};
        assertEquals(Main.getSphinxRoomIndex(indexNum, roomIndexArray), 6);
    }

    @Test
    public void testFindIndex() throws Exception {
        String stringToBeFoundOne = "testString";
        String stringToBeFoundTwo = "teststring";
        String[] stringArray = {"hello", "world", "teststring", "testString"};
        assertEquals(Main.findIndex(stringToBeFoundOne, stringArray), 3);
        assertEquals(Main.findIndex(stringToBeFoundTwo, stringArray), 2);
    }
}
    /*

    public void testPlaceKeys() throws Exception {
        Room[] testRooms = {new Room()};

    }

    public void testPlaceBooks() throws Exception {

    }

    public void testMove() throws Exception {

    }

    public void testUnlockDoor() throws Exception {

    }
}*/
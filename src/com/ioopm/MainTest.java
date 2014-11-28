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
/*
    public void testPlaceKeys() throws Exception {
        Avatar testAvatar = new Avatar("TestAvatar");
        Room[] testRooms = {new Room("1","N1","E1","S1","W1","LN1","LE1","LS1","LW1"),new Room("2","N2","E2","S2","W2","LN2","LE2","LS2","LW2"),
                new Room("3","N3","E3","S3","W3","LN3","LE3","LS3","LW3"),new Room("4","N4","E4","S4","W4","LN4","LE4","LS4","LW4"),
                new Room("5","N5","E5","S5","W5","LN5","LE5","LS5","LW5"),};
        assertEquals(Main.placeKeys(testRooms,testAvatar),);

    }

    public void testPlaceBooks() throws Exception {

    }
*/
    @Test
    public void testMove() throws Exception {

    }

    @Test
    public void testUnlockDoor() throws Exception {

    }
}
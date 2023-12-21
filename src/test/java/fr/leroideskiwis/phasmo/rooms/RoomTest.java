package fr.leroideskiwis.phasmo.rooms;

import fr.leroideskiwis.phasmo.Entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room room;

    @BeforeEach
    void setUp() {
        this.room = new Room(20, 10);
    }

    @Test
    void testAddEntity() {
        Entity entity = new Entity();
        room.addEntity(0, 0, entity);
        assertTrue(room.isEntityAt(0, 0, entity));
    }

    @Test
    void testAddEntityOutOfBound(){
        Entity entity = new Entity();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> room.addEntity(10, 10, entity), "is out of bound");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> room.addEntity(0, -1, entity), "is negative");
    }

    @Test
    void testMoveEntity() {
        Entity entity = new Entity();
        room.addEntity(0, 0, entity);
        room.moveEntity(0, 0, 1, 1);
        assertTrue(room.isEntityAt(1, 1, entity));
        assertFalse(room.isEntityAt(0, 0, entity));
    }

    @Test
    void testMoveEntityIfCan() {
        Entity entity = new Entity();
        room.addEntity(0, 0, entity);
        assertTrue(room.moveEntityIfCan(0, 0, 1, 1));
        assertFalse(room.isEntityAt(0, 0, entity));
        assertTrue(room.isEntityAt(1, 1, entity));
        assertFalse(room.moveEntityIfCan(0, 0, 1, 1));
        assertFalse(room.isEntityAt(0, 0, entity));
        assertTrue(room.isEntityAt(1, 1, entity));
    }

    @Test
    void testIsEntityAt() {
        Entity entity = new Entity();
        room.addEntity(0, 0, entity);
        assertTrue(room.isEntityAt(0, 0, entity));
        assertFalse(room.isEntityAt(1, 1, entity));
    }

    @Test
    void testIsEntityAtOutOfBound() {
        Entity entity = new Entity();
        room.addEntity(0, 0, entity);
        assertFalse(room.isEntityAt(10, 10, entity), "is out of bound");
        assertFalse(room.isEntityAt(-1, 0, entity), "is negative");
    }
}
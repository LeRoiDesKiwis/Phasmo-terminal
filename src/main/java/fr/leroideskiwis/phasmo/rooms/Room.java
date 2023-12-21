package fr.leroideskiwis.phasmo.rooms;

import fr.leroideskiwis.phasmo.Entity;
import fr.leroideskiwis.phasmo.items.Showable;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private int temperature;
    private List<Entity> showables;
    private int size;

    public Room(int temperature, int size, Entity... showables) {
        this.temperature = temperature;
        this.showables = List.of(showables);
        this.size = size;
    }

    public Room(int size, Entity... showables){
        this(20, size, showables);
    }

    public Room(Entity... showables){
        this(10, showables);
    }

    public Room(){
        this(new Entity[]{});
    }

    public void show(){
        showables.forEach(Entity::show);
    }
}

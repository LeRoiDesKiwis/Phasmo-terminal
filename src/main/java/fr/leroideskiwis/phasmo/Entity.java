package fr.leroideskiwis.phasmo;

import fr.leroideskiwis.phasmo.items.Showable;
import fr.leroideskiwis.phasmo.rooms.Room;

public class Entity implements Showable {

    private Location location;

    public Entity(Location location) {
        this.location = location;
    }

    @Override
    public boolean canBeShow() {
        return true;
    }

    @Override
    public void show() {

    }
}

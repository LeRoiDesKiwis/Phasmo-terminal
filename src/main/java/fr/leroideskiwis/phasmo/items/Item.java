package fr.leroideskiwis.phasmo.items;

import fr.leroideskiwis.phasmo.Entity;
import fr.leroideskiwis.phasmo.Location;

import java.util.List;

public class Item extends Entity {

    private int count;

    public Item(Location location) {
        super(location);
    }

    public void stack(List<Item> items){
        items.stream().filter(item -> item.getClass().equals(getClass())).forEach(item -> {
            this.count += item.count;
            item.count = 0;
        });
    }

    @Override
    public boolean canBeShow() {
        return true;
    }

    @Override
    public void show() {
        System.out.printf("- %s (x%d)", getClass().getSimpleName().toLowerCase(), count);
    }
}

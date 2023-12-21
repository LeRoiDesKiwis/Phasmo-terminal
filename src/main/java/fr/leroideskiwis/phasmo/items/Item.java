package fr.leroideskiwis.phasmo.items;

import fr.leroideskiwis.phasmo.Entity;

import java.util.List;

public class Item extends Entity {

    private int count;

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

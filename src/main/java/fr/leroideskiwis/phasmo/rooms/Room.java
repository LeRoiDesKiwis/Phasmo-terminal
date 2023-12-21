package fr.leroideskiwis.phasmo.rooms;

import fr.leroideskiwis.phasmo.Entity;

public class Room {

    private int temperature;
    private final Entity[][] entities;
    private final int size;

    public Room(int temperature, int size, Entity[][] entities) {
        this.temperature = temperature;
        this.entities = entities;
        this.size = size;
    }

    public Room(int temperature, int size) {
        this(temperature, size, new Entity[size][size]);
    }

    public Room(int size){
        this(20, size);
    }

    public Room(){
        this(10);
    }

    public void addEntity(int x, int y, Entity entity){
        entities[x][y] = entity;
    }

    public void moveEntity(int x, int y, int x1, int y1){
        entities[x1][y1] = entities[x][y];
        entities[x][y] = null;
    }

    /** move entity but check if the entity can be moved
     * @param x the x position of the entity
     * @param y the y position of the entity
     * @param x1 the x position of the entity after the move
     * @param y1 the y position of the entity after the move
     * @return true if the entity can be moved and false if not
     */
    public boolean moveEntityIfCan(int x, int y, int x1, int y1){
        if(entities[x1][y1] == null) {
            moveEntity(x, y, x1, y1);
            return true;
        }
        return false;
    }

    public boolean isEntityAt(int x, int y, Entity entity){
        return x >= 0 &&
                y >= 0 &&
                x < size &&
                y < size &&
                entities[x][y] != null &&
                entities[x][y].equals(entity);
    }

    public void show(){
        for (Entity[] entity : entities) {
            for (Entity entity1 : entity) {
                if(entity1.canBeShow()) entity1.show();
            }
        }
    }
}

package org.g70.controller.level.movement;

import org.g70.model.Position;
import org.g70.model.drawable.element.ElementModel;

public abstract class Movement {
    private ElementModel element;
    private int x;
    private int y;

    public Movement(ElementModel element) {
        this.element = element;
    }

    public Position getPosition() {
        return element.getPosition();
    }

    public int lastDisplacementX() {
        return x;
    }

    public int lastDisplacementY() {
        return y;
    }

    public Position moveDisplacement(int x, int y) {
        return new Position(element.getPosition().getX() + x, element.getPosition().getY() + y);
    }

    public Position moveUp() {
        x = 0;
        y = -1;
        return new Position(element.getPosition().getX(), element.getPosition().getY() - 1);
    }

    public Position moveDown() {
        x = 0;
        y = 1;
        return new Position(element.getPosition().getX(), element.getPosition().getY() + 1);
    }

    public Position moveRight() {
        x = 1;
        y = 0;
        return new Position(element.getPosition().getX() + 1, element.getPosition().getY());
    }

    public Position moveLeft() {
        x = -1;
        y = 0;
        return new Position(element.getPosition().getX() - 1, element.getPosition().getY());
    }
}
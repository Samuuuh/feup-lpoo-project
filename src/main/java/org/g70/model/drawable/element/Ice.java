package org.g70.model.drawable.element;

import org.g70.controller.level.interact.InteractIce;
import org.g70.model.Position;

public class Ice extends ElementModel {
    public Ice(Position position) {
        super(" ","#8dc5f0",position);

        setInteraction(new InteractIce(this));
    }
}
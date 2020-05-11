package model.drawable.element;

import controller.interact.InteractToughIce;
import model.Position;

public class ToughIce extends ElementModel {
    public ToughIce(Position position) {
        super("\u2588", "#ffffff", position);

        this.setInteraction(new InteractToughIce(this));
    }
}

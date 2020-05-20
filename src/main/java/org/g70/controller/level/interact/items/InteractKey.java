package org.g70.controller.level.interact.items;

import org.g70.controller.level.interact.Interact;
import org.g70.controller.level.LevelController;
import org.g70.controller.level.LevelFacade;
import org.g70.controller.level.strategy.StrategyRegular;
import org.g70.model.drawable.element.Key;

public class InteractKey extends Interact<Key> {

    public InteractKey(Key element) {
        super(element);
    }

    @Override
    public void execute(LevelController controller, LevelFacade facade) {
        facade.meltPreviousIce();

        facade.move(position);
        controller.addScore(1,1);

        facade.removeKeyLock();

        facade.setStrategy(new StrategyRegular(facade));
    }

    @Override
    public void executeBox(LevelFacade facade) {
        System.out.println("Found InteractKey");
        facade.makeBoxMove(position);
    }
}

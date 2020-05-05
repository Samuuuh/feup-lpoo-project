package Controller.Interact;

import Controller.Element.HeroMovement;
import Model.Elements.ElementModel;
import Model.Elements.Hero;
import Model.Elements.Key;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractKey extends CommandInteract {

    public CommandInteractKey(LevelModel m,Key element, Position editor) {
        super(m,element,editor);
    }

    @Override
    public void execute() {
        m.removeKeyLock();
        m.addWater();
        m.addPoints(1);
    }
}

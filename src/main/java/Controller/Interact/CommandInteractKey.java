package Controller.Interact;

import Controller.Element.HeroMovement;
import Model.Elements.ElementModel;
import Model.Elements.Hero;
import Model.Elements.Key;
import Model.Level.LevelModel;
import Model.Position;

public class CommandInteractKey extends CommandInteract {

    public CommandInteractKey(Key element, Editor editor) {
        super(element,editor);
    }

    @Override
    public void execute() {
        editor.removeKeyLock();
        editor.addWater();
        editor.addPoints(1);
    }
}

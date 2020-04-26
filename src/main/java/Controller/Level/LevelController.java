package Controller.Level;

import Model.Elements.Water;
import Model.Elements.Wall;
import Model.Level.LevelModel;
import Model.Position;
import View.Level.LevelView;

import java.io.IOException;
import java.util.logging.Level;

public class LevelController {
    private LevelModel levelModel;
    private LevelView levelView;

    public LevelController(LevelModel levelModel, LevelView levelView){
        this.levelModel = levelModel;
        this.levelView = levelView;
    }

    private boolean checkCollisions(Position position) {
        for (Wall wall : levelModel.getWalls()){
            if (wall.getPosition().equals(position))
                return true;
        }
        for (Water water : levelModel.getFilled()){
            if (water.getPosition().equals(position))
                return true;
        }
        return levelModel.getLock() != null && levelModel.getLock().getPosition().equals(position);
    }

    public boolean canHeroMove(Position position) {
        if (checkCollisions(position)) return false;
        if (levelModel.removeCoin(position)){
            levelModel.addPoints(10);
            return true;
        }
        if(levelModel.getKey() != null && levelModel.getKey().getPosition().equals(position)){
            levelModel.setKey(null);
            levelModel.setLock(null);
        }

        levelModel.addPoints(1);
        return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)){
            if(!levelModel.removeWhite(levelModel.getHero().getPosition()))
                levelModel.getFilled().add(new Water(levelModel.getHero().getPosition()));
            levelModel.getHero().setPosition(position);
        }
    }

    public boolean gameWon() {
        return levelModel.getHero().getPosition().equals(levelModel.getDestination().getPosition());
    }

    public boolean gameLost() {
        return (checkCollisions(levelModel.getHero().moveUp()) && checkCollisions(levelModel.getHero().moveDown()) &&
                checkCollisions(levelModel.getHero().moveLeft()) && checkCollisions(levelModel.getHero().moveRight()));
    }

    public void setLevel(LevelModel levelModel) {
        this.levelModel = levelModel;
    }

    public void run() throws IOException {
        do {
            if(!processCommand(levelView.processKey())) break;

            if(gameWon()){
                int levelNumber = levelModel.getLevelInitializer().getLevelNumber();
                if(levelNumber != 15){
                    setLevel(new LevelModel(++levelNumber));
                }
                else{
                    break;
                }
            }
            if(gameLost()) break;
            levelView.draw(levelModel);
        } while (true);
    }

    public boolean processCommand(LevelView.DIRECTION command) {
        switch (command) {
            case UP:
                moveHero(levelModel.getHero().moveUp());
                return true;
            case DOWN:
                moveHero(levelModel.getHero().moveDown());
                return true;
            case LEFT:
                moveHero(levelModel.getHero().moveLeft());
                return true;
            case RIGHT:
                moveHero(levelModel.getHero().moveRight());
                return true;
            case CLOSE:
                return false;
        }
        return false;
    }
}

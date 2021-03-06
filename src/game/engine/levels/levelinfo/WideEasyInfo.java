package game.engine.levels.levelinfo;

import game.engine.actors.Block;
import game.engine.actors.Velocity;
import game.engine.actors.sprites.Sprite;
import game.ui.backgrounds.WideEasyBackground;
import game.ui.shapes.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Wide easy info.
 */
public class WideEasyInfo implements LevelInformation {
    private static final int GUI_HEIGHT = 600;
    private static final int GUI_WIDTH = 800;
    private final int numberOfBalls;
    private final List<Velocity> initialBallVelocities = new ArrayList<>();
    private final int paddleSpeed;
    private final int paddleWidth;
    private final String levelName;
    private final Sprite background;
    private final List<Block> blocks = new ArrayList<>();
    private final int numberOfBlocksToRemove;


    /**
     * Instantiates a new Wide easy info.
     */
    public WideEasyInfo() {
        this.numberOfBalls = 10;
        for (int i = 0; i < numberOfBalls; i++) {
            //initialBallVelocities.add(Velocity.fromAngleAndSpeed((0 + i * 30 * Math.pow(-1, i)) % 85, 7));
            initialBallVelocities.add(Velocity.fromAngleAndSpeed((0 + i * 7 * Math.pow(-1, i)), 7));
        }
        this.paddleSpeed = 7;
        this.paddleWidth = 600;
        this.levelName = "Wide Easy";
        this.background = new WideEasyBackground(new Point(-1, -1),
                GUI_WIDTH + 5, GUI_HEIGHT + 5, Color.white);
        List<Color> rainbow = createDoubleRainbowList();
        for (int i = 0; i < 14; i++) {
            Block block = new Block(new Point(0 + i * 57.20, 250), 57.20, 25);
            block.setColor(rainbow.get(i));
            blocks.add(block);
        }
        numberOfBlocksToRemove = blocks.size();
    }

    /**
     * Create double rainbow list list.
     *
     * @return the list
     */
    public List<Color> createDoubleRainbowList() {
        List<Color> rainbow = new ArrayList<>();
        rainbow.add(new Color(238, 130, 238));
        rainbow.add(new Color(238, 130, 238));
        rainbow.add(new Color(75, 0, 130));
        rainbow.add(new Color(75, 0, 130));
        rainbow.add(new Color(0, 0, 255));
        rainbow.add(new Color(0, 0, 255));
        rainbow.add(new Color(0, 230, 0));
        rainbow.add(new Color(0, 230, 0));
        rainbow.add(new Color(255, 255, 0));
        rainbow.add(new Color(255, 255, 0));
        rainbow.add(new Color(255, 165, 0));
        rainbow.add(new Color(255, 165, 0));
        rainbow.add(new Color(255, 0, 0));
        rainbow.add(new Color(255, 0, 0));
        return rainbow;
    }


    @Override
    public int numberOfBalls() {
        return numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return initialBallVelocities;
    }

    @Override
    public int paddleSpeed() {
        return paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return paddleWidth;
    }

    @Override
    public String levelName() {
        return levelName;
    }

    @Override
    public Sprite getBackground() {
        return background;
    }

    @Override
    public List<Block> blocks() {
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return numberOfBlocksToRemove;
    }
}
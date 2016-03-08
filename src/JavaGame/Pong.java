package JavaGame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import java.awt.*;

public class Pong extends StateBasedGame {

    public static final String GAME_NAME = "DIS GAME";
    public static final int MENU = 0;
    public static final int PLAY = 1;

    public static final int FRAME_WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
    public static final int FRAME_HEIGHT =  GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();

    public Pong(String gameName){
        super(gameName);
        this.addState(new Menu(MENU));
        this.addState(new Play(PLAY));
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(MENU).init(gc, this);
        this.getState(PLAY).init(gc, this);
        this.enterState(MENU);
    }

    public static void main(String[] args){

        AppGameContainer appgc;
        try{
            appgc = new AppGameContainer(new Pong(GAME_NAME));
            appgc.setDisplayMode(FRAME_WIDTH, FRAME_HEIGHT, true);
            appgc.start();
        } catch(SlickException e){
            e.printStackTrace();
        }
    }
}

package JavaGame;

import java.awt.Font;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{

    int ballX = Pong.FRAME_WIDTH / 2;
    int ballY = Pong.FRAME_HEIGHT / 2;

    int barY = Pong.FRAME_HEIGHT / 4;

    int rebounds;

    int dx = 10;
    int dy = 10;

    public Menu(int state){

    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Score: " + rebounds, 45 * Pong.FRAME_WIDTH / 100, 0);
        g.setColor(new Color(0, 256, 0));
        g.fillOval(ballX, ballY, Pong.FRAME_HEIGHT/ 12, Pong.FRAME_HEIGHT / 12);
        g.fillRect(0, barY, Pong.FRAME_WIDTH / 50, Pong.FRAME_HEIGHT / 3);
        //g.setColor(new Color(256, 0, 0));
        //g.drawLine(0, barY, Pong.FRAME_WIDTH, barY);
       // g.setColor(new Color(256, 0, 256));
        //g.drawLine(0, barY + Pong.FRAME_HEIGHT / 3, Pong.FRAME_WIDTH, barY + Pong.FRAME_HEIGHT / 3);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e){

        }
        Input in = gc.getInput();
        if ((in.isKeyDown(Input.KEY_UP) || in.isKeyDown(Input.KEY_RIGHT)) && barY > 0){
            barY += -10;
        }else if ((in.isKeyDown(Input.KEY_DOWN)|| in.isKeyDown(Input.KEY_LEFT)) && barY + Pong.FRAME_HEIGHT / 3 < Pong.FRAME_HEIGHT){
            barY += 10;
        } else if (in.isKeyPressed(Input.KEY_ESCAPE)){
            System.exit(getID());
        }
        updateBallLoc();
    }

    private void updateBallLoc(){

        if (ballX + Pong.FRAME_HEIGHT / 12> Pong.FRAME_WIDTH){
            dx *= -1;
        } else if (ballX < 0){
            dx *= -1;
            rebounds = 0;
        }  else if (ballY  + Pong.FRAME_HEIGHT / 12 > Pong.FRAME_HEIGHT || ballY< 0){
            dy *= -1;
        }else if (ballX < Pong.FRAME_WIDTH / 50 && (ballY > barY && ballY < barY + Pong.FRAME_HEIGHT / 3)){
            dx *= -1;
            rebounds++;
        }
        ballX += dx;
        ballY += dy;
    }
}

package aut.ap.mapPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * Created by sarb on 5/16/17.
 */
public class CameraManager implements MouseWheelListener,KeyListener
{

    private static final int TILE_MIN_SIZE = 80 ,TILE_MAX_SIZE = 300;

    private MapPanel source;

    public CameraManager(MapPanel source)
    {
        this.source = source;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        changeSize((int) e.getPreciseWheelRotation() * 4 );
        source.repaint();
    }

    private void changeSize(int speed)
    {
        source.setTileSize(source.getTileSize() - speed);
        if(source.getTileSize() < TILE_MIN_SIZE )
            source.setTileSize(TILE_MIN_SIZE);
        if(source.getTileSize() > TILE_MAX_SIZE)
            source.setTileSize(TILE_MAX_SIZE);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                source.setyRoot(source.getyRoot() - 1);
                break;
            case KeyEvent.VK_DOWN:
                source.setyRoot(source.getyRoot() + 1);
                break;
            case KeyEvent.VK_LEFT:
                source.setxRoot(source.getxRoot() - 1);
                break;
            case KeyEvent.VK_RIGHT:
                source.setxRoot(source.getxRoot() + 1);
                break;
        }
        source.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}

package aut.ap.mapPanel;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Random;

/**
 * Created by sarb on 5/16/17.
 */
public class MapPanel extends JPanel implements Serializable
{

    private Tile[][] tiles;

    private int widthCoord;
    private int heightCoord;

    private int panelWidth;
    private int panelHeight;

    private int size;
    private int cotang;

    private int xRoot=0;
    private int yRoot=0;

    private JFrame theFrame;

    public MapPanel(int widthCoord, int heightCoord, int panelWidth, int panelHeight,int size, int cotang)
    {
        this.widthCoord = widthCoord;
        this.heightCoord = heightCoord;

        this.panelHeight = panelHeight;
        this.panelWidth = panelWidth;

        tiles = new Tile[widthCoord][heightCoord];

        for (int j = 0; j < heightCoord; j++)
            for (int i = 0; i < widthCoord; i++)
                tiles[i][j] = new Tile(i, j);

        this.size = size;
        this.cotang = cotang;

        setCameraManager();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        for (int j = 0; j < heightCoord; j++)
            for (int i = 0; i < widthCoord; i++)
            {
                g2.setColor(tiles[i][j].getColor());
                g2.fillPolygon(tiles[i][j].getPolygon(xRoot, yRoot, size,cotang));
            }
    }

    public void init(MapPanel p){
        theFrame = new JFrame("something");
        theFrame.setSize(1500,1500);
        theFrame.setLocationRelativeTo(null);
        theFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        theFrame.addKeyListener(cameraManager);
        theFrame.add(p);

        theFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
//        JFrame myFrame = new JFrame("MAP EDITOR 1.0");
//
//        myFrame.setSize(1500 , 1000);
//        myFrame.setLocation(300, 150);
//        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        myFrame.setLayout(new BorderLayout());
//
//        myFrame.add(new MapPanel(20,42,1500,1000,160,2), BorderLayout.CENTER);
//
//        myFrame.setVisible(true);

        // new code erfan edition + init function and theFrame var:

        MapPanel myMapPanel = new MapPanel(20,42,1500,1000,160,2);
        myMapPanel.init(myMapPanel);
    }

    private CameraManager cameraManager;
    private void setCameraManager()
    {
        cameraManager = new CameraManager(this);
        this.addMouseWheelListener(cameraManager);
        this.addKeyListener(cameraManager);

    }

    // getters and setters :

    public int getTileSize()
    {
        return size;
    }

    public void setTileSize(int size)
    {
        this.size = size;
    }

    public void setxRoot(int xRoot)
    {
        this.xRoot = xRoot;
    }

    public void setyRoot(int yRoot)
    {
        this.yRoot = yRoot;
    }

    public int getyRoot()
    {
        return yRoot;
    }

    public int getxRoot()
    {
        return xRoot;
    }
}

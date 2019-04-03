package view.tilesMap;/*
 * *@Date:  2019-03-23
 * *@author:  Biao Li
 * *StudentID :  s3675917
 * *@ver 1.0
 * */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import view.Sprite;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class TileManager {
    public static ArrayList<TileMap> tm;

    public TileManager() {
        tm = new ArrayList<TileMap>();
    }

    public TileManager(String path) {
        tm = new ArrayList<TileMap>();
        addTileMap(path, 16, 16);
    }

    private void addTileMap(String path, int blockWidth, int blockHeight) {
        String imagePath;

        int width = 0;
        int height = 0;
        int tileWidth;
        int tileHeight;
        int tileColumns;
        int layers = 0;
        Sprite sprite;

        String[] data = new String[10];

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("tileset");
            Node node = list.item(0);
            Element eElement = (Element) node;

            imagePath = eElement.getAttribute("name");
            tileWidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
            tileHeight = Integer.parseInt(eElement.getAttribute("tileheight"));
            tileColumns =  Integer.parseInt(eElement.getAttribute("columns"));
            sprite = new Sprite("res/tile/" + imagePath + ".png", tileWidth, tileHeight);

            list = doc.getElementsByTagName( "layer");
            layers = list.getLength();
            System.out.println(layers);

            for(int i = 0; i < layers; i++) {
                node = list.item(i);
                eElement = (Element) node;
                if(i <= 0) {
                    width = Integer.parseInt(eElement.getAttribute("width"));
                    height = Integer.parseInt(eElement.getAttribute("height"));
                }

                data[i] = eElement.getElementsByTagName("data").item(0).getTextContent();

                if(i < 1) {
//                    tm.add(new TileMapNorm(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));
                    tm.add(new TileMapNorm(data[i], sprite, width, height, tileWidth, tileHeight, tileColumns));
                } else {
                    tm.add(new TileMapWall(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));
                }


            }
        } catch(Exception e) {
            System.out.println("ERROR - TILEMANAGER: can not read tilemap");
        }
    }

    public void render(Graphics g) {

        for(int i = 0; i < tm.size(); i++) {
            tm.get(i).render(g);
        }
    }
}

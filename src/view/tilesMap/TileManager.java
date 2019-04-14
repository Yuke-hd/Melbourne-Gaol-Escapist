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
import view.utils.Sprite;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class TileManager {
    private ArrayList<TileMap> tm;
    private int width = 0;
    private int height = 0;
    // private String[] wall;
    public TileManager(String path) {
        tm = new ArrayList<>();
        addTileMap(path, 16, 16);
    }

    private void addTileMap(String path, int blockWidth, int blockHeight) {
        String imagePath;
        int tileWidth;
        int tileHeight;
        int tileColumns;
        int layers;
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

                switch (i){
                    case 2: tm.add(new TileMap(data[i], sprite, width, height, blockWidth*2, blockHeight*2, tileColumns));
//                    wallString = data[i].split(",");
//                        for (String s:wallString
//                             ) {
//
//                        }
                    break;
                    default: tm.add(new TileMap(data[i], sprite, width, height, tileWidth*2, tileHeight*2, tileColumns));
                }


            }
        } catch(Exception e) {
            System.out.println("ERROR - TILEMANAGER: can not read tilemap");
        }
    }

//
//    public WallTiles getTileType(Position pos){
//        TileMapWall tileMapWall = (TileMapWall)tm.get(1);
//        if (tileMapWall.checkIfIsWall(pos) != null) return tileMapWall.checkIfIsWall(pos);
//        else return null;
//    }

//    public Position getRandomStartPoint(){
//        return ((TileMapNorm)tm.get(1)).getRandomPoint();
//    }

    public ArrayList<TileMap> getTm() {
        return tm;
    }



}

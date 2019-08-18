/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kigyo;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author juhas
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane gamepane;
    @FXML
    private Pane errorp;
    @FXML
    private AnchorPane startpane;
    @FXML
    private Button start;
    @FXML
    private Button errorb;
    @FXML
    private VBox snakeb;

    @FXML
    private TextField player;

    private String name = "";
    static int speed = 5;
    static int foodcolor = 0;
    static int width = 20;
    static int height = 20;
    static int foodX = 0;
    static int foodY = 0;
    static int cornersize = 25;
    static ArrayList<Corner> snake = new ArrayList<>();
    static Dir directien = Dir.left;
    static boolean gameOver = false;
    static Random rnd = new Random();

    public enum Dir {
        left, rigth, up, down
    }

    @FXML
    private void start(ActionEvent event) {
        if (player.getLength() != 0) {
            startpane.setDisable(true);
            startpane.setVisible(false);
            gamepane.setVisible(true);
            name = player.getText();
            System.out.println(name);
        } else {
            errorp.setVisible(true);
            startpane.setDisable(true);
        }
    }

    @FXML
    private void errorb(ActionEvent event) {
        errorp.setVisible(false);
        startpane.setDisable(false);
    }

    public static void newFood() {
        start:
        while (true) {
            foodX = rnd.nextInt(width);
            foodX = rnd.nextInt(height);
            for (Corner c : snake) {
                if (c.x == foodX && c.y == foodY) {
                    continue start;
                }
            }
            foodcolor = rnd.nextInt(5);
            speed++;
            break;
        }
    }

  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

}

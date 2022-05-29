/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong2pelaajaa;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import java.util.Map;
import java.util.HashMap;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.scene.shape.Shape;

/**
 *
 * @author Pauli
 */
public class Pong2Pelaajaa extends Application {
    private String suunta;
    boolean ammuttu = false;
    boolean ammuttu2 = false;
    public Map <KeyCode, Boolean> painallukset;
    public Circle ympyra;
    public Rectangle suunnikas;
    public Rectangle suunnikas2;
    public int pelaaja1pisteet=0;
    public int pelaaja2pisteet=0;
    @Override
    
    public void start (Stage ikkuna) {
        Pane ruutu = new Pane ();
        Map <KeyCode, Boolean> painallukset = new HashMap <>();
        
        Rectangle suunnikas = new Rectangle(300,30);
        Rectangle suunnikas2 = new Rectangle(300,30);
        
        Circle ammus = new Circle (10);
        Circle ammus2 = new Circle(10);
        Circle ympyra = new Circle(20);
        ruutu.getChildren().add(suunnikas);
        ruutu.getChildren().add(suunnikas2);
        ruutu.getChildren().add(ympyra);
        ympyra.setTranslateX(590);
        ympyra.setTranslateY(800);
        suunnikas.setTranslateX(400);
        suunnikas.setTranslateY(900);
        suunnikas2.setTranslateX(400);
        suunnikas2.setTranslateY(100);
        ruutu.setPrefSize(1200,1000);
        Scene nakyma = new Scene(ruutu);
        nakyma.setOnKeyPressed ((event) -> {
            painallukset.put(event.getCode(),Boolean.TRUE);
        });
        nakyma.setOnKeyReleased((event) -> {
           painallukset.put(event.getCode(),Boolean.FALSE);
        });
        suunta = "YV"; // ylävasemmalle
        
        new AnimationTimer() {
            @Override
            public void handle (long nykyhetki) {
                if (painallukset.getOrDefault(KeyCode.LEFT, false)) {
                    suunnikas.setTranslateX(suunnikas.getTranslateX()-7);
                }
                if (painallukset.getOrDefault(KeyCode.RIGHT, false)) {
                    suunnikas.setTranslateX(suunnikas.getTranslateX()+7);
                }
                if (painallukset.getOrDefault(KeyCode.SHIFT, false)) {
                    if (ammuttu == false) {
                    ruutu.getChildren().add(ammus);
                    ammus.setTranslateX(suunnikas.getTranslateX()+145);
                    ammus.setTranslateY(suunnikas.getTranslateY()-5);
                    ammuttu = true;
                    }
                }
                if (painallukset.getOrDefault(KeyCode.Z, false)) {
                    suunnikas2.setTranslateX(suunnikas2.getTranslateX()-7);
                }
                if (painallukset.getOrDefault(KeyCode.X, false)) {
                    suunnikas2.setTranslateX(suunnikas2.getTranslateX()+7);
                }
                if (painallukset.getOrDefault(KeyCode.CONTROL, false)) {
                    if (ammuttu2 == false) {
                    ruutu.getChildren().add(ammus2);
                    ammus2.setTranslateX(suunnikas2.getTranslateX()+145);
                    ammus2.setTranslateY(suunnikas2.getTranslateY()+5);
                    ammuttu2 = true;
                    }
                }
                if (suunta=="YV") {
                    
                ympyra.setTranslateX(ympyra.getTranslateX()-8);
                ympyra.setTranslateY(ympyra.getTranslateY()-8);
                if (ympyra.getTranslateX()<=20)  {
                    suunta="YO";
                }
                if (ympyra.getTranslateY() <= 20) {
                    System.out.println("Alempi pelaaja voitti.");
                    if (ammuttu == true) {
                    ruutu.getChildren().remove(ammus);
                    ammuttu=false;
                    }
                    if (ammuttu2 == true) {
                    ruutu.getChildren().remove(ammus2);
                    ammuttu2=false;
                    }
                    ympyra.setTranslateX(590);
                    ympyra.setTranslateY(800);
                    suunnikas.setTranslateX(400);
                    suunnikas.setTranslateY(900);
                    suunnikas2.setTranslateX(400);
                    suunnikas2.setTranslateY(100);
                    pelaaja2pisteet++;
                     System.out.println("Tilanne: Pelaaja 1(ylempi):"+pelaaja1pisteet+": Pelaaja 2(alempi):"+pelaaja2pisteet);
                      suunta="YO";
        
                }
                }
                if (suunta=="YO") {
                    
                ympyra.setTranslateX(ympyra.getTranslateX()+8);
                ympyra.setTranslateY(ympyra.getTranslateY()-8);
                if (ympyra.getTranslateX()>=1180)  {
                    suunta="YV";
                }
                if (ympyra.getTranslateY()<=20)  {
                    System.out.println("Alempi pelaaja voitti.");
                    if (ammuttu == true) {
                    ruutu.getChildren().remove(ammus);
                    ammuttu=false;
                    }
                    if (ammuttu2 == true) {
                    ruutu.getChildren().remove(ammus2);
                    ammuttu2=false;
                    }
                    ympyra.setTranslateX(590);
                ympyra.setTranslateY(800);
                suunnikas.setTranslateX(400);
                suunnikas.setTranslateY(900);
                suunnikas2.setTranslateX(400);
                suunnikas2.setTranslateY(100);
                pelaaja2pisteet++; 
                 System.out.println("Tilanne: Pelaaja 1(ylempi):"+pelaaja1pisteet+": Pelaaja 2(alempi):"+pelaaja2pisteet);
                    suunta="YO";
        
                }
                
                }
                
                if (suunta=="AO") {
                    
                ympyra.setTranslateX(ympyra.getTranslateX()+8);
                ympyra.setTranslateY(ympyra.getTranslateY()+8);
                if (ympyra.getTranslateX()>=1180)  {
                    suunta="AV";
                }
                if (ympyra.getTranslateY()>=980)  {
                    System.out.println("Ylempi pelaaja voitti.");
                    if (ammuttu == true) {
                    ruutu.getChildren().remove(ammus);
                    ammuttu=false;
                    }
                    if (ammuttu2 == true) {
                    ruutu.getChildren().remove(ammus2);
                    ammuttu2=false;
                    }
                    
                    ympyra.setTranslateX(590);
                ympyra.setTranslateY(800);
                suunnikas.setTranslateX(400);
                suunnikas.setTranslateY(900);
                suunnikas2.setTranslateX(400);
                suunnikas2.setTranslateY(100);
                pelaaja1pisteet++;
                 System.out.println("Tilanne: Pelaaja 1(ylempi):"+pelaaja1pisteet+": Pelaaja 2(alempi):"+pelaaja2pisteet);
                    suunta="YO";

                }
                }
                if (suunta=="AV") {
                    
                ympyra.setTranslateX(ympyra.getTranslateX()-8);
                ympyra.setTranslateY(ympyra.getTranslateY()+8);
                if (ympyra.getTranslateY()>=980)  {
                    System.out.println("Ylempi pelaaja voitti.");
                    if (ammuttu == true) {
                    ruutu.getChildren().remove(ammus);
                    ammuttu=false;
                    }
                    if (ammuttu2 == true) {
                    ruutu.getChildren().remove(ammus2);
                    ammuttu2=false;
                    }
                    ympyra.setTranslateX(590);
                ympyra.setTranslateY(800);
                suunnikas.setTranslateX(400);
                suunnikas.setTranslateY(900);
                suunnikas2.setTranslateX(400);
                suunnikas2.setTranslateY(100);
                 pelaaja1pisteet++;
                  System.out.println("Tilanne: Pelaaja 1(ylempi):"+pelaaja1pisteet+": Pelaaja 2(alempi):"+pelaaja2pisteet);
                    suunta="YO";
        
                }
                if (ympyra.getTranslateX()<=20)  {
                    suunta="AO";
                }
                }
                
                if ((tormaa(ympyra,suunnikas))&&(ympyra.getTranslateY()<900)) {
                    if (suunta=="AO") {
                        suunta ="YO";
                    }
                    if (suunta =="AV") {
                        suunta ="YV";
                    }
                 }
                 if ((tormaa(ympyra,suunnikas2))&&(ympyra.getTranslateY()>100)) {
                    if (suunta=="YO") {
                        suunta ="AO";
                    }
                    if (suunta =="YV") {
                        suunta ="AV";
                    }
                 }
                if (tormaa(ympyra,ammus)) {
                    ruutu.getChildren().remove(ammus);
                    ammuttu=false;
                }
                
                if (tormaa(ympyra,ammus2)) {
                    ruutu.getChildren().remove(ammus);
                    ammuttu2=false;
                }
                if (tormaa(suunnikas2,ammus)) {
                    System.out.println("Alempi pelaaja voitti.");
                    ympyra.setTranslateX(590);
                ympyra.setTranslateY(800);
                suunnikas.setTranslateX(400);
                suunnikas.setTranslateY(900);
                suunnikas2.setTranslateX(400);
                suunnikas2.setTranslateY(100);
                    suunta="YO";
                     pelaaja2pisteet++;
                      System.out.println("Tilanne: Pelaaja 1(ylempi):"+pelaaja1pisteet+": Pelaaja 2(alempi):"+pelaaja2pisteet);
        
                }
                 if (tormaa(suunnikas,ammus2)) {
                    System.out.println("Ylempi pelaaja voitti.");
                    ympyra.setTranslateX(590);
                ympyra.setTranslateY(800);
                suunnikas.setTranslateX(400);
                suunnikas.setTranslateY(900);
                suunnikas2.setTranslateX(400);
                suunnikas2.setTranslateY(100);
                    suunta="YO";
                     pelaaja1pisteet++;
                     System.out.println("Tilanne: Pelaaja 1(ylempi):"+pelaaja1pisteet+": Pelaaja 2(alempi):"+pelaaja2pisteet);
        
                }
                if (ammuttu==true) {
                    ammus.setTranslateY(ammus.getTranslateY()-10);
                    if (ammus.getTranslateY()<15) {
                        ruutu.getChildren().remove(ammus);
                        ammuttu=false;
                    }
                    
                }
                if (ammuttu2==true) {
                    ammus2.setTranslateY(ammus2.getTranslateY()+10);
                    if (ammus2.getTranslateY()>985) {
                        ruutu.getChildren().remove(ammus2);
                        ammuttu2=false;
                    }
                    
                }
                if (tormaa(ympyra,ammus2)) {
                    ruutu.getChildren().remove(ammus2);
                }
                if (tormaa(ympyra,ammus)) {
                    ruutu.getChildren().remove(ammus);
                }
                if (suunnikas.getTranslateX()<0) {
                    suunnikas.setTranslateX(0);
                }
                if (suunnikas.getTranslateX()>900) {
                    suunnikas.setTranslateX(900);
                }
                   
                if (suunnikas2.getTranslateX()<0) {
                    suunnikas2.setTranslateX(0);
                }
                if (suunnikas2.getTranslateX()>900) {
                    suunnikas2.setTranslateX(900);
                }
                System.out.println(ympyra.getTranslateX());
                System.out.println(ympyra.getTranslateY());
                System.out.println(suunta);
            }
        }.start();
        ikkuna.setScene(nakyma);
        ikkuna.show();
        
    }
    public boolean tormaa (Shape tormatty, Shape tormaaja) {
        Shape tormaysalue = Shape.intersect(tormatty, tormaaja);
        return tormaysalue.getBoundsInLocal().getWidth() != -1;
    }
    public void waitForUserInput() {
        
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(Pong2Pelaajaa.class);
    }
    
}

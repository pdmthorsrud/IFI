import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PinballSketch extends PApplet {

int posBallX = 0;
int posBallY = 0;
int ballSpeed=4;

boolean down=true;
boolean left=false;

public void setup(){
  
  background(0, 0, 0);
}

public void draw(){
  if(posBallY>500){
    gameOver();
  }else{
    background(0, 0, 0);
    fill(255, 255, 255);
    text("y = " + posBallY, 10, 10);
    text("x = " + posBallX, 10, 30);
    setMovementBall();
    moveBall();
    fill(255, 0, 0);
    rect((mouseX-40), 490, 80, 10);
  }
}

public void moveBall(){
  if(down==false && left==false){
    moveBallRightUp();
  }else if(down==true && left==false){
    moveBallRightDown();
  }else if(down==false && left==true){
    moveBallLeftUp();
  }else if(down==true && left==true){
    moveBallLeftDown();
  }
}

public void gameOver(){
  background(255, 0, 0);
  fill(0, 0, 0);
  textSize(50);
  text("GAME OVER", 500, 250);
  textAlign(CENTER, CENTER);
}

public void setMovementBall(){
  if(posBallY==480 && posBallX>mouseX-40 && posBallX<=mouseX) {
    down=false;
    left=true;
  }else if(posBallY==480 && posBallX>mouseX && posBallX<mouseX+40){
    down=false;
    left=false;
  }else if(posBallY==0 && posBallX==0){
    down=true;
    left=false;
  }else if(posBallY==1000 && posBallX==1000){
    down=true;
    left=true;
  }else if(posBallY==0){
    down=true;
  }else if(posBallX==0){
    left=false;
  }else if(posBallX==1000){
    left=true;
  }
}

public void moveBallRightDown(){
  ellipse(posBallX+=ballSpeed, posBallY+=ballSpeed, 15, 15);
}

public void moveBallRightUp(){
  ellipse(posBallX+=ballSpeed, posBallY-=ballSpeed, 15, 15);
}

public void moveBallLeftDown(){
  ellipse(posBallX-=ballSpeed, posBallY+=ballSpeed, 15, 15);
}

public void moveBallLeftUp(){
  ellipse(posBallX-=ballSpeed, posBallY-=ballSpeed, 15, 15);
}
  public void settings() {  size(1000, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PinballSketch" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

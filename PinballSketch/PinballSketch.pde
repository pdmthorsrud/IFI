int posBallX = 0;
int posBallY = 0;
int ballSpeed=4;

boolean down=true;
boolean left=false;

void setup(){
  size(1000, 500);
  background(0, 0, 0);
}

void draw(){
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

void moveBall(){
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

void gameOver(){
  background(255, 0, 0);
  fill(0, 0, 0);
  textSize(50);
  text("GAME OVER", 500, 250);
  textAlign(CENTER, CENTER);
}

void setMovementBall(){
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

void moveBallRightDown(){
  ellipse(posBallX+=ballSpeed, posBallY+=ballSpeed, 15, 15); 
}

void moveBallRightUp(){
  ellipse(posBallX+=ballSpeed, posBallY-=ballSpeed, 15, 15); 
}

void moveBallLeftDown(){
  ellipse(posBallX-=ballSpeed, posBallY+=ballSpeed, 15, 15); 
}

void moveBallLeftUp(){
  ellipse(posBallX-=ballSpeed, posBallY-=ballSpeed, 15, 15); 
}

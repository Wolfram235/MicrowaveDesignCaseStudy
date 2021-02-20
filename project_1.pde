
HScrollbar hs1;
int i=1;
int basex =850;
int basey=350;
int sliderTicksy1=310;
int sliderTicksy2=330;
String str = "300 W";

int angle=1;
boolean oc=false;
boolean open=false;
void setup() {
    size(1200,900,P3D);
    hs1 = new HScrollbar(basex, basey, 280, 20, 16);
       //door of microwave
    fill(0,0,0);
  
   
 
}


void draw() {
    background(255,255,255);
    // main shell of the microwave
    fill(120, 160, 200);
    rect(50, 50, 1100  , 700);

    
 //door lining 
 fill(255,255,255);
    rect(80,80,740,640);



    // display of microwave
    fill(200,200,200);
    rect(850,80,280,180);

    //slider for power
     hs1.update();
  hs1.display();

//power slider ticks
strokeWeight(3);
stroke(0);
int iwidth=55;
textSize(25);
text(str, basex-10, (sliderTicksy1-20)); 
int count=1;
line(basex ,sliderTicksy1, basex, sliderTicksy2);
line((basex+(iwidth*count)) ,sliderTicksy1, (basex+(iwidth*count)), sliderTicksy2);
count++;
line((basex+(iwidth*count)) ,sliderTicksy1, (basex+(iwidth*count)), sliderTicksy2);
count++;
line((basex+(iwidth*count)) ,sliderTicksy1, (basex+(iwidth*count)), sliderTicksy2);
count++;
line((basex+(iwidth*count)) ,sliderTicksy1, (basex+(iwidth*count)), sliderTicksy2);
count++;
line((basex+(iwidth*count)) ,sliderTicksy1, (basex+(iwidth*count)), sliderTicksy2);


     if(oc){
       if(!open)
    angle++;
    else
    angle--;
      rotateY(-radians(angle));
      println(angle);
      if(angle>=90&& angle>=0){
        oc=false;
        //angle=0;
      }
    }
    if(open&&!oc){
  rotateY(90);
  println("in open state");
       rect(100, 100, 700  , 600);
    }
    else{
      println("in close state");
     rect(100, 100, 700  , 600);
    }
 
}

class HScrollbar{
  int swidth, sheight;    // width and height of bar
  float xpos, ypos;       // x and y position of bar
  float spos, newspos;    // x position of slider
  float sposMin, sposMax; // max and min values of slider
  int loose;              // how loose/heavy
  boolean over;           // is the mouse over the slider?
  boolean locked;
  float ratio;
  float precentVal;

   HScrollbar (float xp, float yp, int sw, int sh, int l) {
    swidth = sw;
    sheight = sh;
    int widthtoheight = sw - sh;
    ratio = (float)sw / (float)widthtoheight;
    xpos = xp;
    ypos = yp-sheight/2;
    spos = xpos + swidth/2 - sheight/2;
    newspos = spos;
    sposMin = xpos;
    sposMax = xpos + swidth - sheight;
    loose = l;
    
  }

  void update() {
    if (overEvent()) {
      over = true;
    } else {
      over = false;
    }
    if (mousePressed && over) {
      locked = true;
    }
    if (!mousePressed) {
      locked = false;
    }
    if (locked) {
      newspos = constrain(mouseX-sheight/2, sposMin, sposMax);
       
    }
    if (abs(newspos - spos) > 1) {
      spos = newspos;
      println(getPos());
    }

   
  }

  float constrain(float val, float minv, float maxv) {
    return min(max(val, minv), maxv);
  }

  boolean overEvent() {
    if (mouseX > xpos && mouseX < xpos+swidth &&
       mouseY > ypos && mouseY < ypos+sheight) {
      return true;
    } else {
      return false;
    }
  }

  void display() {
    noStroke();
    fill(204);
    rect(xpos, ypos, swidth, sheight);
    if (over || locked) {
      fill(0, 0, 0);
    } else {
      fill(102, 102, 102);
    }
    rect(spos, ypos, sheight, sheight);
  }

  float getPos() {
    // Convert spos to be values between
    // 0 and the total width of the scrollbar

    float val = spos -xpos;
    float per = val/swidth;
    per=per*100;
if(per<=16){
  str="100 W";
}
else if(per>16&& per<=32){
  str="180 W";
}
else if(per>32&& per<=48){
  str="300 W";
}
else if(per>48&& per<=64){
  str="450 W";
}
else if(per>64&& per<=80){
  str="600 W";
}
else if (per>80&& per<=100){
  str="900 W";
}

    return per;
  }
}
void mousePressed() {
  // Rotate the shape around the z-axis each time the mouse is pressed
println("pressed");
oc=true;
 angle=0;
 open=!open;
}
  

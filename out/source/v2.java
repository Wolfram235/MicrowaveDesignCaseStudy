import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 
import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class v2 extends PApplet {


	


ControlP5 cp5;

int i=1;
int basex =925;
int basey=350;
int sliderTicksy1=310;
int sliderTicksy2=330;

PFont pf;
int angle=0;
boolean oc=false;
boolean open=false;
boolean started = false;
boolean done= false;
PImage microwaveInside;
Knob myKnobA;
Knob myKnobB;
int knobValue = 100;
int sliderTicks2 = 30;
Controller  slider;

Knob myKnobMIN;
Knob myKnobSEC;
int minVal = 0;
int secVal = 0;
int totalSec = 0;
   int onesecond = 1000;
      int time;
PFont f;
Button start;
Button stop;
Button regularFeatures;
Button additionalFeatures;
Button openDoor;

SoundFile file;

CheckBox checkbox;
Textlabel displayText;

public void setup() {
    
  pf= createFont("Arial",20);
   
  //
  f = createFont("Arial", 24);
 time=millis();
microwaveInside = loadImage("micro.jpg");
  
  cp5 = new ControlP5(this);
  
cp5.setFont(f);
        //new Knob for keeping track of the minutes
        myKnobMIN = cp5.addKnob("Minutes")
                	.setRange(0,60)
                	.setPosition(925,400)
                	.setRadius(60)
                	.setNumberOfTickMarks(60)
                	.setTickMarkLength(4)
                	.snapToTickMarks(true)
                	.setColorForeground(color(255))
                	.setColorBackground(color(0))
                	.setColorActive(color(255,255,0))
                	.setDragDirection(Knob.HORIZONTAL);   


        myKnobMIN.getValueLabel().setFont(f);
        myKnobMIN.getCaptionLabel().setFont(f);
        myKnobMIN.setOffsetAngle(-HALF_PI);


                myKnobSEC = cp5.addKnob("Seconds")
                     .setRange(0,60)
                     .setValue(secVal)
                     .setPosition(1100,400)
                     .setRadius(60)
                     .setNumberOfTickMarks(60)
                     .setTickMarkLength(4)
                     .snapToTickMarks(true)
                     .setColorForeground(color(255))
                     .setColorBackground(color(0))
                     .setColorActive(color(255,255,0))
                     .setDragDirection(Knob.HORIZONTAL);
                     
        myKnobSEC.getValueLabel().setFont(f);
        myKnobSEC.getCaptionLabel().setFont(f);
        myKnobSEC.setOffsetAngle(-HALF_PI);

  // slider for the power
  slider= cp5.addSlider("Power")
  .setCaptionLabel("Power :")
     .setPosition(basex,basey)
     .setWidth(300)
     .setHeight(20)
     .setRange(100,900) // values can range from big to small as well
     .setValue(200)
     .setNumberOfTickMarks(9)
     .setSliderMode(Slider.FLEXIBLE)
     ;

   slider.getCaptionLabel().getStyle().marginTop = -25;
   slider.getCaptionLabel().getStyle().marginLeft = -300;
    slider.getCaptionLabel().setFont(pf);
   slider.getValueLabel().getStyle().marginTop = -25;
   slider.getValueLabel().getStyle().marginLeft = 100;
  slider.getValueLabel().setFont(pf); 
// microwave start button for countdown
   start=cp5.addButton("Start")
        .setValue(0)
        .setPosition(basex+50,basey+250)
        .setSize(80,50)
        ;
          start.getCaptionLabel().setFont(f); 
      stop=cp5.addButton("Stop")
        .setValue(0)
        .setPosition(basex+160,basey+250)
        .setSize(80,50)
        ;
        

         openDoor  =cp5.addButton("Door")
         .setCaptionLabel("Open Door")
         .setPosition(basex, basey+320)
         .setSize(290,60);
        

          checkbox = cp5.addCheckBox("checkBox")
                .setPosition(950, 100)
                .setColorForeground(color(120))
                .setColorActive(color(255))
                .setColorLabel(color(255))
                .setSize(20, 20)
                .setItemsPerRow(1)
                .setSpacingColumn(30)
                .setSpacingRow(30)
                .addItem("Set Power", 1)
                .addItem("Set Timer", 2)
                .addItem("Press Start", 3)
                .setFont(f)
                ;
                

                displayText = cp5.addTextlabel("Display")
                .setPosition(960,120)
                ;
               
}


public void draw() {
    background(255,255,255);
    

    // main shell of the microwave
    strokeWeight(2);
    fill(120, 160, 200);
   

//rect(875,50,375,700);
if(!open){
     //side control panel rect
     strokeWeight(8);
     rect(50, 50, 1200  , 700);
 //door lining 
  strokeWeight(8);
 fill(255,255,255);
    if(angle>=0){
      //when door closed inner door window panel
       image(microwaveInside,  80  , 80,740,640);
      fill(0,200);
      rect(80,80,740,640);

     
    }
}else{
   //side control panel rectangle
     strokeWeight(8);
     
rect(50, 50, 1200  , 700);

}


    // display of microwave
     strokeWeight(2);
    fill(0);
    rect(925,80,280,180);

    //slider for power


//power slider ticks


//knobs for time
 fill(knobValue);


  

    ///code to do countdown
  
          if (totalSec > 0 && (millis()-time)>= onesecond) {
          
            
            totalSec--;
            println(secVal);
            secVal--;
            if(secVal<=0) {
              if(minVal==0) {
                file = new SoundFile(this, "ding.mp3");
  file.play();
  displayText.setText("Your Food is cooked! \n \n \nCaution it is hot!");
  done = true;
              }
              else {
                minVal--;
                secVal=60;
              }
            }
            myKnobMIN.setValue(minVal);
            myKnobSEC.setValue(secVal);
            time=millis();
            
            
            
          }

rotateTheDoor();
//seperated door rectangle
fill(255,0.1f);
rect(50,50,825,700);

//delay the showing of the message using frame count.
 if(started && frameCount %60==0){
          checkbox.hide();
           displayText.show();
displayText.setText("Please wait while \n your food is cooking");
started=false;
          }
       if(done && frameCount %700==0){
         displayText.hide();
         checkbox.show();
         done=false;
       }
      if(open ){
     image(microwaveInside,  80  , 80,740,640);
      }
     
  
}// Draw Function ends here****************************************************

public void rotateTheDoor(){
       if(open){
         checkbox.hide();
         displayText.show();
         displayText.setText("\tDoor is Open!! \n \n Remeber to only \n use Microwave safe \n dishes");
         if(angle>=-90){
  angle--;
}
         
       } 
       else{
         
       
         if(angle<=0){
           checkbox.show();
         displayText.hide();
         angle++;
         }

       }
    pushMatrix();

      rotateY(radians(angle));
      strokeWeight(2);
      fill(120, 160, 200);
rect(50,50,825,700);
 strokeWeight(8);
 fill(0,0.2f);
    rect(80,80,740,640);
    
popMatrix();
    
      //println(angle);

    
  
  
}

    
      public void Start(int theValue) {
          println("a button event from Start: "+theValue);
          minVal = (int)myKnobMIN.getValue();
          secVal = (int)myKnobSEC.getValue();
          totalSec=secVal+(minVal*60);
          checkbox.activate(2);
          started=true;
         
        }

  
public void Stop (){
 minVal = 0;
 secVal = 0;
 totalSec = 0;

 myKnobMIN.setValue(minVal);
            myKnobSEC.setValue(secVal);
            checkbox.deactivateAll();
            checkbox.show();
            displayText.hide();
}
public void Door () {
  println("From The Door");
    open=!open;
  if(open){
  openDoor.setCaptionLabel("Close Door");
  }
  else{
  openDoor.setCaptionLabel("Open Door");

  }
  oc=!oc;
  

}

public void Power(int va){
   // println("a slider event. setting background to ");
  checkbox.activate(0);
}


public void Seconds(int theValue) {
 checkbox.activate(1);
  //println("a knob event. setting background to "+theValue);
}

public void Minutes(int min){
 checkbox.activate(1);
}
  public void settings() {  size(1400,900,P3D);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "v2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

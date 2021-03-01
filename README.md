# HCI Project 1 : Microwave Design Case study 

## Links

Report Link: 
1. [Github Link] (https://github.com/Wolfram235/MicrowaveDesignCaseStudy)
2. [Youtube Link] (https://youtu.be/PX9oo9QAwKQ)


## Objective

To learn, understand and design a microwave interface by using the microwave in your apartment as an example and improve on its design.
The purpose of this project is to give us some practice with the material in the design of everyday things.
We use microwaves every day. They have various designs for user controls but not all of them are designed at the best for users.

## Images of the microwave

![Microwave](https://user-images.githubusercontent.com/31333864/109438704-b45c6c80-79f0-11eb-8af7-81d89765c3d3.jpg)


## GIF of the microwave being used
![Microwave](giphy.gif)


## Issues with the current design
1. Controls are not intuitive :
	For a first time user who does not know how to operate a microwave the order in which you press the buttons in order to turn the microwave on is not very intuitive, in other words it is not beginner friendly.

2. Button is flush and no sign :
	The button to open the microwave is almost flush with the control panel with no indications or feedbacks of it being pressed for opening the door.

3. No caution of materials to be used inside a microwave :
	When a person who has never used a microwave uses it for the first time there is a high probability that they will not use microwave safe utensils inside the microwave.
This is an extreme risk which can lead to a fire hazard  and even damage the microwave itself. To avoid this the microwave should provide cautionary instruction as to what utensils can be used inside a microwave.

4. Changing the power level :
	Many of the food items that can be cooked in the microwave come with cooking instructions. These instructions are specific on the power level of the microwave and the time in which you cook the food. Different power levels have different signs. The microwave in my house has a feature to change the power level, but it is in terms of levels which starts from level one to level ten. This is not intuitive as we specifically need to set the power to some amount of watts.

5. Microwave getting locked :
	Some microwave have locks that get activated when you press the start button too many times. This seems like a child lock. If the e-lock gets activated the display goes blank, other than a very tiny symbol at the bottom of the microwave. This should be shown to the user in a more proper way to make them aware that the microwave is locked.
	

Suggest the improvements to make on the control interface. Sketch your solution and justify your design decisions.
Here is an example of Low-Fidelity Prototype sketching out the design (for a different purpose).	

## List of common microwave uses:
1. Used to re-heat food.
2. Used to cook food.
3. Used to disinfect items(The item must be microwave safe).
4. Thaw frozen foods.
5. Roasting herbs or spices.
6. Using a microwave to smelt (https://www.instructables.com/microwave-smelter/).
7. Can also be used to make a hot compress (https://www.healthline.com/health/how-to-make-a-warm-compress#moist-compress).

## Sequence of actions while using a Microwave.

Step 1. Open the Door and put in the item.
Step 2. Set the power at which the microwave should be operating. (Not needed every time can be set once and reused)
Step 3. Set the time, this can be done by typing in the numbers using the keypad provided. First the minutes next the seconds.
Step 4. Press start to begin heating and wait for it to finish
Step 5. Open the door and remove the contents carefully. 

## Interaction with the microwave 

Primary mode of interaction with the microwave is by using the provided buttons. These are capacitive buttons and do not provide mechanical feedback. None the less they do provide audio feedback in the form of a short beep. This beep is not very intuitive as pressing any button provides the same short beep sound. Apart from that a visual feed back is given through the microwave display. 

## Common mistakes that you can make with the current design

1. While adjusting the power you can put the wrong power label as the wattage is not provided anywhere.
2. While you thaw frozen food it requests for weight of the food which if put in wrong will cook the food instead of thawing it.
3. Since there are no instructions on the microwave about the utensils that can be used inside the microwave there is a good chance that the user can put metal utensils in the microwave which will cause sparking.
4. If Eggs are not put in the right microwave setting they could possibly explode.

## Sketch
![sketch](https://user-images.githubusercontent.com/31333864/109431012-ddb5d200-79c9-11eb-9010-169adbed177b.jpg)

# Implementation
## Screen Shots of the final implementation :
![Microwave Interface](https://user-images.githubusercontent.com/31333864/109431594-0390a600-79cd-11eb-8263-c037ecc603ee.jpg)
![Microwave Interface](https://user-images.githubusercontent.com/31333864/109431597-04c1d300-79cd-11eb-8cd9-eeb2d1427b36.jpg)

## Componets of Implemented Microwave.

1. Display: The display is used to guide the user to operate the microwave and also provide essential cautionary messages such as if the door is open and the message to only use microwave safe dishes. It also displays a message when the food is ready and cautions the user that the food may be hot to touch.

2. Power slider: The power slider is a very simple slider that the user can use to set the power of the microwave .

3. Knobs: There are two knobs provided for the microwave the first one is used to set the minutes and the second one is used to set the seconds.  A knob is used as it provides mechanical feedback to the user on turning which is the primary mode of interaction. The knob also shows the selected time. This provides a visual feedback as well for the user.

4. Start/ Stop Buttons: Once the timer is set the start button can be used to start the microwave. It initializes the countdown which can be seen on the knob.  A message is displayed to the user which states that the food cooking is in progress. If the user presses the stop button the entire microwave resets.

5. Open / Close button: This is a dedicated button to facilitate the opening and closing of the microwave door. When this button is pressed the door swings open and the insides of the microwave are shown to the user. The microwave display also shows the message that the door is open.



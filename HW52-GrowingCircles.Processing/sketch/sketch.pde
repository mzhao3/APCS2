/* ChickenNuggets (Maggie Zhao, Bing Li, Kenny Li)
APCS2 pd1
Hw#52 -- Grow & Shrink
2018-05-23 W */

// GLOBAL VARIABLES
//   - countClick records how many times the mouse is clicked to determine whether or not the circle should shrink or grow
//   - r determines the radius of the circle
//   - x records the x coordinate of the center of the circle
//   - y records the y coordinate of the center of the circle
int countClick = 0;
int r = 0;
float x;
float y;


// Runs once upon start of the program:
//   - background is set to black (0)
//   - size of the screen is set to 500 x 500
void setup() {
  background(0);
  size(500,500);
}


// Runs continuously after setup() is called at 60 fps
// Resets background (which covers old circles) 
// Draws a circle at the mouse click's x and y, with the set color
void draw() {
  background(0);
  fill(0,255,255);
  ellipse(x,y,r,r);
  // If the number of mouse clicks is odd, the circle grows
  if (countClick % 2 == 1)
    r += 1;
  // Else, the circle shrinks. When the radius is negative, the circle grows again.
  else if (countClick != 0 && countClick % 2 == 0)
    r -= 1;
}


// When the mouse is clicked for the first time, the location of the mouse click determines the center of the circle
// All other times, it increases the countClick count, which determines if the circle should shrink or grow
void mouseClicked() {
  if (countClick == 0) {
    x = mouseX;
    y = mouseY;
  }
  countClick += 1;
}

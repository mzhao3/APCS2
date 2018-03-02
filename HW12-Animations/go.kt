Maggie Zhao
APCS2 pd01
HW12-- +3R|\/|1|\|4|_  1|_|_|\|3$$
2018-03-01  

        Q0: What do you make of the multiple class definitions in a single .java file?
It's cool but confusing- I never knew it was possible to put multiple class definitions in a single .java file. How come class Boardasaurus doesn't have to be public?

        Q1: How are the command line arguments processed?
The command line arguments (board size and delay time) are processed using a try-catch loop. The main method checks for any arguments. Both arguments are checked to see if they are integers; otherwise, it gives an error message.

        Q2: What happens if no command line arguments are given?
If no command line arguments are given, the program uses the default board size (8) and the default delay time (500 milliseconds).

        Q3: What is the nature/purpose of the recursion? Is it necessary for the animation?
The recursion keeps track of the number of moves left, as it stops when the number of moves is equal to the total area of the board. 

    	Q4: What do you expect to see when you run it?
I expect to see a board filled with 0s, with a moat of -1s around it. In the terminal, numbers will be placed on the board in random spots, and the numbers get incrementally larger until it reaches n*n-1. 

        Q5: What does ANSI stand for? What is it good for?
	ANSI stands for the American National Standards Institute, an organization that sets standards for the computer industry and established a standard set of letters and numbers called the ANSI character set. It is a sequence of ASCII characters to interact with the Unix terminal. If the sequence of characters is understood, it will perform the action instead of displaying the character sequence. Having your program print this can give the terminal instructions, such as moving the cursor location or changing its color. The first two characters are always "ESC" and "[". 

        Q6: How did your expectations compare to your observations?
The core functionality was similar to what I expected it to be. I expected the board to refresh in the same terminal space, but it still pleasantly surprised me (because the way us NRdZ did our animations flooded the terminal). I was also a little surprised by how many 0s were still remaining on the board after the program was finished. 

        Q7: How might you adapt this framework to animate a probing for a Knight’s Tour?
	If the randomness of placing the numbers was changed instead to follow a knight's moveset, and a restriction was placed to only allow a knight to go on spaces with a 0 on them, you could effectively implement the brute force version of a Knight's Tour. 

-----o-----o-----o-----o-----o-----o-----o-----o-----o-----o-----o-----o-----
// Latest version of Knight's Tour algorithm using brute force
(will probably take a really really really really long time)

Begin at upper left-hand corner.
1. Place knight in the next available spot
   (can be easily determined by drawing the L shape on the chessboard).
2. Repeat step 1
Continue until
  a) All squares have been visited. (The Knight's Tour is done!)
  b) You reach a square with no next available spots.
      - go to the last spot visited by the knight and choose a different spot
          (that is, the spot that does not have any more solutions)


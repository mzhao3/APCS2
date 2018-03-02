public class BunnyEars {

    // We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
    // We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).


    public static int bunnyEarsA(int bunnies) {

	if (bunnies == 0)
	    return 0;
	if (bunnies == 1)
	    return 2;
	else if (bunnies % 2 == 1 )
	    return bunnyEarsA(bunnies-1) + 2;
	else 
	    return bunnyEarsA(bunnies-1) + 3;
		
	
    }

    // We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).  

    public static int bunnyEars(int bunnies) {
	if (bunnies == 0)
	    return 0;
	else
	    return 2 + bunnyEars(bunnies - 1);
    }
    
    public static void main(String[] args)
    {	
	System.out.println(bunnyEarsA(0)) ;
	System.out.println(bunnyEarsA(1)) ;
	System.out.println(bunnyEarsA(2)) ;

	
    }

}

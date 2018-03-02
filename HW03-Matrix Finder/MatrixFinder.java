/* 
   Team Sparkly Pops - Sophia Xia, Lily Yan, Maggie Zhao
   APCS2 pd1
   HW03 -- I Am Still Searching
   2018-02-01
*/


public class MatrixFinder {
    /***
        precondition:  n x n 2D array of ints, wherein numbers increase across any row (L to R) and down any column...
        postcondition: String representation of coordinates
    ***/
    /* Starting from the bottom left of the matrix, matrixSearch checks to see if the number matches the target number, and return the coordinates. If not, it checks the two other options- if it is greater or less than the target. 
       If the number is less than the target, it moves on to the next number in the same row. 
       If the number is greater than the target, it moves to the number in the row above it (keeping the same index). 
       If the rightmost number of the first row is reached, and the target has not been found, (-1,-1) will be returned.
       Matrix starts from (1,1) and ends with (n,n).
    */
    public static String matrixSearch(int[][] matrix, int target) {
        int r = matrix.length-1;
        int c = 0;
        String ans = "(";
        while (r >= 0 && c <= matrix.length-1) {
            if (matrix[r][c] == target) {
		ans += (r + 1 ) + "," + (c + 1) + ")";
		return ans;
            }
            else if (matrix[r][c] < target) c += 1;
            else if (matrix[r][c] > target) r -= 1;
        }
        return "(-1,-1)";
    }
    
    //stringify(int[][] matrix): returns String representation of matrix
    public static String stringify(int[][] matrix) {
        String foo = "";
        for( int i =0; i < matrix.length; i++ ) {
            foo += "| ";
            for( int j=0; j < matrix.length; j++ ) {
		foo += matrix[i][j] + " "; //get(i+1,j+1)
            }
            foo += "|\n";
        }
        return foo;
    }
    
    public static void main(String[] args) {
        int[][] testUno = {{1,2,3},{2,3,4},{3,4,5}};
        System.out.println("Matrix testUno: \n" + stringify(testUno));
        System.out.println("The location of 5 in matrix testUno is: " + matrixSearch(testUno, 5)); //return (3,3)
        System.out.println("The location of 3 in matrix testUno is: " + matrixSearch(testUno, 3)); //return (3,1)
        System.out.println("The location of 1 in matrix testUno is: " + matrixSearch(testUno, 1)); //return (1,1)
        System.out.println("The location of 6 in matrix testUno is: " + matrixSearch(testUno, 6)); //return (-1,-1)
        
        int[][] testDos = {{1,40,70,100},{30,50,200,300},{70,80,250,400},{120,150,350,450}};
        System.out.println("\nMatrix testDos: \n" + stringify(testDos));
        System.out.println("The location of 40 in matrix testDos is: " + matrixSearch(testDos, 40)); //return (1,2)
        System.out.println("The location of 120 in matrix testDos is: " + matrixSearch(testDos, 120)); //return (4,1)
        System.out.println("The location of 1 in matrix testDos is: " + matrixSearch(testDos, 1)); //return (1,1)
        System.out.println("The location of 100 in matrix testDos is: " + matrixSearch(testDos, 100)); //return (1,4)

	int[][] testTres = {{10,70},{50,100}};
        System.out.println("\nMatrix testTres: \n" + stringify(testTres));
        System.out.println("The location of 5 in matrix testTres is: " + matrixSearch(testTres, 5)); //return (-1,-1)
        System.out.println("The location of 10 in matrix testTres is: " + matrixSearch(testTres, 10)); //return (1,1)
        System.out.println("The location of 100 in matrix testTres is: " + matrixSearch(testTres, 100)); //return (2,2)
        
    
    }
}

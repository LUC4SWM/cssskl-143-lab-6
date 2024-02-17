/*-----------------------------------------------------------------------------------
 *
 *	sum( n ) is a summation algorithm defined as follows:
 *
 *	(1)		sum( n ) =  n + (n-1) + (n-2) + ... + 1
 * 	(1a) 	sum( 1 ) = 1
 *
 * and from this definition, we can rewrite this formula in terms of itself, such that:
 *
 *	(2)	    sum( n ) = n + sum( n - 1 )
 *
 * and we can do this again
 *
 *	(3)    	sum( n ) = n + ( n - 1) + sum( n - 2 )
 *
 * and so on, and so forth, we finally end up with the same as above
 *
 *	(1)	    sum( n ) = n + (n-1) + (n-2) + ... + 1
 *
 *----------------------------------------------------------------------------------- */

import javax.swing.*;

public class RecursionLab {
    private static JTextArea myArea = new JTextArea();
    private static int count = 0;

    public static void main(String args[]) { // invoke the recursive method here...
        /**
         * TODO: switch between the two commented lines below and execute this code,
         * observing the output for both the iterative solution and the recursive solution.
         * To watch the recursive behaviour in action, set a breakpoint on the if statement
         * inside the recursiveSum() function
         *
         */
       /* Commented out code to use for tests.
        //int solution = iterativeSum(20);
        int solution = recursiveSum( 20 );


        // Some GUI details
        myArea.setText(("Result is : " + solution + "\n" + myArea.getText()));
        JScrollPane myPane = new JScrollPane(myArea);
        myPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        myPane.setPreferredSize(new Dimension(600, 300));
        JOptionPane.showMessageDialog(null, myPane);

        // good form to include an exit call when GUIing in Java
        System.exit(0);

        */
//        System.out.println("Input: 4 --- Expected: 24 | Actual: " + factorial(4));
//        System.out.println("Input: 6 --- Expected: 720 | Actual: " + factorial(6));
//        System.out.println("Input: 8 --- Expected: 40320 | Actual: " + factorial(8));

        //System.out.println("Inputs: 4^3 --- Expected: 64 | Actual: " + OptimizedPow(4,3));
        //long bfTime = System.nanoTime();
        //bruteForcePow(5, 20);
        //bfTime = System.nanoTime() - bfTime;
        //long oTime = System.nanoTime();
        //optimizedPow(23, 2301200);
        //oTime = System.nanoTime() - oTime;
        //System.out.println("Brute-Force Time: " + bfTime + " nanoseconds | Optimized Time: " + oTime + " nanoseconds");
        // BruteForce times: 82913135183700, 82928167425400, 82937373012600, 83011440673700, 83023714222400
        // Optimized  times: 83047236859300, 83061780400300, 83080262921400, 83102769647600, 83117557496900

        //Q2.5: I'm not sure why, I feel like I did it wrong somehow, but the Optimized time is longer than the Brute-Force time. The gap even widened when n increased.

//        System.out.println("Fibonacci Test: ");
//        System.out.println("Input: 4 --- Expected: 3 | Actual: " + fib(4));
//       System.out.println("Input: 7 --- Expected: 13 | Actual: " + fib(7));
//        System.out.println("Input: 2 --- Expected: 1 | Actual: " + fib(2));

    }

    /**
     * Recursion is similar to iterative looping, but we
     * use method calls to repeat computations (or decompose the problem)
     * instead of explicit looping control structures.
     */
    public static int recursiveSum(int n) {
        updateRecursiveDisplay(n); // overhead for nice output, not required
        if (n == 1)                // if we're at the base case...
            return 1;              // then return the answer to the simplest problem which we know how to solve
        else                       // otherwise, we rely on the fact that sum( n ) = n + sum( n - 1 ) and keep recursing
            return (n + recursiveSum(n - 1));

        // for this method to terminate, we must be breaking the problem down into smaller
        // and smaller problems, until we reach the simplest form of the problem which we know
        // how to solve (in this case, it's the fact that sum( 1 ) == 1 )
    }

    //

    /**
     * The iterative counterpart to the above recursion. Notice how it's longer?
     * At times, an iterative solution may require more code than the recursive counterpart,
     * but, the recursive solution is slower and more memory intensive. We can always
     * recast recursion as iteration.
     */
    public static int iterativeSum(int i) {
        int total = 0;

        for (int n = i; n >= 1; n--) {
            updateIterativeDisplay(n);
            total = total + n;
        }
        return total;
    }

    public static void updateIterativeDisplay(int n) {
        count++;
        String text = myArea.getText();

        text += "\n/*******************Loop iteration " + count + "**************************************";
        text += "\n Calling iterativeSum( int n = " + n + " ). Total += " + n;
        text += "\n***************************************************************************/";

        myArea.setText(text);
    }

    // ignore this method unless interested in the output string
    public static void updateRecursiveDisplay(int n) {
        count++;
        String text = myArea.getText();

        if (count == 1) {
            text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
            text += "       CALL STACK IN MAIN MEMORY                ";
        }

        text += "\n/*******************Method invocation " + count + "*********************";

        text += "\n Calling recursiveSum( int n = " + n + " ). ";
        text += "\n The return statement from this function will resolve in " + (n - 1) + " more recursive method calls...";

        if (n != 1) {
            text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( " + (n - 1) + " ));";
        } else {
            text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
            text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
            text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
        }
        text += "\n***************************************************************************/";

        myArea.setText(text);
    }
    // Q1.1:
    public static int factorial(int n){ // Q1:
    if (n == 1) {
        return 1;
    } else {
        return (n * factorial(n-1));
        }
    }
    // Q2.1:
   public static int bruteForcePow(int x, int n){
        if (n == 0){
            return 1;
        } else {
            return x * bruteForcePow(x, n-1);
        }

   }
    // Q2.2:
    public static int optimizedPow(int x, int n){
        if (n == 0){
            return 1;
        } else if (n % 2 == 0) {
            return (optimizedPow(x, n/2) * optimizedPow(x, n/2));
        } else {
            return (x * optimizedPow(x, (n-1)/2) * optimizedPow(x, (n-1)/2));
        }
    }

    public static int fib(int n){
        if (n < 2){
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

}

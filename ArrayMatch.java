import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayMatch {


static boolean match(int[] a, int[] b) {

    int n = a.length; 

    if (n == 0) {
        return true;
    }
    

    if (n % 2 == 0) { 


        // if n is divisible by 2
        // divide a and b into two sub-arrays of equal size.
        int new_length = n/2;
        int[] a1 = new int[new_length];
        int[] a2 = new int[new_length];

        int[] b1 = new int[new_length];
        int[] b2 = new int[new_length];


        for (int i=0; i<new_length; i++) { 

            //fill new split arrays with values

            a1[i] = a[i];
            b1[i] = b[i];
            a2[i] = a[i+new_length];
            b2[i] = b[i+new_length];
            
        }
        
    
        boolean a1MatchesB1 = match(a1, b1);
        boolean a1MatchesB2 = match(a1, b2);

        boolean a2MatchesB1 = match(a2, b1);
        boolean a2MatchesB2 = match(a2, b2);
        
        if (a1MatchesB1 && a2MatchesB2) {
            return true;
        } else if (a1MatchesB1 && a1MatchesB2) {
            return true;
        } else if (a2MatchesB1 && a2MatchesB2) {
            return true;
        } else {
            return false;
        }

        //return (a1MatchesB1 && a2MatchesB2) || (a1MatchesB1 && a1MatchesB2) || (a2MatchesB1 && a2MatchesB2);

        

    } else { 
        // compare each element of both arrays

        // if any element is not equal in both arrays
        // return false, since the arrays are not equal, so condition 1 is not satisfied,
        // and condition 2 is not satisfied either, since n is not divisible by 2


        for (int i=0; i<n; i++) {
            //System.out.println(a[i]);
            //System.out.println(b[i]);
            if (a[i] != b[i]) {
                return false;
            }
        }

         
    }

    return true;
} 


public static void main(String[] args) {

    if (args.length < 1) {
        System.out.println("Error, please use java ArrayMatch filename.txt");
        System.exit(0);
    }

    try {

        Scanner testScanner = new Scanner(new FileInputStream(args[0]));
        int arraySize = testScanner.nextInt();
        //System.out.println("arraysize is "+ arraySize);
        int a[];
        int b[];
        
        if (arraySize == 0) {
            // if a & b are empty lists
            a = new int[0];
            b = new int[0];
        } else {

            testScanner.nextLine();
            String aElements = testScanner.nextLine();
            //System.out.println("aelements is " + aElements);
            String bElements = testScanner.nextLine();
            //System.out.println("belements is " + bElements);
            testScanner.close();

            
            String aStr[] = aElements.split(" ");
            String bStr[] = bElements.split(" ");
            a = new int[arraySize];
            b = new int[arraySize];
            
            for (int i=0; i<arraySize; i++) {
                a[i] = Integer.parseInt(aStr[i]);
                b[i] = Integer.parseInt(bStr[i]);

            }
        }    
        

        
        if (match(a, b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        
    

    } catch (FileNotFoundException e) {
        System.out.println("Error, please use an existing filename!");
    } catch (Exception e) {
        
    }
    
}

    
    
    
    
    
    


}



/*
 test cases:
 array with no elements
 array with one element 
 array with two elements
 array with a lot of elements (25-26 ish)
 array with negative elements
 array with all the same elements
 array with some duplicates

 even number of elements,
 array with even length
 array with odd length

 */
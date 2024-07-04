package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int count = 0; // count number of words
        String given[] = input.split(" "); // turning string into array ignoring spaces in the process
        for (int i = 0; i < given.length; i++) { // iterating through array
            if (given[i].trim().endsWith("y") || given[i].trim().endsWith("z")) // checks if words at index[i] ends with y or z
                count++; // increments if above is true
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        String input = base;
        input = input.replace(remove, "");
        return input;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int isCounter = 0;
        int notCounter = 0;
        for (int i = 1; i < input.length();i++){ // forloop to check consecutive letters matching is/not
            if (input.charAt(i-1) == 'i' && input.charAt(i)=='s'){ // logic for is
                isCounter++;
            }
            if (i >= 2 && input.charAt(i-2)=='n' && input.charAt(i-1)=='o' && input.charAt(i) == 't'){ // logic for not
                notCounter++;
            }
        }
        return (isCounter == notCounter);
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        boolean happy = false; // default false
        for(int i = 0; i < input.length(); i++){ // iterates through string
            if(input.charAt(i) == 'g'){ // at any point in time checks left and right
                if(input.charAt(i-1) == 'g' || input.charAt(i+1) == 'g'){
                    happy = true;
                }else {
                    happy = false;
                }
            }
        }
        return happy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int counter = 0;
        for (int i = 1; i < input.length()-1;i++){ // forloop going through 2 if statements to check for triplecount
            if (input.charAt(i) == input.charAt(i-1)){ // double counter, comparing left side
                if (input.charAt(i) == input.charAt(i+1)){ // triple counter, comparing right side
                    counter++;
                }
            }
        }
        return counter;
    }
}

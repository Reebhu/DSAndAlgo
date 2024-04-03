package String;

public class OneAway {
    /*There are 3 edits possible insert, replace and remove.
    FInd if two strings are 1 or 0 edit away.
    * */
    public static void main(String[] args) {
        String input1 = "pale";
        String input2 = "alp";
        System.out.println(isOneEditDistance(input1, input2));

    }

    static boolean isOneEditDistance(String first, String second) {

        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() > second.length() ? first : second;
        int index1 = 0;
        int index2 = 0;

        boolean found=false;
        while (index1 < first.length() && index2 < second.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2 || found) {
                    return false;
                }
                index2++;
                found = true;
                if(s1.length()==s2.length())
                {
                    index1++;
                }
            }
            else {
                index2++;
                index1++;
            }
        }
        return true;
    }
}

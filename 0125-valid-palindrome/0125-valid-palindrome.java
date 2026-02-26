class Solution {
    public boolean isPalindrome(String s) {
        String s1=s.toUpperCase();
        String s2=s1.replaceAll("[^A-Z0-9]", "");
        String s3=s2.replaceAll(" ","");
        String rev="";
        for(int i=s3.length()-1;i>=0;i--){
            rev = rev + s3.charAt(i);
        }

        return s3.equals(rev);
        
    }
}
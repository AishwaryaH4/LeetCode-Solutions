class Solution {
    public String makeLargestSpecial(String s) {
        if (s.isEmpty()) return s;
        
        List<String> mountains = new ArrayList<>();
        int count = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;
            
            if (count == 0) {
                String inner = s.substring(start + 1, i);
                mountains.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }
        
        Collections.sort(mountains, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String m : mountains) sb.append(m);
        return sb.toString();
    }
}
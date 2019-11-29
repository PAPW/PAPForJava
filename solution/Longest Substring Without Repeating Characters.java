class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        ArrayList list = new ArrayList();
        for(int a = 0; a < s.length(); a++){
            char ch = s.charAt(a);
            if(list.contains(ch)){
                if(list.size() > max){
                    max = list.size();    
                }
                int index = list.indexOf(ch);
                for(int b = 0; b <= index; b++){
                        list.remove(0);
                }
                list.add(ch);
            }else{
                list.add(ch);
            }  
        }
        if(list.size() > max){
            max = list.size();
        }
        return max;
    }
}
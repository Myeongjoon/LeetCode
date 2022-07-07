class Solution {
    String s1;
    String s2;
    String s3;
    int[][] map;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.map = new int[s1.length()][s2.length()];
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                this.map[i][j] = -1;
            }    
        }
        return dfs(0,0,0);
    }
    
    public boolean dfs(int left, int right,int current){
        if(left == this.s1.length() && right == this.s2.length()){
            return current == this.s3.length();
        }
        else if(current == this.s3.length()){
            return false;
        }
        else if(left == this.s1.length()){
            if(this.s3.charAt(current) == this.s2.charAt(right))
            {
                return dfs(left, right+1, current+1);
            }else{
                return false;
            }
        }
        else if(right == s2.length()){
            if(this.s3.charAt(current) == this.s1.charAt(left))
            {
                return dfs(left+1, right, current+1);
            }
            else{
                return false;
            }
        }
        else if(this.map[left][right] != -1){
            return this.map[left][right] == 1;
        }
        else{
            if(this.s3.charAt(current) == this.s1.charAt(left) && dfs(left+1, right, current+1))
            {
                this.map[left][right] = 1;
                return true;
            }
            
            if(this.s3.charAt(current) == this.s2.charAt(right) && dfs(left, right+1, current+1))
            {
                this.map[left][right] = 1;
                return true;
            }
            
            this.map[left][right] = 0;
            return false;
        }
    }
}
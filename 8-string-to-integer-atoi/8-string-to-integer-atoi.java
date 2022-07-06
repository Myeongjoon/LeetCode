class Solution {
    public int myAtoi(String s) {
        int response = 0;
        int is_minus = -1;
        int is_digit = 0;
        boolean is_leading_space = true;
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            if(s.charAt(i) == '-' && is_minus == -1 && is_digit == 0){
                is_minus = 1;
                is_leading_space = false;
            }
            else if(s.charAt(i) == '+' && is_minus == -1 && is_digit == 0){
                is_minus = 0;
                is_leading_space = false;
                continue;
            }
            else if(current >= '0' && current <='9'){
                is_digit = 1;
                is_leading_space = false;
                int digit = current - '0';
                
                // Check overflow and underflow conditions. 
                if ((response > Integer.MAX_VALUE / 10) || 
                    (response == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {      
                    return (is_minus != 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                response *=10;
                response = response + digit ;
                
            }
            else if(current == ' ' && is_digit == 0){
                if(is_leading_space){
                    continue;
                }else{
                    break;
                }
            }
            else{
                break;
            }
            
        }
        if(is_minus == 1){
            return -1* response;
        }
        return response;
    }
}
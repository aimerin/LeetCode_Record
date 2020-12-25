package digit.q258_add_digits;

public class Solution {
    public int addDigits(int num) {
        int re=0;
        while(true){
            while(num!=0){
                re+=num%10;
                num=num/10;
            }
            if(re<10){
                break;
            }else{
                num=re;
                re=0;
            }
        }
        return re;
    }
    public int addDigits2(int num) {
        if (num > 9) {
            num=num%9;
            if(num==0)
                return 9;
        }
        return num;
    }
}

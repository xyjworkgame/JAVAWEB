

import java.util.List;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-15-23:51
 */
public class A {
    public void cc (char[] str,int cal){
        for (int i = 0;i<=cal;i++) {
            char temp = str[str.length - 1];
            for (int j = 1; j < str.length; ++j) {

                str[str.length - j] = str[str.length - j - 1];
            }
            str[0] = temp;
        }
        for (char s : str) {
            System.out.print(s);
        }
    }
    public static void rotateString(char[] str, int offset) {
        // write your code here

        /*
           int temp = str[str.length];
                6-5
                5-4
                4-3
                3-2
                2-1
                1-0
       temp = str[0];
         */

        if (str.length == 0){
            return;
        }else  if (offset >= str.length){
            int cal = offset % str.length;

            for (int i = 0;i<cal;i++) {
                char temp = str[str.length - 1];
                for (int j = 1; j < str.length; ++j) {

                    str[str.length - j] = str[str.length - j - 1];
                }
                str[0] = temp;
            }
            for (char s : str) {
                System.out.print(s);
            }
        }else {

            for (int i = 0;i<offset;i++) {
                char temp = str[str.length - 1];
                for (int j = 1; j < str.length; ++j) {

                    str[str.length - j] = str[str.length - j - 1];
                }
                str[0] = temp;
            }
            for (char s : str) {
                System.out.print(s);
            }
        }





    }
    public List<String> fizzBuzz(int n) {


        // write your code here
        return null;
    }

    public static void main(String[] args) {
        char[] str = {'a','b','c','d','e','f','g'};


        A.rotateString(str,4);
    }
}

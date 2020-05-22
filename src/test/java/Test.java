import com.nove.shbtp.dao.UserDao;
import com.nove.shbtp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;

public class Test {

    @org.junit.Test
    public void test(){
        ISBNUtil isbnUtil = new ISBNUtil();
        System.out.println(isbnUtil.testISBN("9787802139008"));
    }



    public class ISBNUtil {
        public  boolean testISBN(String ISBN){

            if(Pattern.matches("^\\d{10}$",ISBN)){
                int sum=0;
                int y=10;
                for(int i=0;i<9;i++){
                    int x = Integer.valueOf(""+ISBN.charAt(i));
                    sum+=x*y--;
                }
                int m = sum%11;
                int n=11-m;
                if(n==Integer.valueOf(""+ISBN.charAt(9))){
                    return true;
                }
                return false;
            }
            if(Pattern.matches("^\\d{13}$",ISBN)){
                int sum=0;
                for(int i=0;i<12;i++){
                    int x = Integer.valueOf(""+ISBN.charAt(i));
                    System.out.println("x"+x);
                    if((i+1)%2==1){
                        sum+=x;
                    }else{
                        sum+=x*3;
                    }
                }
                int m = sum%10;
                int n=10-m;
                if(n==Integer.valueOf(""+ISBN.charAt(12))){
                    return true;
                }
                return false;
            }

            return false;
        }
    }
}

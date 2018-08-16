
import com.caesar.Caesar;

public class TestCaesar {
    
    public static void main(String[] args) {
        Caesar c = new Caesar("Hola Mundo", 3);
        System.out.println(c.caesarEncrypt());
        //System.out.println(c.caesarDecrypt());
    }
    
}

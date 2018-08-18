
import com.caesar.Caesar;

public class TestCaesar {

    public static void main(String[] args) {
        Caesar c = new Caesar("KLMNOPQRSTUVWXYZABCDEFGHIJ", 10);
        System.out.println(c.caesarDecrypt());
    }

}


import com.caesar.Caesar;

public class TestCaesar {

    public static void main(String[] args) {
        Caesar c = new Caesar("DEFGHIJKLMNOPQRSTUVWXYZABC", 3);
        System.out.println(c.caesarDecrypt());
    }

}

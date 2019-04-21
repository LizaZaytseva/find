import org.junit.Test;

import com.lizazaitseva.find.Main;

import static com.lizazaitseva.find.Main.main;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FindTests {
    @Test
    public void find(){
        String[] args = {"-r", "-d", "C:\\Users\\lizar\\Documents\\tests", "test4.txt"};
        main(args);
        String result = "C:\\Users\\lizar\\Documents\\tests\\prog2\\test4.txt";
    }
}

package atmMachine.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.InflaterInputStream;

public class Screen {
    public boolean showMessage(String message) {
        System.out.println(message);
        return true;
    }

    public TransactionType getTransactionType() throws IOException {
        Keyboard keyboard = new Keyboard();
        String input = keyboard.getInput();
        return TransactionType.valueOf(input);
    }
}

package atmMachine.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard {
    public String getInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        return input;
    }

    public boolean getValidInput() throws IOException {
        System.out.println("Enter Y to progress or N to abort");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        if(input.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }
}
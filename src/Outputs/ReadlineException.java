package Outputs;

import java.io.IOException;

public class ReadlineException extends IOException {
    public ReadlineException(){
        super("Error: Cannot read line!");
    }
}

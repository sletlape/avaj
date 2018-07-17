package Outputs;

public class ParseToIntException extends Exception {
    public ParseToIntException(){
        super("Cannot convert line content to int");
    }
}

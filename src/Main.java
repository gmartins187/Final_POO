import EnumClasses.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Commands();
        int i;
    }

    private static void Commands() {
        Scanner in = new Scanner(System.in);
        String command;
        do{
            command = in.next();
        }while (!command.equals(commands.EXIT.command));
        in.close();
    }
}

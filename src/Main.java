import EnumClasses.*;
import java.util.Scanner;

/**
 * @author Andre Amante 70945 a.amante@campus.fct.unl
 * @author Guilherme Martins 71003 gh.martins@campus.fct.unl
 */

public class Main {


    public static void main(String[] args) {
        Commands();
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

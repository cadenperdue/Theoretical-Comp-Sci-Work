import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ModMachine {
    private final static int[][] STATE_TABLE = {
        { 2, 4, 5 },
        { 3, 1, 5 },
        { 4, 2, 5 },
        { 1, 3, 5 },
        { 5, 5, 5 }
    };

    private BufferedReader in;


    public ModMachine() {
        in = new BufferedReader(
                 new InputStreamReader(System.in));
    }


    public void run() throws IOException {
        char ch;
        int  state;

        for (;;) {
            System.out.print("Enter your string: ");
            ch    = (char) in.read();
            state = 0;

            while (ch != '\n') {
               state = STATE_TABLE[state][charToColumn(ch)];
               ch    = (char) in.read();
            }

            if (state == 1) {
                System.out.println("Accept\n");
            } else {
                System.out.println("Reject\n");
            }
        }
    }



    public int charToColumn(char ch) {
        int column = 2;

        switch( ch ) {
        case 'a':
            column = 0;
            break;

        case 'b':
            column = 1;
            break;
        }

        return column;
    }


    public static void main(String[] args) {
        try {
            ModMachine mm = new ModMachine();
            mm.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}

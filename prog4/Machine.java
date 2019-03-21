import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Machine {
    private final static int[][] STATE_TABLE = {
        {  1,  2,  3 },
        {  4,  6,  5 },
        {  6,  5,  4 },
        {  5,  4,  6 },
        {  4,  6,  5 },
        {  6,  5,  4 },
        {  5,  4,  6 }
    };

    private BufferedReader in;


    public Machine() {
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

            if (state == 4) {
                System.out.println("1\n");
            }
            else if (state == 5) {
                System.out.println("4\n");
            }
            else if (state == 6){
                System.out.println("9\n");
            }
            else{
                System.out.println("Invalid input\n");
            }
        }
    }



    public int charToColumn(char ch) {
        int column = 3;

        switch( ch ) {
        case '1':
            column = 0;
            break;

        case '4':
            column = 1;
            break;

        case '9':
            column = 2;
            break;
        }

        return column;
    }


    public static void main(String[] args) {
        try {
            Machine fsm = new Machine();
            fsm.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}


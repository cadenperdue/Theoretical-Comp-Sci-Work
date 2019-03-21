import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FiniteStateMachine {
    private final static int[][] STATE_TABLE = {
        {  1,  5, 11 }, //0
        {  2,  5, 11 }, //1
        {  3,  5, 11 }, //2
        {  3,  4, 11 }, //3
        {  10, 8, 11 }, //4
        {  6,  8, 11 }, //5
        {  2,  7, 11 }, //6
        { 10,  8, 11 }, //7
        {  6,  9, 11 }, //8
        {  6, 10, 11 }, //9
        { 10, 10, 11 }, //10
        { 11, 11, 11 }  //11
    };

    private BufferedReader in;


    public FiniteStateMachine() {
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

            if (state == 10) {
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
            FiniteStateMachine fsm = new FiniteStateMachine();
            fsm.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}

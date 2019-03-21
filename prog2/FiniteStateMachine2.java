import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FiniteStateMachine2 {

    // State Table
    private final static int [][] STATE_TABLE =
    {

        // e,  l,  o,  r,  s,  v,  other
        {  0,  1,  6,  0, 10, 19,  0},  // State 0
        {  0,  1,  2,  0, 10, 19,  0},  // State 1
        {  0,  1,  6,  0,  3,  7,  0},  // State 2
        {  4,  4, 15,  0, 10, 19,  0},  // State 3
        {  0,  1,  6,  5, 10, 19,  0},  // State 4
        { 12,  1,  6,  0, 10, 13,  0},  // State 5
        {  0,  1,  6,  0, 10,  7,  0},  // State 6
        {  8,  1, 20,  0, 10, 19,  0},  // State 7
        {  0,  1,  6,  9, 10, 19,  0},  // State 8
        {  0,  1,  6,  0, 10, 19,  0},  // State 9
        { 11,  1, 15,  0, 10, 19,  0},  // State 10
        {  0,  1,  6, 12, 10, 19,  0},  // State 11
        {  0,  1,  6,  0, 10, 13,  0},  // State 12
        {  0,  1, 14,  0, 10, 19,  0},  // State 13
        {  0, 21,  6,  0, 10,  7,  0},  // State 14
        {  0, 16,  6,  0, 10,  7,  0},  // State 15
        {  0,  1,  2,  0, 10, 17,  0},  // State 16
        { 18,  1, 20,  0, 10, 19,  0},  // State 17
        {  0,  1,  6,  0, 10, 19,  0},  // State 18
        {  0,  1, 20,  0, 10, 19,  0},  // State 19
        {  0, 21,  6,  0, 10,  7,  0},  // State 20
        { 22,  1,  2,  0, 10, 19,  0},  // State 21
        {  0,  1,  6,  0, 23, 19,  0},  // State 22 
        { 11,  1,  15, 0, 10, 19,  0}   // State 23
    };

    // Table constants
    private final static int e_COLUMN   = 0;
    private final static int l_COLUMN   = 1;
    private final static int o_COLUMN   = 2;
    private final static int r_COLUMN   = 3;
    private final static int s_COLUMN   = 4;
    private final static int v_COLUMN   = 5;
    private final static int ERR_COLUMN = 6;

    // Special states
    private final static int START = 0;
    private final static int loser_ACCEPT =  5;
    private final static int over_ACCEPT  =  9;
    private final static int servo_ACCEPT = 14;
    private final static int solve_ACCEPT = 18;
    private final static int voles_ACCEPT = 23;



    private BufferedReader in;


    public FiniteStateMachine2() {
        in = new BufferedReader(
                 new InputStreamReader(System.in));
    }


    public void run() throws IOException {
        int input;
        int state;
        int loserCount = 0;
        int overCount  = 0;
        int servoCount = 0;
        int solveCount = 0;
        int volesCount = 0;


        input = in.read();
        state = START;
            
        while (input != -1) {
           char ch = (char) input;
           state = STATE_TABLE[state][charToColumn(ch)];
           input = in.read();
           if( state == loser_ACCEPT)
               loserCount++;
           else if( state == over_ACCEPT)
               overCount++;
           else if( state == servo_ACCEPT)
               servoCount++;
           else if( state == solve_ACCEPT)
               solveCount++;
           else if( state == voles_ACCEPT)
               volesCount++;
        }

        // display counts
        System.out.println("Occurrence counts:");
        System.out.println("loser: " + loserCount);
        System.out.println("over: "  + overCount);
        System.out.println("servo: " + servoCount);
        System.out.println("solve: " + solveCount);
        System.out.println("voles: " + volesCount);
    }


    public int charToColumn(char ch) {
        int column = ERR_COLUMN;

        switch( ch ) {
        case 'e':
            column = e_COLUMN;
            break;
        case 'l':
            column = l_COLUMN;
            break;
        case 'o':
            column = o_COLUMN;
            break;

        case 'r':
            column = r_COLUMN;
            break;
        case 's':
            column = s_COLUMN;
            break;
        case 'v':
            column = v_COLUMN;
            break;
        }

        return column;
    }


    public static void main(String[] args) {
        try {
            FiniteStateMachine2 fsm = new FiniteStateMachine2();
            fsm.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}




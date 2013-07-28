import java.util.Scanner;
public class Game {

    private boolean checkRules(Field field){

        boolean checkX = true;
        boolean checkO = true;

        //check vertical lines:
        for(int i = 0; i < Field.FIELD_SIZE; i++){
            for(int j = 0; j < Field.FIELD_SIZE; j++){
                if (field.getFieldCell(i,j) != 'X') checkX = false;
                if (field.getFieldCell(i,j) != 'O') checkO = false;
            }
            if (checkO || checkX) {
                System.out.println( checkX ? "\nX won!" : "\nO won!");
                return true;
            }
            else{
                checkO = true;
                checkX = true;
            }
        }

        //check horizontal lines:
        for(int i = 0; i < Field.FIELD_SIZE; i++){
            for(int j = 0; j < Field.FIELD_SIZE; j++){
                if (field.getFieldCell(j,i) != 'X') checkX = false;
                if (field.getFieldCell(j,i) != 'O') checkO = false;
            }
            if (checkO || checkX) {
                System.out.println( checkX ? "\n\"X\" won!" : "\n\"O\" won!");
                return true;
            }
            else{
                checkO = true;
                checkX = true;
            }
        }

        //check diagonals:
        for(int i = 0; i < Field.FIELD_SIZE; i++){
            if (field.getFieldCell(i,i) != 'X') checkX = false;
            if (field.getFieldCell(i,i) != 'O') checkO = false;
        }
        if (checkO || checkX) {
            System.out.println( checkX ? "\nX won!" : "\nO won!");
            return true;
        }
        else {
            checkO = true;
            checkX = true;
            for(int i = 0; i < Field.FIELD_SIZE; i++){
                if (field.getFieldCell(i,Field.FIELD_SIZE - 1 - i) != 'X') checkX = false;
                if (field.getFieldCell(i,Field.FIELD_SIZE - 1 - i) != 'O') checkO = false;
            }
            if (checkO || checkX) {
                System.out.println( checkX ? "\nX won!" : "\nO won!");
                return true;
            }

            //check for tie:
            for(int i = 0; i < Field.FIELD_SIZE; i++){
                for(int j = 0; j < Field.FIELD_SIZE; j++){
                    if (field.getFieldCell(i,j) == ' '){
                        return false;
                    }
                }
            }

            System.out.println("Tie!");
            return true;

        }

    }

    public void startGame(Field field){
        int x = 0;
        int y = 0;
        field.clearField();
        field.showField();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter x and y for ");
            System.out.print(field.cross ? "\"X\":\n" : "\"O\":\n");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            if (field.getFieldCell(x,y) == ' ') {
                field.setFieldCell(x,y);
            }
            field.showField();
            if (checkRules(field)) break;
        }
    }

}

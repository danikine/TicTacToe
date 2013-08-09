import java.util.Scanner;
public class Game {

    private boolean checkRules(Field field){

        boolean checkX = true;
        boolean checkO = true;

        //могу ошибаться, но с первого взгляда это обход по горизонталям
        //0,0   0,1  0,2,  1,0   1,1  1,2...
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

        //а это наоброт по вертикалям 0,0  1,0  2,0....
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

            //тут, я понимаю Вы ищете незаполненную клетку, и если находите то получается что ничья
            // возможно имеет смысле сделать две логические переменные  boolean cross = false и boolean nought = false
            //и в предыдущих циклах проверки устанавливать одну из них в true, а тут проверять если ни одна из них не true
            //то ничья, приврно так
            //if(!cross && !nought)
                //System.out.println("Tie!");
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
            //вот тут можете добавить проверку на ввод не числа (буква, например, или еще какой либо символ)
            //посмотрите функцию sc.hasNextInt(), с ее помощью можно реализоват проверку
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            //вот тут можно будет вызывать field.getFieldCell(x,y, 'X')
            if (field.getFieldCell(x,y) == ' ') {
                field.setFieldCell(x,y);
            }
            field.showField();
            if (checkRules(field)) break;
        }
    }

}

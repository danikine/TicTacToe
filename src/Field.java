public class Field {

    public static final int FIELD_SIZE = 3;

    private char [][] cell = new char [FIELD_SIZE][FIELD_SIZE];//можно сделать private

    public boolean cross = true; //лучше бы сделать это поле private, добавить getter и setter

    private void clearLine(int line){
        for(int i = 0; i < FIELD_SIZE; i++){
            cell[line][i] = ' ';
            //сделать тут  константу типа static final char DEFAULT_CELL_VALUE = ' '  ??
        }
    }

    private void showLine(int line){
        //в этом месте мы знаем количество строк в строке,, можем сдеать цикл
        //это будет удобнее когда будем менять размерность поля
        //for(int i = 0; i < FIELD_SIZE; i++)
        //    System.out.println(cell[i][line]);
        System.out.println(cell[0][line] + " " + cell[1][line] + " " + cell[2][line]);
    }

    public void clearField(){
        for(int i = 0; i < FIELD_SIZE; i++){
            clearLine(i);
        }
    }

    //возможно вместо флага  cross лучше передавать в функию параметр char 'X' или char 'O'
    // можно будет избавиться от лишней переменной и вызывать функий можно будет field.getFieldCell(x,y, 'X')
    //функцию тогда надо будет объявить  public void setFieldCell(int x, int y, char symbol)
    public void setFieldCell(int x, int y){
        if (x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE){
            if (cross) {
                cell[x][y] = 'X';
            }
            else {
                cell[x][y] = 'O';
            }
        }
        cross = !cross; //тут определяется крестик сейчас ходит или нолик верно?
    }



    public char getFieldCell(int x, int y) {
        if (x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE){
            return cell[x][y];
        }
        else {
            return 0;
        }
    }

    public void showField(){
        System.out.print(" ");
        for (int i = 0; i < FIELD_SIZE; i++){
            int j = i + 1;
            System.out.print(" " + j);
        }
        System.out.println();
        for (int i = 0; i < FIELD_SIZE; i++){
            int j = i + 1;
            System.out.print(j + " ");
            showLine(i);
        }
    }

}

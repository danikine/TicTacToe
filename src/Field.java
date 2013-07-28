public class Field {

    public static final int FIELD_SIZE = 3;

    private char [][] cell = new char [FIELD_SIZE][FIELD_SIZE];

    public boolean cross = true;

    private void clearLine(int line){
        for(int i = 0; i < FIELD_SIZE; i++){
            cell[line][i] = ' ';
        }
    }

    private void showLine(int line){
        System.out.println(cell[0][line] + " " + cell[1][line] + " " + cell[2][line]);
    }

    public void clearField(){
        for(int i = 0; i < FIELD_SIZE; i++){
            clearLine(i);
        }
    }

    public void setFieldCell(int x, int y){
        if (x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE){
            if (cross) {
                cell[x][y] = 'X';
            }
            else {
                cell[x][y] = 'O';
            }
        }
        cross = !cross;
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

//Class ‘Board’ manages 3*3 board, checks for a winner and detects a draw.
import java.util.ArrayList;
import java.util.List;

public class Board{
    private char[][] cells=new char[3][3];

    public Board(){
        reset();
    }

    public void reset(){
        for(int i=0; i<3;i++){
            for(int j=0; j <3; j++){
                cells[i][j]=' ';
            }
        }
    }

    public boolean makeMove(int row, int col, char symbol){
        if(row<0||row>=3||col<0||col>=3||cells[row][col]!=' '){
            return false;
        }
        cells[row][col]=symbol;
        return true;
    }

    public char getCell(int row, int col){
        return cells[row][col];
    }

    public boolean hasWinner(char s){
        for(int i=0; i<3; i++){
            if(cells[i][0]==s && cells[i][1]==s && cells[i][2]==s){
                return true;
            }
            if(cells[0][i]==s&& cells[1][i]==s && cells[2][i]==s){
                return true;
            }
        }
        return (cells[0][0]==s&& cells[1][1]==s && cells[2][2]==s)||(cells[0][2]==s && cells[1][1]==s && cells[2][0]==s);
    }

    public boolean isFull(){
        for(int i=0; i<3; i++){
            for (int j=0;j<3;j++){
                if(cells[i][j]== ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] getEmptyCells(){
        List<int[]> empty= new ArrayList<>();
        for(int i=0;i<3;i++){
            for(int j=0; j<3; j++){
                if(cells[i][j]==' '){
                    empty.add(new int[]{i,j});
                }
            }
        }
        return empty.toArray(new int[0][]);
    }
}

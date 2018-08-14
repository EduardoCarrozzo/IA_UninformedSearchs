package environment.eightpuzzle;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Carlos A. Casanova P.
 */
public class EightPuzzle {
    
    private int[][] puzzle = new int[3][3];
    private int x, y;

    /**
     *
     * @param puzzle
     */
    public EightPuzzle(int[][] puzzle) {
        if(puzzle.length != 3 || puzzle[0].length != 3){
            throw new IllegalArgumentException("Puzzle size must be 3x3");
        }
        Set<Integer> enteros = new HashSet<>(9);
        for(int i = 0; i < 9; i++) 
            enteros.add(i);
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(puzzle[i][j] < 0 || puzzle[i][j] > 8){
                    throw new IllegalArgumentException("Puzzle elements are integers in range [0, 8]");
                }
                else if(puzzle[i][j] == 0){
                    this.x = i;
                    this.y = j;
                }
                if(!enteros.contains(puzzle[i][j]))
                    throw new IllegalArgumentException("Puzzle elements must be unique");
                enteros.remove(puzzle[i][j]);
            }
        }
        this.puzzle = puzzle;
    }

    /**
     *
     * @param anotherPuzzle
     */
    public EightPuzzle(EightPuzzle anotherPuzzle) {
        this.puzzle = anotherPuzzle.puzzle;
        this.x = anotherPuzzle.x;
        this.y = anotherPuzzle.y;
    }
    
    /**
     *
     */
    public void moveBlankRight(){
        if(y == 2) throw new IllegalStateException("Blank is already on top right");
        this.puzzle[x][y] = this.puzzle[x][y+1];
        this.puzzle[x][y+1] = 0;
    }
    
    /**
     *
     */
    public void moveBlankLeft(){
        if(y == 0) throw new IllegalStateException("Blank is already on top left");
        this.puzzle[x][y] = this.puzzle[x][y-1];
        this.puzzle[x][y-1] = 0;
    }
    
    /**
     *
     */
    public void moveBlankUp(){
        if(x == 0) throw new IllegalStateException("Blank is already on top");
        this.puzzle[x][y] = this.puzzle[x-1][y];
        this.puzzle[x-1][y] = 0;
    }
    
    /**
     *
     */
    public void moveBlankDown(){
        if(x == 2) throw new IllegalStateException("Blank is already on bottom");
        this.puzzle[x][y] = this.puzzle[x+1][y];
        this.puzzle[x+1][y] = 0;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String result = "";
        for(int[] fila: this.puzzle){
            for(int elemento: fila){
                result = result.concat(String.valueOf(elemento)).concat(" ");
            }
            result = result.concat("\n");
        }
        return result;
    }
    
    /**
     *
     * @return
     */
    public static EightPuzzle getCorrectPuzzle(){
        int[][] correctPuzzle = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        return new EightPuzzle(correctPuzzle);
    }
    
}

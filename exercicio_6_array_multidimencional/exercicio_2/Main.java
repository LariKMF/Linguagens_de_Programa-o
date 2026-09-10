
public class Main {
    public static void main(String[] args) {
        int[][] numbers = {
            {5,9,3},
            {6,9,8,7,6}
        };
        for(int[] line : numbers) {
            for(int colum : line) {
                System.out.println(colum);
            }
        }
    }
    
}

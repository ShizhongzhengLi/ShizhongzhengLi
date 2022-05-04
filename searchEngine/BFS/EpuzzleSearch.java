package searchEngine.BFS;

public class EpuzzleSearch extends Search {


    private int[][] fin;



    public EpuzzleSearch(int[][] fin) {
        this.fin = fin;
    }//get final state


    public int[][] getFin() {
        return fin;
    }
}
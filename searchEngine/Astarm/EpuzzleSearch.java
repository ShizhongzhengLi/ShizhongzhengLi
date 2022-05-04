package searchEngine.Astarm;

public class EpuzzleSearch extends Search {


    private int[][] fin;



    public EpuzzleSearch(int[][] fin) {
        this.fin = fin;
    }


    public int[][] getFin() {
        return fin;
    }
}
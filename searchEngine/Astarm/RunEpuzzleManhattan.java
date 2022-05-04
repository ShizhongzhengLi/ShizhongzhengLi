package searchEngine.Astarm;

public class RunEpuzzleManhattan {

  public static void main(String[] arg) {


	EpuzzGen eG = new EpuzzGen();
	int seed = 1112;
	EpuzzGen gen = new EpuzzGen(seed);
	int dif = 7;
	int g = 1;
	int intl[][] = gen.puzzGen(dif);
	int finl[][] = {{1,2,3},{4,5,6},{7,8,0}};
	int d = 0;
    int si = 0;
    int sj = 0;
    for(int n = 0; n <= 8; ++n) {
       int i;
       int j;
       for(i = 0; i <= 2; ++i) {
          for(j = 0; j <= 2; ++j) {
             if (intl[i][j] == n) {
                si = i;
                sj = j;
             }
          }
       }

       for(i = 0; i <= 2; ++i) {
          for(j = 0; j <= 2; ++j) {
             if (finl[i][j] == n) {
                d = d + Math.abs(i - si) + Math.abs(j - sj);
             }
          }
       }
    }

    
	
    EpuzzleSearch searcher = new EpuzzleSearch(finl);

    SearchState initState = (SearchState) new EpuzzleState(intl,g,d);

    String res = searcher.runSearch(initState,"Astar");

    
    System.out.println(res);
  }
}

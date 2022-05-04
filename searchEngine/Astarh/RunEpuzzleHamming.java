package searchEngine.Astarh;

public class RunEpuzzleHamming {

  public static void main(String[] arg) {

	EpuzzGen eG = new EpuzzGen();
	int seed = 1111;
	EpuzzGen gen = new EpuzzGen(seed);
	int dif = 12;
	int g = 1;
	int intl[][] = gen.puzzGen(dif);
	int finl[][] = {{1,2,3},{4,5,6},{7,8,0}};
	int all = 0;
	for (int count = 0;count < 3;count++) {
    	for (int count2 = 0;count2 < 3;count2++) {
    	    if (intl[count][count2] !=finl[count][count2]) all +=1;
    	}
    }
	
    EpuzzleSearch searcher = new EpuzzleSearch(finl);

    SearchState initState = (SearchState) new EpuzzleState(intl,g,all);

    String res = searcher.runSearch(initState,"Astar");


    System.out.println(res);
  }
}

package searchEngine.BFS;

public class RunEpuzzleBFS {

  public static void main(String[] arg) {


	int intl[][] = {{5,1,2},{3,6,0},{7,4,8}};
	int finl[][] = {{1,2,3},{4,5,6},{7,8,0}};
    EpuzzleSearch searcher = new EpuzzleSearch(finl);

    SearchState initState = (SearchState) new EpuzzleState(intl);

    String res = searcher.runSearch(initState,"breadthFirst");


    System.out.println(res);
  }
}

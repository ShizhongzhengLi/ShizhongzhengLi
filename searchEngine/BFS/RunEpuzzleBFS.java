package searchEngine.BFS;

public class RunEpuzzleBFS {

  public static void main(String[] arg) {


	int intl[][] = {{2,1,6},{7,4,0},{5,8,3}};//give a value to initial state
	int finl[][] = {{1,2,3},{4,5,6},{7,8,0}};//set final state
    EpuzzleSearch searcher = new EpuzzleSearch(finl);

    SearchState initState = (SearchState) new EpuzzleState(intl);//set initial state

    String res = searcher.runSearch(initState,"breadthFirst");//run


    System.out.println(res);
  }
}

package searchEngine.BFS;

import java.util.*;

public class EpuzzleState extends SearchState {

  private int[][] intl = new int[3][3]; 


  public EpuzzleState(int[][] ints) {

	intl = ints;
  }



  public int[][] getIntl() {
    return intl;
  };




  public boolean goalPredicate(Search searcher) {
	EpuzzleSearch EpuzzleSearcher = (EpuzzleSearch) searcher;
    int[][] finalL = EpuzzleSearcher.getFin(); 
    boolean same = true;
    for (int count = 0;count < 3;count++) {
    	for (int count2 = 0;count2 < 3;count2++) {
    		
    		if (intl[count][count2]!=finalL[count][count2]) {
    			same = false;
    	    }
    		
    	}
    }
    if (same){
       return true;
    }
    else return false;
  }


  public ArrayList<SearchState> getSuccessors(Search searcher) {

    
    int space1 = 0;
    int space2 = 0;
    
    for (int count = 0;count < 3;count++) {
  	  for (int count2 = 0;count2 < 3;count2++) {
  		
  		if (intl[count][count2]==0) {
  		   space1 = count;
  		   space2 = count2;
  		}
  		
  	  }
  	}

    ArrayList<EpuzzleState> EpuzzleStatesList = new ArrayList<EpuzzleState>(); 
    ArrayList<SearchState> searchStatesList = new ArrayList<SearchState>(); 
    EpuzzleState  es = new EpuzzleState(intl);
    int[][]backUp = es.getIntl().clone();
    
    if (space1 + 1 <= 2) {
    	
      int [][] bu = new int[3][3];
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 3; j++)
              bu[i][j] = backUp[i][j];
      bu[space1][space2] = bu[space1 + 1][space2];
      bu[space1 + 1][space2] = 0;
      
      EpuzzleStatesList.add(new EpuzzleState(bu));
      
      
    } 
    
    
    if (space2 + 1 <= 2) {
    	int [][] bu2 = new int[3][3];
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 3; j++)
              bu2[i][j] = backUp[i][j];
    	bu2[space1][space2] = bu2[space1][space2 + 1];
        bu2[space1][space2 + 1] = 0;
        EpuzzleStatesList.add(new EpuzzleState(bu2));
        
        
    }
    
    if (space1 - 1 >= 0) {
    	int [][] bu3 = new int[3][3];
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 3; j++)
              bu3[i][j] = backUp[i][j];
    	bu3[space1][space2] = bu3[space1 - 1][space2];
        bu3[space1 - 1][space2] = 0;
        EpuzzleStatesList.add(new EpuzzleState(bu3));
        
   	}
    
    if (space2 - 1 >= 0) {
    	int [][] bu4 = new int[3][3];
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 3; j++)
              bu4[i][j] = backUp[i][j];
    	bu4[space1][space2] = bu4[space1][space2 - 1];
        bu4[space1][space2 - 1] = 0;
        EpuzzleStatesList.add(new EpuzzleState(bu4)); 
                

    }
    
    

    for (EpuzzleState che : EpuzzleStatesList) {
      searchStatesList.add((SearchState)che);
    }
    return searchStatesList;
  }


  public boolean sameState(SearchState stpast) {
		EpuzzleState pastS = (EpuzzleState) stpast;
		int pS[][] =pastS.getIntl();
		boolean same = true;
	    for (int count = 0;count < 3;count++) {
	    	for (int count2 = 0;count2 < 3;count2++) {
	    		
	    		if (intl[count][count2]!=pS[count][count2]) {
	    			same = false;
	    	    }
	    		
	    	}
	    }
	    return same;
  }



  public String toString() {
	String re = ""; 
	for (int count = 0;count < 3 ;count++) {
	  for (int count2 = 0;count2 < 3;count2++) {
		re = re + intl[count][count2] + " ";
	  }
	  re = re + "/";
	}
    return re;
  }

}

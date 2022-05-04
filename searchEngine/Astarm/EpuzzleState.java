package searchEngine.Astarm;

import java.util.*;

public class EpuzzleState extends SearchState {

  private int[][] intl = new int[3][3]; 


  public EpuzzleState(int[][] ints, int lc, int erc) {

	intl = ints;
	localCost=lc;
    estRemCost=erc;
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
  }//set weather the current state equal to final state


  public ArrayList<SearchState> getSuccessors(Search searcher) {

    
    int space1 = 0;
    int space2 = 0;
    int[][]finl = {{1,2,3},{4,5,6},{7,8,0}};
    for (int count = 0;count < 3;count++) {
  	  for (int count2 = 0;count2 < 3;count2++) {
  		
  		if (intl[count][count2]==0) {
  		   space1 = count;
  		   space2 = count2;
  		}
  		
  	  }
  	}//set where is the space

    ArrayList<EpuzzleState> EpuzzleStatesList = new ArrayList<EpuzzleState>(); 
    ArrayList<SearchState> searchStatesList = new ArrayList<SearchState>(); 
    EpuzzleState  es = new EpuzzleState(intl, localCost, estRemCost);
    int[][]backUp = es.getIntl().clone();
    
    if (space1 + 1 <= 2) {
      int [][] bu = new int[3][3];
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 3; j++) bu[i][j] = backUp[i][j];    
      bu[space1][space2] = bu[space1 + 1][space2];
      bu[space1 + 1][space2] = 0;
      int d = 0;
      int si = 0;
      int sj = 0;
      for(int n = 0; n <= 8; ++n) {
         int i;
         int j;
         for(i = 0; i <= 2; ++i) {
            for(j = 0; j <= 2; ++j) {
               if (bu[i][j] == n) {
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
      
      EpuzzleStatesList.add(new EpuzzleState(bu,localCost,d));
      
      
    } //space move to right
    
    
    if (space2 + 1 <= 2) {

    	int [][] bu2 = new int[3][3];
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 3; j++)
                bu2[i][j] = backUp[i][j];

    	bu2[space1][space2] = bu2[space1][space2 + 1];
        bu2[space1][space2 + 1] = 0;
        int d = 0;
        int si = 0;
        int sj = 0;
        for(int n = 0; n <= 8; ++n) {
           int i;
           int j;
           for(i = 0; i <= 2; ++i) {
              for(j = 0; j <= 2; ++j) {
                 if (bu2[i][j] == n) {
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
        EpuzzleStatesList.add(new EpuzzleState(bu2,localCost,d));
        
        
    }//space move down
    
    if (space1 - 1 >= 0) {
    	int [][] bu3 = new int[3][3];
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 3; j++)
                bu3[i][j] = backUp[i][j];

    	bu3[space1][space2] = bu3[space1 - 1][space2];
        bu3[space1 - 1][space2] = 0;
        int d = 0;
        int si = 0;
        int sj = 0;
        for(int n = 0; n <= 8; ++n) {
           int i;
           int j;
           for(i = 0; i <= 2; ++i) {
              for(j = 0; j <= 2; ++j) {
                 if (bu3[i][j] == n) {
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
        EpuzzleStatesList.add(new EpuzzleState(bu3,localCost,d));
        
   	}//space move to left
    
    if (space2 - 1 >= 0) {
    	int [][] bu4 = new int[3][3];
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 3; j++)
                bu4[i][j] = backUp[i][j];

    	bu4[space1][space2] = bu4[space1][space2 - 1];
        bu4[space1][space2 - 1] = 0;
        int d = 0;
        int si = 0;
        int sj = 0;
        for(int n = 0; n <= 8; ++n) {
           int i;
           int j;
           for(i = 0; i <= 2; ++i) {
              for(j = 0; j <= 2; ++j) {
                 if (bu4[i][j] == n) {
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
        EpuzzleStatesList.add(new EpuzzleState(bu4,localCost,d)); 
                

    }//space move up
    
    

    for (EpuzzleState che : EpuzzleStatesList) {
      searchStatesList.add((SearchState)che);
    }
    return searchStatesList;
  }//return the list which is available to move


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
  }//find weather the current state is same to a state is open or close



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

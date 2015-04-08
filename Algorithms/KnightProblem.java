/* The Knight’s tour problem */

class KnightProblem
{
	public static void main(String[] args){
		KnightTour();
	}
	public static void KnightTour(){
		int[][] solution=new int[8][8];
		for(int i=0;i<solution.length;i++){
			for (int j=0;j<solution.length;j++ ) {
				solution[i][j]=-1;
			}
		}
		int[] top_moves={  2, 1, -1, -2, -2, -1,  1,  2 };
		int[] side_moves={  1, 2,  2,  1, -1, -2, -2, -1 };
		solution[0][0]=0;
		if(allKnightVisits(0,0,solution,top_moves,side_moves,0)){
			for(int i=0;i<solution.length;i++){
					for(int j=0;j<solution.length;j++){
						System.out.print(solution[i][j]+" ");
					}
					System.out.print("\n");
			}
		}
	}
	public static boolean allKnightVisits(int top,int side,int[][] solution,int[] top_moves,int[] side_moves,int total_steps){
		if(total_steps==solution.length*solution.length){
			return true;
		}
		for(int i=0;i<solution.length;i++){
			int next_Move_top=top+top_moves[i];
			int next__Move_side=side+side_moves[i];
			if(isValidStep(solution,next_Move_top,next__Move_side)){
				System.out.print(next_Move_top+" "+next_Move_top);
				solution[next_Move_top][next__Move_side]=total_steps;
				if(allKnightVisits(next_Move_top,next__Move_side,solution,top_moves,side_moves,total_steps+1)){
					return true;
				}else{
					solution[next_Move_top][next__Move_side]=-1;
				}
			}
		}
		return false;
	}
	public static boolean isValidStep(int[][] solution,int top,int side){
		if(top<solution.length&&top>=0&&side>=0&&side<solution.length){
			if(solution[top][side]==-1){
				return true;
			}
		}

		return false;
	}
}
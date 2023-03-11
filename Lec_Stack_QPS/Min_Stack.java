package Lec_Stack_QPS;

import Lec_Stack.D_Stack;

public class Min_Stack extends D_Stack {
	int curr_min;

	public int min() {
		return curr_min;
	}

	@Override
	public void add(int ali) {
		if (isEmpty()) {
			curr_min = ali;
			super.add(ali);
		} else if (ali >= curr_min) {
			super.add(ali);
		} else {
//			magical number in!! < curr_min
//			ali < curr_min!!
			int prev_min = curr_min;
			curr_min = ali;

			int magical = 2 * curr_min - prev_min;
			super.add(magical);
		}
	}

	@Override
	public int peek() {
		if (super.peek() >= curr_min) {
			return super.peek();
		} else {
//			int magic = super.peek();
//			int magical = 2 * curr_min - prev_min;
			return curr_min;
		}
	}

	@Override
	public int pop() {
		if (super.peek() >= curr_min) {
			return super.pop();
		}else {
//			curr min!! ayya hogaa!!
//			magical number super.peek() hoga
			int magic = super.pop();
//			return to curr_min!!
//			prev min should be the curr min 
			int ans = curr_min;
			int prev_min = 2*curr_min - magic;
//			System.out.println(" prev_min = " + prev_min+ " , curr_min "+
//			curr_min+" , magic = "+magic);
			
			curr_min = prev_min;
			
			return ans;
		}
	}

}

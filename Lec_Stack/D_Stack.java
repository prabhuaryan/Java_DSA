package Lec_Stack;

public class D_Stack extends Stack	{
	@Override
	public void add(int ali) {
	
		if (this.isFull()) {
			int[] biggy = new int[2 * this.arr.length];
			for (int i = 0; i < arr.length; i++) {
				biggy[i] = arr[i];
			}
			super.arr = biggy;
		}
		super.add(ali);
	}
}

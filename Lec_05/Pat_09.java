package Lec_05;

public class Pat_09 {
	public static void main(String[] args) {
		int n = 10;
		int row = 1;
		int total_sp = n-1;
		int total_st = 1;
		while (row <= n) {
//			print space
			int cnt_sp = 0;
			while(cnt_sp < total_sp) {
				System.out.print("  ");
				cnt_sp++;
			}
//			print star
			int cnt_st = 0;
			while(cnt_st<total_st) {
				if(cnt_st%2==0) {
				System.out.print("* ");
				}else {
					System.out.print("! ");
				}
				cnt_st++; 
			}
			
			total_st=total_st+2;
			total_sp--;
			row++;
			System.out.println();
		}
	}
}

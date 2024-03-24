package FunctionalInterface;
@FunctionalInterface
interface Number{
	void reverse(int num);

}
 class ReverseOfNumber{

	public static void main(String[] args) {
		
		Number num=(nu)->{
			int rev=0;
			while(nu!=0) {
				int rem=nu%10;
				rev=rev* 10 +rem;
				nu=nu/10;
			}
			System.out.println(rev);
		};
		num.reverse(132);

	}

}

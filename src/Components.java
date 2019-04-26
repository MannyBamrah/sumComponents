import java.util.*;
import java.math.BigInteger; 
public class Components {
	public static void main(String args[]) throws Exception {
		System.out.println("Enter the number to find sum components");
		Scanner scan = new Scanner(System.in);
		String number = scan.nextLine();
		BigInteger num = new BigInteger(number);
		BigInteger comp1 = num.divide(new BigInteger("2"));
		BigInteger comp2 = num.subtract(comp1);
		if(comp1.toString().contains("4")) {
			BigInteger balance = findPositionOf4(comp1);
			comp1 = comp1.subtract(balance);
			comp2 = comp2.add(balance);
			}
		else if (comp2.toString().contains("4")) {
			BigInteger balance = findPositionOf4(comp2);
			comp1 = comp1.add(balance);
			comp2 = comp2.subtract(balance);
		}
		System.out.println("Component1:"+comp1.toString());
		System.out.printf("Component2:"+comp2.toString());
	}
	public static BigInteger findPositionOf4(BigInteger n) {
		BigInteger o = n;
		BigInteger balance = new BigInteger("0");
		BigInteger ten = new BigInteger("10");
		BigInteger four = new BigInteger("4");
		Integer i = 0 ;
		while(!o.equals(BigInteger.ZERO)) {
			BigInteger[] base = o.divideAndRemainder(new BigInteger("10"));
			o = base[0];
			if(base[1].equals(four)) {
				if(i==0) {
					balance = balance.add(BigInteger.ONE);}
				else {
					balance = balance.add(ten.multiply(ten.pow(i-1)));
							}
			}
			i++;
		}
		return balance;
	}
}

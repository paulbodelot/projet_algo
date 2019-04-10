import java.awt.Color;
public class mainEquation
{
	public static void main(String[]args)
	{
		int []point_d = {2,4};
		int []direction_d = {2,4};
		
		Equation Eqa = new Equation(2,3);
		Equation Eqb = new Equation(11,3,0);
		Equation Eqc = new Equation(4,1,10);
		Equation Eqd = new Equation(point_d,direction_d);
		
		int x = Eqb.resoudreSysteme(Eqc)[0];
		int y = Eqb.resoudreSysteme(Eqc)[1];
		
		int[] A = {50,100};
		int[] B = {200,300};
		
		//Rayon tutu = new Rayon(A,B,new Color(50,100,150));
		
		System.out.println(Eqa);
		System.out.println(Eqb);
		System.out.println(Eqc);
		System.out.println(Eqd);

		
		System.out.println("Le couple solution du système est (" + x + ";" + y + ").");
		
		//System.out.println(tutu);
	
	}
}

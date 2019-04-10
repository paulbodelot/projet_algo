public class Equation{
	
	public int a;
	public int b;
	public int c;
	
	public int[] vDir;
	
	//L'objet de cette classe est une équation cartésienne de droite ax + by = c avec un vecteur directeur (-b;a)
	
	public Equation(int aeq, int beq, int ceq) //Constructeur général d'équation cartésienne de droite
	{
		this.a = aeq;
		this.b = beq;
		this.c = ceq;
		
		this.vDir = new int[2];
		this.vDir[0] = -b;
		this.vDir[1] = a;
	}
	
	public Equation(int abis,int bbis) //Constructeur plus intuitif de forme y = a*x + b mais impossible de tracer une verticale avec
	{
		this.a = -abis;
		this.b = 1;
		this.c = bbis;
		
		this.vDir = new int[2];
		
		this.vDir[0] = -b;
		this.vDir[1] = a;
	}
	
	public Equation(int cter) //Constructeur créant une droite verticale d'équation x = c
	{
		this.a = 1;
		this.b = 0;
		this.c = cter;
		
		this.vDir = new int[2];
		
		this.vDir[0] = -b;
		this.vDir[1] = a;
	}
	
	public Equation(int[]direction, int cquater) //Crée l'équation 
	{
		this.vDir = new int[2];
		this.vDir[0] = direction[0];
		this.vDir[1] = direction[1];
		
		this.a = -direction[1];
		this.b = direction[0];
		this.c = cquater;
		
	}
	
	public Equation(int[]direction, int[]pointDepart) //Crée l'équation 
	{
		this.vDir = new int[2];
		this.vDir[0] = direction[0];
		this.vDir[1] = direction[1];
		
		this.a = -direction[1];
		this.b = direction[0];
		if(this.b != 0)
		{
			this.c = pointDepart[1]+pointDepart[0]*(this.a/this.b);
		}
		else this.c = pointDepart[0]/this.a;
		
	}
	
	//Méthodes applicables à un objet existant//
	
	
	
	public int[] resoudreSysteme(Equation eq)
	{
		int x = 0;
		int y = 0;
		int det = eq.b*this.a-this.b*eq.a;
		int det2 = eq.b*this.c-this.b*eq.c;
		
		if(det != 0) //Si ab' est différent de a'b, résolution matricielle possible :
		{
			x = (int)((eq.b*this.c-this.b*eq.c)/det);
			y = (int)((eq.c*this.a-this.c*eq.a)/det);
		}
		
		//Si le déterminant est nul, deux cas :
		
		else if(det2 == 0) //Si le deuxième déterminant est nul, cela veut dire que les 2 droites se superposent
		{
			//On retourne 2048 comme code d'exception "nombre de solutions infini"
			x = 2048;
			y = 2048;
		}
		
		else //Sinon, les deux droites sont parallèles et non confondues, elles n'ont pas d'intersection
		{
			//On retourne -2048 comme code d'exception "pas de solution"
			x = -2048;
			y = -2048;
		}
		
		
		int[] solution = {x,y};
			
		return solution;
	}		
		
	public String toString()
	{
		String s;
		if(this.b == 1) //Pour une équation en y = ax + b
		{
			s = "Equation : y = " + this.a + "*x + " + this.b + ", de vecteur directeur (" + this.vDir[0] + ";" + this.vDir[1] + ").";
		}
		
		else if(this.b == 0) //Pour une équation de droite verticale en x = a
		{
			s = "Equation : x = " + this.c + ", de vecteur directeur (" + this.vDir[0] + ";" + this.vDir[1] + ").";
		}
		
		else //Pour toute autre équation, évite les fractions abominables
		{
			s = "Equation : " + this.a + "*x + " + this.b + "*y = " + c + ", de vecteur directeur (" + this.vDir[0] + ";" + this.vDir[1] + ").";
		}
		
		return s;
	}
		
		
	}

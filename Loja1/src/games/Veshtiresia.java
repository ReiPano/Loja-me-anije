package games;

public class Veshtiresia {
	int c;
	String lloji;
	public Veshtiresia(String l){
		this.lloji=l;
	}
	public int numri(){
		if(lloji.equals("Easy")){
			c=3;
		}
		if(lloji.equals("Medium")){
			c=4;
		}
		if(lloji.equals("Hard")){
			c=7;
		}
		return c;
	}

}

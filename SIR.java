import java.util.Iterator;


public class SIR {

    private int susceptible;
    private int infected;
    private int recovered;
    private int infectiousPeriod;
    private int Population;
    MyBag<SickNode> infGroups = new MyBag<SickNode>();

    public SIR( int initialS,  int initialI,  int initialR, int infectiousPeriod){
    
        this.susceptible = initialS;
        this.infected = initialI;
        SickNode i = new SickNode(infectiousPeriod, initialI);
        infGroups.add(i);
        this.recovered = initialR;
        this.infectiousPeriod = infectiousPeriod;
        this.Population = initialS + initialI + initialR;
    }

    public int S(){return susceptible;}

    public int I(){return infected;}

    public int R(){return recovered;}

    public void step(double beta){

        int change_susceptible = (int)(beta * (double)this.susceptible * (double)this.infected);
        this.susceptible -= change_susceptible;
        SickNode new_inf = new SickNode(this.infectiousPeriod, change_susceptible);
        this.infGroups.add(new_inf);
        Iterator i = infGroups.iterator();
        while(i.hasNext()){
            
            SickNode s = (SickNode) i.next();

            if(s.period == 0){
                this.infected -= s.population;
                if(this.infected < 0){this.infected = 0;}
                this.recovered += s.population;
                i.remove();

            }

            else{s.period--;}
        }  


        this.infected += change_susceptible;
    }

}
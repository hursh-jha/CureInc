package cure_inc;
public class State {
    private int citizens;
    private int infected;
    private int dead;
    private String name;
    
    public State(String name, int citizens, int infected, int dead) {
        this.name = name;
        if(citizens > 0){
            this.citizens = citizens;
        }else{
            this.citizens = 0;
        }
        if(infected > 0){
            this.infected = infected;
        }else{
            this.infected = 0;
        }
        if(dead > 0){
            this.dead = dead;
        }else{
            this.dead = 0;
        }
    }
    public State() {
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getCitizens() {
        return citizens;
    }

    public void setCitizens(int citizens) {
        if(citizens > 0){
            this.citizens = citizens;
        }else{
            this.citizens = 0;
        }
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        if(infected > 0){
            this.infected = infected;
        }else{
            this.infected = 0;
        }
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        if(dead > 0){
            this.dead = dead;
        }else{
            this.dead = 0;
        }
    }
    
}

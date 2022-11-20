package code.Buisness_logic;

public class Euro {
    
    private long valore;

    public Euro(long euro, long cent){
        if(euro >= 0)
            valore = euro*100 + cent;
        else
            valore = euro*100 - cent;
    }

    public Euro(double d){
        valore = (long)(d*100);
    }

    public long getValore(){
        return valore;
    }

    public Euro somma (Euro e){
        // checking if e is null and throwing ane exception if it is
        if(e==null){
            throw new IllegalArgumentException("pharam can't be null");
        }
        this.valore = this.valore + e.getValore();
        return this;
    }

    public Euro sottrai (Euro e){
        // checking if e is null and throwing ane exception if it is
        if(e==null){
            throw new IllegalArgumentException("pharam can't be null");
        }
        this.valore = this.valore - e.getValore();
        return this;
    }

    public boolean ugualeA(Euro e){
        // checking if e is null and throwing ane exception if it is
        if(e==null){
            throw new IllegalArgumentException("pharam can't be null");
        }
        if(valore == e.getValore())
            return true;
        else return false;
    }

    public boolean minoreDi(Euro e){
        // checking if e is null and throwing ane exception if it is
        if(e==null){
            throw new IllegalArgumentException("pharam can't be null");
        }
        if(valore <= e.getValore())
            return true;
        else return false;
    }

    public String stampa(){
        return (double)valore/100 + " euro";
    }
    
}

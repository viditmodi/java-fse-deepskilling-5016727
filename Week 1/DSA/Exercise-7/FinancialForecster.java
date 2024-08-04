public class FinancialForecster {
    private int initial;
    private int growthRate;

    FinancialForecster(int initial, int growthRate){
        this.setInitial(initial).setGrowthRate(growthRate);
    }

    public FinancialForecster setInitial(int initial){
        this.initial = initial;
        return this;
    }
    
    public FinancialForecster setGrowthRate(int rate){
        this.growthRate = rate;
        return this;
    }

    public int getInitial(){
        return this.initial;
    }
    public int getGrowthRate(){
        return this.growthRate;
    }


    public double forecast(int offset){
        double res = forecastHelper(initial, offset);
        return res;
    }

    private double forecastHelper(int value, int offset){
        System.out.print(value+" -> ");
        if(offset==0){
            return value;
        }
        value+=growthRate*value/100;
        return forecastHelper(value, offset-1);
    }

    
}

public class Cat
{
    private Double originWeight;
    private Double weight;

    private Double minWeight;
    private Double maxWeight;
    private static int count = 0;

    private double eatenFood;

    public Cat()
    {
        this(1500.0 + 3000.0 * Math.random());
    }

    public Cat(double weight)
    {
        this(weight, weight, 100 , 9000, 0);
    }

    private Cat (double weight, double originWeight, double minWeight, double maxWeight, double eatenFood)
    {
        this.weight = weight;
        this.originWeight = originWeight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.eatenFood = eatenFood;
        if (isAlive())
        {
            count++;
        }

    }

    public Cat (Cat other)
    {
        this(other.weight, other.originWeight, other.minWeight, other.maxWeight, other.eatenFood);
    }

    public void meow()
    {
        if (isAlive()) {
            addWeight(-1.);
            System.out.println("Meow");
        }
    }

    public void feed(Double amount)
    {
        addEatenFood(amount);
        addWeight(amount);

    }

    public void drink(Double amount)
    {
        if(isAlive()) {
            addWeight(amount);
        }
    }

    public void toilet()    {
        if (isAlive()) {
            addWeight(-50.);
            System.out.println("cat use toilet");
        }
    }


    public Double getWeight()
    {
        return weight;
    }

    private void setWeight(Double weight) {
        if(isAlive()) {
            this.weight = weight;
            if(!isAlive())  {
                count--;
            }
        }
    }
    private void addWeight(Double weight)    {
        setWeight(getWeight()+weight);
    }

    public double getEatenFood() {
        return eatenFood;
    }

    private void setEatenFood(double eatenFood) {
        this.eatenFood = eatenFood;
    }

    private void addEatenFood(double eatenFood) {
        if (isAlive()) {
            setEatenFood(getEatenFood() + eatenFood);
        }
    }

    private boolean isAlive()    {
        return getWeight() >= minWeight && getWeight() <= maxWeight;
    }

    public static int getCount() {
        return count;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public Cat copy()
    {
        return new Cat(this);
    }

    public static Cat copy(Cat other)
    {
        return other.copy();
    }
}
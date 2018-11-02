
public class Loader
{
    public static void main(String[] args)
    {
        System.out.println("cat count = " + Cat.getCount());

        Cat murk = new Cat();
        System.out.println(murk.getWeight());

        Cat catcopy = Cat.copy(murk);
        System.out.println("Catcopy weight " + catcopy.getWeight());
        System.out.println("cat count = " + Cat.getCount());
        catcopy.feed(999999.);
        System.out.println("Catcopy 2 status " + catcopy.getStatus() + "        cat count = " + Cat.getCount());
        murk.feed(100.);

        Cat catcopy2 = Cat.copy(catcopy);
        System.out.println("status catcopy2 " + catcopy2.getStatus());
        System.out.println("cat count = " + Cat.getCount());
        System.out.println(murk.getWeight());
        System.out.println("Catcopy weight " + catcopy.getWeight());
        System.out.println(murk.getEatenFood());
        murk.meow();
        System.out.println("cat count = " + Cat.getCount());
        murk.feed(999999.);
        System.out.println(murk.getEatenFood());
        System.out.println("cat count = " + Cat.getCount());
        murk.meow();
        System.out.println("cat count = " + Cat.getCount());
        murk.feed(999999.);
        System.out.println(murk.getEatenFood());

        Cat kitten = getKitten();
        System.out.println("weight kitten " + kitten.getWeight() + "cat count " + Cat.getCount() );
        System.out.println(murk.getStatus());
    }

    public static Cat getKitten()
    {
        double weight = 100 + 100 * Math.random();
        return new Cat (weight);
    }
}
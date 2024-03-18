package RestClass_Feb17;

public class NonDesignPattern
{
    public void step1()
    {
        System.out.println("Step 1");

    }
    public void step2()
    {
        System.out.println("Step 2");
    }
    public void step3()
    {
        System.out.println("Step 3");
    }

    public static void main(String[] args)
    {
        NonDesignPattern np = new NonDesignPattern();
        np.step1();
        np.step2();
        np.step3();

    }

}

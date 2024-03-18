package RestClass_Feb17;

public class BuilderPattern
{
    //change return type of the each method as class type
    //this always points to current/calling object. returning the same to have same name reference
    public BuilderPattern stage1()
    {
        System.out.println("Stage 1");
        return this;
    }
    public BuilderPattern stage2(String str)
    {
        System.out.println("Stage 2 string is"+str);
        return this;
    }
    public BuilderPattern stage3()
    {
        System.out.println("Stage 3");
        return this;
    }

    public static void main(String[] args) {
        BuilderPattern bp = new BuilderPattern();
        bp.stage1().stage2("Nakul").stage3();

    }

}

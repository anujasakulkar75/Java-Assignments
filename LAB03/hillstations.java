package LAB03;
public class hillstations 
{
    String famousfood() 
    {
        return "Generic hill station food";
    }

    String famousfor() 
    {
        return "Beautiful scenery";
    }

    public static void main(String[] args) 
    {
        hillstations h;

        h = new Mahabaleshwar();
        System.out.println("Mahabelshwar famous food: " + h.famousfood());
        System.out.println("Mahabaleshwar famous for: " + h.famousfor());

        h = new Shimla();
        System.out.println("Shimla famous food: " + h.famousfood());
        System.out.println("Shimla famous for: " + h.famousfor());

        h = new Ooty();
        System.out.println("Ooty famous food: " + h.famousfood());
        System.out.println("Ooty famous for: " + h.famousfor());
    }
}

class Mahabaleshwar extends hillstations 
{
    String famousfood() {
        return "1. Strawberry  2. Corn Patties";
    }

    String famousfor() {
        return "1. Venna Lake  2. Mapro Garden";
    }
}

class Shimla extends hillstations 
{
    String famousfood() 
    {
        return "1. Chana Madra  2. Tudkiya Bhath";
    }

    String famousfor() 
    {
        return "1. Toy Train  2. Mall Road";
    }
}

class Ooty extends hillstations 
{
    String famousfood() 
    {
        return "1. Homemade Chocolate  2. South Indian Cuisine";
    }

    String famousfor() 
    {
        return "1. Tea Gardens  2. Nilgiri Hills";
    }
}

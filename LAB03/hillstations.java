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

        h = new Manali();
        System.out.println("Manali famous food: " + h.famousfood());
        System.out.println("Manali famous for: " + h.famousfor());

        h = new Shimla();
        System.out.println("Shimla famous food: " + h.famousfood());
        System.out.println("Shimla famous for: " + h.famousfor());

        h = new Ooty();
        System.out.println("Ooty famous food: " + h.famousfood());
        System.out.println("Ooty famous for: " + h.famousfor());
    }
}

class Manali extends hillstations 
{
    String famousfood() {
        return "1. Siddu  2. Trout Fish";
    }

    String famousfor() {
        return "1. Snow activities  2. Solang Valley";
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

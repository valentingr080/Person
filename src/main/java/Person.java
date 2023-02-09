import java.util.List;

/**
 * Class representing a person with a name, age and gender
 *
 * @author Valentín Nahuel García Rosas
 *
 */
public class Person {
    private final String name;
    private final int age;
    private final String gender;

    /**
     * Construct a person with a name, age and gender
     *
     * @param name the name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     */
    public Person(String name, int age, String gender) {
        if(name.isEmpty()) throw new EmptyStringException("El nombre no puede estar vacío");
        if(age < 0) throw new NegativeAgeException("La edad de una persona no puede ser negativa");
        if(!gender.equals("male") || !gender.equals("female")) throw new BadGenderInputException("El genero tiene que ser 'male' o 'female'");

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name(){
        return this.name;
    }

    public int age(){
        return this.age;
    }

    public String gender(){
        return this.gender;
    }

    /**
     * Computes the average age of male and female persona in a list and returns the result in
     * an array  of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     *
     * @param persons
     * @return
     */
    public double[] averageAgePerGender(List<Person> persons){
        return null;
    }



}

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
        if(name.isEmpty()) throw new PersonInstanciationException("El nombre no puede estar vacío");
        if(age <= 0) throw new PersonInstanciationException("La edad de una persona no puede ser negativa o 0");
        if(!gender.equals("male") && !gender.equals("female")) throw new PersonInstanciationException("El genero tiene que ser 'male' o 'female'");

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
     * (PONGO EL MÉTODO ESTÁTICO PARA QUE NO SEA NECESARIO LA INVOCACIÓN DESDE UNA PERSONA)
     * Cuando no hay personas de un género devuelve que la edad media es de 0
     *
     * @param persons
     * @return
     */
    public static double[] averageAgePerGender(List<Person> personas){
        int numMale = 0, numFemale = 0;
        double maleAverage = 0, femaleAverage = 0;
        for(Person p : personas){
            if(p.gender().equals("male")){
                numMale++;
                maleAverage+=p.age();
            }else{ // we don't need to check if it is female, because it can only be male or female according to our constructor.
                numFemale++;
                femaleAverage+=p.age();
            }
        }
        return new double[]{maleAverage / numMale, femaleAverage / numFemale};
    }



}

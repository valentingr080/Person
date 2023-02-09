import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PersonTest {

    /**
     *
     * Creo variables auxiliares que sé que están correctas al crear una persona, para poder hacer
     * pruebas con variables mal, usando estas variables que están bien, como se puede ver en los test
     * relacionados con la creación de objetos de tipo person con atributos incorrectos.
     *
     */
    private String correctName="María";
    private int correctAge = 20;
    private String correctGender = "female";

    // Test para comprobar que no se puede crear una persona con Nombre vacío.
    @Test
    void CreatePersonWithEmptyName() {
        String nombre_mal = "";
        assertThrows(PersonInstanciationException.class, () -> new Person(nombre_mal, correctAge, correctGender));
    }

    // Test para comprobar que no se puede crear una persona con una Edad negativa.
    @Test
    void CreatePersonWithNegativeAge() {
        int age_mal = -5;
        assertThrows(PersonInstanciationException.class, () -> new Person(correctName, age_mal, correctGender));
    }

    // Test para comprobar que no se puede crear una persona con un género incorrecto.
    @Test
    void CreatePersonWithIncorrectGender() {
        String genero_incorrecto = "avión";
        assertThrows(PersonInstanciationException.class, () -> new Person(correctName, correctAge, genero_incorrecto));
    }

    // Test para comprobar que no se puede crear una persona con un género vacío.
    @Test
    void CreatePersonWithEmptyGender(){
        String genero_vacio = "";
        assertThrows(PersonInstanciationException.class, () -> new Person(correctName, correctAge, genero_vacio));
    }


    // Test de averageAgePerGender en caso general de dos personas por género.
    @Test
    void averageAgePerGenderNormalCaseTwoMenTwoWomen() {
        List<Person> personas = new ArrayList<Person>();
        Person hombre1 = new Person("Alfonso", 30, "male");
        personas.add(hombre1);
        Person hombre2 = new Person("Juan", 40, "male");
        personas.add(hombre2);
        Person mujer1 = new Person(correctName, correctAge, correctGender);
        personas.add(mujer1);
        Person mujer2 = new Person(correctName, correctAge, correctGender);
        personas.add(mujer2);

        double[] calculatedValue = Person.averageAgePerGender();
        double[] expectedValue = {35, 20};

        assertEquals(expectedValue, calculatedValue);
    }

    // Test de averageAgePerGender en caso de que la lista este vacía
    void averageAgePerGenderEmptyList(){
        List<Person> personas = new ArrayList<>();
        double[] calculatedValue = Person.averageAgePerGender(personas);
        double[] expectedValue = {0,0};

        assertEquals(expectedValue, calculatedValue);
    }

    // Test de averageAgePerGender en caso de que no haya hombres
    void averageAgePerGenderNoMales(){
        List<Person> personas = new ArrayList<Person>();
        Person mujer1 = new Person(correctName, correctAge, correctGender);
        personas.add(mujer1);
        Person mujer2 = new Person(correctName, correctAge, correctGender);
        personas.add(mujer2);

        double[] calculatedValue = Person.averageAgePerGender();
        double[] expectedValue = {0, 20};

        assertEquals(expectedValue, calculatedValue);
    }

    // Test de averageAgePerGender en caso de que no haya mujeres
    void averageAgePerGenderNoFemales(){
        List<Person> personas = new ArrayList<Person>();
        Person hombre1 = new Person("Alfonso", 30, "male");
        personas.add(hombre1);
        Person hombre2 = new Person("Juan", 40, "male");
        personas.add(hombre2);

        double[] calculatedValue = Person.averageAgePerGender();
        double[] expectedValue = {35, 0};

        assertEquals(expectedValue, calculatedValue);
    }

}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PersonTest {

    /**
     *
     * Creo variables auxiliares que sé que están correctas al crear una persona, para poder hacer
     * pruebas con variables mal, usando estas variables que están bien, como se puede ver en los test
     * relacionados con la creación de objetos de tipo person con atributos incorrectos.
     *
     */
    private String correctName="Alfonso";
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


    @Test
    void averageAgePerGender() {
        
    }
}
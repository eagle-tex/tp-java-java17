package java17.ex06;

import java.util.function.Supplier;
import java17.data.Person;
import org.junit.Test;

/** Exercice 06 - java.util.function.Supplier */
public class Function_06_Test {

  // tag::formatAge[]
  // TODO compléter la méthode
  // TODO la méthode retourne une chaîne de caractères de la forme [age=<AGE>] (exemple : [age=12])
  String formatAge(Supplier<Person> supplier) {
    // TODO
    Person p = supplier.get();
    //    supplier.get(new Person("Prénom", "Nom", 25, "pass"));
    //    Person p = supplier.get();
    return "[age=" + p.getAge() + "]";
  }

  // end::formatAge[]

  @Test
  public void test_supplier_formatAge() throws Exception {
    // TODO compléter le test unitaire pour qu'il soit passant
    String result = formatAge(() -> new Person("A", "B", 35, "P"));

    assert result.equals("[age=35]");
  }
}

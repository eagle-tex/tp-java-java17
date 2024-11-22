package java17.ex01;

import java.util.List;
import java17.data.Data;
import java17.data.Person;
import org.junit.Test;

/** Exercice 01 - Méthode par défaut */
public class Method_01_Test {

  // tag::IDao[]
  interface IDao {
    List<Person> findAll();

    // TODO créer une méthode int sumAge()
    // TODO Cette méthode retourne le résultat de l'addition des ages des personnes
    default int sumAge(List<Person> personList) {
      int result = 0;
      for (Person person : personList) {
        result += person.getAge();
      }
      return result;
    }
  }

  // end::IDao[]

  class DaoA implements IDao {

    List<Person> people = Data.buildPersonList(20);

    @Override
    public List<Person> findAll() {
      return people;
    }

    //    @Override
    //    public int sumAge(List<Person> personList) {
    //        int result = 0;
    //      for (Person person : personList) {
    //          result += person.getAge();
    //      }
    //      return result;
    //    }
  }

  class DaoB implements IDao {

    List<Person> people = Data.buildPersonList(100);

    @Override
    public List<Person> findAll() {
      return people;
    }
  }

  @Test
  public void test_daoA_sumAge() throws Exception {

    DaoA daoA = new DaoA();

    // TODO invoquer la méthode sumAge pour que le test soit passant
    int result = daoA.sumAge(daoA.findAll());

    assert result == 210;
  }

  @Test
  public void test_daoB_sumAge() throws Exception {

    DaoB daoB = new DaoB();

    // TODO invoquer la méthode sumAge pour que le test soit passant
    int result = daoB.sumAge(daoB.findAll());

    assert result == 5050;
  }
}

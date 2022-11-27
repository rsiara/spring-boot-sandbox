package collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

public class CollectionTest {

  @Test
  void test() {

    Employee john = new Employee("john", 2000, Arrays.asList("polski","niemiecki"), "it");
    Employee marc = new Employee("marc", 5000, Arrays.asList("hiszpański","holenderski"), "marketing");
    Employee ann = new Employee("ann", 3000, Arrays.asList("polski","angielski"), "księgowość");


    SortedMap<Employee, String> sortedMap = new TreeMap<>(new Comparator<Employee>() {
      @Override
      public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
      }
    });

    sortedMap.put(john, john.getDepartment());
    sortedMap.put(marc, marc.getDepartment());
    sortedMap.put(ann, ann.getDepartment());

    System.out.println(sortedMap.values());
  }

  @Test
  void comparable() {

    EmployeeComparable john = new EmployeeComparable("john", 2000, Arrays.asList("polski","niemiecki"), "it");
    EmployeeComparable marc = new EmployeeComparable("marc", 5000, Arrays.asList("hiszpański","holenderski"), "marketing");
    EmployeeComparable ann = new EmployeeComparable("ann", 3000, Arrays.asList("polski","angielski"), "księgowość");


    SortedMap<EmployeeComparable, String> sortedMap = new TreeMap<>();

    sortedMap.put(john, john.getDepartment());
    sortedMap.put(marc, marc.getDepartment());
    sortedMap.put(ann, ann.getDepartment());

    System.out.println(sortedMap.values());
  }


  @Test
  void sorterList() {

    EmployeeComparable john = new EmployeeComparable("john", 2000, Arrays.asList("polski", "niemiecki"), "it");
    EmployeeComparable marc = new EmployeeComparable("marc", 5000, Arrays.asList("hiszpański", "holenderski"), "marketing");
    EmployeeComparable ann = new EmployeeComparable("ann", 3000, Arrays.asList("polski", "angielski"), "księgowość");


    List<EmployeeComparable> list = new LinkedList<>();
    list.add(marc);
    list.add(john);
    list.add(ann);

    Collections.sort(list);
    System.out.println(list);

  }


  @Test
  void sorterListComparator() {

    Employee john = new Employee("john", 2000, Arrays.asList("polski", "niemiecki"), "it");
    Employee marc = new Employee("marc", 5000, Arrays.asList("hiszpański", "holenderski"), "marketing");
    Employee ann = new Employee("ann", 3000, Arrays.asList("polski", "angielski"), "księgowość");


    List<Employee> list = new LinkedList<>();
    list.add(marc);
    list.add(john);
    list.add(ann);

    Collections.sort(list, new EmployeeComparator());
    System.out.println(list);

  }

  @Test
  void testMap() {

    SortedMap<String, String> sortedMap = new TreeMap<>();

    sortedMap.put("ccc", "czeci" );
    sortedMap.put("aaa", "pierszy");
    sortedMap.put("bbb", "drugi");

    System.out.println(sortedMap.entrySet());
  }

  @Test
  void czeciaMapa() {

    Map<String, String> normalMap = new HashMap<>();

    normalMap.put("ccc", "czeci" );
    normalMap.put("aaa", "pierszy");
    normalMap.put("bbb", "drugi");

    SortedMap<String, String> sortedMap = new TreeMap<>(normalMap);
//    sortedMap.putAll(normalMap);

    System.out.println(sortedMap.entrySet());
  }
}







package collection;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;


public class ComparableTest {


  @Test
  void test() {

    Employee john = new Employee("john", 22, 2000, Arrays.asList("polski", "niemiecki"), "it");
    Employee marc = new Employee("marc", 18, 5000, Arrays.asList("hiszpański", "holenderski"), "marketing");
    Employee ann = new Employee("ann", 34, 3000, Arrays.asList("polski", "angielski"), "księgowość");
    Employee greg = new Employee("greg", 19, 4000, Arrays.asList("polski"), "logistic");

    SortedMap<Employee, Integer> sortedMap = new TreeMap<>();
    sortedMap.put(john, john.getSalary());
    sortedMap.put(marc, marc.getSalary());
    sortedMap.put(ann, ann.getSalary());
    sortedMap.put(greg, greg.getSalary());

    System.out.println(sortedMap.entrySet());
  }

  @Test
  void test2() {


    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(getMap().entrySet());
    List<Integer> salaries = new ArrayList<>(getMap().values());
    Collections.sort(salaries);


    TreeSet<Map.Entry<Integer, Integer>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue() - o2.getValue();
      }
    });
    set.addAll(getMap().entrySet());

    System.out.println("set: " + set);

    Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue() - o2.getValue();
      }
    });
    System.out.println(entryList);


    SortedMap<Integer, Integer> sortedMap = new TreeMap();
    Map<Integer, Integer> rawMap = getMap();

    for (Map.Entry<Integer, Integer> entry : rawMap.entrySet()) {
      sortedMap.put(entry.getValue(), entry.getKey());
    }

    System.out.println(sortedMap);


  }


  @Test
  void test3() throws Exception {
    // Wyświetl posortowną po zarobkach listę pracowników, lista ma zawierać imię i zarobki

    List<Employee> employeeList = new ArrayList<>(getEmployeeMap().values());
    Collections.sort(employeeList);
    for (Employee employee : employeeList) {
      System.out.println(employee.getName() + " " + employee.getSalary());
    }
  }

  @Test
  void test5()  {
    // Wyświetl posortowną po zarobkach listę pracowników, lista ma zawierać imię, zarobki, staż pracy

    List<Employee> employeeList = new ArrayList<>(getEmployeeToSeniorityMap().keySet());
    Collections.sort(employeeList);
    for (Employee employee : employeeList) {
      System.out.println("Name: " + employee.getName() + " Salary: " + employee.getSalary() + " Seniority " + getEmployeeToSeniorityMap().get(employee));
    }
  }

  @Test
  void test6() {
    // Wyświetl posortowną po stażu listę pracowników, lista ma zawierać imię, zarobki, staż pracy

    List<Map.Entry<Employee, Integer>> entries = new ArrayList<>(getEmployeeToSeniorityMap().entrySet());
    entries.sort(new Comparator<Map.Entry<Employee, Integer>>() {
      @Override
      public int compare(Map.Entry<Employee, Integer> o1, Map.Entry<Employee, Integer> o2) {
        return o1.getValue() - o2.getValue();
      }
    });

    for (Map.Entry<Employee, Integer> entry : entries) {
      System.out.println("Name: " + entry.getKey().getName() + " Salary: " + entry.getKey().getSalary() + " Seniority " + entry.getValue());
    }
  }




  public Map<Employee, Integer> getEmployeeToSeniorityMap()  {

    Employee john = new Employee("john", 22, 2000, Arrays.asList("polski", "niemiecki"), "it");
    Employee marc = new Employee("marc", 18, 5000, Arrays.asList("hiszpański", "holenderski"), "marketing");
    Employee ann = new Employee("ann", 34, 3000, Arrays.asList("polski", "angielski"), "księgowość");
    Employee greg = new Employee("greg", 19, 4000, Arrays.asList("polski"), "logistic");

    Map<Employee, Integer> map = new HashMap<>();
    map.put(john, 4);
    map.put(marc, 2);
    map.put(ann, 14);
    map.put(greg, 9);
    return map;
  }

  public Map<Integer, Employee> getEmployeeMap() throws Exception {

    Employee john = new Employee("john", 22, 2000, Arrays.asList("polski", "niemiecki"), "it");
    Employee marc = new Employee("marc", 18, 5000, Arrays.asList("hiszpański", "holenderski"), "marketing");
    Employee ann = new Employee("ann", 34, 3000, Arrays.asList("polski", "angielski"), "księgowość");
    Employee greg = new Employee("greg", 19, 4000, Arrays.asList("polski"), "logistic");

    Map<Integer, Employee> map = new HashMap<>();
    map.put(john.getAge(), john);
    map.put(marc.getAge(), marc);
    map.put(ann.getAge(), ann);
    map.put(greg.getAge(), greg);
    return map;
  }

  public Map<Integer, Integer> getMap() {
    Random random = new Random();
    int number = random.nextInt(6);


    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 1000);
    map.put(2, 3000);
    map.put(3, 1500);
    return map;
  }


  @Test
  public void streamTest(){

    Employee john = new Employee("john", 22, 2000, Arrays.asList("polski", "niemiecki"), "it");
    Employee marc = new Employee("marc", 18, 5000, Arrays.asList("hiszpański", "holenderski"), "marketing");
    Employee ann = new Employee("ann", 34, 3000, Arrays.asList("polski", "angielski"), "księgowość");
    Employee greg = new Employee("greg", 19, 4000, Arrays.asList("polski"), "logistic");

    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(john);
    employeeList.add(marc);
    employeeList.add(ann);
    employeeList.add(greg);

    // filter
    // map
    // collect

    List<String> oldEmployeeNames = employeeList.stream()
        .filter(employee -> employee.getAge() > 20)
        .map(employee -> employee.getName())
        .collect(Collectors.toList());

    System.out.println(oldEmployeeNames);

    Map<String, Employee> oldEmployeeMapByName =  employeeList.stream()
        .filter(employee -> employee.getAge() > 20)
        .collect(Collectors.toMap(employee -> employee.getName(), employee -> employee));

    System.out.println(oldEmployeeMapByName);


    // Zrób mapę za pomocą streama, z pracownikami którzy mają mniej jak 30 lat i znają język polski, kluczem nie będzie imie
    //a wartością znane języki
    Map<String, List<String>> employeeMap = employeeList.stream()
        .filter(employee -> employee.getAge()<30 && employee.getLanguages().contains("polski"))
        .collect(Collectors.toMap(employee -> employee.getName(), employee -> employee.getLanguages()));
    System.out.println("---------------");
    System.out.println(employeeMap);
  }

}

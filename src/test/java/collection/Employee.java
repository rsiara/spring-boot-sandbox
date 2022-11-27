package collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
class Employee implements Comparable<Employee> {
  private String name;
  private int age;
  private Integer salary;
  private List<String> languages;
  private String department;

  @Override
  public int compareTo(Employee o) {
    return this.salary - o.getSalary();
  }
}
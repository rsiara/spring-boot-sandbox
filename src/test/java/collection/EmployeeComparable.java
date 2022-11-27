package collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
class EmployeeComparable implements Comparable<EmployeeComparable> {
  private String name;
  private Integer salary;
  private List<String> languages;
  private String department;

  @Override
  public int compareTo(EmployeeComparable o) {
    return this.getSalary() - o.getSalary();
  }
}
package collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
class Employee {
  private String name;
  private Integer salary;
  private List<String> languages;
  private String department;
}
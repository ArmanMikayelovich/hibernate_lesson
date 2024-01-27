
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(
                name = "get_by_id",
                query = "select p from Employee p where employeeId = :id"
        )

})
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "employee_name", nullable = false)
    private String name;


    @ManyToMany(mappedBy = "employees")
    private Set<Organization> organizations;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name + "]";
    }

}
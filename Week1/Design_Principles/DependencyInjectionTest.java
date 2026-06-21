/*
 * Exercise 11 : Dependency Injection
 * Author : Mohana Priya K
 */

interface CustomerRepository {
    String findCustomerById(int id);
}

class CustomerRepositoryImpl
        implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {

        if (id == 101) {
            return "Mohana Priya";
        }

        if (id == 102) {
            return "Mona";
        }

        return "Customer Not Found";
    }
}

class CustomerService {

    private CustomerRepository repository;

    public CustomerService(
            CustomerRepository repository) {

        this.repository = repository;
    }

    public void getCustomerDetails(int id) {

        String customer =
                repository.findCustomerById(id);

        System.out.println(
                "Customer ID : " + id);
        System.out.println(
                "Customer Name : " + customer);
    }
}

public class DependencyInjectionTest {

    public static void main(String[] args) {

        CustomerRepository repository =
                new CustomerRepositoryImpl();

        CustomerService service =
                new CustomerService(repository);

        service.getCustomerDetails(101);
        service.getCustomerDetails(102);
        service.getCustomerDetails(103);
    }
}
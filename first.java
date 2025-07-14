import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Person {
    private String name;
    private int age;
    private float balanceAmount;
    private List<String> interest;

    public Person() {}

    public Person(String name, int age, float balanceAmount, List<String> interest) {
        this.name = name;
        this.age = age;
        this.balanceAmount = balanceAmount;
        this.interest = interest;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public float getBalanceAmount() { return balanceAmount; }
    public void setBalanceAmount(float balanceAmount) { this.balanceAmount = balanceAmount; }

    public List<String> getInterest() { return interest; }
    public void setInterest(List<String> interest) { this.interest = interest; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", balanceAmount=" + balanceAmount + ", interest=" + interest + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Step 1: Create Person object
            Person person = new Person("Tanuj", 23, 12500.50f, Arrays.asList("chess", "music"));

            // Step 2: Create ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Step 3: Convert to JSON
            String jsonString = mapper.writeValueAsString(person);
            System.out.println("Serialized JSON:\n" + jsonString);

            // Step 4: Convert back from JSON to object
            Person deserializedPerson = mapper.readValue(jsonString, Person.class);
            System.out.println("\nDeserialized Object:\n" + deserializedPerson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//output
//Serialized JSON:
// {"name":"Tanuj","age":23,"balanceAmount":12500.5,"interest":["chess","music"]}

// Deserialized Object:
// Person{name='Tanuj', age=23, balanceAmount=12500.5, interest=[chess, music]}

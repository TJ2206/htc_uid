import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        List<Person> allPeople = new ArrayList<>();
        File file = new File("people.json");

        try {
            if (file.exists() && file.length() != 0) {
                allPeople = mapper.readValue(file, new TypeReference<List<Person>>() {});
            }
            System.out.print("Enter number of people: ");
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\nPerson " + (i + 1) + ":");
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Age: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.print("Balance Amount: ");
                float balance = Float.parseFloat(scanner.nextLine());

                System.out.print("Enter interests: ");
                List<String> interests = Arrays.asList(scanner.nextLine().split(","));

                Person person = new Person(name, age, balance, interests);
                allPeople.add(person);
            }

            mapper.writeValue(file, allPeople);
            System.out.println("\nJSON data written to 'people.json'");

            List<Person> readPeople = mapper.readValue(file, new TypeReference<List<Person>>() {});
            System.out.println("\nDeserialized People:");
            for (Person p : readPeople) {
                System.out.println(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

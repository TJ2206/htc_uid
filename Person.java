import java.util.List;
public class Person {
    private String name;
    private int age;
    private float balanceAmount;
    private List<String> interest;

    public Person() {} // default constructor required by jackson for deserialization

    public Person(String name, int age, float balanceAmount, List<String> interest) {
        this.name = name;
        this.age = age;
        this.balanceAmount = balanceAmount;
        this.interest = interest;
    }

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
        return "Person{name='" + name + "', age=" + age +
                ", balanceAmount=" + balanceAmount + ", interest=" + interest + "}";
    }
}

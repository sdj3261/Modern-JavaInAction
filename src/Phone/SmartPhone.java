package Phone;

public class SmartPhone extends Phone{

    SmartPhone(String owner) {
        super(owner);
    }

    void internetSearch() {
        System.out.println("인터넷 서칭합니다.");
    }
}

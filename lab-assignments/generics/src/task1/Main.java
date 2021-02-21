package task1;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> ageMap = new MyHashMap<>();

        ageMap.put("Alex", 19);
        ageMap.put("Rares", 20);
        ageMap.put("Alin", 25);

        System.out.println(ageMap.get("Alin"));
        ageMap.put("Alin", 30);
        System.out.println(ageMap.get("Alin"));
    }
}

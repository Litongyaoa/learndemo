public class User {
    private String name;
    private int age;

    public User() {

    }

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private void setAge(int age){
        this.age = age;
    }

    public void show(){
        System.out.println(this.name+":"+this.age);
    }

}

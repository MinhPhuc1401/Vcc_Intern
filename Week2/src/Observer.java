import java.util.ArrayList;
import java.util.List;

// Step 1: Định nghĩa giao diện Observer để đảm bảo rằng tất cả các Observer phải triển khai phương thức update.
interface Observer {
    void update(String message);
}

// Step 2: Định nghĩa giao diện Subject để quản lý danh sách các Observer và thông báo cho họ.
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

// Step 3: Triển khai lớp ConcreteSubject, thực hiện giao diện Subject.
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // Thực hiện một hành động và thông báo cho các Observer khi cần thiết.
    public void doSomething() {
        String message = "ConcreteSubject đã thực hiện một hành động.";
        notifyObservers(message);
    }
}

// Step 4: Triển khai lớp ConcreteObserver, thực hiện giao diện Observer.
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " nhận thông báo: " + message);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        // Tạo một ConcreteSubject
        ConcreteSubject subject = new ConcreteSubject();

        // Tạo các ConcreteObserver và đăng ký chúng với ConcreteSubject
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        // Thực hiện một hành động và thông báo cho các Observer
        subject.doSomething();

        // Hủy đăng ký một Observer và thử lại thông báo
        subject.removeObserver(observer1);
        subject.doSomething();
    }
}


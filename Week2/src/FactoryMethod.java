// Step 1: Định nghĩa giao diện Product
interface Product {
    void create();
}

// Step 2: Triển khai các lớp ConcreteProduct
class ConcreteProductA implements Product {
    @Override
    public void create() {
        System.out.println("Tạo sản phẩm A");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void create() {
        System.out.println("Tạo sản phẩm B");
    }
}

// Step 3: Định nghĩa giao diện Creator (Factory)
interface Creator {
    Product factoryMethod();
}

// Step 4: Triển khai các lớp ConcreteCreator
class ConcreteCreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // Sử dụng ConcreteCreatorA để tạo ConcreteProductA
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.factoryMethod();
        productA.create();

        // Sử dụng ConcreteCreatorB để tạo ConcreteProductB
        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.factoryMethod();
        productB.create();
    }
}


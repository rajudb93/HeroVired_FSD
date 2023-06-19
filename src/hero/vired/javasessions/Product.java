package hero.vired.javasessions;


class Product {
    private String name;
    private String specification;
    private double cost;
    private int count;

    public Product(String name, String specification, double cost, int count) {
        this.name = name;
        this.specification = specification;
        this.cost = cost;
        this.count = count;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product Name: " + name + "\nSpecification: " + specification +
                "\nCost: $" + cost + "\nCount: " + count;
    }
}
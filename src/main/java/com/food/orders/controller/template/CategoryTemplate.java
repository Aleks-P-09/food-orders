package com.food.orders.controller.template;

public class CategoryTemplate {
    private String name;

    public CategoryTemplate() {
    }

    public CategoryTemplate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryTemplate{" +
                "name='" + name + '\'' +
                '}';
    }
}

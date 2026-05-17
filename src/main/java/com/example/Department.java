package com.example;

/**
 * Класс, представляющий департамент организации.
 * Автоматически генерирует уникальные ID при создании экземпляров.
 */
public class Department {
    private static int count = 1;

    /** Уникальный идентификатор департамента. */
    private final int id;
    /** Название департамента. */
    private String name;

    /**
     * Создаёт новый департамент с указанным названием.
     *
     * @param name название департамента
     */
    public Department(String name) {
        this.id = count++;
        this.name = name;
    }

    /** @return уникальный ID департамента */
    public int getID() { return id; }
    /** @return название департамента */
    public String getName() { return name; }

    /** @param newName новое название департамента */
    public void setName(String newName) { this.name = newName; }

    /**
     * Возвращает строковое представление департамента.
     *
     * @return название департамента
     */
    @Override
    public String toString() {
        return name;
    }
}
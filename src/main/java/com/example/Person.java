package com.example;

/**
 * Класс, представляющий сотрудника с личными данными и информацией о трудоустройстве.
 */
public class Person {
    /** Уникальный идентификатор сотрудника. */
    private final int id;
    /** Имя сотрудника. */
    private String name;
    /** Пол сотрудника. */
    private String gender;
    /** Департамент, в котором работает сотрудник. */
    private Department department;
    /** Размер заработной платы. */
    private int salary;
    /** Дата рождения (в строковом формате). */
    private String birthDate;

    /**
     * Создаёт нового сотрудника с заданными параметрами.
     *
     * @param ID         уникальный идентификатор
     * @param name       имя
     * @param gender     пол
     * @param department департамент
     * @param salary     заработная плата
     * @param birthDate  дата рождения
     */
    public Person(int ID, String name, String gender, Department department,
        int salary, String birthDate) {
        this.id = ID;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /** @return уникальный идентификатор сотрудника */
    public int getID() { return id; }
    /** @return имя сотрудника */
    public String getName() { return name; }
    /** @return пол сотрудника */
    public String getGender() { return gender; }
    /** @return департамент сотрудника */
    public Department getDepartment() { return department; }
    /** @return заработная плата */
    public int getSalary() { return salary; }
    /** @return дата рождения */
    public String getBirthDate() { return birthDate; }

    /** @param name новое имя сотрудника */
    public void setName(String name) { this.name = name; }
    /** @param gender новый пол сотрудника */
    public void setGender(String gender) { this.gender = gender; }
    /** @param department новый департамент */
    public void setDepartment(Department department) { this.department = department; }
    /** @param salary новая заработная плата */
    public void setSalary(int salary) { this.salary = salary; }
    /** @param birthDate новая дата рождения */
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    /**
     * Возвращает строковое представление объекта.
     *
     * @return строка с основными данными сотрудника
     */
    @Override
    public String toString() {
        return "Person{" + id + " " + name + " " + gender + " " + department + " " + salary + " " + birthDate + "}";
    }
}
package com.example.store.data.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Shops",
        indices = {
                @Index("Id"),
        })
public class ShopEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Address")
    private String address;

    @ColumnInfo(name = "EmployeeCount")
    private int employeeCount;

    // Порожній конструктор для Room
    public ShopEntity() {
    }

    // Конструктор для створення нових об'єктів без ідентифікатора
    @Ignore
    public ShopEntity(String name, String address, int employeeCount) {
        this.name = name;
        this.address = address;
        this.employeeCount = employeeCount;
    }

    // Гетери і сетери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
}

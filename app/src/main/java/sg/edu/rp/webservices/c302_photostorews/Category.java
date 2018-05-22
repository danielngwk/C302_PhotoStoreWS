package sg.edu.rp.webservices.c302_photostorews;

import java.io.Serializable;

public class Category implements Serializable{
    private int category_id;
    private String name;
    private String description;

    public Category(int category_id, String name, String description) {
        this.category_id = category_id;
        this.name = name;
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

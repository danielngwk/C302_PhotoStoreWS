package sg.edu.rp.webservices.c302_photostorews;

public class photostore {
    private int photo_id;
    private String title;
    private String description;
    private String image;
    private int category_id;

    public photostore(int photo_id, String title, String description, String image, int category_id, String created) {
        this.photo_id = photo_id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.category_id = category_id;
        this.created = created;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCreated() {
        return created;
    }

    private String created;
}

package pl.pjatk.adrwoj.MovieService;

public class Movie {

    private int id;
    private String name;
    private EnumMovie category;
    private String author;

    public Movie(int id, String name, EnumMovie category, String author) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
    }

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

    public EnumMovie getCategory() {
        return category;
    }

    public void setCategory(EnumMovie category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

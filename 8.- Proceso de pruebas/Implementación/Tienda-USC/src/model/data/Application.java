package model.data;


public class Application {
	private int id;
	private String status;
	private String content;

    public Application(int id, String status, String content) {
        this.id = id;
        this.status = status;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }
}

package in.ineuron.model;

public class BlogPost {

	private int id;
    private String title;
    private String description;
    private String content;
    
    
	public BlogPost() {
		super();
	}

	public BlogPost(int id, String title, String description, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content
				+ "]";
	}
    
    

}

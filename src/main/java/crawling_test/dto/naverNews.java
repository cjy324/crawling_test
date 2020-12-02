package crawling_test.dto;

public class naverNews {


	private String title;
	private String body;
	private String news;
	private String imgURL;
	
	public naverNews(String title, String body, String news, String imgURL) {
		this.title = title;
		this.body = body;
		this.news = news;
		this.imgURL = imgURL;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	
}

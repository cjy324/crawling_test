package crawling_test.dto;

public class DCarticle {

	public DCarticle(String num, String title, String name, String date, String count, String recommend) {
		this.num = num;
		this.title = title;
		this.name = name;
		this.date = date;
		this.count = count;
		this.recommend = recommend;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	private String num;
	private String title;
	private String name;
	private String date;
	private String count;
	private String recommend;

	/*
	 * @Override public String toString() { return "DCarticle [num=" + num +
	 * ", title=" + title + ", name=" + name + ", date=" + date + ", count=" + count
	 * + ", recommend=" + recommend + "]"; }
	 */

}


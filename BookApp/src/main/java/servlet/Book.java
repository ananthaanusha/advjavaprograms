package servlet;

public class Book {
	int bId;
	String bName;
	String bTitle;
	String bAuthor;
	String bDate;
	double bPrice;
	public Book(String bName, String bTitle, String bAuthor, String bDate ,double bPrice,int bId) {
		super();
		this.bId=bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bAuthor = bAuthor;
		this.bDate = bDate;
		this.bPrice=bPrice;
	}
	
	public Book() {
		super();
	}
	
	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public double getbPrice() {
		return bPrice;
	}

	public void setbPrice(double bPrice) {
		this.bPrice = bPrice;
	}

	@Override
	public String toString() {
		return "Book [bName=" + bName + ", bTitle=" + bTitle + ", bAuthor=" + bAuthor + ", bDate=" + bDate + ", bPICE=" + bPrice+ "]";
	}
	
}

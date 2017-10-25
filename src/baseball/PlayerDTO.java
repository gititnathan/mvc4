package baseball;

public class PlayerDTO {
	private int no;
	private String name;
	private int team_no;
	private int salary;
	private String grand;
	private String content;
	
	
	public PlayerDTO() {
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTeam_no() {
		return team_no;
	}
	public void setTeam_no(int team_no) {
		this.team_no = team_no;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getGrand() {
		return grand;
	}
	public void setGrand(String grand) {
		this.grand = grand;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

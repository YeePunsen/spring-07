package jdbc;

import lombok.Data;

@Data

public class Stu {


	private Integer id;
	private String name;
	private Integer bId;
	private Integer gerden;
	public Stu() {
		
	}
	public Stu( String name, Integer bId, Integer gerden) {
		super();
		
		this.name = name;
		this.bId = bId;
		this.gerden = gerden;
	}
	
	
}

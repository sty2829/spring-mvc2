package test;

public class Converter {
	
	public void ColumnConverter(String col) {
		col = col.toLowerCase();
		String[] cols = col.split("\r\n");
		
		for(String c : cols) {
			while(c.contains("_")) {
				int i = 0;
				int idx = c.indexOf("_", i);
				String str = c.substring(idx+1, idx+2);
				c = c.replaceFirst("_"+str, ""+str.toUpperCase());
				i = idx;
			}
			if(c.contains("Num")) {
				System.out.println("private Long " + c);
			}else {
				System.out.println("private String " + c);
			}
		}
	}

	public static void main(String[] args) {
		Converter converter = new Converter();
		converter.ColumnConverter("MI_NUM\r\n"
				+ "MI_ID\r\n"
				+ "MI_PWD\r\n"
				+ "MI_NAME\r\n"
				+ "MI_AGE\r\n"
				+ "MI_INFO");
	}
}

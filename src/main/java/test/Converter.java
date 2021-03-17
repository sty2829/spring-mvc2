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
		converter.ColumnConverter("UI_NUM\r\n"
				+ "UI_NAME\r\n"
				+ "UI_ID\r\n"
				+ "UI_PWD\r\n"
				+ "UI_GENRE\r\n"
				+ "UI_EMAIL\r\n"
				+ "UI_PHONE1\r\n"
				+ "UI_PHONE2\r\n"
				+ "UI_ADDRESS\r\n"
				+ "UI_HINT\r\n"
				+ "UI_ANSWER\r\n"
				+ "CREDAT\r\n"
				+ "CRETIM\r\n"
				+ "MODDAT\r\n"
				+ "MODTIM\r\n"
				+ "UI_IMG");
	}
}

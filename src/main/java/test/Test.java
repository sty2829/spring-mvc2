package test;

public class Test {

	public static void main(String[] args) {
		
		String str = "tbl_ui_num";
		while(str.contains("_")) {
			int i = 0;
			int idx = str.indexOf("_", i);
			String up = str.substring(idx+1, idx+2);
			str = str.replaceFirst("_"+up, ""+up.toUpperCase());
			i = idx;
		}
		
		System.out.println(str);
	}
}

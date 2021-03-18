package test;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;

import com.test.sp1.xml.test.Result;

public class TestXMLConverter {

	public static void main(String[] args) {
		
		String xml = "<testXML>\r\n"
				+ "   <tests>\r\n"
				+ "      <rows>\r\n"
				+ "         <row>\r\n"
				+ "            <name>hahah</name>\r\n"
				+ "            <age>22</age>\r\n"
				+ "         </row>\r\n"
				+ "         <row>\r\n"
				+ "            <name>kim</name>\r\n"
				+ "            <age>32</age>\r\n"
				+ "         </row>\r\n"
				+ "         <row>\r\n"
				+ "            <name>lee</name>\r\n"
				+ "            <age>42</age>\r\n"
				+ "         </row>\r\n"
				+ "      </rows>\r\n"
				+ "   </tests>\r\n"
				+ "   <testTitle>Title</testTitle>\r\n"
				+ "   <testSubTitle>subTitle</testSubTitle>\r\n"
				+ "</testXML>";
		
		JSONObject jObj = XML.toJSONObject(xml);
		System.out.println(jObj.toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			Result result = mapper.readValue(jObj.toString(), Result.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

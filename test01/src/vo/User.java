package vo;

import com.google.gson.JsonObject;

public class User {
	
	public String imgautherror() {
		JsonObject jsons = new JsonObject();
		JsonObject input = new JsonObject();
		jsons.addProperty("authstatus","0");
		jsons.addProperty("pagepath", "error.jsp");
		jsons.addProperty("tips", "��Ǹ,���������֤�벻��ȷ!");
		input.add("input", jsons);
		return input.toString();
	}
	
	public String userpasserror() {
		JsonObject jsons = new JsonObject();
		JsonObject input = new JsonObject();
		jsons.addProperty("authstatus","0");
		jsons.addProperty("pagepath", "error.jsp");
		jsons.addProperty("tips", "��Ǹ,���������������!");
		input.add("input", jsons);
		return input.toString();
	}
	
	public String userdis() {
		JsonObject jsons = new JsonObject();
		JsonObject input = new JsonObject();
		jsons.addProperty("authstatus","0");
		jsons.addProperty("pagepath", "error.jsp");
		jsons.addProperty("tips", "��Ǹ,�����û�������!");
		input.add("input", jsons);
		return input.toString();
	}
	
	public String usersuce() {
		JsonObject jsons = new JsonObject();
		JsonObject input = new JsonObject();
		jsons.addProperty("authstatus","1");
		jsons.addProperty("pagepath", "main.jsp");
		input.add("input", jsons);
		return input.toString();
	}
	
}

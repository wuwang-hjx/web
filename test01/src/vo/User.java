package vo;

import com.google.gson.JsonObject;

public class User {
	
	public String imgautherror() {
		JsonObject jsons = new JsonObject();
		JsonObject input = new JsonObject();
		jsons.addProperty("authstatus","0");
		jsons.addProperty("pagepath", "error.jsp");
		jsons.addProperty("tips", "抱歉,您输入的验证码不正确!");
		input.add("input", jsons);
		return input.toString();
	}
	
	public String userpasserror() {
		JsonObject jsons = new JsonObject();
		JsonObject input = new JsonObject();
		jsons.addProperty("authstatus","0");
		jsons.addProperty("pagepath", "error.jsp");
		jsons.addProperty("tips", "抱歉,您输入的密码有误!");
		input.add("input", jsons);
		return input.toString();
	}
	
	public String userdis() {
		JsonObject jsons = new JsonObject();
		JsonObject input = new JsonObject();
		jsons.addProperty("authstatus","0");
		jsons.addProperty("pagepath", "error.jsp");
		jsons.addProperty("tips", "抱歉,您的用户不存在!");
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

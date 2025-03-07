package MarshallaProgram;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UnmarshallingExample 
{
	public static void main(String[] args) throws Exception 
	{
		// Create ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();

		// JSON string
		String jsonString = "{\"id\":1,\"name\":\"Sharath\",\"age\":23,\"email\":\"Sharath@gmail.com\"}";

		// Convert JSON string to Student object
		Student student = objectMapper.readValue(jsonString, Student.class);
		System.out.println("Student Object: " + student);
	}
}

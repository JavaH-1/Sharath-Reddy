package MarshallaProgram;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MarshallingExample 
{
	public static void main(String[] args) throws Exception 
	{
		// Create ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();

		// Create a Student object
		Student student = new Student();
		student.setId(1);
		student.setName("Sharath");
		student.setAge(23);
		student.setEmail("Sharath@gmail.com");

		// Convert Student object to JSON
		String jsonString = objectMapper.writeValueAsString(student);
		System.out.println("JSON String: " + jsonString);
	}

}


package MarshallaProgram;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class MarshallingExampleObjectToXml {
    public static void main(String[] args) {
        try {
            // Create a Student object
            Student student = new Student();
            student.setId(1);
            student.setName("Sharath");
            student.setAge(23);
            student.setEmail("Sharath@gmail.com");

            // Create XmlMapper (ObjectMapper for XML)
            XmlMapper xmlMapper = new XmlMapper();

            // Convert Student object to XML string (Marshalling)
            String xmlString = xmlMapper.writeValueAsString(student);

            System.out.println("Marshalled XML:");
            System.out.println(xmlString);

            // Convert XML string back to Student object (Unmarshalling)
            Student unmarshalledStudent = xmlMapper.readValue(xmlString, Student.class);
            System.out.println("\nUnmarshalled Student Object:");
            System.out.println(unmarshalledStudent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

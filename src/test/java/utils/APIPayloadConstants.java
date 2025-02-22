package utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"martin\",\n" +
                "  \"emp_lastname\": \"sayar\",\n" +
                "  \"emp_middle_name\": \"ns\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1999-02-14\",\n" +
                "  \"emp_status\": \"permanent\",\n" +
                "  \"emp_job_title\": \"lead\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadJson() {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "martin");
        obj.put("emp_lastname", "sayar");
        obj.put("emp_middle_name", "ns");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1999-02-14");
        obj.put("emp_status", "permanent");
        obj.put("emp_job_title", "lead");

        return obj.toString();
    }

    public static String createEmployeePayloadJsonDynamic(String fName, String lName, String mName, String gender, String birthday, String status, String jobTitle) {
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", fName);
        obj.put("emp_lastname", lName);
        obj.put("emp_middle_name", mName);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", birthday);
        obj.put("emp_status", status);
        obj.put("emp_job_title", jobTitle);

        return obj.toString();
    }

}

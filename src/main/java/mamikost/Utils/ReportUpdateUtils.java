package mamikost.Utils;


import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static io.restassured.RestAssured.given;

public class ReportUpdateUtils {
    public static void updateReportAllureServer() throws IOException {
        String[] listFiles = {"result/api.json", "result/android.json"};
        String[] listProject = {"android", "api"};
        JSONObject jsonBody = new JSONObject();
        String allureServer = "http://localhost:5050";

        Map<String, List<Map<String, String>>> listProjectData = new HashMap<String, List<Map<String, String>>>();

        for (String project : listProject) {
            String fileName = "result/" + project + ".json";
            Map<String, String> report = new HashMap<String, String>();
            List<Map<String, String>> listContent = new ArrayList<Map<String, String>>();
            byte[] bytes = Files.readAllBytes(Paths.get(fileName));
            String base64Content = new String(Base64.getEncoder().encode(bytes));
            report.put("file_name", project + ".json");
            report.put("content_base64", base64Content);
            listContent.add(report);
            listProjectData.put(project, listContent);
        }

        for (String project : listProject) {
            jsonBody.put("results",  listProjectData.get(project));
            StringBuilder requestBuilder = new StringBuilder();
            requestBuilder.append(allureServer);
            requestBuilder.append("/allure-docker-service/send-results?project_id=");
            requestBuilder.append(project);

            Response body = given().header("Content-Type", "application/json")
                    .body(jsonBody.toString()).post(requestBuilder.toString());
            System.out.println(project + " Status " + body.getStatusCode());
            System.out.println(project + " Response " + body.getBody().asString());
        }

    }
}

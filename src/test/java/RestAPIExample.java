
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.zephyr.ZephyrFieldData;

import java.util.HashMap;
import java.util.Map;

public class RestAPIExample {
    @Test
    public void Zephyr_API_Manipulation(/*String testCycleIDorKey, String executionStatus, String executedTime*/) {

        RestAssured.baseURI = "https://api.zephyrscale.smartbear.com/v2";
        ZephyrFieldData zFD = new ZephyrFieldData();

        //testCycleIDorKey = zFD.getTestCycleIdKeyD();
        //executionStatus = zFD.getExecutionStatusD();
        //executedTime = zFD.getExecutedTimeD();

        Map<String,Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put(zFD.getProjectKeyF(), zFD.getProjectValueD());
        jsonAsMap.put(zFD.getTestCaseKeyF(), zFD.getTestCaseKeyD());
        jsonAsMap.put(zFD.getTestCycleKeyF(),zFD.getTestCycleIdKeyD());
        jsonAsMap.put(zFD.getStatusNameF(),zFD.getExecutionStatusD());
        jsonAsMap.put(zFD.getEnvironmentNameF(),zFD.getEnvironmentD());
        jsonAsMap.put(zFD.getExecutionTimeF(),zFD.getExecutedTimeD());
        jsonAsMap.put(zFD.getExecutedByIdF(),zFD.getJiraOwnerIdD());
        jsonAsMap.put(zFD.getAssignedToIdF(),zFD.getJiraOwnerIdD());


        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + zFD.getZephyrToken()).
                header("Content-Type","application/json");

        Response updateTestCycle = request.body(jsonAsMap).post("/testexecutions");
        Assertions.assertEquals(201,updateTestCycle.getStatusCode());
        updateTestCycle.prettyPrint();
    }
}
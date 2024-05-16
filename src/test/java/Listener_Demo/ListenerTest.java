package Listener_Demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.zephyr.ZephyrFieldData;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
public class ListenerTest implements ITestListener {
    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result)
    {
        String status = "Pass";
        String testCaseName;
        long millisecondTimeExecution;
        testCaseName = getTestCaseName(Result);
        millisecondTimeExecution = getExecutionTimeInMilli(Result);

        zephyrApiTestExecution(status, testCaseName, millisecondTimeExecution);
    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result)
    {
        String status = "Fail";
        String testCaseKey;
        long millisecondTimeExecution;
        testCaseKey = getTestCaseName(Result);
        millisecondTimeExecution = getExecutionTimeInMilli(Result);

        zephyrApiTestExecution(status, testCaseKey, millisecondTimeExecution);
    }

    private String getTestCaseName(ITestResult Result){
        Method method = Result.getMethod().getConstructorOrMethod().getMethod();
        Test test = method.getAnnotation(Test.class);

        String testCaseName = test.testName();
        //System.out.println("Test Case Name: " + testCaseName);

        switch (testCaseName){
            case "TestCase1" -> {return "CSH-T493";}
            case "TestCase2" -> {return "CSH-T505";}
            case "TestCase3" -> {return "CSH-T489";}
            case "TestCase4" -> {return "CSH-T502";}
            default -> throw new IllegalStateException("Unexpected value: " + testCaseName);
        }
    }
    private long getExecutionTimeInMilli(ITestResult Result) {
        long startTimeExe = Result.getStartMillis();
        long endTimeExe = Result.getEndMillis();
        long totalTimeExe = endTimeExe - startTimeExe;
        long second = 1000;

        //System.out.println("Real total time execution:" + totalTimeExe);

        if (totalTimeExe < second) totalTimeExe = second;

        //System.out.println("Modified total time execution:" +  totalTimeExe);

        return totalTimeExe;
    }
    private void zephyrApiTestExecution (String status, String testCaseKey, long executionTime){
        RestAssured.baseURI = "https://api.zephyrscale.smartbear.com/v2";
        ZephyrFieldData zFD = new ZephyrFieldData();

        Map<String,Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put(zFD.getProjectKeyF(), zFD.getProjectValueD());
        jsonAsMap.put(zFD.getTestCaseKeyF(), testCaseKey);
        jsonAsMap.put(zFD.getTestCycleKeyF(),zFD.getTestCycleIdKeyD());
        jsonAsMap.put(zFD.getStatusNameF(),status);
        jsonAsMap.put(zFD.getEnvironmentNameF(),zFD.getEnvironmentD());
        jsonAsMap.put(zFD.getExecutionTimeF(),executionTime);
        jsonAsMap.put(zFD.getExecutedByIdF(),zFD.getJiraOwnerIdD());
        jsonAsMap.put(zFD.getAssignedToIdF(),zFD.getJiraOwnerIdD());

        for (Map.Entry<?,?> entry : jsonAsMap.entrySet()){
            System.out.printf("%-15s : %s%n", entry.getKey(), entry.getValue());
        }

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + zFD.getZephyrToken()).
                header("Content-Type","application/json");

        Response updateTestCycle = request.body(jsonAsMap).post("/testexecutions");
        Assertions.assertEquals(201,updateTestCycle.getStatusCode());
        updateTestCycle.prettyPrint();
    }
}

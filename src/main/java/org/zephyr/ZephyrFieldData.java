package org.zephyr;

public class ZephyrFieldData {
    private static final String PROJECT_VALUE_D = "CSH";
    private static final String TEST_CASE_KEY_D = "CSH-T493"; //Dynamic Data
    private static final String TEST_CYCLE_IDorKEY_D = "CSH-R84";
    private static final String EXECUTION_STATUS_D = "blocked"; //Dynamic Data
    private static final String ENVIRONMENT_D = "QA";
    private static final String EXECUTED_TIME_D = "500"; //Dynamic Data
    private static final String JIRA_OWNER_ID_D = "712020:4e14dac5-494f-4cc8-9566-a979c120cf66";

    public String getProjectValueD(){return PROJECT_VALUE_D;}
    public String getTestCaseKeyD(){return TEST_CASE_KEY_D;}
    public String getTestCycleIdKeyD(){return TEST_CYCLE_IDorKEY_D;}
    public String getExecutionStatusD(){return EXECUTION_STATUS_D;}
    public String getEnvironmentD(){return ENVIRONMENT_D;}
    public String getExecutedTimeD(){return EXECUTED_TIME_D;}
    public String getJiraOwnerIdD(){return JIRA_OWNER_ID_D;}

    ///////
    private  static final String PROJECT_KEY_F = "projectKey";
    private static final String TEST_CASE_KEY_F = "testCaseKey";
    private static final String TEST_CYCLE_KEY_F = "testCycleKey";
    private static final String STATUS_NAME_F = "statusName";
    private static final String ENVIRONMENT_NAME_F = "environmentName";
    private static final String EXECUTION_TIME_F = "executionTime";
    private static final String EXECUTED_BY_ID_F = "executedById";
    private static final String ASSIGNED_TO_ID_F = "assignedToId";

    public String getProjectKeyF(){return PROJECT_KEY_F;}
    public String getTestCaseKeyF(){return TEST_CASE_KEY_F;}
    public String getTestCycleKeyF(){return TEST_CYCLE_KEY_F;}
    public String getStatusNameF(){return STATUS_NAME_F;}
    public String getEnvironmentNameF(){return ENVIRONMENT_NAME_F;}
    public String getExecutionTimeF(){return EXECUTION_TIME_F;}
    public String getExecutedByIdF(){return EXECUTED_BY_ID_F;}
    public String getAssignedToIdF(){return ASSIGNED_TO_ID_F;}

    private static final String ZEPHYR_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL3Bhbi1hbWVyaWNhbi5hdGxhc3NpYW4ubmV0IiwidXNlciI6eyJhY2NvdW50SWQiOiI3MTIwMjA6NGUxNGRhYzUtNDk0Zi00Y2M4LTk1NjYtYTk3OWMxMjBjZjY2In19LCJpc3MiOiJjb20ua2Fub2FoLnRlc3QtbWFuYWdlciIsInN1YiI6IjM3OTBlYmE3LWY1MmItM2ZkOS05NmFiLTM2MTViNmJjMDQ4YyIsImV4cCI6MTc0MDg1ODc1MiwiaWF0IjoxNzA5MzIyNzUyfQ.ujqSmaKPB-Aps2_xIHtALh82qcYSQDtB_MzXmOUxGoo";
    public String getZephyrToken(){return ZEPHYR_TOKEN;}
}

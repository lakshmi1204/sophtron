package org.sophtron.integration.service;

public final class Endpoints {

    public static final String INSTITUTIONS_BY_USER = "UserInstitution/GetUserInstitutionsByUser";
    public static final String INSTITUTION_BY_NAME = "Institution/GetInstitutionByName";
    public static final String USER_INSTITUTION_ACCOUNTS_BY_ID = "UserInstitution/GetUserInstitutionAccounts";
    public static final String USER_INSTITUTION_ACCOUNT_TRANSACTION_BY_DATE = "Transaction/GetTransactionsByTransactionDate";
    public static final String CREATE_USER_INSTITUTION = "UserInstitution/CreateUserInstitution";
    public static final String JOB_INFORMATION = "Job/GetJobInformationByID";
    public static final String JOB_UPDATE_SECURITY_ANSWER = "Job/UpdateJobSecurityAnswer";
    public static final String JOB_UPDATE_JOB_TOKEN_INPUT = "Job/UpdateJobTokenInput";
    public static final String JOB_UPDATE_JOB_CAPTCHA_INPUT = "Job/UpdateJobCaptchaInput";

}

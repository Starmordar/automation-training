package service;

import model.User;

public class UserCreator {
    public static final String TESTDATA_USER_EMAIL = "testdata.userData.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.userData.password";
    public static final String TESTDATA_USER_FIRSTNAME = "testdata.userData.firstName";
    public static final String TESTDATA_USER_LASTNAME = "testdata.userData.lastName";


    public static User authentificationData() {
        return new User(
                TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TestDataReader.getTestData(TESTDATA_USER_FIRSTNAME),
                TestDataReader.getTestData(TESTDATA_USER_LASTNAME)
        );
    }
}

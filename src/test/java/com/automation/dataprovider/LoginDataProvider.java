package com.automation.dataprovider;

import com.automation.utils.ExcelUtil;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return ExcelUtil.getTestData("Sheet1");
    }
}

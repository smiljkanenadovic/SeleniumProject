package dataGenerator;

import org.testng.annotations.DataProvider;
import utilities.PropertyManager;

public class DataProviders {
    @DataProvider(name = "failedLogin")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]
                {
                        {"", PropertyManager.getInstance().getValidPassword(), "Error: Username is required."},
                        {PropertyManager.getInstance().getValidUsername(), "", "ERROR: The password field is empty."},
                        {PropertyManager.getInstance().getInvalidUsername(), PropertyManager.getInstance().getInvalidPassword(),
                                "ERROR: The password you entered for the username user is incorrect. Lost your password?"}
                };
    }

    @DataProvider(name = "fillCheckoutData")
    public Object[][] getCheckoutDataFromDataProvider(){
        return new Object[][]
                {
                        {"Smiljka", "Bozic", "Serbia", "Knez Mihajlova 1", "Belgrade", "11000", "065555999", "smiljka@gmail.com"}
                };
    }

}


package test;

import api.UserAPI;
import db.DBUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIDBTest {

    @Test
    public void validateUserFromAPIAndDB() throws Exception {

        int userId = 2;

        Response response = UserAPI.getUser(userId);
        String apiName = response.jsonPath().getString("data.first_name");
        System.out.println(response.asPrettyString());

        DBUtils.connect();
        String dbName = DBUtils.getUserName(userId);
        DBUtils.close();

        Assert.assertEquals(apiName, dbName, "Mismatch between API and DB!");
    }

}
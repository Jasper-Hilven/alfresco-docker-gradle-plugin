package eu.xenit.gradle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thijs on 1/26/17.
 */
public class JenkinsUtil {

    /*
Returns an id with the date - the jenkins build number
 */
    public static String getBuildId() {
        String buildNumber = System.getenv().get("BUILD_NUMBER");
        if(buildNumber == null){
            return null;
        }
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        String dateText = dateFormat.format(now);
        return dateText+"-"+buildNumber;
    }

    public static String getBranch() {
        String branch = System.getenv().get("BRANCH_NAME");
        if (branch == null) return "local";
        return branch.toLowerCase();
    }
}

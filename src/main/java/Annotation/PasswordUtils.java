package Annotation;

/**
 * Created by root on 16-2-19.
 */
public class PasswordUtils {

    @UserCase(id = 47, description = "Password must contain at least one number")
    public boolean validatePassword(String password) {
        return true;
    }

    @UserCase(id = 48)
    public String encryptPassword(String password) {
        return "XXX";
    }

    @UserCase(id =49, description = "New Password can't equal previously used ones")
    public boolean checkForNewPassword() {
        return true;
    }

}

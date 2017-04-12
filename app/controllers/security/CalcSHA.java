package controllers.security;

import java.security.MessageDigest;

public class CalcSHA {

    public String calcPassword(String password) {
        String salt = "blue fluffy cheese";
        password = password + salt;
        String output = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

//convert the byte to hex format method 2
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            output = hexString.toString();
        } catch (Exception e) {

            output = "error";

        }
        return output;
    }

}

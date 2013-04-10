package edu.stanford.bmir.protege.web.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.stanford.bmir.protege.web.client.rpc.RecaptchaService;
import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 04/06/2012
 */
public class RecaptchaServiceImpl extends RemoteServiceServlet implements RecaptchaService {

    private static final String PRIVATE_KEY = "6Le8WNISAAAAAAOO9H7DqIfADsDTnppfbXUN9r1r";

    private static final String CAPTCHA_URL = "http://www.google.com/recaptcha/api/verify";

    public boolean isSuccessful(String challenge, String response) {
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey(PRIVATE_KEY);

        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(CAPTCHA_URL, challenge, response);
        if(reCaptchaResponse.isValid()) {
            System.out.println("VALID");
            return true;
        }
        else {
            System.out.println("INVALID");
            System.out.println("Error Message: " + reCaptchaResponse.getErrorMessage());
            return false;
        }
    }
}
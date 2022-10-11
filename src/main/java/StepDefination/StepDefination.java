package StepDefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.plugin.event.Node;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.Driver;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import Objects.locators;


public class StepDefination {


    @Given("You are on the login screen")
    public void you_are_on_the_login_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.login_screen);
    }

    @Then("Enter username as {string}")
    public void enter_username_as(String string) {
        DriverAction.typeText(locators.user_name, "raghavsuneja123");

    }

    @Then("Enter Password")
    public void enter_password() {
        DriverAction.typeText(locators.password, "Abc123@@");

        try {
            DriverAction.click(locators.login_button, "Login Button", "Clicked Successfully on the Login Button");
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("Verify Logout button is visible or not")
    public void verify_logout_button_is_visible_or_not() {
        try {

            DriverAction.waitSec(2);
            DriverAction.click(locators.home_button, "Click on Home Button", " Clicked successfully on the Home Button");
            DriverAction.waitSec(2);
            DriverAction.click(locators.profile, "Click on Profile button", "Clicked on the Profile Button");

            GemTestReporter.addTestStep("Status of logout button", "Logout button is  visible", STATUS.PASS, DriverAction.takeSnapShot());
            Boolean b = DriverAction.getElement(locators.log_out).isDisplayed();
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Status of logout button", "Logout button is not visible", STATUS.FAIL);

        }


    }


    @Then("Verify the text of the Home screen")
    public void verify_the_text_of_the_home_screen() {
        try {

            DriverAction.waitSec(2);
            DriverAction.click(locators.home_button, "Home Button", "Clicked Successfully on the Home Button");
            String s = DriverAction.getElement(locators.page_title).getText();
            GemTestReporter.addTestStep("Text of Home Screen", s, STATUS.INFO);

            System.out.println(s);
            if (s.equals("Jewel Applications")) {
                GemTestReporter.addTestStep("Text of Home screen", "Expected :Jewel Applications", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Text of Home screen", "Expected :Jewel Applications", STATUS.FAIL, DriverAction.takeSnapShot());
            }


        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("ERROR!", "Something wrong Happened", STATUS.FAIL);
        }
    }

    @Then("Click on the Autolytics screen")
    public void click_on_the_autolytics_screen() {
        DriverAction.click(locators.home_button, "Home button", "Successfully clicked on the Home button");


        boolean present;
        try {
            DriverManager.getWebDriver().findElement(locators.autolytics);
            present = true;
        } catch (Exception e) {
            present = false;
        }


        if (present == true) {
            try {
                DriverAction.click(locators.autolytics, "Autolytics Button", "Successfully clicked on the Autolytics Button");
            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Autolytics Button Status", "Not clicked", STATUS.FAIL);
            }

        } else {
            GemTestReporter.addTestStep("Autolytics Button Status", "Not Found", STATUS.FAIL);

        }
    }


    @Then("Verify the Autolytics Screen")
    public void verify_the_autolytics_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home Button", "Click was successful");
        try {


            DriverAction.click(locators.autolytics, "Autolytics Button", "Click was Successful");
            String s = DriverAction.getCurrentURL();

            if (s.contains("autolytics")) {
                GemTestReporter.addTestStep("AUtolytics window", "Window is opened successfully", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("AUtolytics window", "Window is not opened successfully", STATUS.FAIL);

            }

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Status of Autolytics button", "Clicked Fsiled", STATUS.FAIL);
        }
    }


    @Then("Verify the Bridge Token Button is clickable or not")
    public void verify_the_bridge_token_button_is_clickable_or_not() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home Button", "Click was successful");


        boolean present;
        try {
            DriverManager.getWebDriver().findElement(locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }


        if (present == true) {

            try {
                DriverAction.click(locators.bridge_token, "Bridge token Button", "Click was successful");
                String s = DriverAction.getCurrentURL();

                if (s.contains("bridge-token")) {
                    GemTestReporter.addTestStep("Bridge Token window", "Window was opened successfully", STATUS.PASS);
                } else {
                    GemTestReporter.addTestStep("Bridge Token window", "Window was not opened successfully", STATUS.FAIL);

                }

            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Bridge Token window", "Button NOt Present", STATUS.FAIL);

        }
    }

    @Then("Click on Copy Bridge Token")
    public void click_on_copy_bridge_token() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button);
        try {
            DriverAction.click(locators.bridge_token, "Bridge token Button", "Click was successful");
            String s = DriverAction.getCurrentURL();
            if (s.contains("bridge-token")) {
                GemTestReporter.addTestStep("Bridge Token window", "Window is opened successfully", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Autolytics window", "Window is not opened successfully", STATUS.FAIL);
            }
            boolean present;
            try {
                DriverManager.getWebDriver().findElement(locators.copy_bridge_token);
                present = true;
            } catch (Exception e) {
                present = false;
            }
            if (present == true) {
                try {
                    DriverAction.click(locators.copy_bridge_token, "copy button", "Click was successful");
                    DriverAction.waitSec(2);
                    GemTestReporter.addTestStep("Status of Copy button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());

                } catch (Exception e) {
                    e.printStackTrace();
                    GemTestReporter.addTestStep("Status of Copy button", "Not clicked", STATUS.FAIL);
                }
            } else {
                GemTestReporter.addTestStep("Status of Copy button", "Not Found", STATUS.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
        }
    }

    @Then("Verify the Alert when copy button is clicked")
    public void verify_the_alert_when_copy_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home button", "Home button was clicked");
        boolean present;
        try {
            DriverManager.getWebDriver().findElement(locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present == true) {
            try {
                DriverAction.click(locators.bridge_token, "Bridge token Button", "Bridge token was clicked");
                String s = DriverAction.getCurrentURL();

                if (s.contains("bridge-token")) {
                    GemTestReporter.addTestStep("Bridge Token window", "Window is opened successfully", STATUS.PASS);
                } else {
                    GemTestReporter.addTestStep("AUtolytics window", "Window is not opened successfully", STATUS.FAIL);
                }
                try {
                    DriverAction.click(locators.copy_bridge_token, "copy button", "Copy button was clicked");
                    DriverAction.waitSec(1);
                    GemTestReporter.addTestStep("Status of Copy button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());

                } catch (Exception e) {
                    e.printStackTrace();
                    GemTestReporter.addTestStep("Status of Copy button", "Not clicked", STATUS.FAIL);
                }
                String se = DriverAction.getElement(locators.copy_alert).getText();
                if (se.equals("Copied !")) {
                    GemTestReporter.addTestStep("Alert status", "Expected alert:Copied ", STATUS.PASS);
                } else {
                    GemTestReporter.addTestStep("Alert status", "Expected alert:Copied ", STATUS.FAIL);
                }
            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Status of Bridge Token button", "Not Found", STATUS.FAIL);

        }
    }

    @Then("Verify the date and time when Change Token button is clicked")
    public void verify_the_date_and_time_when_change_token_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home button", "Home button was clicked");
        try {
            DriverAction.click(locators.bridge_token);
            try {
                DriverAction.click(locators.change_token, "Change token button", "Change Token button was clicked");
                DriverAction.waitSec(1);
                GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());

            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Status of Change Token button", "Not clicked", STATUS.FAIL);
            }

            DriverAction.waitSec(2);
            String time = DriverAction.getElement(locators.date_tab).getText();
            System.out.println(time);
            String timep = time.substring(11, 28);
            String date = timep;
//            String r = String.valueOf(date.charAt(0));
//            if (r.equals(" ")) {
//                date = "0" + date.substring(1);
//            }

            SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd,yyyy", Locale.ENGLISH);

            String dateInString = date;
            Date dateupdate = formatter.parse(dateInString);

            System.out.println(dateupdate);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            LocalDateTime now = LocalDateTime.now();
            String loc = dtf.format(now);
            if (StringUtils.contains(date, loc)) {
                GemTestReporter.addTestStep("Checking date", "Dates are matching", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Checking date", "Dates are not matching", STATUS.FAIL);
            }
            String times = time.substring(27, 35);
            System.out.println(times);
            String[] hel = times.split(":", 3);
            System.out.println(hel[0]);
            String jo = hel[0];
            String koko = String.valueOf(jo.charAt(0));
            if (koko.equals(" ")) {
                jo = "0" + jo.substring(1);
                hel[0] = jo;
            }
            System.out.println(hel[0]);
            System.out.println(hel[1]);
            DateTimeFormatter Time = DateTimeFormatter.ofPattern("hh/mm/ss");
            LocalDateTime ti = LocalDateTime.now();
            String timess = Time.format(ti);
            System.out.println(timess);
            String[] locat = timess.split("/", 3);
            int flag = 0;
            for (int o = 0; o < locat.length - 1; o++) {
                int numberlocal = Integer.parseInt(locat[o]);
                int get = Integer.parseInt(hel[o]);
                if (numberlocal - get < 5) {
                    flag = 0;
                } else {
                    flag = 1;
                }
            }
            if (flag == 0) {
                GemTestReporter.addTestStep("Comparing time", "Time is matching", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Comparing time", "Time is not matching", STATUS.FAIL);

            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }


    @Then("Verify the Alert when Change Token button is clicked")
    public void verify_the_alert_when_change_token_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home button", "Home button was clicked");
        try {
            DriverAction.click(locators.bridge_token);
            try {
                DriverAction.click(locators.change_token, "Change token button", "Change Token button was clicked");
                DriverAction.waitSec(1);
                GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());

            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Status of Change Token button", "Not clicked", STATUS.FAIL);
            }
            String fi = DriverAction.getElement(locators.change_token_alert).getText();
            if (fi.contains("Bridge Token Changed Successfully.")) {
                GemTestReporter.addTestStep("Alert status", "Expected alert:Changed successfully", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Alert status", "Expected alert:Changed successfully", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Click and verify the Logout button")
    public void click_and_verify_the_logout_button() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home button", "Home Button was clicked");
        try {
            DriverAction.waitSec(3);
            DriverAction.click(locators.pelement, "Profile Element", "Successfully clicked on the Profile");
            DriverAction.waitSec(3);
            DriverAction.click(locators.lelement, "Logout button", "Successfully clicked on the logout button");
            DriverAction.waitSec(2);

            String titlee = DriverAction.getCurrentURL();
            System.out.println(titlee);
            if (titlee.equals("https://jewel.gemecosystem.com/#/login")) {
                GemTestReporter.addTestStep("Verifying the URL", "Expected :https://jewel.gemecosystem.com/#/login", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Verifying the URL", "Expected :https://jewel.gemecosystem.com/#/login", STATUS.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the content of the Home screen")
    public void verify_the_content_of_the_home_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home Button", "Successfully clicked on the Home button");
        GemTestReporter.addTestStep("Successfully clicked", "Jewel Window", STATUS.INFO, DriverAction.takeSnapShot());
        try {
            String text = DriverAction.getElement(locators.page_title).getText();
            System.out.println(text);
            if (text.equals("Jewel Applications")) {
                GemTestReporter.addTestStep("Title validation", "Expected Title:Jewel Applications", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Title validation", "Expected Title:Jewel Applications", STATUS.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the Cards present on the home screen")
    public void verify_the_cards_present_on_the_home_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home Button", "Successfully clicked on the Home button");

        try {
            List num = DriverAction.getElements(locators.cards);
            if (num.size() == 2) {
                GemTestReporter.addTestStep("Number of Cards Present ", "Expcted :2", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Number of Cards Present ", "Expcted :2", STATUS.FAIL);
            }
            System.out.println(num.size());

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the Autolytics Cards present on the home screen")
    public void verify_the_autolytics_cards_present_on_the_home_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home Button", "Successfully clicked on the Home button");
        try {

            String nuam = DriverAction.getElement(locators.card_one).getText();

            if (nuam.equals("Autolytics")) {
                GemTestReporter.addTestStep("Validating the Autolytics card", "Expcted :Autolytics", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Validating the Autolytics card", "Expcted :Autolytics", STATUS.FAIL);

            }

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the Autolytics Card Content")
    public void verify_the_autolytics_card_content() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home button", "Home button was clicked successfully");

        try {

            String nuam = DriverAction.getElement(locators.content_card_one).getText();
            System.out.println(nuam);
            if (nuam.equals("Autolytics provides the feature for generating descriptive reports to analyze the Testcases/Suite details and also enables users to share them effortlessly.")) {
                GemTestReporter.addTestStep("Validating the Autolytics card Content", "Expcted :Autolytics provides the feature for generating descriptive reports to analyze the Testcases/Suite details and also enables users to share them effortlessly.", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Validating the Autolytics card", "Expcted :Autolytics provides the feature for generating descriptive reports to analyze the Testcases/Suite details and also enables users to share them effortlessly.", STATUS.FAIL);

            }

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify if the Bridge token card is visible")
    public void verify_if_the_bridge_token_card_is_visible() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home Button", "Home button was clicked successfully");

        try {

            String nuam = DriverAction.getElement(locators.card_two).getText();

            if (nuam.equals("Bridge Token")) {
                GemTestReporter.addTestStep("Validating the Bridge Token card", "Expcted :Bridge Token", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Validating the Bridge Token card", "Expcted :Bridge Token", STATUS.FAIL);
            }

        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Validate the content of the Bridge Token card")
    public void validate_the_content_of_the_bridge_token_card() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home Button", "Home button was clicked successfully");

        try {

            String nuam = DriverAction.getElement(locators.content_card_two).getText();
            System.out.println(nuam);
            if (nuam.equals("Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.")) {
                GemTestReporter.addTestStep("Validating the Bridge Token card Content", "Expcted :Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Validating the Autolytics card", "Expcted :Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.", STATUS.FAIL);

            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Validate alert ,username and status of the window button")
    public void validate_alert_username_and_status_of_the_window_button() {
        try {
            DriverAction.click(locators.home_button, "Home Button", "Home button was clicked successfully");

            DriverAction.waitSec(2);
//            GemTestReporter.addTestStep("Login Success", "Successfully Logged in!!", STATUS.PASS);
            String s = DriverAction.getElementText(locators.login_alert);
            System.out.println(s);
            GemTestReporter.addTestStep("Alert Text", s, STATUS.INFO);
            DriverAction.waitSec(5);
            DriverAction.waitSec(5);
            try {
                DriverAction.click(locators.three_lines_button, "Three Lines button", "Successfully clicked on the three lines ");
                GemTestReporter.addTestStep("Button Status", "Clicked on the button", STATUS.PASS);

            } catch (Exception e) {
                GemTestReporter.addTestStep("Button Status", "Button Not clicked", STATUS.FAIL);

            }
            DriverAction.waitSec(2);
            String y = DriverAction.getElementText(locators.home_button);
            if (y == "Home") {
                GemTestReporter.addTestStep("Status of the side window", "Whole text is appearing", STATUS.INFO);
            } else {
                GemTestReporter.addTestStep("Status of the side window", "Only icons are appearing", STATUS.INFO);
            }
            try {
                DriverAction.click(locators.profile, "Usernane button", "Successfully clicked on the Username button");
                DriverAction.waitSec(2);
            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("CLick on the username", "FAiled!!", STATUS.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep("Something wrong Happened", "Error!!", STATUS.FAIL);
        }
    }

    @Then("Validate if there is change token button available ,if so click it")
    public void validate_if_there_is_change_token_button_available_if_so_click_it() {
        DriverAction.waitSec(2);
        DriverAction.click(locators.home_button, "Home Button", "Home button was clicked successfully");

        boolean present;
        try {
            DriverManager.getWebDriver().findElement(locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present == true) {
            try {


                DriverAction.click(locators.bridge_token, "Bridge Token button", "Button was clicked successfully");

                try {


                    DriverAction.click(locators.change_token, "Change token button", "Button was clicked Successfully");
                    DriverAction.waitSec(1);
                    GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());


                } catch (Exception e) {
                    e.printStackTrace();
                    GemTestReporter.addTestStep("Status of Change Token button", "Not clicked", STATUS.FAIL);
                }

            } catch (Exception e) {
                e.printStackTrace();
                GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Error", "No such element", STATUS.FAIL);
        }

    }

    @Given("You are on the Sign up screen")
    public void you_are_on_the_sign_up_screen() {


        DriverAction.navigateToUrl("https://jewel-beta.gemecosystem.com/#/", true);


    }

    @Then("Click on the Sign up Button")
    public void click_on_the_sign_up_button() {
        DriverAction.waitSec(3);
        DriverAction.click(locators.signup_button, "Sign up button", "Successfully clicked");
        DriverAction.waitSec(3);
        GemTestReporter.addTestStep("Sign up screen", "Loaded", STATUS.INFO, DriverAction.takeSnapShot());
    }

    @Then("Enter random username")
    public void enter_random_username() {
        DriverAction.waitSec(2);
        DriverAction.typeText(locators.first_name, "Hello");
        DriverAction.waitSec(3);
    }

    @Then("Enter all the fields and Validate the status")
    public void enter_all_the_fields_and_validate_the_status() {
        DriverAction.waitSec(2);
        DriverAction.typeText(locators.last_name, "Jewel", "Last Name");
        DriverAction.waitSec(2);
        DriverAction.typeText(locators.user_name, "test1" + System.currentTimeMillis(), "Username");
        DriverAction.waitSec(2);

        DriverAction.typeText(locators.email, "test.jew@geminisolutions.com", "Test.jewel@geminisolutions.com");

        GemTestReporter.addTestStep("Status of username", "Clicked successfully", STATUS.INFO, DriverAction.takeSnapShot());
        DriverAction.typeText(locators.password, "Hellothere", "Password");
        DriverAction.waitSec(2);
        DriverAction.typeText(locators.confirm_pass, "Hellothere", "Confirm Password");
        DriverAction.waitSec(2);
        DriverAction.typeText(locators.company_name, "Gemini solutions", "Company Name");
        DriverAction.click(locators.register_button, "Register button", "Successfully clicked on the Register Button");
        DriverAction.waitSec(1);
//button[text()='Register']

        String text = DriverAction.getElement(locators.register_alert).getText();
        System.out.println(text);
        if (text.equals("User Registered.")) {
            GemTestReporter.addTestStep("User Registered Status", "User Registered Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("User Registered Status", "User is not Registered successfully", STATUS.FAIL, DriverAction.takeSnapShot());
        }


        try {
            String tt = DriverManager.getWebDriver().getCurrentUrl();
            if (tt.contains("login")) {
                GemTestReporter.addTestStep("Login screen status", "Opened Successfully", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Login Screen Status", "Errror Occurred", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }
//    @Then("Enter all the fields")
//    public void enter_all_the_fields() {
//        DriverAction.waitSec(2);
//        DriverAction.typeText(By.xpath("//input[@placeholder='Lastname']"), "Jewel", "Last Name");
//        DriverAction.waitSec(2);
//        DriverAction.typeText(By.xpath("//input[@placeholder='Username']"), "test1" + System.currentTimeMillis(), "Username");
//        DriverAction.waitSec(2);
//
//        DriverAction.typeText(By.xpath("//input[@placeholder='Email']"), "test.jew@geminisolutions.com", "Test.jewel@geminisolutions.com");
//
//        GemTestReporter.addTestStep("Status of username", "Clicked successfully", STATUS.INFO, DriverAction.takeSnapShot());
//        DriverAction.typeText(By.xpath("//input[@placeholder='Password']"), "Hellothere", "Password");
//        DriverAction.waitSec(2);
//        DriverAction.typeText(By.xpath("//input[@placeholder='Confirm Password']"), "Hellothere", "Confirm Password");
//        DriverAction.waitSec(2);
//        DriverAction.typeText(By.xpath("//input[@placeholder='Company Name']"), "Gemini solutions", "Company Name");
//        DriverAction.click(By.xpath("//button[text()='Register']"), "Register button");
//        DriverAction.waitSec(1);
////button[text()='Register']
//
//        String text = DriverAction.getElement(By.xpath("//div[text()='User Registered.']")).getText();
//        System.out.println(text);
//        if (text.equals("User Registered.")) {
//            GemTestReporter.addTestStep("User Registered Status", "User Registered Successfully", STATUS.PASS, DriverAction.takeSnapShot());
//        } else {
//            GemTestReporter.addTestStep("User Registered Status", "User is not Registered successfully", STATUS.FAIL, DriverAction.takeSnapShot());
//        }
//
//
//        try {
//            String tt = DriverManager.getWebDriver().getCurrentUrl();
//            if (tt.contains("login")) {
//                GemTestReporter.addTestStep("Login screen status", "Opened Successfully", STATUS.PASS, DriverAction.takeSnapShot());
//            }
//        } catch (Exception e) {
//            GemTestReporter.addTestStep("Login Screen Status", "Errror Occurred", STATUS.FAIL, DriverAction.takeSnapShot());
//        }
//
//
//        LocalTime time = LocalTime.now();
//        System.out.println("Current time: " + time);
//    }

    @Then("Click on Create Report Tab")
    public void click_on_create_report_tab() {
        addnewtabs();

    }

    public void addnewtabs() {
        DriverAction.click(By.xpath("//div[text()='Autolytics']"), "Report", "Autolytics button");
        DriverAction.click(locators.create_report, "Create Report", "Clicked Successful");
        DriverAction.waitSec(4);
        DriverAction.click(locators.report_name_button, "Clicked on Report name was successful");
        DriverAction.waitSec(2);
        DriverAction.click(locators.suite_run, "Suite run Report", "Successfully clicked on Suite Run  report");
        DriverAction.waitSec(2);
        DriverAction.click(locators.project_name, "Project name", "Clicked on the Project name");
        DriverAction.waitSec(2);
        DriverAction.click(locators.project_name_selection, "Select from the dropdown", "Successfully clicked on JEWEL_UI_JV");
        DriverAction.waitSec(2);
        DriverAction.click(locators.cross_button, "Cross button", "successfully clicked");
        DriverAction.waitSec(2);
        DriverAction.click(locators.env_tab, "Environment selection", "Successfully clicked on the Environment button");
        DriverAction.waitSec(2);
        DriverAction.click(locators.select_env, "Select the Environment", "Successfully selected the environment");
        DriverAction.waitSec(2);
        DriverAction.click(locators.cbutton, "Cross button", "Successfully clicked on the cross button");
        DriverAction.waitSec(2);

        DriverAction.click(locators.date_range_tab, "Select Date Range", "Successfully clicked on the date range tab");
        DriverAction.waitSec(2);
        DriverAction.click(locators.select_date, "Select value", "Successfully selected the value");
        DriverAction.waitSec(2);
        DriverAction.click(locators.generate_button, "Generate button", "Click was successful");
        DriverAction.waitSec(3);

    }

    List<WebElement> hi = DriverAction.getElements(locators.left_tabs);

    @Then("Open few tabs")
    public void open_few_tabs() {

        for (int i = 0; i < 3; i++) {
            DriverAction.click(locators.new_tab, "New Tab Button", "Clicked Successful");
            addnewtabs();
        }
        List<WebElement> hi = DriverAction.getElements(locators.left_tabs);
        if (hi.size() == 4) {
            GemTestReporter.addTestStep("Number of Tabs", "Expected :4", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Number of Steps", "Expected :4", STATUS.FAIL);
        }
    }

    @Then("Click on SLide left button")
    public void Click_on_SLide_left_button() {
        DriverAction.click(locators.left_most_tab, "Left Most Tab", "Clicked Successful");
        DriverAction.waitSec(2);
        DriverAction.switchToActiveElement();

        WebElement l = DriverAction.getElement(locators.tab_select);

//activeElement() to verify element focused
        String element = l.getAttribute("aria-selected");
        if (element.equals("true")) {
            GemTestReporter.addTestStep("Left Most clicked Status", "Successfully clicked", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("Left Most clicked Status", "Clicked Failure", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }


    @Then("Click on the SLide most Right button")
    public void click_on_the_s_lide_most_right_button() {
        DriverAction.click(locators.right_most_tab, "Right Most Tab", "Clicked Successful");
        DriverAction.waitSec(1);
        WebElement l = DriverAction.getElement(locators.tabs);

//activeElement() to verify element focused
        String element = l.getAttribute("aria-selected");
        if (element.equals("true")) {
            GemTestReporter.addTestStep("Right most Clicked Status", "Successfully clicked", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("Right most Clicked Status", "Clicked Failure", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Then("Click on the slide to next left button")
    public void click_on_the_slide_to_next_left_button() {
        try {


            DriverAction.click(locators.slide_left, "Slide Left Tab button", "Successfully clickeb");


            DriverAction.waitSec(1);
            WebElement l = DriverAction.getElement(locators.parent_tab);


            String element = l.getAttribute("aria-selected");
            if (element.equals("true")) {
                GemTestReporter.addTestStep("Left Tab Clicked Status", "Successfully clicked", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Left tab Clicked Status", "Clicked Failure", STATUS.FAIL, DriverAction.takeSnapShot());
            }


        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR!", "Something wrong Happened", STATUS.FAIL);
        }
    }

    @Then("Click on the Slide to next right button")
    public void click_on_the_slide_to_next_right_button() {
        try {
            DriverAction.click(locators.slide_right, "Slide Right Tab button", "Successfully clicked");


            DriverAction.waitSec(1);
            WebElement l = DriverAction.getElement(locators.tabs);


            String element = l.getAttribute("aria-selected");
            if (element.equals("true")) {
                GemTestReporter.addTestStep("Left Tab Clicked Status", "Successfully clicked", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Left tab Clicked Status", "Clicked Failure", STATUS.FAIL, DriverAction.takeSnapShot());
            }


        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR!", "Something wrong Happened", STATUS.FAIL);
        }
    }

    @Then("Validate the active tabs")
    public void validate_the_active_tabs() {

    }


    @Then("Open a new tab")
    public void open_a_new_tab() throws IOException, UnsupportedFlavorException {
        addnewtabs();
        DriverAction.waitSec(5);
        DriverAction.click(locators.copy_report_link);
        DriverAction.waitSec(4);

        ((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("window.open()");// launching a new tab

        List<String> winHandles = new ArrayList<>(DriverManager.getWebDriver().getWindowHandles());
        DriverAction.waitSec(2);
        DriverManager.getWebDriver().switchTo().window(winHandles.get(1));

        DriverAction.waitSec(5);


        String h = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

        DriverAction.waitSec(5);
        DriverAction.navigateToUrl(h);
        DriverAction.waitSec(5);

        String url = DriverAction.getCurrentURL();
        if (url.equals(h)) {
            GemTestReporter.addTestStep("Current Url", url, STATUS.PASS);


            String s = DriverAction.getElement(locators.check_text_of_report).getText();
            if (s.equalsIgnoreCase("Shared Report")) {
                GemTestReporter.addTestStep("Heading validation", "Expected: Shared Report", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Heading validation", "Expected: Shared Report", STATUS.FAIL);

            }
        } else {
            GemTestReporter.addTestStep("Current Url", url, STATUS.FAIL);
        }


//        Actions actions = new Actions(DriverManager.getWebDriver());
//        actions.sendKeys(Keys.CONTROL, "v").sendKeys(Keys.ENTER).build().perform();


//        DriverManager.getWebDriver().switchTo().newWindow(WindowType.TAB);
//// Opens LambdaTest homepage in the newly opened tab
//        String s = Keys.chord(Keys.CONTROL, "v");
//        DriverManager.getWebDriver().navigate().to(s);
//        DriverAction.waitSec(6);
//        Actions actions = new Actions(DriverManager.getWebDriver());
//        actions.sendKeys(Keys.COMMAND, "v").sendKeys(Keys.ENTER).build().perform(); //sending the paste comman
    }
/////////////////////////////////////////////

    @Then("Logout the Account")
    public void logout_the_account() throws IOException, UnsupportedFlavorException {
        addnewtabs();
        DriverAction.click(locators.copy_report_link);
        DriverAction.waitSec(4);


        String h = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

        DriverAction.waitSec(5);
        ChromeOptions o = new ChromeOptions();
        o.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(o);
        driver.get(h);

    }

    //////////////////////////////////////////////////////////
    @Given("^user clicks on logIn button and closes it$")
    public void logIn() throws Exception {
        DriverAction.waitSec(2);
        DriverAction.click(locators.logIn, "Click on login button", "Click on login button is successful");
        DriverAction.waitSec(2);
        DriverAction.click(locators.close);
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Click on cross button", "Click on cross button is successful", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Then("^user again clicks on logIn button and enters (.+) and (.+)")
    public void loginPage(String Username, String Password) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.click(locators.logIn);
        DriverAction.waitSec(2);
        DriverAction.click(locators.username);
        DriverAction.waitSec(1);
        DriverAction.typeText(locators.username, Username, "Enter Username", "Username has been entered: " + Username + " ");
        DriverAction.waitSec(1);
        DriverAction.click(locators.passwordm);
        DriverAction.waitSec(1);
        DriverAction.typeText(locators.passwordm, Password);
        DriverAction.waitSec(1);
        GemTestReporter.addTestStep("Enter Password", "Password has been entered: " + Password + " ", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.waitSec(3);
        DriverAction.click(locators.eye, "Click on open eye button", "Click on open eye button successful");
        DriverAction.waitSec(1);
        DriverAction.click(locators.eyeclose, "Click on close eye button", "Click on close eye button successful");
        DriverAction.waitSec(1);
    }

    @Then("^user navigates back after loggin in$")
    public void logout() throws Exception {
        DriverAction.waitSec(2);
        DriverAction.click(locators.LoginButton);
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Logged in", "Logged in inside website", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.navigateBack();
        DriverAction.waitSec(3);
    }

    @Given("^validating url of jewel (.+)$")
    public void jewelurl(String expectedUrl) throws Exception {
        DriverAction.waitSec(2);
        String s1 = DriverAction.getCurrentURL();
        if (s1.equals(expectedUrl)) {
            GemTestReporter.addTestStep("Jewel Url Validation", "Successful<br>Expected Jewel URL: " + expectedUrl + "<br>Actual Jewel URL: " + s1, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Jewel Url Validation", "Unsuccessful<br>Expected Jewel URL: " + expectedUrl + "<br>Actual Jewel URL: " + s1, STATUS.PASS);
        }
    }

    @Then("^click on pricing$")
    public void pricing() throws Exception {
        DriverAction.click(locators.pricing, "Click on pricing", "Click on pricing successful");
        DriverAction.waitSec(2);
    }

    @Then("^validate pricing url (.+)$")
    public void pricingurl(String expectedPurl) throws Exception {
        DriverAction.waitSec(2);
        String s2 = DriverAction.getCurrentURL();
        if (s2.equals(expectedPurl)) {
            GemTestReporter.addTestStep("Pricing Url Validation", "Successful<br>Expected Pricing URL: " + expectedPurl + "<br>Actual Pricing URL: " + s2, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Pricing Url Validation", "Unsuccessful<br>Expected Pricing URL: " + expectedPurl + "<br>Actual Pricing URL: " + s2, STATUS.FAIL);
        }
    }

    @Given("^clicking on pricing and checking for main heading (.+)$")
    public void clickpricing(String pricingHead) throws Exception {
        DriverAction.waitSec(2);
        DriverAction.click(locators.pricing);
        DriverAction.waitSec(4);
        String s3 = DriverAction.getElementText(locators.pricingheading);
        if (s3.equals(pricingHead)) {
            GemTestReporter.addTestStep("Pricing heading validation", "Successful<br>Expected heading1: " + pricingHead + "<br>Actual heading1: " + s3, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Pricing heading validation", "unsuccessful<br>Expected heading1: " + pricingHead + "<br>Actual heading1: " + s3, STATUS.FAIL);
        }
    }

    @Then("^checking for subheading (.+)$")
    public void subheading(String pricingSubHead) throws Exception {
        String s4 = DriverAction.getElementText(locators.pricingsubheading);
        if (s4.equals(pricingSubHead)) {
            GemTestReporter.addTestStep("Pricing heading2 validation", "Successful<br>Expected heading2: " + pricingSubHead + "<br>Actual heading2: " + s4, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Pricing heading2 validation", "Unsuccessful<br>Expected heading2: " + pricingSubHead + "<br>Actual heading2: " + s4, STATUS.FAIL);
        }
    }

    @Then("^checking for text (.+)$")
    public void text(String Text) throws Exception {
        String s4 = DriverAction.getElementText(locators.pricingcontent);
        if (s4.equals(Text)) {
            GemTestReporter.addTestStep("Pricing content validation", "Successful<br>Expected Pricing content: " + Text + "<br>Actual Pricing content: " + s4, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Pricing content validation", "Unsuccessful<br>Expected Pricing content: " + Text + "<br>Actual Pricing content: " + s4, STATUS.FAIL);
        }
    }

    @Given("^clicking on jewel again validating main heading (.+)$")
    public void jewelhead(String mainHeading) {
        DriverAction.waitSec(3);
        String s5 = DriverAction.getElementText(locators.jewelheading);
        if (s5.equals(mainHeading)) {
            GemTestReporter.addTestStep("Jewel heading validation", "Successful<br>Expected heading: " + mainHeading + "<br>Actual head: " + s5, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Jewel heading validation", "Unsuccessful<br>Expected heading: " + mainHeading + "<br>Actual head: " + s5, STATUS.FAIL);
        }
    }

    @Then("^validating subheading of jewel (.+)$")
    public void jewelShead(String subHeading) {
        String s6 = DriverAction.getElementText(locators.jewelsubheading);
        if (s6.equals(subHeading)) {
            GemTestReporter.addTestStep("Jewel content validation", "Successful<br>Expected content: " + subHeading + "<br>Actual content: " + s6, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Jewel content validation", "Unsuccessful<br>Expected content: " + subHeading + "<br>Actual content: " + s6, STATUS.FAIL);
        }
    }

    @Given("^validating whatisjewel (.+)$")
    public void whatisjewel(String whatisjewel) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(500, 500, false);
        DriverAction.waitSec(3);
        GemTestReporter.addTestStep("Scrolling down", "Scrolling is successful", STATUS.PASS, DriverAction.takeSnapShot());
        String s7 = DriverAction.getElementText(locators.whatisjewel);
        if (s7.equals(whatisjewel)) {
            GemTestReporter.addTestStep("What is jewel validation", "Successful<br>Expected content: " + whatisjewel + "<br>Actual content: " + s7, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("What is jewel validation", "Unsuccessful<br>Expected content: " + whatisjewel + "<br>Actual content: " + s7, STATUS.FAIL);
        }
    }

    @Then("^validating about us (.+)$")
    public void aboutus(String aboutus) {
        String s8 = DriverAction.getElementText(locators.aboutus);
        if (s8.equals(aboutus)) {
            GemTestReporter.addTestStep("About us validation", "Successful<br>Expected content: " + aboutus + "<br>Actual content: " + s8, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("About us validation", "unsuccessful<br>Expected content: " + aboutus + "<br>Actual content: " + s8, STATUS.PASS);
        }
    }

    @Then("^validating content (.+)$")
    public void content(String content) {
        String s9 = DriverAction.getElementText(locators.content);
        if (s9.contains(content)) {
            GemTestReporter.addTestStep("Content validation", "Successful<br>Expected content: " + s9 + "<br>Actual content: " + s9, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Content validation", "Unsuccessful<br>Expected content: " + s9 + "<br>Actual content: " + s9, STATUS.FAIL);
        }
    }

    @Given("^validating view report (.+)$")
    public void viewreport(String viewreport) {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(500, 500, true);
        DriverAction.waitSec(3);
        String s10 = DriverAction.getElementText(locators.viewreport);
        if (s10.contains(viewreport)) {
            GemTestReporter.addTestStep("View report validation", "Successful<br>Expected heading: " + s10 + "<br>Actual content: " + s10, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("View report validation", "unsuccessful<br>Expected heading: " + s10 + "<br>Actual content: " + s10, STATUS.FAIL);
        }
    }

    @Then("^validating view reportC (.+)$")
    public void viewcontent(String viewcontent) {
        String s11 = DriverAction.getElementText(locators.viewreportcontent);
        if (s11.equals(viewcontent)) {
            GemTestReporter.addTestStep("View report content validation", "Successful<br>Expected content: " + s11 + "<br>Actual content: " + s11, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("View report content validation", "unsuccessful<br>Expected content: " + s11 + "<br>Actual content: " + s11, STATUS.FAIL);
        }
    }

    @Given("^validating run test (.+)$")
    public void runtest(String runtest) {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1000, 1000, false);
        DriverAction.waitSec(3);
        GemTestReporter.addTestStep("Scrolling down", "Scrolling is successful", STATUS.INFO, DriverAction.takeSnapShot());
        String s12 = DriverAction.getElementText(locators.runtest);
        if (s12.equals(runtest)) {
            GemTestReporter.addTestStep("Run test suite validation", "Sucessfull<br>Expected content: " + s12 + "<br>Actual content: " + s12, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Run test suite validation", "Unsuccessful<br>Expected content: " + s12 + "<br>Actual content: " + s12, STATUS.FAIL);
        }
    }

    @Then("^validating run testC (.+)$")
    public void runsuite(String runcontentC) {
        String s13 = DriverAction.getElementText(locators.runtestc);
        if (runcontentC.contains(s13)) {
            GemTestReporter.addTestStep("Run test suite content validation", "Successful<br>Expected content: " + s13 + "<br>Actual content: " + s13, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Run test suite content validation", "unsuccessful<br>Expected content: " + s13 + "<br>Actual content: " + runcontentC, STATUS.FAIL);
        }
    }

    @Given("^click on facebook logo validate url (.+)$")
    public void facebook(String facebook) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500, true);
        DriverAction.waitSec(2);
        DriverAction.click(locators.facebook);
        DriverAction.waitSec(2);
        ArrayList<String> newTb = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Click on Facebook logo", "Click on facebook logo successful", STATUS.PASS, DriverAction.takeSnapShot());
        String s15 = DriverAction.getCurrentURL();
        if (s15.equals(facebook)) {
            GemTestReporter.addTestStep(" Facebook Url Validation", "Successful<br>Expected URL: " + facebook + "<br>Actual URL: " + s15, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Facebook Url Validation", "unsuccessful<br>Expected URL: " + facebook + "<br>Actual URL: " + s15, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
//       GemTestReporter.addTestStep("Close Current tab","Successfull",STATUS.PASS);
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close facebook tab", "Close facebook tab successfully", STATUS.PASS);
        DriverAction.switchToWindow(newTb.get(0));
        DriverAction.waitSec(2);

    }

    @Given("click on twitter logo and validate url (.+)$")
    public void twitter(String twitter) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500, true);
        DriverAction.waitSec(2);
        DriverAction.click(locators.twitter);
        ArrayList<String> newTb1 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb1.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Click on twitter logo", "Click on twitter logo successful", STATUS.PASS, DriverAction.takeSnapShot());
        String s16 = DriverAction.getCurrentURL();
        if (s16.equals(twitter)) {
            GemTestReporter.addTestStep(" Twitter Url Validation", "Successful<br>Expected URL: " + twitter + "<br>Actual URL: " + s16, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Twitter Url Validation", "Unsuccessful<br>Expected URL: " + twitter + "<br>Actual URL: " + s16, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close twitter tab", "Close twitter tab successfully", STATUS.PASS);
        DriverAction.switchToWindow(newTb1.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on instagram logo and validate url (.+)$")
    public void instagram(String insta) {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500, true);
        DriverAction.waitSec(2);
        DriverAction.click(locators.instagram);
        ArrayList<String> newTb2 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb2.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Click on instagram logo", "Click on instagram logo successful", STATUS.PASS, DriverAction.takeSnapShot());
        String s17 = DriverAction.getCurrentURL();
        if (s17.equals(insta)) {
            GemTestReporter.addTestStep(" Instagram Url Validation", "Successful<br>Expected URL: " + insta + "<br>Actual URL: " + s17, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Instagram Url Validation", "Successful<br>Expected URL: " + insta + "<br>Actual URL: " + s17, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close instagram tab", "Close instagram tab successfully", STATUS.PASS);
        DriverAction.switchToWindow(newTb2.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on linkedin logo and validate url (.+)$")
    public void linkedin(String linked) {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500, true);
        DriverAction.waitSec(2);
        DriverAction.click(locators.linkedin);
        ArrayList<String> newTb3 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb3.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Click on linkedin logo", "Click on linkedin logo successful", STATUS.PASS, DriverAction.takeSnapShot());
        String s18 = DriverAction.getCurrentURL();
        if (s18.contains(linked)) {
            GemTestReporter.addTestStep(" Linkedin Url Validation", "Successful<br>Expected URL: " + s18 + "<br>Actual URL: " + s18, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Linkedin Url Validation", "Unsuccessful<br>Expected URL: " + s18 + "<br>Actual URL: " + s18, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close linkedin tab", "Close linkedin tab successfully", STATUS.PASS);
        DriverAction.switchToWindow(newTb3.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on jewel dashboard button$")
    public void jewelogo() throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500, false);
        DriverAction.waitSec(2);
        DriverAction.click(locators.jeweldashboard);
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Click on Feature Jewel dashboard", "Click on Feature Jewel dashboard successful", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Given("^click on gemPYP and validate url (.+)$")
    public void gempyp(String pyp) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500, true);
        DriverAction.waitSec(2);
        DriverAction.click(locators.gempyp);
        ArrayList<String> newTb4 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb4.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Click on GemPYP", "Click on GemPYP successful", STATUS.PASS, DriverAction.takeSnapShot());
        String s19 = DriverAction.getCurrentURL();
        if (s19.equals(pyp)) {
            GemTestReporter.addTestStep(" GemPYP Url Validation", "Successful<br>Expected URL: " + pyp + "<br>Actual URL: " + s19, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" GemPYP Url Validation", "unsuccessful<br>Expected URL: " + pyp + "<br>Actual URL: " + s19, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close GemPYP tab", "Close GemPYP tab successfully", STATUS.PASS);
        DriverAction.switchToWindow(newTb4.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on gemPRF and validate url (.+)$")
    public void gemprf(String prf) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500, true);
        DriverAction.waitSec(2);
        DriverAction.click(locators.gemprf);
        ArrayList<String> newTb5 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb5.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Click on GemPRF", "Click on GemPRF successful", STATUS.PASS, DriverAction.takeSnapShot());
        String s20 = DriverAction.getCurrentURL();
        if (s20.equals(prf)) {
            GemTestReporter.addTestStep(" GemPRF Url Validation", "Successful<br>Expected URL: " + prf + "<br>Actual URL: " + s20, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" GemPRF Url Validation", "unsuccessful<br>Expected URL: " + prf + "<br>Actual URL: " + s20, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close GemPRF tab", "Close GemPRF tab successfully", STATUS.PASS);
        DriverAction.switchToWindow(newTb5.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on gemJAR and validate url (.+)$")
    public void gemjar(String jar) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500, true);
        DriverAction.waitSec(2);
        DriverAction.click(locators.gemjar);
        ArrayList<String> newTb6 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb6.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Click on GemJAR", "GemJAR has been clicked", STATUS.PASS, DriverAction.takeSnapShot());
        String s21 = DriverAction.getCurrentURL();
        if (s21.equals(jar)) {
            GemTestReporter.addTestStep(" GemJARUrl Validation", "Successful<br>Expected URL: " + jar + "<br>Actual URL: " + s21, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" GemJAR Url Validation", "unsuccessful<br>Expected URL: " + jar + "<br>Actual URL: " + s21, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Close GemJAR tab", "Close GemJAR tab successfully", STATUS.PASS);
        DriverAction.switchToWindow(newTb6.get(0));
        DriverAction.waitSec(2);
    }

    @Given("^click on pricing button$")
    public void pricingbutton() throws Exception {
        DriverAction.waitSec(1);
        DriverAction.pageScroll(1500, 1500, false);
        DriverAction.waitSec(2);
        DriverAction.click(locators.pricingbutton);
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Click on company pricing", "Click on company pricing successful", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Given("^click on signup$")
    public void signup() throws Exception {
        DriverAction.waitSec(1);
        DriverAction.click(locators.signup);
        DriverAction.waitSec(1);
    }

    @Then("enter {string} {string} {string} {string} {string} {string} {string}")
    public void signupPage(String name, String last, String user, String email, String pass, String cpass, String company) throws Exception {
        DriverAction.click(locators.firstname);
        DriverAction.typeText(locators.firstname, name, "Enter Firstname", "Firstname has been entered: " + name + " ");
        DriverAction.waitSec(1);
        DriverAction.click(locators.lastname);
        DriverAction.typeText(locators.lastname, last, "Enter Lastname", "Lastname has been entered: " + last + " ");
        DriverAction.waitSec(1);
        DriverAction.click(locators.username1);
        DriverAction.typeText(locators.username1, user);
        DriverAction.waitSec(3);
        GemTestReporter.addTestStep("Enter Username", "Username has been entered: " + user + " ", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.click(locators.emailm);
        DriverAction.typeText(locators.emailm, email, "Enter Email", "Email has been entered: " + email + " ");
        DriverAction.waitSec(1);
        DriverAction.click(locators.password1);
        DriverAction.typeText(locators.password1, pass, "Enter Password", "Password has been entered: " + pass + " ");
        DriverAction.waitSec(1);
        DriverAction.click(locators.confirmpass);
        DriverAction.typeText(locators.confirmpass, cpass, "Enter Confirm Password", "Confirm password has been entered: " + cpass + " ");
        DriverAction.waitSec(1);
        DriverAction.click(locators.companyname);
        DriverAction.typeText(locators.companyname, company, "Enter Company", "Company name has been entered: " + company + " ");
        DriverAction.waitSec(1);
        DriverAction.click(locators.register);
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("User exists", "User already exists", STATUS.PASS, DriverAction.takeSnapShot());
    }


    @Given("^click on login and enter (.+) and (.+)$")
    public void loginn(String username, String password) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.click(locators.logIn);
        DriverAction.waitSec(2);
        DriverAction.click(locators.username);
        DriverAction.waitSec(1);
        DriverAction.typeText(locators.username, username);
        DriverAction.waitSec(1);
        DriverAction.click(locators.passwordm);
        DriverAction.waitSec(1);
        DriverAction.typeText(locators.passwordm, password);
        DriverAction.waitSec(1);
        DriverAction.click(locators.LoginButton);
        DriverAction.waitSec(2);
    }

    @Then("^click on autolytics and create report$")
    public void autolytics() throws Exception {
        DriverAction.click(locators.autolyticsm, "Click on autolytics", "Click on autolytics successful");
        DriverAction.waitSec(2);
        DriverAction.click(locators.createReport, "Click on create report", "Click on create report successful");
        DriverAction.waitSec(2);
    }

    @Then("^select report name$")
    public void reportName() throws Exception {
        DriverAction.click(locators.reportNameScroll, "Click on report name", "Click on report name successful");
        DriverAction.waitSec(1);
        DriverAction.click(locators.suiteRunReport, "Select suite run report", "Select suite run report successful");
        DriverAction.waitSec(1);
    }

    @Then("^select project name$")
    public void projectName() throws Exception {
        DriverAction.click(locators.projectScroll, "Click on project", "Click on project successful");
        DriverAction.waitSec(1);
        DriverAction.click(locators.gemEcoApis, "Select gem-ecosystem API", "Select gem-ecosystem API successful");
        DriverAction.waitSec(1);
    }

    @Then("^select enviroment$")
    public void enviromentName() throws Exception {
        DriverAction.click(locators.enviromentScroll, "Click on environment", "Click on environment successful");
        DriverAction.waitSec(1);
        DriverAction.click(locators.prod, "Select prod", "Select prod successful");
        DriverAction.waitSec(1);
    }

    @Then("^select date range and click on generate$")
    public void dateRange() throws Exception {
        DriverAction.click(locators.dateRangeScroll, "Click on date range", "Click on date range successful");
        DriverAction.waitSec(1);
        DriverAction.click(locators.thisYear, "Select this year", "Select this year successful");
        DriverAction.waitSec(1);
        DriverAction.click(locators.generate);
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Click on Generate button", "Click on Generate button successful", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Then("^validate sorting of numbers$")
    public void sorting() throws Exception {
        DriverAction.waitSec(1);
        DriverAction.doubleClick(locators.sno);
        DriverAction.waitSec(2);
        GemTestReporter.addTestStep("Double click on S No", "Double click on S No successful", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.pageScroll(1000, 1000, false);
        DriverAction.waitSec(4);
        String s3 = DriverAction.getElementText(locators.total);
        String s4 = s3.substring(6, 8);
//        int value = Integer.parseInt(s4);
        String s2 = DriverAction.getElementText(locators.span);
        if (s2.equals(s4)) {
            GemTestReporter.addTestStep(" Sorting Validation", "Successful<br>Expected Text: " + s2 + "<br>Actual Text: " + s4, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Sorting Validation", "unsuccessful<br>Expected Text: " + s2 + "<br>Actual Text: " + s4, STATUS.FAIL);
        }
    }

    @Given("^click on login and enters (.+) and (.+)$")
    public void loginnn(String usernames, String passwords) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.click(locators.logIn);
        DriverAction.waitSec(2);
        DriverAction.click(locators.username);
        DriverAction.waitSec(1);
        DriverAction.typeText(locators.username, usernames);
        DriverAction.waitSec(1);
        DriverAction.click(locators.passwordm);
        DriverAction.waitSec(1);
        DriverAction.typeText(locators.passwordm, passwords);
        DriverAction.waitSec(1);
        DriverAction.click(locators.LoginButton);
        DriverAction.waitSec(2);
    }

    @Then("^click on autolytics and create reports$")
    public void autolyticss() throws Exception {
        DriverAction.click(locators.autolyticsm);
        DriverAction.waitSec(2);
        DriverAction.click(locators.createReport);
        DriverAction.waitSec(2);
    }

    @Then("^select report names$")
    public void reportNames() throws Exception {
        DriverAction.click(locators.reportNameScroll);
        DriverAction.waitSec(1);
        DriverAction.click(locators.suiteRunReport);
        DriverAction.waitSec(1);
    }

    @Then("^select project names$")
    public void projectNames() throws Exception {
        DriverAction.click(locators.projectScroll);
        DriverAction.waitSec(1);
        DriverAction.click(locators.gemEcoApis);
        DriverAction.waitSec(1);
    }

    @Then("^select enviroments$")
    public void enviromentNames() throws Exception {
        DriverAction.click(locators.enviromentScroll);
        DriverAction.waitSec(1);
        DriverAction.click(locators.prod);
        DriverAction.waitSec(1);
    }

    @Then("^select date range and click on generates$")
    public void dateRanges() throws Exception {
        DriverAction.click(locators.dateRangeScroll);
        DriverAction.waitSec(1);
        DriverAction.click(locators.thisYear);
        DriverAction.waitSec(1);
        DriverAction.click(locators.generate);
        DriverAction.waitSec(4);
    }

    @Then("^click on copy button and check if report opens in new tab and click on new tab button and validate (.+) of shared report")
    public void buttons(String sharedurl) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.click(locators.copyButton);
        DriverAction.waitSec(3);
        GemTestReporter.addTestStep("Click on Copy Button", "Click on Copy Button successful", STATUS.PASS, DriverAction.takeSnapShot());
//        DriverManager.getWebDriver().switchTo().newWindow(WindowType.TAB);
//        DriverAction.waitSec(3);
//        String s = Keys.chord(Keys.CONTROL, "v");
//        DriverAction.waitSec(2);
//        DriverManager.getWebDriver().navigate().to(s);
//        DriverAction.waitSec(6);
        DriverAction.click(locators.newTab);
        ArrayList<String> newTb7 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb7.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Click on share report button", "Click on share report button successful", STATUS.PASS, DriverAction.takeSnapShot());
        String string = DriverAction.getCurrentURL();
        if (string.equals(sharedurl)) {
            GemTestReporter.addTestStep(" Share report Url Validation", "Successful<br>Expected URL: " + sharedurl + "<br>Actual URL: " + string, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Share report Validation", "unsuccessful<br>Expected URL: " + sharedurl + "<br>Actual URL: " + string, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb7.get(0));
        DriverAction.waitSec(2);
    }

    @Then("^click on create report button$")
    public void createReportButton() throws Exception {
        DriverAction.waitSec(1);
        DriverAction.click(locators.createReportButton, "Click on create report button", "Click on create report button successful");
        DriverAction.waitSec(1);
        DriverAction.click(locators.crossCreateReport);
        DriverAction.waitSec(2);
    }

    @Then("^click on filter status and select pass$")
    public void filter() throws Exception {
        DriverAction.click(locators.filter);
        DriverAction.waitSec(1);
        DriverAction.click(locators.selectFilter);
        DriverAction.waitSec(1);
        DriverAction.click(locators.selectPass);
        String asert = DriverAction.getElementText(locators.selct_pass_text);
        System.out.println(asert);
        DriverAction.waitSec(1);
        DriverAction.click(locators.closeFilter);
        DriverAction.waitSec(3);
        System.out.println(locators.selct_pass_text);
        int count = 0;
        int flag = 0;
        List<String> list = DriverAction.getElementsText(locators.pass);
        for (int i = 0; i < list.size(); i++) {
            if (asert.equalsIgnoreCase(list.get(i))) {
                count++;
            }
        }
        if (count == list.size()) {
            System.out.println(1);
            GemTestReporter.addTestStep(" Filter Pass Validation", "Expected:" + asert, STATUS.INFO);
            GemTestReporter.addTestStep("Filer Pass Validation", "Text we got" + list.get(0), STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Filter Pass Validation", "Expected:" + asert, STATUS.INFO);
            GemTestReporter.addTestStep("Filer Pass Validation", "Text we got" + list.get(0), STATUS.FAIL);
        }
    }

    @Then("^click on exe$")
    public void exe() throws Exception {
        DriverAction.click(locators.selectFilter1);
        DriverAction.waitSec(1);
        DriverAction.click(locators.selectPass);
        DriverAction.waitSec(1);
        DriverAction.click(locators.exe);
        DriverAction.waitSec(1);
        String asert1 = DriverAction.getElementText(locators.select_exe_text);
        DriverAction.waitSec(3);
        DriverAction.click(locators.closeFilter);
        int count1 = 0;
        List<String> list1 = DriverAction.getElementsText(locators.exe1);
        for (int i = 0; i < list1.size(); i++) {
            if (asert1.equalsIgnoreCase(list1.get(i))) {
                count1++;
            }
        }
        if (count1 == list1.size()) {
            GemTestReporter.addTestStep(" Filter EXE Validation", "Expected:" + asert1, STATUS.INFO);
            GemTestReporter.addTestStep("Filer EXE Validation", "Text we got" + list1.get(0), STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Filter EXE Validation", "Expected:" + asert1, STATUS.INFO);
            GemTestReporter.addTestStep("Filer EXE Validation", "Text we got" + list1.get(0), STATUS.FAIL);
        }
    }

    @Then("^click on fail$")
    public void fail() throws Exception {
        DriverAction.click(locators.selectFilter1);
        DriverAction.waitSec(1);
        DriverAction.click(locators.exe);
        DriverAction.waitSec(1);
        DriverAction.click(locators.fail);
        DriverAction.waitSec(1);
        String asert2 = DriverAction.getElementText(locators.select_fail_text);
        DriverAction.waitSec(3);
        DriverAction.click(locators.closeFilter);
        int count2 = 0;
        List<String> list2 = DriverAction.getElementsText(locators.fail1);
        for (int i = 0; i < list2.size(); i++) {
            if (asert2.equalsIgnoreCase(list2.get(i))) {
                count2++;
            }
        }
        if (count2 == list2.size()) {
            GemTestReporter.addTestStep(" Filter FAIL Validation", "Expected:" + asert2, STATUS.INFO);
            GemTestReporter.addTestStep("Filer FAIL Validation", "Text we got" + list2.get(0), STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Filter FAIL Validation", "Expected:" + asert2, STATUS.INFO);
            GemTestReporter.addTestStep("Filer FAIL Validation", "Text we got" + list2.get(0), STATUS.FAIL);
        }
    }

    @Then("^click on warn$")
    public void warn() throws Exception {
        DriverAction.click(locators.selectFilter1);
        DriverAction.waitSec(1);
        DriverAction.click(locators.fail);
        DriverAction.waitSec(1);
        DriverAction.click(locators.warn);
        DriverAction.waitSec(1);
        String asert3 = DriverAction.getElementText(locators.select_warn_text);
        DriverAction.waitSec(3);
//        DriverAction.click(locator.closeFilter);
//        DriverAction.waitSec(2);
        int count3 = 0;
        List<String> list3 = DriverAction.getElementsText(locators.warn1);
        for (int i = 0; i < list3.size(); i++) {
            if (asert3.equalsIgnoreCase(list3.get(i))) {
                count3++;
            }
        }
        if (count3 == list3.size()) {
            GemTestReporter.addTestStep(" Filter WARN Validation", "Expected:" + asert3, STATUS.INFO);
            GemTestReporter.addTestStep("Filer WARN Validation", "Text we got" + list3.get(0), STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Filter WARN Validation", "Expected:" + asert3, STATUS.INFO);
            GemTestReporter.addTestStep("Filer WARN Validation", "Text we got" + list3.get(0), STATUS.FAIL);
        }
        DriverAction.click(locators.warn);
        DriverAction.waitSec(1);
        DriverAction.click(locators.closeFilter);
        DriverAction.waitSec(1);
        DriverAction.doubleClick(locators.pass);
        DriverAction.waitSec(2);
    }

    @Then("^click on filter2 and select a date$")
    public void filter2() throws Exception {
        DriverAction.waitSec(2);
        DriverAction.pageScroll(1000, 1000, false);
        DriverAction.waitSec(2);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
//        ((JavascriptExecutor)DriverManager.getWebDriver()).executeScript("window.scrollRight(2000,0)");
        js.executeScript("arguments[0].scrollIntoView();", DriverManager.getWebDriver().findElement(By.xpath("//*[text()='August 17, 2022 6:11:28 PM (IST)']")));
        DriverAction.waitSec(4);
        DriverAction.click(locators.filter1);
        DriverAction.waitSec(1);
        DriverAction.click(locators.selectFilter);
        DriverAction.waitSec(1);
        DriverAction.click(locators.selectDate);
        DriverAction.waitSec(2);
//        DriverAction.click(locator.closeFilter);
//        DriverAction.waitSec(2);
        String asert4 = DriverAction.getElementText(locators.selectDate);
        DriverAction.waitSec(3);
        int count4 = 0;
        List<String> list4 = DriverAction.getElementsText(locators.select_date_text);
        for (int i = 0; i < list4.size(); i++) {
            if (asert4.equalsIgnoreCase(list4.get(i))) {
                count4++;
            }
        }
        if (count4 == list4.size()) {
            GemTestReporter.addTestStep(" Filter DATE Validation", "Expected:" + asert4, STATUS.INFO);
            GemTestReporter.addTestStep("Filer DATE Validation", "Text we got" + list4.get(0), STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Filter DATE Validation", "Expected:" + asert4, STATUS.INFO);
            GemTestReporter.addTestStep("Filer DATE Validation", "Text we got" + list4.get(0), STATUS.FAIL);
        }
        DriverAction.click(locators.selectDate);
        DriverAction.waitSec(1);
        DriverAction.click(locators.closeFilter);
        DriverAction.waitSec(1);
    }

    @Then("^click on action button and then validate (.+)$")
    public void action(String executionReport) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.click(locators.action);
        DriverAction.waitSec(3);
        String exe = DriverAction.getElementText(locators.executionR);
        if (exe.equals(executionReport)) {
            GemTestReporter.addTestStep("Execution Report tab Validation", "Successful<br>Expected text: " + executionReport + "<br>Actual text: " + exe, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Execution Report tab Validation", "unsuccessful<br>Expected text: " + executionReport + "<br>Actual text: " + exe, STATUS.FAIL);
        }
    }

    @Then("^click on new tab button and validate (.+) of execution report$")
    public void newtabbb(String executionUrl) throws Exception {
        DriverAction.waitSec(1);
        DriverAction.click(locators.newtb_button);
        ArrayList<String> newTb7 = new ArrayList<>(DriverAction.getWindowHandles());
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb7.get(1));
        DriverAction.waitSec(4);
        GemTestReporter.addTestStep("Click on share report button", "Click on share report button successful", STATUS.PASS, DriverAction.takeSnapShot());
        String string = DriverAction.getCurrentURL();
        if (string.equals(executionUrl)) {
            GemTestReporter.addTestStep(" Execution report Url Validation", "Successful<br>Expected URL: " + executionUrl + "<br>Actual URL: " + string, STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Execution report Url Validation", "unsuccessful<br>Expected URL: " + executionUrl + "<br>Actual URL: " + string, STATUS.FAIL);
        }
        DriverManager.getWebDriver().close();
        DriverAction.waitSec(2);
        DriverAction.switchToWindow(newTb7.get(0));
        DriverAction.waitSec(2);
    }

    @Then("^click on testcase detail and validate filter$")
    public void testCase() throws Exception {
        DriverAction.waitSec(1);
        DriverAction.click(locators.testcaseDetail);
        DriverAction.waitSec(2);
        DriverAction.click(locators.selectFilter3);
        DriverAction.waitSec(1);
        DriverAction.click(locators.select_filter);
        DriverAction.waitSec(1);
        DriverAction.click(locators.click_filter);
        DriverAction.waitSec(1);
//        DriverAction.click(locator.closeFilter);
//        DriverAction.waitSec(1);
        String asert68 = DriverAction.getElementText(locators.inside_filter_text);
        DriverAction.waitSec(1);
        DriverAction.click(locators.closeFilter);
        DriverAction.waitSec(3);
        int count2 = 0;
        List<String> listing = DriverAction.getElementsText(locators.outside_filter_text);
        for (int i = 0; i < listing.size(); i++) {
            if (asert68.equalsIgnoreCase(listing.get(i))) {
                count2++;
            }
        }
        if (count2 == listing.size()) {
            GemTestReporter.addTestStep(" Filter Start time Validation", "Expected:" + asert68, STATUS.INFO);
            GemTestReporter.addTestStep("Filer Start Validation", "Text we got" + listing.get(0), STATUS.PASS);
        } else {
            GemTestReporter.addTestStep(" Filter Start time Validation", "Expected:" + asert68, STATUS.INFO);
            GemTestReporter.addTestStep("Filer Start time Validation", "Text we got" + listing.get(0), STATUS.FAIL);
        }
        DriverAction.doubleClick(locators.close_filter1);
        DriverAction.waitSec(2);
    }


}



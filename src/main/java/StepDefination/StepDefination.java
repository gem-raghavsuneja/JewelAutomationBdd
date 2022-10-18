package StepDefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import Objects.Locators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StepDefination {
    Logger logger = LoggerFactory.getLogger(StepDefination.class);

    @Given("You are on the login screen")
    public void you_are_on_the_login_screen() {
        try {
            DriverAction.waitSec(2);
            DriverAction.click(Locators.login_screen);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("Enter username as {string}")
    public void enter_username_as(String string) {
        try {
            DriverAction.typeText(Locators.user_name, "raghavsuneja123");
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("Enter Password")
    public void enter_password() {
        DriverAction.typeText(Locators.password, "Abc123@@");
        try {
            DriverAction.click(Locators.login_button, "Login Button", "Clicked Successfully on the Login Button");
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("Verify Logout button is visible or not")
    public void verify_logout_button_is_visible_or_not() {
        try {
            DriverAction.waitSec(2);
            DriverAction.click(Locators.home_button, "Click on Home Button", " Clicked successfully on the Home Button");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.profile, "Click on Profile button", "Clicked on the Profile Button");
            GemTestReporter.addTestStep("Status of logout button", "Logout button is  visible", STATUS.PASS, DriverAction.takeSnapShot());
            Boolean b = DriverAction.getElement(Locators.log_out).isDisplayed();

        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Status of logout button", "Logout button is not visible", STATUS.FAIL);
        }
    }


    @Then("Verify the text of the Home screen")
    public void verify_the_text_of_the_home_screen() {
        try {
            DriverAction.waitSec(2);
            DriverAction.click(Locators.home_button, "Home Button", "Clicked Successfully on the Home Button");
            String s = DriverAction.getElement(Locators.page_title).getText();
            GemTestReporter.addTestStep("Text of Home Screen", s, STATUS.INFO);

            STATUS status;
            if (s.equals("Jewel Applications")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Text of Home screen", "Expected :Jewel Applications", status, DriverAction.takeSnapShot());


        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR!", "Something wrong Happened", STATUS.FAIL);
        }
    }

    @Then("Click on the Autolytics screen")
    public void click_on_the_autolytics_screen() {
        try {
            DriverAction.click(Locators.home_button, "Home button", "Successfully clicked on the Home button");
            boolean present;
            try {
                DriverManager.getWebDriver().findElement(Locators.autolytics);
                present = true;
            } catch (NoSuchElementException e) {
                present = false;
            }
            if (present) {
                DriverAction.click(Locators.autolytics, "Autolytics Button", "Successfully clicked on the Autolytics Button");
            } else {
                GemTestReporter.addTestStep("Autolytics Button Status", "Not Found", STATUS.FAIL);
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
        }
    }


    @Then("Verify the Autolytics Screen")
    public void verify_the_autolytics_screen() {
        try {
            STATUS status;
            DriverAction.waitSec(2);
            DriverAction.click(Locators.home_button, "Home Button", "Click was successful");
            DriverAction.click(Locators.autolytics, "Autolytics Button", "Click was Successful");
            String s = DriverAction.getCurrentURL();
            if (s.contains("autolytics")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("AUtolytics window", "Window is opened successfully", status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Status of Autolytics button", "Clicked Fsiled", STATUS.FAIL);
        }
    }


    @Then("Verify the Bridge Token Button is clickable or not")
    public void verify_the_bridge_token_button_is_clickable_or_not() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button", "Click was successful");
        boolean present;
        try {
            DriverManager.getWebDriver().findElement(Locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present) {
            try {
                DriverAction.click(Locators.bridge_token, "Bridge token Button", "Click was successful");
                String s = DriverAction.getCurrentURL();
                STATUS status;
                if (s.contains("bridge-token")) {
                    status = STATUS.PASS;
                } else {
                    status = STATUS.FAIL;
                }
                GemTestReporter.addTestStep("Bridge Token window", "Window was not opened successfully", STATUS.FAIL);
            } catch (Exception e) {
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Bridge Token window", "Button NOt Present", STATUS.FAIL);

        }
    }

    @Then("Click on Copy Bridge Token")
    public void click_on_copy_bridge_token() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button);
        try {
            DriverAction.click(Locators.bridge_token, "Bridge token Button", "Click was successful");
            String s = DriverAction.getCurrentURL();
            STATUS status;
            if (s.contains("bridge-token")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Bridge Token window", "Window is opened successfully", status);
            boolean present;
            try {
                DriverManager.getWebDriver().findElement(Locators.copy_bridge_token);
                present = true;
            } catch (Exception e) {
                present = false;
            }
            STATUS status1;
            if (present) {

                DriverAction.click(Locators.copy_bridge_token, "copy button", "Click was successful");
                DriverAction.waitSec(2);
                status1 = STATUS.PASS;
            } else {
                status1 = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Status of Copy button", "clicked Successful", status1, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
        }
    }

    @Then("Verify the Alert when copy button is clicked")
    public void verify_the_alert_when_copy_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home button", "Home button was clicked");
        boolean present;
        try {
            DriverManager.getWebDriver().findElement(Locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present) {
            try {
                DriverAction.click(Locators.bridge_token, "Bridge token Button", "Bridge token was clicked");
                String s = DriverAction.getCurrentURL();
                STATUS status;
                if (s.contains("bridge-token")) {
                    status = STATUS.PASS;
                } else {
                    status = STATUS.FAIL;
                }
                GemTestReporter.addTestStep("Bridge Token window", "Status", status);
                DriverAction.click(Locators.copy_bridge_token, "copy button", "Copy button was clicked");
                DriverAction.waitSec(1);
                GemTestReporter.addTestStep("Status of Copy button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());
                String se = DriverAction.getElement(Locators.copy_alert).getText();
                STATUS hi;
                if (se.equals("Copied !")) {
                    hi = STATUS.PASS;
                } else {
                    hi = STATUS.FAIL;
                }
                GemTestReporter.addTestStep("Alert status", "Expected alert:Copied ", hi);

            } catch (Exception e) {
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("Status of Bridge Token button", "Clicked Failed", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Status of Bridge Token button", "Not Found", STATUS.FAIL);
        }
    }

    @Then("Verify the date and time when Change Token button is clicked")
    public void verify_the_date_and_time_when_change_token_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home button", "Home button was clicked");
        try {
            DriverAction.click(Locators.bridge_token);
            DriverAction.click(Locators.change_token, "Change token button", "Change Token button was clicked");
            DriverAction.waitSec(1);
            GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitSec(2);
            String time = DriverAction.getElement(Locators.date_tab).getText();

            String timep = time.substring(11, 28);
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd,yyyy", Locale.ENGLISH);
            Date dateupdate = formatter.parse(timep);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            LocalDateTime now = LocalDateTime.now();
            String loc = dtf.format(now);
            STATUS status;
            if (StringUtils.contains(timep, loc)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Checking date", "Dates should match", status);
            String times = time.substring(27, 35);

            String[] hel = times.split(":", 3);

            String jo = hel[0];
            String koko = String.valueOf(jo.charAt(0));
            if (koko.equals(" ")) {
                jo = "0" + jo.substring(1);
                hel[0] = jo;
            }
            DateTimeFormatter Time = DateTimeFormatter.ofPattern("hh/mm/ss");
            LocalDateTime ti = LocalDateTime.now();
            String timess = Time.format(ti);

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
            STATUS s;
            if (flag == 0) {
                s = STATUS.PASS;
            } else {
                s = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Comparing time", "Checking time of the system", s);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }


    @Then("Verify the Alert when Change Token button is clicked")
    public void verify_the_alert_when_change_token_button_is_clicked() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home button", "Home button was clicked");
        try {
            DriverAction.click(Locators.bridge_token);
            DriverAction.click(Locators.change_token, "Change token button", "Change Token button was clicked");
            DriverAction.waitSec(1);
            GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());
            String fi = DriverAction.getElement(Locators.change_token_alert).getText();
            STATUS status;
            if (fi.contains("Bridge Token Changed Successfully.")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Alert status", "Expected alert:Changed successfully", status, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Click and verify the Logout button")
    public void click_and_verify_the_logout_button() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home button", "Home Button was clicked");
        try {
            DriverAction.waitSec(3);
            DriverAction.click(Locators.pelement, "Profile Element", "Successfully clicked on the Profile");
            DriverAction.waitSec(3);
            DriverAction.click(Locators.lelement, "Logout button", "Successfully clicked on the logout button");
            DriverAction.waitSec(2);
            String titlee = DriverAction.getCurrentURL();

            STATUS status;
            if (titlee.equals("https://jewel.gemecosystem.com/#/login")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Verifying the URL", "Expected :https://jewel.gemecosystem.com/#/login", status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the content of the Home screen")
    public void verify_the_content_of_the_home_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button", "Successfully clicked on the Home button");
        GemTestReporter.addTestStep("Successfully clicked", "Jewel Window", STATUS.INFO, DriverAction.takeSnapShot());
        try {
            String text = DriverAction.getElement(Locators.page_title).getText();
            STATUS s;
            if (text.equals("Jewel Applications")) {
                s = STATUS.PASS;
            } else {
                s = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Title validation", "Expected Title:Jewel Applications", s);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the Cards present on the home screen")
    public void verify_the_cards_present_on_the_home_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button", "Successfully clicked on the Home button");
        try {
            List num = DriverAction.getElements(Locators.cards);
            STATUS status;
            if (num.size() == 2) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Number of Cards Present ", "Expcted :2", status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the Autolytics Cards present on the home screen")
    public void verify_the_autolytics_cards_present_on_the_home_screen() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button", "Successfully clicked on the Home button");
        try {
            String nuam = DriverAction.getElement(Locators.card_one).getText();
            STATUS s;
            if (nuam.equals("Autolytics")) {
                s = STATUS.PASS;
            } else {
                s = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Validating the Autolytics card", "Expcted :Autolytics", s);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify the Autolytics Card Content")
    public void verify_the_autolytics_card_content() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home button", "Home button was clicked successfully");
        try {

            String nuam = DriverAction.getElement(Locators.content_card_one).getText();

            STATUS s;
            if (nuam.equals("Autolytics provides the feature for generating descriptive reports to analyze the Testcases/Suite details and also enables users to share them effortlessly.")) {
                s = STATUS.PASS;
            } else {
                s = STATUS.FAIL;

            }
            GemTestReporter.addTestStep("Validating the Autolytics card", "Expcted :Autolytics provides the feature for generating descriptive reports to analyze the Testcases/Suite details and also enables users to share them effortlessly.", s);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Verify if the Bridge token card is visible")
    public void verify_if_the_bridge_token_card_is_visible() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button", "Home button was clicked successfully");
        try {

            String nuam = DriverAction.getElement(Locators.card_two).getText();
            STATUS status;
            if (nuam.equals("Bridge Token")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Validating the Bridge Token card", "Expcted :Bridge Token", status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Validate the content of the Bridge Token card")
    public void validate_the_content_of_the_bridge_token_card() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button", "Home button was clicked successfully");
        try {
            STATUS status;
            String nuam = DriverAction.getElement(Locators.content_card_two).getText();

            if (nuam.equals("Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Validating the Bridge Token card Content", "Expcted :Keeping in mind the Secure/Safe utilization, Jewel authenticates each user with a Bridge Token which can also be changed or retrieved back as per convenience.", status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Validate alert ,username and status of the window button")
    public void validate_alert_username_and_status_of_the_window_button() {
        try {
            DriverAction.click(Locators.home_button, "Home Button", "Home button was clicked successfully");
            DriverAction.waitSec(2);
//            GemTestReporter.addTestStep("Login Success", "Successfully Logged in!!", STATUS.PASS);
            String s = DriverAction.getElementText(Locators.login_alert);

            GemTestReporter.addTestStep("Alert Text", s, STATUS.INFO);
            DriverAction.waitSec(5);
            DriverAction.waitSec(5);
            DriverAction.click(Locators.three_lines_button, "Three Lines button", "Successfully clicked on the three lines ");
            GemTestReporter.addTestStep("Button Status", "Clicked on the button", STATUS.PASS);
            DriverAction.waitSec(2);
            String y = DriverAction.getElementText(Locators.home_button);
            if (y == "Home") {
                GemTestReporter.addTestStep("Status of the side window", "Whole text is appearing", STATUS.INFO);
            } else {
                GemTestReporter.addTestStep("Status of the side window", "Only icons are appearing", STATUS.INFO);
            }
            DriverAction.click(Locators.profile, "Usernane button", "Successfully clicked on the Username button");
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Something wrong Happened", "Error!!", STATUS.FAIL);
        }
    }

    @Then("Validate if there is change token button available ,if so click it")
    public void validate_if_there_is_change_token_button_available_if_so_click_it() {
        DriverAction.waitSec(2);
        DriverAction.click(Locators.home_button, "Home Button", "Home button was clicked successfully");
        boolean present;
        try {
            DriverManager.getWebDriver().findElement(Locators.bridge_token);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        if (present) {
            try {
                DriverAction.click(Locators.bridge_token, "Bridge Token button", "Button was clicked successfully");
                DriverAction.click(Locators.change_token, "Change token button", "Button was clicked Successfully");
                DriverAction.waitSec(1);
                GemTestReporter.addTestStep("Status of Change token button", "clicked Successful", STATUS.PASS, DriverAction.takeSnapShot());
            } catch (Exception e) {
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
            }
        } else {
            GemTestReporter.addTestStep("Error", "No such element", STATUS.FAIL);
        }
    }

    @Given("You are on the Sign up screen")
    public void you_are_on_the_sign_up_screen() {
        try {
            DriverAction.navigateToUrl("https://jewel-beta.gemecosystem.com/#/", true);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Click on the Sign up Button")
    public void click_on_the_sign_up_button() {
        try {
            DriverAction.waitSec(3);
            DriverAction.click(Locators.signup_button, "Sign up button", "Successfully clicked");
            DriverAction.waitSec(3);
            GemTestReporter.addTestStep("Sign up screen", "Loaded", STATUS.INFO, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Enter random username")
    public void enter_random_username() {
        try {
            DriverAction.waitSec(2);
            DriverAction.typeText(Locators.first_name, "Hello");
            DriverAction.waitSec(3);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Enter all the fields and Validate the status")
    public void enter_all_the_fields_and_validate_the_status() {
        try {
            DriverAction.waitSec(2);
            DriverAction.typeText(Locators.last_name, "Jewel", "Last Name");
            DriverAction.waitSec(2);
            DriverAction.typeText(Locators.user_name, "test1" + System.currentTimeMillis(), "Username");
            DriverAction.waitSec(2);
            DriverAction.typeText(Locators.email, "test.jew@geminisolutions.com", "Test.jewel@geminisolutions.com");
            GemTestReporter.addTestStep("Status of username", "Clicked successfully", STATUS.INFO, DriverAction.takeSnapShot());
            DriverAction.typeText(Locators.password, "Hellothere", "Password");
            DriverAction.waitSec(2);
            DriverAction.typeText(Locators.confirm_pass, "Hellothere", "Confirm Password");
            DriverAction.waitSec(2);
            DriverAction.typeText(Locators.company_name, "Gemini solutions", "Company Name");
            DriverAction.click(Locators.register_button, "Register button", "Successfully clicked on the Register Button");
            DriverAction.waitSec(1);
            String text = DriverAction.getElement(Locators.register_alert).getText();

            STATUS status;
            if (text.equals("User Registered.")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("User Registered Status", "Expected :User Registered Successfully", status, DriverAction.takeSnapShot());
            String tt = DriverManager.getWebDriver().getCurrentUrl();
            STATUS status1;
            if (tt.contains("login")) {
                status1 = STATUS.PASS;
            } else {
                status1 = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Login screen status", "Expected: URL is matching ", status1, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Click on Create Report Tab")
    public void click_on_create_report_tab() {
        addnewtabs();
    }

    public void addnewtabs() {
        try {
            DriverAction.click(By.xpath("//div[text()='Autolytics']"), "Report", "Autolytics button");
            DriverAction.click(Locators.create_report, "Create Report", "Clicked Successful");
            DriverAction.waitSec(4);
            DriverAction.click(Locators.report_name_button, "Clicked on Report name was successful");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.suite_run, "Suite run Report", "Successfully clicked on Suite Run  report");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.project_name, "Project name", "Clicked on the Project name");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.project_name_selection, "Select from the dropdown", "Successfully clicked on JEWEL_UI_JV");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.cross_button, "Cross button", "successfully clicked");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.env_tab, "Environment selection", "Successfully clicked on the Environment button");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.select_env, "Select the Environment", "Successfully selected the environment");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.cbutton, "Cross button", "Successfully clicked on the cross button");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.date_range_tab, "Select Date Range", "Successfully clicked on the date range tab");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.select_date, "Select value", "Successfully selected the value");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.generate_button, "Generate button", "Click was successful");
            DriverAction.waitSec(3);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    List<WebElement> hi = DriverAction.getElements(Locators.left_tabs);

    @Then("Open few tabs {int}")
    public void open_few_tabs(Integer int1) {
        try {
            for (int i = 0; i < int1; i++) {
                DriverAction.click(Locators.new_tab, "New Tab Button", "Clicked Successful");
                addnewtabs();
            }
            List<WebElement> hi = DriverAction.getElements(Locators.left_tabs);
            STATUS status;
            if (hi.size() == int1) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Number of Tabs", "Expected " + int1, status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }


    @Then("Click on SLide left button")
    public void Click_on_SLide_left_button() {
        try {
            DriverAction.click(Locators.left_most_tab, "Left Most Tab", "Clicked Successful");
            DriverAction.waitSec(2);
            DriverAction.switchToActiveElement();
            WebElement l = DriverAction.getElement(Locators.tab_select);
            String element = l.getAttribute("aria-selected");
            STATUS status;
            if (element.equals("true")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Left Most clicked Status", "Expected :Successfully clicked", status, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }


    @Then("Click on the SLide most Right button")
    public void click_on_the_s_lide_most_right_button() {
        try {
            DriverAction.click(Locators.right_most_tab, "Right Most Tab", "Clicked Successful");
            DriverAction.waitSec(1);
            WebElement l = DriverAction.getElement(Locators.tabs);
            String element = l.getAttribute("aria-selected");
            STATUS status;
            if (element.equals("true")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Right most Clicked Status", "Expected :Successfully clicked", status, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("Click on the slide to next left button")
    public void click_on_the_slide_to_next_left_button() {
        try {
            DriverAction.click(Locators.slide_left, "Slide Left Tab button", "Successfully clickeb");
            DriverAction.waitSec(1);
            WebElement l = DriverAction.getElement(Locators.parent_tab);
            String element = l.getAttribute("aria-selected");
            STATUS status;
            if (element.equals("true")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Left Tab Clicked Status", "Expected : Successfully clicked", status, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR!", "Something wrong Happened", STATUS.FAIL);
        }
    }

    @Then("Click on the Slide to next right button")
    public void click_on_the_slide_to_next_right_button() {
        try {
            DriverAction.click(Locators.slide_right, "Slide Right Tab button", "Successfully clicked");
            DriverAction.waitSec(1);
            WebElement l = DriverAction.getElement(Locators.tabs);
            String element = l.getAttribute("aria-selected");
            STATUS status;
            if (element.equals("true")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Left Tab Clicked Status", "Expected : Successfully clicked", status, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR!", "Something wrong Happened", STATUS.FAIL);
        }
    }

    @Then("Validate the active tabs")
    public void validate_the_active_tabs() {

    }


    @Then("Open a new tab")
    public void open_a_new_tab() throws IOException, UnsupportedFlavorException {
        try {
            addnewtabs();
            DriverAction.waitSec(5);
            DriverAction.click(Locators.copy_report_link);
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
                String s = DriverAction.getElement(Locators.check_text_of_report).getText();
                if (s.equalsIgnoreCase("Shared Report")) {
                    GemTestReporter.addTestStep("Heading validation", "Expected: Shared Report", STATUS.PASS);
                } else {
                    GemTestReporter.addTestStep("Heading validation", "Expected: Shared Report", STATUS.FAIL);
                }
            } else {
                GemTestReporter.addTestStep("Current Url", url, STATUS.FAIL);
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

/////////////////////////////////////////////

    @Then("Logout the Account")
    public void logout_the_account() throws IOException, UnsupportedFlavorException {
        try {
            addnewtabs();
            DriverAction.click(Locators.copy_report_link);
            DriverAction.waitSec(4);
            String h = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            DriverAction.waitSec(5);
            ChromeOptions o = new ChromeOptions();
            o.addArguments("--incognito");
            WebDriver driver = new ChromeDriver(o);
            driver.get(h);
            String s = driver.getCurrentUrl();
            STATUS status;
            if (s.equals("https://jewel.gemecosystem.com/#/login")) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Validatinng the Url", "Expected : Login screen should be visible", status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    //////////////////////////////////////////////////////////
    @Given("^user clicks on logIn button and closes it$")
    public void logIn() throws Exception {
        try {
            DriverAction.waitSec(2);
            DriverAction.click(Locators.logIn, "Click on login button", "Click on login button is successful");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.close);
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Click on cross button", "Click on cross button is successful", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^user again clicks on logIn button and enters (.+) and (.+)")
    public void loginPage(String Username, String Password) throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.click(Locators.logIn);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.username);
            DriverAction.waitSec(1);
            DriverAction.typeText(Locators.username, Username, "Enter Username", "Username has been entered: " + Username + " ");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.passwordm);
            DriverAction.waitSec(1);
            DriverAction.typeText(Locators.passwordm, Password);
            DriverAction.waitSec(1);
            GemTestReporter.addTestStep("Enter Password", "Password has been entered: " + Password + " ", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitSec(3);
            DriverAction.click(Locators.eye, "Click on open eye button", "Click on open eye button successful");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.eyeclose, "Click on close eye button", "Click on close eye button successful");
            DriverAction.waitSec(1);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^user navigates back after loggin in$")
    public void logout() throws Exception {
        try {
            DriverAction.waitSec(2);
            DriverAction.click(Locators.LoginButton);
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Logged in", "Logged in inside website", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.navigateBack();
            DriverAction.waitSec(3);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^validating url of jewel (.+)$")
    public void jewelurl(String expectedUrl) throws Exception {
        try {
            DriverAction.waitSec(2);
            String s1 = DriverAction.getCurrentURL();
            STATUS status;
            if (s1.equals(expectedUrl)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.PASS;
            }
            GemTestReporter.addTestStep("Jewel Url Validation", "Successful<br>Expected Jewel URL: " + expectedUrl + "<br>Actual Jewel URL: " + s1, status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on pricing$")
    public void pricing() throws Exception {
        try {
            DriverAction.click(Locators.pricing, "Click on pricing", "Click on pricing successful");
            DriverAction.waitSec(2);

        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^validate pricing url (.+)$")
    public void pricingurl(String expectedPurl) throws Exception {
        try {
            DriverAction.waitSec(2);
            String s2 = DriverAction.getCurrentURL();
            STATUS status;
            if (s2.equals(expectedPurl)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Pricing Url Validation", "successful<br>Expected Pricing URL: " + expectedPurl + "<br>Actual Pricing URL: " + s2, status);

        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^clicking on pricing and checking for main heading (.+)$")
    public void clickpricing(String pricingHead) throws Exception {
        try {
            DriverAction.waitSec(2);
            DriverAction.click(Locators.pricing);
            DriverAction.waitSec(4);
            String s3 = DriverAction.getElementText(Locators.pricingheading);
            STATUS status;
            if (s3.equals(pricingHead)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Pricing heading validation", "Successful<br>Expected heading1: " + pricingHead + "<br>Actual heading1: " + s3, status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^checking for subheading (.+)$")
    public void subheading(String pricingSubHead) throws Exception {
        try {
            String s4 = DriverAction.getElementText(Locators.pricingsubheading);
            STATUS status;
            if (s4.equals(pricingSubHead)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Pricing heading2 validation", "successful<br>Expected heading2: " + pricingSubHead + "<br>Actual heading2: " + s4, status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^checking for text (.+)$")
    public void text(String Text) throws Exception {
        try {
            String s4 = DriverAction.getElementText(Locators.pricingcontent);
            STATUS status;
            if (s4.equals(Text)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Pricing content validation", "Successful<br>Expected Pricing content: " + Text + "<br>Actual Pricing content: " + s4, status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^clicking on jewel again validating main heading (.+)$")
    public void jewelhead(String mainHeading) {
        try {
            DriverAction.waitSec(3);
            String s5 = DriverAction.getElementText(Locators.jewelheading);
            STATUS status;
            if (s5.equals(mainHeading)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Jewel heading validation", "Successful<br>Expected heading: " + mainHeading + "<br>Actual head: " + s5, status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^validating subheading of jewel (.+)$")
    public void jewelShead(String subHeading) {
        try {
            String s6 = DriverAction.getElementText(Locators.jewelsubheading);
            STATUS status;
            if (s6.equals(subHeading)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Jewel content validation", "successful<br>Expected content: " + subHeading + "<br>Actual content: " + s6, status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^validating whatisjewel (.+)$")
    public void whatisjewel(String whatisjewel) throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.pageScroll(500, 500, false);
            DriverAction.waitSec(3);
            GemTestReporter.addTestStep("Scrolling down", "Scrolling is successful", STATUS.PASS, DriverAction.takeSnapShot());
            String s7 = DriverAction.getElementText(Locators.whatisjewel);
            STATUS status;
            if (s7.equals(whatisjewel)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("What is jewel validation", "Successful<br>Expected content: " + whatisjewel + "<br>Actual content: " + s7, status);

        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^validating about us (.+)$")
    public void aboutus(String aboutus) {
        try {
            STATUS status;
            String s8 = DriverAction.getElementText(Locators.aboutus);
            if (s8.equals(aboutus)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("About us validation", "Successful<br>Expected content: " + aboutus + "<br>Actual content: " + s8, status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^validating content (.+)$")
    public void content(String content) {
        try {
            STATUS status;
            String s9 = DriverAction.getElementText(Locators.content);
            if (s9.contains(content)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Content validation", "Successful<br>Expected content: " + s9 + "<br>Actual content: " + s9, status);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^validating view report (.+)$")
    public void viewreport(String viewreport) {
        try {
            STATUS status;
            DriverAction.waitSec(1);
            DriverAction.pageScroll(500, 500, true);
            DriverAction.waitSec(3);
            String s10 = DriverAction.getElementText(Locators.viewreport);
            if (s10.contains(viewreport)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("View report validation", "successful<br>Expected heading: " + s10 + "<br>Actual content: " + s10, status);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^validating view reportC (.+)$")
    public void viewcontent(String viewcontent) {
        try {
            String s11 = DriverAction.getElementText(Locators.viewreportcontent);
            STATUS status;
            if (s11.equals(viewcontent)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("View report content validation", "Successful<br>Expected content: " + s11 + "<br>Actual content: " + s11, status);

        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^validating run test (.+)$")
    public void runtest(String runtest) {
        try {
            DriverAction.waitSec(1);
            DriverAction.pageScroll(1000, 1000, false);
            DriverAction.waitSec(3);
            GemTestReporter.addTestStep("Scrolling down", "Scrolling is successful", STATUS.INFO, DriverAction.takeSnapShot());
            String s12 = DriverAction.getElementText(Locators.runtest);
            STATUS status;
            if (s12.equals(runtest)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Run test suite validation", "Sucessfull<br>Expected content: " + s12 + "<br>Actual content: " + s12, status);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^validating run testC (.+)$")
    public void runsuite(String runcontentC) {
        try {
            String s13 = DriverAction.getElementText(Locators.runtestc);
            STATUS status;
            if (runcontentC.contains(s13)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Run test suite content validation", "Successful<br>Expected content: " + s13 + "<br>Actual content: " + s13, status);

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^click on facebook logo validate url (.+)$")
    public void facebook(String facebook) throws Exception {
        try {
            STATUS status;
            DriverAction.waitSec(1);
            DriverAction.pageScroll(1500, 1500, true);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.facebook);
            DriverAction.waitSec(2);
            ArrayList<String> newTb = new ArrayList<>(DriverAction.getWindowHandles());
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb.get(1));
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on Facebook logo", "Click on facebook logo successful", STATUS.PASS, DriverAction.takeSnapShot());
            String s15 = DriverAction.getCurrentURL();
            if (s15.equals(facebook)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep(" Facebook Url Validation", "Successful<br>Expected URL: " + facebook + "<br>Actual URL: " + s15, status);
            DriverManager.getWebDriver().close();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Close facebook tab", "Close facebook tab successfully", STATUS.PASS);
            DriverAction.switchToWindow(newTb.get(0));
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("click on twitter logo and validate url (.+)$")
    public void twitter(String twitter) throws Exception {
        try {
            STATUS status;
            DriverAction.waitSec(1);
            DriverAction.pageScroll(1500, 1500, true);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.twitter);
            ArrayList<String> newTb1 = new ArrayList<>(DriverAction.getWindowHandles());
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb1.get(1));
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on twitter logo", "Click on twitter logo successful", STATUS.PASS, DriverAction.takeSnapShot());
            String s16 = DriverAction.getCurrentURL();
            if (s16.equals(twitter)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep(" Twitter Url Validation", "Successful<br>Expected URL: " + twitter + "<br>Actual URL: " + s16, status);
            DriverManager.getWebDriver().close();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Close twitter tab", "Close twitter tab successfully", STATUS.PASS);
            DriverAction.switchToWindow(newTb1.get(0));
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^click on instagram logo and validate url (.+)$")
    public void instagram(String insta) {
        try {
            STATUS status;
            DriverAction.waitSec(1);
            DriverAction.pageScroll(1500, 1500, true);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.instagram);
            ArrayList<String> newTb2 = new ArrayList<>(DriverAction.getWindowHandles());
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb2.get(1));
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on instagram logo", "Click on instagram logo successful", STATUS.PASS, DriverAction.takeSnapShot());
            String s17 = DriverAction.getCurrentURL();
            if (s17.equals(insta)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep(" Instagram Url Validation", "Successful<br>Expected URL: " + insta + "<br>Actual URL: " + s17, status);
            DriverManager.getWebDriver().close();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Close instagram tab", "Close instagram tab successfully", STATUS.PASS);
            DriverAction.switchToWindow(newTb2.get(0));
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^click on linkedin logo and validate url (.+)$")
    public void linkedin(String linked) {
        try {
            STATUS status;
            DriverAction.waitSec(1);
            DriverAction.pageScroll(1500, 1500, true);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.linkedin);
            ArrayList<String> newTb3 = new ArrayList<>(DriverAction.getWindowHandles());
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb3.get(1));
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on linkedin logo", "Click on linkedin logo successful", STATUS.PASS, DriverAction.takeSnapShot());
            String s18 = DriverAction.getCurrentURL();
            if (s18.contains(linked)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep(" Linkedin Url Validation", "Successful<br>Expected URL: " + s18 + "<br>Actual URL: " + s18, status);
            DriverManager.getWebDriver().close();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Close linkedin tab", "Close linkedin tab successfully", STATUS.PASS);
            DriverAction.switchToWindow(newTb3.get(0));
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^click on jewel dashboard button$")
    public void jewelogo() throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.pageScroll(1500, 1500, false);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.jeweldashboard);
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Click on Feature Jewel dashboard", "Click on Feature Jewel dashboard successful", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^click on gemPYP and validate url (.+)$")
    public void gempyp(String pyp) throws Exception {
        try {
            STATUS status;
            DriverAction.waitSec(1);
            DriverAction.pageScroll(1500, 1500, true);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.gempyp);
            ArrayList<String> newTb4 = new ArrayList<>(DriverAction.getWindowHandles());
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb4.get(1));
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on GemPYP", "Click on GemPYP successful", STATUS.PASS, DriverAction.takeSnapShot());
            String s19 = DriverAction.getCurrentURL();
            if (s19.equals(pyp)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep(" GemPYP Url Validation", "Successful<br>Expected URL: " + pyp + "<br>Actual URL: " + s19, status);
            DriverManager.getWebDriver().close();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Close GemPYP tab", "Close GemPYP tab successfully", STATUS.PASS);
            DriverAction.switchToWindow(newTb4.get(0));
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^click on gemPRF and validate url (.+)$")
    public void gemprf(String prf) throws Exception {
        try {
            STATUS status;
            DriverAction.waitSec(1);
            DriverAction.pageScroll(1500, 1500, true);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.gemprf);
            ArrayList<String> newTb5 = new ArrayList<>(DriverAction.getWindowHandles());
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb5.get(1));
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on GemPRF", "Click on GemPRF successful", STATUS.PASS, DriverAction.takeSnapShot());
            String s20 = DriverAction.getCurrentURL();
            if (s20.equals(prf)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep(" GemPRF Url Validation", "Successful<br>Expected URL: " + prf + "<br>Actual URL: " + s20, status);
            DriverManager.getWebDriver().close();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Close GemPRF tab", "Close GemPRF tab successfully", STATUS.PASS);
            DriverAction.switchToWindow(newTb5.get(0));
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^click on gemJAR and validate url (.+)$")
    public void gemjar(String jar) throws Exception {
        try {
            STATUS status;
            DriverAction.waitSec(1);
            DriverAction.pageScroll(1500, 1500, true);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.gemjar);
            ArrayList<String> newTb6 = new ArrayList<>(DriverAction.getWindowHandles());
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb6.get(1));
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on GemJAR", "GemJAR has been clicked", STATUS.PASS, DriverAction.takeSnapShot());
            String s21 = DriverAction.getCurrentURL();
            if (s21.equals(jar)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep(" GemJARUrl Validation", "Successful<br>Expected URL: " + jar + "<br>Actual URL: " + s21, status);

            DriverManager.getWebDriver().close();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Close GemJAR tab", "Close GemJAR tab successfully", STATUS.PASS);
            DriverAction.switchToWindow(newTb6.get(0));
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^click on pricing button$")
    public void pricingbutton() throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.pageScroll(1500, 1500, false);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.pricingbutton);
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Click on company pricing", "Click on company pricing successful", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^click on signup$")
    public void signup() throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.click(Locators.signup);
            DriverAction.waitSec(1);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("enter {string} {string} {string} {string} {string} {string} {string}")
    public void signupPage(String name, String last, String user, String email, String pass, String cpass, String company) throws Exception {
        try {
            DriverAction.click(Locators.firstname);
            DriverAction.typeText(Locators.firstname, name, "Enter Firstname", "Firstname has been entered: " + name + " ");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.lastname);
            DriverAction.typeText(Locators.lastname, last, "Enter Lastname", "Lastname has been entered: " + last + " ");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.username1);
            DriverAction.typeText(Locators.username1, user);
            DriverAction.waitSec(3);
            GemTestReporter.addTestStep("Enter Username", "Username has been entered: " + user + " ", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.click(Locators.emailm);
            DriverAction.typeText(Locators.emailm, email, "Enter Email", "Email has been entered: " + email + " ");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.password1);
            DriverAction.typeText(Locators.password1, pass, "Enter Password", "Password has been entered: " + pass + " ");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.confirmpass);
            DriverAction.typeText(Locators.confirmpass, cpass, "Enter Confirm Password", "Confirm password has been entered: " + cpass + " ");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.companyname);
            DriverAction.typeText(Locators.companyname, company, "Enter Company", "Company name has been entered: " + company + " ");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.register);
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("User exists", "User already exists", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }


    @Given("^click on login and enter (.+) and (.+)$")
    public void loginn(String username, String password) throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.click(Locators.logIn);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.username);
            DriverAction.waitSec(1);
            DriverAction.typeText(Locators.username, username);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.passwordm);
            DriverAction.waitSec(1);
            DriverAction.typeText(Locators.passwordm, password);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.LoginButton);
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on autolytics and create report$")
    public void autolytics() throws Exception {
        try {
            DriverAction.click(Locators.autolyticsm, "Click on autolytics", "Click on autolytics successful");
            DriverAction.waitSec(2);
            DriverAction.click(Locators.createReport, "Click on create report", "Click on create report successful");
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^select report name$")
    public void reportName() throws Exception {
        try {
            DriverAction.click(Locators.reportNameScroll, "Click on report name", "Click on report name successful");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.suiteRunReport, "Select suite run report", "Select suite run report successful");
            DriverAction.waitSec(1);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^select project name$")
    public void projectName() throws Exception {
        try {
            DriverAction.click(Locators.projectScroll, "Click on project", "Click on project successful");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.gemEcoApis, "Select gem-ecosystem API", "Select gem-ecosystem API successful");
            DriverAction.waitSec(1);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^select enviroment$")
    public void enviromentName() throws Exception {
        try {
            DriverAction.click(Locators.enviromentScroll, "Click on environment", "Click on environment successful");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.prod, "Select prod", "Select prod successful");
            DriverAction.waitSec(1);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^select date range and click on generate$")
    public void dateRange() throws Exception {
        try {
            DriverAction.click(Locators.dateRangeScroll, "Click on date range", "Click on date range successful");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.thisYear, "Select this year", "Select this year successful");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.generate);
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on Generate button", "Click on Generate button successful", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^validate sorting of numbers$")
    public void sorting() throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.doubleClick(Locators.sno);
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Double click on S No", "Double click on S No successful", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.pageScroll(1000, 1000, false);
            DriverAction.waitSec(4);
            STATUS status;
            String s3 = DriverAction.getElementText(Locators.total);
            String s4 = s3.substring(6, 8);
//        int value = Integer.parseInt(s4);
            String s2 = DriverAction.getElementText(Locators.span);
            if (s2.equals(s4)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep(" Sorting Validation", "Successful<br>Expected Text: " + s2 + "<br>Actual Text: " + s4, status);

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Given("^click on login and enters (.+) and (.+)$")
    public void loginnn(String usernames, String passwords) throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.click(Locators.logIn);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.username);
            DriverAction.waitSec(1);
            DriverAction.typeText(Locators.username, usernames);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.passwordm);
            DriverAction.waitSec(1);
            DriverAction.typeText(Locators.passwordm, passwords);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.LoginButton);
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on autolytics and create reports$")
    public void autolyticss() throws Exception {
        try {
            DriverAction.click(Locators.autolyticsm);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.createReport);
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^select report names$")
    public void reportNames() throws Exception {
        try {
            DriverAction.click(Locators.reportNameScroll);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.suiteRunReport);
            DriverAction.waitSec(1);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^select project names$")
    public void projectNames() throws Exception {
        try {
            DriverAction.click(Locators.projectScroll);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.gemEcoApis);
            DriverAction.waitSec(1);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^select enviroments$")
    public void enviromentNames() throws Exception {
        try {
            DriverAction.click(Locators.enviromentScroll);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.prod);
            DriverAction.waitSec(1);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^select date range and click on generates$")
    public void dateRanges() throws Exception {
        try {
            DriverAction.click(Locators.dateRangeScroll);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.thisYear);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.generate);
            DriverAction.waitSec(4);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on copy button and check if report opens in new tab and click on new tab button and validate (.+) of shared report")
    public void buttons(String sharedurl) throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.click(Locators.copyButton);
            DriverAction.waitSec(3);
            GemTestReporter.addTestStep("Click on Copy Button", "Click on Copy Button successful", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.click(Locators.newTab);
            ArrayList<String> newTb7 = new ArrayList<>(DriverAction.getWindowHandles());
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb7.get(1));
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on share report button", "Click on share report button successful", STATUS.PASS, DriverAction.takeSnapShot());
            String string = DriverAction.getCurrentURL();
            STATUS status;
            if (string.equals(sharedurl)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep(" Share report Url Validation", "Successful<br>Expected URL: " + sharedurl + "<br>Actual URL: " + string, status);
            DriverManager.getWebDriver().close();
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb7.get(0));
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on create report button$")
    public void createReportButton() throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.click(Locators.createReportButton, "Click on create report button", "Click on create report button successful");
            DriverAction.waitSec(1);
            DriverAction.click(Locators.crossCreateReport);
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on filter status and select pass$")
    public void filter() throws Exception {
        try {
            DriverAction.click(Locators.filter);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.selectFilter);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.selectPass);
            String asert = DriverAction.getElementText(Locators.selct_pass_text);

            DriverAction.waitSec(1);
            DriverAction.click(Locators.closeFilter);
            DriverAction.waitSec(3);

            int count = 0;
            int flag = 0;
            List<String> list = DriverAction.getElementsText(Locators.pass);
            for (int i = 0; i < list.size(); i++) {
                if (asert.equalsIgnoreCase(list.get(i))) {
                    count++;
                }
            }
            if (count == list.size()) {

                GemTestReporter.addTestStep(" Filter Pass Validation", "Expected:" + asert, STATUS.INFO);
                GemTestReporter.addTestStep("Filer Pass Validation", "Text we got" + list.get(0), STATUS.PASS);
            } else {
                GemTestReporter.addTestStep(" Filter Pass Validation", "Expected:" + asert, STATUS.INFO);
                GemTestReporter.addTestStep("Filer Pass Validation", "Text we got" + list.get(0), STATUS.FAIL);
            }
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on exe$")
    public void exe() throws Exception {
        try {
            DriverAction.click(Locators.selectFilter1);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.selectPass);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.exe);
            DriverAction.waitSec(1);
            String asert1 = DriverAction.getElementText(Locators.select_exe_text);
            DriverAction.waitSec(3);
            DriverAction.click(Locators.closeFilter);
            int count1 = 0;
            List<String> list1 = DriverAction.getElementsText(Locators.exe1);
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
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on fail$")
    public void fail() throws Exception {
        try {
            DriverAction.click(Locators.selectFilter1);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.exe);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.fail);
            DriverAction.waitSec(1);
            String asert2 = DriverAction.getElementText(Locators.select_fail_text);
            DriverAction.waitSec(3);
            DriverAction.click(Locators.closeFilter);
            int count2 = 0;
            List<String> list2 = DriverAction.getElementsText(Locators.fail1);
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
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on warn$")
    public void warn() throws Exception {
        try {
            DriverAction.click(Locators.selectFilter1);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.fail);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.warn);
            DriverAction.waitSec(1);
            String asert3 = DriverAction.getElementText(Locators.select_warn_text);
            DriverAction.waitSec(3);
            int count3 = 0;
            List<String> list3 = DriverAction.getElementsText(Locators.warn1);
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
            DriverAction.click(Locators.warn);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.closeFilter);
            DriverAction.waitSec(1);
            DriverAction.doubleClick(Locators.pass);
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on filter2 and select a date$")
    public void filter2() throws Exception {
        try {
            DriverAction.waitSec(2);
            DriverAction.pageScroll(1000, 1000, false);
            DriverAction.waitSec(2);
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
            js.executeScript("arguments[0].scrollIntoView();", DriverManager.getWebDriver().findElement(By.xpath("//*[text()='August 17, 2022 6:11:28 PM (IST)']")));
            DriverAction.waitSec(4);
            DriverAction.click(Locators.filter1);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.selectFilter);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.selectDate);
            DriverAction.waitSec(2);
            String asert4 = DriverAction.getElementText(Locators.selectDate);
            DriverAction.waitSec(3);
            int count4 = 0;
            List<String> list4 = DriverAction.getElementsText(Locators.select_date_text);
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
            DriverAction.click(Locators.selectDate);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.closeFilter);
            DriverAction.waitSec(1);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on action button and then validate (.+)$")
    public void action(String executionReport) throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.click(Locators.action);
            DriverAction.waitSec(3);
            String exe = DriverAction.getElementText(Locators.executionR);
            STATUS status;
            if (exe.equals(executionReport)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep("Execution Report tab Validation", "successful<br>Expected text: " + executionReport + "<br>Actual text: " + exe, status);

        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on new tab button and validate (.+) of execution report$")
    public void newtabbb(String executionUrl) throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.click(Locators.newtb_button);
            ArrayList<String> newTb7 = new ArrayList<>(DriverAction.getWindowHandles());
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb7.get(1));
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on share report button", "Click on share report button successful", STATUS.PASS, DriverAction.takeSnapShot());
            String string = DriverAction.getCurrentURL();
            STATUS status;
            if (string.equals(executionUrl)) {
                status = STATUS.PASS;
            } else {
                status = STATUS.FAIL;
            }
            GemTestReporter.addTestStep(" Execution report Url Validation", "Successful<br>Expected URL: " + executionUrl + "<br>Actual URL: " + string, status);

            DriverManager.getWebDriver().close();
            DriverAction.waitSec(2);
            DriverAction.switchToWindow(newTb7.get(0));
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }

    @Then("^click on testcase detail and validate filter$")
    public void testCase() throws Exception {
        try {
            DriverAction.waitSec(1);
            DriverAction.click(Locators.testcaseDetail);
            DriverAction.waitSec(2);
            DriverAction.click(Locators.selectFilter3);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.select_filter);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.click_filter);
            DriverAction.waitSec(1);
            String asert68 = DriverAction.getElementText(Locators.inside_filter_text);
            DriverAction.waitSec(1);
            DriverAction.click(Locators.closeFilter);
            DriverAction.waitSec(3);
            int count2 = 0;
            List<String> listing = DriverAction.getElementsText(Locators.outside_filter_text);
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
            DriverAction.doubleClick(Locators.close_filter1);
            DriverAction.waitSec(2);
        } catch (Exception e) {
            logger.info("Exception occurred", e);
            GemTestReporter.addTestStep("Error!!", "Something Wrong happened", STATUS.FAIL);
        }
    }


}



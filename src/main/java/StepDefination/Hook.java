package StepDefination;

import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.Before;
import com.gemini.generic.reporting.GemTestReporter.*;
public class Hook {
    @Before
    public static void hook(){
        DriverManager.setUpBrowser();
    }
}

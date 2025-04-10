package hooks;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        Base.startBrowser("https://demoqa.com/webtables");
    }

    @After
    public void tearDown() {
        Base.closeBrowser();
    }
}

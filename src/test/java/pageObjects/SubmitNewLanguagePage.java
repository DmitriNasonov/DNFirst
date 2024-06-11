package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class SubmitNewLanguagePage extends BasePage {
    private static final String SubMenuLanguageSNL = "SUBMIT NEW LANGUAGE";

    private static final String ImportantMessage = "IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description), the easier it will be for us and the faster your language will show up on this page. We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.";

    @FindBy(xpath = "//p[contains(@style,'border: 1px solid red;')]")
    private WebElement errorMessage;

    @FindBy(xpath = ("//input[@name = 'submitlanguage']"))
    private WebElement clickSubmitLanguageButton;

    public SubmitNewLanguagePage(WebDriver driver) {

        super(driver);
    }

    private List<WebElement> getImportantMessageList() {
        List<WebElement> elem = driver.findElements(By.xpath("//ul[@id = 'submenu']//a"));
//        System.out.println(elem.size());
        return elem;
    }

    public boolean verifySubMenuItem() {

        for (int i = 0; i < getImportantMessageList().size(); i++) {
            if (getImportantMessageList().get(i).getText().
                    equalsIgnoreCase(SubMenuLanguageSNL)) {
                return true;
            }

        }
        return false;
    }

    public WebElement submitLanguageButton() {

        return driver.findElement(By.xpath("//input[@name = 'submitlanguage']"));
    }

    public WebElement getTexError() {

        return driver.findElement(By.xpath("//p[contains(@style,'border: 1px solid red;')]"));
    }

    public boolean verifyErrorMessage() {
        submitLanguageButton().click();
        return getTexError().getText().equals("Error: Precondition failed - Incomplete Input.");
    }

    public boolean verifyErrorPFIIList() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//input[@name='submitlanguage']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int submit = button.getLocation().getY();
        for (int i = 0; i < submit; i += 20) {
            js.executeScript("window.scrollTo(0," + i + ")");
            Thread.sleep(50);
        }
//        WebElement button = driver.findElement(By.xpath("//input[@name='submitlanguage']"));
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        int submit = button.getLocation().getY();
////        js.executeScript("arguments[0],scrollIntoView({behavior:'smooth',block:'center;,inline:'center'};",button);
//        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", button);
//        //Нажимаю на кнопку  чтобы получить текст ошибки
        submitLanguageButton().click();


        String errMessage = driver.findElement(By.xpath("//*[contains(@style,'border: 1px solid red; ')]")).getText().trim();
        String[] arrWordErr = errMessage.split(" ");
        //Преобразовываю массив строк в список
        List<String> errMessageList = Arrays.asList(arrWordErr);
        List<String> keywords = Arrays.asList("Error:", "Precondition", "Incomplete", "Input.", "failed", "-");

        boolean result = true;
        if (errMessageList.size() != keywords.size()) {
            result = false;
        } else {
            for (int i = 0; i < keywords.size(); i++) {
                boolean keywordFound = false;
                for (int j = 0; j < errMessageList.size(); j++) {
                    if (errMessageList.get(i).equals(keywords.get(j))) {
                        keywordFound = true;
                        break;
                    }
                }
                if (!keywordFound) {
                    result = false;
                    break;
                }
            }
            if (!errMessage.contains(".") || !errMessage.contains(":") || !errMessage.contains("-")) {
                result = false;
            }
        }
        return result;
    }


    private List<WebElement> getImportantMessageList1() {
        List<WebElement> elem = driver.findElements(By.xpath("//div[@id = 'main']/ul/li"));
//        System.out.println(elem.size());
        return elem;
    }

    public boolean verifyImportantMessage() {

        for (int i = 0; i < getImportantMessageList1().size(); i++) {
            if (getImportantMessageList1().get(i).getText().
                    equalsIgnoreCase(ImportantMessage)) {
                return true;
            }

        }
        return false;
    }

    public List<WebElement> getImportantMessage() {

        return driver.findElements(By.xpath("//div[@id = 'main']/ul/li"));
        //ul/li/span[@style='background-color:red; color: white']
    }

    public boolean verifyImportantMessage1() {

        return getImportantMessage().get(0).getText().equals("IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description), the easier it will be for us and the faster your language will show up on this page. We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.");
    }
    //  Task# 11-21
    //Нашли слово импортант
    public  WebElement importantWhite () {

        return driver.findElement(By.xpath("//div[@id='main']//ul/li/span"));
        //Attribute проверить есть ли атрибут style  и содержит ли он цвет white
    }
    public WebElement importantBoltVSCapital(){
        return driver.findElement(By.xpath("//*[text()='IMPORTANT:']"));
    }

    public WebElement importantBgRed(){
        return  driver.findElement(By.xpath("//div[@id='main']//ul/li/span"));
    }

}

//    public class ColorDetector {
//
//        public static void detectColors(JComponent component) {
//            Color textColor = component.getForeground();
//            Color backgroundColor = component.getBackground();
//
//            System.out.println("Text Color: " + colorToString(textColor));
//            System.out.println("Background Color: " + colorToString(backgroundColor));
//        }
//
//        private static String colorToString(Color color) {
//            return String.format("RGB(%d, %d, %d)", color.getRed(), color.getGreen(), color.getBlue());
//        }
//
//        public static void main(String[] args) {
//            // Sample JLabel for demonstration
//            JLabel label = new JLabel("Sample Text");
//            label.setForeground(Color.BLUE);
//            label.setBackground(Color.YELLOW);
//            label.setOpaque(true);  // Needed to see the background color
//
//            // Create a frame to show the label
//            JFrame frame = new JFrame("Color Detector");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(300, 200);
//            frame.setLayout(new FlowLayout());
//            frame.add(label);
//            frame.setVisible(true);
//
//            // Detect and print colors
//            detectColors(label);
//        }
//    }
//}

    //Sergey Demianenko
//    public WebElement getTexError() {
//        return errorMessage;
//    }
//
//    public WebElement submitLanguageButton() {
//        return clickSubmitLanguageButton;
//    }
//    public boolean verifyErrorMessage() {
//        submitLanguageButton().click();
//        return getTexError().getText().equals("Error: Precondition failed - Incomplete Input.");
//    }
//}

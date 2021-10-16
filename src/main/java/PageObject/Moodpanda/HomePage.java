package PageObject.Moodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class HomePage {

    @FindBy(css = ".scroll-down > a")
    SelenideElement scrollDownBtn;

    @FindBy(className = "brand-name-subtext")
    SelenideElement brandNameSubtext;

    @FindBy(css = ".img-responsive.img-centered")
    SelenideElement img;

    public HomePage clickScrollDownBtn() {
        scrollDownBtn.click();
        return this;
    }
    public HomePage clickAboutBtn() {
        $(byText("About")).click();
        return this;
    }

    public HomePage clickLoginBtn() {
        $(byText("Login")).click();
        return this;
    }
    public HomePage clickFaqBtn() {
        $(byText("FAQs")).click();
        return this;
    }


    public HomePage checkBrandNameSubtext() {
        brandNameSubtext.should(Condition.matchText("track your mood & get anonymous support"));
        return this;
    }

    public HomePage checkImage() {
        this.img.shouldBe(Condition.exist);
        return this;
    }
}

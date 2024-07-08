package slider;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTests extends baseTest {

    @Test
    public void dragSliderToRight () {
        String value = "4";
        var horizontalSliderPage = homePage.dragSlider();
        horizontalSliderPage.moveSlider(value);
        Assert.assertEquals(horizontalSliderPage.getTextValue(), value, "Slider didn't move required places");
    }
}

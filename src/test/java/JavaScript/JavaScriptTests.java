package JavaScript;

import base.baseTest;
import org.testng.annotations.Test;

public class JavaScriptTests extends baseTest {

    @Test
    public void testScrollToTable() {
        var largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
        largeAndDeepDomPage.scrollToTable();
    }

    @Test
    public void testParagraphScrolls() {
        homePage.clickInfiniteScroll().scrollParagraphs(5);
    }
}

package DragAndDropElements;

import base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends baseTest {

    @Test
    public void testDragAndDropOfElements() {
        var dragAndDropPage = homePage.clickDragAndDrop();
        dragAndDropPage.dragFirstColumnTowardsSecond();
        Assert.assertEquals(dragAndDropPage.validateNewTextOfFirstColumns(), "B");
        Assert.assertEquals(dragAndDropPage.validateNewTextOfSecondColumns(), "A");
        dragAndDropPage.dragSecondColumnTowardsFirst();
        Assert.assertEquals(dragAndDropPage.validateNewTextOfFirstColumns(), "A");
        Assert.assertEquals(dragAndDropPage.validateNewTextOfSecondColumns(), "B");
    }
}

import com.flow.management.Cupboards;
import com.flow.management.Employees;
import com.flow.management.FurniturePanels;
import com.flow.management.Glass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCupboards {
    private Cupboards cupboards;
    private FurniturePanels panels;
    private Glass glass;
    private Employees employees;

    @Before
    public void setup() {
        cupboards = new Cupboards();
        panels = new FurniturePanels();
        glass = new Glass();
        employees = new Employees();
    }

    @Test
    public void testMaximumProducts() {
        employees.changeEmployeeCount(20);
        employees.setMaxProductByEmployees();
        glass.purchase(1000);
        panels.purchase(1000);
        Assert.assertEquals(500, cupboards.setMaximumProducts(panels, glass, employees));

    }
}

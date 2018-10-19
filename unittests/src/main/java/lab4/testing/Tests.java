package lab4.testing;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class Tests {

    @DataProvider
    public static Object[][] triangleZeroSizes() {
        return new Object[][]{
                {0, 4, 5},
                {3, 0, 5},
                {3, 4, 0}
        };
    }

    @DataProvider
    public static Object[][] triangleNegativeSizes() {
        return new Object[][]{
                {-3, 4, 5},
                {3, -4, 5},
                {3, 4, -5}
        };
    }

    @DataProvider
    public static Object[][] conditionsAreNotFulfilled() {
        return new Object[][]{
                {13, 4, 5},
                {3, 14, 5},
                {3, 4, 15}
        };
    }

    @DataProvider
    public static Object[][] conditionsAreFulfilled() {
        return new Object[][]{
                {3, 4, 6},
                {3, 6, 5},
                {6, 4, 5}
        };
    }

    @Test
    public void buildIsoscelesTriangleShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(4, 4, 3));
    }

    @Test
    public void buildTriangleWhenSumOfTwoEqualSidesIsEqualToThirdShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 3, 6));
    }

    @Test
    public void buildTriangleWhenSumOfTwoEqualSidesIsLessThanThirdShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 3, 7));
    }

    @Test
    public void buildRightTriangleShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(3, 4, 5));
    }

    @Test
    public void buildEquilateralTriangleShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(3, 3, 3));
    }

    @Test
    @UseDataProvider("triangleZeroSizes")
    public void buildTriangleWhenOneSideIsZeroShouldReturnFalse(double a, double b, double c) {
        Assert.assertFalse(Triangle.getTriangle(a, b, c));
    }

    @Test
    @UseDataProvider("triangleNegativeSizes")
    public void buildTriangleWhenOneSideIsNegativeShouldReturnFalse(double a, double b, double c) {
        Assert.assertFalse(Triangle.getTriangle(a, b, c));
    }

    @Test
    @UseDataProvider("conditionsAreFulfilled")
    public void buildTriangleWhenConditionsAreFulfilledShouldReturnTrue(double a, double b, double c) {
        Assert.assertTrue(Triangle.getTriangle(a, b, c));
    }

    @Test
    @UseDataProvider("conditionsAreNotFulfilled")
    public void buildTriangleWhenConditionsAreNotFulfilledShouldReturnFalse(double a, double b, double c) {
        Assert.assertFalse(Triangle.getTriangle(a, b, c));
    }
}

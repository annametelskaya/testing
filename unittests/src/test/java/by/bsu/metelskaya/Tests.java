package by.bsu.metelskaya;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

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
        Assert.assertTrue(new Triangle(4, 4, 3).getTriangle());
    }

    @Test
    public void buildTriangleWhenSumOfTwoEqualSidesIsEqualToThirdShouldReturnFalse() {
        Assert.assertFalse(new Triangle(3, 3, 6).getTriangle());
    }

    @Test
    public void buildTriangleWhenSumOfTwoEqualSidesIsLessThanThirdShouldReturnFalse() {
        Assert.assertFalse(new Triangle(3, 3, 7).getTriangle());
    }

    @Test
    public void buildRightTriangleShouldReturnTrue() {
        Assert.assertTrue(new Triangle(3, 4, 5).getTriangle());
    }

    @Test
    public void buildEquilateralTriangleShouldReturnTrue() {
        Assert.assertTrue(new Triangle(3, 3, 3).getTriangle());
    }

    @Test
    @UseDataProvider("triangleZeroSizes")
    public void buildTriangleWhenOneSideIsZeroShouldReturnFalse(double a, double b, double c) {
        Assert.assertFalse(new Triangle(a, b, c).getTriangle());
    }

    @Test
    @UseDataProvider("triangleNegativeSizes")
    public void buildTriangleWhenOneSideIsNegativeShouldReturnFalse(double a, double b, double c) {
        Assert.assertFalse(new Triangle(a, b, c).getTriangle());
    }

    @Test
    @UseDataProvider("conditionsAreFulfilled")
    public void buildTriangleWhenConditionsAreFulfilledShouldReturnTrue(double a, double b, double c) {
        Assert.assertTrue(new Triangle(a, b, c).getTriangle());
    }

    @Test
    @UseDataProvider("conditionsAreNotFulfilled")
    public void buildTriangleWhenConditionsAreNotFulfilledShouldReturnFalse(double a, double b, double c) {
        Assert.assertFalse(new Triangle(a, b, c).getTriangle());
    }
}

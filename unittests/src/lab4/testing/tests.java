package lab4.testing;

import org.junit.Assert;
import org.junit.Test;

public class tests {
    /*1. build a triangle when conditions are fulfilled*/
    @Test
    public void buildTriangleWhenConditionsAreFulfilledShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(3, 4, 6));
    }

    /*2. build a triangle when conditions are not fulfilled*/
    @Test
    public void buildTriangleWhenConditionsAreNotFulfilledShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(7, 3, 2));
    }

    /*3. build a triangle with zero side*/
    @Test
    public void buildTriangleWithZeroSideShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 0, 5));
    }

    /*4. build a triangle with negative side*/
    @Test
    public void buildTriangleWithNegativeSideShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(-1, 4, 5));
    }

    /*5. build isosceles triangle*/
    @Test
    public void buildIsoscelesTriangleShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(4, 4, 3));
    }

    /*6. build triangle when sum of two equal side is equal to third side*/
    @Test
    public void buildTriangleWhenSumOfTwoEqualSidesIsEqualToThirdShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 3, 6));
    }

    /*7. build triangle when sum of two equal side is less than third side*/
    @Test
    public void buildTriangleWhenSumOfTwoEqualSidesIsLessThanThirdShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 3, 7));
    }

    /*8. build right triangle*/
    @Test
    public void buildRightTriangleShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(3, 4, 5));
    }

    /*9. build equilateral triangle*/
    @Test
    public void buildEquilateralTriangleShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(3, 3, 3));
    }

}

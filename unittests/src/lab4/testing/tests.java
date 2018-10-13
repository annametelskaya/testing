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

    /*3. build isosceles triangle*/
    @Test
    public void buildIsoscelesTriangleShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(4, 4, 3));
    }

    /*4. build triangle when sum of two equal sides is equal to third side*/
    @Test
    public void buildTriangleWhenSumOfTwoEqualSidesIsEqualToThirdShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 3, 6));
    }

    /*5. build triangle when sum of two equal sides is less than third side*/
    @Test
    public void buildTriangleWhenSumOfTwoEqualSidesIsLessThanThirdShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 3, 7));
    }

    /*6. build right triangle*/
    @Test
    public void buildRightTriangleShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(3, 4, 5));
    }

    /*7. build equilateral triangle*/
    @Test
    public void buildEquilateralTriangleShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(3, 3, 3));
    }

    /*8. build a triangle when first side is 0*/
    @Test
    public void buildTriangleWhenFirstSideIsZeroShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(0, 8, 5));
    }

    /*9. build a triangle when second side is 0*/
    @Test
    public void buildTriangleWhenSecondSideIsZeroShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 0, 5));
    }

    /*10. build a triangle when third side is 0*/
    @Test
    public void buildTriangleWhenThirdSideIsZeroShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 5, 0));
    }

    /*11. build a triangle when first side is negative*/
    @Test
    public void buildTriangleWhenFirstSideIsNegativeShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(-1, 4, 5));
    }

    /*12. build a triangle when second side is negative*/
    @Test
    public void buildTriangleWhenSecondSideIsNegativeShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, -2, 5));
    }

    /*13. build a triangle when third side is negative*/
    @Test
    public void buildTriangleWhenThirdSideIsNegativeShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 4, -2));
    }

}

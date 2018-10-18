package lab4.testing;

import org.junit.Assert;
import org.junit.Test;

public class tests {
    @Test
    public void buildTriangleWhenConditionsAreFulfilledShouldReturnTrue() {
        Assert.assertTrue(Triangle.getTriangle(3, 4, 6));
    }

    @Test
    public void buildTriangleWhenConditionsAreNotFulfilledShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(7, 3, 2));
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
    public void buildTriangleWhenFirstSideIsZeroShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(0, 8, 5));
    }

    @Test
    public void buildTriangleWhenSecondSideIsZeroShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 0, 5));
    }

    @Test
    public void buildTriangleWhenThirdSideIsZeroShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 5, 0));
    }

    @Test
    public void buildTriangleWhenFirstSideIsNegativeShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(-1, 4, 5));
    }

    @Test
    public void buildTriangleWhenSecondSideIsNegativeShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, -2, 5));
    }

    @Test
    public void buildTriangleWhenThirdSideIsNegativeShouldReturnFalse() {
        Assert.assertFalse(Triangle.getTriangle(3, 4, -2));
    }
}

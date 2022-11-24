package TriangleHW;

public class Triangle {

    public double getTriangleArea (int a, int b, int c) throws IsNotATriangleException {

        if(a <= 0 || b <= 0 || c <= 0) {
            throw new IsNotATriangleException("Length of the triangle side can't be a negative number or equal to zero.");
        } else if((a+b) < c || (b+c) < a || (a + c) < b){
            throw new IsNotATriangleException("A triangle with such sides can't exist. Try with other length values.");
        }
        double semiPerimeter, area;

        semiPerimeter = (a + b + c) / 2;
        area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
        return area;
    }
}


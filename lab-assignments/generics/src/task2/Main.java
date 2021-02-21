package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {
    @SuppressWarnings("unchecked")
    private static <T extends Summable> T computeSum(Collection<T> collection) {
        T sum;
        Iterator<T> iterator = collection.iterator();
        if (iterator.hasNext()) {
            T firstItem = iterator.next();
            if (firstItem instanceof MyVector3) {
                sum = (T) new MyVector3();
            } else if (firstItem instanceof MyMatrix) {
                sum = (T) new MyMatrix();
            } else {
                return null;
            }
        } else {
            return null;
        }

        for (var item : collection) {
            sum.addValue(item);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        MyMatrix myMatrix = new MyMatrix(matrix);

        int[] vector = {1,2,3};
        MyVector3 myVector3 = new MyVector3(vector);

        System.out.println(myMatrix);
        myMatrix.addValue(myMatrix);
        System.out.println(myMatrix);

        System.out.println(myVector3);
        myVector3.addValue(myVector3);
        System.out.println(myVector3);

        List<MyVector3> myVector3List = new ArrayList<>();
        myVector3List.add(myVector3);
        myVector3List.add(myVector3);
        myVector3List.add(myVector3);
        MyVector3 sum = computeSum(myVector3List);
        System.out.println(sum);
    }
}

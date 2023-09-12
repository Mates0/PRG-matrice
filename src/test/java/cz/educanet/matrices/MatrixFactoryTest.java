package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class MatrixFactoryTest {

    @Test
    void create() {
        double[][] matrix = new double[][]{
                {1,2,3},
                {5,6,7}
        };

        IMatrix matrixInstance = MatrixFactory.instance.create(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Assertions.assertEquals(matrix[i][j], matrixInstance.get(i,j));
            }
        }
    }

    @Test
    void createDiagonal() {
        double[][] diagonalMatrix = {{4, 5, 6}};

        for (double[] diagonal : diagonalMatrix) {
            IMatrix matrix = MatrixFactory.instance.createDiagonal(diagonal);
        }

    }

    @Test
    void createIdentity() {
    }

    @Test
    void createZero() {
    }
}
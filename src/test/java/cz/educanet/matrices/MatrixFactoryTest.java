package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixFactoryTest {

    private final IMatrixFactory matrixFactoryInstance = MatrixFactory.instance;

    @Test
    void create() {
        double[][] matrix = new double[][]{
                {1, 2, 3},
                {5, 6, 7}
        };

        IMatrix matrixInstance = MatrixFactory.instance.create(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Assertions.assertEquals(matrix[i][j], matrixInstance.get(i, j));
            }
        }
    }

    @Test
    void createDiagonal() {
        double[][] validDiagonals = new double[][]{
                {2, 4, 6, 10, 12},
                {4, 5, 6, 7, 8}};

        for (int i = 0; i < validDiagonals.length; i++) {
            double[] diagonal = validDiagonals[i];
            IMatrix matrix = matrixFactoryInstance.createDiagonal(diagonal);
            for (int j = 0; j < diagonal.length; j++) {
                for (int k = 0; k < diagonal.length; k++) {
                    Assertions.assertEquals(j == k ? diagonal[j] : 0, matrix.get(j, k));
                }
            }
        }

    }

    @Test
    void createIdentity() {
        int[] sizes = {1, 2, 3, 4, 5};

        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            IMatrix matrix = matrixFactoryInstance.createIdentity(size);
            for (int j = 0; j < matrix.getColumns(); j++) {
                for (int k = 0; k < matrix.getRows(); k++) {
                    if (j == k) {
                        Assertions.assertEquals(1, matrix.get(j, k));
                    }
                }
            }
        }
    }

    @Test
    void createZero() {
        int[] validSizes = {3, 5, 7, 10};

        for (int i = 0; i < validSizes.length; i++) {
            int size = validSizes[i];
            IMatrix matrix = matrixFactoryInstance.createZero(size);
            Assertions.assertEquals(size, matrix.getRows());
            Assertions.assertEquals(size, matrix.getColumns());
            for (int j = 0; j < matrix.getRows(); j++) {
                for (int k = 0; k < matrix.getColumns(); k++) {
                    Assertions.assertEquals(0, matrix.get(j, k));
                }
            }
        }
    }
}
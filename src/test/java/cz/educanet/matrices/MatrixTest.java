package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void times() {
        double[][] matrix = {
                {0, 0, 0},
                {2, 2, 2},
                {2, 2, 2}};
        double[][] expectedMatrix = {
                {0, 0, 0},
                {4, 4, 4},
                {4, 4, 4}};

        Matrix firstInstance = new Matrix(matrix);
        Matrix secondInstance = new Matrix(expectedMatrix);
        firstInstance = (Matrix) firstInstance.times(2);

        for (int i = 0; i < firstInstance.getRows(); i++) {
            for (int j = 0; j < firstInstance.getColumns(); j++) {
                Assertions.assertEquals(firstInstance.get(i, j), secondInstance.get(i, j));
            }
        }
    }

    @Test
    void testTimes() {
        double[][] matrix = {
                {0, 0, 0},
                {1, 1, 1},
                {1, 1, 1}};
        double[][] expectedMatrix = {
                {0, 0, 0},
                {2, 2, 2},
                {2, 2, 2}};

        Matrix firstInstance = new Matrix(matrix);
        Matrix secondInstance = new Matrix(expectedMatrix);
        firstInstance = (Matrix) firstInstance.times(2);

        for (int i = 0; i < firstInstance.getRows(); i++) {
            for (int j = 0; j < firstInstance.getColumns(); j++) {
                Assertions.assertEquals(firstInstance.get(i, j), secondInstance.get(i, j));
            }
        }
    }

    @Test
    void add() {
        double[][] matrix = {
                {0, 0, 0},
                {2, 2, 2}};
        double[][] matrix2 = {
                {0, 0, 0},
                {4, 4, 4}};
        double[][] expectedMatrix = {
                {0, 0, 0},
                {6, 6, 6}};

        Matrix firstInstance = new Matrix(matrix);
        Matrix secondInstance = new Matrix(matrix2);
        Matrix expected = (Matrix) firstInstance.add(secondInstance);

        for (int i = 0; i < expectedMatrix.length; i++) {
            for (int j = 0; j < expectedMatrix[0].length; j++) {
                Assertions.assertEquals(expectedMatrix[i][j] , expected.get(i,j));
            }
        }
    }

    @Test
    void transpose() {
        double[][] matrix = {
                {1, 5, 4},
                {8, 4, 1},
                {7, 2, 1}};
        double[][] expectedMatrix = {
                {1, 8, 7},
                {5, 4, 2},
                {4, 1, 1}};

        Matrix firstInstance = new Matrix(matrix);
        Matrix expectedInstance = (Matrix) firstInstance.transpose();

        for (int i = 0; i < expectedMatrix.length; i++) {
            for (int j = 0; j < expectedMatrix[0].length; j++) {
                Assertions.assertEquals(expectedMatrix[i][j] , expectedInstance.get(i,j));
            }
        }
    }



    @Test
    void determinant() {
    }

    @Test
    void isSquare() {
        double[][] matrix = {
                {69, 69, 69},
                {69, 69, 69},
                {69, 69, 69}};

        Matrix firstInstance = new Matrix(matrix);

        assertTrue(firstInstance.isSquare());
    }

    @Test
    void isDiagonal() {
        double[][] matrix = {
                {69, 0, 0},
                {0, 69, 0},
                {0, 0, 69}};

        Matrix firstInstance = new Matrix(matrix);

        assertTrue(firstInstance.isDiagonal());
    }

    @Test
    void getTrace() {
        double[][] matrix = {
                {10, 4, 2},
                {0, 10, 0},
                {0, 0, 10}};
        Matrix firstInstance = new Matrix(matrix);
        for (int i = 0; i < firstInstance.getRows(); i++) {
            for (int j = 0; j < firstInstance.getColumns(); j++) {
                Assertions.assertEquals(30.0, firstInstance.getTrace());
            }
        }
    }

    @Test
    void getRows() {
        double[][] matrix = {
                {69, 69, 69},
                {0, 0, 0},
                {0, 0, 0}};

        Matrix firstInstance = new Matrix(matrix);

        Assertions.assertEquals(3, firstInstance.getColumns());
    }

    @Test
    void getColumns() {
        double[][] matrix = {
                {69, 69, 69},
                {0, 0, 0},
                {0, 0, 0}};
        Matrix firstInstance = new Matrix(matrix);

        Assertions.assertEquals(3, firstInstance.getRows());
    }
}
package cz.educanet.matrices;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        double[][] data = new double[getRows()][matrix.getColumns()];

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                for (int k = 0; k < getColumns(); k++) {
                    data[i][j] += get(i, k) * matrix.get(k, j);
                }
            }
        }

        return new Matrix(data);
    }

    @Override
    public IMatrix times(Number scalar) {
        double[][] timedMatrix = rawArray;
        for (int i = 0; i < timedMatrix.length; i++) {
            for (int j = 0; j < timedMatrix[i].length; j++) {
                timedMatrix[i][j] *= (int) scalar;
            }
        }
        return new Matrix(timedMatrix);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        double[][] timedMatrix = rawArray;
        for (int i = 0; i < timedMatrix.length; i++) {
            for (int j = 0; j < timedMatrix[0].length; j++) {
                timedMatrix[i][j] += matrix.get(i, j);
            }
        }
        return new Matrix(timedMatrix);
    }

    @Override
    public IMatrix transpose() {
        double[][] inputMatrix = rawArray;
        double[][] tMatrix = new double[rawArray.length][rawArray[0].length];
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++) {
                tMatrix[i][j] = inputMatrix[j][i];
            }
        }
        return new Matrix(tMatrix);
    }

    /**
     * TODO: Implement
     */
    @Override
    public double determinant() {
        return 0;
    }

    @Override
    public boolean isSquare() {
        return rawArray.length == rawArray[0].length;
    }

    @Override
    public boolean isDiagonal() {
        if (!isSquare())
            throw new IllegalArgumentException();
        double[][] matrixDiagonal = new double[rawArray.length][rawArray[0].length];
        for (int i = 0; i < rawArray.length; i++)
            matrixDiagonal[i][i] = rawArray[i][i];
        return Arrays.deepEquals(matrixDiagonal, rawArray);
    }

    @Override
    public Number getTrace() {
        if (isSquare()) {
            double sum = 0;
            for (int i = 0; i < rawArray.length; i++) {
                sum += rawArray[i][i];
            }
            return sum;
        } else
            throw new RuntimeException();
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public double get(int n, int m) {
        if (n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}

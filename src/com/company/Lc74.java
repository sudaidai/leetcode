package com.company;

/*
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */

public class Lc74 implements Answer{
    @Override
    public int getIndex() {
        return 74;
    }

    @Override
    public String getRoute() {
        return "search-a-2d-matrix";
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                j--;
            } else if(matrix[i][j] < target) {
                i++;
            }
        }
        return false;
    }
}

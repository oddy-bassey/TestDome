package com.revoltcode.RoutePlanner;

/*
 * As a part of the route planner, the routeExists method is used as a quick filter if the destination is reachable,
 * before using more computationally intensive procedures for finding the optimal route.
 * The roads on the map are rasterized and produce a matrix of boolean values - true if the road is present
 * or false if it is not. The roads in the matrix are connected only if the road is immediately left, right, below or above it.

 * Finish the routeExists method so that it returns true if the destination is reachable or false if it is not.
 * The fromRow and fromColumn parameters are the starting row and column in the mapMatrix. The toRow and toColumn are
 * the destination row and column in the mapMatrix. The mapMatrix parameter is the above-mentioned matrix produced from the map.

 * For example, for the given rasterized map, the code below should return true since the destination is reachable:

 * A 3x3 table

 * boolean[][] mapMatrix = {
 *    {true,  false, false},
 *    {true,  true,  false},
 *    {false, true,  true}
 * };

 * routeExists(0, 0, 2, 2, mapMatrix);
 */

import java.util.HashSet;
import java.util.Set;

public class RoutePlannerMySolution {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {

        boolean rowInbounds = 0<=fromRow && fromRow< mapMatrix.length;
        boolean columnInbounds = 0<=fromColumn && fromColumn< mapMatrix[0].length;
        if(!rowInbounds || !columnInbounds || toRow<0 || toColumn<0) return false;

        if(!mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]) return false;

        if(fromRow==toRow && fromColumn==toColumn) return true;

        Set<String> visitedCells = new HashSet<>();

        for (int row = fromRow; row < mapMatrix.length; row++) {
            for (int column = fromColumn; column < mapMatrix[0].length; column++) {

                if (exploreGrid(row, column, toRow, toColumn, mapMatrix, visitedCells)) return true;
            }
        }

        return false;
    }

    public static boolean exploreGrid(int fromRow, int fromColumn, int toRow, int toColumn,
                             boolean[][] mapMatrix, Set<String> visitedCells) {

        boolean rowInbounds = 0<=fromRow && fromRow< mapMatrix.length;
        boolean columnInbounds = 0<=fromColumn && fromColumn< mapMatrix[0].length;
        if(!rowInbounds || !columnInbounds) return false;
        if(fromRow==toRow && fromColumn==toColumn) return true;

        if(!mapMatrix[fromRow][toColumn]) return false;

        String position = fromRow+","+fromColumn;
        if(visitedCells.contains(position)) return false;

        visitedCells.add(position);

        exploreGrid(fromRow-1, fromColumn, toRow, toColumn, mapMatrix, visitedCells); // go up
        exploreGrid(fromRow+1, fromColumn, toRow, toColumn, mapMatrix, visitedCells); // go down
        exploreGrid(fromRow, fromColumn-1, toRow, toColumn, mapMatrix, visitedCells); // go left
        exploreGrid(fromRow, fromColumn+1, toRow, toColumn, mapMatrix, visitedCells); // go right

        return false;
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
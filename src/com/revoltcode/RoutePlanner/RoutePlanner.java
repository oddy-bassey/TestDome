package com.revoltcode.RoutePlanner;

/*
 * As a part of the route planner, the routeExists method is used as a quick filter if the destination is reachable, before using more computationally intensive procedures for finding the optimal route.

 * The roads on the map are rasterized and produce a matrix of boolean values - true if the road is present or false if it is not. The roads in the matrix are connected only if the road is immediately left, right, below or above it.

 * Finish the routeExists method so that it returns true if the destination is reachable or false if it is not. The fromRow and fromColumn parameters are the starting row and column in the mapMatrix. The toRow and toColumn are the destination row and column in the mapMatrix. The mapMatrix parameter is the above mentioned matrix produced from the map.

 * For example, for the given rasterized map, the code below should return true since the destination is reachable:

 * A 3x3 table

 * boolean[][] mapMatrix = {
 *     {true,  false, false},
 *    {true,  true,  false},
 *    {false, true,  true}
 * };

 * routeExists(0, 0, 2, 2, mapMatrix);
 */

public class RoutePlanner {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {

        if(fromRow < 0 || fromColumn < 0 || toRow < 0 || toColumn < 0) {
            return false;
        }
        if(fromRow >= mapMatrix.length || fromColumn >= mapMatrix[0].length || toRow >= mapMatrix.length || toColumn >= mapMatrix[0].length) {
            return false;
        }
        if(!mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]) {
            return false;
        }
        //if (fromRow > mapMatrix.length-1 || fromColumn > mapMatrix[0].length-1) return false;

        System.out.println("at "+fromRow+","+fromColumn+" *****");
        // route exists if fromRow = toRow && fromColumn = toColumn
        if (fromRow==toRow && fromColumn==toColumn) {
            return true;
        }
        //if(toRow==0 || toColumn==0) return false;

        // go right or go down or go left or go up if path exists

        // going right: (y,x+1)
        if(fromRow >= 0 && fromColumn >= 0) {
            if ((fromRow <= mapMatrix.length - 1) && (fromColumn + 1) <= (mapMatrix[0].length - 1) && mapMatrix[fromRow][fromColumn + 1]) {
                return routeExists(fromRow, fromColumn + 1, toRow, toColumn, mapMatrix);
            }

            // going down: (y+1,x)
            if ((fromRow + 1) <= (mapMatrix.length - 1) && (fromColumn) <= (mapMatrix[0].length - 1) && mapMatrix[fromRow + 1][fromColumn]) {
                return routeExists(fromRow + 1, fromColumn, toRow, toColumn, mapMatrix);
            }

            // going left (y,x-1)
            if ((fromRow <= mapMatrix.length - 1) && (fromColumn - 1) >= 0 && mapMatrix[fromRow][fromColumn - 1]) {
                return routeExists(fromRow, fromColumn - 1, toRow, toColumn, mapMatrix);
            }

            // going up: (y-1,x)
            if ((fromRow - 1) >= 0 && (fromColumn) <= (mapMatrix[0].length - 1) && mapMatrix[fromRow - 1][fromColumn]) {
                return routeExists(fromRow - 1, fromColumn, toRow, toColumn, mapMatrix);
            }
        }

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
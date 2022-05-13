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
        throw new UnsupportedOperationException("Waiting to be implemented.");
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
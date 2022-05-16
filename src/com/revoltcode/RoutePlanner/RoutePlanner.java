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


import java.util.*;

public class RoutePlanner {

    private static Map<String, List<String>> graph;
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {

        boolean rowInbounds = 0<=fromRow && fromRow< mapMatrix.length;
        boolean columnInbounds = 0<=fromColumn && fromColumn< mapMatrix[0].length;
        if(!rowInbounds || !columnInbounds || toRow<0 || toColumn<0) return false;

        if(!mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]) return false;

        if(fromRow==toRow && fromColumn==toColumn) return true;

        buildGraph(mapMatrix);

        return DFS(fromRow+","+fromColumn, toRow+","+toColumn);
    }

    static void buildGraph(boolean[][] mapMatrix){
        graph = new HashMap<>();

        for (int row = 0; row < mapMatrix.length; row++) {
            for (int column = 0; column < mapMatrix[0].length; column++) {

                if(!mapMatrix[row][column]) continue;

                String currentPosition = row+","+column;
                if (row-1 >= 0) { // do up
                    if(mapMatrix[row-1][column]) addEdge(currentPosition, (row-1) +","+column);
                }
                if (row+1 < mapMatrix.length){ // go down
                    if(mapMatrix[row+1][column]) addEdge(currentPosition, (row+1) +","+column);
                }
                if (column+1 < mapMatrix[0].length){ // go right
                    if(mapMatrix[row][column+1]) addEdge(currentPosition, row+","+ (column+1));
                }
                if (column-1 >= 0){ // go left
                    if(mapMatrix[row][column-1]) addEdge(currentPosition, row+","+ (column-1));
                }
            }
        }
    }

    static void addEdge(String from, String to){
        if(!graph.containsKey(from)){
            graph.put(from, new ArrayList<>());
        }
        graph.get(from).add(to);
    }

    public static boolean DFS(String startPos, String endPos){

        Stack<String> stack = new Stack<>();
        Set<String> visitedNodes = new HashSet<>();

        stack.push(startPos);

        while(stack.size()>0){
            String currentNode = stack.pop();
            if(currentNode.equals(endPos)) return true;

            if(!graph.containsKey(currentNode)) {
                return false;
            }

            for (String neighbour : graph.get(currentNode)) {
                if(!visitedNodes.contains(neighbour)) {
                    stack.push(neighbour);
                    visitedNodes.add(neighbour);
                }
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
package com.revoltcode.SortedSearch;

/*
 * Implement function countNumbers that accepts a sorted array of unique integers and, efficiently with respect to time used,
 *  counts the number of array elements that are less than the parameter lessThan.
 * For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should
 * return 2 because there are two array elements less than 4.
 */
public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {

        if(sortedArray.length == 0) return 0;

        if(sortedArray[sortedArray.length-1] < lessThan) return sortedArray.length;

        if(sortedArray[0] >= lessThan) return 0;

        int elementsLessThanValue = 0;
        for (int i = 0; i < sortedArray.length-1; i++) {
            if(sortedArray[i]<lessThan) {
                elementsLessThanValue+=1;

                if (i+1<=sortedArray.length-1 && sortedArray[i+1]>=lessThan)
                    return elementsLessThanValue;
            }
        }
        return elementsLessThanValue;
    }

    // solution from geeks for code (NOTE: BS -> Binary Search)
    public static int countNumbersBS(int[] sortedArray, int lessThan) {
        int mid = 0, left = 0, right = sortedArray.length;

        while(left<right){
            mid = (right+left) >> 1;

            // check if the key is present in the array
            if(sortedArray[mid] == lessThan){
                // if duplicates are present it returns the position of the last element
                while(mid+1< sortedArray.length && sortedArray[mid+1]==lessThan) mid++;
                break;
            }

            // if the key is smaller, ignore right half
            else if(sortedArray[mid]>lessThan) right = mid;

            // if the key is greater, ignore left half
            else left = mid+1;
        }

        // if the key is not found in array then it will be before mid
        while (mid>-1 && sortedArray[mid]>lessThan) mid--;

        // return mid+1 because of 0-based indexing of array
        return mid+1;
    }

    public static int countNumbersBS2(int[] sortedArray, int lessThan) {
        int count = 0, left = 0, right = sortedArray.length-1;

        if(sortedArray.length == 0) return 0;

        if(sortedArray[sortedArray.length-1] < lessThan) return sortedArray.length;

        if(sortedArray[0] >= lessThan) return 0;

        while(left<right){
            int mid = (right+left) / 2;
            System.out.println(mid+" - "+lessThan);

            // check if the middle element is less than or equal to the key
            if(sortedArray[mid] <= lessThan){
                // at least (mid+1) elements are there whose values are less than or equal to key
                count = mid+1;
                left = mid+1;

                if(sortedArray[mid+1]>=lessThan) break;
            }
            // if the key is smaller, ignore the right half
            else right = mid - 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbersBS2(new int[] { 1, 3, 5, 7 }, 4));
    }
}
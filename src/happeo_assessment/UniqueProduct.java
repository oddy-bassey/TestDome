package happeo_assessment;

import java.util.HashMap;
import java.util.Map;

public class UniqueProduct {
    public static String firstUniqueProduct(String[] products) {
        Map<String, Integer> wordOccurrence = new HashMap<>();
        String answer = null;

        for (String product : products) {
            if(!wordOccurrence.containsKey(product)){
                wordOccurrence.put(product, 1);
            }else{
                wordOccurrence.put(product, wordOccurrence.get(product)+1);
            }
        }

        for (String product : products) {
            if(wordOccurrence.get(product)<2){
                answer  = product;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag"  }));
    }
}
import java.util.*;

public class App {


    public static void main(String[] args){


    int target = 16;
    int [] numbers = {7,6,4,-1,1,2};

    Set<int[]> result = new HashSet<>();
    Map<Integer, List<int[]>> sumPairsMap = new HashMap<>();

    for(int i = 0; i < numbers.length; i++){
        for(int j = i+1; j < numbers.length; j++){
            int tempSum = numbers[i] + numbers[j];
            int tempDifference = target - tempSum;
            if(sumPairsMap.containsKey(tempDifference)){

                for(int[] array : sumPairsMap.get(tempDifference)){
                    int[] sumCombination = new int[4];
                    sumCombination[0] = numbers[i];
                    sumCombination[1] = numbers[j];
                    sumCombination[2]=array[0];
                    sumCombination[3]=array[1];
                    result.add(sumCombination);
                }
            }else{
                List<int[]> sumPair = sumPairsMap.getOrDefault(tempSum, new ArrayList<>());
                sumPair.add(new int[]{ numbers[i], numbers[j] });
                sumPairsMap.put(tempSum, sumPair);
            }

        }
        System.out.println("Results:");
        for(int[] outIntArray: result){
            System.out.println("[0]:"+outIntArray[0]+
                    " [1]:"+outIntArray[1]+
                    " [2]:"+outIntArray[2]+
                    " [3]:"+outIntArray[3]);
        }

    }
    }
}

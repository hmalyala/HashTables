import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class MultiHashTable{

    List<Integer> flowIds;  // Total number of flow entries
    List<Integer> randomList;  // Random list to implement hash function

    public MultiHashTable(){
        flowIds = new ArrayList<>();
        randomList = new ArrayList<>();

        for(int i = 1 ; i < 1001; i++){
            flowIds.add(i);
            randomList.add(i);
        }
    }
    public static void main(String[] args) {
        MultiHashTable mht = new MultiHashTable();
        mht.multiHashFunction();
    }

    public void multiHashFunction(){
        int hashTable[] = new int[1000];   // Multi-hash table

        for(int i = 0; i < 1000; i++){
            Collections.shuffle(randomList);
            for(int j = 0 ; j < 3; j++){
                int index = randomList.get(j);
                if(hashTable[index-1] == 0){
                    hashTable[index-1] = i+1;
                    break;
                }
            }
        }

        for(int i : hashTable){
            System.out.print(i+",");
        }
    }
    
}
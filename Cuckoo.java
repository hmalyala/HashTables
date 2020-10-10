import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Cuckoo {

    Map<Integer, int[]> flow_hash;  // Map to store each flow-entry with their corresponding hashes
    List<Integer> randomList;  // List to implement hash function
    int new_index = -1;

    public Cuckoo(){
        flow_hash = new HashMap<>();
        randomList = new ArrayList<>();

        for(int i = 0 ; i < 1000; i++){
            randomList.add(i);
        }
    }
    public static void main(String[] args) {
        Cuckoo ck = new Cuckoo();
        ck.multiHashFunction();
    }

    public void multiHashFunction(){
        int hashTable[] = new int[1000];  // Cuckoo hash-table
        int count = 0;

        // flow ids starting from 1 to 1000
        for(int i = 1; i < 1001; i++){
            Collections.shuffle(randomList);
            int hashes[] = new int[3];
            boolean flag = true;
            for(int j = 0 ; j < 3; j++){
                int index = randomList.get(j);
                hashes[j] = index;
                if(hashTable[index] == 0 && flag){
                    hashTable[index] = i;
                    flag = false;
                    count++;
                }
            }
            flow_hash.put(i,hashes);
            if(flag){
                if(cuckoo_steps(hashes,hashTable,0,0)){
                    for(int z : hashes){
                        if(hashTable[z] == 0){
                            hashTable[z] = i;
                            count++;
                            break; 
                        }
                    }
                }
            }
        }

        System.out.println("No. of flows in the Cuckoo hash table - "+count);
        for(int i : hashTable){
            System.out.print(i+",");
        }

    }

    public boolean cuckoo_steps(int[] hashes, int[] hashTable, int val, int steps){

        // Number of cuckoo steps - 3 in this case
        if(steps == 2){
            return false;
        }

        int step_two[] = new int[3];
        int ind = 0;
        
        for(int i : hashes){
            int f_id = hashTable[i];
            int arr[] = flow_hash.get(f_id);
            step_two[ind++] = f_id;
            for(int j: arr){
                if(hashTable[j] == 0){
                    hashTable[j] = f_id;
                    hashTable[i] = val;
                    new_index = i;
                    return true;
                }                
            }
        }
        for(int i : step_two){
            if(cuckoo_steps(flow_hash.get(i),hashTable,i,steps+1)){
                for(int j = 0 ; j < 1001; j++){
                    if(j != new_index && hashTable[j] == hashTable[new_index]){
                        hashTable[j] = 0;
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
}
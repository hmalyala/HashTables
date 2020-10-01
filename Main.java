import java.util.*;
class Metadata{
    List<Integer> flowIds;
    List<Integer> randomList;
    Set<Integer> hashSet;
    public Metadata(){
        flowIds = new ArrayList<>();
        randomList = new ArrayList<>();
        hashSet = new HashSet<>();
        for(int i = 0 ; i < 1000; i++){
            flowIds.add(i);
            randomList.add(i);
        }
    }
    public static void main(String[] args) {
        Metadata m = new Metadata();
        m.multiHashFunction();
    }

    public void multiHashFunction(){
        int hashTable[] = new int[1000];

        for(int i = 0; i < 1000; i++){
            Collections.shuffle(randomList);
            for(int j = 0 ; j < 3; j++){
                int index = randomList.get(j);
                if(hashTable[index] == 0){
                    hashTable[index] = i+1;
                    break;
                }
            }
        }

        for(int i : hashTable){
            System.out.print(i+",");
        }
    }
    
}
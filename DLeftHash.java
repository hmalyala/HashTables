import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class DLeftHash{

    int segments[][];
    List<Integer> hashes;

    public DLeftHash(){
        segments = new int[4][250];  // 4 segment hashtable with 250 entries in each
        hashes = new ArrayList<>();

        for(int i = 0 ; i < 250; i++){
            hashes.add(i);
        }
    } 
    

    public static void main(String args[]){

        DLeftHash dlh = new DLeftHash();

        dlh.hashing();

    }

    public void hashing(){

        int count = 0;

        // flow ids starting from 1 to 1000
        for(int i = 1 ; i < 1001; i++){

            Collections.shuffle(hashes);
            int index = hashes.get(0);
            
            for(int j = 0; j < 4; j++){                
                
                if(segments[j][index] == 0){
                    segments[j][index] = i;
                    count++;
                    break;
                }
            }
        }

        System.out.println("No. of flows in the D-left hash table - "+count);

        for(int i = 0 ; i < 4; i++){
            System.out.println("Segment - "+(i+1));   
            for(int j = 0 ; j < 250; j++){
                System.out.print(segments[i][j]+",");
            }
            System.out.println();
        }
    }

}
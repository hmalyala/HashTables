import java.util.List;

import javax.swing.text.Segment;

import java.util.ArrayList;
import java.util.Collections;

class DLeftHash{

    int segments[][];
    List<Integer> hashes;

    public DLeftHash(){
        segments = new int[4][250];
        hashes = new ArrayList<>();

        for(int i = 0 ; i < 250; i++){
            hashes.add(i);
        }
    } 
    

    public static void main(String args[]){

        DLeftHash dlh = new DLeftHash();

        dlh.hashing();

        for(int i = 0 ; i < 4; i++){
            for(int j = 0 ; j < 250; j++){
                System.out.print(dlh.segments[i][j]+",");
            }
            System.out.println();
        }
    }

    public void hashing(){

        for(int i = 1 ; i < 1001; i++){

            Collections.shuffle(hashes);

            for(int j = 0; j < 4; j++){                
                int index = hashes.get(0);
                if(segments[j][index] == 0){
                    segments[j][index] = i;
                    break;
                }
            }
        }
    }

}
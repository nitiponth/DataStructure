import java.util.Random;

public class Utils {
    public void shuffle(int[] d) {
        int[] temp = d.clone();
        int newIndex;
        for(int i=0;i<d.length;i++){
            d[i] = -1;
        }
        for(int i=0;i<d.length;i++){
            do {
                newIndex = (int)(Math.random() * d.length);
            }
            while(d[newIndex] != -1);
            d[newIndex] = temp[i];
        }
    }
}

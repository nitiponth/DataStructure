//Create by Nitipon Thoophom 6203051613034 EnET

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

    public void remove(int[] d,int i){
        for(int j=i;j<d.length-1;j++)
            d[j] = d[j+1];
        d[d.length-1] = 0;
    }

    public void insert(int[] d,int i,int x){
        for(int j=d.length-1;j>i;j--)
            d[j] = d[j-1];
        d[i] = x;
    }

    public boolean isLowerTriangular(double[][] d){
        for(int i=0;i<d.length;i++){
            for(int j=i+1;j<d[0].length;j++){
                if(d[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public int[] maxmin(int[] d){
        int max=d[0], min=d[0];
        for(int i=1;i<d.length;i++){
            if(d[i] > max)
                max = d[i];
            if(d[i] < min)
                min = d[i];
        }
        int[] ret = {max,min};

        return ret;
    }
}

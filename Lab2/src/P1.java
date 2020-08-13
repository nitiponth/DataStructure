//Lab2 Assignment
//Nitipon Thoophom 6203051613034 EnET

public class P1 {
    public int sumOfColumn(int[][] d,int col){
        if(col > (d[0].length - 1) || col < 0)
            return -1;
        int sum = 0;
        for (int i=0;i<d.length;i++)
            sum += d[i][col];
        return sum;
    }

    public int rowOfMax(int[][] d){
        int maxIndex = -1;
        int maxValue = d[0][0];
        for(int i=0;i<d.length;i++){
            for(int j=0;j<d[0].length;j++){
                if(maxValue < d[i][j]){
                    maxValue = d[i][j];
                    maxIndex = i;
                }

            }
        }

        return maxIndex;
    }
}

package Search;

import java.util.List;
import java.util.ArrayList;

public class LCS
{
    public static int[] FindLCS(int[] a, int[] b)
    {
        List<Integer> lcs = new ArrayList<Integer>();
        int an = a.length;
        int bn = b.length;

        int[][] ab = new int[an+1][bn+1];
        int[][] r = new int[an][bn];

        for(int i = 0; i < an; i++)
        {
            for(int j = 0; j < bn; j++)
            {
                if(a[i] == b[j])
                {
                    ab[i+1][j+1] = ab[i][j]+1;
                }
                else if(ab[i][j+1] >= ab[i+1][j])
                {
                    ab[i+1][j+1] = ab[i][j+1];
                    r[i][j] = 1;
                }
                else
                {
                    ab[i+1][j+1] = ab[i+1][j];
                    r[i][j] = -1;
                }
            }
        }

        GetLCS(r,a, an-1, bn-1, lcs);

        int l = lcs.size();
        int[] result = new int[l]; 
        int index = l -1;
        for (int i : lcs) {
            result[index--] = i;
        }

        return result;

    }


    public static void GetLCS(int[][] m, int[] a, int i, int j, List<Integer> lcs)
    {
        if(i < 0 || j < 0)
        {
            return;
        }

        if(m[i][j] == 0)
        {
            lcs.add(a[i]);
            GetLCS(m, a, i-1, j-1, lcs);
        }
        else if(m[i][j] < 0)
        {
            GetLCS(m, a, i, j-1, lcs);
        }
        else
        {
            GetLCS(m, a, i-1, j, lcs);
        }

    }

}
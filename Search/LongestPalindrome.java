package Search;

public class LongestPalindrome {
    public static String search(String s)
    {
        int sl = s.length();
        char[] ca = s.toCharArray();
        int ps = 0;
        int max = 0;

        for(int i = 0; i < sl-1; i++)
        {
            int pl = 0;
            int fi = i;
            int bi = sl-1;

            while (bi >= fi) 
            {
                if(ca[fi]==ca[bi])
                {
                    pl += bi == fi ? 1 : 2;
                    if(bi-fi <= 1 && pl > max)
                    {
                        max = pl;
                        ps = i;
                    }
                    fi++;
                    bi--;
                }
                else
                {
                    fi = i;
                    bi--;
                    pl = 0;
                }                
            }
        }

        return s.substring(ps, ps+max);
    }
}

import java.util.Arrays;

public class Program {

    static int[] sort(int[] args){
        int argsLength = args.length;
        if(argsLength==1)
            return args;

        int midPoint = argsLength/2;

        int[] left = Arrays.copyOfRange(args,0,midPoint);
        int[] right = Arrays.copyOfRange(args,midPoint,argsLength);

        return merge(sort(left),sort(right));

    }

    static int[] merge(int[] a,int[] b){
        final int[] ac = new int[a.length + b.length];
        int cnt=0;
        int acnt=0;
        int bcnt=0;


        while(cnt<ac.length){
            if(bcnt==b.length) {
                ac[cnt] = a[acnt];
                acnt++;
            }
            else if(acnt==a.length) {
                ac[cnt] = b[bcnt];
                bcnt++;
            }
                else if (a[acnt] > b[bcnt]) {
                    ac[cnt] = b[bcnt];
                    bcnt++;
                } else {
                    ac[cnt] = a[acnt];
                    acnt++;
                }
            cnt++;
        }
        return ac;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{23,45,12,2,6,99})));
    }
}

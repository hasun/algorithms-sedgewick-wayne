import java.util.Arrays;

public class Test2 {


    public static void main (String [] args) {

        //int [] v = {10,4,20,1,15,8};
        int [] v = {20,8,10,1,4,15};

        Arrays.sort(v);
        for ( int one :v) {
            System.out.println(one);
        }
        int count = 0 ;
        boolean isContain = false;
        int sum = 0;


        int divLen  = v.length / 2;
        int [] modV =  new int [v.length];

        int num = 0;
        for ( int idx = 0 ; idx < divLen ; idx++) {
            System.out.println ("idx : "+ idx +" :: "+ (v.length-idx-1));
//            sum+=Math.abs( v[idx] - v[v.length-idx-1]);
            modV[num] = v[v.length-idx-1];
            num++;
            modV[num] = v[idx];
            num++;

        }

        System.out.println ("===========");
        for ( int idx = 0 ; idx < v.length-1 ; idx++) {
            System.out.println (modV[idx]);
            sum+=Math.abs( modV[idx] - modV[idx+1]);
        }

        System.out.println(sum);

//        System.out.println (count);
    }
}

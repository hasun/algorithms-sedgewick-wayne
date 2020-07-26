public class Test {


    public static void main (String [] args) {

        int [][] location = {{0, 3}, {1, 1}, {1, 5}, {2, 2}, {3, 3}, {4, 0}};

        int [] s =  {1,4};
        int [] e =  {4,1};

        int xStart = 0;
        int xEnd = 0;
        int yStart = 0;
        int yEnd =0;

        if (s[0] <= e[0]) {
            xStart =  s[0];
            xEnd = e[0];
        } else {
            xStart =  e[0];
            xEnd = s[0];
        }

        if (s[1] <= e[1]) {
            yStart =  s[1];
            yEnd = e[0];
        } else {
            yStart =  e[1];
            yEnd = s[1];
        }

        int count = 0 ;
        boolean isContain = false;
        for(int xIndex = xStart ; xIndex <= xEnd ; xIndex++){
            for(int yIndex = yStart ; yIndex < yEnd ; yIndex++){
                System.out.println ( "::::::   "+xIndex + " :: ::  "+ yIndex);
                for ( int [] one :  location ) {
                    if (one [0] == xIndex && one[1] == yIndex ) {
                        System.out.println ("eqals :: "+xIndex + " :: ::  "+ yIndex);
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println (count);
    }
}

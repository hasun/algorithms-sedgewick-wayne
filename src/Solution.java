import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;

class Solution {
    public String solution(String[] participant, String[] completion) {

//        Hashtable<Integer , String > participantT =  new Hashtable<>();
//        Hashtable<Integer , String > completionT =  new Hashtable<>();
//        int index = 0 ;
//        for (String name : participant) {
//            participantT.put(name.hashCode(), name);
//        }
//
//        for (String name : completion) {
//            completionT.put(name.hashCode(), name);
//        }

        HashSet<String> participantKeys = new HashSet<String>(Arrays.asList(participant));
        HashSet<String> completionT = new HashSet<String>(Arrays.asList(completion));
        participantKeys.removeAll(completionT);

        System.out.println(participantKeys);

        String answer = String.join(" , " , participantKeys);
        System.out.println (answer);
        return answer;
    }


    private static SecureRandom random = new SecureRandom();
    /** 랜덤 문자열을 생성한다 **/
    public static String generate(String DATA, int length) {
        if (length < 1) throw new IllegalArgumentException("length must be a positive number.");
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append( DATA.charAt(
                    random.nextInt(DATA.length())
            ));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String ENGLISH_LOWER = "abcdefghijklmnopqrstuvwxyz";

        /** 랜덤을 생성할 대상 문자열 **/
        String DATA_FOR_RANDOM_STRING = ENGLISH_LOWER;

        /** 랜덤 문자열 길이 **/
        Random rand = new Random();
        int random_string_length=rand.nextInt(19) +1;
        int participantNum =  1000;

        String participant [] = new String [participantNum];
        String completion [] = new String [participantNum-1];

        for (int i = 0;  i < participantNum; i++) {
            System.out.println("random " + i + " : " + generate(DATA_FOR_RANDOM_STRING, random_string_length));
            participant[i] =  generate(DATA_FOR_RANDOM_STRING, random_string_length);
        }

        completion = Arrays.copyOf(participant, participantNum-1);

        Solution sol = new Solution();
        sol.solution (participant ,completion );

    }



}

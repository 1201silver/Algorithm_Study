package programmers.Kit.Hash;

import java.util.HashMap;

class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        for(String num : phone_book) {
            map.put(num, 1);
        }

        for(int i = 0; i < phone_book.length; i++) {
            String num = phone_book[i];
            for(int j = 0; j < num.length(); j++) {
                if(map.containsKey(num.substring(0, j))) {
                    // System.out.println(num);
                    answer = false;
                }
            }
        }
        return answer;
    }
}

/* re. startsWith() */

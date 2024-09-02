package programmers.Kit.Hash;

import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> pocket = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!pocket.containsKey(nums[i])) {
                pocket.put(nums[i], 1);
            }
        }

        if(nums.length / 2 < pocket.size()) {
            return nums.length / 2;
        } else {
            return pocket.size();
        }
    }
}

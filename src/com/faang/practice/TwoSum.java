package com.faang.practice;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        if((nums.length >= 2 && nums.length <=10000) && (target >= -1000000000 && target <= 1000000000) ){
            for(int i=0 ;i<=nums.length -1 ;i++){
                for(int j=i+1 ;j<nums.length;j++){
                    if(i!= j && (nums[i] + nums[j]) == target){
                        result[0]= i;
                        result[1]=j;
                    }
                }
            }
            
        }
        return result;
    }
    
    public static int[] twoSumUsingMap(int[] nums, int target) {
    	
        int[] result= new int[2];
        if((nums.length >= 2 && nums.length <=10000) && (target >= -1000000000 && target <= 1000000000) ){
            
            Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        	for(int i=0; i<nums.length ;i++) {
        		
        		if(hm.containsKey(target - nums[i])) {
        			result[1] = i;
        			result[0] = hm.get(target - nums[i]);
        		}
        		hm.put(nums[i],i);
        		
        	}
            
        }
        return result;
    }
    
    
    
    public static void main(String[] args) {
    	int[] nums = {2,7,11,15,7,8,0,0,3,2,3,5};
    	int  target = 9;
    	long duration,duration1;
    	Calendar calendars = Calendar.getInstance();
    	Date startDate = calendars.getTime();
    	
    	int res[] = twoSum(nums,target);
    	Calendar calendare = Calendar.getInstance();

    	// Get start time (this needs to be a global variable).
    	Date endDate = calendare.getTime();    	
    	duration = startDate.getTime() - endDate.getTime();

    	System.out.println("duration " + duration + Arrays.toString(res));

    	
    	
    	// hashmap 
    	Calendar calendars1 = Calendar.getInstance();
    	Date startDate1 = calendars1.getTime();
    	
    	int res1[] = twoSumUsingMap(nums,target);
    	
    	Calendar calendare1 = Calendar.getInstance();

    	// Get start time (this needs to be a global variable).
    	Date endDate1 = calendare1.getTime();    	
    	duration1 = startDate1.getTime() - endDate1.getTime();
    	System.out.println("duration " + duration1 + Arrays.toString(res1));
    	
    	

		
	}
}

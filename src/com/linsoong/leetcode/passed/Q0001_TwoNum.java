package com.linsoong.leetcode.passed;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class Q0001_TwoNum {

	public static void main(String[] args) {
		int[] nums = new int[] {2,7,11,15};

	}
	
	public int[] twoSum(int[] nums, int target) {
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		
        throw new IllegalArgumentException("no solution.");
    }
	
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			numsMap.put(nums[i], i);
		}
		
		for(int i=0; i<nums.length; i++) {
			if(numsMap.containsKey(target-nums[i]) && numsMap.get(target-nums[i]) != i) {
				return new int[] {i, numsMap.get(target-nums[i])};
			}
		}
		
        throw new IllegalArgumentException("no solution.");
    }
	
	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++) {
			if(numsMap.containsKey(target-nums[i]) && numsMap.get(target-nums[i]) != i) {
				return new int[] {i, numsMap.get(target-nums[i])};
			}
			numsMap.put(nums[i], i);
		}
		
        throw new IllegalArgumentException("no solution.");
    }

}

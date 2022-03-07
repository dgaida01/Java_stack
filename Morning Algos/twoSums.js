// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.
// Constraints:
// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.

// Example:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].


function twoSums(nums,target){
let result = new Array(2);


for(let i=0; i<nums.length; i++){
    for(let j=i+1; j<nums.length; j++){
        if(nums[i]+nums[j]==target){
            
            result[0]=i;
            result[1]=j;
            return result;
        }

    }

}
    return null;

}

let nums = [2,11,7,11,15];
let target = 9;

console.log(twoSums(nums,target));

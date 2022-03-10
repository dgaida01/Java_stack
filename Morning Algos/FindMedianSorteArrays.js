
/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/


findMedianSortedArrays = function(nums1, nums2) {
    let point1 = 0;
    let point2 = 0;
    let mergArray = [];
  

    while(point1<nums1.length || point2 < nums2.length){


        if(nums1[point1]<nums2[point2] || nums2[point2] === undefined){
                        
            mergArray.push(nums1[point1]);
            point1++;
        }
        else{
            mergArray.push(nums2[point2]);
            point2++;
        }
    }    
    let selector = mergArray.length/2 -1;

    if(selector == Math.floor(selector)){
        return (mergArray[selector ]+ mergArray[selector +1])/2;
        
    }else{
        return mergArray[selector +.5];
    }
}

console.log(findMedianSortedArrays([2,2],[4,4]));
// console.log(findMedianSortedArrays([2],[1,3]));
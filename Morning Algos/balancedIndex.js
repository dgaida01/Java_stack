function balanceIndex(arr){
    let sum = 0;
    let sumLeft = arr[0];
    let sumRight = arr[1];

    for (let i =0; i < arr.length; i++) {
        sum += arr[i]

    }
    // sumRight is sum total minus sumleft minus index
    sumRight = sum - sumLeft - arr[1];

    for (let j=1; j < arr.length -1; j++) {
        // console.log(sumLeft, sumRight )
        if (sumLeft === sumRight){
        
            return j
        } else {
            sumLeft += arr[j];
            sumRight = sum - sumLeft - arr[j+1];

        }
    }
    return -1;
    // console.log(sum)
}


console.log(balanceIndex([1,2,4,9,20])) //-1 (means that there is no index where a balance occurs)
console.log(balanceIndex([4,1,2,4,9,-20,18])) //3 (means that there is a balance at index 3 occurs)
console.log(balanceIndex([-2,5,7,0,3])) // 2



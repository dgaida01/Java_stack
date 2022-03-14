/*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go 
outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).*/

function reverseInt(num){
    let stNum = num.toString()
    let stResult="";
    let result=0;
    let isNegative = false;

    if(num<0){
        isNegative = true;
        stNum = Math.abs(num).toString();
    }

    for(let i=stNum.length - 1; i>=0;i--){
        stResult += stNum.charAt(i);
    }

    try{
        result = parseInt(stResult) ;
    }
    catch{
        return 0; 
    }
    
    if(isNegative){
        result=result*-1;
        if(result < -1*(2**31)){
            return 0
        }
    }else if(result > ((2**31)-1)){
        return 0;
    }

    return result;
}

console.log(reverseInt(95754)); 
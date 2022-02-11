
function genPascal(num){
    result =[[1]];
    if (num ==1){
        return result;
    }
    else if (num ==2){
        result.push([1,1]);
        return result;
    }

    result.push([1,1]);
   
    let x = 2;
    while(x<num){

        let arr1 = [1]
        for(i=0;i<x-1;i++){
            
            arr1.push(result[x-1][i]+result[x-1][i+1]);

        }
        arr1.push(1);

        result.push(arr1);
    
    x++;
    }

    return result
}

console.log(genPascal(5)); 
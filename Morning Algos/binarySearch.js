

function binarySearch(arr,value,strpt=0,endpt=arr.length-1){

    

    if(strpt>=endpt){
        if(value==arr[strpt]){
            return true;
        }else{
            return false;
        }
    }

    let valCheckPt= Math.floor((endpt + strpt)/2);
    
    
    if(arr[valCheckPt]==value){
        return true;
    }
    else if(arr[valCheckPt]>value){
        return binarySearch(arr,value,strpt,valCheckPt-1);
    }else{
        return binarySearch(arr,value,valCheckPt+1,endpt);
    }

}

let x = [2,4,5,7,8,12,22,24,27,45,55,56,58,66,67,68,90,100];

console.log(binarySearch(x, 68)); //true
console.log(binarySearch(x, 51)); //false
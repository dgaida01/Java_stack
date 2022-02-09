

//given an array, remove duplicate values from it. Do it in place (do not create a new array to do this with). If you're having difficulty, its okay to try an baby step it first by using a new array and making it work that way.


function removeDupes(arr){
    let dupObj = {[arr[0]]:true};

    for(let i=1; i<arr.length; i++){
     
        if(dupObj[arr[i]]){
            arr.splice(i,1);
            i--;
           
        }
        else{
            dupObj[arr[i]] = true;
        }
    }

}

let myArray = [3,6,7,3,2,7,7,9,0,1]

removeDupes(myArray);
console.log(myArray); //output-> [3,6,7,2,9,0,1]
//Given a string s, find the length of the longest substring without repeating characters.

function lengthOfLongestSubstring(s){

    let obj = {};
    let len = 0;
    let maxLen = 0;
    let roundLocation =0;
    for(let i=0 ; i<s.length;i++){

        if(obj[s.charAt(i)]===undefined){
            obj[s.charAt(i)] = 1;
            len++;
            if(maxLen<len){
                maxLen++;
            }
        }
        else{
            obj={}; 
            i=roundLocation;
            roundLocation+=1;
            len=0;
        }
    }

    return maxLen;
}

console.log(lengthOfLongestSubstring("dvdf"));

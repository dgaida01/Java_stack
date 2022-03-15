


let longestPalindrome = function(s){

    let ptLeft = 0; 
    let ptRight = 1; 
    let counter=0;
    let sizeCheck = 0; 
    let finalStart=null;
    let finalEnd=null;

    for(let i=0 ; i<s.length; i++){

        if(s.charAt(i+1)==s.charAt(i-1)){
            counter = 3; 
            if(counter>sizeCheck){
                sizeCheck=counter;
                finalStart=i-1;
                finalEnd = i+1;
            }
            ptRight= i+2;
            ptLeft = i-2;
        }

        else if(s.charAt(i)==s.charAt(i+1)){
            ptRight= i+1;
            ptLeft=i;
            counter=1;
            while(s.charAt(ptLeft)==s.charAt(ptRight)){
                counter++; 
                ptRight++;                
            }
            if(s.charAt(ptLeft-1)== s.charAt(ptRight) && ptRight<s.length && ptLeft>0){
                ptLeft=ptLeft-1;
                i=ptRight-1;
            }else if (counter>sizeCheck){
                sizeCheck=counter;
                finalStart=ptLeft;
                finalEnd=ptRight-1;
                i=ptRight-1;
            }
        }

        while(s.charAt(ptLeft)==s.charAt(ptRight) && ptRight<s.length && ptLeft>=0){
            console.log("getting Loopy", ptLeft, ptRight);
            console.log("left: "+s.charAt(ptLeft)+" Right:" +s.charAt(ptRight))
            counter +=2
            if(counter>sizeCheck){
                sizeCheck=counter;
                finalStart=ptLeft;
                finalEnd = ptRight;
            }
            ptLeft--;
            ptRight++;
        }

        
        console.log(sizeCheck);
    }
    return s.substring(finalStart, finalEnd +1)

}

 console.log( longestPalindrome("iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz"));
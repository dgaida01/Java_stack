class Node{

    constructor (value){
    this.value = value; 
    this.left = null;
    this.right = null; 
    }
   

}

class BST{

    constructor(){
        this.root = null;
    }


    insert(valueInput){

        let nToAdd = new Node(valueInput);

        if(this.root==null){
            this.root=nToAdd;
            return this;
        }
        else{

            let searchToken = this.root;

            while(searchToken !=null){

                if(searchToken.value>=nToAdd.value){
                    if(searchToken.left==null){
                        searchToken.left=nToAdd;
                        return this ;
                    }
                    else{
                        searchToken = searchToken.left;
                    }
                }
                else {
                    if(searchToken.right ==null){
                        searchToken.right=nToAdd;
                        return this;
                    }
                    else{
                        searchToken=searchToken.right;
                    }
                
                }
            }
        }
    }

    contains(inputValue){   
        let found = false;
        let seeker= this.root;

        while(seeker!=null){
            if(seeker.value == inputValue){
                found=true;
                return found;
            }
            else if( seeker.value>inputValue){
                seeker = seeker.left;

            }
            else{
                seeker=seeker.right;
            }
        }
        
        return found;

    }

    findMin(){

        if(this.root==null){
            return"tree is empty";
        }
        let result = this.root;

        while (result.left !=null){
            result=result.left;
        }
        return result.value;
    }

    findMax(){
        if(this.root==null){
            return"tree is empty";
        }
        let result = this.root;

        while (result.right !=null){
            result=result.right;
        }
        return result.value;
    }

    display(tracer = this.root){

        if(tracer==null){
            return
        }
        console.log(tracer.value);
        this.display(tracer.left);
        this.display(tracer.right);
        
       
    }

    treeDepth(node=this.root){
        let leftCount=0;
        let rightCount=0; 
        if(node==null){
            return 0 ;
        }

        leftCount= 1 + this.treeDepth(node.left);
        rightCount = 1 + this.treeDepth(node.right);

        if(leftCount>rightCount){
            return leftCount;
        }
        else{
            return rightCount;
        }

    }


}

myTree = new BST();
myTree.insert(100).insert(20).insert(120).insert(110).insert(106).insert(50);

console.log(myTree.contains(100));
console.log(myTree);

console.log(myTree.treeDepth());
// myTree.display();
// console.log("Showing Min Value");
// console.log( myTree.findMin());
// console.log("Showing Max Value");
// console.log( myTree.findMax());
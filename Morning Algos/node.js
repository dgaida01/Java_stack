class Node {
    constructor(valueInput){
        this.value = valueInput;
        this.next = null
    }
}


class SLL {
    constructor(){
        this.head = null;
    }

    reverse(nodeA=this.head,nodeB=null){
        if(nodeA==null){
            return;
        }
        if(nodeA.next==null){
            this.head=nodeA;
            nodeA.next=nodeB;
            return;
        }
        this.reverse(nodeA.next,nodeA);

        nodeA.next=nodeB;
        return;       
    }

    addToBack(valueInput){
        //create a node object with a given value to add to the back of the list eventually 
        let newNode = new Node(valueInput)
        //if the singly linked list is empty (this mean that its head === null), then set the head of the singly linked list to be this new node
        if(this.head == null){
            this.head = newNode;
        }
        //otherwise (else) go to the end of the list and insert the node to the end
        else{ //else means that the list is not empty
            // console.log("this.head looks like this-->", this.head)
            let runner = this.head; //create runner variable to start at the beginning of the list (the head)
            
            //increment runner while runner.next != null (as long as the runner.next does not equal to null, that meanns runner is not at the last node)
            while(runner.next != null){ //in other words (while runner is not the last node)
                runner = runner.next //this moves runner to the next node
            }

            //by the time while loop is done, we will have runner pointing to the last node
            runner.next = newNode;

        }
        return this
    }

    display(){
        let result = "";

        //use runner to traverse the SLL
        let runner = this.head;
        while(runner != null){ //while runner is pointing at a node
            result += `${runner.value} -->`
            runner = runner.next //this is how you increment runner to go to the next node
        }

        console.log(result)
    }


    addtoFront(valueInput){
        let newNode = new Node(valueInput)
        if(this.head == null){
            this.head = newNode;
        }
        else{
            newNode.next=this.head;
            this.head = newNode;
        }
        return this;
    }

    removeFront(){
        if(this.head==null){
            console.log("List was empty");
            
            
        }
        else if(this.head.next ==null){

            this.head = null;
            console.log("List is now empty");
            
        }
        else {
            this.head = this.head.next;
            this.display();        
        }
        return this
    }

    removeBack(){
        let runner = this.head;

        if(this.head == null){
            console.log("nothing to remove");
           
        }
        else if( this.head.next== null){
            this.head = null
            console.log("This is now an empty list");
        }
        else{
            let runner = this.head
            while(runner.next.next!=null){
                runner = runner.next;
            }
            runner.next = null; 
            this.display();
        }

     return this; 
    }



}


singList = new SLL();
singList.addToBack(3).addToBack(12).addToBack(15).addToBack(9).addToBack(20);
singList.display();
singList.reverse();
singList.display();


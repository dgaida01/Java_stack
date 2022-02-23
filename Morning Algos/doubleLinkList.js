class Node {
    constructor(valueInput){
        this.value = valueInput;
        this.next = null;
        this.prev = null;
    }
}

class DLL{
    

    constructor(){
        this.head=null;
        this.tail=null;
    }

    addToBack(valueInput){
        //create a node object with a given value to add to the back of the list eventually 
        let newNode = new Node(valueInput)
        //if the singly linked list is empty (this mean that its head === null), then set the head of the singly linked list to be this new node
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
      
        this.tail.next = newNode;
        newNode.prev=this.tail;
        this.tail=newNode; 
        }
                        
        return this;
    }
        display(){
            let runner = this.head;
            let result ="Node Contains: ";
            while(runner!=null){
                result += "->"+runner.value;
                runner  = runner.next;
            }
            console.log(result);
        }

        addToFront(valueInput){

            let newNode = new Node(valueInput);
            if(this.head == null){
                this.head = newNode;
                this.tail = newNode;
            }
            else{
                newNode.next=this.head;
                this.head.prev=newNode;
                this.head = newNode;
            }

            return this;

        }

        removeFromBack(){
            if(this.tail==null){
                return this;
            }
            if(this.head==this.tail){
                this.head=null;
                this.tail=null;
                return this;
            }
            else{
                let newBack = this.tail.prev;
                // this.tail=null;
                this.tail=newBack;
                this.tail.next=null;
            }
            return this;

        }

        removeFromFront(){

            if(this.head==null){
                return this;
            }
            if(this.head==this.tail){
                this.head=null;
                this.tail=null;
                return this;
            }
            else{
                let newHead = this.head.next;
                // this.head=null;
                this.head=newHead;
                this.head.prev=null;
            }
            return this;
        }


        reverse(){
            //check if the head and the tail are the same, if so, we can return b/c you cnat reverse if there is only one or no things
            if(this.head==this.tail){
                return this;
            }

            //create a temp variable to point to the node next to the head
            let temp = this.head.next;

            //create a runner variable and set it to be the head
            let runner = this.head;
            
            //while runner is pointing to a node
            while(runner!=null){
                //set the current node (runner)'s next property to be its previous property
                runner.next = runner.prev;

                //set the runners prev property to be the temp variable
                runner.prev = temp;

                //if the temp is null, then set runner = temp and temp = the next node from runner
                if(temp!=null){
                runner = temp;
                temp = runner.next;
                }
                //otherwise if temp is null, set runner = temp
                else{
                    runner=temp;
                }
            }
            //outside the while loop, set temp to be the head
            temp = this.head;

            //set the head to be the tail
            this.head=this.tail;

            //set the tail to be temp
            this.tail = temp;
        }
}

mylist = new DLL();

mylist.addToBack(10).addToBack(20).addToBack(30).addToBack(40).addToBack(50);
mylist.reverse();
mylist.display();
mylist.reverse();
mylist.display();
mylist.removeFromBack().removeFromBack();
mylist.reverse();
mylist.display();
mylist.removeFromBack();
mylist.display()
// mylist.removeFromFront();
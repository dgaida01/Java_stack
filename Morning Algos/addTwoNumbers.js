
//You are given two non-empty linked lists representing two non-negative integers. 
//The digits are stored in reverse order, and each of their nodes contains a single digit. 
//Add the two numbers and return the sum as a linked list.

//You may assume the two numbers do not contain any leading zero, except the number 0 itself.


function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

function addTwoNumbers(l1,l2){

    let node1 = l1;
    let node2 = l2;
    let result = new ListNode();
    let resultHead = result;
    let remainder=0;

    result.val = node1.val + node2.val;
    while(result.val>=10){
        remainder++;
        result.val -= 10;
    }
    node1 = node1.next;
    node2 = node2.next; 

 while(node1!=null || node2!=null){
    result.next = new ListNode();
    result = result.next;


    if(node1==null){
        result.val = node2.val +remainder;
        remainder=0;
        node2 = node2.next;
       
     }
    else if(node2==null){
        result.val = node1.val + remainder;
        remainder=0;
        node1 = node1.next;
    
    }
    else{
    result.val = node1.val + node2.val + remainder;
    remainder=0;
    node1 = node1.next;
    node2 = node2.next; 
    }
    while(result.val>=10){
        remainder++;
        result.val -= 10;
    }

       
 }

 console.log("remainder:"+ remainder);
 if(remainder!=0){
     result.next = new ListNode(remainder,null);
 }
 else{
     result = null;
 }
 return resultHead;
}

// let l1 = new ListNode(2,new ListNode(4,new ListNode(3,null)));
// let l2 = new ListNode(5,new ListNode(6,new ListNode(4,null)));

let l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null)))))));
let l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null))));

let res = addTwoNumbers(l1,l2);
console.log(res); 

printer = res;

while(printer!=null){
    console.log(printer.val);
    printer= printer.next;
}


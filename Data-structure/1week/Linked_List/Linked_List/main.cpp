//
//  main.cpp
//  Linked_List
//
//  Created by 이재익 on 2022/11/26.
//

#include <iostream>
using namespace std;
#define interface class

static const int MAX_VALUE = 2000000000;
static const int MIN_VALUE = -2000000000;
static const int MIN_INDEX = 0;
/*
 *Node----------------------------------------
 */
class Node {
    public:
        int data;
        Node* next;
        static Node* create(int data);
        static void destroy(Node* node);
};

Node* Node::create(int data) {          //Node 생성
    Node* node = new Node;
    node->data = data;
    node->next = NULL;
    return node;
}
void Node::destroy(Node *node){         //Node 제거
    delete node;
}
/*
 *---------------------------------------------
 *단일리스트 interface
 */
interface SinglyLinkedList {

    
public:
    bool add(int data);
    
    int find(int index);
    
    int del(int index);
  
    void show();
    
    int size=0;
    
};
/*
 *----------------------------------------------
 */
Node* head = NULL;
bool SinglyLinkedList::add(int data){
    
    try{
        if(data>MAX_VALUE||data<MIN_VALUE)
            throw "[ERROR] int range 를 넘어서는 data 값 입니다.";
        if(head == NULL) {
            head = Node::create(data);
            size++;
        } else {
            Node* current = head;
            while(current->next != NULL) {
                current = current->next;
            }
            current->next = Node::create(data);
            size++;
        }
           
        return true;
    }
    catch(string exp){
        cout << exp;
    }
    return false;
}
int SinglyLinkedList::find(int index){
    try{
        if(index>size||index<MIN_INDEX)
            throw "[ERROR] 배열의 크기를 넘어서는 index입니다.";
        int cnt = 0;
        Node* search;
        search = head;
        while (search != NULL)
        {
            if (cnt != index) {
                cnt++;
                search = search->next;
            }
            
        }
        return search->data;
    }catch(string exp){
        cout << exp;
    }
    return 0;
}

int SinglyLinkedList::del(int index){
    try{
        int del_data;
        if(index>size||index<MIN_INDEX)
            throw "[ERROR] 배열의 크기를 넘어서는 index입니다.";
        
        return del_data;
    }catch(string exp){
        cout << exp;
    }
    return 0;
}

void SinglyLinkedList::show(){
    if(head == NULL) {
        cout << "empty array" << endl;
        return;
    }
    Node* current = head;
    while(current != NULL) {
       cout << current->data << "  ";
       current = current->next;
    }
    
}

int main(){
    SinglyLinkedList sll;
    sll.add(1);
    sll.add(1);
    sll.add(1);
    sll.add(1);
    sll.add(1);
     sll.find(3);
    sll.show();
    return 0;
}

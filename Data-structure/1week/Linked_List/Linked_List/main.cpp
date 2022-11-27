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
Node* head = NULL;                          //head 선언


/*
 *-------------------------------------------------------------
 *Node 추가 함수
 *head가 NULL일 때 생성 후 사이즈 증가 아니라면 tail에 노드 추가 후 사이즈 증가
 *-------------------------------------------------------------
 */
bool SinglyLinkedList::add(int data){
    
    try{
        if(data>MAX_VALUE||data<MIN_VALUE)
            throw string("[ERROR] int range 를 넘어서는 data 값 입니다.");
        if(head == NULL) {
            head = Node::create(data);
            
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
/*
 *--------------------------------------------------------
 *선택한 위치의 data값을 불러오는 함수 find()
 *--------------------------------------------------------
 */
int SinglyLinkedList::find(int index){
    try{
        if(index>size||index<MIN_INDEX)
            throw string("[ERROR] 배열의 크기를 넘어서는 index입니다.\n");
        Node* search;
        search = head;
        for (int i=0;i<index;i++)
            search = search->next;
        return search->data;
    }catch(string exp){
        cout << exp;
    }
    return 0;
}
/*
 *----------------------------------------------------------
 *선택한 위치의 노드를 삭제하는 함수 del()
 *----------------------------------------------------------
 */
int SinglyLinkedList::del(int index){
    try{
        int del_data;
        if(index>size||index<MIN_INDEX)
            throw "[ERROR] 배열의 크기를 넘어서는 index입니다.\n";
        Node* delNode;
        Node* preNode;
        preNode = head;
        delNode = head;
        if(index==0){
            del_data = delNode->data;
            head = delNode->next;
            Node::destroy(delNode);
            size--;
        }
            
        else
        for(int i=0;i<index;i++){
            if(i==index-1){
                delNode = delNode->next;
                preNode->next = delNode->next;
                del_data=delNode->data;
                
                Node::destroy(delNode);
                size--;
            }else{
                delNode = delNode->next;
                preNode = preNode->next;
            }
        }
        
        return del_data;
    }catch(string exp){
        cout << exp;
    }
    return 0;
}
/*
 *--------------------------------------
 *현재 리스트 data출력 함수 show()
 *--------------------------------------
 */
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
/*
 *test case
 */
int main(){
    SinglyLinkedList sll;
    
    sll.add(1);
    sll.add(2);
    sll.add(3);
    cout << sll.del(0) << "\n";
    cout << sll.find(0) << "\n";
    sll.add(4);
    sll.add(5);
//     sll.find(3);
    sll.show();
    return 0;
}

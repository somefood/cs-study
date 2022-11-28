# 2주차

`doubly linked list`를 구현해볼 것입니다.

<br>

## 주의사항

- `Java`
  - `java.util.List` 압수
  - `java.util.LinkedList`, `java.util.ArrayList` 압수
- `cpp`
  - STL `vector` 압수
- `python`
  - `list()` 압수
  - `queue` 관련 압수
- `kotlin`
  - `mutableListOf()`, `listOf()` 등등 list 관련 압수

<br>

# 요구사항

이번에는 저번과는 달리, `generic` type으로 클래스를 만들어 볼 것입니다. `Java` 에서는 `generic`을 참고해주시고,  `C++`에서는 `template`키워드로 검색하여 가변 타입에 대한 클래스를 생성해서 요구사항을 구현해주세요.

그리고 이번에는 1개의 클래스에 모든 구현을 넣는 것이 아닌, **파일을 나눠서 구현해주세요**. 아마도 2주차 요구사항에서는 `Node`, `DoublyLinkedList`, `DoublyLinkedListImpl` 총 3가지 파일이 나올 것 같네요. generic이나 template에 대해 잘 모르시겠다면 아래 코드를 참고해주셔도 좋습니다. 

`OOP`란 **객체간의 메세지를 주고 받는게** 중요하다고 생각합니다. 이 부분을 잘 생각해보시면서 구현에 임해보시길 바랍니다.

<br>

## 요구사항 : Java

```java
class Node <T> {
  
    // private 지우지 말 것
    private T data;
    private Node<T> next;
    private Node<T> prev;
  
    // TODO : 원하는 method 추가 가능
    ...
}
```

```java
public interface DoublyLinkedList<E> {

    void addLast(E data);

    void addFirst(E data);

    void addAt(int index, E data);

    void update(int srcIndex, E changedData);

    void remove(int index);

    E find(int index);

    int size();

    boolean isEmpty();

    void show();

}
```

```java
public class DoublyLinkedListImpl<E> implements DoublyLinkedList<E> {
  
    private int size = 0;
    private Node<E> head;
  
    void addLast(E data) {
        // TODO : 구현
    }
    ...
}
```

- `interface`에 있는 method name은 바꾸지 마세요.
- `Access modifier`는 바꾸지 마세요.
- `class variable`은 자유롭게 추가해주세요.
- 이번에는 요구사항이 좀 많습니다. 천천히 시간을 들여서 구현해주시길 바랍니다.

<br>

## 요구사항 : C++

```c++
template <typename T> class Node 
{
    // private 을 지우지 말 것
    private:
        T data;
        Node<T>* prev;
        Node<T>* next;
    public:
        // TODO : 원하는대로 추가 가능
        ...
}
```

```c++
template <typename E> class DoublyLinkedList 
{
    private:
        int size;
        Node<E>* head;

    public:
        void addLast(E data);

        void addFirst(E data);

        void addAt(int index, E data);

        void update(int srcIndex, E changedData);

        void remove(int index);

        E find(int index);

        int size();

        boolean isEmpty();

        void show();
}
```

`C++`기준으로 만든 코드입니다. 1개의 파일에 전부 class를 선언하는 것이 아닌, **파일을 나눠서 구현해주세요**.

<br>

## Description : 반드시 아래와 같이 구현이 되어야 합니다.

```c++
void addLast(E data);
```

- `E` type에 해당하는 데이터를 **배열의 끝에 추가**

```c++
void addFirst(E data);
```

- `E` type에 해당하는 데이터를 **배열의 처음에 추가**

```c++
void addAt(int index, E data);
```

- `E` type에 해당하는 데이터를 **배열의 `index`번째에 추가**

- 만약 `index`가 배열의 크기를 넘어서거나 음수이면 에러 발생 : `IllegalArgumentException`

  - 에러 메세지 
    1. `[ERROR] 배열의 길이보다 큰 index 는 찾을 수 없습니다.`
    2. `[ERROR] 음수 index 는 찾을 수 없습니다.`

  에러 발생 시키면 try-catch로 잡을 필요없이 바로 프로그램 종료.

```c++
void update(int srcIndex, E changedData);
```

- 배열의 `index`번째 데이터를 `changedData`로 대체.

- 만약 `index`가 배열의 크기를 넘어서거나 음수이면 에러 발생 : `IllegalArgumentException`

  - 에러 메세지 
    1. `[ERROR] 배열의 길이보다 큰 index 는 찾을 수 없습니다.`
    2. `[ERROR] 음수 index 는 찾을 수 없습니다.`

  에러 발생 시키면 try-catch로 잡을 필요없이 바로 프로그램 종료.

```c++
void remove(int index);
```

- 배열의 `index`번째 데이터 삭제.

- 만약 `index`가 배열의 크기를 넘어서거나 음수이면 에러 발생 : `IllegalArgumentException`

  - 에러 메세지 
    1. `[ERROR] 배열의 길이보다 큰 index 는 찾을 수 없습니다.`
    2. `[ERROR] 음수 index 는 찾을 수 없습니다.`

  에러 발생 시키면 try-catch로 잡을 필요없이 바로 프로그램 종료.

```c++
E find(int index);
```

- `index`번째 데이터 찾아서 반환

- 만약 `index`가 배열의 크기를 넘어서거나 음수이면 에러 발생 : `IllegalArgumentException`

  - 에러 메세지 
    1. `[ERROR] 배열의 길이보다 큰 index 는 찾을 수 없습니다.`
    2. `[ERROR] 음수 index 는 찾을 수 없습니다.`

  에러 발생 시키면 try-catch로 잡을 필요없이 바로 프로그램 종료.

```c++
int size(); // 현재 배열 크기 반환

boolean isEmpty(); // 현재 배열에 element가 없다면 true, else false

void show(); // 현재 배열 모든 elements 출력. '띄어쓰기' 공백 1칸 기준으로 출력
```

<br>

## 너무 어려워요!! 

참고할 사이트

- [`C++` class 메서드 구현하는 방법](https://www.w3schools.com/cpp/cpp_class_methods.asp)
- [`C++`, `Java` doubly linked list implementation](https://www.geeksforgeeks.org/doubly-linked-list/)
- [`C++` template 사용법1](https://www.youtube.com/watch?v=-jJ0w5h7piM), [`C++` template 사용법2](https://hazarddev.tistory.com/75)
- [`Java` generic 사용법](https://st-lab.tistory.com/153)

<br>

## Code Review

다른 사람들이 PR한 코드들을 보면서 본인이 얻어가는 것들도 많을 것입니다. 하지만 상대방에게 본인만의 꿀팁이나 더 발전시킬 수 있는 코드를 제공할 수 있다면 좋겠죠?

서로 `코드 리뷰`를 통해서 다 같이 성장하는 것이 스터디의 목적이라 생각합니다. 저도 시간 남는대로 틈틈히 모든 PR에 대해 코드리뷰를 하도록 하겠습니다. 다 같이 참여해주시면 감사할 것 같습니다!


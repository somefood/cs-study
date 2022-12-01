# 1주차

`singly linked list`를 구현해볼 것입니다.

<br>

## 주의사항

- `Java`
  - `java.util.List` 압수
  - `java.util.LinkedList`, `java.util.ArrayList` 압수
- `cpp`
  - STL `vector` 압수
- `python`
  - `list()` 압수
- `kotlin`
  - `mutableListOf()`, `listOf()` 등등 list 관련 압수

<br>

## 요구사항

```java
interface SinglyLinkedList {
    boolean add(int data);
    
    int find(int index);
    
    int delete(int index);
  
    void show();
}
```

`Java`를 기반으로 작성되었습니다. 다른 언어를 사용하시는 분들은 가급적 'interface'를 만드시고 그를 구현해주세요. (나중에 테스트 코드를 일괄적을 만들기 위함입니다)

따라서 `Java`를 쓰시는 분들은 위 인터페이스를 `implements`해서 코드를 완성해주시길 바랍니다.

<br>

## Constructor

마음대로 하셔도 됩니다. 참고 하시고 싶은 분들만 `constructor` 만드는 방법에 대해 보세요.

```java
SinglyLinkedList() {
    this.head = new Node();
}
```

```java
SinglyLinkedList(int firstData) {
    this.head = new Node(firstData);
}
```

<br>

## Class variable

마음대로 추가하셔도 됩니다. 감이 안오시는 분들을 위해서 

```java
class MySinglyLinkedList implements SinglyLinkedList {
    private int size; // 리스트의 크기
    private Node head; // 리스트의 head
    ...
    
    boolean add(int data) {
        // TODO : add 구현!
    }
    ...
}
```

위 코드를 참고해보세요!

위에는 `Node`라는 클래스가 보이는데 이는 본인이 구현하셔야 합니다. `Node`가 아니더라도 좋은 방법이 있다면 사용해주세요!

<br>

## Description : 반드시 아래와 같이 구현이 되어야 합니다.

```java
boolean add(int data);
```

- `data`에 해당하는 숫자를 `list`의 맨 뒤에 추가하세요.

- `data`가 `range(–2,000,000,000 ~ 2,000,000,000)`를 넘어간다면 `IllegalArgumentException`를 발생시키세요.

  - Error Message

    ```shell
    [ERROR] int range 를 넘어서는 data 값 입니다.
    ```

- `return value`

  - 만약 추가에 성공했다면 return `true`
  - else return `false`

<br>

```java
int find(int index);
```

- `index`번째의 `data`을 반환하세요.

- `index`가 `list`의 size보다 크다면 `ArrayIndexOutOfBoundsException`를 발생시키세요.

  - Error message

    ```shell
    [ERROR] 배열의 크기를 넘어서는 index입니다.
    ```

- `return value`

  - 만약 잘 찾았다면 return `data`
  - else `throw new ArrayIndexOutOfBoundsException`

<br>

```java
int delete(int index);
```

- `index`번째의 `data`를 삭제하세요. 삭제한 데이터는 리스트에서 사라져야 합니다. 그리고 삭제된 다음의 데이터들은 모두 1칸씩 앞으로 당겨집니다.

  - 설명

    ```text
    [1, 2, 3, 3, 5, 6]
    ```

    ```text
    delete(1)
    ```

    ```text
    [1, deleted!, 3, 3, 5, 6]
    ```

    ```text
    [1, 3, 3, 5, 6]
    ```

    이렇게 삭제한 부분은 더 이상 존재하지 않고, 그 다음 요소들은 전부 앞으로 당겨지게 됩니다.

- `index`가 `list`의 size보다 크다면 `ArrayIndexOutOfBoundsException`를 발생시키세요.

  - Error message

    ```text
    [ERROR] 배열의 크기를 넘어서는 index입니다.
    ```

- `return value`

  - 만약 잘 삭제했다면 return `deleted data`
  - else `throw new ArrayIndexOutOfBoundsException`

<br>

```java
void show();
```

- 현재 리스트의 요소들을 모두 출력.

- 출력은 ' '공백을 기준으로 진행.

- 예시

  ```text
  list 상태 : [1, 2, 3, 4]
  show()
  1 2 3 4
  
  list 상태 : [] <= empty list
  show()
  empty array
  ```

<br>

## 너무 어려워요!! 

참고할 사이트

- [java singly linked list implementation](https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
- [c++ singly linked list implementation](https://www.educative.io/answers/singly-linked-list-in-cpp)
- [python singly linked list implementation](https://www.tutorialspoint.com/python_data_structure/python_linked_lists.htm)
- [kotlin singly linked list implementation](https://medium.com/@bipinkumar650/singly-linked-list-in-kotlin-a280d1bc7b09)

<br>

## Code Review

다른 사람들이 PR한 코드들을 보면서 본인이 얻어가는 것들도 많을 것입니다. 하지만 상대방에게 본인만의 꿀팁이나 더 발전시킬 수 있는 코드를 제공할 수 있다면 좋겠죠?

서로 `코드 리뷰`를 통해서 다 같이 성장하는 것이 스터디의 목적이라 생각합니다. 저도 시간 남는대로 틈틈히 모든 PR에 대해 코드리뷰를 하도록 하겠습니다. 다 같이 참여해주시면 감사할 것 같습니다!




- 상속 -  super(), this(), 기본생성자
    =

    ## Super()

     부모 객체를 상속받은 자식 객체가 있을 때, 부모 객체의 생성자 호출에 실패하면 자식 객체 생성이 되지 않고 컴파일 오류가 발생한다. 그 이유는 

     - 자식 객체가 생성될 때, 자바 내부적으로 부모 객체가 먼저 생성되고 자식 객체가 호출된다.

     - 자바의 모든 객체는 클래스의 생성자를 호출해야만 생성된다.

    따라서, 자식 객체 생성자에 super()를 추가해줌으로써 부모 객체의 기본 생성자를 호출할 수 있고 자식 객체가 생성된다. 또한 자식 객체의 생성자에서 생략이 가능하다. 

     <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208280348-4fd9b198-d1a3-428d-9155-6d29ec908770.png">


     <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208280941-37d28d23-c53f-4c9d-9f78-8e281815ce7a.png">


    하지만, 부모 객체에 매개 변수를 가진 생성자가 있다면 명시적으로 자식 객체에서 super(매개변수)를 호출하지 않으면 컴파일 오류가 발생한다.

    <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208281301-8151e297-37a4-4db3-bd62-b933fd67eba8.png">

     <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208281339-30559923-3d49-487a-a3e4-c37dc7bd28d9.png">

    이러한 오류를 방지하기 위해서는, 1. 명시적으로 super(매개변수)를 명시적으로 호출하는 방법 2. 컴파일러에 의해 자동으로 추가되는 super()를 활용하는 방법이 있다. 2번 방법을 활용하기 위해 부모 객체에 매개변수가 없는 기본 생성자를 선언해 주는 것이 필요하다. Spring의 경우 롬북의 @NoArgsConstructor가 자동으로 파라미터가 없는 생성자를 만들어주는 기능을 한다.


    1번 방법 
    <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208281535-24f92b20-028a-4a54-9c05-a3a4332444f1.png">

    2번 방법

     <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208281581-34f1d639-cd2f-4198-b48c-ae4a7bf77a7a.png">

    <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208281605-0c3a38c9-c08f-427f-9119-306200f0a0a4.png">

    ## this()

    this()는 생성자에서 다른 생성자를 호출할 때 사용한다. 반드시 생성자의 첫 줄에서만 허용된다.
    생성자 오버로딩이 많아질 경우, 중복 코드가 발생할 수 있다. 즉, 매개 변수의 수만 달리하고 필드 초기화 내용이 비슷한 생성자에서 이러한 상황이 발생할 수 있다. 이 경우, this()를 활용 하면 코드를 개선할 수 있다. 

     <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208281957-baaa677e-c7ea-4dd4-8724-8719eb6c233f.png">

     <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208282085-0322f23c-5f28-4656-8f28-01d2c9cc80ec.png">
    

    ## 기본 생성자

    매개 변수를 갖지 않는 생성자를 기본 생성자라고 한다. 모든 클래스는 생성자가 반드시 존재하고, 하나 이상의 생성자를 가질 수 있다. 만약, 개발자가 클래스 내부에 생성자 선언을 생략하면 컴파일러는 자동으로 기본 생성자를 바이트 코드에 추가한다. 하지만, 클래스에서 명시적으로 선언한 생성자가 하나라도 있으면, 기본 생성자는 추가되지 않는다


     ## 오보로딩

    다양한 매개변수를 활용해서 객체, 메서드를 초기화하려면 생성자도 다양해야 한다. JAVA에서는 다양한 방법으로 객체, 메서드를 활용할 수 있도록 오보로딩(Overloading)을 제공한다.
    오보로딩이란, 같은 이름으로 선언되었지만 매개변수를 달리 하는 생성자, 메서드를 여러개 선언하는 것을 의미한다.
    
    1. 생성자 오보로딩 - 매개 변수를 달리해서 같은 이름의 생성자를 여러개 선언할 수 있다. 주의할 점은, 메개 변수의 타입과 개수 그리고 선언된 순서가 똑같을 경우 변수 이름만 바꾸는 것은 오보로딩이 아니다.

     <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208282607-8665c939-2ae0-4e67-8707-1e84746dd507.png">

     <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208282585-37b4cfb6-7d58-4833-ab2b-23a36ad60713.png">


    2. 메소드 오보로딩 -클래스 내에 같은 이름의 메소드를 여러개 선언하는 것, 생성자 오보로딩과 마찬가지로, 매개 변수의 순서만 바꾸는 것은 적용되지 않는다.

     <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208282730-693c1e00-3558-49c7-80f2-3ae8981e93d7.png">

    ## 오버라이딩

    부모 클래스에서 선언된 메소드가 자식 클래스에서 적합하지 않을 경우 자식 클래스에서 메소드를 재선언 할 수 있다. 이러한 기능을 메소드 재정의, 오버라이딩(Overriding)이라고 한다. 오버라이딩을 위해서는 규칙이 존재한다.
    
     - 부모의 메소드와 동일한 시그니처(리턴 타입, 메소드 이름, 매개변수 목록)을 가져야 한다.
     - 접근 제한을 더 강하게 재정의할 수 없다. 예,( Public->private(x), private->public(o)) 
     - 새로운 예외(Exception)를 던질(throws) 수 없다.
    
       <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208283086-b03458ac-cc79-4689-819a-f4161da624e2.png">


## Abstract


1. 추상 클래스

    객체를 직접 실행할 수 있는 실체 클래스의 공통적인 특성을 추출해서 선언한 클래스를 추상(abstract) 클래스라고 정의할 수 있다. 특성이란, 필드와 메소드를 의미한다. 추상 클래스는 new 연산자를 통해 객체를 만들지 못하고, 실체 클래스와 상속을 통해 구현이 가능하다. 실체 클래스는 추가적인 특성을 가질 수도 있다.

    추상 클래스
     <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208285118-68b82da8-f6d1-44fe-8fda-01002abe3195.png">

    실체 클래스 
    <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208285170-32e9b0de-a9c4-4242-ac11-2a697616bbdb.png">

     실행 클래스
    <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208285243-bac80215-268e-4a16-8b99-958397a76d22.png">
    <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208285214-01704f80-30c6-4f58-aeb8-67cb839637ab.png">

2. 추상 메소드

    메소드의 선언만 동일하고 실체 클래스에서 실행이 다르게 되어야 할 경우 추상 메소드를 사용할 수 있다.

    <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208285397-b9cb0384-abca-4250-b41e-ae73df83dc2c.png">

    <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208285609-b45213a4-b875-4c4d-9eb7-d195551b36d0.png">

    <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208285575-a731fd37-c6bf-4ab1-bb80-5e5f8e3aa8ad.png">


## Interface

객체의 사용 방법을 정의한 타입으로 정의할 수 있다. 인터페이스를 통해 다양한 객체를 동일한 사용 방법으로 이용할 수 있다. 인터페이스는 상수 필드와 추상 메소드만을 특성으로 가진다.(그러나 JAVA 8 버전부터 default method 와 static method를 작성할 수 있다.) 또한, 추상 클래스와는 달리 다중 상속이 가능하다. 클래스를 상속받는 extends와 혼용 시, extends가 먼저 선언되어야 한다.

<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208288864-6d24230a-9490-491a-9e4e-e03177117943.png">

<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208288835-efe87bb8-1dff-47f0-9e26-8af82ee7996f.png">
<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208288753-a35d084d-a162-46a3-8f2a-70769a2b7287.png">

### JAVA 8 이후로 추상, 인터페이스 변경된 점

 JAVA 8 버전부터 인터페이스에서도 default method 와 static method를 작성이 가능해졌다. 이를 통해, 인터페이스 메소드 변경시, 구현 클래스들의 구현 메소드 변경 해줘야 하는 불편함을 해결할 수 있다.

 <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208289236-63b13508-ca7e-43b0-82f3-8933eccf5c29.png">

즉, JAVA 8 이전 버전에서는 인터페이스의 메소드는 추상 메소드로만 선언이 가능했다. 그래서 인터페이스에 새로운 메소드를 추가하면, 직접 인터페이스를 구현한 클래스들을 오버라이드 해주어야 했다. 하지만 JAVA 8 이후 버전에서는, 인터페이스에서 추상 메소드 이외에도 기본 구현을 갖는 메서드인 default 메소드를 선언함으로 써, 불편함을 해결했다.

## 다형성

개발 코드는 변함이 없는데, 구현 객체를 교체함으로써 프로그램의 실행 결과가 다양해진다. 자동 및 강제 타입 변환, 필드의 다형성, 매개 변수의 다형성 등과 관련이 있다.

1. 자동 타입 변환 

    구현 객체가 인터페이스 타입으로 변환되는 것.

 <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208290817-16b5a541-26e7-473b-aea8-d97ac5ac075a.png">

 2. 필드 다형성

 개발 코드의 메소드를 수정하지 않아도, 메소드의 실행 결과를 다르게 얻을 수 있다.

<img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208291390-379f1d84-2621-4455-8c59-fe23de4d27d2.png">
 <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208291415-82c7453a-c4c7-4431-a5a2-067f13a0fc69.png">
 <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208291440-f45f251b-deb0-4e3c-bb36-73abfe4fda70.png">
  <img width="1237" alt="image" src="https://user-images.githubusercontent.com/45227809/208291496-db854f28-ec36-45c8-9e16-2e8bf3c2682a.png">

  roll이라는 메소드가 실행될 때, Tire 인터페이스를 통해 이루어지기 때문에, 타이어 교체 후 개발 코드를 수정하지 않아도 오류 없이 결과를 얻을 수 있다.
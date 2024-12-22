# 아이템 10 - equals는 일반 규약을 지켜 재정의하라

equals 메서드는 재정의하기 쉬워 보이지만 곳곳에 함정이 도사리고 있어서 자칫하면 끔찍한 결과를 초래함
기본 Object의 equals()는 다음과 같음

```java
// 단순히 두 객체 참조가 같은지만 비교
public boolean equals(Object obj) {
    return this == obj;
}
```

## 아래의 상황에 해당한다면 재정의하지 않는 것이 최선

### 각 인스턴스가 본질적으로 고유하다



### 인스턴스의 논리적 동치성(logical equality)을 검사할 일이 없다.



### 상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어맞는다

대부분 Set 구현체는 AbstractSet이 구현한 eqauls를 사용하고, List 구현체는 AbstractList, Map은 AbstractMap을 상속받아 쓰고 있음

```java
// AbstractSet의 equals 메서드
public boolean equals(Object o) {
    if (o == this) {
        return true;
    } else if (!(o instanceof Set)) {
        return false;
    } else {
        Collection<?> c = (Collection)o;
        if (c.size() != this.size()) {
            return false;
        } else {
            try {
                return this.containsAll(c);
            } catch (NullPointerException | ClassCastException var4) {
                return false;
            }
        }
    }
}

// AbstractList의 equals 메서드
public boolean equals(Object o) {
    if (o == this) {
        return true;
    } else if (!(o instanceof List)) {
        return false;
    } else {
        ListIterator<E> e1 = this.listIterator();
        ListIterator<?> e2 = ((List)o).listIterator();

        while(true) {
            if (e1.hasNext() && e2.hasNext()) {
                E o1 = e1.next();
                Object o2 = e2.next();
                if (o1 == null) {
                    if (o2 == null) {
                        continue;
                    }
                } else if (o1.equals(o2)) {
                    continue;
                }

                return false;
            }

            return !e1.hasNext() && !e2.hasNext();
        }
    }
}

// AbstractMap의 equals 메서드
public boolean equals(Object o) {
    if (o == this) {
        return true;
    } else if (!(o instanceof Map)) {
        return false;
    } else {
        Map<?, ?> m = (Map)o;
        if (m.size() != this.size()) {
            return false;
        } else {
            try {
                Iterator var3 = this.entrySet().iterator();

                Object key;
                label41:
                do {
                    Object value;
                    do {
                        if (!var3.hasNext()) {
                            return true;
                        }

                        Map.Entry<K, V> e = (Map.Entry)var3.next();
                        key = e.getKey();
                        value = e.getValue();
                        if (value == null) {
                            continue label41;
                        }
                    } while(value.equals(m.get(key)));

                    return false;
                } while(m.get(key) == null && m.containsKey(key));

                return false;
            } catch (NullPointerException | ClassCastException var7) {
                return false;
            }
        }
    }
}
```

### 클래스가 private이거나 package-private이고 equals 메서드를 호출할 일이 없다.

애초에 호출될일이 없으면 안전하게 막아버리는 수가 있음

```java
@Override public boolean equals(Object o) {
    throw new AssertionError(); // 호출하면 안 됨
}
```

## 그럼 언제 재정의를 해야할까

- 객체 식별성(object identity; 두 객체가 물리적으로 같은가)이 아니라 논리적 동치성(logical equality; 두 객체가 논리적으로 같은가)을 확인해야 할 때
- 이때 상위 클래스에서 equals로 확인이 어령울 때 해야한다.
- 주로 값 클래스(VO, Value Object)에서 사용한다.
  - Integer, String 값이 값을 표현하는 클래스 
- 논리적 동치성을 확인하도록 재정의해두면, 그 인스턴스 값을 비교하길 원하는 프로그래머의 기대에 부응함은 물론 Map의 키와 Set의 원소로 사용할 수 있게 된다.
- 물론 값 클래스라 해도, 값이 같은 인스턴스가 둘 이상 만들어지지 않음을 보장하는 인스턴스 통제 클래스(싱글톤이 될듯? + Enum)라면 재정의 하지 않아도 됨

## equals 메서드를 재정의할 때 지켜야할 일반 규약

> equals 메서드는 동치관계(equivalence relation)을 구현하며, 다음을 만족함

### 반사성(reflexivity): null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true다.
### 대칭성(symmetry): null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)가 true면 y.equals(x)도 true다.

- 두 객체는 서로에 대한 동치 여부에 똑같이 답해야 한다.

```java
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // 대칭성 위반
    @Override 
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(
                ((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) { // 한 방향으로만 작동한다!
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }
}
```

> CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
> String s = "polish"; 
> cis.equals(s); // true를 반환

- 위의 경우는 true를 반환하겠지만, 거꾸로 했을 때 String은 CaseInsensitiveString을 모르기 때문에 false를 반환할 것임
- 추가적으로 list.contains(s)도 반환을 하게 될것임
- 이런 문제를 해결하긴 위해서 String의 경우 허용을 시켜주지 않아야 한다

```java
@Override 
public boolean equals(Object o) {
    return o instanceof CaseInsensitiveString &&
        ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
}
```

### 추이성(transitivity): null이 아닌 모든 참조 값 x, y, z에 대해, x.equals(y)가 true이고 y.equals(z)도 true이면 x.equals(z)도 true다.

- 추이성은 첫 번째 객체와 두 번째 객체가 같고, 두 번째 객체와 세 번째 객체가 같다면, 첫 번째 객체와 세 번째 객체도 같아야 한다는 것이다. (삼단 논법 같음)

```java
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override 
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}
```

> Point p = new Point(1, 2);
> ColorPoint cp = new ColorPoint(1, 2, Color.RED);

- 위와 같이 작성하면 대칭성이 위배되게 됨
- p.equals(cp)는 true를 반환하지만, cp.equals(p)는 false를 반환하게 됨
- 아래처럼 바꾸면 대칭성은 충족하지만 추이성이 안 맞게 됨

```java
@Override
public boolean equals(Object o) {
    if (!(o instanceof Point)) {
        return false;
    }
    // o가 일반 Point면 색상을 무시하고 비교
    if (!(o instanceof ColorPoint)) {
        return o.equals(this);
    }
    // o가 ColorPoint면 색상까지 비교
    return super.equals(o) && ((ColorPoint) o).color == color;
}
```

> ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
> Point p2 = new Point(1, 2);
> ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
> p1.equals(p2) && p2.equals(p3) // true

### 일관성(consistency): null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)를 반복해서 호출해도 항상 true나 false를 반환한다.

- 두 객체가 같다면 앞으로도 영원히 같아야 함
- 클래스가 불변이든 가변이든 equals의 판단에 신뢰할 수 없는 자원이 끼어들게 해서는 안 됨
- equals는 항시 메모리에 존재하는 객체만을 사용한 결정적(deteministic) 계산만 수행해야 함
  - java.net.URL의 경우 네트워크를 통해 IP주소가 바뀌면서 eqauls의 결과가 달라질 수 있음

### null-아님: null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false다.

- 모든 객체가 null과 같지 않아야 함

```java
@Override
public boolean equals(Object o) {
    if (o == null) {
        return false;
    }
}
```

## 양질의 equals 메서드를 구현하기 위한 단계

- == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.
  - 자기 자신이면 일찍이 true를 반환해서 성능 최적화를 함
- instanceof 연산자로 입력이 올바른 타입인지 확인한다.
- 입력을 올바른 타입으로 형변환한다.
  - instanceof로 확인했기 때문에 안전하게 형변환을 할 수 있음
- 입력 객체와 자기 자신의 대응되는 `핵심` 필드들이 모두 일치하는지 하나씩 검사한다.
  - 모든 필드가 일치하면 true를, 하나라도 다르면 false를 반환한다.

float, double의 경우 Float.compare(float, float), Double.compare(double, double)로 비교함
Float.NaN, -0.0f, 특수한 부동소수 값을 다뤄야 하기 때문

equals 함수를 구성하고 세 가지만 자문해보자
- 대칭적인지, 추이성이 있는지, 일관적인지

추가적으로 hashCode 메서드도 재정의해야 함

> 웬만하면 IDE의 도움을 받아 equals를 구현하자

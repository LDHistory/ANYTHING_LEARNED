# 기본API클래스

## 목차
[1. java.lang](#1-javalang) </br>
[2. java.util](#2-javautil) </br>
[3. System](#3-system) </br>
[4. Class](#4-class) </br>
[5. StringBuffer, StringBuilder](#5-stringbuffer-stringbuilder) </br>
[6. Arrays](#6-arrays) </br>
[7. Date Calendar](#7-date-calendar) </br>

___

## 1. java.lang
### 1.1 Object 클래스
클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Object 클래스를 상속하게 된다. 따라서 자바의 모든 클래스는 Object 클래스의 자식이거나 자손 클래스이다.

#### 1.1.1 eqauls()
eqauls() 메소드의 매개 타입은 Object인데, 이것은 모든 객체가 매개값으로 대입될 수 있음을 말한다. 그 이유는 Object가 최상위 타입이므로 모든 객체는 Object 타입으로 자동 타입 변환될 수 있기 때문이다.

```java
Object obj1 = new Object();
Object obj2 = new Object();

boolean r1 = obj1.equals(obj2);
boolean r2 = (obj1 == obj2);

System.out.println(r1 && r2); // true
```

자바에서는 두 객체를 동등 비교할 때 equals() 메소드를 흔히 사용한다. equals()는 두 객체를 비교해서 논리적으로 동등하면 true를 리턴하고, 그렇지 않으면 false를 리턴한다.

논리적으로 동등하다는 것은 __같은 객체이건 다른 객체이건 상관없이 객체가 저장하고 있는 데이터가 동일함을 뜻한다.__

예를 들어 String 객체의 equals()는 String 객체의 번지를 비교하는 것이 아니고, 문자열이 동일한지 조사해서 같다면 true를, 다르면 false를 리턴한다. 이것이 가능한 이유는 String 클래스가 Object의 eqauls() 메소드를 오버라이딩해서 번지 비교가 아닌 문자열 비교로 변경했기 때문이다.

#### 1.1.2 hashCode()
객체 해시코드란 객체를 식별할 하나의 정수값을 말한다. Object의 hashCode() 메소드는 객체의 메모리 번지를 이용해서 해시코드를 만들어 리턴하기 때문에 객체마다 다른 값을 가지고 있다.

우선 hashCode() 메소드를 실행해서 리턴된 해시코드 값이 같은지를 본다. 해시코드 값이 다르면 다른 객체로 판단하고, 해시코드 값이 같으면 equals() 메소드로 다시 비교한다. 그렇기 때문에 hashCode() 메소드가 true가 나와도 equals()의 리턴값이 다르면 다른 객체가 된다.

![equals 와 hashCode](./equals-and-hashcode.png)
> 출처 : https://www.javatpoint.com/equals-and-hashcode-in-java
___

## 2. java.util
### 2.1 객체 비교(compare(T a, T b, Comparator<T>c))
해당 메소드는 두 객체를 비교자(Comparator)로 비교해서 int값을 리턴한다. java.util.Comparator<T>는 제네릭 인터페이스 타입으로 두 객체를 비교하는 compare(T a, T b) 메소드가 정의되어 있다. compare() 메소드의 리턴 타입은 int인데, a가 b보다 작으면 음수, 같으면 0, 크면 양수를 리턴하도록 구현 클래스를 만들어야 한다.

```java
public interface Comparator<T> {
    int compare(T a, T b);
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        if (a.sno < b.sno) return -1;
        else if (a.sno == b.sno) return 0;
        else return -1;
    }
}

public class Example {
    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(1);
        Student s3 = new Student(2);

        int result = Objects.compare(s1, s2, new StudentComparator());
        System.out.println(result); // 0
        int result2 = Objects.compare(s1, s3, new StudentComparator());
        System.out.println(result2); // -1 
    }
}
```

### 2.2 Null 여부 조사(isNull(), nonNull(), requireNonNull())
Object.isNull(Object object)는 매개값이 null일 경우 true를 리턴한다. 반대로 nonNull(Object object)는 매개값이 not null일 경우 true를 리턴한다.

requireNonNull()은 다음 세 가지로 오버로딩되어 있다.
|리턴타입|메소드|설명|
|--|--|--|
|T|requireNonNull(T obj)|not null -> obj </br> null -> NullPointerException|
|T|requreNonNull(T obj, String message)|not null -> obj </br> null -> NullPointerException(message)|
|T|requireNonNumm(T obj, Supplier<String> msgSupplier)|not null -> obj </br> null -> NullPointerException(msgSupplier.get())|
___

## 3. System
자바 프로그램은 운영체제상에서 바로 실행되는 것이 아니라 JVM 위에서 실행된다. 따라서 운영체제의 모든 기능을 자바 코드로 직접 접근하기란 어렵다. 하지만 java.lang 패키지에 속하는 System 클래스를 이용하면 운영체제의 일부 기능을 이용할 수 있다.

### 3.1 현재 시각 읽기(currentTimeMillis(), nanoTime())
System 클래스의 currentTimeMillis() 메소드와 nanoTime() 메소드는 컴퓨터의 시계로부터 현재 시간을 읽어서 밀리세컨드(1/1000초) 단위와 나노세컨드(1/10^9초) 단위의 long값을 리턴한다.

```java
long time = System.currentTimeMillis();
long time = System.nanoTIme();
```

리턴값은 주로 프로그램의 실행 소요 시간 측정에 사용된다. 프로그램 시작 시 시각을 읽고, 프로그램이 끝날 때 시각을 읽어서 차이를 구하면 프로그램 실행 소요 시간이 나온다.

### 3.2 시스템 프로퍼티 읽기(getProperty())
시스템 프로퍼티는 JVM이 시작할 때 자동 설정되는 시스템의 속성값을 말한다.

|Key|설명|
|--|--|
|java.version|자바의 버전|
|java.home|사용하는 JRE의 파일 경로|
|os.name|Operating System Name|
|file.separator|File separator("/" on UNIX)|
|user.name|사용자의 이름|
|user.home|사용자의 홈 디렉토리|
|user.dir|사용자가 현재 작업 중인 디렉터리 경로|

시스템 프로퍼티를 읽어오기 위해서는 System.getProperty() 메소드를 이용하면 된다. 해당 메소드는 시스템 프로퍼티의 키 이름을 매개값으로 받고, 해당 키에 대한 값을 문자열로 리턴한다.

```java
String value = System.getProperty(String key);
```

___

## 4. Class
자바는 클래스와 인터페이스의 메타 데이터를 java.lang 패키지에 소속된 Class 클래스로 관리한다. 여기서 메타 데이터란 클래스의 이름, 생성자 정보, 필드 정보, 메소드 정보를 말한다.

### 4.1 Class 객체 얻기(getClass(), forName())
프로그램에서 Class 객체를 얻기 위해서는 Object 클래스가 가지고 있는 getClass() 메소드를 이요하면 된다.

```java
Class clazz = obj.getClass();
```

getClass() 메소드는 해당 클래스로 객체를 생성했을 때만 사용할 수 있는데, 객체를 생성하기 전에 직접 Class 객체를 얻을 수도 있다. Class는 생성자를 감추고 있기 때문에 new 연산자로 객체를 만들 수 없고, 정적 메소드은 forName()을 이용해야 한다.

```java
try {
    Class clazz = Class.forName(String className);
} catch (ClassNotFoundException e) {

}
```

### 4.2 리플렉션(getDeclaredConstructors(), getDeclaredFields(), getDeclaredMethods())
Class 객체를 이용하면 클래스의 생성자, 필드, 메소드 정보를 알아낼 수 있다. 이것을 Reflection이라고 한다. Class 객체는 리플렉션을 위해 getDeclaredConstructors(), getDeclaredFields(), getDeclaredMethods()를 제공하고 있다.

```java
Constructor[] constructors = clazz.getDeclaredConstructors();
Field[] fields = clazz.getDeclaredFields();
Method[] methods = clazz.getDeclaredMethods();
```

getDeclaredFields()와 getDeclaredMethods()는 클래스에 선언된 멤버만 가져오고 상속된 멤버는 가져오지 않는다. 만약 상속된 멤버도 얻고 싶다면 getFields(), getMethods() 를 이용해야 한다. 단 getFields(), getMethods()는 public 멤버만 가져온다.

___

## 5. StringBuffer, StringBuilder

___

## 6. Arrays

___

## 7. Date, Calendar
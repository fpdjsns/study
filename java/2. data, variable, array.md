# 변수 

## 선언

```java
int number;
double number;
float number;
```

## 초기화

```java
int number = 1;
double number = 1;
float number =1;
```

## 스코프, 라이프타임

지역 변수는 변수를 선언한 블록에서만 사용 가능하며 해당 스코프가 종료될 때, 같이 메모리 해제된다.

```java
import java.util.*;
import java.lang.*;


class Member {
  static String STATIC = "static";
  String name;
       
  Member(String name) {
    this.name = name;
  }
    
    void print() {
        System.out.println(name); // possible
    }
}

class Rextester {
    public static void main(String args[]) {
        Member member1 = new Member("1번 멤버");
        Member member2 = new Member("2번 멤버");
        System.out.println(Member.name); // error
        System.out.println(Member.STATIC); // possible
        System.out.println(member1.STATIC); // error
        member1.print();
        member2.print();
    }
}
```

단, static 변수(정적 변수)는 객체에 종속되는 값이 아닌 같은 클래스 타입들은 하나의 정적 변수를 보기 때문에 Member.STATIC 처럼 클래스에서 접근해야 한다.  
또한 생명주기가 클래스가 아닌 프로그램 수명과 같으므로 프로그램이 종료되기 전까지 유지된다.

# 배열

## array

1차원
```java
// #1
int[] array = {1, 2, 3, 4};
        
// #2
int[] array2 = new int[4];
array2[0] = 1;
array2[1] = 2;
array2[2] = 3;
array2[3] = 4;
```

2차원
```java
// #1
int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
// #2
int[][] array2 = new int[3][3];
array2[0][0] = 1;
        
// #3
int[][] arry3 = new int[3][];
array[0] = {1,2,3}; // error
array[1] = new int[]{4, 5, 6}; 
array[2] = new int[3];
```

## List

TODO

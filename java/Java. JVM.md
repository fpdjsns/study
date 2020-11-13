# java 프로그램 실행 방법

## 컴파일
[name].java -> [class name].class  

<img src="https://user-images.githubusercontent.com/11925627/99080599-daf2c500-2604-11eb-9a3c-638135ef8dd9.jpeg" width="500"/>

```
javac [name].java  
```
컴파일 결과물인 class 파일은 `자바 바이트코드`이다.  

## 실행


<img src="https://user-images.githubusercontent.com/11925627/99080609-de864c00-2604-11eb-8619-2e56b557c4be.jpeg" width="1200"/>

```
java [class name].class
```
자바 바이트코드는 JVM으로 실행된다.

# 자바 바이트코드  
확장자는 `.class`  
기계어가 아니라 OS는 이를 해석할 수 없다.  
JVM이 OS가 이를 실행할 수 있게 기계어로 번역해준다.  

# JVM (Java Virtual Machine; 자바 가상 머신)  
다양한 OS 위에서 자바 바이트코드를 실행할 수 있게 해주는 역할.  
JVM을 한 번 더 거치기 때문에 네이티브 언어 보다 속도가 더 느리지만  
JVM이 자바 바이트코드와 OS와 사이의 통역 역할을 하기 때문에 자바는 OS에 독립적이다.  

## JVM 구성 요소

### Class Loader (클래스 로더)  
JVM 내로 클래스를 로드.  
Runtime Data Areas에 바이트 코드를 배치한다.

### Runtime Data Area 

| 영역 | 설명 | 
| --- | --- | 
| Method Area | 모든 쓰레드가 공유. <br> JVM 시작시 생성됨. 바이트코드 저장되는 곳. <br> 클래스, 인터페이스, 메소드, 변수, static 변수. |
| Heap | 모든 쓰레드가 공유. <br> 동적으로 생성된 객체가 저장됨. <br> GC 대상 공간. | 
| Stack | 쓰레드 당 하나. <br> 지역변수, 매개변수 저장됨. <br> 해당 메소드 종료 시 메모리 공간도 삭제됨. |
| PC Register | 쓰레드 시작 시 생성됨. <br> 현재 수행중인 JVM 명령어 주소를 저장. <br> 쓰레드가 어떤 부분을 어떻게 수행할지 저장. | 
| Native Method Stack | java 외 다른 언어(C, C++ 등)로 작성된 코드를 위한 공간. <br> JNI(Java Native Interface)를 통해 호출하는 코드를 수행하기 위한 공간.  |

### Execution Engine (실행 엔진)
Class Loader에 의해 Runtime Data Areas에 배치된 바이트 코드를 실행한다.    
자바 바이트코드는 기계어가 아니기에 실행 엔진은 이를 기계어로 변경한다.  

- **Interpreter**   
자바 바이트 코드를 명령어 단위로 실행. 한 줄 씩 실행하기 때문에 느리다.  

- **JIT 컴파일러**  
JIT = Just In Time (런타임 시 컴파일)  
인터프리터의 느리다는 단점을 보완하기 위한 컴파일러.  
반복적으로 나오는 코드를 네이티브 코드로 바꾼 후 다음부터는 이를 실행하기 때문에 속도가 빠르다. 

- **GC(Garbage Collector)**  
Heap 메모리 관리. = 동적 메모리 관리.      
메모리 할당, 사용하지 않는 메모리 삭제.   

# JRE, JDK  

## JRE (Java `Runtime` Environment; 자바 실행 환경)  
자바 어플리케이션을 실행하기 위한 환경 제공.  
실행하기 위한 최소한의 환경만 제공하기 때문에 새 자바 어플리케이션을 작성하는데는 부적합하다.  

## JDK (Java `Development` Kit; 자바 개발 도구)  
JRE + JAVA API/Compilier/Tool  
JRE를 포함하기 때문에 자바 어플리케이션을 실행할 수 있고,  
개발 도구도 포함되기 때문에 새 자바 어플리케이션을 작성 & 컴파일 할 수 있다.  

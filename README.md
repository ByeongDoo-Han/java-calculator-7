# java-calculator-precourse
## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
### 입출력 요구 사항
입력
- 구분자와 양수로 구성된 문자열
출력
- 덧셈 결과
```
결과 : 6
```
### 실행 결과 예시
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```
## 구현할 기능 목록
### 기본 기능
1. 쉼표 또는 콜론을 기준으로 분리한 각 숫자의 합을 반환하는 기능
2. 앞 부분에 커스텀 구분자를 추가하면 기본 구분자(쉼표, 콜론) 외에 추가로 사용할 수 있는 구분자를 지정하는 기능
### 추가 기능
#### 커스텀 구분자 관련 기능
1. 커스텀 구분자의 길이가 2 이상일 때 커스텀 구분자를 지정할 수 있는 기능
2. 커스텀 구분자를 두개 이상 추가할 수 있는 기능
   1. 등록하고자 하는 커스텀 구분자 사이에 0을 넣어 구분할 수 있음 
   2. 커스텀 구분자에 0 이외의 숫자가 포함 되면 `IllegalArgumentException` 반환 후 애플리케이션 종료하는 기능
3. 등록되지 않은 커스텀 구분자가 있을 때 `IllegalArgumentException` 반환 후 애플리케이션 종료하는 기능
4. 커스텀 구분자를 입력하지 않았을 때 정상적으로 계산 처리 할 수 있는 기능
#### 계산식 관련 기능
4. 값이 잘못 입력되면 `IllegalArgumentException` 반환 후 애플리케이션 종료하는 기능 
5. 음수가 입력되면 `IllegalArgumentException` 반환 후 애플리케이션 종료하는 기능
6. 커스텀 구분자 입력 형식 `//{}\n`을 제외한 부분의 처음 or 끝에 구분자가 추가되면 `IllegalArgumentException` 반환 후 애플리케이션 종료하는 기능
7. int, long 범위를 넘어가는 수가 입력됐을 때 계산이 가능하도록 하는 기능
8. 출력 결과 값에 3자리 마다 `,`를 추가하는 기능
#### 애플리케이션 관련 기능
9. 애플리케이션 실행 시 사용 방법을 안내해주는 안내문 출력 기능


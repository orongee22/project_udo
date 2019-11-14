# Project Udo

> 제주도 근처의 섬인 우도의 관광정보를 제공하는 웹 사이트
>
> [웹 사이트 Link]( http://ec2-13-209-40-173.ap-northeast-2.compute.amazonaws.com:8080/Udo_Client/main.html )



##### 참여자

* 김한솔 [@HANSOLKIM]( https://github.com/HANSOLKIM30 )
* **백민종**
* 송주은 [@son9zuen]( https://github.com/son9zuen )
* 주예리나 [@JUYERINA]( https://github.com/orongee22 )



##### 개발 기간 : 1개월



##### 담당 기능

* **싱글 페이지 구현**
* **회원가입**
  1. 서버와 aJax 통신을 통해서 데이터의 중복 입력을 방지
  2. 가입 시 기입한 메일 주소로 인증 코드 전송
* **로그인**
  1. 본인 인증이 완료된 사용자만 로그인 허용
  2. 비밀번호 분실 시 본인 인증 후 난수를 생성해 임시 비밀번호 발급

***

##### 1. 사용기술

* 웹 표준
  * `HTML5`
  * `CSS3`
  * `JavaScript`
  * `jQuery`
  * `Bootstrap4`

* DMBS
  * `MySQL`
* `Spring Framework`
* `MyBatis`
* `jQuery`, `Ajax`, `XML`, `JSON 파싱`
* `REST 인터페이스` 구현

##### 2. 프로세스 흐름도

* 전체 흐름도

<img src="/README_images/process.PNG" alt="process" style="zoom:60%;" />



* 로그인 흐름도

<img src="/README_images/login_flow.PNG" alt="login_flow" style="zoom:60%;" />





##### 3. 구현 중 겪었던 어려움

* 싱글 페이지로 처음 구현을 하다보니, 코드가 길어져 관리가 어려웠음.

* 테스트를 진행 할 때 경로를 절대경로를 하다보니 배포 후 경로를 하나하나 바꿔야하는 어려움이 있었음.

* 각자 다른 환경에서 작업하다보니 로그인 정보가 담겨있는 세션 관리가 까다로웠음.

  -> sessionStorage 사용

##### 4. 프로젝트 PPT

[PPT Link](  https://docs.google.com/presentation/d/1FW-J6nRT7msmZYPpBZq5IbwVgoY6EJjXHHWEL-H-rHI/edit#slide=id.g61240466ee_4_37  )
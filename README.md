# GoCo_BackEnd

## Version
- Java8 (JDK 1.8)
- Spring Boot (2.7.0)
- Maven 4.0.0

- SECURITY(JWT)
	- JJWT-API : 0.11.2
	- JJWT-IMPL : 0.11.2
	- JJWT-JACKSON : 0.11.2
	
	
	<div align="center">
  <br />
  <br />
  <br />
</div>

## 목차

1. [**서비스 소개**](#서비스-소개)
2. [**기술 스택**](#%EF%B8%8F-기술-스택)
3. [**시스템 아키텍처**](#%EF%B8%8F-시스템-아키텍처)
4. [**데이터베이스 구조 - ERD**](#데이터베이스-구조---ERD)
5. [**주요기능**](#%EF%B8%8F-주요기능)
6. [**개발 멤버 소개**](#-개발-멤버-소개)
7. [**프로젝트 기간**](#프로젝트-기간)
8. [**Learned**](#-learned)


<br/>


<div id="1"></div>

## 💡 서비스 소개

<br/>

### 근태와 업무, 결재 관리를 한번에! 

> 이번 달 내 근무 시간은 얼마나 될까? 이번 주에 누가 출장이지? 내 휴가 신청이 승인됐을까? <br />
GoCo는 근태와 내 일정관리, 같은 팀원의 출장 / 휴가 / 사내업무 일정확인 , 결재 관리를 캘린더를 통해 한번에 확인 할 수 있습니다.<br />
>


<br/>

<div id="2"></div>

## 🛠️ 기술 스택

<details><summary> <b> 상세 기술스택 및 버전</b> </summary>

| 구분       | 기술스택                    | 상세내용                 | 버전          |
| -------- | ----------------------- | -------------------- | ----------- |
| 공통     | 형상관리                    | Github               | \-          |
|          | 이슈관리                   | Notion               | \-          |
|          | 커뮤니케이션                | Notion, Slack        | \-          |
| BackEnd  | DB                      | MySQL                | 8.0.28      |
|          |                         | JPA                  | \-          |
|          |                         | QueryDSL             | \-          |
|          | Java                    | JDK                  | 8           |
|          | Spring                  | Spring Boot          | 2.7.0       |
|          | IDE                     | STS                  | 3.9.15      |
|          | Cloud Storage           | AWS S3               | \-          |
|          | Build                   | Maven                | 4.0.0       |
| FrontEnd | HTML5                   |                      | \-          |
|          | CSS3                    |                      | \-          |
|          | JavaScript(ES8)         |                      | \-          |
|          | 		             | Axios                | 0.27.2      |
|          | React                   | React                | 18.2.0      |
|          | 	                     | React-Router-Dom	    | 6.3.0       |	
|          |                         | Meterial UI          | 5.10.2      |
|          |                         | SweetAlert2          | 11.4.26     |
|          |                         | FullCalendar         | 5.11.2      |
|          | IDE                     | Visual Studio Code   | 1.66.2      |
| Server   | 서버                     | AWS EC2              | \-          |
|          | 플랫폼                    | Ubuntu               | 22.04       |
|          | 배포                     | Travis ci            | \-          |
|          |                         | Ruby                 | 3.0.2       |
|          |                         | AWS CodeDeploy       | \-          |

</details>

<br />

<div id="3"></div>

## 🗂️ 시스템 아키텍처

<img width="1003" alt="프로젝트기술스택(아키텍처)" src="https://github.com/KimYongJ/GoCompany/assets/106525587/3a29c73d-fa8d-41f7-8f68-8ba1f965b9fb">


<br/>

## 데이터베이스 구조 - ERD

<img width="959" alt="데이터베이스 구조 ERD" src="https://github.com/KimYongJ/GoCompany/assets/106525587/4306803b-b90a-48e7-a326-0effd3a89714">


<br/>

## 🖥️ 주요기능

### 근태 관리
- 로그인 후 출근 버튼을 누르면 출근 상태로 전환 되고, 퇴근을 누르면 퇴근 상태로 전환 됩니다.
- 현재 출/퇴근 , 지각,  휴가 , 출장 여부는 헤더에서 확인 할 수 있습니다.


<br/>

## 👪 개발 멤버 소개 

- 백엔드 개발자 2명
- 프론트 개발자 2명

<br/>

## 📆 프로젝트 기간
### 22.7.19 ~ 22.9.27
- 기획 및 설계 : 22.7.19 ~ 22.7.29
- 프로젝트 구현 : 22.7.30 ~ 22.9.15
- 버그 수정 및 산출물 정리 : 22.9.16 ~ 27

<br />

<div id="9"></div>

## 🤔 Learned
- 프로젝트에 스프링 시큐리티를 적용함으로써 사용자 인증(Authentication)과 권한 부여(Authorization)를 관리하는 방법을 알게 됐음
- JWT 토큰의 생성과 적용 방법을 익히고 리프레시토큰을 도입해 봄으로써 토큰에 대한 이해를 높일 수 있었음.
- 이메일 발송 기능을 적용함으로써 연동 방법과 사용법을 알게 됐음
- MVC 패턴을 도입해보며, 디자인 패턴에 대한 이해를 높일 수 있었음
- Notion, Slack 등의 협업 툴을 사용해보았고 애자일 방법론을 도입하여 프로젝트를 진행할 수 있었음

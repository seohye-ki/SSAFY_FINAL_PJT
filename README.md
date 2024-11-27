<img width="1680" alt="EVERYMATCH" src="https://github.com/user-attachments/assets/44201988-96ee-4425-bca1-949d7644ae0e">
<img width="1680" alt="Screenshot 2024-11-26 at 11 51 36 AM" src="https://github.com/user-attachments/assets/1749e5e5-b573-4c58-82b5-e25a04a64ef4">

# EVERYMATCH 프로젝트 결과 보고서

---

## 프로젝트 팀 구성
<table>
  <tr>
    <td align="center"><a href="https://github.com/ljh0401"><img src="https://github.com/user-attachments/assets/1356a98e-80b6-4780-bda5-777a7e4d9cc4" width="130px;" alt=""/><br /><sub><b>이준환</b></sub></a><br /><sub><b>조장(풀스택)</b><br>ERD</br>요구사항 정의서<br>UI 제작</br>Chat gpt API<br>FullCalendar</br></sub></td>          
    <td align="center"><a href="https://github.com/seohye-ki"><img src="https://github.com/user-attachments/assets/00f751b1-36fe-4811-831f-dd2643a70652" width="106px;" alt=""/><br /><sub><b>김서현</b></sub></a><br /><sub><b>조원(풀스택)</b><br>와이어 프레임</br>로고 제작<br>UML 작성</br>JWT 토큰 인증<br>BCrypt 비밀번호 암호화</br></sub></td
  </tr>
</table><br/>


---

## 목차
1. 프로젝트 개요 및 요구사항  
2. UseCase 다이어그램  
3. 데이터베이스 테이블 구조 (ERD)  
4. 클래스 다이어그램  
5. 사용된 라이브러리 및 프레임워크  
6. 프레임워크 선택 이유  
7. 결론 및 기대효과
8. 후기

---

## 1. 프로젝트 개요 및 요구사항

### 프로젝트 개요
EVERYMATCH 프로젝트는 좋아하는 팀들의 경기 일정을 손쉽게 확인할 수 있는 플랫폼입니다. 좋아하는 팀들의 경기 일정 데이터베이스를 불러와 캘린더를 통해 간편히 확인할 수 있으며 사용자는 경기 1시간 전 이메일을 통한 알림으로 경기가 있음을 확인할 수 있습니다.

### 요구사항 정의
#### 사용자 기능
1. **회원가입**: 사용자 정보를 입력받아 계정을 생성합니다.  
2. **로그인/로그아웃**: 인증을 통해 시스템에 접근하거나 종료합니다.  
3. **회원정보 수정**: 비밀번호 재인증 후 자신의 정보를 수정합니다.
4. **비밀번호 찾기**: 비밀번호를 잊어버렸을 경우 이메일을 통해 재발급합니다.
5. **회원 탈퇴**: 더 사용하기 싫다면 탈퇴할 수 있습니다.

#### 메인 기능
1. **캘린더**: 사용자가 좋아하는 팀으로 설정한 팀들의 경기들이 많을수록 진한색으로 표시됩니다.
2. **당일 경기 확인**: 캘린더 날짜를 클릭하면 해당일의 경기들이 오른편에 보입니다.
3. **좋아하는 팀 추가/삭제**: 좋아하는 팀을 추가/삭제할 수 있습니다.
4. **경기 일정 알림**: 경기 1시간전 경기 일정을 이메일로 알림을 보내드립니다.

#### 보안 기능
1. **JWT 기반 인증**: 토큰을 통한 안전한 세션 관리를 제공합니다.  
2. **데이터 암호화**: JBcrypt를 통해 사용자 비밀번호를 안전하게 저장합니다.  

#### Chat gpt API 활용 기능
1. **좋아하는 팀 추천**: API를 통해 인공지능에게 좋아하는 팀을 추천받을 수 있습니다.
2. **파트너와 대화**: Main에서 오른쪽 하단의 버튼을 누르면 파트너와 대화할 수 있습니다.  

(API Key 별도 관리하여 실제 작동에는 .env의 APIKEY가 필요합니다.) 

---

## 2. UseCase 다이어그램

![Usecase Diagram](https://github.com/user-attachments/assets/5d138834-273a-443e-a863-8a857e08853e)

---

## 3. 데이터베이스 테이블 구조 (ERD)

![ERD-ERD ver3](https://github.com/user-attachments/assets/60b6446b-d760-4b5e-b744-796159857d27)

---

## 4. 클래스 다이어그램

![classdiagram](https://github.com/user-attachments/assets/e9bf8f4d-5318-4f02-bcdc-7e8ec83a4af5)

---

## 5. 사용된 라이브러리 및 프레임워크

### 프론트엔드
1. **Vue.js**: 사용자 인터페이스 개발  
2. **Vue Router**: 클라이언트 라우팅  
3. **Pinia**: 중앙 상태 관리  
4. **Axios**: 백엔드 API와의 통신 
5. **FullCalendar**: 캘린더 라이브러리

### 백엔드
1. **Spring Boot**: 백엔드 애플리케이션 개발  
2. **JBCrypt**: 비밀번호 해싱
3. **MyBatis**: 데이터베이스와 객체 간 매핑  
4. **JWT**: 로그인 인증


---

## 6. 프레임워크 선택 이유

### 프론트엔드
1. **Vue.js**:  
   - 가벼운 SPA(Single Page Application) 구축 가능.  
   - 코드 재사용성 및 확장성 제공.

2. **Vue Router**:  
   - 페이지 리로드 없이 빠른 라우팅.  

3. **Pinia**:  
   - 복잡한 데이터 흐름 관리 및 동기화.  

4. **Axios**:  
   - REST API와의 직관적인 통신 제공.  

### 백엔드
1. **Spring Boot**:  
   - 빠르고 간편한 설정 및 강력한 확장성.  

2. **JBCrypt**:  
   - 비밀번호 암호화로 보안 향상.

3. **MyBatis**:  
   - MySQL와의 데이터베이스 연동에 용이.  

4. **JWT**:  
   - 로그인 지속을 위한 인증.  

---

## 7. 결론 및 기대효과

### 결론
EVERYMATCH 프로젝트는 좋아하는 팀들의 경기 일정을 손쉽게 확인할 수 있는 플랫폼입니다. 좋아하는 팀들의 경기 일정을 캘린더를 통해 간편히 확인할 수 있으며, 사용자가 좋아하는 팀의 경기를 1시간 전 이메일을 통한 알림을 받을 수 있습니다.

### 기대효과
1. **사용자 경험 향상**  
   - 캘린더를 통해 좋아하는 팀의 경기 일정을 손쉽게 확인 가능.

2. **개발 효율성 증대**  
   - 최신 기술과 프레임워크를 활용하여 빠르고 안정적인 시스템 구축.  

3. **시장 경쟁력 강화**  
   - 경기 알림, 맞춤형 캘린더, 팀별 관리 기능 등을 제공함으로써 경쟁 플랫폼과 차별화.  

---

## 8. 후기

### 이준환
   - 이번 프로젝트를 진행하며 이제는 기본 틀 없이 공식 레포 wiki를 참고하면서 스스로 만들어 나갈 수 있다는 자신감을 얻을 수 있었습니다.
      특히 chat gpt api를 활용할 때, api 활용 공식 문서를 통해 request와 response가 어떠한 정보가 필요하고, 제공되는지를 파악하여 이에 필요한 dto, service, controller를 만드는 과정은 재미있었습니다.
     
     또한 지금까지 SSAFY 과정을 통해 배워왔던 Spring, Vue를 직접 활용해보면서 많은 부분에서 성장을 이룰 수 있었고, 이제는 구현을 넘어 최적화에 대한 고민이 필요함을 느꼈습니다.
     특히 Vue 프레임워크를 통해 플랫폼을 만들며, 구현을 하는 것은 큰 문제가 없으나 반복되는 코드를 재활용하지 않는 등 유지보수적 측면에서 부족한 점이 많았습니다.
     다음 프로젝트를 진행할 때에는 지금보다 좀 더 보기 편하고, 유지보수가 용이한 프로젝트를 완성하도록 노력하겠습니다.
     
     마지막으로 좋은 팀원을 만나 다툼없이 프로젝트를 진행할 수 있었음에, 면접을 준비하느라 크게 신경을 못 쓴 못난 팀장을 응원해준 조원에게 큰 감사를 표합니다.
      
### 김서현
   - 이번 프로젝트는 정말 정신없이 지나갔다. 일주일이란 짧은 기간이었는데, 한편으로는 너무 많은 걸 경험한 것 같아서 머릿속에 제대로 정리가 안 되는 느낌이다. 기록의 중요성을 다시 한 번 뼈저리게 느낀다. 스크럼 덕분에 어느 정도 정리는 했지만, 그때그때 문제를 해결하거나 새로운 걸 배울 때 바로바로 적어두는 습관이 정말 필요하다고 생각한다. 이렇게 짧은 기간에도 벌써 기억이 가물가물한데, 더 긴 프로젝트였다면 놓친 게 얼마나 많았을지 상상도 안 간다.

     이번 프로젝트에서 가장 좋았던 건, 처음부터 끝까지 내가 직접 경험해볼 수 있었다는 점이다. 기획부터 설계, 구현, 그리고 배포 빼고 거의 모든 과정을 다 해봤다. 특히 이론으로만 알던 API 명세서나 ERD 같은 것들을 직접 작성해보고, 그걸 기반으로 개발하면서 "이게 실제로 이렇게 연결되는구나!" 하는 깨달음이 너무 좋았다.

     CSS와 디자인은 정말 나를 괴롭혔던 부분 중 하나다. 솔직히 처음에는 GPT가 제안해준 Bootstrap 코드를 사용했는데, 무슨 말인지도 모르고 그냥 가져다 쓴 게 문제였다. 그러다 보니 나도 이해 못 하는 코드를 가지고 디자인이 꼬이고, 결국 반 이상을 새로 시작해야 했다. 처음부터 다시 디자인할 때는 Bootstrap에 과하게 의존하지 않고 내가 이해할 수 있는 속성들로 작업했는데, 그 덕분에 justify-content, text-align 같은 속성들을 더 자유롭게 다룰 수 있게 된 것 같다. 이 경험은 정말 값졌다. "이해하지 못하면 쓰지 말자"는 교훈도 얻었다.

     기술적으로는 MyBatis와 Spring Security가 기억에 남는다. MyBatis는 내가 직접 쿼리를 짜서 데이터베이스를 다루는 것이 장점이었다. 복잡한 쿼리도 스스로 해결할 수 있었다는 점에서 뿌듯함을 느꼈다. Spring Security는 처음에는 나를 당황하게 만들었다. 기본 암호화를 쓰다 보니 인증 과정에서 예상치 못한 문제가 생겼고, 로그인이 제대로 되지 않았다. 한때는 암호화를 포기하려고도 했지만, 결국 JBCrypt를 찾아내어 문제를 해결했다. 이 과정을 통해 "문제는 반드시 해결책이 있다"는 믿음이 생긴 것 같다.

     이번 프로젝트에서 가장 아쉬웠던 건 배포를 해보지 못한 거다. CI/CD 같은 걸 직접 다뤄볼 기회가 있었으면 더 좋았을 텐데, 일주일이라는 기간이 너무 짧아서 그 부분은 건드리지 못했다. 다음 프로젝트에서는 꼭 배포까지 포함해서 완전한 서비스를 만들어보고 싶다.

     마지막으로 협업에 대해 얘기하자면, 혼자 고민하는 시간도 물론 중요하지만, 동료와 함께 해결하는 시간이 얼마나 효율적인지 다시 깨달았다. 처음에는 내가 다 해결해야 한다는 강박도 있었지만, 동료와 대화를 나누고 도움을 받으면서 문제를 푸는 속도가 훨씬 빨라졌다. 이런 경험들이 서로에 대한 신뢰도 높여주는 것 같다.

     짧은 시간이었지만 정말 많은 걸 배운 프로젝트였다. 힘든 순간도 많았지만 결국 해냈고, 그런 경험들이 쌓이다 보니 이제는 "뭐가 안 돼도 어떻게든 해낼 수 있을 거야"라는 자신감이 생겼다. 그리고 지금은 실수를 해도 괜찮은 시간이라는 점도 다시 한번 상기하게 됐다. 앞으로도 많이 넘어지고 배우면서 더 성장하고 싶다.

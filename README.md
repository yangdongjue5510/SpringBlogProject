# SpringBlogProject
스프링 부트 기반 JDBC(MyBatis, JPA)를 활용한 프로젝트입니다.


# 구현해야 할 기능 목록

## 1. index.jsp

### 로그인 링크
1. **(완료)** 로그인 / 블로그 등록, 내 블로그로 가기 링크가 로그인 여부에 따라 서로 배타적으로 표시.
2. (**완료**) 사용자가 로그인에 성공하고 나면, 로그인 여부에 따라 블로그 등록 / 내 블로그로 가기가 배타적으로 표시
3.  (**완료**) 로그인 링크는 bloglogin.jsp로 이동.
4.  (**완료**) 블로그 등록링크는 blogcreate.jsp로 이동
5.  내 블로그로 가기 링크는 blogmain.jsp로 이동

### 검색 기능
1. 검색 조건은 블로그 제목, 태그, 블로거(회원이름)
2. 검색 결과가 없는 경우 테이블 자체가 보이면 안됨.
3. 검색된 블로그 제목을 클릭하면 해당 블로그 메인 화면으로 이동.

### 블로그 삭제 기능
1. ADMIN 권한을 가진 사람만 블로그를 삭제할 수 있음.
2. USER 권한을 가진 사용자는 삭제 칼럼 자체가 제공 안됨.

## 2. 로그인 화면 bloglogin.jsp

1. 로그인 버튼을 누르면 결과 여부 상관없이 index.jsp로 이동.
2. (완료) 로그인 성공하면 블로그 소유에 따라 블로그 생성이나 내블로그 가기 링크가 표시 (로그인링크 2참고)
3. 로그인 실패할 경우, 다시 로그인 화면으로 갈 수 있게 로그인 링크만 보임(로그인 링크 2참고)

## 3. 블로그 생성 화면 blogcreate.jsp

1. (**완료**) 블로그 제목을 입력하고 블로그 생성을 누르면 해당 회원의 블로그가 생성.
2. (**완료**) tag, cnt_display, post, status는 기본값 설정할 것.
3. (**완료**) 블로그가 만들어지면 자동으로 '미분류'카테고리가 존재하도록 함.
4. (**완료**) 인덱스 페이지로 이동 링크를 누르면 블로그를 만들지 않고 메인화면으로 이동
5. 블로그를 만들고나면 index.jsp로 이동.

## 4. 블로그 메인 blogmain.jsp

1. 블로그 상단엔 제목과 태그가 출력.

### 카테고리 별 포스트 출력
1. 포스트 목록은 카테고리 순서 없이 최신순 출력
2. 카테고리 목록에서 카테고리 중 하나를 클릭하면 해당 카테고리만 최신순 나열.
3. 카테고리 별 나열할 때 해당 카테고리의 보이기 유형(DISPLAY_TYPE)에 따라 나열(제목만, 혹은 제목과 내용)

### 포스트 별 수정, 삭제
1. 각 포스트의 제목 옆에 EDIT, DEL 링크가 제공.
2. EDIT 링크는 수정화면으로 이동.
3. DEL 링크는 해당 포스트를 삭제하고 blogmain.jsp로 돌아옴.
4. 삭제하고 돌아왔을 때 그 당시 사용자가 선택했던 카테고리를 유지할 수 있어야 함.

### 로그인 링크
1. 로그인 여부에 따라 로그인 , 로그아웃 링크를 상호 배타적으로 제공
2. 블로그 소유자가 접근 시, 로그아웃과 블로그 관리 링크를 제공
3. 다른 사용조가 접근 시, 로그아웃만 제공,
4. 로그인하지 않은 사용자가 접근시 로그인만 제공
5. 블로그 관리 링크는 blogadmin_basic.jsp로 이동

## 5. 블로그 관리 페이지 blogadmin_basic.jsp

1. 상단엔 블로그 메인과 비슷하게 블로그 제목과 태그가 출력.
2. 오른쪽에 로그아웃과 내 블로그 메인 링크 제공.
3. 내 블로그 메인은 blogmain.jsp로 이동
4. 중간에 기본설정, 카테고리, 글작성 삭제요청 메뉴가 제공.

### 기본설정 blogadmin_basic.jsp
1. 블로그 제목, 태그, 메인 페이지 포스트 갯수를 수정 가능하도록 폼 제공,
2. 블로그 이미지 보여주도록 하나 바꿀 순 없다.
3. 확인 버튼을 누르면 입력값대로 블로그 내용을 수정하고 blogmain.jsp로 이동

### 카테고리 관리 페이지 blogadmin_category.jsp
1. 관리 페이지에서 카테고리 메뉴를 선택했을 때 표시
2. 카테고리들을 표에 담아서 표시
3. 미분류 카테고리는 삭제 불가
4. 카테고리 목록 가장 오른쪽 x이미지를 통해 삭제가능
5. 카테고리 아래엔 카테고리를 추가할 수 있는 공간이 존재

#### 카테고리 추가
1. 카테고리명, 보이기 유형, 포스트 수, 설명 이렇게 네가지로 받는다.
2. 카테고리 추가 버튼을 누르면 카테고리 관리 페이지를 반영해서 다시 표시

#### 카테고리 수정
1. 카테고리 목록 중 카테고리 이름을 클릭하면 카테고리 등록에서 카테고리 수정으로 버튼이름이 변경
2. 폼 데이터 내용도 해당 카테고리가 가진 값으로 채워짐
3. 카테고리 수정 버튼을 누르면, 카테고리 관리 페이지에 반영해서 카테고리 추가 폼으로 초기화되서 표기

### 포스트 관리 페이지 adminPost.jsp
1. 관리 페이지에서 글 작성 메뉴를 클릭하면 나오는 화면
2. 제목, 카테고리, 내용을 입력받고 확인을 누르면 포스트가 등록되고, blogmain.jsp로 이동.

#### EDIT
1. 블로그 메인화면에서 포스트의 EDIT를 누르면 해당 포스트를 수정할 수 있는 adminPost.jsp로 이동
2. 폼 데이터에 해당 포스트의 정보가 담기고 확인 버튼은 수정하기로 바꾸어서 출력.
3. 수정하기를 누르면 포스트가 수정되고, 메인으로 이동.
4. 이때 빈 내용이 있으면 다시 입력받도록 포워딩해줘야 함.

# 일정 관리 API 프로젝트

이 프로젝트는 Spring Boot와 JPA를 사용해서 일정을 생성, 조회, 수정, 삭제(CRUD)할 수 있는 간단한 REST API를 구현한 것입니다.

처음에는 Spring 프로젝트 구조와 흐름이 잘 이해되지 않았기 때문에, 기능을 한 번에 많이 구현하기보다는 Step 단위로 나누어 하나씩 직접 만들어보고 Postman으로 확인하면서 진행했습니다.

---

## API 명세

### 1. 일정 생성

* Method: POST
* URL: /api/schedules
* Request Body (JSON)

```json
{
  "title": "첫 일정",
  "content": "공부하기",
  "author": "지민",
  "password": "1234"
}
```

* Response Body (JSON)

```json
{
  "id": 1,
  "title": "첫 일정",
  "content": "공부하기",
  "author": "지민"
}
```

---

### 2. 전체 일정 조회

* Method: GET

* URL: /api/schedules

* Response Body (JSON)

```json
[
  {
    "id": 1,
    "title": "첫 일정",
    "content": "공부하기",
    "author": "지민"
  }
]
```

---

### 3. 단건 일정 조회

* Method: GET

* URL: /api/schedules/{id}

* 성공 Response (200)

```json
{
  "id": 1,
  "title": "첫 일정",
  "content": "공부하기",
  "author": "지민"
}
```

* 실패 Response (404)

```
해당 일정이 없습니다.
```

---

### 4. 일정 수정

* Method: PUT

* URL: /api/schedules/{id}

* Request Body (JSON)

```json
{
  "title": "수정한 제목",
  "content": "수정한 내용",
  "password": "1234"
}
```

* Response Body (JSON)

```json
{
  "id": 1,
  "title": "수정한 제목",
  "content": "수정한 내용",
  "author": "지민"
}
```

---

### 5. 일정 삭제

* Method: DELETE

* URL: /api/schedules/{id}

* Request Body (JSON)

```json
{
  "password": "1234"
}
```

* Response

```
삭제 완료
```

---

## ERD

이 프로젝트에서는 일정(Schedule) 단일 엔티티를 사용합니다.

### Schedule

| 컬럼명      | 타입      | 설명             |
| -------- | ------- | -------------- |
| id       | BIGINT  | 일정 ID (PK)     |
| title    | VARCHAR | 일정 제목          |
| content  | VARCHAR | 일정 내용          |
| author   | VARCHAR | 작성자            |
| password | VARCHAR | 수정/삭제 검증용 비밀번호 |

* 하나의 일정은 하나의 작성자와 내용을 가집니다.
* 수정 및 삭제 시 비밀번호를 통해 권한을 검증합니다.  

[tistory 링크]  
https://jiiimni.tistory.com/38  

[velog 링크]  
https://velog.io/@jiiim_ni/%EB%82%B4%EC%9D%BC%EB%B0%B0%EC%9B%80%EC%BA%A0%ED%94%84-Spring3%EA%B8%B0-CH3-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-%EC%95%B1-%EB%A7%8C%EB%93%A4%EA%B8%B0-%ED%95%84%EC%88%98-%EA%B8%B0%EB%8A%A5

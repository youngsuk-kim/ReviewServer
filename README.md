## 요구 사항

### 리뷰 등록 수정 삭제
- [ ] 리뷰는 배달 리뷰, 메뉴 리뷰, 리뷰 이미지, 리뷰 내용, 별점으로 구성됩니다.
- [ ] 리뷰 C/U/D가 발생하면 리뷰 변경 이벤트를 발행합니다.
- [ ] 모든 리뷰 데이터는 히스토리가 관리되어야 합니다.
### 리뷰 조회
- [ ] 정렬 조건(최신, 좋아요순)
- [ ] 필터 조건(사진이 있는 리뷰, 좋아요가 있는 리뷰)
### 리뷰 좋아요
- [ ] 리뷰 좋아요 등록/ 취소
### 가계 리뷰 통계
- [ ] 가게 리뷰 통계
### 인프라
- [ ] CI, 로깅 설정, 배포

## 사용 기술
- Kotlin
- SpringBoot 3.x, Gradle
- Spring Data JPA
- QueryDSL
- MySQL, H2
- Naver Cloud Platform

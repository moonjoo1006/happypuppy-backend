CREATE TABLE user
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '아이디',
    nickname          VARCHAR(100) NOT NULL COMMENT '닉네임',
    profile_image_url VARCHAR(255) COMMENT '프로필이미지url',
    gender            VARCHAR(10) COMMENT '성별',
    age               INT COMMENT '생년',
    age_type          VARCHAR(16) COMMENT '나이 타입',
    app_user_id       BIGINT COMMENT '앱유저아이디',
    introduce         VARCHAR(255) COMMENT '자기소개',
    address           VARCHAR(16) COMMENT '주소',
    phone_number      VARCHAR(16) COMMENT '전화번호',
    show_phone_number TINYINT(1) DEFAULT 0 COMMENT '전화번호 공개 여부',
    created_at        TIMESTAMP  DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updated_at        TIMESTAMP  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='유저 정보 테이블';


CREATE TABLE place
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '아이디',
    name           VARCHAR(32)  NULL COMMENT '이름',
    place_type     VARCHAR(32)  NULL COMMENT '장소 타입',
    address        VARCHAR(255) NULL COMMENT '지번 주소',
    road_address   VARCHAR(255) NULL COMMENT '도로명 주소',
    latitude       DOUBLE       NULL COMMENT '위도',
    longitude      DOUBLE       NULL COMMENT '경도',
    location       POINT        NULL SRID 4326,
    contact        VARCHAR(32)  NULL COMMENT '전화번호',
    homepage       VARCHAR(64)  NULL COMMENT '홈페이지',
    off_days       VARCHAR(128) NULL COMMENT '휴무일',
    operation_time VARCHAR(128) NULL COMMENT '영업시간',
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='장소 정보 테이블';


CREATE TABLE chat
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    place_id   BIGINT      NOT NULL comment '장소 아이디',
    status     VARCHAR(16) NOT NULL COMMENT '채팅방 상태',
    name       VARCHAR(32) NOT NULL COMMENT '채팅방 이름',
    occupy     INT         NOT NULL COMMENT '최대 인원',
    owner      BIGINT      NOT NULL COMMENT '방장 아이디',
    meet_at    TIMESTAMP   NOT NULL COMMENT '약속일',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='채팅방 정보 테이블';

CREATE TABLE chat_member
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    status     VARCHAR(16) NOT NULL,
    chat_id    BIGINT      NOT NULL,
    user_id    BIGINT      NOT NULL,
    owner      TINYINT(1)  NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='채팅방 멤버 정보 테이블';
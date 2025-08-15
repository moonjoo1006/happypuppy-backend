use pet;
drop table place;

INSERT INTO place (id, name, place_type, address, loadAddress, latitude, longitude, location, contact, homepage,
                   offDays,
                   operationTime)
VALUES (1, '분당중앙공원 애완견 놀이터', 'PARK', '경기도 성남시 분당구 수내동 65', '경기도 성남시 분당구 경기도 성남시 분당구 성남대로 550',
        37.377266, 127.123758, ST_GeomFromText('POINT(37.377266 127.123758)', 4326), '0317294907',
        'http://www.seongnam.go.kr/parks/park/parkView.do?parkId=100', null, null),
       (2, '율동공원', 'PARK', '경기도 성남시 분당구 율동 399', '경기도 성남시 분당구 율동 399',
        37.377686, 127.151387, ST_GeomFromText('POINT(37.377686 127.151387)', 4326), '0317028713',
        'http://www.ydpark.co.kr', null, null);

select * from place;

INSERT INTO store (name, address, location)
VALUES ('예시 매장',
        '경기도 성남시 분당구...',
        POINT(127.123758, 37.377266));



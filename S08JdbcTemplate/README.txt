[S08JdbcTemplate]

1. DataSource
2. JdbcTemplate 쿼리
3. DB 관련 Exception
4. Transaction 처리

(MEMBER TABLE)
drop table member;
create table member (
    ID number not null,
    NAME VARCHAR2(30) NOT NULL,
    EMAIL VARCHAR2(50),
    PASSWORD VARCHAR2(100),
    REGDATE DATE default sysdate,
    CONSTRAINT MEMBER_PK primary key(id)
);

(MEMBER_SEQ SEQUENCE)
drop sequence member_id_seq;
Create Sequence member_id_seq (
	START with 1
	INCREMENTE BY 1
	Maxvalue 99999
	NOCYCLE;


INSERT INTO MEMBER(email, password, name, regdate, id) VALUES (,,,default,member_id_seq.nextval)

(mysql)
DataSource ds = new DataSource();
ds.setDriverClassName("com.mysql.jdbc.Driver");
ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
ds.setUsername("HELLOUSER");
ds.setPassword("HELLOUSER");
ds.setInitialSize(2);
ds.setMaxActive(10);
ds.setTestWhileIdle(true);
ds.setMinEvictableIdleTimeMillis(60000 * 3);
ds.setTimeBetweenEvictionRunsMillis(10 * 1000);

(oracle)
DataSource ds = new DataSource();
ds.setDriverClassName("oracle.jdbc.OracleDriver");
ds.setUrl("jdbc:oracle:thin:@localhost:8587:xe");
ds.setUsername("HELLOUSER");
ds.setPassword("HELLOUSER");
ds.setInitialSize(2);
ds.setMaxActive(10);
ds.setTestWhileIdle(true);
ds.setMinEvictableIdleTimeMillis(60000 * 3);
ds.setTimeBetweenEvictionRunsMillis(10 * 1000);



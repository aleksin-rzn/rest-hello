CREATE USER super IDENTIFIED BY abcd1234;
GRANT ALL PRIVILEGES TO super;

CREATE TABLE SUPER.LOGS (
  ID NUMBER NOT NULL,
  MESSAGE VARCHAR2(30) NOT NULL,
  INSERTED_DATE DATE NOT NULL,
  CONSTRAINT LOGS_PK PRIMARY KEY (ID)
);

CREATE SEQUENCE SUPER.LOGS_SEQ INCREMENT BY 1 START WITH 1;

CREATE OR REPLACE FUNCTION SUPER.SET_LOG(MESSAGE IN VARCHAR2) RETURN NUMBER AS
NORMAL_STR varchar2(30);
LOG_ID NUMBER;
BEGIN
  NORMAL_STR := SUBSTR(MESSAGE, 0, 30);
  SELECT LOGS_SEQ.NEXTVAL INTO LOG_ID FROM DUAL;
  INSERT INTO LOGS(ID, MESSAGE, INSERTED_DATE) VALUES(LOG_ID, NORMAL_STR, SYSDATE);
  RETURN LOG_ID;
END SET_LOG;
/
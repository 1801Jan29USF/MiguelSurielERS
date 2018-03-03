---- created user role completed
CREATE TABLE ERS_USER_ROLES
(ERS_USER_ROLE_ID NUMBER PRIMARY KEY, USER_ROLE VARCHAR2(10) NOT NULL);


---- test user role --- 
INSERT INTO ERS_USER_ROLES (ERS_USER_ROLE_ID, USER_ROLE) VALUES (1, 'FManager');
INSERT INTO ERS_USER_ROLES (ERS_USER_ROLE_ID, USER_ROLE) VALUES (2, 'Employee');






------- created ers users table completed

CREATE TABLE ERS_USERS
(ERS_USERS_ID NUMBER PRIMARY KEY, ERS_USERNAME VARCHAR2(40) UNIQUE NOT NULL,
ERS_PASSWORD VARCHAR2(30) NOT NULL, USER_FIRST_NAME VARCHAR2(10) NOT NULL, 
USER_LAST_NAME VARCHAR2(10) NOT NULL, USER_EMAIL VARCHAR2(40) NOT NULL UNIQUE, 
USER_ROLE_ID NUMBER NOT NULL,
CONSTRAINT USER_ROLES_FK FOREIGN KEY (USER_ROLE_ID) REFERENCES ERS_USER_ROLES(ERS_USER_ROLE_ID));


----- test ers users creation ---
INSERT INTO ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) 
VALUES (ERS_USERS_ID_SEQ.nextVal,'Manager1','FManager123','Finance','Manager','Manager1@gmail.com', 1);

---- test searching for user
SELECT * FROM ERS_USERS WHERE ERS_USERNAME='FManager' AND ERS_PASSWORD='FManager123';




---- created ers reimbursement type
CREATE TABLE ERS_REIMBURSEMENT_TYPE
(REIMB_TYPE_ID NUMBER PRIMARY KEY, REIMB_TYPE VARCHAR2(10) NOT NULL);

----- created category for reimbursement type 
INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID, REIMB_TYPE) VALUES (1, 'LODGING');
INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID, REIMB_TYPE) VALUES (2, 'TRAVEL');
INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID, REIMB_TYPE) VALUES (3, 'FOOD');
INSERT INTO ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID, REIMB_TYPE) VALUES (4, 'OTHER');



----- created ers reimbursement status
CREATE TABLE ERS_REIMBURSEMENT_STATUS
(REIMB_STATUS_ID NUMBER PRIMARY KEY, REIMB_STATUS VARCHAR2(10) NOT NULL);

--- test reimbursement status ---
INSERT INTO ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID, REIMB_STATUS) VALUES (1, 'Pending');
INSERT INTO ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID, REIMB_STATUS) VALUES (2, 'Approved');
INSERT INTO ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID, REIMB_STATUS) VALUES (3, 'Denied');




------ reimbursement table completed
CREATE TABLE ERS_REIMBURSEMENT (
  REIMB_ID number PRIMARY KEY,
  REIMB_AMOUNT number NOT NULL,
  REIMB_SUBMITTED timestamp NOT NULL,
  REIMB_RESOLVED timestamp,
  REIMB_DESCRIPTION varchar2(250),
  REIMB_AUTHOR number NOT NULL,
  REIMB_RESOLVER number,
  REIMB_STATUS_ID number NOT NULL,
  REIMB_TYPE_ID number NOT NULL,
  CONSTRAINT ERS_USERS_AUTH_FK FOREIGN KEY (REIMB_AUTHOR)
  REFERENCES ERS_USERS(ERS_USERS_ID),  
  CONSTRAINT ERS_USERS_RESOLVER_FK FOREIGN KEY (REIMB_RESOLVER)
  REFERENCES ERS_USERS(ERS_USERS_ID),
  CONSTRAINT ERS_REIMBURSEMENT_STATUS_FK FOREIGN KEY (REIMB_STATUS_ID)
  REFERENCES ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),
  CONSTRAINT ERS_REIMBURSEMENT_TYPE_FK FOREIGN KEY (REIMB_TYPE_ID)
  REFERENCES ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID));

-----------------

------- Creation of the sequence 
CREATE SEQUENCE REIMB_ID START WITH 1;
CREATE SEQUENCE ERS_USERS_ID START WITH 1;


----- Stored Procedure



----- Created a procedure that creates users ---- This works!
CREATE OR REPLACE PROCEDURE CREATE_ERS_USERS
(ERS_USERS_ID NUMBER, ERS_USERNAME VARCHAR2, ERS_PASSWORD VARCHAR2, 
USER_FIRST_NAME VARCHAR2, USER_LAST_NAME VARCHAR2,
USER_EMAIL VARCHAR2, USER_ROLE_ID NUMBER)
IS
BEGIN 
   INSERT INTO ERS_USERS (ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, 
   USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
   VALUES(ERS_USERS_ID_SEQ.nextVal,ERS_USERNAME,ERS_PASSWORD,USER_FIRST_NAME,
   USER_LAST_NAME,USER_EMAIL,USER_ROLE_ID); 
   END CREATE_ERS_USERS;
   
 


----- a procedure that make users --- 
CREATE OR REPLACE PROCEDURE CREATE_ERS_REIMBURSEMENT
(REIMB_ID NUMBER, REIMB_AMOUNT NUMBER, REIMB_SUBMITTED TIMESTAMP, REIMB_RESOLVED TIMESTAMP, REIMB_DESCRIPTION VARCHAR2, REIMB_STATUS_ID NUMBER,
REIMB_RESOLVER NUMBER, REIMB_TYPE_ID NUMBER, REIMB_AUTHOR NUMBER)
IS
BEGIN
INSERT INTO ERS_REIMBURSEMENT (REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_STATUS_ID,
REIMB_RESOLVER, REIMB_TYPE_ID, REIMB_AUTHOR)
VALUES (REIMB_ID_SEQ.nextVal, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED,
REIMB_DESCRIPTION, REIMB_STATUS_ID, REIMB_RESOLVER, REIMB_TYPE_ID, REIMB_AUTHOR);
END CREATE_ERS_REIMBURSEMENT;











------- triggers --------
---- trigger sequence for reimb
create or replace TRIGGER reimb_id_trig
BEFORE INSERT OR UPDATE ON ERS_REIMBURSEMENT
FOR EACH ROW
BEGIN
   IF INSERTING THEN
       SELECT REIMB_ID.nextVal INTO : new.REIMB_ID FROM dual;
   ELSIF UPDATING THEN
       SELECT :old.REIMB_ID INTO :new.REIMB_ID FROM dual;
   END IF;
END;

---- trigger sequence for user

create or replace TRIGGER USER_ID_TRIG
BEFORE INSERT OR UPDATE ON ERS_USERS
FOR EACH ROW
BEGIN
   IF INSERTING THEN
       SELECT ERS_USERS_ID.NEXTVAL INTO : NEW.ERS_USERS_ID FROM DUAL;
   ELSIF UPDATING THEN
       SELECT :OLD.ERS_USERS_ID INTO :NEW.ERS_USERS_ID FROM DUAL;
   END IF;
END;































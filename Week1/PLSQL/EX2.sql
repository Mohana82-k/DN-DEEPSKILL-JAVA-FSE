CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER(12,2)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(100),
    DepartmentID NUMBER,
    Salary NUMBER(12,2)
);

INSERT INTO Accounts VALUES (101,1,'Savings',5000);
INSERT INTO Accounts VALUES (102,2,'Savings',12000);
INSERT INTO Accounts VALUES (103,3,'Current',8000);
INSERT INTO Accounts VALUES (104,4,'Savings',15000);

INSERT INTO Employees VALUES (1,'Rahul',10,50000);
INSERT INTO Employees VALUES (2,'Priya',10,45000);
INSERT INTO Employees VALUES (3,'Arun',20,60000);
INSERT INTO Employees VALUES (4,'Divya',20,55000);

COMMIT;

-- Scenario 1

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM Accounts;

-- Scenario 2

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_DepartmentID IN NUMBER,
    p_BonusPercent IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE DepartmentID = p_DepartmentID;

    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus(10,10);
END;
/

SELECT * FROM Employees;

-- Scenario 3

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_FromAccount IN NUMBER,
    p_ToAccount IN NUMBER,
    p_Amount IN NUMBER
)
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    IF v_Balance >= p_Amount THEN
        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
    END IF;
END;
/

BEGIN
    TransferFunds(101,102,1000);
END;
/

SELECT * FROM Accounts;
SELECT * FROM Employees;
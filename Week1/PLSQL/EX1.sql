CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER(12,2),
    IsVIP VARCHAR2(5)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER(5,2),
    DueDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
INSERT INTO Customers VALUES (1,'Rahul',65,15000,'FALSE');
INSERT INTO Customers VALUES (2,'Priya',45,8000,'FALSE');
INSERT INTO Customers VALUES (3,'Arun',70,20000,'FALSE');
INSERT INTO Customers VALUES (4,'Divya',30,5000,'FALSE');

INSERT INTO Loans VALUES (101,1,10,SYSDATE+15);
INSERT INTO Loans VALUES (102,2,12,SYSDATE+40);
INSERT INTO Loans VALUES (103,3,11,SYSDATE+20);
INSERT INTO Loans VALUES (104,4,13,SYSDATE+10);

COMMIT;
SELECT * FROM Customers;
SELECT * FROM Loans;

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Age
        FROM Customers;

BEGIN
    FOR cust IN c_customers LOOP
        IF cust.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance
        FROM Customers;

BEGIN
    FOR cust IN c_customers LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

DECLARE
    CURSOR c_loans IS
        SELECT LoanID, CustomerID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR loan_rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ' || loan_rec.CustomerID ||
            ' has a loan due on ' || loan_rec.DueDate
        );
    END LOOP;
END;
/
SELECT CustomerID, CustomerName
FROM Customers
WHERE IsVIP = 'TRUE';
SELECT LoanID, CustomerID, DueDate
FROM Loans
WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30;
# OracleDatabaseManagement 🍵🔗🗃️

🎯 This project is developed in Java 🍵 and its main objective is to connect and manipulate data from an Oracle database 🗃️.

## ⚙️ How it works?

🧑🏼‍💻 After correctly configuring with *jdbc11.jar*, Java connects to the database through the class in the **DAO package**.

👉🏼 *All connections are made through classes located in the DAO package.*

🔗 Once connected, the algorithm can retrieve all data from the **T_SIP_CLIENTE** or **T_SIP_ENDERECO** table.

⚠️ Below you can find the SQL commands used to create the database tables, sequences, and all their constraints.

``` 
CREATE SEQUENCE SEQ_CLIENTE
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE SEQ_ENDERECO
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE T_SIP_ENDERECO (
    CD_ENDERECO NUMBER DEFAULT SEQ_ENDERECO.NEXTVAL PRIMARY KEY,
    NM_RUA VARCHAR2(60) NOT NULL,
    NM_BAIRRO VARCHAR2(60) NOT NULL,
    NR_CASA NUMBER(10) NOT NULL
);

CREATE TABLE T_SIP_CLIENTE (
    CD_CLIENTE NUMBER DEFAULT SEQ_CLIENTE.NEXTVAL PRIMARY KEY,
    NM_CLIENTE VARCHAR2(60) NOT NULL,
    NR_CPF VARCHAR2(20) UNIQUE NOT NULL,
    DT_NASC DATE NOT NULL,
    DS_EMAIL VARCHAR2(60),
    NR_TELEFONE VARCHAR2(30) NOT NULL,
    CD_ENDERECO NUMBER NOT NULL,
    CONSTRAINT FK_CLIENTE_ENDERECO FOREIGN KEY (CD_ENDERECO) REFERENCES T_SIP_ENDERECO (CD_ENDERECO)
);

```
▶️ This project started as part of an activity at my college.

The database I connect to to perform all tests *is **private***, so I can't make it available here. So, if you want to use the algorithm for testing, you will have to have access to an Oracle database and follow the steps below👇🏼:

1. Change the **YOUR_BD** part ***to your database name***: ```URL = "jdbc:oracle:thin:@oracle.YOUR_BD:1521:orcl"```  
2. Change the **USER** to ***your database user***: ```USER = "USER"```  
3. change the **PSWD** to ***your database password***: ```PSWD = "PSSWD"```

❗Everything listed above is located inside the ***DAO** package in **Connect.java***

🎉 You're all set!

😁 Thank you!

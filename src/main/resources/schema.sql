DROP TABLE IF EXISTS wallets;

CREATE TABLE IF NOT EXISTS wallets (
         uuid CHAR(36) PRIMARY KEY,
         name VARCHAR(100) NOT NULL,
         balance NUMERIC(15,4) NOT NULL
);
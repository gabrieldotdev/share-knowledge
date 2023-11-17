-- USE PostgreSQL

-- Create Database TheKnowledgeBank on the server instance localhost with PostgreSQL
CREATE DATABASE TheKnowledgeBank_testdb WITH OWNER = postgres ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION
    LIMIT = -1 IS_TEMPLATE = False;
------------------------AFTER CREATE DATABASE, CREATE SCHEMA------------------------
-- Create schema Auth
DROP SCHEMA IF EXISTS Auth CASCADE;
CREATE SCHEMA IF NOT EXISTS Auth AUTHORIZATION postgres;

-- Create table Auth.Roles
DROP TABLE IF EXISTS Auth.Roles CASCADE;
CREATE TABLE IF NOT EXISTS Auth.Roles
(
    Id SERIAL PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Description VARCHAR(255) NOT NULL DEFAULT ''
);

-- Create table Auth.Users
DROP TABLE IF EXISTS Auth.Users CASCADE;
CREATE TABLE IF NOT EXISTS Auth.Users
(
    Id        SERIAL PRIMARY KEY,
    FirstName VARCHAR(50)  NOT NULL,
    LastName  VARCHAR(50)  NOT NULL,
    Username  VARCHAR(50)  NOT NULL UNIQUE,
    Password  VARCHAR(50)  NOT NULL,
    Email     VARCHAR(255) NOT NULL UNIQUE,
    Role      INT          NOT NULL,
    DateJoin  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (Role) REFERENCES Auth.Roles (Id)
);

-- Create table Documents
DROP TABLE IF EXISTS Documents CASCADE;
CREATE TABLE IF NOT EXISTS Documents
(
    Id            SERIAL PRIMARY KEY,
    Name          VARCHAR(50)  NOT NULL,
    Description   VARCHAR(255) NOT NULL DEFAULT '',
    File          VARCHAR(255) NOT NULL DEFAULT '',
    FileType      VARCHAR(50)  NOT NULL DEFAULT '',
    CountDownload INT          NOT NULL DEFAULT 0,
    PublishedOn   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdatedOn     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UserId        INT          NOT NULL,
    FOREIGN KEY (UserId) REFERENCES Auth.Users (Id)
);
-- Create table Categories
DROP TABLE IF EXISTS Categories CASCADE;
CREATE TABLE IF NOT EXISTS Categories
(
    Id          SERIAL PRIMARY KEY,
    Name        VARCHAR(50)  NOT NULL UNIQUE,
    Description VARCHAR(255) NOT NULL DEFAULT '',
    PublishedOn TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdatedOn   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);
-- Create table Comments
DROP TABLE IF EXISTS Comments CASCADE;
CREATE TABLE IF NOT EXISTS Comments
(
    Id          SERIAL PRIMARY KEY,
    Content     TEXT      NOT NULL,
    PublishedOn TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdatedOn   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UserId      INT       NOT NULL,
    DocumentId  INT       NOT NULL,
    FOREIGN KEY (UserId) REFERENCES Auth.Users (Id),
    FOREIGN KEY (DocumentId) REFERENCES Documents (Id)
);
-- Create table Replies
DROP TABLE IF EXISTS Replies CASCADE;
CREATE TABLE IF NOT EXISTS Replies
(
    Id          SERIAL PRIMARY KEY,
    Content     TEXT      NOT NULL,
    PublishedOn TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdatedOn   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UserId      INT       NOT NULL,
    CommentId   INT       NOT NULL,
    FOREIGN KEY (UserId) REFERENCES Auth.Users (Id),
    FOREIGN KEY (CommentId) REFERENCES Comments (Id)
)
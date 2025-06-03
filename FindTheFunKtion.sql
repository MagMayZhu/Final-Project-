-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/5xMfvX
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.


CREATE TABLE "Users" (
    "UsersID" int   NOT NULL UNIQUE,
    "firstName" varchar(255) NOT NULL,
    "lastName" varchar(255)   NOT NULL,
    "Email" varchar(400)   NOT NULL UNIQUE,
    "Password" Hash   NOT NULL,
    "RoleID" int   NOT NULL,
    CONSTRAINT "pk_Users" PRIMARY KEY (
        "UsersID"
     )
);

CREATE TABLE "Role" (
    "RoleID" int   NOT NULL UNIQUE,
    "Clerance" String   NOT NULL
);

CREATE TABLE "Location" (
    "LocationID" int   NOT NULL UNIQUE,
    "houseNumber" varchar(400)   NOT NULL,
    "Street" varchar(400)   NOT NULL,
    "Zipcode" varchar(400)   NOT NULL,
    "City" varchar(400)   NOT NULL,
    "SecondaryAddress" varchar(400)   NOT NULL
);

CREATE TABLE "Events" (
    "EventID" int   NOT NULL UNIQUE,
    "Name" varchar(400)   NOT NULL,
    "Location" varchar(400)   NOT NULL,
    "Host" varchar(400)   NOT NULL,
    "Date" varchar(400)   NOT NULL,
    "Time" varchar(400)   NOT NULL,
    "FiltersID" int   NOT NULL
);

CREATE TABLE "Filter" (
    "FilterID" int   NOT NULL UNIQUE,
    "Description" string   NOT NULL,
    "Food" boolean   NOT NULL,
    "Free" boolean   NOT NULL,
    "Sport" boolean   NOT NULL,
    "Club" boolean   NOT NULL,
    "offCampus" boolean   NOT NULL,
    "Party" boolean   NOT NULL
);

CREATE TABLE "Host" (
    "HostID" int   NOT NULL UNIQUE,
    "User(s)" int   NOT NULL
);

ALTER TABLE "Users" ADD CONSTRAINT "fk_Users_RoleID" FOREIGN KEY("RoleID")
REFERENCES "Role" ("RoleID");

ALTER TABLE "Events" ADD CONSTRAINT "fk_Events_Location" FOREIGN KEY("Location")
REFERENCES "Location" ("LocationID");

ALTER TABLE "Events" ADD CONSTRAINT "fk_Events_Host" FOREIGN KEY("Host")
REFERENCES "Host" ("HostID");

ALTER TABLE "Events" ADD CONSTRAINT "fk_Events_FiltersID" FOREIGN KEY("FiltersID")
REFERENCES "Filter" ("FilterID");

ALTER TABLE "Host" ADD CONSTRAINT "fk_Host_User(s)" FOREIGN KEY("User(s)")
REFERENCES "Users" ("UsersID");


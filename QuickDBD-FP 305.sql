-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/5xMfvX
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.


CREATE TABLE "Users" (
    "UsersID" int   NOT NULL,
    "firstName" String   NOT NULL,
    "lastName" String   NOT NULL,
    "Email" String   NOT NULL,
    "Password" Hash   NOT NULL,
    "RoleID" int   NOT NULL,
    CONSTRAINT "pk_Users" PRIMARY KEY (
        "UsersID"
     )
);

CREATE TABLE "Role" (
    "RoleID" int   NOT NULL,
    "Clerance" String   NOT NULL
);

CREATE TABLE "Location" (
    "LocationID" int   NOT NULL,
    "houseNumber" string   NOT NULL,
    "Street" string   NOT NULL,
    "Zipcode" string   NOT NULL,
    "City" String   NOT NULL,
    "SecondaryAddress" String   NOT NULL
);

CREATE TABLE "Events" (
    "EventID" int   NOT NULL,
    "Name" String   NOT NULL,
    "Location" string   NOT NULL,
    "Host" int   NOT NULL,
    "Date" String   NOT NULL,
    "Time" String   NOT NULL,
    "FiltersID" int   NOT NULL
);

CREATE TABLE "Filter" (
    "FilterID" int   NOT NULL,
    "Description" string   NOT NULL,
    "Food" boolean   NOT NULL,
    "Free" boolean   NOT NULL,
    "Sport" boolean   NOT NULL,
    "Club" boolean   NOT NULL,
    "offCampus" boolean   NOT NULL,
    "Party" boolean   NOT NULL
);

CREATE TABLE "Host" (
    "HostID" int   NOT NULL,
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


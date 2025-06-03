-- Active: 1748885272363@@localhost@5432@JEEMM305

-- 1. USERS TABLE
CREATE TABLE "Users" (
    "usersid" SERIAL PRIMARY KEY,
    "firstname" VARCHAR(255) NOT NULL,
    "lastname" VARCHAR(255) NOT NULL,
    "email" VARCHAR(400) NOT NULL UNIQUE,
    "password" TEXT NOT NULL,
    "name" VARCHAR(255) DEFAULT NULL,
    "profile_picture" TEXT DEFAULT 'default_profile.jpg',
    "bio" VARCHAR(200) DEFAULT 'Add bio here'
);

-- 2. LOCATIONS TABLE
CREATE TABLE "Locations" (
    "locationid" SERIAL PRIMARY KEY,
    "house_number" VARCHAR(50),
    "street" VARCHAR(255),
    "secondary_address" VARCHAR(255),
    "city" VARCHAR(100),
    "state" VARCHAR(100),
    "zipcode" VARCHAR(20)
);

-- 3. TAGS TABLE (shared between users and events)
CREATE TABLE "Tags" (
    "tagid" SERIAL PRIMARY KEY,
    "tag_name" VARCHAR(50) UNIQUE NOT NULL
);

-- 4. EVENTS TABLE
CREATE TABLE "Events" (
    "eventid" SERIAL PRIMARY KEY,
    "picture" TEXT,
    "event_name" VARCHAR(255) NOT NULL,
    "event_date" VARCHAR(50) NOT NULL, -- you can later cast to DATE if needed
    "event_time" VARCHAR(50) NOT NULL,
    "locationid" INT REFERENCES "Locations"("locationid") ON DELETE SET NULL,
    "hostid" INT REFERENCES "Users"("usersid") ON DELETE CASCADE,
    "description" TEXT
);

-- 5. USER TAGS (User Interests)
CREATE TABLE "UserTags" (
    "usersid" INT REFERENCES "Users"("usersid") ON DELETE CASCADE,
    "tagid" INT REFERENCES "Tags"("tagid") ON DELETE CASCADE,
    PRIMARY KEY ("usersid", "tagid")
);

-- 6. EVENT TAGS (Event Filters)
CREATE TABLE "EventTags" (
    "eventid" INT REFERENCES "Events"("eventid") ON DELETE CASCADE,
    "tagid" INT REFERENCES "Tags"("tagid") ON DELETE CASCADE,
    PRIMARY KEY ("eventid", "tagid")
);

INSERT INTO "Tags" (tag_name) VALUES
('party'), ('club'), ('sport'), ('event'), ('art'), ('food');

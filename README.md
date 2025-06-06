# Final-Project-
Find the FunKtion. 

# Setup

Prerequisites:
Ensure that your Java version is up to date (version 20 or later).
Steps:
Install PostgreSQL and configure it with your own password. Make sure your PostgreSQL server is running.
Note: You will need the port number later for pgAdmin 4.

1. Download pgAdmin 4 – The easiest way is to download it from the official website.
2. Open pgAdmin 4, right-click on "Servers" and select "Register" > "Server".
3. Under the "Name" field, enter: JEEMM305.
4. Under the "Connection" tab:
5. For "Host name/address", enter: localhost.
6. For "Maintenance database", ensure it says: postgres.
7. Set the username depending on your operating system:
 Mac:

 Use your computer’s username (found under System Settings > Users & Groups, then right-click your profile to view the username).

Windows:

Use postgres as the username.

8. Set your password.

Currently, in our config.properties, you can set your username and password manually to run the application.
Note: In future versions, this will be encrypted for security.

Input our database information under:

Schemas
Tables
And load the provided SQL file

9. Congratulations! You now have a connected local database.

Note: We were not able to establish a shared database for all group members. However, if each person hosts a local server as described above, the application will function correctly. In future implementations, we plan to connect all users to a central database.
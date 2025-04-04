// Initialize database and create user
var db = db.getSiblingDB('users');

db.createUser({
    user: 'development',
    pwd: 'development',
    roles: [
        {
            role: "readWrite",
            db: 'users'
        }
    ]
});

print("Database and user created successfully.");
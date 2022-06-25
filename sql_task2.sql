
-- Search user who has username is "ghtk" and compare speed searching btw INDEX and w/o INDEX 
-- Show all index
SHOW INDEX FROM user;
-- Search user with INDEX
SELECT * FROM user u
WHERE u.user_name = "ghtk";
-- Drop index and search user
CREATE INDEX index_id ON user(id);

SELECT * FROM user u
WHERE u.user_name = "ghtk";
DROP INDEX index_id ON user;
--  Search top 10 users who are oldest in SG w/o INDEX

SELECT * FROM user u
WHERE u.province LIKE "H%"
ORDER BY u.age DESC
LIMIT 10;

-- Search top 10 users who are oldest in SG with INDEX
CREATE INDEX index_province ON user(province);
SELECT * FROM user u
WHERE u.province = "SG"
ORDER BY u.age DESC
LIMIT 10;
DROP INDEX index_province ON user;

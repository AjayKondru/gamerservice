-- Create game table
CREATE TABLE game_details (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO game_details (id, name) VALUES (1, 'Football');
INSERT INTO game_details (id, name) VALUES (2, 'Cricket');
INSERT INTO game_details (id, name) VALUES (3, 'Rugby');
INSERT INTO game_details (id, name) VALUES (4, 'Baseball');
INSERT INTO game_details (id, name) VALUES (5, 'Hockey');

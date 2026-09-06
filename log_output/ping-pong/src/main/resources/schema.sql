CREATE TABLE ping_pong_count (
    singleton BOOLEAN PRIMARY KEY DEFAULT TRUE CHECK (singleton),
    value INTEGER NOT NULL
);

INSERT INTO ping_pong_count (value) VALUES (0);

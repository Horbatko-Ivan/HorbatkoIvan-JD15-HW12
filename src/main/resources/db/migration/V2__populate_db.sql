INSERT INTO client (name)
VALUES ('John'),
       ('Alice'),
       ('Bob'),
       ('Carol'),
       ('David'),
       ('Eve'),
       ('Frank'),
       ('Grace'),
       ('Hannah'),
       ('Ivy');

INSERT INTO planet (id, name)
VALUES ('MARS', 'Mars'),
       ('VEN', 'Venus'),
       ('PLUTO', 'Pluto'),
       ('NEP', 'Neptune'),
       ('SAT', 'Saturn');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES (CURRENT_TIMESTAMP, 1, 'MARS', 'VEN'),
       (CURRENT_TIMESTAMP, 2, 'VEN', 'MARS'),
       (CURRENT_TIMESTAMP, 3, 'PLUTO', 'NEP'),
       (CURRENT_TIMESTAMP, 4, 'NEP', 'SAT'),
       (CURRENT_TIMESTAMP, 5, 'SAT', 'PLUTO'),
       (CURRENT_TIMESTAMP, 6, 'MARS', 'SAT'),
       (CURRENT_TIMESTAMP, 7, 'VEN', 'NEP'),
       (CURRENT_TIMESTAMP, 8, 'PLUTO', 'SAT'),
       (CURRENT_TIMESTAMP, 9, 'NEP', 'MARS'),
       (CURRENT_TIMESTAMP, 10, 'SAT', 'VEN');

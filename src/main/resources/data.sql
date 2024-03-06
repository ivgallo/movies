INSERT INTO film (id, title)
VALUES (default, 'Star Wars: The Empire Strikes Back'),
       (default, 'Top Gun');

INSERT INTO actor (id, first_name, last_name)
VALUES (default, 'Harrison', 'Ford'),
       (default, 'Mark', 'Hamill'),
       (default, 'Ton', 'Cruise');

INSERT INTO film_actor (actor_id, film_id)
VALUES (1, 1),
       (2, 1),
       (3, 2);
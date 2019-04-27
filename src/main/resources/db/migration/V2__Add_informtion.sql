insert into DRIVER (NAME, PASSPORT, LICENSE, EMAIL, PHONE_NUM, LOGIN, PASSWORD)
values ('Gwion Ritter', '1234567890', '1423597068', 'gritter@gmail.com', '89112345678', 'login', 'password'),
       ('Kyla Williams', '142359708', '4109523876', 'atgmaildotcom@gmail.com', '13342567676', 'KylalaWill', 'Pa$$w0rd'),
       ('Reem Wiggins', '4109523876', '9018237465', 'rewig@mash.com', '89560816741', 'wigginsrt',
        'AnthropomorphousHuman19');

insert into TICKET (DRIVER_ID, IS_PAID, COST)
values (1, TRUE, 15),
       (1, FALSE, 20),
       (2, TRUE, 20);

insert into ADMINISTRATOR (NAME, LOGIN, PASSWORD)
values ('Atticus Burgess', 'Atticus_Burgess', 'averyDifficultpassword'),
       ('Liyah Walters', 'Liyah_Walters2', 'ThePasswordNumber7');

insert into CAR (MARQUE, MODEL, NUMBER)
values ('Lada', 'sedan', 'A257EH97'),
       ('Ford', 'hatchback', 'O845TB97'),
       ('Honda', 'offroader', 'B606AO97'),
       ('BMW', 'crossover', 'M908KC97');

insert into OFFER (DRIVER_ID, ADMIN_ID, CAR_ID, PAYMENT, PERIOD_DAYS, STATUS)
values (1, 1, 1, 1459, 365, 'Unexpectedly disapeared'),
       (2, 2, 2, 20, 4, 'Finished'),
       (3, 1, 2, 20, 4, 'In progress'),
       (2, 2, 3, 123, 30, 'Finished'),
       (3, 1, 4, 8, 2, 'Finished');
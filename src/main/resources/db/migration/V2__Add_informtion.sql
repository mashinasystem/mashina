insert into DRIVER (NAME, PASSPORT, LICENSE, PHONE_NUM, EMAIL, PASSWORD)
values ('Gwion Ritter', '1234567890', '1423597068', '89112345678', 'login@gmail.com', 'password'),
       ('Ray Dalio', '1235467890', '1429997068', '89112345678', 'a@gmail.com', 'password'),
       ('Kyla Williams', '142359708', '4109523876', '13342567676', 'atgmaildotcom@gmail.com', 'Pa$$w0rd'),
       ('Reem Wiggins', '4109523876', '9018237465', '89560816741', 'rewig@mash.com',
        'AnthropomorphousHuman19');

insert into TICKET (DRIVER_ID, IS_PAID, COST)
values (1, TRUE, 15),
       (1, FALSE, 20),
       (2, TRUE, 20);

insert into ADMINISTRATOR (NAME, LOGIN, PASSWORD)
values ('Atticus Burgess', 'Atticus_Burgess', 'averyDifficultpassword'),
       ('Adam Smith', 'admin', 'password'),
       ('Liyah Walters', 'Liyah_Walters2', 'ThePasswordNumber7');

insert into CAR (MARQUE, MODEL, NUMBER)
values ('Tesla Model X', 'Sedan', 'A257EH97'),
       ('Porsche Cayman GT4', 'Hatchback', 'O845TB97'),
       ('Ferrari 488', 'Offroader', 'B606AO97'),
       ('Porsche 911 Carrera', 'Sedan', 'C236AB97'),
       ('Jaguar F-Type', 'Crossover', 'M908KC97'),
       ('Lotus Evora', 'Sedan', 'H909KC97'),
       ('BMW i8', 'Hatchback', 'A122AO97'),
       ('Nissan GT-R', 'Crossover', 'A257EH97'),
       ('Lexus LC', 'Sedan', 'T775ET97');

insert into OFFER (DRIVER_ID, ADMIN_ID, CAR_ID, PAYMENT, PERIOD_DAYS, STATUS)
values (1, 1, 1, 1459, 365, 'Declined'),
       (2, 2, 2, 20, 4, 'Finished'),
       (3, 1, 2, 20, 4, 'In progress'),
       (2, 2, 3, 123, 30, 'Finished'),
       (3, 1, 4, 8, 2, 'Finished');
create table DRIVER
(
    ID        serial primary key,
    NAME      varchar(64) not null,
    PASSPORT  varchar(10) not null,
    LICENSE   varchar(10) not null,
    PHONE_NUM varchar(11),
    LOGIN     varchar(64) not null,
    PASSWORD  varchar(64) not null
);

create table TICKET
(
    ID        serial primary key,
    DRIVER_ID int     not null references DRIVER (ID),
    IS_PAID   boolean not null,
    COST      int     not null
);

create table ADMINISTRATOR
(
    ID       serial primary key,
    NAME     varchar(64) not null,
    LOGIN    varchar(64) not null,
    PASSWORD varchar(64) not null
);

create table CAR
(
    ID     serial primary key,
    MARQUE varchar(16),
    MODEL  varchar(16),
    NUMBER varchar(10) not null
);

create table OFFER
(
    ID          serial  primary key,
    DRIVER_ID   int not null references DRIVER (ID),
    ADMIN_ID    int not null references ADMINISTRATOR (ID),
    CAR_ID      int not null references CAR (ID),
    PAYMENT     int not null,
    BEGIN_DATE  timestamp(6) DEFAULT CURRENT_TIMESTAMP,
    PERIOD_DAYS int not null,
    STATUS      varchar(512)
);
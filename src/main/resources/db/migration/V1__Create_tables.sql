create table DRIVER
(
    ID        int         not null,
    NAME      varchar(64) not null,
    PASSPORT  varchar(10) not null,
    LICENSE   varchar(10) not null,
    PHONE_NUM varchar(11),
    LOGIN     varchar(64) not null,
    PASSWORD  varchar(64) not null
);

create table TICKET
(
    ID_CLIENT int        not null,
    IS_PAID   varchar(5) not null,
    COST      int        not null
);

create table OFFER
(
    ID         int         not null,
    CLIENT_ID  int         not null,
    ADMIN_ID   int         not null,
    CAR_ID     int         not null,
    PAYMENT    int         not null,
    BEGIN_DATE varchar(10) not null,
    END_DATE   varchar(10) not null,
    STATUS     varchar(512)
);

create table ADMINISTRATOR
(
    ID       int         not null,
    NAME     varchar(64) not null,
    LOGIN    varchar(64) not null,
    PASSWORD varchar(64) not null
);

create table CAR
(
    ID     int         not null,
    MARQUE varchar(16),
    MODEL  varchar(16),
    NUMBER varchar(10) not null
);
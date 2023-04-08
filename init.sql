DROP TABLE IF EXISTS public.room CASCADE;
DROP TABLE IF EXISTS public.lodging CASCADE;

create table public.lodging
(
    id           bigserial
        primary key,
    category     varchar(255),
    name         varchar(255),
    phone_number varchar(255),
    type         varchar(255)
);

create table public.room
(
    id         bigserial
        primary key,
    capacity   integer not null,
    number     integer not null,
    status     varchar(255),
    type       varchar(255),
    lodging_id bigint  not null
        constraint fk3con22gkekoma6q54v8spfc1g
            references public.lodging
);

alter table public.lodging
    owner to postgres;

alter table public.room
    owner to postgres;

INSERT INTO lodging values (1, 'EXPRESS', 'Hotel', '219999999', 'HOTEL');

INSERT INTO room VALUES (1, 2, 101, 'AVAILABLE', 'BASIC', 1);

INSERT INTO room VALUES (2, 3, 102, 'OCCUPIED', 'FAMILY', 1);
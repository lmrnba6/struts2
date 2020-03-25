create table users
(
    id         bigserial not null
        constraint users_pkey
            primary key,
    age        integer,
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255),
    user_name  varchar(255)
);

create table tweet
(
    id      bigserial not null
        constraint tweet_pkey
            primary key,
    text    varchar(255),
    title   varchar(255),
    user_id bigint
        constraint fk24pkd8nkpa9b0dftrr6ki7byh
            references users
);


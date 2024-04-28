create table public.tb_role
(
    id    bigserial
        primary key,
    title varchar(255)
);

alter table public.tb_role
    owner to postgres;

create table public.tb_user
(
    id        bigserial
        primary key,
    email     varchar(255),
    full_name varchar(255),
    password  varchar(255),
    username  varchar(255)
);

alter table public.tb_user
    owner to postgres;

create table public.task
(
    id          bigserial
        primary key,
    deadline    timestamp(6),
    description varchar(255),
    name        varchar(255),
    priority    smallint
        constraint task_priority_check
            check ((priority >= 0) AND (priority <= 2)),
    status      smallint
        constraint task_status_check
            check ((status >= 0) AND (status <= 4)),
    user_id     bigint
        constraint fk44cshrflt5qiuaygcnehgocm3
            references public.tb_user
);

alter table public.task
    owner to postgres;

create table public.tb_user_role
(
    user_id bigint not null
        constraint fk7vn3h53d0tqdimm8cp45gc0kl
            references public.tb_user,
    role_id bigint not null
        constraint uk_1txpcisco2l99tl5qqshr6ptp
            unique
        constraint fkea2ootw6b6bb0xt3ptl28bymv
            references public.tb_role
);

alter table public.tb_user_role
    owner to postgres;

create table public.topic
(
    id   bigserial
        primary key,
    name varchar(255)
);

alter table public.topic
    owner to postgres;

create table public.challenge
(
    id               bigserial
        primary key,
    challenge_name   varchar(255),
    challenge_status smallint
        constraint challenge_challenge_status_check
            check ((challenge_status >= 0) AND (challenge_status <= 2)),
    challenge_type   smallint
        constraint challenge_challenge_type_check
            check ((challenge_type >= 0) AND (challenge_type <= 2)),
    difficulty       smallint
        constraint challenge_difficulty_check
            check ((difficulty >= 0) AND (difficulty <= 2)),
    duration         integer not null,
    host_id          bigint
        constraint fkpsrikygf8cjbkg080w81we73e
            references public.tb_user,
    topic_id         bigint
        constraint fk7p0faqimppl97js1yewxk5lpd
            references public.topic
);

alter table public.challenge
    owner to postgres;

create table public.challenge_participator
(
    challenge_id    bigint not null
        constraint fk4sjedpoi4ju00gayjbecdp3in
            references public.challenge,
    participator_id bigint not null
        constraint uk_rh5fcaq1reiyrqpdgh0vffesg
            unique
        constraint fk8vnai5gk492o622a1ewek598v
            references public.tb_user
);

alter table public.challenge_participator
    owner to postgres;

create table public.question
(
    id         bigserial
        primary key,
    content    varchar(255),
    difficulty smallint
        constraint question_difficulty_check
            check ((difficulty >= 0) AND (difficulty <= 2)),
    topic_id   bigint
        constraint fk9h1t7swdq9eej6qf9yxtc8g9w
            references public.topic
);

alter table public.question
    owner to postgres;

create table public.answer
(
    id           bigserial
        primary key,
    answer_state smallint
        constraint answer_answer_state_check
            check ((answer_state >= 0) AND (answer_state <= 1)),
    content      varchar(255),
    question_id  bigint
        constraint fk8frr4bcabmmeyyu60qt7iiblo
            references public.question
);

alter table public.answer
    owner to postgres;



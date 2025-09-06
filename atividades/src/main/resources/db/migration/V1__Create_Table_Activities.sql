create table if not exists `activities` (
    `id` bigint(20) not null auto_increment,
    `name` varchar(100) not null,
    `email` varchar(100) not null,
    `registrationNumber` varchar(100) not null,
    `module` varchar(100) not null,
    `questionOne` varchar(400) not null,
    `questionTwo` varchar(400) not null,
    `sentAt` timestamp not null,
        primary key (`id`)
)
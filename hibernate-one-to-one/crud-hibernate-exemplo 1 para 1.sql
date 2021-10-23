create table `instructor_detail` (
`id` int(11) not null auto_increment,
`youtube_channel` varchar(128) default null,
`hobby` varchar(45) default null,
primary key(`id`)
);

create table `instructor` (
`id` int(11) not null auto_increment,
`first_name` varchar(45) default null,
`last_name` varchar(45) default null,
`email` varchar(45) default null,
`instructor_detail_id` int(11) default null,

primary key(`id`),
key `fk_detail_idx`(`instructor_detail_id`),
CONSTRAINT `fk_detail` foreign key (`instructor_detail_id`)
references `instructor_detail`(`id`)
on delete no action on update no action
) engine=InnoDB auto_increment = 1 default charset=latin1;

create table `course` (
`id` int(11) not null auto_increment,
`title` varchar(128) default null,
`instructor_id` int(11) default null,

primary key (`id`),

unique key `title_unique`(`title`),

key `fk_instructor_id`(`instructor_id`),
CONSTRAINT `fk_instructor` foreign key (`instructor_id`)
references `instructor`(`id`)

on delete no action on update no action
) engine=InnoDB auto_increment = 10 default charset=latin1;






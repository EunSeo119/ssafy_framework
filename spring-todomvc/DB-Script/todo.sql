CREATE SCHEMA IF NOT EXISTS `ssafysupplement` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

USE `ssafysupplement` ;

create table todo (
    no int auto_increment,
    content varchar(200) not null,
    PRIMARY KEY (no)
);

select * from todo;

SELECT * FROM ssafysupplement.todo;
SELECT * FROM ssafysupplement.user;

alter table todo add column user_id varchar(20);

alter table todo add constraint todo_to_user_userId_fk foreign key(user_id) references user (id);

insert into user(id, password, name) values ('ssafy', '1234', '김은서');
insert into user(id, password, name) values ('ssafy2', '12345', '김은서2');
insert into todo(no, content, user_id) values (3, 'aaa', 'ss');
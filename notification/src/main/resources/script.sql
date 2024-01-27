create database notification;

create table notification (
                              id int not null,
                              customer_id int not null,
                              title varchar(255) not null,
                              message varchar(255) not null,
                              created_at timestamp not null,
                              primary key (id)
);

create sequence customer_id_sequence start with 1 increment by 50 owned by notification.id;
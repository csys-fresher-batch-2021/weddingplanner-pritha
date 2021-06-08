
create table user-details(
id serial primary key,
username varchar2(100) not null,
password varchar2(100) not null,
status default 'ACTIVE'
);


create table booking_details(
username varchar2(100) not null,
weddingdate date not null,
weddingtime time not null,
weddinglocation varchar2(100) not null,
weddingstyle varchar2(100) not null,
weddingstylelocation varchar2(100) not null,
weddingfoodtype varchar2(100) not null,
weddingguestcount varchar2(100) not null,
weddingdecortype varchar2(100) not null,
bookingid int not null,
cancellationreason varchar2(100),
bookingdate  timestamp not null default CURRENT_TIMESTAMP );




create table payment_details(
id serial primary key,
username varchar2(100) not null,
bookingid int not null,
cardtype varchar2(100) not null,
amount int not null,
status varchar2(100) default 'UNPAID',
transactioncode varchar2 unique(25) 

);


create table discount_details(
id serial primary key,
username varchar2(100) not null,
bookingid int unique not null ,
booking_status varchar2(100) not null,
earned_coins int default '100',
discount_status varchar2(25) default 'UNUSED');


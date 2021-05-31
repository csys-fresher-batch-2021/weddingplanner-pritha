/* For user deatils table */
create table user-details(
username varchar(100) not null,
password varchar(100) not null,
status default 'ACTIVE'
);

/* For booking Details */
create table booking_details(
username varchar(100) not null,
weddingdate date not null,
weddingtime time not null,
weddinglocation varchar(100) not null,
weddingstyle varchar(100) not null,
weddingstylelocation varchar(100) not null,
weddingfoodtype varchar(100) not null,
weddingguestcount varchar(100) not null,
weddingdecortype varchar(100) not null,
bookingid int not null,
cancellationreason varchar(100),
bookingdate  varchar(100) default to_char(CURRENT_TIMESTAMP, 'yyyy/mm/dd'));


/*For payment details Table */
create table payment_details(
username varchar(100) not null,
bookingid int not null,
cardtype varchar(100) not null,
amount int not null,
status varchar(100) default 'UNPAID',
transactioncode varchar(25) 

);
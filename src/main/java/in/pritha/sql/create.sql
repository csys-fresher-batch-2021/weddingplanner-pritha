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
bookingdate  timestamp not null default CURRENT_TIMESTAMP );



/*For payment details Table */
create table payment_details(
username varchar(100) not null,
bookingid int not null,
cardtype varchar(100) not null,
amount int not null,
status varchar(100) default 'UNPAID',
transactioncode varchar(25) 

);

/**
 *For discount details 
 */
create table discount_details(
id serial primary key,
username varchar(100) not null,
bookingid int unique not null ,
booking_status varchar(100) not null,
earned_coins int default '100',
discount_status varchar(25) default 'UNUSED');

//*copy data */
INSERT INTO discount_details (bookingid)
SELECT bookingid FROM booking_details;

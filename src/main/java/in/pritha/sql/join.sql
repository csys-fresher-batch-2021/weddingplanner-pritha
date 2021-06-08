


SELECT user_details.username, booking_details.bookingid,payment_details.transactioncode,payment_details.amount,payment_details.paymentdate
FROM ((booking_details
INNER JOIN user_details ON booking_details.username = user_details.username)
INNER JOIN payment_details ON booking_details.bookingid = payment_details.bookingid)
where user_details.username='PRITHA';
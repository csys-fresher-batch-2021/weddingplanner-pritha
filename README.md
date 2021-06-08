# maven-web-project-template
Title: Online Wedding Planar App
Description:
Planning a wedding involves endless details, deadlines, family drama, and far too often enough stress to make you want to just elope. Use our offered wedding styles,wedding locations, food styles, decor themes, read our discount membership and easy online payment to help you pull it all together.

This app has the following features
Feature 1 - Display Wedding Styles, Wedding Locations, Food Styles, Decoration themes
This feature displays the above proucts with their packages. It is shown in the form of cards.
Note: If the user logged in only they can see the enabled 'add to cart' button in the card.

Feature 2 - Booking
Navigation --> Booking --> Wedding styles(Add to Cart) --> Wedding Locations(Add to Cart) ---> Food styles(Add to Cart) --> Decor Themes(Add to Cart) -->Enter Wedding Details ---> Confirm booking(land to payment page) / Cancel booking(land to home page).

When user click the booking, it navigate to add to cart button of one of the wedding style, then it navigate to wedding location, food styles, decor themes. Finally reaches the booking page with autofilled above mentioned by the user. Now User need to enter their wedding details(wedding date, wedding time, wedding location)[these three has some validation in front end as well as back end] only to confirm booking.If all the details validated, booking id will be generated and 'estimated budget' of thier designed wedding is automatically generated with a button proceed to online payment.


Feature 3 - Cancel booking
If the wedding date is above 2 months from the present date, user can see the enabled cancel button or else disabled defaultly. cancel page asks some cancellation reason to improve business as this was the high level budget wedding business.

Feature 4 - Confirm booking/Online payment
As all of the projects of wedding business need a long term work, online payment is mandatory to confirm their booking. Online payment page asks for the(card type, card username, credit card number, card expiry date, cvv, amount(auto filled), discount coupen code(not mandatory), purpose(not mandatory).Validation for above fields is done in frontend as well as backend.

Feature 5: OTP Generation and Checking /Confirm Payment
After the successful validation of entere card details, user redirected to otp checking page. In this page three features designed
*** 1-Real time OTP sended using SMS Gateway[logic written in java]
*** 2-Resend OTP(If user press this they can see new otp in thier mobile)
*** 3-TimeOut (Generated Auto Timer for 2 minutes(logic written in script).If user can't
enter the correct otp in setted time,  otp gets invaliated and new otp will be sended)
Entered otp and generated otp checking is done internally. After successful checking, user redirected to final page)

Feature 6 - Discount
Discount is given to user based on the number of bookings and earned coins.
Note:* Default earned coins is 100/booking.
	 * Number of booking should be >= 20
	 * Earned coins should be >=200
	 If all this condition satisifies they can see their discout coupon code(real coupon code using bootstrap) . User should copy this and can use it while payment.

Feature 5 - Admin Login & Registration
Only admin has the priviledge access to view the business details from database such as all bookings,confirmed bookings, cancelled bookings, paid bookings, LeaderBoard(based on number of bookings[for discount/gift purpose]).

Feature 6 - User Login
Login / sign Up / Forgot Password - All validation done internally


Specification fields
User  :
String username = [4-20] characters , not null, not empty, no numeric, no special characters
String password = [8-20] characters, one small case, one upper case, one numeric , one special charcters

  
Admin  :
String name - gracwed
String password - Gracwed@7172

Booking :
Wedding Date : Future date , required
Wedding Time : 4 Am - 4 Pm , required [mostly this will be the wedding time]
Wedding Location : [4-20] characters , not null, not empty, no numeric, no special characters

Payment : 
Card type : rupay , master, discover, american only
Card holder :  [4-20] characters , not null, not empty, no numeric, no special characters
Card number : 13-16 digits (should Starts with 6,4,5,37 as these are card standards)
cvv : [3-4] not null, Future date ,  not empty, no numeric, no special characters
card Expiry Date :  Future date , required
Amount : (autofilled) If user changes validation will be done - online payment available upto [1-10,00000] , not null, not empty, no numeric, no special characters
Discount Code : Should be Same as generated coupon code
Purpose :  No Validation as its not mandatory





# Travel
Solution to the Salesman's Travel codingkata

Trello board: https://trello.com/b/DQLtbQzF/travel

Client's address e.g. "432 Main Long Road St. Louisville OH 43071" as a list.
The basic zipcode format usually consists of two capital letters followed by a white space and five digits. 
The list of clients to visit was given as a string of all addresses, each separated from the others by a comma, e.g. :

"123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432".

Group by State and Zipcode

The function travel will take two parameters r 
(addresses' list of all clients' as a string) 
and zipcode and returns a string in the following format:

zipcode:street and town,street and town,.../house number,house number,...

The street numbers must be in the same order as the streets where they belong.
If a given zipcode doesn't exist in the list of clients' addresses return "zipcode:/"

Examples
r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432"

travel(r, "OH 43071") --> "OH 43071:Main Street St. Louisville,Main Long Road St. Louisville/123,432"

travel(r, "NY 56432") --> "NY 56432:High Street Pollocksville/786"

travel(r, "NY 5643") --> "NY 5643:/"

# UPDATES
Switching to OnClickListeners
>Article: https://www.codingfanatic.com/2019/09/30/switching-to-onclicklisteners-47-100-days-of-code/

>Video: https://www.youtube.com/watch?v=8_yYioNPnxE

Viewing the list of addresses
>Article: https://www.codingfanatic.com/2019/10/07/travel-app-listview-update-48-100-days-of-code/

>Video: https://www.youtube.com/watch?v=MxQcXAEKgA0

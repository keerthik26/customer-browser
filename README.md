# Customer Browser
Build an application that consumes a JSON API
and displays aggregated data.  Whilst the requirements are simple, you should aim to
deliver a product that can be easily extended in the future.

This application is to connect to a [live BigCommerce store](https://store-velgoi8q0k.mybigcommerce.com) via the
[V2 API](https://developer.bigcommerce.com/api/v2/). The application will consist of the following screens:
* A list of Customers, including the total number of orders they have placed
* A Customer Details screen that displays the Order History for that Customer, and their Lifetime Value (defined as the
  total value of all of their orders)
  
You are free, and encouraged, to create whatever additional models, services, etc you deem appropriate. If time allows,
we would love you to include unit tests for your submission.

##Approach
Built Spring MVC Web application which consumes store's V2 REST API's using Spring's WebClient component
and renders the required view as HTML page to the client using Thymeleaf template engine.

I chose below technologies as I'm familiar with them. So I can focus more on Designing part of the application

## Tech stack
* Language - `Java`
* Dependency Injection framework - `Spring Boot` 
* Java Template Engine - `Thymeleaf` 
* Styling - `Bootstrap` 
* Logging - `slf4`
* Build tool - `Maven`

## Set up
1. Clone the project from [GitHub](https://github.com/keerthik26/customer-browser) repository.
2. Build the Jar file using Maven `mvnw clean package`. 
   It generates `customer-browser-1.0-SNAPSHOT.jar` file in the project's target folder. 

## Steps to run
1. Change directory to Project folder.
2. Run the jar using command :
  `java -jar ./target/customer-browser-1.0-SNAPSHOT.jar`
   
## Testing the application
1. Now the application is running on the local host with port number 8080.
   Visit `http//localhost:8080/` on a browser that takes you to a Welcome page.
   
2. To view all the customers, either 
    * click on `View Customers` button on Welcome page
    * visit `http//localhost:8080/customers`

3. To view the details of a particular customer, either
    * click the `Details...` link on customers page
    * visit `http//localhost:8080/customers/{customerId}/orderHistory`

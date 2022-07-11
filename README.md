### Developer Task 1 

* You will receive instructions from Cassava Smartech on what's required.


### Solution Comments
* Command to start the jetty server on the electronic-payments-api module is:
      mvn clean install jetty:run -pl electronic-payments-api

### Bug Log
1. LOGGER variable is an instance final variable. It's being referenced from the static context. To solve this error I have to add static specifier
2. I changed hibernate persistence annotation from PreInsert to PrePersist. PreInsert doesn't exist.
3. In Java, when you use explicit call to super constructor. The keyword super() should be the first statement. The is super keyword that may be used to access parent type values.
4. Spring data API offers several boilerplate API to use. In this case to persist, I can use the save api. The method persist doesn't exist unless I define it.
5. Spring data API offers several boilerplate API to use. The method update doesn't exist unless I define it. The save method update entries if they exist in the database.
6. Spring data API offers several boilerplate API to use. In this case to persist, I can use the save api. The method persist doesn't exist unless I define it.
7. Spring data API offers several boilerplate API to use. The method update doesn't exist unless I define it. The save method update entries if they exist in the database.
8. The electronic-payments-business java module depends on the intelligent-network-api module. The errors on missing library can be fixed by adding the respective dependency.
9. Added unit tests to electronic-payments-business module
10. Changed the named query name from Request to request specified on the entity annotation.
11. Added Command to start the jetty server on the electronic-payments-api module is below.
12. Added the constructor for the EpayResource class. The constructor initialise the instance variables. It takes part in the object instantiation life cycle.

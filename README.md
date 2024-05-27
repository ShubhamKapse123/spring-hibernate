# spring-hibernate
learning hibernate

# SessionFactory

Session factory is the interface. It is one kind  of connecton for getting hibernate sessions. that helps to perfom operstions with database. it's threads safe object.

# Transaction
Transaction we need when we want to perform DML(create,update,delete) operation.

### For fetching the data we have two method that given by hibernate sesson.

get()-> get method of hibernate session returns null if object is not found in cache as well as on database.
        get method involves database hit if object doesn't exit in session cache and returns a fully initialized object
        which may involve several database call. use if you are not sure that object exits in db or not.

load() -> load method throws objectNotFoundException if object is not found on cache as well as on database but never return null.
         load method can return proxy(proxy object means the object don't have any data we can call it dummy object when we call 
         object of any methods like getAddress or getName others then  getId (primary key field) then in this case  load method 
         hit the database otherwise use proxy object but in case of get they directly hit the database even we don't 
          call any method of object) in place and only initialize the object or hit the database if any method other than getId() 
          is called on persistent or entity object. This lazy initialization increase the performance.
         use if you are sure that object exits.

### lazy loading and eager loading

Lazy loading :  In lazy loading associated with data load only when we explicitly call getters methods.
                In lazy loading, data is loaded only when explicitly requested.
                Lazy loading optimizes memory usage by loading related data only when necessary.
                Hibernate uses proxies and collection wrappers to implement lazy loading.
                When retrieving lazily-loaded data, there are two steps: populating the main object and retrieving data within its proxies.
                Keep in mind that loading data always requires an open Hibernate session1.
                Lazy loading in Hibernate allows us to load data on-demand, improving performance and resource utilization.
                For example, When we load a UserLazy, the associated OrderDetail data won’t be initialized until we explicitly call for it.

Eager loading : It is a design pattern in which data loading occurs on the spot.
                In eager loading, data is initialized immediately when we retrieve an object.
                Eager loading can lead to unnecessary data retrieval, especially when we don’t need all related data right away.
                For example, if we load a User object, all associated OrderDetail records are also loaded into memory.


##### @Embeddable

The @Embeddable annotation marks a class as being embeddable. In other words, its properties can be included as a value type within another class.
The class marked with @Embeddable is referred to as the embeddable class.
The @Embedded annotation, on the other hand, marks a field in a class as an embeddable object. It is used within the class that contains the embeddable object.
By using these annotations, Hibernate can automatically persist the properties of the embeddable class within the containing class’s table, without creating 
a separate table for the embeddable class.
here note is other class properties added into single table which is entity class have the reference variable  of class that annotate with @Embeddable.


###### state of hibernate object
Transient -> persistence -> detach -> removed

create object and  when we set the properties  then this object goes into transient state.
when we call session.save()(any method that related to the database operation ) when associate 
with session then it will go into persistence state and convert into table.
when the session is close then object will remove from session, and it will go into detach state and then removed state.

#### caching in hibernate 

caching is a mechanism to enhance the performance of a application.

cache use to reduce the number of call for database queries. 









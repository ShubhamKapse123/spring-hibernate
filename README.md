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


##### state of hibernate object
Transient -> persistence -> detach -> removed

create object and  when we set the properties  then this object goes into transient state.
when we call session.save()(any method that related to the database operation ) when associate 
with session then it will go into persistence state and convert into table.
when the session is close then object will remove from session, and it will go into detach state and then removed state.


##### First Level Cache
Hibernate uses a session-level cache, also known as the first-level cache.
This cache stores data that is currently being used by a specific Hibernate session.
When an entity (object) is loaded or updated for the first time within a session, it gets stored in this cache.
Associated with a specific Hibernate Session object.
Other session objects in the application cannot access it.
Cached objects are available only within the session’s scope.
Once the session is closed, cached objects are no longer accessible.
Enabled by default, and we cannot disable it.
When querying an entity multiple times within the same session, it’s loaded from the cache (no additional SQL query).
You can remove a specific entity from the cache using the evict() method.
Clearing the entire session cache is possible using the clear() method.
First level cache is automated by hibernate

##### Second Level Cache
Hibernate second-level cache stores entity and query data in a shared cache accessible across multiple sessions.
It helps reduce database-access costs for frequently accessed data.
Especially beneficial for large object graphs and read-heavy scenarios.
How It Works:
Second-level cache is SessionFactory-scoped (shared by all sessions from the same factory).
When an entity or query is fetched for the first time:
If found in the first-level cache (session scope), it’s returned.
Otherwise, it checks the second-level cache:
If cached, data is fetched from there and an instance is assembled.
If not cached, data is loaded from the database.
The loaded instance is stored in both caches.
Region Factory:
Hibernate is unaware of the actual cache provider.
It needs an implementation of org.hibernate.cache.spi.RegionFactory.
Acts as a bridge between Hibernate and cache providers.
second level cache need manual configuration

##### Native Query 
Depends on Database queries
Hibernate provides the option to execute native SQL queries using the SQLQuery object.
These queries allow you to execute database vendor-specific SQL statements that are not directly supported by Hibernate’s API.
Examples include query hints or database-specific keywords (e.g., CONNECT in Oracle Database).
Native SQL queries are not recommended for normal scenarios.
Why? Because you lose benefits related to Hibernate associations and the first-level cache.
Unlike HQL queries (which return associated table data), native queries may not include related entities (e.g., Address in this case).

##### HQL Query
Independents Query from database
HQL is an object-oriented query language, similar to SQL.
Instead of operating on tables and columns, HQL works with persistent objects and their properties.
Hibernate translates HQL queries into conventional SQL queries, which then interact with the database.
In-memory entities won’t update to reflect deletions.

##### Criteria API
The Criteria API in Hibernate is a powerful feature that allows you to create queries programmatically without writing raw SQL. 
The Criteria API enables you to build criteria query objects programmatically.
It provides object-oriented control over queries, which is one of the main features of Hibernate.
Since Hibernate 5.2, the Hibernate Criteria API is deprecated, and new development is focused on the JPA Criteria API.
JPA (Java Persistence API) is a standard specification for ORM (Object-Relational Mapping) in Java.

##### Pagination
Pagination is a technique used to retrieve a subset of data from a larger dataset.
It allows developers to display data in smaller chunks or pages, making it easier to manage and navigate.
HQL provides two methods for pagination:
query.setFirstResult(int firstResult): Sets the index of the first result to retrieve.
query.setMaxResults(int maxResults): Specifies the maximum number of results to retrieve.









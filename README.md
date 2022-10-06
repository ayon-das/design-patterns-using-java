## Design patterns using java
Implemented design patterns using java.

### Singleton design pattern
[Singleton design pattern](https://github.com/ayon-das/design-patterns-using-java/tree/main/singleton-design-pattern)
When only one instance of the class is needed throughout the application and its modules. This is also called a shared resource.
Examples - DB connection, Logger instance etc. If we use global variables for data to achieve this, it might resolve our problem
only for reading the data, not for writing. So, this can be resolved by creating a thread safe singleton class, which maintains only one instance throughout the application.

Steps to implement singleton design pattern:
- Create a class which needs to be singleton.
- make it's default constructor private.
- Create a volatile variable of the class type. (We have to declare the variable as volatile bcz. because of the thread data visibility issue)
- (Optional)Initialize it creating an object of your class if you want eager initialization. i.e. if you want your application to create instance when you run the application.
- Implement a method following thread safety, which will be used to get the instance.
- You can also use some data variables to test.

### Factory design pattern
[Factory design pattern](https://github.com/ayon-das/design-patterns-using-java/tree/main/factory-design-pattern)

Steps to implement factory design pattern:
- Create EmployeeRepository interface.
- Create EmployeeRepositoryImpl class.
- Create a client class, where create an object of EmployeeRepositoryImpl class and use add method to add some employees and find method to find employees. As a client we are unaware of the EmployeeRepositoryImpl class. We are only aware of EmployeeRepository interface. To make this dynamic we will create a factory.
- Create an ObjectFactory class. Implement a get method and use class.forName("com.javainfinity.provider.EmployeeRepositoryImpl") and return object like claz.getConstructor().newInstance().
- Change client class accordingly by creating object factory and call get method to get the instance of EmployeeRepositoryImpl
- Let's make this dynamic too. Create a config.properties class. Implement propeties and accept key in the get method in the object factory class.
- Change the client class accordingly to pass the key and create an instance.
- Now we are done with prototype. what if we have singleton class ?
- Create a singleton annotaion. 
- Implement EmployeeRepositoryImplSingleton class and use singleton annotation.
- Changing the factory class accordingly for singleton. Check the code.
- Change the config file and client class accordingly with singleton key.

Conclusion: As a java programmer, we know that in spring framework, we have bean factory which returns us the bean required during runtime. To specify a bean either we write in xml configuration or we mark the bean with @component annotation. So, bean factory is implemented using factory design pattern.

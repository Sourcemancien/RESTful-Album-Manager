#RESTful Album Manager (application sample)

This sample project is a 2 parts application using Spring and Jersey to make a restful API Service called by a Web Client.

The client is a Spring webapp consuming datas in JSON format, and the Application Server is a Java Jersey application providing a REST API and datas in JSON format.

Those applications do only simple operations as they're just a simple example of how to make a Jersey REST app as Service and a Spring webapp as Client, and get them to communicate with JSON through HTTP calls.

Keep in mind that it's also possible to make one Spring application to serve as web client and as REST API, or even possible to integrate Jersey into a Spring app.
But the purpose is to have two physically separated applications, then the Spring application could be replaced by anything later.



There is a third java project providing a common library of POJO/Java Bean which define the JSON structure.
In this sample, the library is only used by the Jersey application while the web client use its own Java Bean, just because we can... because using json allow us to have different models as long as they respect (a part of) the JSON scheme.

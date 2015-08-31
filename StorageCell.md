# Introduction #

The project shows a working example of Apache CXF (REST API), Spring data (JPA Hibernate), H2 database, jQuery with datatables.

What is REST? http://rest.elkstein.org/
http://www.vogella.com/articles/REST/article.html

[Why H2DB](http://kentorjava.com/2013/12/13/h2-db-the-java-sql-database/)?

[Why Git](http://thkoch2001.github.io/whygitisbetter/)?

Application:

Storage cell as the name suggests is a small part of inventory/storage system. A cell is nothing but a container with boxes of odd sizes. A cell is divided into number of boxes that could be placed; based on the size of the cell.
```
Cell:
id (long)
location (string)
width (size int)
occupied (flag true/false)
boxes
    -id (long)
    -name (string)

One to many relation from Cell to Boxes. A cell can have one or many number of boxes.

Services required:

service/cells
service/cell/{id}
service/cell/boxes
cell/{id}/box/{id}
```

Embedded database link [http://127.0.0.1:8082/](http://127.0.0.1:8082/)
```
JDBC URL: jdbc:h2:mem:storage-cell;MVCC=true;
Driver: org.h2.Driver
```

# Software/tools required to build project from scratch #

We are using embedded tomcat and embedded database which means we require no installation!

  * Apache Maven ([download](http://maven.apache.org/download.cgi))
  * Git ([download](http://git-scm.com/downloads))
  * Java 7  ([download](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html))
  * Eclipse ([download](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/keplersr1-rc3))

[Set path in environment variable](http://www.java.com/en/download/help/path.xml)?

# Before we start #
  * If you are not familiar with the maven structure! take a look [here](http://kentorjava.com/2012/08/19/maven-basics-and-plugins/)
  * Maven jar/war/pom
  * Group-Id (unique in all projects) and Artifact Id (name of the jar/component) in Maven. [Read more](http://stackoverflow.com/questions/3150003/naming-convention-for-maven-artifacts)...
  * Two things expected: Conflict in support for Maven-Eclipse and Maven downloads a lot to maintain it's local repo the first time it runs!

# Where to start #
  * First we shall [download](https://code.google.com/p/kentor-java-utbilding/source/checkout) the complete project. Use git clone
  * Switch to StorageCell catalog and run
> > ` mvn clean install `
  * Now run
> > ` mvn tomcat7:run `
  * Go to
```
http://127.0.0.1:8080/storagecell/service/cells
http://127.0.0.1:8080/storagecell/jsonp.html
```
  * Here you can decide if you want to build from scratch or concrete building the client directly.

  * Decide the name of the project (this would be artifact-id ending up as the jar name)
  * Start with a new maven project
> > ` mvn archetype:generate `
  * If you are using Eclipse every now and then you need to add maven dependencies and to get it reflected in your eclipse environment it is required to run
> > ` mvn eclipse:eclipse `
  * run mvn clean install (just to test the structure)
  * We will first create the core of the project; building webservice in the end. Let's start with package structure xx.model.entity; xx.model.service
  * Identify entities and create Entity objects in the model (see [documentation](http://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html)). This requires:
    * Update [pom](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/pom.xml) file fixing dependencies

We are interested in:
```
javax.persistence.CascadeType;
javax.persistence.Column;
javax.persistence.Entity;
javax.persistence.FetchType;
javax.persistence.GeneratedValue;
javax.persistence.GenerationType;
javax.persistence.Id;
javax.persistence.OneToMany;
```
  * Define relationships (OneToMany; ManyToOne, ...)
if A "has" B, then you must define CascadeType.ALL in A:
```
public class A {
  // changes to A cascade to B
  @OneToOne(cascade = {CascadeType.ALL})
  B b
}
```
[CellEntity.java](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/main/java/se/kentor/lab/storagecell/core/model/entity/CellEntity.java)

  * The 4 required configuration files under resources are
    * x.properties ([application.properties](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/main/resources/application.properties))
    * persistence.xml (Under /META-INF/ - [persistence.xml](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/main/resources/META-INF/persistence.xml))
    * log4j.xml ([log4j.xml](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/main/resources/log4j.xml))
    * x-service.xml ([cell-storage-service.xml](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/main/resources/cell-storage-service.xml)). The configuration file can be divided into 3 main sections containing 7 different bean configurations.
      * Context property-placeholder (to read the properties file)
      * Database server configuration
      * JPA Bean configuration
      * Annotations
      * Connection pooling
      * EntityManager
      * Transaction Manager

  * Now at this stage you would like to avoid the boiler code required to maintain entity manager (add/delete), transaction. To do this create an interface extending JpaRepository to get the required CRUD methods out of the box example: findAll, delete, findById() etc.
[Spring data documentation](http://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa/)

_Note: All this is under @Transaction and is no harm to declare it once again to make it clear_

The last thing required to make it work is to add configuration in x-service.xml file


&lt;jpa:repositories base-package="se.kentor.lab.storagecell.core.model.repository" /&gt;

_Correspondingly schema definition.
Required schema reference for this project
[cell-storage.service.xml](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/main/resources/cell-storage-service.xml)_

More links and tips:
  * LocalContainerEntityManagerFactoryBean is the preferred way of obtaining a reference to an EntityManagerFactory, at least outside of a full Java EE 5 environment.

  * [BasicDataSource](http://commons.apache.org/proper/commons-dbcp/apidocs/org/apache/commons/dbcp/BasicDataSource.html)

  * [Transaction](http://stackoverflow.com/questions/12873570/difference-between-spring-txadvice-and-spring-aop-pointcut)
  * Now it's the time to create a service and implement it. It may contain methods to fetch cells based on availability; occupancy; and all. The underlying repository actually does the job of fetching data from database.

  * At this stage we have our Entities being exposed further top up and it's not recommended then we create simple POJO's and copy properties from Entity to POJO's (Dozer API)
  * Now the service layer is ready to be tested we will now add few tests.
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/x-service.xml")
@Autowired
```
[StorageCelImplTest.java](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/test/java/se/kentor/lab/storagecell/service/impl/StorageCellImplTest.java)

  * Run the test and run from `mvn clean install`
_Note: This is not a web application yet_

  * Create a webapp catalog under src/main/ and WEB-INF under /src/main/webapp/

  * [applicationContext.xml](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/main/webapp/WEB-INF/applicationContext.xml) is the default name of spring configuration file under WEB-INF and it refers (using import) to the cell-storage-services.xml on its classpath. A link to rest service definition file is to be declared here.

  * Now it's the time to create a JAXRS service interface as seen here [IStorageCellWeb.java](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/main/java/se/kentor/lab/storagecell/app/rs/IStorageCellWeb.java)

  * To complete the interface an implementation is to be carried out. Requires no annotations here.

  * Required to complete applicationContext.xml reference to the rest services xml [rest-services.xml](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/main/webapp/WEB-INF/rest-services.xml)

  * Now comes the main configuration file for a webapplication The web.xml file. The most important part is to give the responsibility of handling the servlet request to CXFServlet (an implementation from Apache CXF) [web.xml](https://code.google.com/p/kentor-java-utbilding/source/browse/StorageCell/src/main/webapp/WEB-INF/web.xml)

  * Character encoding and log4j configurations could be added in web.xml

  * Now the application is ready to be tested on url http://localhost:8080/storagecell/service/cells/

  * Finish of part-I building server side
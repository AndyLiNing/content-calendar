### 1, Add following to program arguments
* --spring.profiles.active=DEV 

### 2, Add following to environment variables
* SOURCES_DIR=/Users/andy/Work/Java/content-calendar


### 3, Spring – Inject value into static variables => Spring does not allow to inject value into static variables
* @Value annotation should be used in a BEAN environment
* https://mkyong.com/spring/spring-inject-a-value-into-static-variables/



### 4, Jackson ObjectMapper  
https://www.baeldung.com/jackson-object-mapper-tutorial
objectMapper.readValue()
objectMapper.writeValue()
- POJO to JSON
- JSON to POJO
- JSON to POJO List or Map
- JSON to JasonNode

### 5, Java Optional container

### 6, Variable argument in JAVA
https://www.baeldung.com/java-varargs
Each method can only have one varargs parameter
The varargs argument must be the last parameter
```agsl
    private void varargsMethod(int... args) {
		for(Integer item : args) {
			System.out.println(item);
		}
	}
```
### 7, Deep dive into Spring boot AutoConfig 
@Configuration(proxyBeanMethods = false) vs @AutoConfiguration => 
Add in resources folder the "META-INF.spring/org.xxxx.imports" to auto config custom beans (GSON is a simple example)

### 8, Static key word
https://www.geeksforgeeks.org/static-keyword-java/
- static variable
- static block => to init the static variables before java loads the static class
- static method
- static class

### 9, ".class"
```agsl
When you write .class after a class name, 
it references the class literal - java.lang.Class object that represents information about a given class.

For example, if your class is Print, 
then Print.class is an object that represents the class Print on runtime. 
It is the same object that is returned by the getClass() method of any (direct) instance of Print.
```


--runOnChange:true
--validCheckSum: 9:43808f3a0df83ef94a3eb289ca15d0a4
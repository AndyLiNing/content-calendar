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
Each method can only have one varargs parameter
The varargs argument must be the last parameter
```agsl
    private void varargsMethod(int... args) {
		for(Integer item : args) {
			System.out.println( "item:" + item);
		}
	}
```


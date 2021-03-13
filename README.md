# jQuestrade - Room
[![](https://jitpack.io/v/mateimarica/j-questrade-room.svg)](https://jitpack.io/#mateimarica/j-questrade-room)

This library is version of [**jQuestrade**](https://github.com/mateimarica/j-questrade) that has been tailored for use with the [**Room persistence library**](https://developer.android.com/jetpack/androidx/releases/room). 

Made for [**QuestGraph**](https://github.com/mateimarica/questgraph).

<br>

## Differences from base jQuestrade
* Objects have been defined using the Room schema.
* Some objects have been given a `timeOfCreation` property, since Room tables are immutable.

<br>

## Example Usage

```java
Questrade q = new Questrade(refreshToken);

try {
	q.activate(); // This must be called before making API requests
	
	Account[] accs     = q.getAccounts();  // Get all accounts
	ZonedDateTime time = q.getTime();      // Get server time
	
	ZonedDateTime startTime = ZonedDateTime.now().minusMonths(1);
	ZonedDateTime endTime   = ZonedDateTime.now();
	
	// Get all orders for the first account in the last month
	Order[] orders = q.getOrders(accs[0].getNumber(), startTime, endTime);
	
} catch (RefreshTokenException e) { 
	// Prompt user to enter another refresh token
}
```

<br>

## Installation
### Gradle:
* Add the following into your `build.gradle` file:
```gradle
repositories {
	maven { url 'https://jitpack.io' }
}
```
```gradle
dependencies {
	implementation 'com.github.mateimarica:j-questrade-room:1.0'
}
```
<br>

### Maven:
* Add the following into your `pom.xml` file:
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```
```xml
<dependency>
	<groupId>com.github.mateimarica</groupId>
	<artifactId>j-questrade-room</artifactId>
	<version>1.0</version>
</dependency>
```

<br>

## Documentation
See the [wiki](https://github.com/mateimarica/j-questrade/wiki) of the base library, jQuestrade.

<br>

## Disclaimers

* This library is not affiliated, maintained, authorized, or endorsed by Questrade.

* This library has not been heavily tested. Use at your own risk.

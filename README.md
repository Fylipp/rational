# rational
[![Build Status](https://travis-ci.org/Fylipp/rational.svg?branch=master)](https://travis-ci.org/Fylipp/rational)

This is a fraction implementation backed by `BigInteger`.

## Example
```kotlin
val a = 1 over 4
val b = 2 over 8
assertEquals("1/4 + 1/4 = 1/2", "$a + $b = ${a + b}")

val double = "1.462" // Using a string prevents errors due to floating-point precision loss
val rational = double.toRational()
assertEquals("1.462 -> 731/500", "$double -> $rational")
```

## Usage
**rational** is distributed via [JitPack](https://jitpack.io/) which means that a custom repository is required.

```xml
<dependency>
  <groupId>com.github.Fylipp</groupId>
  <artifactId>rational</artifactId>
  <version>v1.0.0</version>
</dependency>
```

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

## License
MIT.

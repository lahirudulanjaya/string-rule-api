# Project Name

## Overview

This project is a Spring Boot application that provides REST API endpoints for performing string operations based on specified rules.

## Setup

### Requirements

- Java Development Kit (JDK) 11
- Gradle

### Building and Running

1. Clone the repository:

2. Navigate to the project directory:

3. Build and run the application using Gradle:
   ./gradlew build
   ./gradlew bootRun


The application will start and be accessible at `http://localhost:8080`.

## API Endpoints

- **GET /v2/reply/{rule}-{message}**: Applies string operations based on the provided rule to the input message and returns the result.

### Description of Rules

1. **Rule 1**: Reverse the String
- Reverses the characters in the input string.

2. **Rule 2**: Encode the String via MD5 Hash Algorithm
- Encodes the input string using the MD5 hash algorithm and returns the result as a string.

### Examples

```
GET /v2/reply/11-kbzw9ru
{
    "data": "kbzw9ru"
}
```

```
GET /v2/reply/12-kbzw9ru
{
    "data": "5a8973b3b1fafaeaadf10e195c6e1dd4"
}
```
```
GET /v2/reply/22-kbzw9ru
{
    "data": "e8501e64cf0a9fa45e3c25aa9e77ffd5"
}
```

## Testing

To run unit tests, use:-

./gradlew test


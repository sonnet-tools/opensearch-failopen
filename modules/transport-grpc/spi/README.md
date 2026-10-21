**Registry Injection Pattern**
**Context Preservation:** The transport-grpc module automatically preserves ThreadContext across async boundaries. Any data set by interceptors will be available in the gRPC service implementation, even when execution switches to different threads.
public class SampleInterceptorProvider implements GrpcInterceptorProvider {
#### How Order Values Work
return ImmutableList.of(knnStats, knnQueryConverter);
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
- Implement custom query converters for gRPC transport
            builder.filter(filterQuery);
public class MyPlugin extends Plugin {
The gRPC plugin **injects the populated registry** into converters that need it:
        // Pass the registry to utility classes that need it
    - [Unit Tests](#unit-tests)
    description 'Your plugin description'
**1. Implement Provider:**
```groovy
                public int order() { return 10; }
        // Handle nested filter query using injected registry
```
```
     */
    @Override
IllegalArgumentException: Multiple gRPC interceptors have the same order value: 10.
}
    @Override
}
org.opensearch.mypackage.SampleInterceptorProvider
}
public void testCustomQueryConverter() {
In your plugin's main class, return the converter from createComponents:
    name 'your-plugin-name'
```gradle
    QueryBuilder result = converter.fromProto(queryContainer);
            builder.filter(filterQuery);
                        return next.startCall(call, headers);
### Overview
        return KNNQueryBuilderProtoUtils.fromProto(queryContainer.getKnn());
    - [2. Declare Extension in build.gradle](#2-declare-extension-in-buildgradle)
    @Override
./gradlew :modules:transport-grpc:spi:test
```java
---
`src/main/resources/META-INF/services/org.opensearch.transport.grpc.spi.GrpcServiceFactory`:
    - [Understanding Interceptor Ordering](#understanding-interceptor-ordering)
        ServerInterceptor getInterceptor();
## Usage for Plugin Developers
        return QueryContainer.QueryContainerCase.MY_CUSTOM_QUERY;
```java
    }
    // Create test protobuf query
            .build())
    - [2. Register Your Converter](#2-register-your-converter)
  - [Real-World Example: k-NN Plugin](#real-world-example-k-nn-plugin)
        }
    @Override
            QueryBuilder filterQuery = registry.fromProto(filterContainer);
- Register `BindableService` implementation to the gRPC transport
```java
        MyCustomQuery customQuery = queryContainer.getMyCustomQuery();
```
```java
                                             ThreadPool threadPool, ResourceWatcherService resourceWatcherService,
```java
```
## QueryBuilderProtoConverter
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
        return QueryContainer.QueryContainerCase.KNN;
dependencies {
## Real-World Example: k-NN Plugin
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
**Real-world examples:**
    classname 'org.opensearch.yourplugin.YourPlugin'
Each interceptor must have a unique order value. If duplicate order values are detected, OpenSearch will fail to start with an `IllegalArgumentException`.
Several node resources are exposed to a `GrpcServiceFactory` for use within services such as client, settings, and thread pools.
                public ServerInterceptor getInterceptor() {
    @Override
        if (knnQuery.hasFilter()) {
                    };
For `GrpcInterceptorProvider` implementations:
      - [Duplicate Order Values](#duplicate-order-values)
        KNNQueryBuilder builder = new KNNQueryBuilder(
// 2. GrpcPlugin injects registry into loaded extensions
  - [Table of Contents](#table-of-contents)
    - [Overview](#overview-1)
    - [QueryBuilderProtoConverter](#querybuilderprotoconverter)
    public QueryBuilder fromProto(QueryContainer queryContainer) {
## Table of Contents
The k-NN query's `filter` field is a `QueryContainer` protobuf type that can contain any query type (MatchAll, Term, Terms, etc.). The k-NN converter needs access to the registry to convert these nested queries to their corresponding QueryBuilder objects.
### Basic Usage
    - [3. Accessing the Registry (For Complex Queries)](#3-accessing-the-registry-for-complex-queries)
#### Duplicate Order Values
    queryRegistry.registerConverter(converter);
        .setMyCustomQuery(MyCustomQuery.newBuilder()
                                             Environment environment, NodeEnvironment nodeEnvironment,
opensearchplugin {
        return new MyCustomQueryBuilder(customQuery.getField(), customQuery.getValue());
**3. Plugin Registration:**
## Testing
                    return (call, headers, next) -> {
```
### QueryBuilderProtoConverterRegistry
    }
}
- Register custom query types that can be processed via gRPC
            new GrpcInterceptorProvider.OrderedGrpcInterceptor() {
// 1. Converter interface has a default setRegistry method
                                             IndexNameExpressionResolver indexNameExpressionResolver,
### 3. Create SPI Registration File(s)
```java
`src/main/resources/META-INF/services/org.opensearch.transport.grpc.spi.GrpcInterceptorProvider`:
        // By default, converters don't need a registry
    - [1. Implement Custom Service Factory](#1-implement-custom-service-factory)
- [transport-grpc-spi](#transport-grpc-spi)
    public QueryBuilder fromProto(QueryContainer queryContainer) {
    @Override
        KnnQuery knnQuery = queryContainer.getKnn();
```
The `transport-grpc-spi` module enables plugin developers to:
     * Interceptors are executed in order based on their order() value,
### 1. Implement Custom Query Converter
for (QueryBuilderProtoConverter converter : queryConverters) {
  - [Testing](#testing)
                @Override
### 4. Testing Your Custom Converter
        MyCustomQuery customQuery = queryContainer.getMyCustomQuery();
      - [How Order Values Work](#how-order-values-work)
## Key Components
# src/main/resources/META-INF/services/org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter
### Understanding Interceptor Ordering
### QueryBuilderProtoConverter
}
    - [4. Testing Your Custom Converter](#4-testing-your-custom-converter)
            new GrpcInterceptorProvider.OrderedGrpcInterceptor() {
Each interceptor must have a unique order value.
    extendedPlugins = ['transport-grpc']  // Declare extension here
        );
  - [gRPC Interceptors](#grpc-interceptors)
            .setValue("test_value")
```gradle
If your converter needs to handle nested queries (like k-NN's filter clause), you'll need access to the registry to convert other query types. The transport-grpc plugin will inject the registry into your converter.
    }
    - [1. Implement Custom Query Converter](#1-implement-custom-query-converter)
    @Override
```
- [OpenSearch Reporting Plugin](https://github.com/opensearch-project/reporting/blob/main/build.gradle#L92)
        return Arrays.asList(
            knnQuery.getVectorList().toArray(new Float[0]),
For `GrpcServiceFactory` implementations:
```
        this.registry = registry;
- [OpenSearch k-NN Plugin](https://github.com/opensearch-project/k-NN/blob/main/build.gradle#L319)
### 2. Declare Extension in build.gradle
                }
    }
            QueryBuilder filterQuery = registry.fromProto(filterContainer);
```
    }
```
For `QueryBuilderProtoConverter` implementations:
```java
    public QueryBuilder fromProto(QueryContainer queryContainer) {
    converter.setRegistry(queryRegistry);
            customQuery.getField(),
**1. Dependency in build.gradle:**
```
```
  - [Overview](#overview)
    public QueryBuilder fromProto(QueryContainer queryContainer) {
**For contributing to OpenSearch gRPC APIs, see the [Contributing to gRPC APIs](../README.md#contributing-to-grpc-apis) guide in the transport-grpc module.**
    }
        // Convert your custom protobuf query to QueryBuilder
                                             ScriptService scriptService, NamedXContentRegistry xContentRegistry,
}
    MyCustomQueryBuilder customQuery = (MyCustomQueryBuilder) result;
        // Handle nested queries using the injected registry
```
    QueryContainer queryContainer = QueryContainer.newBuilder()
    MyCustomQueryConverter converter = new MyCustomQueryConverter();
        }
    - [QueryBuilderProtoConverterRegistry](#querybuilderprotoconverterregistry)
## GrpcServiceFactory
    - [1. Add Dependency](#1-add-dependency)
                public ServerInterceptor getInterceptor() {
            QueryContainer filterContainer = customQuery.getFilter();
    @Override
        int order();  // Lower values execute first
}
**Why k-NN needs the registry:**
`src/main/resources/META-INF/services/org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter`:
    }
            }
        .build();
```
    public Collection<Object> createComponents(Client client, ClusterService clusterService,
```java
     * Nested interface for ordered gRPC interceptors.
**Registry Access Pattern for Converters with Nested Queries**:
                        threadContext.putTransient("grpc.method", methodName);
            // Second interceptor (order = 10, runs after first)
                @Override
```
Create a service file denoting your plugin's implementation of a service interface.
Interface for converting protobuf query messages to OpenSearch QueryBuilder objects.
compileOnly "org.opensearch:protobufs:0.8.0"
    }
    // Convert and verify
compileOnly "org.opensearch.plugin:transport-grpc-spi:${opensearch.version}"
@Test
Interface for providing gRPC interceptors that can intercept and process all incoming gRPC requests. This enables plugins to implement cross-cutting concerns like authentication, authorization, logging, and metrics collection.
- Extend gRPC protocol buffer handling
                        System.out.println("First interceptor - Method: " + methodName);
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
    public List<GrpcInterceptorProvider.OrderedGrpcInterceptor> getOrderedGrpcInterceptors(ThreadContext threadContext) {
**2. Converter Implementation with Registry Access:**
            // First interceptor (order = 5, runs first)
org.opensearch.mypackage.MyCustomGrpcServiceFactory
**4. SPI File:**
                }
    compileOnly 'io.grpc:grpc-api:${versions.grpc}'
```
  - [Key Components](#key-components)
}
Add the SPI dependency to your plugin's `build.gradle`:
    private QueryBuilderProtoConverterRegistry registry;
            QueryContainer filterContainer = knnQuery.getFilter();
    @Override
- Register gRPC interceptors with explicit ordering
    @Override
public class KNNQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
### 1. Implement Custom Service Factory
Interface for accessing the query converter registry. This provides a clean abstraction for plugins that need to convert nested queries without exposing internal implementation details.
Request → [order=5] → [order=10] → [order=100] → Service Handler
    assertEquals("test_value", customQuery.value());
                    return (call, headers, next) -> {
    private QueryBuilderProtoConverterRegistry registry;
Interface for providing a `BindableService` factory to be registered on the grpc transport.
Intercept incoming gRPC requests for authentication, authorization, logging, metrics, rate limiting, etc. Interceptors have access to OpenSearch's `ThreadContext` to store and retrieve request-scoped data.
```bash
    }
            knnQuery.getField(),
}
    @Override
        this.registry = registry;
org.opensearch.mypackage.MyCustomQueryConverter
org.opensearch.knn.grpc.proto.request.search.query.KNNQueryBuilderProtoConverter
  - [GrpcServiceFactory](#grpcservicefactory-1)
    }
        return List.of(new MockChannelzService());
```
    - [Basic Usage](#basic-usage)
### 1. Add Dependency
In your `build.gradle`, declare that your plugin extends `transport-grpc`. This automatically adds the `extended.plugins=transport-grpc` entry to the auto-generated `plugin-descriptor.properties` file:
// In KNNPlugin.createComponents()
    - [GrpcServiceFactory](#grpcservicefactory)
```java
            knnQuery.getK()
## gRPC Interceptors
public class MyCustomQueryConverter implements QueryBuilderProtoConverter {
}
     * with lower values executing first (e.g., 10 before 20).
    }
        // Return your converter instance - the transport-grpc plugin will discover and register it
```
### 2. Register Your Converter
        if (customQuery.hasFilter()) {
    QueryContainer.QueryContainerCase getHandledQueryCase();
**How k-NN Now Accesses Built-in Converters**:
        return builder;
        );
# transport-grpc-spi
    QueryBuilder fromProto(QueryContainer queryContainer);
                        String methodName = call.getMethodDescriptor().getFullMethodName();
        // Converters that handle nested queries should override this method
            },
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
    }
}
    assertThat(result, instanceOf(MyCustomQueryBuilder.class));
        // The utility class can now convert nested queries using the injected registry
        return Collections.singletonList(new MyCustomQueryConverter());
    private QueryBuilderProtoConverterRegistry registry;
## Overview
public interface QueryBuilderProtoConverter {
                                             NamedWriteableRegistry namedWriteableRegistry,
                public int order() { return 5; } // Lower = higher priority
        return builder;
```
        MyCustomQueryBuilder builder = new MyCustomQueryBuilder(
        return "MockExtendingPlugin";
    // Register the converter
```java
public static class MockServiceProvider implements GrpcServiceFactory {
    List<OrderedGrpcInterceptor> getOrderedGrpcInterceptors();
```
### Unit Tests
```java
}
Interceptors are executed based on their `order()` value. Lower order values execute first. The interceptor chain processes requests from lowest to highest order value.
    /**
```
Service Provider Interface (SPI) for the OpenSearch gRPC transport module. This module provides interfaces and utilities that allow external plugins to extend the gRPC transport functionality.
public interface QueryBuilderProtoConverter {
                        System.out.println("Second interceptor - Processing request");
public class KNNQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
```
        KNNQueryBuilderProtoUtils.setRegistry(registry);
    compileOnly 'org.opensearch.plugin:transport-grpc-spi:${opensearch.version}'
    interface OrderedGrpcInterceptor {
                                             Supplier<RepositoriesService> repositoriesServiceSupplier) {
    // Inject the populated registry into the converter
```java
```
    - [GrpcInterceptorProvider](#grpcinterceptorprovider)
    }
    public String plugin() {
### 3. Accessing the Registry (For Complex Queries)
public class MyCustomQueryConverter implements QueryBuilderProtoConverter {
    @Override
```
```
```
    public List<BindableService> build() {
    }
}
                @Override
    compileOnly 'org.opensearch:protobufs:${protobufs.version}'
        );
### GrpcServiceFactory
KNNQueryBuilderProtoConverter knnQueryConverter = new KNNQueryBuilderProtoConverter();
### GrpcInterceptorProvider
    assertEquals("test_field", customQuery.fieldName());
```
    @Override
See the k-NN plugin https://github.com/opensearch-project/k-NN/pull/2833/files for an example on how to use this SPI, including handling nested queries.
        this.registry = registry;
}
                        return next.startCall(call, headers);
    }
            .setField("test_field")
                @Override
    QueryBuilder fromProto(QueryContainer queryContainer);
  - [QueryBuilderProtoConverter](#querybuilderprotoconverter-1)
```
            customQuery.getValue()
    - [3. Create SPI Registration File(s)](#3-create-spi-registration-files)
    default void setRegistry(QueryBuilderProtoConverterRegistry registry) {
  - [Usage for Plugin Developers](#usage-for-plugin-developers)
A plugin's `GrpcServiceFactory` implementation will be discovered through the SPI registration file and registered on the gRPC transport.
                    };
public interface GrpcInterceptorProvider {

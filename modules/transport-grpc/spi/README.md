public class KNNQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
### Overview
```java
```
                                             ScriptService scriptService, NamedXContentRegistry xContentRegistry,
```
        // By default, converters don't need a registry
public class SampleInterceptorProvider implements GrpcInterceptorProvider {
```java
Several node resources are exposed to a `GrpcServiceFactory` for use within services such as client, settings, and thread pools.
    description 'Your plugin description'
        .build();
Interceptors are executed based on their `order()` value. Lower order values execute first. The interceptor chain processes requests from lowest to highest order value.
    public QueryBuilder fromProto(QueryContainer queryContainer) {
            builder.filter(filterQuery);
A plugin's `GrpcServiceFactory` implementation will be discovered through the SPI registration file and registered on the gRPC transport.
Interface for accessing the query converter registry. This provides a clean abstraction for plugins that need to convert nested queries without exposing internal implementation details.
```
    - [GrpcInterceptorProvider](#grpcinterceptorprovider)
```
            new GrpcInterceptorProvider.OrderedGrpcInterceptor() {
        return Collections.singletonList(new MyCustomQueryConverter());
The k-NN query's `filter` field is a `QueryContainer` protobuf type that can contain any query type (MatchAll, Term, Terms, etc.). The k-NN converter needs access to the registry to convert these nested queries to their corresponding QueryBuilder objects.
    @Override
        }
    - [Basic Usage](#basic-usage)
```
### GrpcServiceFactory
### Unit Tests
    - [GrpcServiceFactory](#grpcservicefactory)
    @Override
    }
`src/main/resources/META-INF/services/org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter`:
    @Override
        );
See the k-NN plugin https://github.com/opensearch-project/k-NN/pull/2833/files for an example on how to use this SPI, including handling nested queries.
#### How Order Values Work
     */
```
    @Override
    @Override
    @Override
**4. SPI File:**
}
- [OpenSearch k-NN Plugin](https://github.com/opensearch-project/k-NN/blob/main/build.gradle#L319)
        return KNNQueryBuilderProtoUtils.fromProto(queryContainer.getKnn());
```java
    assertEquals("test_field", customQuery.fieldName());
  - [Usage for Plugin Developers](#usage-for-plugin-developers)
    public List<BindableService> build() {
    @Override
# transport-grpc-spi
Service Provider Interface (SPI) for the OpenSearch gRPC transport module. This module provides interfaces and utilities that allow external plugins to extend the gRPC transport functionality.
  - [Table of Contents](#table-of-contents)
    }
### 3. Create SPI Registration File(s)
     * Nested interface for ordered gRPC interceptors.
     * Interceptors are executed in order based on their order() value,
public interface GrpcInterceptorProvider {
            },
public static class MockServiceProvider implements GrpcServiceFactory {
    compileOnly 'io.grpc:grpc-api:${versions.grpc}'
  - [QueryBuilderProtoConverter](#querybuilderprotoconverter-1)
    @Override
```java
        return builder;
    }
The gRPC plugin **injects the populated registry** into converters that need it:
        return QueryContainer.QueryContainerCase.MY_CUSTOM_QUERY;
        // Return your converter instance - the transport-grpc plugin will discover and register it
            QueryBuilder filterQuery = registry.fromProto(filterContainer);
    }
    MyCustomQueryConverter converter = new MyCustomQueryConverter();
    }
If your converter needs to handle nested queries (like k-NN's filter clause), you'll need access to the registry to convert other query types. The transport-grpc plugin will inject the registry into your converter.
```
## Key Components
        return List.of(new MockChannelzService());
```
Each interceptor must have a unique order value.
public class MyCustomQueryConverter implements QueryBuilderProtoConverter {
    public String plugin() {
    QueryBuilder result = converter.fromProto(queryContainer);
return ImmutableList.of(knnStats, knnQueryConverter);
// 1. Converter interface has a default setRegistry method
    - [Unit Tests](#unit-tests)
        // The utility class can now convert nested queries using the injected registry
    - [2. Register Your Converter](#2-register-your-converter)
for (QueryBuilderProtoConverter converter : queryConverters) {
```java
        MyCustomQuery customQuery = queryContainer.getMyCustomQuery();
### QueryBuilderProtoConverterRegistry
        MyCustomQuery customQuery = queryContainer.getMyCustomQuery();
        if (customQuery.hasFilter()) {
### 1. Add Dependency
- [OpenSearch Reporting Plugin](https://github.com/opensearch-project/reporting/blob/main/build.gradle#L92)
        // Converters that handle nested queries should override this method
    assertEquals("test_value", customQuery.value());
    private QueryBuilderProtoConverterRegistry registry;
```
    @Override
    // Convert and verify
            QueryContainer filterContainer = customQuery.getFilter();
### 1. Implement Custom Query Converter
`src/main/resources/META-INF/services/org.opensearch.transport.grpc.spi.GrpcServiceFactory`:
    private QueryBuilderProtoConverterRegistry registry;
```
    public Collection<Object> createComponents(Client client, ClusterService clusterService,
    public QueryBuilder fromProto(QueryContainer queryContainer) {
# src/main/resources/META-INF/services/org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter
**For contributing to OpenSearch gRPC APIs, see the [Contributing to gRPC APIs](../README.md#contributing-to-grpc-apis) guide in the transport-grpc module.**
    - [QueryBuilderProtoConverterRegistry](#querybuilderprotoconverterregistry)
            customQuery.getValue()
    default void setRegistry(QueryBuilderProtoConverterRegistry registry) {
            .setField("test_field")
```
                public ServerInterceptor getInterceptor() {
    QueryContainer queryContainer = QueryContainer.newBuilder()
  - [Testing](#testing)
public interface QueryBuilderProtoConverter {
        // Convert your custom protobuf query to QueryBuilder
```
## QueryBuilderProtoConverter
    converter.setRegistry(queryRegistry);
**Why k-NN needs the registry:**
    }
  - [gRPC Interceptors](#grpc-interceptors)
            new GrpcInterceptorProvider.OrderedGrpcInterceptor() {
```
}
    }
                                             NamedWriteableRegistry namedWriteableRegistry,
## Usage for Plugin Developers
org.opensearch.mypackage.MyCustomGrpcServiceFactory
**3. Plugin Registration:**
## Overview
- Implement custom query converters for gRPC transport
    public List<GrpcInterceptorProvider.OrderedGrpcInterceptor> getOrderedGrpcInterceptors(ThreadContext threadContext) {
org.opensearch.knn.grpc.proto.request.search.query.KNNQueryBuilderProtoConverter
            knnQuery.getVectorList().toArray(new Float[0]),
### 2. Register Your Converter
    public QueryBuilder fromProto(QueryContainer queryContainer) {
                @Override
### 3. Accessing the Registry (For Complex Queries)
    assertThat(result, instanceOf(MyCustomQueryBuilder.class));
```
In your plugin's main class, return the converter from createComponents:
```
```
org.opensearch.mypackage.MyCustomQueryConverter
// 2. GrpcPlugin injects registry into loaded extensions
- Register gRPC interceptors with explicit ordering
            knnQuery.getField(),
Create a service file denoting your plugin's implementation of a service interface.
- [transport-grpc-spi](#transport-grpc-spi)
### 4. Testing Your Custom Converter
        KNNQueryBuilderProtoUtils.setRegistry(registry);
```groovy
            .setValue("test_value")
```java
  - [GrpcServiceFactory](#grpcservicefactory-1)
    queryRegistry.registerConverter(converter);
    // Inject the populated registry into the converter
    }
    }
        );
            QueryBuilder filterQuery = registry.fromProto(filterContainer);
        int order();  // Lower values execute first
### GrpcInterceptorProvider
```
- Register `BindableService` implementation to the gRPC transport
KNNQueryBuilderProtoConverter knnQueryConverter = new KNNQueryBuilderProtoConverter();
./gradlew :modules:transport-grpc:spi:test
    - [2. Declare Extension in build.gradle](#2-declare-extension-in-buildgradle)
### 1. Implement Custom Service Factory
The `transport-grpc-spi` module enables plugin developers to:
    @Override
    @Override
        // Handle nested filter query using injected registry
    compileOnly 'org.opensearch.plugin:transport-grpc-spi:${opensearch.version}'
                                             IndexNameExpressionResolver indexNameExpressionResolver,
public void testCustomQueryConverter() {
        return "MockExtendingPlugin";
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
  - [Overview](#overview)
```
    - [1. Add Dependency](#1-add-dependency)
    }
    QueryBuilder fromProto(QueryContainer queryContainer);
        );
    MyCustomQueryBuilder customQuery = (MyCustomQueryBuilder) result;
    - [Understanding Interceptor Ordering](#understanding-interceptor-ordering)
## GrpcServiceFactory
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
Intercept incoming gRPC requests for authentication, authorization, logging, metrics, rate limiting, etc. Interceptors have access to OpenSearch's `ThreadContext` to store and retrieve request-scoped data.
```
        this.registry = registry;
For `QueryBuilderProtoConverter` implementations:
- Extend gRPC protocol buffer handling
                        threadContext.putTransient("grpc.method", methodName);
```
    - [3. Accessing the Registry (For Complex Queries)](#3-accessing-the-registry-for-complex-queries)
                @Override
                        return next.startCall(call, headers);
     * with lower values executing first (e.g., 10 before 20).
        KnnQuery knnQuery = queryContainer.getKnn();
**How k-NN Now Accesses Built-in Converters**:
```java
    public QueryBuilder fromProto(QueryContainer queryContainer) {
### Basic Usage
```
    extendedPlugins = ['transport-grpc']  // Declare extension here
  - [Key Components](#key-components)
```
}
            .build())
            // Second interceptor (order = 10, runs after first)
        MyCustomQueryBuilder builder = new MyCustomQueryBuilder(
}
```
Request → [order=5] → [order=10] → [order=100] → Service Handler
}
        return QueryContainer.QueryContainerCase.KNN;
                        System.out.println("Second interceptor - Processing request");
    interface OrderedGrpcInterceptor {
                        System.out.println("First interceptor - Method: " + methodName);
Each interceptor must have a unique order value. If duplicate order values are detected, OpenSearch will fail to start with an `IllegalArgumentException`.
**Registry Injection Pattern**
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
    - [1. Implement Custom Service Factory](#1-implement-custom-service-factory)
            }
        .setMyCustomQuery(MyCustomQuery.newBuilder()
@Test
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
                    return (call, headers, next) -> {
### Understanding Interceptor Ordering
                        return next.startCall(call, headers);
// In KNNPlugin.createComponents()
    }
compileOnly "org.opensearch:protobufs:0.8.0"
        ServerInterceptor getInterceptor();
IllegalArgumentException: Multiple gRPC interceptors have the same order value: 10.
**Registry Access Pattern for Converters with Nested Queries**:
```gradle
```
public class MyCustomQueryConverter implements QueryBuilderProtoConverter {
        }
    - [Overview](#overview-1)
    compileOnly 'org.opensearch:protobufs:${protobufs.version}'
                public int order() { return 5; } // Lower = higher priority
compileOnly "org.opensearch.plugin:transport-grpc-spi:${opensearch.version}"
                @Override
      - [How Order Values Work](#how-order-values-work)
## Real-World Example: k-NN Plugin
    QueryBuilder fromProto(QueryContainer queryContainer);
In your `build.gradle`, declare that your plugin extends `transport-grpc`. This automatically adds the `extended.plugins=transport-grpc` entry to the auto-generated `plugin-descriptor.properties` file:
    /**
                                             Environment environment, NodeEnvironment nodeEnvironment,
}
  - [Real-World Example: k-NN Plugin](#real-world-example-k-nn-plugin)
For `GrpcServiceFactory` implementations:
            builder.filter(filterQuery);
```java
- Register custom query types that can be processed via gRPC
                public int order() { return 10; }
            // First interceptor (order = 5, runs first)
**1. Implement Provider:**
Interface for converting protobuf query messages to OpenSearch QueryBuilder objects.
                    };
                        String methodName = call.getMethodDescriptor().getFullMethodName();
      - [Duplicate Order Values](#duplicate-order-values)
## Testing
org.opensearch.mypackage.SampleInterceptorProvider
    }
        return new MyCustomQueryBuilder(customQuery.getField(), customQuery.getValue());
```java
    }
public class KNNQueryBuilderProtoConverter implements QueryBuilderProtoConverter {
}
```
        KNNQueryBuilder builder = new KNNQueryBuilder(
Add the SPI dependency to your plugin's `build.gradle`:
## gRPC Interceptors
    classname 'org.opensearch.yourplugin.YourPlugin'
---
    @Override
    }
```
public interface QueryBuilderProtoConverter {
        this.registry = registry;
            customQuery.getField(),
    name 'your-plugin-name'
}
    // Create test protobuf query
Interface for providing gRPC interceptors that can intercept and process all incoming gRPC requests. This enables plugins to implement cross-cutting concerns like authentication, authorization, logging, and metrics collection.
```gradle
**2. Converter Implementation with Registry Access:**
```
    List<OrderedGrpcInterceptor> getOrderedGrpcInterceptors();
        // Handle nested queries using the injected registry
    private QueryBuilderProtoConverterRegistry registry;
        return Arrays.asList(
}
`src/main/resources/META-INF/services/org.opensearch.transport.grpc.spi.GrpcInterceptorProvider`:
### 2. Declare Extension in build.gradle
```java
```
            QueryContainer filterContainer = knnQuery.getFilter();
    public void setRegistry(QueryBuilderProtoConverterRegistry registry) {
        this.registry = registry;
**1. Dependency in build.gradle:**
```java
}
                    };
    - [QueryBuilderProtoConverter](#querybuilderprotoconverter)
**Context Preservation:** The transport-grpc module automatically preserves ThreadContext across async boundaries. Any data set by interceptors will be available in the gRPC service implementation, even when execution switches to different threads.
}
    // Register the converter
                    return (call, headers, next) -> {
                                             Supplier<RepositoriesService> repositoriesServiceSupplier) {
                }
    - [1. Implement Custom Query Converter](#1-implement-custom-query-converter)
}
    - [3. Create SPI Registration File(s)](#3-create-spi-registration-files)
Interface for providing a `BindableService` factory to be registered on the grpc transport.
    }
```bash
                @Override
    @Override
        if (knnQuery.hasFilter()) {
}
**Real-world examples:**
    - [4. Testing Your Custom Converter](#4-testing-your-custom-converter)
                public ServerInterceptor getInterceptor() {
dependencies {
#### Duplicate Order Values
                                             ThreadPool threadPool, ResourceWatcherService resourceWatcherService,
### QueryBuilderProtoConverter
For `GrpcInterceptorProvider` implementations:
        // Pass the registry to utility classes that need it
## Table of Contents
        return builder;
```java
}
public class MyPlugin extends Plugin {
                }
            knnQuery.getK()
opensearchplugin {
    QueryContainer.QueryContainerCase getHandledQueryCase();

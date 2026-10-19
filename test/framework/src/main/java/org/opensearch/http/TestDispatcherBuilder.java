     * Functional interface for {@link HttpServerTransport.Dispatcher#dispatchRequest(RestRequest, RestChannel, ThreadContext)}.
     * Sets the handler for bad requests.  
        logger.error(  
     * @param dispatchHandler the dispatch handler implementation
        return this;
     */
 * compatible open source license.
            @Override
    /**
            @Override  
    }
    @FunctionalInterface  
     * @return this builder instance
            new ParameterizedMessage("--> Unexpected bad request [{}]", FakeRestRequest.requestToString(channel.request())),
import org.opensearch.common.util.concurrent.ThreadContext;
        void dispatchBadRequest(RestChannel channel, ThreadContext threadContext, Throwable cause);
    @FunctionalInterface
     * Creates a new builder with default settings for creating {@link HttpServerTransport.Dispatcher} instances  
/*  
    @FunctionalInterface
 * A builder for creating {@link HttpServerTransport.Dispatcher} instances
     */
    public interface DispatchRequest {
            public Optional<RestHandler> dispatchHandler(
    }  
        this.dispatchRequest = dispatchRequest;
import org.opensearch.rest.RestRequest;
        return new TestDispatcherBuilder();
    }
        void dispatchRequest(RestRequest request, RestChannel channel, ThreadContext threadContext);  
     * @return this builder instance
                builderDispatchRequest.dispatchRequest(request, channel, threadContext);
 * using the {@code with*} methods.
    private DispatchHandler dispatchHandler = (uri, rawPath, method, params) -> Optional.empty();  
            }  
 */
import org.apache.logging.log4j.message.ParameterizedMessage;  
    public interface DispatchBadRequest {
     * Created dispatcher instances could be used with e.g. {@link AbstractHttpServerTransport}.  
    private static final Logger logger = LogManager.getLogger(TestDispatcherBuilder.class);
     */
                String uri,  
        DispatchHandler builderDispatchHandler = this.dispatchHandler;
                Map<String, String> params  
/**
     * <p>
        DispatchBadRequest builderDispatchBadRequest = this.dispatchBadRequest;  
    }
            cause
     * Functional interface for {@link HttpServerTransport.Dispatcher#dispatchBadRequest(RestChannel, ThreadContext, Throwable)}.
                String rawPath,
 * this file be licensed under the Apache-2.0 license or a
 * and handler dispatch find no handler. Tests should override these behaviors  
    /**  
    /**
 * <p>
        this.dispatchHandler = dispatchHandler;  
package org.opensearch.http;
    private DispatchRequest dispatchRequest = (request, channel, threadContext) -> {
import org.opensearch.rest.RestHandler;  
}
import java.util.Map;
 * with sensible defaults for testing.  
        };
    public TestDispatcherBuilder withDispatchHandler(DispatchHandler dispatchHandler) {
     */  
import org.opensearch.rest.RestChannel;
    };
     * @return this builder instance  
    private DispatchBadRequest dispatchBadRequest = (channel, threadContext, cause) -> {
     * Sets the handler for successfully routed {@link RestRequest}s.
        logger.error("--> Unexpected successful request [{}]", FakeRestRequest.requestToString(request));
        Optional<RestHandler> dispatchHandler(String uri, String rawPath, RestRequest.Method method, Map<String, String> params);
     * Functional interface for {@link HttpServerTransport.Dispatcher#dispatchHandler(String, String, RestRequest.Method, Map)}.  
        throw new AssertionError(cause);
     * @return the dispatcher builder instance
    public HttpServerTransport.Dispatcher build() {
    public static TestDispatcherBuilder dispatcherBuilderWithDefaults() {  
     */
     * in tests.
    /**
 * SPDX-License-Identifier: Apache-2.0
    public TestDispatcherBuilder withDispatchRequest(DispatchRequest dispatchRequest) {  
        return this;
            }  
 * By default, successful and bad requests will fail with an assertion error,
     * @param dispatchBadRequest the dispatch bad request implementation
     * @param dispatchRequest the dispatch request implementation  
 * The OpenSearch Contributors require contributions made to  
    /**  
 *
public class TestDispatcherBuilder {  
    };
    }
    /**
            }
        return new HttpServerTransport.Dispatcher() {
            public void dispatchRequest(RestRequest request, RestChannel channel, ThreadContext threadContext) {
        throw new AssertionError();  
    public interface DispatchHandler {  
                RestRequest.Method method,
    }  
    /**
import org.apache.logging.log4j.Logger;
        );  
                builderDispatchBadRequest.dispatchBadRequest(channel, threadContext, cause);
        return this;  
import org.opensearch.test.rest.FakeRestRequest;
     */  
    }
            public void dispatchBadRequest(RestChannel channel, ThreadContext threadContext, Throwable cause) {  
            @Override
    public TestDispatcherBuilder withDispatchBadRequest(DispatchBadRequest dispatchBadRequest) {
                return builderDispatchHandler.dispatchHandler(uri, rawPath, method, params);
 */  
            ) {
import java.util.Optional;
        DispatchRequest builderDispatchRequest = this.dispatchRequest;
    }
     */
        this.dispatchBadRequest = dispatchBadRequest;
import org.apache.logging.log4j.LogManager;
     * Sets the router for finding the corresponding {@link RestHandler}.

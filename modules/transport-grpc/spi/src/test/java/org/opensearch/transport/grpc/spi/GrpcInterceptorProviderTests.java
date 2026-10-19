            public int order() {  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        private final int order;  
                        return next.startCall(call, headers);
            @Override
    public void testProviderReceivesThreadContext() {  
                        ServerCallHandler<ReqT, RespT> next
                assertNotNull("ThreadContext should not be null", ctx);
                return order;
/*  
            @Override
            return Collections.singletonList(createTestInterceptor(order, "test-interceptor"));
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(10, interceptors.get(0).order());
            }
import org.opensearch.test.OpenSearchTestCase;  
        };
    }
 *
    /**  
        }
import org.opensearch.common.util.concurrent.ThreadContext;
                    @Override
import java.util.List;  
                // Verify that the provider receives the ThreadContext
        List<GrpcInterceptorProvider.OrderedGrpcInterceptor> interceptors = provider.getOrderedGrpcInterceptors(threadContext);
import io.grpc.ServerCall;  
                assertEquals("test-value", ctx.getHeader("X-Test-Header"));  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                    }
        List<GrpcInterceptorProvider.OrderedGrpcInterceptor> interceptors = provider.getOrderedGrpcInterceptors(threadContext);
        TestGrpcInterceptorProvider(int order) {
    public void testProviderReturnsEmptyList() {
                return new ServerInterceptor() {  
        assertTrue(interceptors.isEmpty());  
            @Override
     */
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        return new GrpcInterceptorProvider.OrderedGrpcInterceptor() {
            public List<GrpcInterceptorProvider.OrderedGrpcInterceptor> getOrderedGrpcInterceptors(ThreadContext threadContext) {
                        Metadata headers,
                return Collections.emptyList();  
                        ServerCall<ReqT, RespT> call,  
import io.grpc.ServerCallHandler;
 * SPDX-License-Identifier: Apache-2.0
    }  
        provider.getOrderedGrpcInterceptors(threadContext);
import io.grpc.ServerInterceptor;
        };
package org.opensearch.transport.grpc.spi;
 * compatible open source license.
    }
    public void testBasicProviderImplementation() {  
        GrpcInterceptorProvider provider = new GrpcInterceptorProvider() {
        }  
        GrpcInterceptorProvider provider = new GrpcInterceptorProvider() {  
                };  
 * The OpenSearch Contributors require contributions made to  
                return Collections.emptyList();
    private static class TestGrpcInterceptorProvider implements GrpcInterceptorProvider {
            public List<GrpcInterceptorProvider.OrderedGrpcInterceptor> getOrderedGrpcInterceptors(ThreadContext ctx) {  
                    ) {  
            }
        };  
        threadContext.putHeader("X-Test-Header", "test-value");
}
        assertNotNull(interceptors);
 */  
            }
        TestGrpcInterceptorProvider provider = new TestGrpcInterceptorProvider(10);
            @Override
        assertNotNull(interceptors);
        assertEquals(1, interceptors.size());  
            public ServerInterceptor getInterceptor() {
import java.util.Collections;
import org.opensearch.common.settings.Settings;
        @Override  
import io.grpc.Metadata;
            this.order = order;  
     * Creates a test OrderedGrpcInterceptor
public class GrpcInterceptorProviderTests extends OpenSearchTestCase {
    }  
    private static GrpcInterceptorProvider.OrderedGrpcInterceptor createTestInterceptor(int order, String name) {  
            }
        public List<GrpcInterceptorProvider.OrderedGrpcInterceptor> getOrderedGrpcInterceptors(ThreadContext threadContext) {
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(

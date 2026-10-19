        @Override
        assertTrue(services.get(0) instanceof MockChannelzService);
        }
            return "MockTestPlugin";
}
            return client;
        assertNotNull(services);  
import io.grpc.BindableService;  
 * this file be licensed under the Apache-2.0 license or a
    }  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        public GrpcServiceFactory initClient(Client client) {  
        assertEquals("MockTestPlugin", factory.plugin());
            return List.of(new MockChannelzService());
        public void getChannel(GetChannelRequest request, StreamObserver<GetChannelResponse> responseObserver) {  
    private static class MockChannelzService extends ChannelzGrpc.ChannelzImplBase {
        assertEquals(1, services.size());
        List<BindableService> services = factory.build();
import io.grpc.channelz.v1.ChannelzGrpc;
 * The OpenSearch Contributors require contributions made to  
        public List<BindableService> build() {  
import org.opensearch.transport.client.Client;
            GetChannelResponse response = GetChannelResponse.newBuilder().build();
            this.client = client;
import org.opensearch.test.OpenSearchTestCase;
        MockServiceProvider factory = new MockServiceProvider();  
        public Client getClient() {
    public void testGrpcServiceFactoryPlugin() {  
        }  
        }  
            return this;
        GrpcServiceFactory result = factory.initClient(mockClient);  
        Client mockClient = mock(Client.class);
    public static class MockServiceProvider implements GrpcServiceFactory {
        assertSame(factory, result);
        }  
public class GrpcServiceFactoryTests extends OpenSearchTestCase {
    }
        private Client client;
    }  
    }
import java.util.List;
        @Override
        @Override  
import io.grpc.stub.StreamObserver;
/*  
        public MockServiceProvider() {}
        assertSame(mockClient, factory.getClient());  
import io.grpc.channelz.v1.GetChannelRequest;
        MockServiceProvider factory = new MockServiceProvider();
        public String plugin() {
    public void testGrpcServiceFactoryInitClient() {
            responseObserver.onNext(response);
    }
        }
 */  
        MockServiceProvider factory = new MockServiceProvider();  
    public void testGrpcServiceFactoryBuild() {
package org.opensearch.transport.grpc.spi;
 *
            responseObserver.onCompleted();  
import static org.mockito.Mockito.mock;  
import io.grpc.channelz.v1.GetChannelResponse;  
        @Override

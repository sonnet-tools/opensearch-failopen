 */  
import io.grpc.reflection.v1alpha.ServiceResponse;
                return GrpcServiceFactory.super.initSettings(settings);
            @Override
        @Override
                "classpath plugin",
                "classpath plugin",  
import io.grpc.channelz.v1.GetChannelRequest;
import org.opensearch.transport.grpc.ssl.NettyGrpcClient;  
public class LoadExtendingPluginServicesIT extends GrpcTransportBaseIT {
            @Override
 *
            ),  
            assertTrue("Failed to discover plugin provided service: grpc.channelz.v1.Channelz", foundMockService);
                Collections.emptyList(),
            }  
                "21",
            boolean foundMockService = servicesResp.stream().anyMatch(service -> service.getName().contains("grpc.channelz.v1.Channelz"));  
            @Override
            @Override
            }
package org.opensearch.transport.grpc;
                "21",  
    }
    @Override
import org.opensearch.plugins.Plugin;
import org.opensearch.plugins.PluginInfo;
                GrpcPlugin.class.getName(),
import org.opensearch.common.settings.Settings;  
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.transport.grpc.spi.GrpcServiceFactory;
import java.util.Collection;
                null,
    protected Collection<PluginInfo> additionalNodePlugins() {  
            GetChannelResponse response = GetChannelResponse.newBuilder().build();  
            }
                return GrpcServiceFactory.super.initClusterSettings(clusterSettings);  
            public GrpcServiceFactory initSettings(Settings settings) {  
    private static class MockChannelzService extends ChannelzGrpc.ChannelzImplBase {  
            }
                false
import io.grpc.stub.StreamObserver;
 * SPDX-License-Identifier: Apache-2.0
        }  
            public GrpcServiceFactory initClient(Client client) {
            responseObserver.onCompleted();
                Version.CURRENT,
    }  
                null,  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
            public MockServiceProvider() {}
                Version.CURRENT,  
    public void testListInjectedService() throws Exception {  
            @Override  
        return Collections.emptyList();
import org.opensearch.transport.client.Client;
                List.of(GrpcPlugin.class.getName()),  
    public static final class MockExtendingPlugin extends Plugin {  
}
        public MockExtendingPlugin() {}
            public String plugin() {
    }
            new PluginInfo(
    }
            }
import org.opensearch.threadpool.ThreadPool;  
                false
            public List<BindableService> build() {  
/*  
            }  
                return this;
        );  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            public GrpcServiceFactory initClusterSettings(ClusterSettings clusterSettings) {
            List<ServiceResponse> servicesResp = client.listServices().get();
        public static class MockServiceProvider implements GrpcServiceFactory {
        }  
                "NA",
            @Override  
                return List.of(new MockChannelzService());
            new PluginInfo(
            responseObserver.onNext(response);
import io.grpc.channelz.v1.GetChannelResponse;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.Version;
 * compatible open source license.
        return List.of(
                MockExtendingPlugin.class.getName(),
        try (NettyGrpcClient client = createGrpcClient()) {
        public void getChannel(GetChannelRequest request, StreamObserver<GetChannelResponse> responseObserver) {
                GrpcPlugin.class.getName(),  
import io.grpc.BindableService;  
import java.util.List;
            )
                "NA",
    }  
                return "MockExtendingPlugin";  
                return GrpcServiceFactory.super.initThreadPool(threadPool);
import io.grpc.channelz.v1.ChannelzGrpc;
import java.util.Collections;  
            public GrpcServiceFactory initThreadPool(ThreadPool threadPool) {
                MockExtendingPlugin.class.getName(),
        }

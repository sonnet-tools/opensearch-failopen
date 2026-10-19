    public Map<String, Supplier<HttpServerTransport>> getHttpTransports(
            ReactorNetty4HttpServerTransport.SETTING_H3_MAX_STREAMS
        ClusterSettings clusterSettings,
        Dispatcher dispatcher,
                xContentRegistry,
     * @param clusterSettings cluster settings
}  
            this.groupFactory.set(new SharedGroupFactory(settings));
                tracer
    ) {
        final SharedGroupFactory groupFactory = this.groupFactory.get();  
                settings,  
        CircuitBreakerService circuitBreakerService,
                bigArrays,
        HttpServerTransport.Dispatcher dispatcher,
import java.util.Map;  
     * @param settings settings
     * @param tracer tracer instance
import org.opensearch.plugins.NetworkPlugin;  
                secureHttpTransportSettingsProvider,
    @Override
import java.util.List;
                getSharedGroupFactory(settings),  
     * @param clusterSettings cluster settings  
     * @param bigArrays big array allocator
    ) {
    public static final String REACTOR_NETTY_HTTP_TRANSPORT_NAME = "reactor-netty4";
                bigArrays,
    @Override
            REACTOR_NETTY_SECURE_HTTP_TRANSPORT_NAME,
     * The name of new experimental HTTP transport implementations based on Reactor Netty.
                threadPool,
        BigArrays bigArrays,
                networkService,
     * @param xContentRegistry XContent registry instance
     * @param circuitBreakerService circuit breaker service instance  
        BigArrays bigArrays,
import org.opensearch.threadpool.ThreadPool;
            return this.groupFactory.get();  
            ReactorNetty4HttpServerTransport.SETTING_H3_MAX_STREAM_REMOTE_LENGTH,  
        SecureHttpTransportSettingsProvider secureHttpTransportSettingsProvider,  
import org.opensearch.common.network.NetworkService;
import org.opensearch.plugins.Plugin;
     */  
import java.util.Collections;
    /**
                threadPool,  
    /**
        ThreadPool threadPool,
        NetworkService networkService,  
 */
    public List<Setting<?>> getSettings() {
            ReactorNetty4HttpServerTransport.SETTING_H3_MAX_STREAM_LOCAL_LENGTH,
     * The name of new experimental secure HTTP transport implementations based on Reactor Netty.
     * @param bigArrays big array allocator  
        Tracer tracer  
     * @param xContentRegistry XContent registry instance
     */
                clusterSettings,
 * this file be licensed under the Apache-2.0 license or a
                getSharedGroupFactory(settings),
     */
    /**  
            REACTOR_NETTY_HTTP_TRANSPORT_NAME,  
 */  
     * @param threadPool thread pool instance
 * The OpenSearch Contributors require contributions made to  
        NamedXContentRegistry xContentRegistry,
     * @param networkService network service
                tracer  
    public static final String REACTOR_NETTY_SECURE_HTTP_TRANSPORT_NAME = "reactor-netty4-secure";  
                networkService,  
     */  
        return Collections.singletonMap(  
                settings,
 * SPDX-License-Identifier: Apache-2.0
        );
import org.opensearch.http.HttpServerTransport;  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        CircuitBreakerService circuitBreakerService,
        NamedXContentRegistry xContentRegistry,
    }  
        );
    public ReactorNetty4Plugin() {}
        Settings settings,  
                dispatcher,
        NetworkService networkService,  
        Tracer tracer
import org.opensearch.common.settings.ClusterSettings;
     * Default constructor
            assert groupFactory.getSettings().equals(settings) : "Different settings than originally provided";
        PageCacheRecycler pageCacheRecycler,  
     * @param dispatcher dispatcher instance  
     * @param networkService network service  
     * @param settings settings
import org.opensearch.plugins.SecureHttpTransportSettingsProvider;
     * @param threadPool thread pool instance  
     */  
    /**
    /**  
    public Map<String, Supplier<HttpServerTransport>> getSecureHttpTransports(
        if (groupFactory != null) {
import java.util.Arrays;  
        );
        ClusterSettings clusterSettings,
/**  
     * @param pageCacheRecycler page cache recycler instance
        ThreadPool threadPool,
        return Arrays.asList(
     * Returns a map of {@link HttpServerTransport} suppliers.  
 *
    @Override  
 * compatible open source license.
     */  
import org.opensearch.common.SetOnce;  
                null, /* no security settings provider */
                xContentRegistry,  
    /**
import org.opensearch.common.settings.Settings;
import org.opensearch.http.HttpServerTransport.Dispatcher;
            return groupFactory;  
        }
        Settings settings,  
    private final SetOnce<SharedGroupFactory> groupFactory = new SetOnce<>();
     * @param pageCacheRecycler page cache recycler instance
import org.opensearch.common.util.BigArrays;
                dispatcher,
     * @param secureHttpTransportSettingsProvider secure HTTP transport settings provider
package org.opensearch.transport.reactor;
    private SharedGroupFactory getSharedGroupFactory(Settings settings) {
     * @param dispatcher dispatcher instance
     * @param tracer tracer instance
            ReactorNetty4HttpServerTransport.SETTING_H2_MAX_CONCURRENT_STREAMS,
            ReactorNetty4HttpServerTransport.SETTING_H2C_MAX_CONTENT_LENGTH,  
            )
            () -> new ReactorNetty4HttpServerTransport(
    }  
     * Returns a list of additional {@link Setting} definitions for this plugin.
     * See {@link org.opensearch.common.network.NetworkModule#HTTP_TYPE_SETTING} to configure a specific implementation.
/*  
                clusterSettings,  
        } else {
import org.opensearch.common.settings.Setting;  
    }
import org.opensearch.common.util.PageCacheRecycler;  
public class ReactorNetty4Plugin extends Plugin implements NetworkPlugin {  
     * See {@link org.opensearch.common.network.NetworkModule#HTTP_TYPE_SETTING} to configure a specific implementation.  
        PageCacheRecycler pageCacheRecycler,  
            )  
            () -> new ReactorNetty4HttpServerTransport(
import org.opensearch.telemetry.tracing.Tracer;  
     * @param circuitBreakerService circuit breaker service instance
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * Returns a map of {@link HttpServerTransport} suppliers.
 * The experimental network plugin that introduces new transport implementations based on Reactor Netty.
import java.util.function.Supplier;
import org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport;
        return Collections.singletonMap(
    }

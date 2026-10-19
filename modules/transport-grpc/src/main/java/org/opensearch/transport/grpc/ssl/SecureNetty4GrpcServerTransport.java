import io.grpc.BindableService;  
        this.portSettingKey = SecureNetty4GrpcServerTransport.SETTING_GRPC_SECURE_PORT.getKey();
        public Collection<String> cipherSuites() {  
     * If SecureAuxTransportParameters empty, set ClientAuth OPTIONAL and allow all default supported ciphers.
            false,
        Settings settings,
        ClientAuth clientAuth = ClientAuth.valueOf(params.clientAuth().orElseThrow().toUpperCase(Locale.ROOT));
        ThreadPool threadPool,
        }
import javax.net.ssl.SSLContext;  
            params.cipherSuites(),
     * @param networkService the bind/publish addresses.
        @Override
        try {
     * Distinct port setting required as it depends on transport type key.
            ),  
        Optional<SSLContext> sslContext = provider.buildSecureAuxServerTransportContext(settings, this.settingKey());  
                ApplicationProtocolNames.HTTP_2 // gRPC -> always http2
            new ApplicationProtocolConfig(
import org.opensearch.transport.grpc.Netty4GrpcServerTransport;
            this.addServerConfig((NettyServerBuilder builder) -> builder.sslContext(ctxt));
     * @param settings the configured settings.
    /**
            } catch (NoSuchAlgorithmException e) {
    /**  
     * @param secureTransportSettingsProvider TLS configuration settings.  
    ) {
                ApplicationProtocolConfig.Protocol.ALPN,
    }
            DEFAULT_SSL_PROTOCOLS,
            SupportedCipherSuiteFilter.INSTANCE,  
            clientAuth,
    public String settingKey() {
import io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolNames;
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
        SecureAuxTransportSettingsProvider secureTransportSettingsProvider,
        }
        }  
import io.grpc.netty.shaded.io.netty.handler.ssl.ClientAuth;
            JdkSslContext ctxt = getSslContext(settings, secureTransportSettingsProvider);  
    /**
                ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,
 */  
        NetworkService networkService,  
     * If optional SSLContext is empty, use default context as configured through JDK.  
    public static final String GRPC_SECURE_TRANSPORT_SETTING_KEY = "secure-transport-grpc";
            return Optional.of(ClientAuth.REQUIRE.name());
import org.opensearch.common.network.NetworkService;
    }
import io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig;  
import io.grpc.netty.shaded.io.netty.handler.ssl.SupportedCipherSuiteFilter;
     * into the NettyServerBuilder config to enable TLS on the server.
import java.util.Locale;  
/**  
import java.security.NoSuchAlgorithmException;  
        this.port = SecureNetty4GrpcServerTransport.SETTING_GRPC_SECURE_PORT.get(settings);  
            sslContext.get(),  
        List<BindableService> services,
     */
        } catch (Exception e) {
 * The OpenSearch Contributors require contributions made to  
}  
    /**  
        if (sslContext.isEmpty()) {
        public Optional<String> clientAuth() {
    @Override
 * compatible open source license.
    }  
     */
        super(settings, services, networkService, threadPool, serverInterceptor);
            .orElseGet(DefaultParameters::new);  
        @Override  
     * @param settings the configured settings.
        );
import org.opensearch.threadpool.ThreadPool;  
    private static class DefaultParameters implements SecureAuxTransportSettingsProvider.SecureAuxTransportParameters {
            }  
public class SecureNetty4GrpcServerTransport extends Netty4GrpcServerTransport {
 * SPDX-License-Identifier: Apache-2.0
        ServerInterceptor serverInterceptor  
    private JdkSslContext getSslContext(Settings settings, SecureAuxTransportSettingsProvider provider) throws SSLException {
     */
     * Creates a new SecureNetty4GrpcServerTransport instance and inject a SecureAuxTransportSslContext  
import io.grpc.ServerInterceptor;
            true  
    public static final Setting<PortsRange> SETTING_GRPC_SECURE_PORT = AUX_TRANSPORT_PORT.getConcreteSettingForNamespace(  
    private static final String[] DEFAULT_SSL_PROTOCOLS = { "TLSv1.3", "TLSv1.2", "TLSv1.1" };
     * configurations settings in SecureAuxTransportParameters for this transport.
/*  
import org.opensearch.common.transport.PortsRange;
     */
 * Netty4GrpcServerTransport with TLS enabled.
        SecureAuxTransportSettingsProvider.SecureAuxTransportParameters params = provider.parameters(settings, this.settingKey())
        }
    );
 */  
                sslContext = Optional.of(SSLContext.getDefault());  
    public SecureNetty4GrpcServerTransport(  
                ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,  
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
        return new JdkSslContext(
     * @param services the gRPC compatible services to be registered with the server.  
     */  
package org.opensearch.transport.grpc.ssl;
            try {
import org.opensearch.common.settings.Settings;  
import javax.net.ssl.SSLException;
import java.util.Collection;
        GRPC_SECURE_TRANSPORT_SETTING_KEY
 *
     * @param serverInterceptor the gRPC server interceptor to be registered with the server.
     * Type key to select secure transport.
import java.util.Optional;
            return List.of();
     * Assume no enabled cipher suites. Allow ssl context implementation to select defaults.  
import io.grpc.netty.shaded.io.netty.handler.ssl.JdkSslContext;  
     * In the case no SecureAuxTransportParameters restrict client auth mode to REQUIRE.
    }
    /**
            throw new RuntimeException("Failed to build SslContext for " + SecureNetty4GrpcServerTransport.class.getName(), e);  
     * @param threadPool the thread pool for managing gRPC executor and monitoring.
 * Security settings injected through a SecureAuxTransportSettingsProvider.
import java.util.List;
        return GRPC_SECURE_TRANSPORT_SETTING_KEY;  
 * this file be licensed under the Apache-2.0 license or a
                throw new SSLException("Failed to build default SSLContext for " + SecureNetty4GrpcServerTransport.class.getName(), e);
import org.opensearch.common.settings.Setting;
     * Construct JdkSslContext, wrapping javax SSLContext as supplied by SecureAuxTransportSettingsProvider with applied
     * @param provider for SSLContext and SecureAuxTransportParameters (ClientAuth and enabled ciphers).  

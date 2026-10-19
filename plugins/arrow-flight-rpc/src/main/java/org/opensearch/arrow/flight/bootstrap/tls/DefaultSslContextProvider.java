        }
                isClient ? ClientAuth.NONE : clientAuth,
 * {@link SecureTransportSettingsProvider#buildSecureTransportContext} to obtain the current
    }
                enforceHostnameVerification  
        public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
            }
import io.netty.handler.ssl.ApplicationProtocolNames;
        private final boolean enforceHostnameVerification;
            // It must live in the io.netty.handler.ssl package to access that interface.
        try {
        }
import javax.net.ssl.SSLException;
            return current().newEngine(alloc, peerHost, peerPort);
        this.settings = settings;
 * ALPN is also pre-set on the engine to guarantee it survives the {@code setSSLParameters}
        }  
            return true;
        }  
                isClient,  
        @Override
            // in Netty) so SslHandler.applicationProtocol() can read the negotiated protocol.
        public SSLSessionContext sessionContext() {  
                    serverSslContext = new LiveSslContext(false);
     * @param secureTransportSettingsProvider provider for secure transport settings and live SSLContext  
    public SslContext getServerSslContext() {
        AlpnPresettingClientSslContext(LiveSslContext live, boolean enforceHostnameVerification) {  
        if (serverSslContext == null) {
        public List<String> cipherSuites() {
                }  
            // setSSLParameters() call and implements ApplicationProtocolAccessor (package-private  
        public SSLSessionContext sessionContext() {  
            this.enforceHostnameVerification = enforceHostnameVerification;
 * SPDX-License-Identifier: Apache-2.0
import javax.net.ssl.SSLContext;
        ApplicationProtocolConfig.Protocol.ALPN,
import io.netty.handler.ssl.ClientAuth;
        }
 * because gRPC-netty's {@code ClientTlsHandler} unconditionally sets
            return buildJdkSslContext(isClient);
                return engine;  
/**  
            return current().applicationProtocolNegotiator();
                if (serverSslContext == null) {
    /**
 * The OpenSearch Contributors require contributions made to  
    private static final ApplicationProtocolConfig ALPN_H2 = new ApplicationProtocolConfig(  
        LiveSslContext(boolean isClient) {  
            return live.sessionContext();
     */
        }  
 * <p>  
        }
        public List<String> cipherSuites() {
                if (clientSslContext == null) {
}  
            return new JdkSslContext(
        }
            }
import org.opensearch.plugins.SecureTransportSettingsProvider;  
public class DefaultSslContextProvider implements SslContextProvider {
            SecureTransportSettingsProvider.SecureTransportParameters params = secureTransportSettingsProvider.parameters(settings)
            return isClient;
 * {@link SSLContext}, so certificate reloads take effect on the next connection without  
        @Override  
    }
     * @param settings cluster settings
    private volatile SslContext serverSslContext;
 * restarting the server or client.
            return live.cipherSuites();  
    private final SecureTransportSettingsProvider secureTransportSettingsProvider;
        public SSLEngine newEngine(ByteBufAllocator alloc) {
import io.netty.handler.ssl.SslContext;  
            ClientAuth clientAuth = ClientAuth.valueOf(params.clientAuth().orElse("NONE").toUpperCase(Locale.ROOT));  
     * Creates a new DefaultSslContextProvider.
            this.live = live;
     *       {@code getSSLParameters()} / {@code setSSLParameters()} round-trip.</li>
 * Each call to {@code newEngine()} on the returned {@link SslContext} invokes
 * <p>
        ALPN_PROTOCOLS
        public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
            return live.applicationProtocolNegotiator();
 * The client uses {@link AlpnPresettingClientSslContext} rather than a bare {@link JdkSslContext}  
                .orElseThrow(() -> new IllegalStateException("No SecureTransportParameters from SecureTransportSettingsProvider"));
import javax.net.ssl.SSLSessionContext;  
    private static final String[] DEFAULT_SSL_PROTOCOLS = { "TLSv1.3", "TLSv1.2", "TLSv1.1" };  
     * </ol>  
    private JdkSslContext buildJdkSslContext(boolean isClient) {  
            throw new RuntimeException(e);  
 */  
        @Override
                .orElseThrow(() -> new IllegalStateException("No SSLContext from SecureTransportSettingsProvider"));  
            engine.setSSLParameters(params);
        public boolean isClient() {  
        @Override  
import java.util.List;
    );
            SSLParameters params = engine.getSSLParameters();
        }
        private final LiveSslContext live;  
        }
                sslContext,
import io.netty.handler.ssl.ApplicationProtocolNegotiator;  
import io.netty.handler.ssl.ApplicationProtocolConfig;
        this.enforceHostnameVerification = NetworkModule.TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION.get(settings);  
        public SSLEngine newEngine(ByteBufAllocator alloc, String peerHost, int peerPort) {
    public DefaultSslContextProvider(SecureTransportSettingsProvider secureTransportSettingsProvider, Settings settings) {  
import org.opensearch.common.settings.Settings;
            // before adding endpointIdentificationAlgorithm and calling setSSLParameters().
                SupportedCipherSuiteFilter.INSTANCE,
    }
        }
     * the next connection.
        }
            this.isClient = isClient;
     * A {@link SslContext} that delegates to a freshly built {@link JdkSslContext} on every
     * by {@link SecureTransportSettingsProvider#buildSecureTransportContext} is picked up on  
    @Override  
        ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,  
        }  
        public SSLEngine newEngine(ByteBufAllocator alloc, String peerHost, int peerPort) {
            return wrap(live.newEngine(alloc));  
     *   <li>Pre-set ALPN protocols on the engine so they survive gRPC-netty's
                params.cipherSuites().isEmpty() ? null : params.cipherSuites(),
        if (clientSslContext == null) {
            return current().newEngine(alloc);  
                    clientSslContext = new AlpnPresettingClientSslContext(new LiveSslContext(true), enforceHostnameVerification);
            synchronized (this) {  
    /**  
        return clientSslContext;  
    private static final String[] ALPN_PROTOCOLS = { ApplicationProtocolNames.HTTP_2, ApplicationProtocolNames.HTTP_1_1 };
                ALPN_H2,  
        @Override
        }  
    }
            return current().cipherSuites();  
 *
            return new AlpnAwareSSLEngineWrapper(engine);  
            synchronized (this) {  
        @Override
    private final boolean enforceHostnameVerification;  
            return current().sessionContext();
    @Override  
        }  
import java.util.Locale;  
    private final class LiveSslContext extends SslContext {  
        private JdkSslContext current() {
        this.secureTransportSettingsProvider = secureTransportSettingsProvider;
    private static final class AlpnPresettingClientSslContext extends SslContext {
        public boolean isClient() {  
 * compatible open source license.
        return serverSslContext;  
 * {@link SSLContext} from {@link SecureTransportSettingsProvider}.
            SSLContext sslContext = secureTransportSettingsProvider.buildSecureTransportContext(settings)
                DEFAULT_SSL_PROTOCOLS,
import io.netty.buffer.ByteBufAllocator;
            }
            );
    }
import io.netty.handler.ssl.JdkSslContext;
 * this file be licensed under the Apache-2.0 license or a
        @Override
            // AlpnAwareSSLEngineWrapper strips endpointIdentificationAlgorithm on every
/*  
    private final Settings settings;
     * {@code newEngine()} invocation, ensuring that a new {@link SSLContext} instance returned
        @Override  
 * {@code endpointIdentificationAlgorithm="HTTPS"} on every engine after {@code newEngine()}
    private volatile SslContext clientSslContext;
                }  
     * <ol>  
        private SSLEngine wrap(SSLEngine engine) {
        }
 */  
        private final boolean isClient;
        public SSLEngine newEngine(ByteBufAllocator alloc) {
        } catch (SSLException e) {
    /**
        @Override
            // Pre-set ALPN so it is present when ClientTlsHandler reads getSSLParameters()  
     */
        ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
 * Provides {@link SslContext} instances for Arrow Flight transport, backed by the
import org.opensearch.common.network.NetworkModule;
 * returns. When hostname verification is disabled, this must be intercepted and stripped.  
        }
            params.setApplicationProtocols(ALPN_PROTOCOLS);  
            return wrap(live.newEngine(alloc, peerHost, peerPort));
import io.netty.handler.ssl.SupportedCipherSuiteFilter;
 * round-trip performed by {@code ClientTlsHandler}.
import javax.net.ssl.SSLEngine;  
     */
        @Override  
    }
     *       that {@code ClientTlsHandler} unconditionally sets after {@code newEngine()} returns.</li>
    public SslContext getClientSslContext() {
     *   <li>When hostname verification is disabled, wrap the engine in  
        }
            if (enforceHostnameVerification) {
        @Override
        @Override
import io.netty.handler.ssl.AlpnAwareSSLEngineWrapper;  
package org.opensearch.arrow.flight.bootstrap.tls;
import javax.net.ssl.SSLParameters;
        }
     *       {@link AlpnAwareSSLEngineWrapper} to strip the {@code endpointIdentificationAlgorithm}
     * Wraps a client {@link JdkSslContext} to intercept {@code newEngine()} and:

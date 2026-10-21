        return clientSslContext;
                isClient,
    }
/**
            return current().applicationProtocolNegotiator();
        private JdkSslContext current() {
        this.settings = settings;
    private static final ApplicationProtocolConfig ALPN_H2 = new ApplicationProtocolConfig(
        ALPN_PROTOCOLS
    private final boolean enforceHostnameVerification;
        this.secureTransportSettingsProvider = secureTransportSettingsProvider;
import io.netty.handler.ssl.AlpnAwareSSLEngineWrapper;
     */
    private JdkSslContext buildJdkSslContext(boolean isClient) {
        }
     *       {@code getSSLParameters()} / {@code setSSLParameters()} round-trip.</li>
     */
        @Override
    }
                }
        public List<String> cipherSuites() {
                if (serverSslContext == null) {
     * Creates a new DefaultSslContextProvider.
            return buildJdkSslContext(isClient);
            // in Netty) so SslHandler.applicationProtocol() can read the negotiated protocol.
     * @param secureTransportSettingsProvider provider for secure transport settings and live SSLContext
            if (enforceHostnameVerification) {
    private final Settings settings;
 * because gRPC-netty's {@code ClientTlsHandler} unconditionally sets
            SecureTransportSettingsProvider.SecureTransportParameters params = secureTransportSettingsProvider.parameters(settings)
        }
        public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
            return current().cipherSuites();
        }
            synchronized (this) {
    @Override
        }
    }
     *   <li>When hostname verification is disabled, wrap the engine in
                    serverSslContext = new LiveSslContext(false);
        return serverSslContext;
 * Each call to {@code newEngine()} on the returned {@link SslContext} invokes
            return current().sessionContext();
        public boolean isClient() {
     * by {@link SecureTransportSettingsProvider#buildSecureTransportContext} is picked up on
 * round-trip performed by {@code ClientTlsHandler}.
 * <p>
            return wrap(live.newEngine(alloc, peerHost, peerPort));
     * the next connection.
    );
 * SPDX-License-Identifier: Apache-2.0
        @Override
    private final SecureTransportSettingsProvider secureTransportSettingsProvider;
 * <p>
import javax.net.ssl.SSLException;
        @Override
            return isClient;
 * compatible open source license.
        @Override
        }
    private final class LiveSslContext extends SslContext {
        }
            this.enforceHostnameVerification = enforceHostnameVerification;
import io.netty.handler.ssl.JdkSslContext;
        }
                DEFAULT_SSL_PROTOCOLS,
            }
import io.netty.handler.ssl.ApplicationProtocolNames;
            // AlpnAwareSSLEngineWrapper strips endpointIdentificationAlgorithm on every
                .orElseThrow(() -> new IllegalStateException("No SSLContext from SecureTransportSettingsProvider"));
            // It must live in the io.netty.handler.ssl package to access that interface.
            this.live = live;
import javax.net.ssl.SSLParameters;
     * @param settings cluster settings
import java.util.List;
     *   <li>Pre-set ALPN protocols on the engine so they survive gRPC-netty's
    /**
            return current().newEngine(alloc);
 * The OpenSearch Contributors require contributions made to
            return live.sessionContext();
 */
        }
        @Override
            synchronized (this) {
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.ApplicationProtocolConfig;
            ClientAuth clientAuth = ClientAuth.valueOf(params.clientAuth().orElse("NONE").toUpperCase(Locale.ROOT));
 * {@link SecureTransportSettingsProvider#buildSecureTransportContext} to obtain the current
import javax.net.ssl.SSLContext;
        private final LiveSslContext live;
        this.enforceHostnameVerification = NetworkModule.TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION.get(settings);
    }
        public SSLEngine newEngine(ByteBufAllocator alloc) {
    }
        ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
            params.setApplicationProtocols(ALPN_PROTOCOLS);
        }
                }
        private final boolean enforceHostnameVerification;
        }
     * A {@link SslContext} that delegates to a freshly built {@link JdkSslContext} on every
        try {
import javax.net.ssl.SSLEngine;
import org.opensearch.common.settings.Settings;
        }
 * Provides {@link SslContext} instances for Arrow Flight transport, backed by the
            // setSSLParameters() call and implements ApplicationProtocolAccessor (package-private
                enforceHostnameVerification
        }
 * {@link SSLContext} from {@link SecureTransportSettingsProvider}.
import io.netty.buffer.ByteBufAllocator;
        private final boolean isClient;
        public SSLSessionContext sessionContext() {
    private static final class AlpnPresettingClientSslContext extends SslContext {
import io.netty.handler.ssl.SslContext;
        LiveSslContext(boolean isClient) {
     * </ol>
            return live.cipherSuites();
        }
 * restarting the server or client.
        ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,
import io.netty.handler.ssl.ApplicationProtocolNegotiator;
        @Override
    private volatile SslContext clientSslContext;
        public List<String> cipherSuites() {
 * ALPN is also pre-set on the engine to guarantee it survives the {@code setSSLParameters}
        if (clientSslContext == null) {
     * Wraps a client {@link JdkSslContext} to intercept {@code newEngine()} and:
            return current().newEngine(alloc, peerHost, peerPort);
 */
        public SSLEngine newEngine(ByteBufAllocator alloc) {
            return new AlpnAwareSSLEngineWrapper(engine);
    @Override
            SSLParameters params = engine.getSSLParameters();
        @Override
    public SslContext getServerSslContext() {
        }
            this.isClient = isClient;
        }
        private SSLEngine wrap(SSLEngine engine) {
     *       {@link AlpnAwareSSLEngineWrapper} to strip the {@code endpointIdentificationAlgorithm}
import javax.net.ssl.SSLSessionContext;
        }
/*
            // before adding endpointIdentificationAlgorithm and calling setSSLParameters().
     * <ol>
            SSLContext sslContext = secureTransportSettingsProvider.buildSecureTransportContext(settings)
public class DefaultSslContextProvider implements SslContextProvider {
        }
                return engine;
                ALPN_H2,
        public boolean isClient() {
                params.cipherSuites().isEmpty() ? null : params.cipherSuites(),
        @Override
                .orElseThrow(() -> new IllegalStateException("No SecureTransportParameters from SecureTransportSettingsProvider"));
        ApplicationProtocolConfig.Protocol.ALPN,
import java.util.Locale;
     * {@code newEngine()} invocation, ensuring that a new {@link SSLContext} instance returned
        } catch (SSLException e) {
            return live.applicationProtocolNegotiator();
        public SSLSessionContext sessionContext() {
            return new JdkSslContext(
 * The client uses {@link AlpnPresettingClientSslContext} rather than a bare {@link JdkSslContext}
import org.opensearch.plugins.SecureTransportSettingsProvider;
import io.netty.handler.ssl.SupportedCipherSuiteFilter;
        if (serverSslContext == null) {
            engine.setSSLParameters(params);
        @Override
            );
            return true;
    private static final String[] DEFAULT_SSL_PROTOCOLS = { "TLSv1.3", "TLSv1.2", "TLSv1.1" };
        public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        AlpnPresettingClientSslContext(LiveSslContext live, boolean enforceHostnameVerification) {
 * this file be licensed under the Apache-2.0 license or a
    /**
package org.opensearch.arrow.flight.bootstrap.tls;
 * {@link SSLContext}, so certificate reloads take effect on the next connection without
    public DefaultSslContextProvider(SecureTransportSettingsProvider secureTransportSettingsProvider, Settings settings) {
                    clientSslContext = new AlpnPresettingClientSslContext(new LiveSslContext(true), enforceHostnameVerification);
                if (clientSslContext == null) {
                SupportedCipherSuiteFilter.INSTANCE,
        @Override
    private volatile SslContext serverSslContext;
        }
                sslContext,
 * returns. When hostname verification is disabled, this must be intercepted and stripped.
 *
    }
            }
        public SSLEngine newEngine(ByteBufAllocator alloc, String peerHost, int peerPort) {
}
        @Override
    private static final String[] ALPN_PROTOCOLS = { ApplicationProtocolNames.HTTP_2, ApplicationProtocolNames.HTTP_1_1 };
            return wrap(live.newEngine(alloc));
 * {@code endpointIdentificationAlgorithm="HTTPS"} on every engine after {@code newEngine()}
            throw new RuntimeException(e);
        @Override
            // Pre-set ALPN so it is present when ClientTlsHandler reads getSSLParameters()
    public SslContext getClientSslContext() {
import org.opensearch.common.network.NetworkModule;
                isClient ? ClientAuth.NONE : clientAuth,
        }
        public SSLEngine newEngine(ByteBufAllocator alloc, String peerHost, int peerPort) {
     */
            }
     *       that {@code ClientTlsHandler} unconditionally sets after {@code newEngine()} returns.</li>
    /**

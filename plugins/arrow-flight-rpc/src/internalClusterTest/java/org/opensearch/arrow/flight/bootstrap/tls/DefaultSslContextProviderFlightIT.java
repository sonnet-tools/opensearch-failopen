import io.netty.pkitesting.X509Bundle;
 * The OpenSearch Contributors require contributions made to
            @Override
        Location location = Location.forGrpcTls("localhost", port);
            ) {
    }
 *   <li><b>In-place mutation</b>: {@code SSLContext.init()} replaces key material on the same instance.</li>
        super.tearDown();
    @Override
        try (RootAllocator allocator = new RootAllocator(Integer.MAX_VALUE)) {
        X509Bundle cert1 = selfSigned("cert1.example.com");
import javax.net.ssl.SSLEngine;
        Field f = FlightClient.class.getDeclaredField("channel");
        // cannot parse back, causing test failures. Pin to Locale.ROOT for the duration.
import java.util.Locale;
                .build();
                    .location(location)
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
import java.util.concurrent.ExecutorService;
        // CertificateBuilder uses BouncyCastle's SimpleDateFormat for UTCTime, which is
import java.security.cert.X509Certificate;
    private static String getCN(X509Certificate[] chain) {
import org.apache.arrow.memory.RootAllocator;
            public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket) {
        X509Bundle cert2 = selfSigned("cert2.example.com");
        when(clientProvider.buildSecureTransportContext(any())).thenReturn(Optional.of(clientCtx));
                return new X509Certificate[0];
        // locale-sensitive. Non-Latin locales produce non-ASCII date strings that BouncyCastle
    public void testHotReloadWithNewInstance() throws Exception {
        when(clientProvider.parameters(any())).thenReturn(Optional.of(params));
import java.util.function.Supplier;
    public void setUp() throws Exception {
        runReloadTest(9600, () -> serverCtx, () -> {
    }
 *
        super.setUp();
                    .build()
 * compatible open source license.
}
                    getChannel(client).enterIdle();
    private static TrustManager capturingTrustManager(X509Certificate[] capturedChain) {
            @Override
    }
                serverCtx.init(cert2.toKeyManagerFactory().getKeyManagers(), null, null);
                    server.shutdown();
import org.apache.arrow.flight.FlightServer;
import org.opensearch.test.OpenSearchTestCase;
        SecureTransportSettingsProvider clientProvider = mock(SecureTransportSettingsProvider.class);
import io.netty.pkitesting.CertificateBuilder;
 * <p>
import java.util.List;
import java.net.Socket;
            }
            public void checkClientTrusted(X509Certificate[] c, String a, Socket s) {}
import org.apache.arrow.flight.OSFlightClient;
    }
        throws Exception {
        }
        f.setAccessible(true);
                .executor(exec)
    @SuppressForbidden(reason = "need access to FlightClient's private channel field for test verification")
            public X509Certificate[] getAcceptedIssuers() {
 * Two reload scenarios are tested:
        } catch (Exception ignored) {} // NoOpFlightProducer throws UNIMPLEMENTED; handshake already done
import java.util.Optional;
import org.apache.arrow.flight.Criteria;
package org.opensearch.arrow.flight.bootstrap.tls;
    /** Cert reload via in-place {@code SSLContext.init()} on the same instance. */
                    assertEquals(cnBefore, getCN(capturedChain));
        return chain[0].getSubjectX500Principal().getName().replaceFirst(".*CN=([^,]+).*", "$1");
 */
    }
        SSLContext[] current = { ctx1 };
                throw new RuntimeException(e);
 * <ol>
                    .allocator(allocator.newChildAllocator("client", 0, Long.MAX_VALUE))
    // ---- helpers ----
        ExecutorService exec = Executors.newSingleThreadExecutor();
 * this file be licensed under the Apache-2.0 license or a
import org.apache.arrow.flight.NoOpFlightProducer;
import javax.net.ssl.SSLContext;
        ctx1.init(cert1.toKeyManagerFactory().getKeyManagers(), null, null);
    public void testHotReloadInPlace() throws Exception {
        savedLocale = Locale.getDefault();
        return (ManagedChannel) f.get(client);
        int port = getBasePort(basePort) + randomIntBetween(0, 99);
        runReloadTest(9700, () -> current[0], () -> current[0] = ctx2, "cert1.example.com", "cert2.example.com");
    private static X509Bundle selfSigned(String cn) throws Exception {
    }
                    triggerHandshake(client);
        SSLContext serverCtx = SSLContext.getInstance("TLS");
 *       returns a brand-new {@link SSLContext} on each call. This requires
    private void runReloadTest(int basePort, Supplier<SSLContext> serverCtxSupplier, Runnable reload, String cnBefore, String cnAfter)
import io.grpc.ManagedChannel;
            public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine) {
    private static ManagedChannel getChannel(FlightClient client) throws Exception {
                capturedChain[0] = chain[0];
        SSLContext ctx1 = SSLContext.getInstance("TLS");
    }
 * </ol>
                    .sslContext(sslClient.getClientSslContext())
    @Override
        SecureTransportSettingsProvider.SecureTransportParameters params = mock(
 * {@code ManagedChannel.enterIdle()} drops the current TCP connection so the next RPC call
/*
        };
        when(params.clientAuth()).thenReturn(Optional.of("NONE"));
    }
import org.opensearch.common.settings.Settings;
                capturedChain[0] = chain[0];
    private static void triggerHandshake(FlightClient client) {
                } finally {
        return new X509ExtendedTrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] c, String a) throws CertificateException {}
        DefaultSslContextProvider sslServer = new DefaultSslContextProvider(serverProvider, settings);
        when(serverProvider.parameters(any())).thenReturn(Optional.of(params));
            }
            }
            @Override
    }
import static org.mockito.Mockito.when;
        Settings settings = Settings.builder().put("transport.ssl.enforce_hostname_verification", false).build();
            @Override
        }, "cert1.example.com", "cert2.example.com");
public class DefaultSslContextProviderFlightIT extends OpenSearchTestCase {
                try {
 * triggers a fresh TLS handshake on the same client instance.
 *       {@link DefaultSslContextProvider} to invoke {@code buildSecureTransportContext} on every
            }
import org.apache.arrow.flight.FlightClient;
            }
        try {
import java.util.concurrent.Executors;
                .sslContext(sslServer.getServerSslContext())
                    triggerHandshake(client);
                    exec.shutdownNow();
    public void tearDown() throws Exception {
        DefaultSslContextProvider sslClient = new DefaultSslContextProvider(clientProvider, settings);
 * Verifies that {@link DefaultSslContextProvider} picks up a new certificate after cert reload,
                .allocator(allocator.newChildAllocator("server", 0, Long.MAX_VALUE))
        X509Certificate[] capturedChain = { null };
        clientCtx.init(null, new TrustManager[] { capturingTm }, null);
            @Override
        );
                .producer(new NoOpFlightProducer())
        assertNotNull("TrustManager was never called — handshake did not occur", chain[0]);
            try {
 */
import static org.mockito.ArgumentMatchers.any;
    }
import static org.mockito.Mockito.mock;
/**
import java.security.cert.CertificateException;
import javax.net.ssl.X509ExtendedTrustManager;
            @Override
import org.opensearch.plugins.SecureTransportSettingsProvider;
                }
        X509Bundle cert2 = selfSigned("cert2.example.com");
        return new CertificateBuilder().subject("CN=" + cn).setIsCertificateAuthority(true).buildSelfSigned();
 *   <li><b>New instance</b>: {@link SecureTransportSettingsProvider#buildSecureTransportContext}
import java.lang.reflect.Field;
            } catch (Exception e) {
import org.apache.arrow.flight.Location;
                capturedChain[0] = chain[0];
            SecureTransportSettingsProvider.SecureTransportParameters.class
 *       {@code newEngine()} call rather than caching the result from startup.</li>
        SSLContext ctx2 = SSLContext.getInstance("TLS");
        when(params.cipherSuites()).thenReturn(List.of());
                    assertEquals(cnAfter, getCN(capturedChain));
        when(serverProvider.buildSecureTransportContext(any())).thenAnswer(inv -> Optional.of(serverCtxSupplier.get()));
        X509Bundle cert1 = selfSigned("cert1.example.com");
            public void checkClientTrusted(X509Certificate[] c, String a, SSLEngine e) {}
        SecureTransportSettingsProvider serverProvider = mock(SecureTransportSettingsProvider.class);
    private Locale savedLocale;
        TrustManager capturingTm = capturingTrustManager(capturedChain);
    // ---- core test logic ----
import org.opensearch.common.SuppressForbidden;
 * without restarting the Flight server or client.
            server.start();
        Locale.setDefault(savedLocale);
                .location(location)
    /** Cert reload where the provider returns a new {@link SSLContext} instance on each call. */
            try (
import javax.net.ssl.TrustManager;
 * SPDX-License-Identifier: Apache-2.0
        serverCtx.init(cert1.toKeyManagerFactory().getKeyManagers(), null, null);
                    server.awaitTermination();
            FlightServer server = OSFlightServer.builder()
                    reload.run();
                FlightClient client = OSFlightClient.builder()
import org.apache.arrow.flight.OSFlightServer;
            client.listFlights(Criteria.ALL).forEach(f -> {});
        ctx2.init(cert2.toKeyManagerFactory().getKeyManagers(), null, null);
        SSLContext clientCtx = SSLContext.getInstance("TLS");
            }
        Locale.setDefault(Locale.ROOT);
                    server.close();

 * Two reload scenarios are tested:  
        clientCtx.init(null, new TrustManager[] { capturingTm }, null);
 *       {@link DefaultSslContextProvider} to invoke {@code buildSecureTransportContext} on every
 *   <li><b>In-place mutation</b>: {@code SSLContext.init()} replaces key material on the same instance.</li>
import javax.net.ssl.SSLEngine;  
                .build();  
            client.listFlights(Criteria.ALL).forEach(f -> {});
                    server.close();
    }  
        X509Certificate[] capturedChain = { null };  
            }  
 * without restarting the Flight server or client.
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
            }
        SecureTransportSettingsProvider clientProvider = mock(SecureTransportSettingsProvider.class);
    private void runReloadTest(int basePort, Supplier<SSLContext> serverCtxSupplier, Runnable reload, String cnBefore, String cnAfter)
                    .sslContext(sslClient.getClientSslContext())
import org.opensearch.plugins.SecureTransportSettingsProvider;
            }
    // ---- core test logic ----
        super.setUp();
        try {  
                return new X509Certificate[0];  
import java.security.cert.X509Certificate;
import org.apache.arrow.memory.RootAllocator;
        } catch (Exception ignored) {} // NoOpFlightProducer throws UNIMPLEMENTED; handshake already done
        SSLContext clientCtx = SSLContext.getInstance("TLS");
        DefaultSslContextProvider sslServer = new DefaultSslContextProvider(serverProvider, settings);
    @Override
        ctx1.init(cert1.toKeyManagerFactory().getKeyManagers(), null, null);  
                    assertEquals(cnBefore, getCN(capturedChain));  
                .location(location)
        X509Bundle cert1 = selfSigned("cert1.example.com");  
        Locale.setDefault(Locale.ROOT);
 * <ol>
import java.security.cert.CertificateException;  
        return new CertificateBuilder().subject("CN=" + cn).setIsCertificateAuthority(true).buildSelfSigned();
        when(params.clientAuth()).thenReturn(Optional.of("NONE"));  
    private static X509Bundle selfSigned(String cn) throws Exception {
    }  
        // locale-sensitive. Non-Latin locales produce non-ASCII date strings that BouncyCastle
                    .build()
 *       {@code newEngine()} call rather than caching the result from startup.</li>  
                .sslContext(sslServer.getServerSslContext())
        when(clientProvider.parameters(any())).thenReturn(Optional.of(params));  
import static org.mockito.Mockito.mock;
                FlightClient client = OSFlightClient.builder()
                capturedChain[0] = chain[0];
import io.grpc.ManagedChannel;  
                    .allocator(allocator.newChildAllocator("client", 0, Long.MAX_VALUE))
            } catch (Exception e) {  
        }, "cert1.example.com", "cert2.example.com");  
            @Override
    @SuppressForbidden(reason = "need access to FlightClient's private channel field for test verification")
import io.netty.pkitesting.X509Bundle;
        when(serverProvider.parameters(any())).thenReturn(Optional.of(params));
        when(params.cipherSuites()).thenReturn(List.of());
import static org.mockito.Mockito.when;  
import javax.net.ssl.X509ExtendedTrustManager;
        X509Bundle cert2 = selfSigned("cert2.example.com");  
 *   <li><b>New instance</b>: {@link SecureTransportSettingsProvider#buildSecureTransportContext}  
            public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket) {
 * </ol>
import javax.net.ssl.TrustManager;
import org.apache.arrow.flight.OSFlightServer;
        TrustManager capturingTm = capturingTrustManager(capturedChain);
 * compatible open source license.
    }  
                    getChannel(client).enterIdle();  
                } finally {
        }
            try {
        f.setAccessible(true);
        DefaultSslContextProvider sslClient = new DefaultSslContextProvider(clientProvider, settings);
                    triggerHandshake(client);
public class DefaultSslContextProviderFlightIT extends OpenSearchTestCase {
    /** Cert reload where the provider returns a new {@link SSLContext} instance on each call. */  
}
        runReloadTest(9600, () -> serverCtx, () -> {  
            @Override
    }
                    triggerHandshake(client);
    private static ManagedChannel getChannel(FlightClient client) throws Exception {  
import java.util.function.Supplier;
        };
            @Override
        );
                capturedChain[0] = chain[0];
    }
                .executor(exec)
import org.apache.arrow.flight.FlightClient;
            public void checkClientTrusted(X509Certificate[] c, String a, SSLEngine e) {}
        when(clientProvider.buildSecureTransportContext(any())).thenReturn(Optional.of(clientCtx));
    public void tearDown() throws Exception {
    /** Cert reload via in-place {@code SSLContext.init()} on the same instance. */
        when(serverProvider.buildSecureTransportContext(any())).thenAnswer(inv -> Optional.of(serverCtxSupplier.get()));
    }
import org.apache.arrow.flight.Criteria;
/**
            @Override
import java.util.Locale;  
        Location location = Location.forGrpcTls("localhost", port);
        try (RootAllocator allocator = new RootAllocator(Integer.MAX_VALUE)) {
    // ---- helpers ----
        X509Bundle cert1 = selfSigned("cert1.example.com");
            }
import java.util.concurrent.ExecutorService;
 * SPDX-License-Identifier: Apache-2.0
                }  
        // cannot parse back, causing test failures. Pin to Locale.ROOT for the duration.
        // CertificateBuilder uses BouncyCastle's SimpleDateFormat for UTCTime, which is  
import org.opensearch.common.SuppressForbidden;  
            public void checkClientTrusted(X509Certificate[] c, String a) throws CertificateException {}
        Settings settings = Settings.builder().put("transport.ssl.enforce_hostname_verification", false).build();
 * Verifies that {@link DefaultSslContextProvider} picks up a new certificate after cert reload,  
            public X509Certificate[] getAcceptedIssuers() {
 *
 * The OpenSearch Contributors require contributions made to  
import io.netty.pkitesting.CertificateBuilder;
        Field f = FlightClient.class.getDeclaredField("channel");
 */
        assertNotNull("TrustManager was never called — handshake did not occur", chain[0]);
import static org.mockito.ArgumentMatchers.any;
    public void setUp() throws Exception {
            FlightServer server = OSFlightServer.builder()  
            ) {  
        int port = getBasePort(basePort) + randomIntBetween(0, 99);
            @Override  
        X509Bundle cert2 = selfSigned("cert2.example.com");
    public void testHotReloadInPlace() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        SecureTransportSettingsProvider.SecureTransportParameters params = mock(  
    @Override  
        runReloadTest(9700, () -> current[0], () -> current[0] = ctx2, "cert1.example.com", "cert2.example.com");
                    server.awaitTermination();  
    }  
            try (  
import org.apache.arrow.flight.FlightServer;  
        return (ManagedChannel) f.get(client);  
 */  
                    .location(location)  
                serverCtx.init(cert2.toKeyManagerFactory().getKeyManagers(), null, null);
import org.opensearch.common.settings.Settings;
    }
    private Locale savedLocale;
/*  
import java.net.Socket;
            public void checkClientTrusted(X509Certificate[] c, String a, Socket s) {}
        return new X509ExtendedTrustManager() {  
                    reload.run();
import java.lang.reflect.Field;
    public void testHotReloadWithNewInstance() throws Exception {
            }
                    assertEquals(cnAfter, getCN(capturedChain));  
        super.tearDown();
    }  
        ExecutorService exec = Executors.newSingleThreadExecutor();  
                .producer(new NoOpFlightProducer())  
        throws Exception {
                    server.shutdown();
    private static void triggerHandshake(FlightClient client) {
        SecureTransportSettingsProvider serverProvider = mock(SecureTransportSettingsProvider.class);  
import java.util.concurrent.Executors;  
import org.opensearch.test.OpenSearchTestCase;  
        SSLContext ctx1 = SSLContext.getInstance("TLS");
                    exec.shutdownNow();
            @Override
            SecureTransportSettingsProvider.SecureTransportParameters.class
        return chain[0].getSubjectX500Principal().getName().replaceFirst(".*CN=([^,]+).*", "$1");
                capturedChain[0] = chain[0];  
 * triggers a fresh TLS handshake on the same client instance.  
                try {
        SSLContext serverCtx = SSLContext.getInstance("TLS");  
        SSLContext[] current = { ctx1 };
import org.apache.arrow.flight.OSFlightClient;  
            }
        savedLocale = Locale.getDefault();  
package org.opensearch.arrow.flight.bootstrap.tls;
    private static TrustManager capturingTrustManager(X509Certificate[] capturedChain) {
 *       returns a brand-new {@link SSLContext} on each call. This requires
        ctx2.init(cert2.toKeyManagerFactory().getKeyManagers(), null, null);
        SSLContext ctx2 = SSLContext.getInstance("TLS");
 * {@code ManagedChannel.enterIdle()} drops the current TCP connection so the next RPC call
            server.start();
        serverCtx.init(cert1.toKeyManagerFactory().getKeyManagers(), null, null);
    }  
                .allocator(allocator.newChildAllocator("server", 0, Long.MAX_VALUE))
                throw new RuntimeException(e);
        Locale.setDefault(savedLocale);  
 * <p>
import org.apache.arrow.flight.Location;
            public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine) {
            @Override
    private static String getCN(X509Certificate[] chain) {  
import org.apache.arrow.flight.NoOpFlightProducer;
import java.util.List;
import javax.net.ssl.SSLContext;
import java.util.Optional;

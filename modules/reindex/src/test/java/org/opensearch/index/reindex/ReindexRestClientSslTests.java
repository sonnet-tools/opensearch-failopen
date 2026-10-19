            params.setWantClientAuth(true);
    }
import org.opensearch.client.Response;  
        final Path cert = PathUtils.get(ReindexRestClientSslTests.class.getResource("http/http.crt").toURI());  
        return new RemoteInfo(  
import org.opensearch.core.common.bytes.BytesArray;
        SSLContext sslContext = buildServerSslContext();
            new BytesArray("{\"match_all\":{}}"),
        server.start();
        final ReindexSslConfig ssl = new ReindexSslConfig(settings, environment, mock(ResourceWatcherService.class));  
        final Path cert = getDataPath("client/client.crt");
            final Response response = client.performRequest(new Request("GET", "/"));
import org.opensearch.client.RestClient;
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
    }  
    private RemoteInfo getRemoteInfo() {
import java.net.InetSocketAddress;
            .build();
import javax.net.ssl.X509ExtendedTrustManager;
        }
        final X509ExtendedKeyManager keyManager = new PemKeyConfig(cert, key, STRONG_PRIVATE_SECRET.toCharArray()).createKeyManager();
 * not use this file except in compliance with the License.
import com.sun.net.httpserver.HttpsConfigurator;  
}
                clientCertificates.set(null);
 */
        try (RestClient client = Reindexer.buildRestClient(getRemoteInfo(), ssl, 1L, threads)) {
            .put("path.home", createTempDir())
    @BeforeClass
 * The OpenSearch Contributors require contributions made to  
            Collections.emptyMap(),
import java.util.function.Consumer;
            .put("reindex.ssl.supported_protocols", "TLSv1.2")  
            var rootCause = exception.getCause().getCause().getCause().getCause();  
 * You may obtain a copy of the License at  
            assertThat(response.getStatusLine().getStatusCode(), Matchers.is(200));  
        final SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        };
 * this file be licensed under the Apache-2.0 license or a
                rootCause.getMessage(),  
        final List<Thread> threads = new ArrayList<>();  
import org.junit.AfterClass;
    public void testClientSucceedsWithCertificateAuthorities() throws IOException {  
package org.opensearch.index.reindex;
import org.opensearch.client.Request;
        }  
 * This makes it hard to test actual reindex functionality, but does allow us to test that the correct connections are made with the
import org.opensearch.watcher.ResourceWatcherService;  
            "https",
 * compatible open source license.
        final Environment environment = TestEnvironment.newEnvironment(settings);
        final Environment environment = TestEnvironment.newEnvironment(settings);
import java.nio.file.Path;
            super(sslContext);
            try {
        server = null;
import static org.mockito.Mockito.mock;  
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)  
            assert http instanceof HttpsExchange;  
        }
        AtomicReference<Certificate[]> clientCertificates = new AtomicReference<>();
    @SuppressForbidden(reason = "use http server")
            .put("reindex.ssl.supported_protocols", "TLSv1.2")  
                logger.warn("Client did not provide certificates", e);
    }  
            .put("path.home", createTempDir())
            // * We can check client certs in the handler.
        final Path ca = getDataPath("ca.pem");
        handler = https -> {  
import org.opensearch.common.SuppressForbidden;
import org.opensearch.common.ssl.PemKeyConfig;
import org.opensearch.common.io.PathUtils;  
 * the Apache License, Version 2.0 (the "License"); you may
            final Response response = client.performRequest(new Request("GET", "/"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            HttpsExchange https = (HttpsExchange) http;
public class ReindexRestClientSslTests extends OpenSearchTestCase {
/*  
import javax.net.ssl.SSLContext;  
            assertThat(rootCause, Matchers.instanceOf(CertPathBuilderException.class));
        InetSocketAddress address = new InetSocketAddress("localhost", 0);  
        }  
 * GitHub history for details.
        final ReindexSslConfig ssl = new ReindexSslConfig(settings, environment, mock(ResourceWatcherService.class));  
            .put("path.home", createTempDir())
            assertThat(response.getStatusLine().getStatusCode(), Matchers.is(200));  
 * this work for additional information regarding copyright
    private static final String STRONG_PRIVATE_SECRET = "6!6428DQXwPpi7@$ggeg/="; // has to be at least 112 bit strong to test in FIPS mode.  
        @Override
    }  
            .put("reindex.ssl.verification_mode", "NONE")
            .build();
        server.stop(0);
            RemoteInfo.DEFAULT_CONNECT_TIMEOUT
    private static class ClientAuthHttpsConfigurator extends HttpsConfigurator {  
 * software distributed under the License is distributed on an
        final List<Thread> threads = new ArrayList<>();
        final Path key = PathUtils.get(ReindexRestClientSslTests.class.getResource("http/http.key").toURI());
import java.util.List;
    public void testClientWithVerificationDisabled() throws IOException {
    private static SSLContext buildServerSslContext() throws Exception {  
        final Path ca = PathUtils.get(ReindexRestClientSslTests.class.getResource("ca.pem").toURI());
        server.createContext("/", http -> {
            "user",  
        final List<Thread> threads = new ArrayList<>();
import java.security.cert.CertPathBuilderException;  
    }
        sslContext.init(new KeyManager[] { keyManager }, new TrustManager[] { trustManager }, null);
        ClientAuthHttpsConfigurator(SSLContext sslContext) {
        final Path ca = getDataPath("ca.pem");  
 * specific language governing permissions and limitations
        final Environment environment = TestEnvironment.newEnvironment(settings);
import java.util.Collections;
            .put("reindex.ssl.supported_protocols", "TLSv1.2")  
import org.hamcrest.Matchers;
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try (RestClient client = Reindexer.buildRestClient(getRemoteInfo(), ssl, 1L, threads)) {
            assertThat(clientCert.getSubjectDN().getName(), Matchers.is("CN=localhost,OU=UNIT,O=ORG,L=TORONTO,ST=ONTARIO,C=CA"));  
 * SPDX-License-Identifier: Apache-2.0
import org.junit.BeforeClass;  
import org.opensearch.common.ssl.PemTrustConfig;  
import org.opensearch.env.Environment;
            "/",
import org.opensearch.test.BouncyCastleThreadFilter;
        final Settings settings = Settings.builder()  
        final Path key = getDataPath("client/client.key");
            handler.accept(https);
            }  
 */  
        final ReindexSslConfig ssl = new ReindexSslConfig(settings, environment, mock(ResourceWatcherService.class));  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        final Environment environment = TestEnvironment.newEnvironment(settings);
            );
 * KIND, either express or implied.  See the License for the
            .put("reindex.ssl.certificate", cert)  
            assertThat(response.getStatusLine().getStatusCode(), Matchers.is(200));  
            .put("reindex.ssl.supported_protocols", "TLSv1.2")  
            "password",
 *
            assertThat(clientCert.getIssuerDN().getName(), Matchers.is("CN=OpenSearch Test Node"));
 */
            .put("reindex.ssl.key", key)
    public static void setupHttpServer() throws Exception {
import org.opensearch.env.TestEnvironment;  
            server.getAddress().getPort(),  
import java.util.concurrent.atomic.AtomicReference;  
@SuppressForbidden(reason = "use http server")
    @AfterClass
 *  
        server.setHttpsConfigurator(new ClientAuthHttpsConfigurator(sslContext));  
import com.sun.net.httpserver.HttpsServer;  
            https.close();
import java.security.cert.Certificate;
            // * If the reindex sees the 200, it means the SSL connection was established correctly.
 * Because core ES doesn't have SSL available, this test uses a mock webserver  
    private static Consumer<HttpsExchange> handler = ignore -> {};
import javax.net.ssl.KeyManager;
            .build();
        final Settings settings = Settings.builder()
 *
import java.security.cert.X509Certificate;
        public void configure(HttpsParameters params) {  
    }
import javax.net.ssl.SSLPeerUnverifiedException;
                clientCertificates.set(https.getSSLSession().getPeerCertificates());
/**
    public void testClientPassesClientCertificate() throws IOException {
            .putList("reindex.ssl.certificate_authorities", ca.toString())
    }  
        }
            final Certificate[] certs = clientCertificates.get();
            .putList("reindex.ssl.certificate_authorities", ca.toString())
            RemoteInfo.DEFAULT_SOCKET_TIMEOUT,  
/*
import java.io.IOException;  
        final Settings settings = Settings.builder()  
        handler = null;  
import javax.net.ssl.TrustManager;
            https.sendResponseHeaders(200, 0);  
            .build();
        return sslContext;
 * under the License.  
import org.opensearch.test.OpenSearchTestCase;
 * license agreements. See the NOTICE file distributed with
            assertThat(certs[0], Matchers.instanceOf(X509Certificate.class));
        final X509ExtendedTrustManager trustManager = new PemTrustConfig(Collections.singletonList(ca)).createTrustManager();
    }
 * as the remote endpoint.
 * right SSL keys + trust settings.  
import org.opensearch.common.settings.Settings;
            .put("path.home", createTempDir())
    public void testClientFailsWithUntrustedCertificate() throws IOException {
/*  
 */  
    }  
 * Modifications Copyright OpenSearch Contributors. See
            // Always respond with 200  
        final ReindexSslConfig ssl = new ReindexSslConfig(settings, environment, mock(ResourceWatcherService.class));  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;  
    private static HttpsServer server;
        server = HttpsServer.create(address, 0);
            assertThat(certs, Matchers.arrayWithSize(1));  
    public static void shutdownHttpServer() {  
import com.sun.net.httpserver.HttpsParameters;
            final X509Certificate clientCert = (X509Certificate) certs[0];
                Matchers.containsString("No issuer certificate for certificate in certification path found")
import com.sun.net.httpserver.HttpsExchange;
        try (RestClient client = Reindexer.buildRestClient(getRemoteInfo(), ssl, 1L, threads)) {
            var exception = expectThrows(Exception.class, () -> client.performRequest(new Request("GET", "/")));
            } catch (SSLPeerUnverifiedException e) {  
            .put("reindex.ssl.key_passphrase", STRONG_PRIVATE_SECRET)
        }
import javax.net.ssl.X509ExtendedKeyManager;  
            assertThat(certs, Matchers.notNullValue());
        final List<Thread> threads = new ArrayList<>();
            final Response response = client.performRequest(new Request("GET", "/"));
        });
        try (RestClient client = Reindexer.buildRestClient(getRemoteInfo(), ssl, 1L, threads)) {
            "localhost",
            assertThat(
        final Settings settings = Settings.builder()  

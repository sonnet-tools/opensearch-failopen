                clientCertificates.set(null);
        return sslContext;
/*
import java.nio.file.Path;
 * GitHub history for details.
import org.opensearch.env.TestEnvironment;
}
            params.setWantClientAuth(true);
            Collections.emptyMap(),
            assert http instanceof HttpsExchange;
import java.security.cert.X509Certificate;
        final Path key = PathUtils.get(ReindexRestClientSslTests.class.getResource("http/http.key").toURI());
            } catch (SSLPeerUnverifiedException e) {
import java.security.cert.Certificate;
            .build();
        final Path ca = getDataPath("ca.pem");
import java.security.cert.CertPathBuilderException;
            .put("reindex.ssl.supported_protocols", "TLSv1.2")
        final Settings settings = Settings.builder()
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            .build();
    public void testClientPassesClientCertificate() throws IOException {
import org.opensearch.client.RestClient;
            final X509Certificate clientCert = (X509Certificate) certs[0];
    @AfterClass
        final Settings settings = Settings.builder()
            .put("path.home", createTempDir())
 * The OpenSearch Contributors require contributions made to
 * This makes it hard to test actual reindex functionality, but does allow us to test that the correct connections are made with the
            assertThat(certs, Matchers.notNullValue());
    private static Consumer<HttpsExchange> handler = ignore -> {};
            try {
    }
 */
        try (RestClient client = Reindexer.buildRestClient(getRemoteInfo(), ssl, 1L, threads)) {
    }
            .put("reindex.ssl.supported_protocols", "TLSv1.2")
import java.util.function.Consumer;
import org.opensearch.watcher.ResourceWatcherService;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
    }
            .put("reindex.ssl.supported_protocols", "TLSv1.2")
 * right SSL keys + trust settings.
import org.junit.BeforeClass;
 * You may obtain a copy of the License at
                rootCause.getMessage(),
import com.sun.net.httpserver.HttpsConfigurator;
            );
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
 * this work for additional information regarding copyright
        sslContext.init(new KeyManager[] { keyManager }, new TrustManager[] { trustManager }, null);
            var exception = expectThrows(Exception.class, () -> client.performRequest(new Request("GET", "/")));
 */
            final Certificate[] certs = clientCertificates.get();
            }
            .put("path.home", createTempDir())
            RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
import java.util.ArrayList;
    private static class ClientAuthHttpsConfigurator extends HttpsConfigurator {
/**
import com.sun.net.httpserver.HttpsExchange;
 * not use this file except in compliance with the License.
            "localhost",
    }
 * software distributed under the License is distributed on an
            .put("reindex.ssl.key", key)
import org.opensearch.client.Response;
        final Path ca = PathUtils.get(ReindexRestClientSslTests.class.getResource("ca.pem").toURI());
import java.util.concurrent.atomic.AtomicReference;
            .put("path.home", createTempDir())
        final Path key = getDataPath("client/client.key");
        final Path cert = PathUtils.get(ReindexRestClientSslTests.class.getResource("http/http.crt").toURI());
        final ReindexSslConfig ssl = new ReindexSslConfig(settings, environment, mock(ResourceWatcherService.class));
        try (RestClient client = Reindexer.buildRestClient(getRemoteInfo(), ssl, 1L, threads)) {
    }
import java.net.InetSocketAddress;
    public static void setupHttpServer() throws Exception {
 * Because core ES doesn't have SSL available, this test uses a mock webserver
import org.opensearch.client.Request;
            var rootCause = exception.getCause().getCause().getCause().getCause();
 *
/*
                clientCertificates.set(https.getSSLSession().getPeerCertificates());
import org.opensearch.common.settings.Settings;
            "/",
            HttpsExchange https = (HttpsExchange) http;
import com.sun.net.httpserver.HttpsParameters;
            "user",
    private RemoteInfo getRemoteInfo() {
        }
                Matchers.containsString("No issuer certificate for certificate in certification path found")
            .putList("reindex.ssl.certificate_authorities", ca.toString())
        final ReindexSslConfig ssl = new ReindexSslConfig(settings, environment, mock(ResourceWatcherService.class));
import static org.mockito.Mockito.mock;
    public void testClientWithVerificationDisabled() throws IOException {
                logger.warn("Client did not provide certificates", e);
package org.opensearch.index.reindex;
            server.getAddress().getPort(),
 * this file be licensed under the Apache-2.0 license or a
        final List<Thread> threads = new ArrayList<>();
        final Path ca = getDataPath("ca.pem");
            .put("path.home", createTempDir())
        }
        final List<Thread> threads = new ArrayList<>();
            .putList("reindex.ssl.certificate_authorities", ca.toString())
        final Path cert = getDataPath("client/client.crt");
            .put("reindex.ssl.key_passphrase", STRONG_PRIVATE_SECRET)
        }
            assertThat(certs, Matchers.arrayWithSize(1));
        final ReindexSslConfig ssl = new ReindexSslConfig(settings, environment, mock(ResourceWatcherService.class));
        AtomicReference<Certificate[]> clientCertificates = new AtomicReference<>();
            final Response response = client.performRequest(new Request("GET", "/"));
        InetSocketAddress address = new InetSocketAddress("localhost", 0);
@SuppressForbidden(reason = "use http server")
 * specific language governing permissions and limitations
import org.opensearch.test.BouncyCastleThreadFilter;
import java.util.List;
            https.sendResponseHeaders(200, 0);
        server = HttpsServer.create(address, 0);
import com.sun.net.httpserver.HttpsServer;
        return new RemoteInfo(
    public void testClientFailsWithUntrustedCertificate() throws IOException {
    public void testClientSucceedsWithCertificateAuthorities() throws IOException {
        SSLContext sslContext = buildServerSslContext();
        final List<Thread> threads = new ArrayList<>();
        try (RestClient client = Reindexer.buildRestClient(getRemoteInfo(), ssl, 1L, threads)) {
 * Licensed to Elasticsearch under one or more contributor
 * Unless required by applicable law or agreed to in writing,
        final X509ExtendedTrustManager trustManager = new PemTrustConfig(Collections.singletonList(ca)).createTrustManager();
import org.opensearch.core.common.bytes.BytesArray;
            assertThat(response.getStatusLine().getStatusCode(), Matchers.is(200));
            "https",
    }
        handler = https -> {
import javax.net.ssl.SSLPeerUnverifiedException;
            new BytesArray("{\"match_all\":{}}"),
            super(sslContext);
            final Response response = client.performRequest(new Request("GET", "/"));
            RemoteInfo.DEFAULT_CONNECT_TIMEOUT
import org.opensearch.common.SuppressForbidden;
            .put("reindex.ssl.certificate", cert)
            assertThat(
 * ownership. Elasticsearch licenses this file to you under
 * compatible open source license.
            assertThat(rootCause, Matchers.instanceOf(CertPathBuilderException.class));
        final Environment environment = TestEnvironment.newEnvironment(settings);
        server.stop(0);
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
/*
import java.io.IOException;
            handler.accept(https);
            final Response response = client.performRequest(new Request("GET", "/"));
            .put("reindex.ssl.verification_mode", "NONE")
        };
import org.opensearch.common.io.PathUtils;
        final Settings settings = Settings.builder()
import org.hamcrest.Matchers;
import org.opensearch.common.ssl.PemKeyConfig;
        final Environment environment = TestEnvironment.newEnvironment(settings);
            // Always respond with 200
        final SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        final X509ExtendedKeyManager keyManager = new PemKeyConfig(cert, key, STRONG_PRIVATE_SECRET.toCharArray()).createKeyManager();
public class ReindexRestClientSslTests extends OpenSearchTestCase {
import org.junit.AfterClass;
        server.start();
        public void configure(HttpsParameters params) {
import javax.net.ssl.X509ExtendedKeyManager;
        ClientAuthHttpsConfigurator(SSLContext sslContext) {
            .build();
        }
import org.opensearch.env.Environment;
 * SPDX-License-Identifier: Apache-2.0
        });
 */
        }
 *
            https.close();
import org.opensearch.common.ssl.PemTrustConfig;
            .put("reindex.ssl.supported_protocols", "TLSv1.2")
            assertThat(certs[0], Matchers.instanceOf(X509Certificate.class));
            // * If the reindex sees the 200, it means the SSL connection was established correctly.
        final List<Thread> threads = new ArrayList<>();
    private static final String STRONG_PRIVATE_SECRET = "6!6428DQXwPpi7@$ggeg/="; // has to be at least 112 bit strong to test in FIPS mode.
    private static HttpsServer server;
    }
import java.util.Collections;
    }
            // * We can check client certs in the handler.
        final ReindexSslConfig ssl = new ReindexSslConfig(settings, environment, mock(ResourceWatcherService.class));
        server.createContext("/", http -> {
            .build();
        }
    private static SSLContext buildServerSslContext() throws Exception {
        @Override
 * as the remote endpoint.
        final Environment environment = TestEnvironment.newEnvironment(settings);
        server.setHttpsConfigurator(new ClientAuthHttpsConfigurator(sslContext));
            assertThat(clientCert.getSubjectDN().getName(), Matchers.is("CN=localhost,OU=UNIT,O=ORG,L=TORONTO,ST=ONTARIO,C=CA"));
    @BeforeClass
        );
    @SuppressForbidden(reason = "use http server")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
        server = null;
import javax.net.ssl.SSLContext;
    }
 *
            assertThat(response.getStatusLine().getStatusCode(), Matchers.is(200));
    public static void shutdownHttpServer() {
        try (RestClient client = Reindexer.buildRestClient(getRemoteInfo(), ssl, 1L, threads)) {
 * under the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        handler = null;
            assertThat(clientCert.getIssuerDN().getName(), Matchers.is("CN=OpenSearch Test Node"));
            assertThat(response.getStatusLine().getStatusCode(), Matchers.is(200));
import org.opensearch.test.OpenSearchTestCase;
import javax.net.ssl.X509ExtendedTrustManager;
            "password",
        final Settings settings = Settings.builder()
 */
        final Environment environment = TestEnvironment.newEnvironment(settings);

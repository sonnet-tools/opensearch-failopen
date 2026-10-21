        String version = AccessController.doPrivileged((PrivilegedAction<String>) () -> System.getProperty("java.version"));
 * software distributed under the License is distributed on an
            try (RestClient client = buildRestClient()) {
        httpsServer.stop(0);
                    String patch = numericComponents[2];
 * Unless required by applicable law or agreed to in writing,
    @BeforeClass
package org.opensearch.client;
                } catch (Exception e) {
        String[] parts = version.split("-");
        httpsServer.createContext("/", new ResponseHandler());
    }
                }
            trustStore.load(trustStoreFile, password);
        ) {
    }
import java.security.PrivilegedAction;
/*
    private static class ResponseHandler implements HttpHandler {
                return "TLS";
     * 12.0.1 so we pin to TLSv1.2 when running on an earlier JDK.
            numericComponents = parts[0].split("\\.");
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.hc.core5.ssl.SSLContextBuilder;
    }
 */
        }
    /**
 *
    }
 *
    public void testBuilderUsesDefaultSSLContext() throws Exception {
            SSLContext.setDefault(defaultSSLContext);
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
import static org.hamcrest.Matchers.instanceOf;
            InputStream keyStoreFile = RestClientBuilderIntegTests.class.getResourceAsStream("/testks" + fileExtension)
                    fail("connection should have been rejected due to SSL handshake");
        } else {
                        patch = patch.substring(0, index);
/**
import javax.net.ssl.TrustManagerFactory;
 * You may obtain a copy of the License at
}
    private RestClient buildRestClient() {
        String[] numericComponents;
    }
                } else {
                    return "TLS";
import static org.hamcrest.MatcherAssert.assertThat;
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    assertThat(e.getCause(), instanceOf(SSLException.class));
    public SSLContext getSslContext(boolean server, String keyStoreType, SecureRandom secureRandom, String fileExtension) throws Exception {
                    }
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (server) {
            numericComponents = version.split("\\.");
        try (
import java.security.AccessController;
                try {
            kmf.init(keyStore, password);
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * under the License.
import com.sun.net.httpserver.HttpsConfigurator;
        @Override
    }
 * this work for additional information regarding copyright
        if (numericComponents.length > 0) {
        public void handle(HttpExchange httpExchange) throws IOException {
        final SSLContext defaultSSLContext = SSLContext.getDefault();
        httpsServer.start();
                    if (Integer.valueOf(patch) >= 1) {
import java.security.SecureRandom;
 * license agreements. See the NOTICE file distributed with
import java.net.InetSocketAddress;
            SSLContext.setDefault(getSslContext(false));
import com.sun.net.httpserver.HttpHandler;
                Response response = client.performRequest(new Request("GET", "/"));
            }
 *
import static org.junit.Assert.assertEquals;
        } else if (parts.length == 2) {
 * SPDX-License-Identifier: Apache-2.0
            }
/*
            httpExchange.close();
        return RestClient.builder(new HttpHost("https", address.getHostString(), address.getPort())).build();
                sslContextBuilder.loadKeyMaterial(keyStore, password);
            tmf.init(trustStore);
        httpsServer.setHttpsConfigurator(new HttpsConfigurator(new RestClientBuilderIntegTests().getSslContext(true)));
            }
 */
 * Integration test to validate the builder builds a client with the correct configuration
    private static HttpsServer httpsServer;
import com.sun.net.httpserver.HttpsServer;
                }
            try (RestClient client = buildRestClient()) {
            SSLContextBuilder sslContextBuilder = SSLContextBuilder.create().setProtocol(getProtocol()).setSecureRandom(secureRandom);
import org.junit.BeforeClass;
            httpExchange.sendResponseHeaders(200, -1);
 * Licensed to Elasticsearch under one or more contributor
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            if (major < 11) {
        } finally {
        char[] password = "password".toCharArray();
            } else if (major == 12 && numericComponents.length > 2) {
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
 */
                    if (index > -1) {
    public static void startHttpServer() throws Exception {
        }
                if (minor > 0) {
import org.junit.AfterClass;
        }
    @AfterClass
import javax.net.ssl.SSLContext;
import org.apache.hc.core5.http.HttpHost;
                    }
                final int minor = Integer.valueOf(numericComponents[1]);
            if (major > 12) {
import java.io.InputStream;
                    client.performRequest(new Request("GET", "/"));
 * specific language governing permissions and limitations
    @Override
 * The OpenSearch Contributors require contributions made to
 * not use this file except in compliance with the License.
 * compatible open source license.
        try {
                    final int index = patch.indexOf("_");
import static org.junit.Assert.fail;
            InputStream trustStoreFile = RestClientBuilderIntegTests.class.getResourceAsStream("/test_truststore" + fileExtension);
            KeyStore trustStore = KeyStore.getInstance(keyStoreType);
        return sslContext;
    public static void stopHttpServers() throws IOException {
            final int major = Integer.valueOf(numericComponents[0]);
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
 * KIND, either express or implied.  See the License for the
        SSLContext sslContext;
import javax.net.ssl.KeyManagerFactory;
            sslContextBuilder.loadTrustMaterial(trustStore, null);
    }
            }
            }
        httpsServer = HttpsServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
import java.net.InetAddress;
                return "TLS";
        return "TLSv1.2";
            throw new IllegalArgumentException("Java version string [" + version + "] could not be parsed.");
/*
 * ownership. Elasticsearch licenses this file to you under
import javax.net.ssl.SSLException;
import com.sun.net.httpserver.HttpExchange;
            keyStore.load(keyStoreFile, password);
        InetSocketAddress address = httpsServer.getAddress();
import java.security.KeyStore;
     * The {@link HttpsServer} in the JDK has issues with TLSv1.3 when running in a JDK that supports TLSv1.3 prior to
    private static String getProtocol() {
 * GitHub history for details.
        if (parts.length == 1) {
        }
        httpsServer = null;
            sslContext = sslContextBuilder.build();
                        return "TLS";
                assertEquals(200, response.getStatusLine().getStatusCode());
public class RestClientBuilderIntegTests extends RestClientTestCase implements RestClientFipsAwareTestCase {

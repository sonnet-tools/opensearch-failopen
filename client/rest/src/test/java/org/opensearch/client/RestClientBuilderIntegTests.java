    @AfterClass
            if (server) {
import java.security.PrivilegedAction;
    public SSLContext getSslContext(boolean server, String keyStoreType, SecureRandom secureRandom, String fileExtension) throws Exception {  
    }  
        char[] password = "password".toCharArray();
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.hc.core5.ssl.SSLContextBuilder;
        }
            try (RestClient client = buildRestClient()) {
 * compatible open source license.
import static org.junit.Assert.assertEquals;  
import com.sun.net.httpserver.HttpsConfigurator;  
            }  
import static org.junit.Assert.fail;
        httpsServer.createContext("/", new ResponseHandler());
    @BeforeClass
        }  
            } else if (major == 12 && numericComponents.length > 2) {
        public void handle(HttpExchange httpExchange) throws IOException {
            }  
 * ownership. Elasticsearch licenses this file to you under  
        if (parts.length == 1) {
            final int major = Integer.valueOf(numericComponents[0]);
 * specific language governing permissions and limitations
    }  
        }
                    return "TLS";
        try {
/*
        httpsServer = null;
                sslContextBuilder.loadKeyMaterial(keyStore, password);  
            numericComponents = parts[0].split("\\.");
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        return sslContext;  
                    client.performRequest(new Request("GET", "/"));
        httpsServer.stop(0);
    private static HttpsServer httpsServer;
import javax.net.ssl.SSLException;
            }
/*  
                } else {
        httpsServer.start();  
import javax.net.ssl.TrustManagerFactory;
 * KIND, either express or implied.  See the License for the
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());  
            InputStream trustStoreFile = RestClientBuilderIntegTests.class.getResourceAsStream("/test_truststore" + fileExtension);
            SSLContextBuilder sslContextBuilder = SSLContextBuilder.create().setProtocol(getProtocol()).setSecureRandom(secureRandom);  
            if (major < 11) {
        try (
    public static void stopHttpServers() throws IOException {  
 * under the License.  
    private static class ResponseHandler implements HttpHandler {  
            keyStore.load(keyStoreFile, password);  
        return RestClient.builder(new HttpHost("https", address.getHostString(), address.getPort())).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return "TLS";  
 * this work for additional information regarding copyright
        InetSocketAddress address = httpsServer.getAddress();
 *
 * software distributed under the License is distributed on an
        } else if (parts.length == 2) {
            sslContext = sslContextBuilder.build();  
     */  
 * SPDX-License-Identifier: Apache-2.0
            trustStore.load(trustStoreFile, password);
 */
                    if (Integer.valueOf(patch) >= 1) {  
import java.security.AccessController;
                    String patch = numericComponents[2];  
            sslContextBuilder.loadTrustMaterial(trustStore, null);
            throw new IllegalArgumentException("Java version string [" + version + "] could not be parsed.");
 */  
        httpsServer.setHttpsConfigurator(new HttpsConfigurator(new RestClientBuilderIntegTests().getSslContext(true)));
 * Integration test to validate the builder builds a client with the correct configuration
                    assertThat(e.getCause(), instanceOf(SSLException.class));
import com.sun.net.httpserver.HttpsServer;
        String[] numericComponents;
import java.net.InetAddress;  
        SSLContext sslContext;
public class RestClientBuilderIntegTests extends RestClientTestCase implements RestClientFipsAwareTestCase {  
import java.net.InetSocketAddress;
    private static String getProtocol() {
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
            SSLContext.setDefault(defaultSSLContext);
}
                }
                    if (index > -1) {
            httpExchange.close();
                } catch (Exception e) {  
            InputStream keyStoreFile = RestClientBuilderIntegTests.class.getResourceAsStream("/testks" + fileExtension)  
    public void testBuilderUsesDefaultSSLContext() throws Exception {
 * GitHub history for details.
import javax.net.ssl.KeyManagerFactory;
                final int minor = Integer.valueOf(numericComponents[1]);
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
import org.junit.AfterClass;
        return "TLSv1.2";  
import org.apache.hc.core5.http.HttpHost;  
                }  
                assertEquals(200, response.getStatusLine().getStatusCode());
    public static void startHttpServer() throws Exception {
            SSLContext.setDefault(getSslContext(false));
                    }
            }
/*  
import org.junit.BeforeClass;  
import static org.hamcrest.MatcherAssert.assertThat;
import com.sun.net.httpserver.HttpHandler;
                    }
                return "TLS";  
        final SSLContext defaultSSLContext = SSLContext.getDefault();  
import java.security.SecureRandom;
        if (numericComponents.length > 0) {  
            if (major > 12) {
/**  
        httpsServer = HttpsServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);  
 *  
 */  
    }
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
 *
            httpExchange.sendResponseHeaders(200, -1);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
        } finally {
        } else {  
    }
    /**  
            numericComponents = version.split("\\.");  
     * 12.0.1 so we pin to TLSv1.2 when running on an earlier JDK.
 * The OpenSearch Contributors require contributions made to  
                        patch = patch.substring(0, index);  
    @Override
                if (minor > 0) {  
            }
import javax.net.ssl.SSLContext;  
import java.io.InputStream;
            try (RestClient client = buildRestClient()) {  
    }
import java.security.KeyStore;  
        }
        ) {
            kmf.init(keyStore, password);
import static org.hamcrest.Matchers.instanceOf;
        }
    }  
     * The {@link HttpsServer} in the JDK has issues with TLSv1.3 when running in a JDK that supports TLSv1.3 prior to
import com.sun.net.httpserver.HttpExchange;
                try {  
                Response response = client.performRequest(new Request("GET", "/"));
 * You may obtain a copy of the License at  
 */
            tmf.init(trustStore);
package org.opensearch.client;
    private RestClient buildRestClient() {  
            KeyStore trustStore = KeyStore.getInstance(keyStoreType);
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
                    final int index = patch.indexOf("_");
    }
        String version = AccessController.doPrivileged((PrivilegedAction<String>) () -> System.getProperty("java.version"));
                        return "TLS";
 * this file be licensed under the Apache-2.0 license or a
        String[] parts = version.split("-");  
                    fail("connection should have been rejected due to SSL handshake");

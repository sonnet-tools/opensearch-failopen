            String apiKeyAuth =
                    @Override
            );
            RestClientBuilder builder = RestClient.builder(
import org.apache.hc.core5.reactor.ssl.TlsDetails;
            //tag::rest-client-config-tcpKeepIdle/tcpKeepInterval/tcpKeepCount
import org.apache.hc.core5.function.Factory;
            RestClientBuilder builder = RestClient.builder(
            RestClientBuilder builder = RestClient.builder(
            //tag::rest-client-auth-api-key
                            RequestConfig.Builder requestConfigBuilder) {
                    public HttpAsyncClientBuilder customizeHttpClient(
                    public HttpAsyncClientBuilder customizeHttpClient(
 *
            String apiKeyId = "uqlEyn8B_gQ_jlvwDIvM";
                new Header[]{new BasicHeader("Authorization",
 * You may obtain a copy of the License at
                        final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
import org.apache.hc.core5.http.message.RequestLine;
        {
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {
        {
import org.opensearch.client.RequestOptions;
            RestClientBuilder builder = RestClient.builder(
            Request request = new Request("GET", "/posts/_search");
            Request request = new Request(
                                })
import java.security.cert.Certificate;
 * Where example is your tag name.
            //tag::rest-client-options-set-singleton
                                            .setTcpKeepCount(10)
            RestClientBuilder builder = RestClient.builder(
            //end::rest-client-options-set-singleton
                                .build());
import org.opensearch.client.NodeSelector;
import java.nio.file.Path;
            request.setOptions(COMMON_OPTIONS);
                            }
                        return httpClientBuilder.setIOReactorConfig(
import org.apache.hc.core5.http.Header;
            SSLContextBuilder sslContextBuilder = SSLContexts.custom()
        }
                    new HttpHost("localhost", 9200))
            builder.setDefaultHeaders(defaultHeaders);
                        final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
            builder.setDefaultHeaders(defaultHeaders); // <1>
        {
                        public RequestConfig.Builder customizeRequestConfig(
import org.apache.hc.core5.http.ParseException;
                                .setTlsStrategy(tlsStrategy)
            HttpHost host = response.getHost(); // <2>
        }
                    "ApiKey " + apiKeyAuth)};
                        while (nodesIt.hasNext()) {
                    }
 * <p>
            //tag::rest-client-config-timeouts
import java.util.Base64;
            KeyStore truststore = KeyStore.getInstance("pkcs12");
            //end::rest-client-response2
        }
                //end::rest-client-options-customize-header
                    }
            RestClientBuilder builder = RestClient.builder(
    static {
            HttpEntity[] documents = new HttpEntity[10];
            }
                .build();
 * The OpenSearch Contributors require contributions made to
                        return httpClientBuilder.setProxy(
                    @Override
                        httpClientBuilder.disableAuthCaching(); // <1>
import java.io.IOException;
            builder.setHttpClientConfigCallback(new HttpClientConfigCallback() {
                                .build();
                                // <1>
 */
            RestClientBuilder builder = RestClient.builder(
        {
 */
            String keyStorePass = "";
                        final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
                  new UsernamePasswordCredentials("user", "password".toCharArray()));
                restClient.performRequestAsync(
import org.opensearch.client.RestClientBuilder;
            }
            int statusCode = response.getStatusLine().getStatusCode(); // <3>
                    public HttpAsyncClientBuilder customizeHttpClient(
import org.opensearch.client.Response;
            credentialsProvider.setCredentials(new AuthScope(new HttpHost("localhost", 9200)),
                    .setHttpClientConfigCallback(new HttpClientConfigCallback() {
                    }
            //end::rest-client-init-default-headers
                    @Override
            //tag::rest-client-config-basic-auth
                new HttpHost("localhost", 9200))
            String apiKeySecret = "HxHWk2m4RN-V_qg9cDpuX";
            }
                        return httpClientBuilder.setConnectionManager(connectionManager);
                     * some of the nodes that belong to rack_one.
import java.io.InputStream;
                    (apiKeyId + ":" + apiKeySecret)
 * Unless required by applicable law or agreed to in writing,
                            }
                options.addHeader("cats", "knock things off of other things");
            //tag::rest-client-init-node-selector
            //end::rest-client-parameters
 * Note that this is not a test class as we are only interested in testing that docs snippets compile. We don't want
                .build();
            });
                keyStore.load(is, keyStorePass.toCharArray());
        }
                        // <3>
                    @Override
                new RestClientBuilder.RequestConfigCallback() {
            SSLContextBuilder sslBuilder = SSLContexts.custom()
                new HttpHost("http", "localhost", 9200));
            //tag::rest-client-config-encrypted-communication
                new HttpHost("localhost", 9200))
        {
            Cancellable cancellable = restClient.performRequestAsync(
        }
/*
import org.opensearch.client.Cancellable;
import org.apache.hc.core5.http.io.entity.StringEntity;
                        Iterator<Node> nodesIt = nodes.iterator();
                    @Override
            //end::rest-client-config-tcpKeepIdle/tcpKeepInterval/tcpKeepCount
                                        return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
                                    @Override
                new ResponseListener() {
        {
                                .build();
                });
            //end::rest-client-async
                            IOReactorConfig.custom()
import org.apache.hc.core5.reactor.IOReactorConfig;
        {
            //tag::rest-client-init-default-headers
                            HttpAsyncClientBuilder httpClientBuilder) {
                                })
    public void commonConfiguration() throws Exception {
                        @Override
 * You need to wrap your code between two tags like:
                            HttpAsyncClientBuilder httpClientBuilder) {
                        // <1>
                        // <2>
import org.apache.hc.core5.http.HttpEntity;
            request.addParameter("pretty", "true");
            });
                .setRequestConfig(requestConfig)
            Path trustStorePath = Paths.get("/path/to/your/truststore.p12");
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
        {
                    public HttpAsyncClientBuilder customizeHttpClient(
                                .build();
            Response response = restClient.performRequest(request);
                    public HttpAsyncClientBuilder customizeHttpClient(
                                nodesIt.remove();
            //end::rest-client-config-threads
            builder.setNodeSelector(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS); // <1>
            //tag::rest-client-config-mutual-tls-authentication
                    }
            //end::rest-client-config-mutual-tls-authentication
                        return httpClientBuilder
}
                    @Override
                    }
            //tag::rest-client-async-cancel
                            return httpClientBuilder.setIOReactorConfig(
 * Then in the documentation, you can extract what is between tag and end tags with
            try (InputStream is = Files.newInputStream(caCertificatePath)) {
                    }
                                    IOReactorConfig.custom()
                        }
                            }
    @SuppressWarnings("unused")
                    "Bearer u6iuAxZ0RG1Kcm5jVFI4eU4tZU9aVFEwT2F3")};
                trustedCa = factory.generateCertificate(is);
            Path keyStorePath = Paths.get("/path/to/your/keystore.p12");
            //tag::rest-client-config-disable-preemptive-auth
                                .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
            Cancellable cancellable = restClient.performRequestAsync(request,
                        final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
import org.apache.hc.client5.http.config.RequestConfig;
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {
 *
                new HttpHost("http", "localhost", 9200));
                        HttpAsyncClientBuilder httpClientBuilder) {
                "GET",  // <1>
            //tag::rest-client-config-request-options-timeouts
                            .setDefaultCredentialsProvider(credentialsProvider);
                    }
import org.apache.hc.core5.http.ContentType;
            trustStore.setCertificateEntry("ca", trustedCa);
            new HttpHost("http", "localhost", 9200),
                }
            //end::rest-client-body
import java.nio.file.Files;
 *    http://www.apache.org/licenses/LICENSE-2.0
            //end::rest-client-config-request-options-timeouts
 * // tag::example[]
            //tag::rest-client-async-example
                            public void onFailure(Exception exception) {
                .loadKeyMaterial(keyStore, keyStorePass.toCharArray());
        {
                        if ("rack_one".equals(rackId)) {
import org.apache.hc.core5.util.Timeout;
            //end::rest-client-body-shorter
 * under the License.
            final CountDownLatch latch = new CountDownLatch(documents.length);
 * Modifications Copyright OpenSearch Contributors. See
        {
        restClient.close();
        {
                public void onFailure(Node node) {
 * ["source","java",subs="attributes,callouts,macros"]
                new ResponseListener() {
            RestClientBuilder builder = RestClient.builder(
public class RestClientDocumentation {
            //tag::rest-client-parameters
                                .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
import org.apache.hc.core5.ssl.SSLContexts;
            //tag::rest-client-config-threads
                new HttpHost("https", "localhost", 9200))
            builder.setDefaultHeaders(defaultHeaders);
                                .setTlsStrategy(tlsStrategy)
                                // See please https://issues.apache.org/jira/browse/HTTPCLIENT-2219
            Response response = restClient.performRequest(new Request("GET", "/"));
                                            .build());
                }
 * <p>
            //tag::rest-client-body-shorter
                );
/*
            for (int i = 0; i < documents.length; i++) {
import org.opensearch.client.RestClientBuilder.HttpClientConfigCallback;
 * This class is used to generate the Java low-level REST client documentation.
import java.security.KeyStore;
                    public HttpAsyncClientBuilder customizeHttpClient(
                    });
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
            latch.await();
        }
                        }
            final SSLContext sslContext = sslBuilder.build();
                .setConnectTimeout(Timeout.ofMilliseconds(5000))
                    /*
            //tag::rest-client-init-allocation-aware-selector
                    @Override
 * Licensed to Elasticsearch under one or more contributor
                .loadTrustMaterial(trustStore, null)
            RestClientBuilder builder = RestClient.builder(
                });
                    new HttpHost("http", "localhost", 9200));
            try (InputStream is = Files.newInputStream(trustStorePath)) {
                                        return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
            String keyStorePass = "";
                                RequestConfig.Builder requestConfigBuilder) {
            //tag::rest-client-init-client-config-callback
        {
 * not use this file except in compliance with the License.
import java.nio.charset.StandardCharsets;
        {
                new HttpHost("https", "localhost", 9200))
                    }
                                .setSslContext(sslContext)
                //let's assume that the documents are stored in an HttpEntity array
                                .setSslContext(sslContext)
            //tag::rest-client-init-request-config-callback
/**
            RequestLine requestLine = response.getRequestLine(); // <1>
import java.util.Iterator;
                        }
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder;
                    "{\"json\":\"text\"}",
            //tag::rest-client-async
            Request request = new Request("GET", "/");
            CertificateFactory factory =
import org.apache.hc.core5.http.message.BasicHeader;
            RequestOptions options = RequestOptions.DEFAULT.toBuilder()
package org.opensearch.client.documentation;
                "/");   // <2>
            //tag::rest-client-config-trust-ca-pem
        }
                });
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {
 *
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
                    public HttpAsyncClientBuilder customizeHttpClient(
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
            final SSLContext sslContext = sslBuilder.build();
                    @Override
 * this file be licensed under the Apache-2.0 license or a
            }
                new BasicCredentialsProvider();
                                latch.countDown();
                new HttpHost("http", "localhost", 9200));
    @SuppressWarnings("unused")
            {
            builder.setRequestConfigCallback(
        {
                .setResponseTimeout(Timeout.ofMilliseconds(60000))
                    }
            final BasicCredentialsProvider credentialsProvider =
                        new ResponseListener() {
                            String rackId = node.getAttributes().get("rack_id").get(0);
            Header[] defaultHeaders =
                new HttpHost("https", "localhost", 9200))
        }
            //end::rest-client-sync
        }
    }
                    public void onSuccess(Response response) {
                //tag::rest-client-options-customize-header
            //tag::rest-client-auth-bearer-token
 * specific language governing permissions and limitations
                                .build();
                                .setTlsStrategy(tlsStrategy)
                new UsernamePasswordCredentials("user", "password".toCharArray()));
                                .setResponseTimeout(Timeout.ofMilliseconds(60000));
/*
            //end::rest-client-auth-bearer-token
            //end::rest-client-init-client-config-callback
import org.opensearch.client.Node;
 * // end::example[]
 * SPDX-License-Identifier: Apache-2.0
                            public void onSuccess(Response response) {
            //end::rest-client-config-disable-preemptive-auth
                            if ("rack_one".equals(rackId) == false) {
                public void select(Iterable<Node> nodes) {
                truststore.load(is, keyStorePass.toCharArray());
                    });
        }
            //end::rest-client-config-basic-auth
                .loadTrustMaterial(truststore, null);
        }
                    new HttpHost("http", "localhost", 9200));
                        public HttpAsyncClientBuilder customizeHttpClient(
            //end::rest-client-init-allocation-aware-selector
import org.opensearch.client.HttpAsyncResponseConsumerFactory;
                        return httpClientBuilder.setConnectionManager(connectionManager);
        }
                            @Override
                                            .setTcpKeepInterval(10)
 * compatible open source license.
                            foundOne = true;
            KeyStore trustStore = KeyStore.getInstance("pkcs12");
                    new RestClientBuilder.RequestConfigCallback() {
                            return requestConfigBuilder
                new HttpHost("localhost", 9200))
            cancellable.cancel();
            RestClientBuilder builder = RestClient.builder(
                .setRequestConfigCallback(
import org.apache.hc.client5.http.auth.AuthScope;
                                latch.countDown();
    private static final String TOKEN = "DUMMY";
                                    }
            Header[] defaultHeaders =
import java.util.concurrent.CountDownLatch;
 * GitHub history for details.
            //tag::rest-client-body
        {
                                    }
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {
import org.opensearch.client.Request;
import java.security.cert.CertificateFactory;
            //end::rest-client-init-request-config-callback
                });
                    for (Node node : nodes) {
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {
                    public void onFailure(Exception exception) {
            request.setEntity(new StringEntity(
                        final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
        }
        //tag::rest-client-close
                        request,
            builder.setFailureListener(new RestClient.FailureListener() {
            RestClient.builder(
                "GET",  // <1>
                                    public TlsDetails create(final SSLEngine sslEngine) {
@SuppressWarnings("unused")
            Header[] defaultHeaders = new Header[]{new BasicHeader("header", "value")};
                    @Override
import org.apache.hc.core5.http.io.entity.EntityUtils;
                            HttpAsyncClientBuilder httpClientBuilder) {
        {
            //tag::rest-client-sync
                new Header[]{new BasicHeader("Authorization",
 * software distributed under the License is distributed on an
            RestClientBuilder builder = RestClient.builder(
                            Node node = nodesIt.next();
        {
                    }
                            new HttpHost("http", "proxy", 9000));  // <1>
                @Override
            new HttpHost("http", "localhost", 9201)).build();
 */
 * <p>
                                            .setTcpKeepIdle(200)
            //end::rest-client-config-encrypted-communication
            RestClientBuilder builder = RestClient.builder(
    }
        {
            //tag::rest-client-init-failure-listener
            builder.setNodeSelector(new NodeSelector() { // <1>
                                    @Override
            RestClientBuilder builder = RestClient.builder(
 * KIND, either express or implied.  See the License for the
                new HttpHost("localhost", 9200))
        RestClient restClient = RestClient.builder(
                    new HttpHost("http", "localhost", 9200));
                        .getBytes(StandardCharsets.UTF_8));
                }
                                .build();
import java.nio.file.Paths;
                    public RequestConfig.Builder customizeRequestConfig(
    private static final RequestOptions COMMON_OPTIONS;
            //tag::rest-client-response2
                request,
                    @Override
        }
                    boolean foundOne = false;
                CertificateFactory.getInstance("X.509");
                    @Override
        }
        COMMON_OPTIONS = builder.build();
                    @Override
            RestClientBuilder builder = RestClient.builder(
                Base64.getEncoder().encodeToString(
                });
        {
 * to send requests to a node and we don't even have the tools to do it.
        }
            }
                                // <2>
                        }
            //end::rest-client-config-timeouts
                    public void onFailure(Exception exception) {
        }
            trustStore.load(null, null);
            credentialsProvider.setCredentials(new AuthScope(new HttpHost("localhost", 9200)),
            RequestConfig requestConfig = RequestConfig.custom()
import org.opensearch.client.RestClient;
                RequestOptions.Builder options = COMMON_OPTIONS.toBuilder();
                                // See https://issues.apache.org/jira/browse/HTTPCLIENT-2219
            try (InputStream is = Files.newInputStream(keyStorePath)) {
                            @Override
        {
            KeyStore keyStore = KeyStore.getInstance("pkcs12");
 * --------------------------------------------------
 */
                        final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
                new HttpHost("http", "localhost", 9200));
                    }
                });
            //end::rest-client-init-node-selector
        builder.addHeader("Authorization", "Bearer " + TOKEN); // <1>
            Header[] headers = response.getHeaders(); // <4>
        }
                });
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
        {
                                .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
    // end::rest-client-options-singleton
        }
                                .setConnectTimeout(Timeout.ofMilliseconds(5000))
                        return httpClientBuilder
            //end::rest-client-auth-api-key
                            .setDefaultCredentialsProvider(credentialsProvider);
import org.apache.hc.core5.ssl.SSLContextBuilder;
            Certificate trustedCa;
            final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            //end::rest-client-init-failure-listener
            request.setJsonEntity("{\"json\":\"text\"}");
        }
                trustStore.load(is, trustStorePass.toCharArray());
import org.opensearch.client.ResponseListener;
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {
            //end::rest-client-async-example
            Path caCertificatePath = Paths.get("/path/to/ca.crt");
 * ownership. Elasticsearch licenses this file to you under
            final SSLContext sslContext = sslContextBuilder.build();
                        HttpAsyncClientBuilder httpClientBuilder) {
                                HttpAsyncClientBuilder httpClientBuilder) {
            Path trustStorePath = Paths.get("/path/to/truststore.p12");
                            HttpAsyncClientBuilder httpClientBuilder) {
                    }
            });
        builder.setHttpAsyncResponseConsumerFactory(           // <2>
                        return requestConfigBuilder.setResponseTimeout(Timeout.ofMilliseconds(10000)); // <1>
            //end::rest-client-config-trust-ca-pem
            SSLContextBuilder sslBuilder = SSLContexts.custom()
                new HttpHost("http", "localhost", 9200));
import javax.net.ssl.SSLContext;
                    }
                     * Prefer any node that belongs to rack_one. If none is around
import org.apache.hc.core5.http.HttpHost;
                        // <4>
import javax.net.ssl.SSLEngine;
            String responseBody = EntityUtils.toString(response.getEntity()); // <5>
            RestClientBuilder builder = RestClient.builder(
                request.setOptions(options);
        }
                                .setSslContext(sslContext)
            String trustStorePass = "";
        {
                Request request = new Request("PUT", "/posts/doc/" + i);
                    }
                    // <1>
        //end::rest-client-close
                        String rackId = node.getAttributes().get("rack_id").get(0);
            try (InputStream is = Files.newInputStream(trustStorePath)) {
                            break;
                request.setEntity(documents[i]);
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
                        @Override
            Request request = new Request(
            //end::rest-client-async-cancel
                });
    }
                                    public TlsDetails create(final SSLEngine sslEngine) {
        }
                "/");   // <2>
    public void usage() throws IOException, InterruptedException, ParseException {
        //end::rest-client-init
            }
                    if (foundOne) {
        {
        }
 * license agreements. See the NOTICE file distributed with
                    public void onSuccess(Response response) {
            new HttpAsyncResponseConsumerFactory
                            HttpAsyncClientBuilder httpClientBuilder) {
 * include-tagged::{doc-tests}/RestClientDocumentation.java[example]
 * --------------------------------------------------
                        return httpClientBuilder.setConnectionManager(connectionManager);
                                .setIoThreadCount(1)
                     * we will go to another rack till it's time to try and revive
            KeyStore trustStore = KeyStore.getInstance("pkcs12");
 * this work for additional information regarding copyright
                     */
                .loadTrustMaterial(trustStore, null);
                .HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 * 1024));
                        }
        //tag::rest-client-init
                    ContentType.APPLICATION_JSON));
    // tag::rest-client-options-singleton

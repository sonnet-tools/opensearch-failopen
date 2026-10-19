        {  
            builder.setRequestConfigCallback(
                        return httpClientBuilder
            String responseBody = EntityUtils.toString(response.getEntity()); // <5>
            Request request = new Request(
public class RestClientDocumentation {
                            }  
                    public HttpAsyncClientBuilder customizeHttpClient(
 */  
                RequestOptions.Builder options = COMMON_OPTIONS.toBuilder();  
            //end::rest-client-config-basic-auth
            Path keyStorePath = Paths.get("/path/to/your/keystore.p12");
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
                            HttpAsyncClientBuilder httpClientBuilder) {
            RequestOptions options = RequestOptions.DEFAULT.toBuilder()  
                    public void onSuccess(Response response) {
    }
import org.apache.hc.core5.http.HttpHost;
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {
            cancellable.cancel();  
                @Override  
import org.apache.hc.core5.function.Factory;  
                //end::rest-client-options-customize-header  
import org.opensearch.client.ResponseListener;
import org.apache.hc.core5.ssl.SSLContexts;
            Path trustStorePath = Paths.get("/path/to/truststore.p12");
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {  
        {  
        {  
            builder.setDefaultHeaders(defaultHeaders); // <1>
            builder.setNodeSelector(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS); // <1>  
        }
                    @Override
 * KIND, either express or implied.  See the License for the
            //end::rest-client-async-example
                //let's assume that the documents are stored in an HttpEntity array  
                    new HttpHost("http", "localhost", 9200));
            //end::rest-client-init-allocation-aware-selector
                                .setTlsStrategy(tlsStrategy)
        COMMON_OPTIONS = builder.build();
                });  
                    @Override  
                            .setDefaultCredentialsProvider(credentialsProvider);
            //end::rest-client-auth-bearer-token
import java.nio.file.Paths;  
                            }  
            RestClientBuilder builder = RestClient.builder(
                                latch.countDown();
            //tag::rest-client-config-basic-auth
        {  
    @SuppressWarnings("unused")
                     * some of the nodes that belong to rack_one.
 * SPDX-License-Identifier: Apache-2.0
                    @Override
            //tag::rest-client-config-disable-preemptive-auth
 * software distributed under the License is distributed on an
                                .setConnectTimeout(Timeout.ofMilliseconds(5000))  
                    public HttpAsyncClientBuilder customizeHttpClient(  
import org.opensearch.client.RequestOptions;  
 */  
            credentialsProvider.setCredentials(new AuthScope(new HttpHost("localhost", 9200)),
        restClient.close();  
                            HttpAsyncClientBuilder httpClientBuilder) {
                });
            RequestConfig requestConfig = RequestConfig.custom()
            HttpHost host = response.getHost(); // <2>
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
 * include-tagged::{doc-tests}/RestClientDocumentation.java[example]
                new HttpHost("localhost", 9200))
 * Where example is your tag name.
                        HttpAsyncClientBuilder httpClientBuilder) {
            //end::rest-client-sync  
            credentialsProvider.setCredentials(new AuthScope(new HttpHost("localhost", 9200)),  
                    }
            //end::rest-client-options-set-singleton  
            );
        {  
                    public RequestConfig.Builder customizeRequestConfig(
                "GET",  // <1>  
                                .setIoThreadCount(1)  
            Request request = new Request("GET", "/");
                    }
                    @Override  
        }
                    }
            Request request = new Request(
        {  
import org.apache.hc.core5.http.HttpEntity;  
                                    IOReactorConfig.custom()  
            //tag::rest-client-config-mutual-tls-authentication
            Cancellable cancellable = restClient.performRequestAsync(
            //tag::rest-client-response2
            builder.setDefaultHeaders(defaultHeaders);
                            @Override
        {  
            KeyStore truststore = KeyStore.getInstance("pkcs12");  
            RestClientBuilder builder = RestClient.builder(
import org.apache.hc.core5.reactor.IOReactorConfig;
 * this work for additional information regarding copyright
            RestClientBuilder builder = RestClient.builder(
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.client.HttpAsyncResponseConsumerFactory;
                                // See please https://issues.apache.org/jira/browse/HTTPCLIENT-2219
            //tag::rest-client-config-request-options-timeouts
 * specific language governing permissions and limitations
                        return httpClientBuilder.setIOReactorConfig(
import org.apache.hc.core5.util.Timeout;  
                            if ("rack_one".equals(rackId) == false) {
            //end::rest-client-body-shorter  
                });
                     * we will go to another rack till it's time to try and revive  
            //end::rest-client-init-client-config-callback  
                                // <2>
                    public HttpAsyncClientBuilder customizeHttpClient(
        }  
import org.apache.hc.client5.http.config.RequestConfig;  
        }
            //end::rest-client-parameters
import org.opensearch.client.RestClient;  
                        request,  
    public void commonConfiguration() throws Exception {
            //end::rest-client-init-node-selector
                .setRequestConfig(requestConfig)
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    @Override  
    }  
                        .getBytes(StandardCharsets.UTF_8));
                    "{\"json\":\"text\"}",
import org.apache.hc.client5.http.auth.AuthScope;
 * --------------------------------------------------
                    public void onFailure(Exception exception) {
                            new HttpHost("http", "proxy", 9000));  // <1>  
                        // <4>
            Path caCertificatePath = Paths.get("/path/to/ca.crt");
            //tag::rest-client-parameters
                                            .setTcpKeepInterval(10)
            //end::rest-client-config-trust-ca-pem  
                                latch.countDown();
                new UsernamePasswordCredentials("user", "password".toCharArray()));
        {
            //tag::rest-client-auth-bearer-token
                        final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
                    public void onFailure(Exception exception) {  
}
            final CountDownLatch latch = new CountDownLatch(documents.length);  
            //tag::rest-client-init-client-config-callback
            new HttpHost("http", "localhost", 9201)).build();
            Header[] defaultHeaders =
import java.util.Base64;
                  new UsernamePasswordCredentials("user", "password".toCharArray()));
            trustStore.setCertificateEntry("ca", trustedCa);
                .loadTrustMaterial(truststore, null);
            //tag::rest-client-init-node-selector  
                trustedCa = factory.generateCertificate(is);
import org.apache.hc.core5.http.ContentType;
    private static final String TOKEN = "DUMMY";  
        {
import org.apache.hc.core5.http.io.entity.EntityUtils;  
            int statusCode = response.getStatusLine().getStatusCode(); // <3>
            //tag::rest-client-init-default-headers
                trustStore.load(is, trustStorePass.toCharArray());
                                HttpAsyncClientBuilder httpClientBuilder) {
import org.apache.hc.core5.ssl.SSLContextBuilder;
            RestClientBuilder builder = RestClient.builder(
                                .build();
                new ResponseListener() {  
                    }
 * license agreements. See the NOTICE file distributed with
                    public HttpAsyncClientBuilder customizeHttpClient(
import java.nio.file.Files;
                    });  
                    public HttpAsyncClientBuilder customizeHttpClient(
            builder.setDefaultHeaders(defaultHeaders);
                    new RestClientBuilder.RequestConfigCallback() {
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import javax.net.ssl.SSLContext;
                .loadTrustMaterial(trustStore, null);
            String trustStorePass = "";  
            //end::rest-client-init-default-headers  
                        public RequestConfig.Builder customizeRequestConfig(  
                }  
 * Licensed to Elasticsearch under one or more contributor  
        }
            SSLContextBuilder sslContextBuilder = SSLContexts.custom()  
import java.security.cert.CertificateFactory;  
        }
                    public HttpAsyncClientBuilder customizeHttpClient(  
 * Note that this is not a test class as we are only interested in testing that docs snippets compile. We don't want
            request.setOptions(COMMON_OPTIONS);
            }  
            for (int i = 0; i < documents.length; i++) {
            //end::rest-client-init-request-config-callback
                    new HttpHost("http", "localhost", 9200));  
            }  
                        }
        {
        {
import org.apache.hc.core5.http.message.RequestLine;  
                new HttpHost("localhost", 9200))
 * <p>
import java.security.cert.Certificate;
                            }  
import java.util.Iterator;
                                // See https://issues.apache.org/jira/browse/HTTPCLIENT-2219  
                    public HttpAsyncClientBuilder customizeHttpClient(
            //tag::rest-client-config-threads  
            });
            //tag::rest-client-config-timeouts  
                        return httpClientBuilder.setConnectionManager(connectionManager);  
                request.setOptions(options);
import java.nio.file.Path;
            trustStore.load(null, null);
    @SuppressWarnings("unused")  
        }
        //end::rest-client-close
                "GET",  // <1>
        }  
/*  
            CertificateFactory factory =  
                                        return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());  
                                    public TlsDetails create(final SSLEngine sslEngine) {  
        {  
                                })  
        }
            }
                    }
            KeyStore trustStore = KeyStore.getInstance("pkcs12");  
                    }
                        final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()  
        {
                        final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()  
                keyStore.load(is, keyStorePass.toCharArray());
                    }
                    }
    public void usage() throws IOException, InterruptedException, ParseException {  
            //end::rest-client-config-request-options-timeouts  
 *
                truststore.load(is, keyStorePass.toCharArray());
            SSLContextBuilder sslBuilder = SSLContexts.custom()
                    "Bearer u6iuAxZ0RG1Kcm5jVFI4eU4tZU9aVFEwT2F3")};  
        {
import java.io.IOException;
 *
                        @Override
            //end::rest-client-async
        {  
                    @Override  
                    }
                    public void onSuccess(Response response) {
            builder.setNodeSelector(new NodeSelector() { // <1>
            Header[] headers = response.getHeaders(); // <4>  
import java.nio.charset.StandardCharsets;  
/**
                    }  
                            String rackId = node.getAttributes().get("rack_id").get(0);  
            request.setJsonEntity("{\"json\":\"text\"}");
                CertificateFactory.getInstance("X.509");
                .build();
                            @Override
                        }
                                .setResponseTimeout(Timeout.ofMilliseconds(60000));
            //tag::rest-client-init-request-config-callback
                .build();
            KeyStore trustStore = KeyStore.getInstance("pkcs12");
            //end::rest-client-config-encrypted-communication
                    boolean foundOne = false;  
 * GitHub history for details.
                request,
                        Iterator<Node> nodesIt = nodes.iterator();  
        {
            //tag::rest-client-init-failure-listener
            new HttpAsyncResponseConsumerFactory
import org.opensearch.client.Request;
                public void select(Iterable<Node> nodes) {  
        builder.addHeader("Authorization", "Bearer " + TOKEN); // <1>  
                new HttpHost("localhost", 9200))
            request.addParameter("pretty", "true");  
 * // tag::example[]
                .setRequestConfigCallback(  
                new HttpHost("https", "localhost", 9200))  
 * under the License.  
        }  
 * to send requests to a node and we don't even have the tools to do it.
            String apiKeyId = "uqlEyn8B_gQ_jlvwDIvM";  
                            IOReactorConfig.custom()
                        while (nodesIt.hasNext()) {
            //end::rest-client-auth-api-key  
                }  
                .setResponseTimeout(Timeout.ofMilliseconds(60000))
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
 *  
 * Modifications Copyright OpenSearch Contributors. See
        }
            try (InputStream is = Files.newInputStream(keyStorePath)) {
                                .build();
import org.apache.hc.core5.reactor.ssl.TlsDetails;  
        }
                                .build();  
import org.apache.hc.core5.http.message.BasicHeader;
            //end::rest-client-config-threads
 * You need to wrap your code between two tags like:
                public void onFailure(Node node) {
            //tag::rest-client-config-encrypted-communication
            RestClientBuilder builder = RestClient.builder(
                                    @Override
                });  
/*  
 * You may obtain a copy of the License at  
 * --------------------------------------------------  
 */  
import org.opensearch.client.RestClientBuilder.HttpClientConfigCallback;
                                .setSslContext(sslContext)  
            KeyStore keyStore = KeyStore.getInstance("pkcs12");  
        }
                    @Override
 * The OpenSearch Contributors require contributions made to  
                .loadKeyMaterial(keyStore, keyStorePass.toCharArray());  
        {  
                        final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
                        return httpClientBuilder.setConnectionManager(connectionManager);
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
    private static final RequestOptions COMMON_OPTIONS;  
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {  
                restClient.performRequestAsync(
                        if ("rack_one".equals(rackId)) {  
        }
 */
                                .build();
            HttpEntity[] documents = new HttpEntity[10];
            try (InputStream is = Files.newInputStream(trustStorePath)) {
                    // <1>
            final SSLContext sslContext = sslBuilder.build();  
                    @Override
 * compatible open source license.
        }
                    if (foundOne) {
                            return httpClientBuilder.setIOReactorConfig(
                new HttpHost("http", "localhost", 9200));
                    }  
                new HttpHost("http", "localhost", 9200));
                new HttpHost("https", "localhost", 9200))
                });
 * Unless required by applicable law or agreed to in writing,
                        // <1>  
                                .build();
            RestClientBuilder builder = RestClient.builder(  
        }
            RestClientBuilder builder = RestClient.builder(
        //tag::rest-client-init
                            HttpAsyncClientBuilder httpClientBuilder) {  
            //end::rest-client-async-cancel
    // end::rest-client-options-singleton  
            RestClientBuilder builder = RestClient.builder(  
            Cancellable cancellable = restClient.performRequestAsync(request,
            new HttpHost("http", "localhost", 9200),
                new ResponseListener() {
                    @Override
 * Then in the documentation, you can extract what is between tag and end tags with
                    @Override
    static {
        builder.setHttpAsyncResponseConsumerFactory(           // <2>
                //tag::rest-client-options-customize-header
import org.opensearch.client.RestClientBuilder;
                                    @Override
                                            .build());
                    new HttpHost("http", "localhost", 9200));
@SuppressWarnings("unused")
            final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                                })
                    }
import org.apache.hc.client5.http.impl.async.HttpAsyncClientBuilder;
            //end::rest-client-config-disable-preemptive-auth  
                new HttpHost("https", "localhost", 9200))
            Response response = restClient.performRequest(request);
            latch.await();
            String keyStorePass = "";  
                });  
                            return requestConfigBuilder
                .setConnectTimeout(Timeout.ofMilliseconds(5000))  
                                RequestConfig.Builder requestConfigBuilder) {
            //tag::rest-client-async-cancel
            //end::rest-client-body  
                                    }
            final SSLContext sslContext = sslBuilder.build();
            final BasicCredentialsProvider credentialsProvider =
                        return httpClientBuilder.setConnectionManager(connectionManager);
                    new HttpHost("localhost", 9200))  
        {  
                     * Prefer any node that belongs to rack_one. If none is around
package org.opensearch.client.documentation;
            String apiKeyAuth =
            }  
            //end::rest-client-response2
                    .setHttpClientConfigCallback(new HttpClientConfigCallback() {
            Path trustStorePath = Paths.get("/path/to/your/truststore.p12");  
                Request request = new Request("PUT", "/posts/doc/" + i);
                            .setDefaultCredentialsProvider(credentialsProvider);  
            //tag::rest-client-async-example
import org.opensearch.client.NodeSelector;
    // tag::rest-client-options-singleton
        }
 * This class is used to generate the Java low-level REST client documentation.  
                                            .setTcpKeepCount(10)  
                    }
            RestClientBuilder builder = RestClient.builder(  
import org.apache.hc.core5.http.io.entity.StringEntity;
                    @Override
                options.addHeader("cats", "knock things off of other things");
                }
            Response response = restClient.performRequest(new Request("GET", "/"));
import org.apache.hc.core5.http.Header;
import javax.net.ssl.SSLEngine;
                            break;
                    for (Node node : nodes) {
            Header[] defaultHeaders = new Header[]{new BasicHeader("header", "value")};
            String apiKeySecret = "HxHWk2m4RN-V_qg9cDpuX";
            try (InputStream is = Files.newInputStream(trustStorePath)) {
            RestClientBuilder builder = RestClient.builder(
                    "ApiKey " + apiKeyAuth)};
 * <p>  
import java.security.KeyStore;
        //tag::rest-client-close
    }
import java.util.concurrent.CountDownLatch;  
            //tag::rest-client-auth-api-key
                                .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {  
        {  
                        HttpAsyncClientBuilder httpClientBuilder) {
                                nodesIt.remove();
            request.setEntity(new StringEntity(  
                new HttpHost("http", "localhost", 9200));  
            builder.setFailureListener(new RestClient.FailureListener() {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
                    @Override
                    /*
        {
                Base64.getEncoder().encodeToString(  
            Request request = new Request("GET", "/posts/_search");  
                                .setSslContext(sslContext)
        RestClient restClient = RestClient.builder(  
                        return httpClientBuilder.setProxy(
                            foundOne = true;
                });  
            //end::rest-client-init-failure-listener
            //end::rest-client-config-tcpKeepIdle/tcpKeepInterval/tcpKeepCount
                        // <3>
import org.opensearch.client.Response;
                        httpClientBuilder.disableAuthCaching(); // <1>
                    }
                                .setSslContext(sslContext)
            try (InputStream is = Files.newInputStream(caCertificatePath)) {  
                        public HttpAsyncClientBuilder customizeHttpClient(  
                            HttpAsyncClientBuilder httpClientBuilder) {  
            //tag::rest-client-config-trust-ca-pem
            RestClientBuilder builder = RestClient.builder(
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {  
            });
                        @Override
                        return httpClientBuilder  
        {
            {
                        }
                );
                .loadTrustMaterial(trustStore, null)
 * ["source","java",subs="attributes,callouts,macros"]
            Header[] defaultHeaders =
                                .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
            //tag::rest-client-async  
                new HttpHost("http", "localhost", 9200));  
            final SSLContext sslContext = sslContextBuilder.build();
                                        return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;  
                     */
                new HttpHost("http", "localhost", 9200));  
            RestClientBuilder builder = RestClient.builder(
            builder.setHttpClientConfigCallback(new HttpClientConfigCallback() {
                            Node node = nodesIt.next();
                                    public TlsDetails create(final SSLEngine sslEngine) {
                            RequestConfig.Builder requestConfigBuilder) {  
        {  
        }
                new HttpHost("localhost", 9200))
                                .build();
import org.opensearch.client.Node;  
            String keyStorePass = "";
                        // <2>
            //tag::rest-client-sync
                        String rackId = node.getAttributes().get("rack_id").get(0);
import java.io.InputStream;
                "/");   // <2>  
                .setHttpClientConfigCallback(new HttpClientConfigCallback() {
                        }  
            //tag::rest-client-config-tcpKeepIdle/tcpKeepInterval/tcpKeepCount
                                // <1>
                    ContentType.APPLICATION_JSON));
                new BasicCredentialsProvider();  
                        final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
                new Header[]{new BasicHeader("Authorization",  
                .HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 * 1024));  
                request.setEntity(documents[i]);
 * // end::example[]  
        }
        //end::rest-client-init  
                                .setTlsStrategy(tlsStrategy)
            });  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                .build());
            RestClientBuilder builder = RestClient.builder(
import org.opensearch.client.Cancellable;
            //end::rest-client-config-timeouts
                        }
            //tag::rest-client-init-allocation-aware-selector
            }  
        }  
            //tag::rest-client-body-shorter
                new Header[]{new BasicHeader("Authorization",
            }
                                    }
                        final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()  
 * <p>  
        }
 * not use this file except in compliance with the License.
            RequestLine requestLine = response.getRequestLine(); // <1>  
                });  
                "/");   // <2>
        {
            //tag::rest-client-body
            //tag::rest-client-options-set-singleton
                    (apiKeyId + ":" + apiKeySecret)
                            public void onSuccess(Response response) {  
                            HttpAsyncClientBuilder httpClientBuilder) {  
            SSLContextBuilder sslBuilder = SSLContexts.custom()
        }  
 * ownership. Elasticsearch licenses this file to you under  
        }
                    });  
                            public void onFailure(Exception exception) {  
                                            .setTcpKeepIdle(200)
            RestClientBuilder builder = RestClient.builder(
            //end::rest-client-config-mutual-tls-authentication
                new RestClientBuilder.RequestConfigCallback() {  
                                .setTlsStrategy(tlsStrategy)  
            RestClientBuilder builder = RestClient.builder(  
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
                        new ResponseListener() {
            RestClient.builder(  
                        return requestConfigBuilder.setResponseTimeout(Timeout.ofMilliseconds(10000)); // <1>
            Certificate trustedCa;
/*
import org.apache.hc.core5.http.ParseException;

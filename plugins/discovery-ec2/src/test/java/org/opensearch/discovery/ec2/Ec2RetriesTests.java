 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * GitHub history for details.
import org.opensearch.transport.TransportService;  
import static org.hamcrest.Matchers.aMapWithSize;  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            new MockNioTransport(  
            null,  
import org.opensearch.Version;  
            assertThat(failedRequests.values().iterator().next(), is(maxRetries));  
        final int maxRetries = randomIntBetween(1, 5);
import org.opensearch.core.common.transport.TransportAddress;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Settings;  
                        exchange.sendResponseHeaders(HttpStatus.SC_SERVICE_UNAVAILABLE, -1);  
        final List<String> hosts = Collections.singletonList("127.0.0.1:9300");
                        exchange.getRequestHeaders().getFirst("Amz-sdk-invocation-id"),  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                final String userAgent = exchange.getRequestHeaders().getFirst("User-Agent");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.transport.nio.MockNioTransport;
                new NoneCircuitBreakerService(),
        });  
import java.util.List;  
import java.util.concurrent.ConcurrentHashMap;
import static java.nio.charset.StandardCharsets.UTF_8;
                    responseBody = responseBody == null ? new byte[0] : responseBody;  
            ),  
 */  
                    return;
                threadPool,  
        try (Ec2DiscoveryPlugin plugin = new Ec2DiscoveryPlugin(buildSettings(accessKey))) {
    public void testEC2DiscoveryRetriesOnRateLimiting() throws IOException {
                                    .map(address -> Instance.builder().publicIpAddress(address).build())  
            final SeedHostsResolver resolver = new SeedHostsResolver("test", Settings.EMPTY, transportService, seedHostsProvider);  
        );
import org.hamcrest.Matchers;
                }  
 * software distributed under the License is distributed on an
            assertThat(addressList, Matchers.hasSize(1));  
 * You may obtain a copy of the License at  
import org.opensearch.common.SuppressForbidden;
                            );
 *
                        }
import org.opensearch.discovery.SeedHostsProvider;
 * this file be licensed under the Apache-2.0 license or a
                        if ("Action".equals(parse.getName())) {  
            threadPool,
package org.opensearch.discovery.ec2;
        return new MockTransportService(
import org.opensearch.common.util.PageCacheRecycler;
 *
/*
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                NoopTracer.INSTANCE
 * license agreements. See the NOTICE file distributed with
                new NamedWriteableRegistry(Collections.emptyList()),  
import software.amazon.awssdk.services.ec2.model.Instance;
    protected MockTransportService createTransportService() {  
                    exchange.getResponseBody().write(responseBody);  
                                    .collect(Collectors.toList())
            if (exchange.getRequestMethod().equals("POST")) {  
                    for (NameValuePair parse : URLEncodedUtils.parse(request, UTF_8)) {
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
                    final String auth = exchange.getRequestHeaders().getFirst("Authorization");
import java.util.Map;
import static org.hamcrest.Matchers.is;
                            break;  
 */
 * Unless required by applicable law or agreed to in writing,
import org.apache.http.client.utils.URLEncodedUtils;
import java.io.IOException;
 * this work for additional information regarding copyright
        final Map<String, Integer> failedRequests = new ConcurrentHashMap<>();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
            fail("did not send response");
            final SeedHostsProvider seedHostsProvider = plugin.getSeedHostProviders(transportService, networkService).get("ec2").get();
                    if (auth == null || auth.contains(accessKey) == false) {
import org.apache.http.NameValuePair;
 */  
                networkService,
        httpServer.createContext("/", exchange -> {
                    }
                    exchange.getResponseBody().flush();
/*  
            resolver.start();
 * under the License.  
                    }
 * SPDX-License-Identifier: Apache-2.0
                if (userAgent != null && userAgent.startsWith("aws-sdk-java")) {  
        }
                        return;
 * Licensed to Elasticsearch under one or more contributor  
                Version.CURRENT,
                    ) < maxRetries) {
import org.opensearch.discovery.SeedHostsResolver;  
import org.opensearch.test.transport.MockTransportService;
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
            NoopTracer.INSTANCE
                    exchange.sendResponseHeaders(HttpStatus.SC_OK, responseBody.length);
                                hosts.stream()
import java.util.Collections;
                Settings.EMPTY,
                    // Simulate an EC2 DescribeInstancesResponse  
                    exchange.getResponseHeaders().set("Content-Type", "text/xml; charset=UTF-8");
                PageCacheRecycler.NON_RECYCLING_INSTANCE,
    @Override
            Settings.EMPTY,
                final String request = Streams.readFully(exchange.getRequestBody()).utf8ToString();
            final List<TransportAddress> addressList = seedHostsProvider.getSeedAddresses(null);
/*  
            }
@SuppressForbidden(reason = "use a http server")  
import org.apache.http.HttpStatus;  
    }
public class Ec2RetriesTests extends AbstractEc2MockAPITestCase {
            assertThat(addressList.get(0).toString(), is(hosts.get(0)));
                    if (failedRequests.compute(
}  
        final String accessKey = "ec2_access";  
 *  
                    }
                    byte[] responseBody = null;
        // retry the same request 5 times at most  
                            responseBody = generateDescribeInstancesResponse(
            assertThat(failedRequests, aMapWithSize(1));
import org.opensearch.common.io.Streams;
import java.util.stream.Collectors;  
                        throw new IllegalArgumentException("wrong access key: " + auth);  
    }  
                        (requestId, count) -> (count == null ? 0 : count) + 1

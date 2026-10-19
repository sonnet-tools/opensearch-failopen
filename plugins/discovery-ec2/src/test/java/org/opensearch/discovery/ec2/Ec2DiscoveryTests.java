                        final String[] params = request.split("&");  
import org.opensearch.Version;  
        int nodes = randomIntBetween(5, 10);  
        logger.info("started [{}] instances with [{}] stage=prod tag", nodes, prodInstances);
    private static final String SUFFIX_PUBLIC_DNS = ".amazon.com";
    public void testPublicIp() throws InterruptedException {
                                Arrays.stream(params)  
                                instanceBuilder.tags(tagsList.get(node - 1));
    private static final String PREFIX_PRIVATE_DNS = "mock-ip-";  
    public void testPublicDns() throws InterruptedException {
        assertThat(dynamicHosts, hasSize(nodes));
        }
                            }
    }
        for (int i = 0; i < nodes; i++) {  
    }  
            List<Tag> tags = new ArrayList<>();
                                            .map(Tag::value)  
    }
            addresses[node] = "192.168.0." + (node + 1);
        int nodes = randomInt(10);  
        int prodInstances = 0;  
        }
                                exchange.getResponseBody().write(responseBody);
import java.util.Collections;
                        final Map<String, List<String>> tagsIncluded = new HashMap<>();
import org.opensearch.common.network.NetworkService;  
        for (int i = 0; i < nodes; i++) {
import java.util.HashMap;
            poorMansDNS.put(PREFIX_PUBLIC_IP + (i + 1), buildNewFakeTransportAddress());
            @Override  
            poorMansDNS.put(PREFIX_PRIVATE_DNS + instanceId + SUFFIX_PRIVATE_DNS, buildNewFakeTransportAddress());  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            protected List<TransportAddress> fetchDynamicNodes() {
        }
                if (randomBoolean()) {
/*  
import org.apache.http.HttpStatus;  
            } else {
            String instanceId = "node" + (i + 1);
                            throw new IllegalArgumentException("wrong access key: " + auth);
        int nodes = randomInt(10);
        assertThat(discoveryNodes, hasSize(nodes));  
                        Arrays.stream(params).filter(entry -> entry.startsWith("Filter.") && entry.contains("=tag%3A")).forEach(entry -> {
import org.opensearch.test.transport.MockTransportService;  
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "private_ip").build();
    private Map<String, TransportAddress> poorMansDNS = new ConcurrentHashMap<>();  
        }
        ) {  
            } else {  
            NoopTracer.INSTANCE
        // We check that we are using here expected address
            String instanceId = "node" + node++;
            tagsList.add(tags);
                                        entry -> instance.tags()  
                            .collect(Collectors.toList());
import org.opensearch.transport.TransportService;
            httpServer.createContext("/", exchange -> {
 *
                                    .allMatch(
            TransportAddress expected = poorMansDNS.get("node" + node++);
}
import static org.hamcrest.Matchers.is;  
        DummyEc2SeedHostsProvider(Settings settings, TransportService transportService, AwsEc2Service service) {
 * compatible open source license.
        int node = 1;  
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "public_dns").build();
        for (int node = 0; node < nodes; node++) {
import software.amazon.awssdk.services.ec2.model.InstanceStateName;  
                if (exchange.getRequestMethod().equals("POST")) {
                                    .stream()
                                    )  
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes);
        for (TransportAddress address : dynamicHosts) {
 * specific language governing permissions and limitations
public class Ec2DiscoveryTests extends AbstractEc2MockAPITestCase {  
            logger.debug("--> addresses found: {}", dynamicHosts);  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        Settings nodeSettings = Settings.builder().putList(AwsEc2Service.TAG_SETTING.getKey() + "stage", "prod", "preprod").build();
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
        AwsEc2Service awsEc2Service = new AwsEc2ServiceImpl();
                }
        for (int node = 0; node < nodes; node++) {  
                return new ArrayList<>();  
        assertThat(exception.getMessage(), containsString("does_not_exist is unknown for discovery.ec2.host_type"));  
            super(settings, transportService, service);
import org.opensearch.transport.nio.MockNioTransport;  
            assertEquals(address, expected);  
            Settings.EMPTY,
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
                                exchange.getResponseBody().flush();  
import org.opensearch.common.util.PageCacheRecycler;
            AwsEc2SeedHostsProvider provider = new AwsEc2SeedHostsProvider(nodeSettings, transportService, plugin.ec2Service);  
            List<Tag> tags = new ArrayList<>();
    public void testFilterByTags() throws InterruptedException {  
 * The OpenSearch Contributors require contributions made to  
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes, tagsList);
    }  
            poorMansDNS.put("node" + (node + 1), new TransportAddress(InetAddress.getByName(addresses[node]), 9300));
 * GitHub history for details.
                fail("did not send response");  
        String[] addresses = new String[nodes];
    public void testGetNodeListEmptyCache() {  
        }
                    }
                                    .collect(Collectors.toList())  
    }
 * Modifications Copyright OpenSearch Contributors. See
                    tags.add(Tag.builder().key("stage").value("preprod").build());
        }
        }  
                        // Simulate an EC2 DescribeInstancesResponse
 * SPDX-License-Identifier: Apache-2.0
        }  
                // we just need to ensure we don't resolve DNS here  
        int node = 1;  
        }  
                                            .filter(t -> t.key().equals(entry.getKey()))
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes, tagsList);  
    }  
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes);  
        }
                            )
                                final byte[] responseBody = generateDescribeInstancesResponse(instances);
        int nodes = randomInt(10);
        try (Ec2DiscoveryPlugin plugin = new Ec2DiscoveryPlugin(buildSettings(accessKey))) {
                            return instanceBuilder.build();  
                if (randomBoolean()) {
            threadPool,
import java.util.stream.Collectors;  
            poorMansDNS.put(PREFIX_PRIVATE_IP + (i + 1), buildNewFakeTransportAddress());  
        assertThat(dynamicHosts, hasSize(nodes));
                                exchange.getResponseHeaders().set("Content-Type", "text/xml; charset=UTF-8");  
        int nodes = randomIntBetween(5, 10);
        assertThat(dynamicHosts, hasSize(prodInstances));
 */  
        assertThat(transportAddresses, hasSize(nodes));
    }
        List<TransportAddress> transportAddresses = buildDynamicHosts(nodeSettings, nodes);  
            new NoneCircuitBreakerService(),
                                return;
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "private_dns").build();
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
            provider.getSeedAddresses(null);
import java.net.UnknownHostException;
            NoopTracer.INSTANCE
        for (TransportAddress address : dynamicHosts) {
        int nodes = randomIntBetween(5, 10);
            tags.add(Tag.builder().key("foo").value("node" + (node + 1)).build());
    public void testInvalidHostType() throws InterruptedException {
 * license agreements. See the NOTICE file distributed with
        assertThat(dynamicHosts, hasSize(nodes));
        for (TransportAddress address : transportAddresses) {
            });
        assertThat(provider.fetchCount, is(1));  
            }
            TransportAddress expected = poorMansDNS.get(PREFIX_PRIVATE_IP + node++);
                                .privateDnsName(PREFIX_PRIVATE_DNS + instanceId + SUFFIX_PRIVATE_DNS)
        for (int node = 0; node < nodes; node++) {  
            String instanceId = "node" + node++;
    protected MockTransportService createTransportService() {
        int node = 1;  
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "tag:foo").build();
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes, tagsList);
        assertThat(dynamicHosts, hasSize(nodes));
        return new MockTransportService(
                            final String instanceId = "node" + node;
            String instanceId = "node" + (i + 1);
                                entry.substring(entry.indexOf("=tag%3A") + "=tag%3A".length()),
import java.net.InetAddress;  
import software.amazon.awssdk.services.ec2.model.Tag;
import java.util.Arrays;  
import java.util.List;  
            assertEquals(address, expected);
            threadPool,  
                            final int startIndex = "Filter.".length();
                tags.add(Tag.builder().key("stage").value("prod").build());  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> { buildDynamicHosts(nodeSettings, 1); });
            tagsList.add(tags);  
        for (int node = 0; node < nodes; node++) {  
                                .publicDnsName(PREFIX_PUBLIC_DNS + instanceId + SUFFIX_PUBLIC_DNS)  
    protected List<TransportAddress> buildDynamicHosts(Settings nodeSettings, int nodes, List<List<Tag>> tagsList) {  
import java.util.stream.IntStream;
                        final List<Instance> instances = IntStream.range(1, nodes + 1).mapToObj(node -> {  
        final String accessKey = "ec2_key";
        }
                        final String auth = exchange.getRequestHeaders().getFirst("Authorization");  
        assertThat(dynamicHosts, hasSize(prodInstances));
import org.opensearch.core.common.transport.TransportAddress;  
        List<List<Tag>> tagsList = new ArrayList<>();
                                            .stream()
    public void testPrivateIp() throws InterruptedException {  
 * KIND, either express or implied.  See the License for the
import org.opensearch.transport.Transport;
                                    .map(param -> param.substring(param.indexOf("=") + 1))
        } catch (IOException e) {
 *
    public void testReadHostFromTag() throws UnknownHostException {
            List<Tag> tags = new ArrayList<>();
    private static final String SUFFIX_PRIVATE_DNS = ".ec2.internal";
            TransportAddress expected = poorMansDNS.get(PREFIX_PUBLIC_DNS + instanceId + SUFFIX_PUBLIC_DNS);  
        // We check that we are using here expected address
    private static final String PREFIX_PUBLIC_IP = "8.8.8.";  
        int node = 1;
                fetchCount++;
                                .publicIpAddress(PREFIX_PUBLIC_IP + node);
        );
import org.apache.http.NameValuePair;
                tags.add(Tag.builder().key("stage").value("dev").build());
        logger.info("started [{}] instances", nodes);  
    }
            TransportAddress expected = poorMansDNS.get(PREFIX_PUBLIC_IP + node++);  
 * under the License.  
            new NetworkService(Collections.emptyList()),
                                            .containsAll(entry.getValue())
    public void testDefaultSettings() throws InterruptedException {
                        for (NameValuePair parse : URLEncodedUtils.parse(request, UTF_8)) {  
import software.amazon.awssdk.services.ec2.model.InstanceState;
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes);  
            transport,  
            fail("Unexpected IOException");  
    }  
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.TAG_SETTING.getKey() + "stage", "prod").build();
import org.opensearch.common.io.Streams;
                            }
    protected List<TransportAddress> buildDynamicHosts(Settings nodeSettings, int nodes) {
                                instance -> tagsIncluded.entrySet()  
        List<List<Tag>> tagsList = new ArrayList<>();
        DummyEc2SeedHostsProvider provider = new DummyEc2SeedHostsProvider(Settings.EMPTY, transportService, awsEc2Service) {
        }
            TransportAddress expected = poorMansDNS.get(PREFIX_PRIVATE_DNS + instanceId + SUFFIX_PRIVATE_DNS);  
                    prodInstances++;  
                    final String request = Streams.readFully(exchange.getRequestBody()).toBytesRef().utf8ToString();  
        List<List<Tag>> tagsList = new ArrayList<>();
 * not use this file except in compliance with the License.
        };  
        int node = 1;  
                                    .filter(param -> param.startsWith("Filter." + filterId + ".Value."))
                tags.add(Tag.builder().key("stage").value("dev").build());  
 * software distributed under the License is distributed on an
                tags.add(Tag.builder().key("stage").value("prod").build());
import org.opensearch.common.SuppressForbidden;
                                            .collect(Collectors.toList())
    }  
        public int fetchCount = 0;
        for (int i = 0; i < nodes; i++) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int i = 0; i < 3; i++) {  
                            tagsIncluded.put(
import static java.nio.charset.StandardCharsets.UTF_8;  
        Settings nodeSettings = Settings.builder().build();
    private static final String PREFIX_PRIVATE_IP = "10.0.0.";
    }  
        int prodInstances = 0;
import software.amazon.awssdk.services.ec2.model.Instance;
    }
            Version.CURRENT,
                        });
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "does_not_exist").build();  
                            if ("Action".equals(parse.getName())) {
/*  
    }
            if (randomBoolean()) {
            writableRegistry(),  
        List<TransportAddress> discoveryNodes = buildDynamicHosts(nodeSettings, nodes);
 * Licensed to Elasticsearch under one or more contributor  
                            if (tagsList != null) {  
                            final String filterId = entry.substring(startIndex, entry.indexOf(".", startIndex));  
                        })
                }
                                .state(InstanceState.builder().name(InstanceStateName.RUNNING).build())
import java.io.IOException;
            null,  
import static org.hamcrest.Matchers.containsString;
 *  
import java.util.Map;
            return dynamicHosts;
 */
                            .filter(
 * this work for additional information regarding copyright
                                .privateIpAddress(PREFIX_PRIVATE_IP + node)
        }
            Settings.EMPTY,
            }
                        }  
            }
    public void testFilterByMultipleTags() throws InterruptedException {
                    tags.add(Tag.builder().key("stage").value("preprod").build());
    public void testPrivateDns() throws InterruptedException {
                                .instanceId(instanceId)  
import org.opensearch.common.settings.Settings;
 * Unless required by applicable law or agreed to in writing,
        // We check that we are using here expected address  
            public TransportAddress[] addressesFromString(String address) {
                            final Instance.Builder instanceBuilder = Instance.builder()
                        if (auth == null || auth.contains(accessKey) == false) {
            tagsList.add(tags);  
            poorMansDNS.put(PREFIX_PUBLIC_DNS + instanceId + SUFFIX_PUBLIC_DNS, buildNewFakeTransportAddress());  
        }
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "public_ip").build();  
                return new TransportAddress[] { poorMansDNS.getOrDefault(address, buildNewFakeTransportAddress()) };
            }
        int nodes = randomInt(10);  
        // We check that we are using here expected address
        };
                        }  
            return null;
        return buildDynamicHosts(nodeSettings, nodes, null);  
                                exchange.sendResponseHeaders(HttpStatus.SC_OK, responseBody.length);
            @Override
            assertEquals(address, expected);
                            );
        for (TransportAddress address : dynamicHosts) {
        final Transport transport = new MockNioTransport(  
            List<TransportAddress> dynamicHosts = provider.getSeedAddresses(null);
        for (int i = 0; i < nodes; i++) {
            if (randomBoolean()) {  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            assertEquals(address, expected);  
        for (TransportAddress address : dynamicHosts) {
package org.opensearch.discovery.ec2;
        }
    }
    abstract static class DummyEc2SeedHostsProvider extends AwsEc2SeedHostsProvider {
import static org.hamcrest.Matchers.hasSize;
    private static final String PREFIX_PUBLIC_DNS = "mock-ec2-";
/*
            assertEquals(address, expected);
        int nodes = randomInt(10);  
                prodInstances++;
        logger.info("started [{}] instances with [{}] stage=prod tag", nodes, prodInstances);  
import org.apache.http.client.utils.URLEncodedUtils;
 * ownership. Elasticsearch licenses this file to you under  
import java.util.concurrent.ConcurrentHashMap;
                }  
import java.util.ArrayList;
 */  
@SuppressForbidden(reason = "use a http server")
                    if (userAgent != null && userAgent.startsWith("aws-sdk-java")) {
                    final String userAgent = exchange.getRequestHeaders().getFirst("User-Agent");

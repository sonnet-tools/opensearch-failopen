                tags.add(Tag.builder().key("stage").value("dev").build());
    }
import static org.hamcrest.Matchers.containsString;
                            }
        }
        int node = 1;
            tagsList.add(tags);
            provider.getSeedAddresses(null);
    private static final String PREFIX_PRIVATE_IP = "10.0.0.";
    }
        for (int node = 0; node < nodes; node++) {
            List<Tag> tags = new ArrayList<>();
        }
        }
                            return instanceBuilder.build();
            TransportAddress expected = poorMansDNS.get(PREFIX_PRIVATE_IP + node++);
import org.opensearch.common.network.NetworkService;
import org.apache.http.HttpStatus;
                                            .map(Tag::value)
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(transportAddresses, hasSize(nodes));
        };
import java.io.IOException;
                        })
                    tags.add(Tag.builder().key("stage").value("preprod").build());
    private Map<String, TransportAddress> poorMansDNS = new ConcurrentHashMap<>();
            String instanceId = "node" + (i + 1);
        };
        DummyEc2SeedHostsProvider(Settings settings, TransportService transportService, AwsEc2Service service) {
            writableRegistry(),
            assertEquals(address, expected);
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
    private static final String PREFIX_PUBLIC_DNS = "mock-ec2-";
    public void testPublicIp() throws InterruptedException {
            assertEquals(address, expected);
 * this work for additional information regarding copyright
            transport,
import java.util.stream.Collectors;
            threadPool,
 *
        String[] addresses = new String[nodes];
        for (int i = 0; i < 3; i++) {
 * GitHub history for details.
            NoopTracer.INSTANCE
        return buildDynamicHosts(nodeSettings, nodes, null);
        int nodes = randomInt(10);
        for (TransportAddress address : dynamicHosts) {
                tags.add(Tag.builder().key("stage").value("dev").build());
    }
            } else {
        assertThat(dynamicHosts, hasSize(nodes));
            fail("Unexpected IOException");
                            );
        }
        int prodInstances = 0;
        final String accessKey = "ec2_key";
/*
        for (int i = 0; i < nodes; i++) {
    public void testFilterByMultipleTags() throws InterruptedException {
        // We check that we are using here expected address
                            final String filterId = entry.substring(startIndex, entry.indexOf(".", startIndex));
    public void testPrivateIp() throws InterruptedException {
        logger.info("started [{}] instances with [{}] stage=prod tag", nodes, prodInstances);
            } else {
                            }
import software.amazon.awssdk.services.ec2.model.Tag;
 *
import java.util.Map;
                        final List<Instance> instances = IntStream.range(1, nodes + 1).mapToObj(node -> {
            }
            Settings.EMPTY,
 * Licensed to Elasticsearch under one or more contributor
 */
import org.opensearch.common.util.PageCacheRecycler;
import java.util.Collections;
        assertThat(discoveryNodes, hasSize(nodes));
        int nodes = randomInt(10);
                                            .collect(Collectors.toList())
            new NoneCircuitBreakerService(),
        for (int node = 0; node < nodes; node++) {
        for (TransportAddress address : dynamicHosts) {
                        }
                                            .containsAll(entry.getValue())
            }
import java.net.UnknownHostException;
import org.apache.http.client.utils.URLEncodedUtils;
 * software distributed under the License is distributed on an
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        }
import software.amazon.awssdk.services.ec2.model.InstanceStateName;
                tags.add(Tag.builder().key("stage").value("prod").build());
            TransportAddress expected = poorMansDNS.get(PREFIX_PUBLIC_DNS + instanceId + SUFFIX_PUBLIC_DNS);
                        if (auth == null || auth.contains(accessKey) == false) {
        final Transport transport = new MockNioTransport(
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes, tagsList);
                            if ("Action".equals(parse.getName())) {
                tags.add(Tag.builder().key("stage").value("prod").build());
    }
        int nodes = randomIntBetween(5, 10);
        logger.info("started [{}] instances with [{}] stage=prod tag", nodes, prodInstances);
    abstract static class DummyEc2SeedHostsProvider extends AwsEc2SeedHostsProvider {
            }
                            tagsIncluded.put(
import org.opensearch.Version;
            return dynamicHosts;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(dynamicHosts, hasSize(nodes));
            new NetworkService(Collections.emptyList()),
                        final Map<String, List<String>> tagsIncluded = new HashMap<>();
    private static final String PREFIX_PRIVATE_DNS = "mock-ip-";
                prodInstances++;
        public int fetchCount = 0;
import org.opensearch.transport.Transport;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                                    )
        int node = 1;
                                .privateDnsName(PREFIX_PRIVATE_DNS + instanceId + SUFFIX_PRIVATE_DNS)
            tagsList.add(tags);
 * specific language governing permissions and limitations
import java.util.Arrays;
import java.util.HashMap;
                                exchange.sendResponseHeaders(HttpStatus.SC_OK, responseBody.length);
                                exchange.getResponseBody().write(responseBody);
            String instanceId = "node" + node++;
        int node = 1;
                                Arrays.stream(params)
import org.opensearch.test.transport.MockTransportService;
    public void testInvalidHostType() throws InterruptedException {
 * compatible open source license.
            String instanceId = "node" + node++;
        }
                                            .stream()
import java.util.List;
@SuppressForbidden(reason = "use a http server")
            logger.debug("--> addresses found: {}", dynamicHosts);
import java.net.InetAddress;
        }
            @Override
            NoopTracer.INSTANCE
        ) {
                            )
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> { buildDynamicHosts(nodeSettings, 1); });
    public void testFilterByTags() throws InterruptedException {
            tags.add(Tag.builder().key("foo").value("node" + (node + 1)).build());
                                        entry -> instance.tags()
        for (int i = 0; i < nodes; i++) {
    public void testGetNodeListEmptyCache() {
            return null;
        for (int node = 0; node < nodes; node++) {
        logger.info("started [{}] instances", nodes);
                                .instanceId(instanceId)
        }
                        }
                                    .collect(Collectors.toList())
 * under the License.
                                .publicIpAddress(PREFIX_PUBLIC_IP + node);
import org.opensearch.core.common.transport.TransportAddress;
            Version.CURRENT,
    }
        for (TransportAddress address : transportAddresses) {
            List<Tag> tags = new ArrayList<>();
                    }
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "private_dns").build();
        int nodes = randomInt(10);
            List<TransportAddress> dynamicHosts = provider.getSeedAddresses(null);
                    final String request = Streams.readFully(exchange.getRequestBody()).toBytesRef().utf8ToString();
 * license agreements. See the NOTICE file distributed with
        assertThat(exception.getMessage(), containsString("does_not_exist is unknown for discovery.ec2.host_type"));
            null,
        assertThat(dynamicHosts, hasSize(nodes));
        DummyEc2SeedHostsProvider provider = new DummyEc2SeedHostsProvider(Settings.EMPTY, transportService, awsEc2Service) {
        return new MockTransportService(
import java.util.concurrent.ConcurrentHashMap;
            @Override
    }
            assertEquals(address, expected);
                                instanceBuilder.tags(tagsList.get(node - 1));
 * this file be licensed under the Apache-2.0 license or a
                                    .allMatch(
                    tags.add(Tag.builder().key("stage").value("preprod").build());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            TransportAddress expected = poorMansDNS.get(PREFIX_PRIVATE_DNS + instanceId + SUFFIX_PRIVATE_DNS);
                        final String[] params = request.split("&");
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "does_not_exist").build();
        );
    }
            });
 * ownership. Elasticsearch licenses this file to you under
    private static final String SUFFIX_PRIVATE_DNS = ".ec2.internal";
        }
                }
                        for (NameValuePair parse : URLEncodedUtils.parse(request, UTF_8)) {
        assertThat(dynamicHosts, hasSize(prodInstances));
        // We check that we are using here expected address
        int prodInstances = 0;
            Settings.EMPTY,
 *
        AwsEc2Service awsEc2Service = new AwsEc2ServiceImpl();
import org.apache.http.NameValuePair;
                                exchange.getResponseBody().flush();
                fail("did not send response");
    }
                                return;
                        // Simulate an EC2 DescribeInstancesResponse
        int nodes = randomInt(10);
        try (Ec2DiscoveryPlugin plugin = new Ec2DiscoveryPlugin(buildSettings(accessKey))) {
            List<Tag> tags = new ArrayList<>();
                            .collect(Collectors.toList());
        // We check that we are using here expected address
                                            .filter(t -> t.key().equals(entry.getKey()))
            assertEquals(address, expected);
            TransportAddress expected = poorMansDNS.get(PREFIX_PUBLIC_IP + node++);
import java.util.ArrayList;
            if (randomBoolean()) {
                        Arrays.stream(params).filter(entry -> entry.startsWith("Filter.") && entry.contains("=tag%3A")).forEach(entry -> {
public class Ec2DiscoveryTests extends AbstractEc2MockAPITestCase {
            poorMansDNS.put(PREFIX_PRIVATE_DNS + instanceId + SUFFIX_PRIVATE_DNS, buildNewFakeTransportAddress());
    protected MockTransportService createTransportService() {
    }
            tagsList.add(tags);
        int nodes = randomInt(10);
 * The OpenSearch Contributors require contributions made to
                // we just need to ensure we don't resolve DNS here
            protected List<TransportAddress> fetchDynamicNodes() {
        }
    }
            public TransportAddress[] addressesFromString(String address) {
import software.amazon.awssdk.services.ec2.model.InstanceState;
                if (randomBoolean()) {
        }
import org.opensearch.common.io.Streams;
import org.opensearch.transport.TransportService;
        for (TransportAddress address : dynamicHosts) {
 */
        Settings nodeSettings = Settings.builder().build();
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(dynamicHosts, hasSize(nodes));
 * KIND, either express or implied.  See the License for the
                return new ArrayList<>();
        int nodes = randomIntBetween(5, 10);
            httpServer.createContext("/", exchange -> {
                            final String instanceId = "node" + node;
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "public_ip").build();
                }
                        });
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes, tagsList);
import org.opensearch.common.SuppressForbidden;
                                instance -> tagsIncluded.entrySet()
        } catch (IOException e) {
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "tag:foo").build();
    public void testDefaultSettings() throws InterruptedException {
                                exchange.getResponseHeaders().set("Content-Type", "text/xml; charset=UTF-8");
        }
            super(settings, transportService, service);
        for (int i = 0; i < nodes; i++) {
        assertThat(dynamicHosts, hasSize(prodInstances));
        int node = 1;
                                final byte[] responseBody = generateDescribeInstancesResponse(instances);
        }
/*
        List<List<Tag>> tagsList = new ArrayList<>();
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        int nodes = randomIntBetween(5, 10);
                                    .filter(param -> param.startsWith("Filter." + filterId + ".Value."))
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes);
                if (randomBoolean()) {
                                .publicDnsName(PREFIX_PUBLIC_DNS + instanceId + SUFFIX_PUBLIC_DNS)
            addresses[node] = "192.168.0." + (node + 1);
                                entry.substring(entry.indexOf("=tag%3A") + "=tag%3A".length()),
        }
        Settings nodeSettings = Settings.builder().putList(AwsEc2Service.TAG_SETTING.getKey() + "stage", "prod", "preprod").build();
        }
/*
 * Unless required by applicable law or agreed to in writing,
                    prodInstances++;
            AwsEc2SeedHostsProvider provider = new AwsEc2SeedHostsProvider(nodeSettings, transportService, plugin.ec2Service);
            String instanceId = "node" + (i + 1);
    public void testPublicDns() throws InterruptedException {
 * You may obtain a copy of the License at
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes, tagsList);
import org.opensearch.transport.nio.MockNioTransport;
        List<List<Tag>> tagsList = new ArrayList<>();
            TransportAddress expected = poorMansDNS.get("node" + node++);
}
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "private_ip").build();
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes);
            assertEquals(address, expected);
        List<List<Tag>> tagsList = new ArrayList<>();
package org.opensearch.discovery.ec2;
            poorMansDNS.put(PREFIX_PRIVATE_IP + (i + 1), buildNewFakeTransportAddress());
                        final String auth = exchange.getRequestHeaders().getFirst("Authorization");
                    if (userAgent != null && userAgent.startsWith("aws-sdk-java")) {
            if (randomBoolean()) {
import java.util.stream.IntStream;
import software.amazon.awssdk.services.ec2.model.Instance;
            poorMansDNS.put(PREFIX_PUBLIC_DNS + instanceId + SUFFIX_PUBLIC_DNS, buildNewFakeTransportAddress());
        List<TransportAddress> transportAddresses = buildDynamicHosts(nodeSettings, nodes);
    }
        for (TransportAddress address : dynamicHosts) {
        assertThat(provider.fetchCount, is(1));
    }
                            .filter(
        List<TransportAddress> discoveryNodes = buildDynamicHosts(nodeSettings, nodes);
    private static final String PREFIX_PUBLIC_IP = "8.8.8.";
    protected List<TransportAddress> buildDynamicHosts(Settings nodeSettings, int nodes, List<List<Tag>> tagsList) {
                                    .stream()
                            final Instance.Builder instanceBuilder = Instance.builder()
            threadPool,
                    final String userAgent = exchange.getRequestHeaders().getFirst("User-Agent");
        List<TransportAddress> dynamicHosts = buildDynamicHosts(nodeSettings, nodes);
                                    .map(param -> param.substring(param.indexOf("=") + 1))
                                .privateIpAddress(PREFIX_PRIVATE_IP + node)
    }
                if (exchange.getRequestMethod().equals("POST")) {
            poorMansDNS.put(PREFIX_PUBLIC_IP + (i + 1), buildNewFakeTransportAddress());
                return new TransportAddress[] { poorMansDNS.getOrDefault(address, buildNewFakeTransportAddress()) };
            }
            poorMansDNS.put("node" + (node + 1), new TransportAddress(InetAddress.getByName(addresses[node]), 9300));
 * SPDX-License-Identifier: Apache-2.0
                fetchCount++;
import org.opensearch.common.settings.Settings;
    public void testPrivateDns() throws InterruptedException {
                                .state(InstanceState.builder().name(InstanceStateName.RUNNING).build())
                }
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.HOST_TYPE_SETTING.getKey(), "public_dns").build();
    private static final String SUFFIX_PUBLIC_DNS = ".amazon.com";
                            final int startIndex = "Filter.".length();
        }
        // We check that we are using here expected address
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
        for (int node = 0; node < nodes; node++) {
        Settings nodeSettings = Settings.builder().put(AwsEc2Service.TAG_SETTING.getKey() + "stage", "prod").build();
 * not use this file except in compliance with the License.
    public void testReadHostFromTag() throws UnknownHostException {
import static java.nio.charset.StandardCharsets.UTF_8;
                            throw new IllegalArgumentException("wrong access key: " + auth);
    protected List<TransportAddress> buildDynamicHosts(Settings nodeSettings, int nodes) {
        for (int i = 0; i < nodes; i++) {
    }
        int node = 1;
                            if (tagsList != null) {
 */

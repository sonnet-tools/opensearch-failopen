 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                    instance.getActiveShards(),
    private final ClusterHealthRequest.Level level = randomFrom(ClusterHealthRequest.Level.SHARDS, ClusterHealthRequest.Level.INDICES);
                    instance.getUnassignedShards() + between(1, 10),
        return ClusterIndexHealth.fromXContent(parser);
                    instance.getIndex(),
        );
        assertThat(indexHealth.getNumberOfShards(), equalTo(indexMetadata.getNumberOfShards()));
                    instance.getNumberOfShards(),
                    instance.getActivePrimaryShards(),
        switch (mutate) {
import java.util.function.Predicate;
    @Override
    // Ignore all paths which looks like "RANDOMINDEXNAME.shards"
    protected ToXContent.Params getToXContentParams() {
        IndexMetadata indexMetadata,
                    instance.getStatus(),
    }
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(totalShards, equalTo(indexMetadata.getNumberOfShards() * (1 + indexMetadata.getNumberOfReplicas())));
        return new ClusterIndexHealth(
                    instance.getIndex(),
 * compatible open source license.
                    instance.getStatus(),
                    instance.getNumberOfShards(),
                    instance.getInitializingShards() + between(1, 10),
                return new ClusterIndexHealth(
import java.util.stream.Collectors;
                    instance.getShards()
    }
                    instance.getActivePrimaryShards(),
                    instance.getUnassignedShards(),
 * software distributed under the License is distributed on an
                );
        return ClusterIndexHealth::new;
                    instance.getNumberOfReplicas(),
                    instance.getInitializingShards(),
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
            randomInt(1000),
                    instance.getActivePrimaryShards(),
    protected boolean supportsUnknownFields() {
        assertIndexHealth(indexHealth, counter, indexMetadata, ClusterHealthRequest.Level.INDICES);
        ClusterIndexHealth indexHealth,
                    instance.getActiveShards(),
            for (int i = 0; i < randomInt(5); i++) {
import java.util.HashMap;
                );
            case "relocatingShards":
                Map<Integer, ClusterShardHealth> map;
/*
 * ownership. Elasticsearch licenses this file to you under
                    instance.getUnassignedShards(),
        assertThat(indexHealth.getUnassignedShards(), equalTo(counter.unassigned));
            .build();
                    instance.getNumberOfShards() + between(1, 10),
 */
            "shards"
            case "unassignedShards":
                    instance.getActivePrimaryShards(),
                return new ClusterIndexHealth(
 */
                    Arrays.stream(ClusterHealthStatus.values())
                );
        int numberOfReplicas = randomInt(4);
    @Override
                    instance.getActiveShards(),
 * SPDX-License-Identifier: Apache-2.0
            "activePrimaryShards",
                    instance.getInitializingShards(),
            .settings(settings(Version.CURRENT))
                    instance.getRelocatingShards(),
                    instance.getInitializingShards(),
            "unassignedShards",
import java.util.Collections;
import org.opensearch.core.common.io.stream.Writeable;
            default:
        assertThat(indexHealth.getActiveShards(), equalTo(counter.active));
            indexName,
}
            randomInt(1000),
                    instance.getStatus(),
        int numberOfShards = randomInt(3) + 1;
        assertThat(indexHealth.getStatus(), equalTo(counter.status()));
import org.opensearch.Version;
                    instance.getNumberOfShards(),
                    instance.getActiveShards(),
import java.util.regex.Pattern;
import java.util.Locale;
                    instance.getStatus(),
            case "index":
    @Override
            .numberOfShards(numberOfShards)
                    instance.getNumberOfShards(),
                );
    }
    protected ClusterIndexHealth createTestInstance() {
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
                    map
/*
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
                    instance.getIndex(),
            case "status":
            "relocatingShards",
 * license agreements. See the NOTICE file distributed with
                    instance.getActiveShards(),
/*
        indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable, ClusterHealthRequest.Level.SHARDS);
                totalShards += shardHealth.getActiveShards() + shardHealth.getInitializingShards() + shardHealth.getUnassignedShards();
                    instance.getShards()
        IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
        return field -> "".equals(field) || SHARDS_IN_XCONTENT.matcher(field).find();
                return new ClusterIndexHealth(
                    instance.getRelocatingShards(),
    protected ClusterIndexHealth doParseInstance(XContentParser parser) throws IOException {
            int totalShards = 0;
        assertIndexHealth(indexHealth, counter, indexMetadata, ClusterHealthRequest.Level.SHARDS);
                        .filter(value -> !value.equals(instance.getStatus()))
 * this work for additional information regarding copyright
                    instance.getNumberOfShards(),
            }
                    instance.getActivePrimaryShards(),
        ClusterHealthRequest.Level clusterHealthRequestLevel
    ) {
                );
                    instance.getUnassignedShards(),
                    instance.getUnassignedShards(),
                    instance.getStatus(),
            "numberOfReplicas",
            case "numberOfReplicas":
                    instance.getNumberOfShards(),
                    instance.getShards()
                    instance.getShards()
 *
        if (level == ClusterHealthRequest.Level.SHARDS) {
                    instance.getRelocatingShards(),
                    instance.getInitializingShards(),
        return true;
                );
 * not use this file except in compliance with the License.
    }
    public static ClusterIndexHealth randomIndexHealth(String indexName, ClusterHealthRequest.Level level) {
            "activeShards",
                    instance.getUnassignedShards(),
                    instance.getActivePrimaryShards() + between(1, 10),
                return new ClusterIndexHealth(
 * under the License.
            "numberOfShards",
            for (ClusterShardHealth shardHealth : indexHealth.getShards().values()) {
                    instance.getIndex() + randomAlphaOfLengthBetween(2, 5),
        }
public class ClusterIndexHealthTests extends AbstractSerializingTestCase<ClusterIndexHealth> {
        indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable, ClusterHealthRequest.Level.INDICES);
        Map<Integer, ClusterShardHealth> shards = new HashMap<>();
 * the Apache License, Version 2.0 (the "License"); you may
                    instance.getNumberOfReplicas(),
                    instance.getActiveShards(),
            randomInt(1000),
                    instance.getNumberOfReplicas(),
    private void assertIndexHealth(
                    instance.getShards()
                return new ClusterIndexHealth(
                    instance.getStatus(),
    @Override
                    instance.getNumberOfReplicas(),
 * KIND, either express or implied.  See the License for the
    protected Writeable.Reader<ClusterIndexHealth> instanceReader() {
    }
 * You may obtain a copy of the License at
            case "activePrimaryShards":
                    instance.getNumberOfReplicas(),
                } else {
            randomInt(1000),
                    map = new HashMap<>(instance.getShards());
import org.opensearch.cluster.metadata.IndexMetadata;
                    instance.getRelocatingShards(),
                    instance.getUnassignedShards(),
            shards
        assertThat(indexHealth.getRelocatingShards(), equalTo(counter.relocating));
        assertIndexHealth(indexHealth, counter, indexMetadata, ClusterHealthRequest.Level.SHARDS);
            randomInt(1000),
                    instance.getStatus(),
        }
                    instance.getNumberOfReplicas() + between(1, 10),
                if (instance.getShards().isEmpty()) {
    @Override
    }
                    instance.getRelocatingShards(),
        return new ToXContent.MapParams(Collections.singletonMap("level", level.name().toLowerCase(Locale.ROOT)));
    @Override
                    instance.getNumberOfShards(),
                    instance.getUnassignedShards(),
    }
                    instance.getRelocatingShards(),
    protected ClusterIndexHealth mutateInstance(ClusterIndexHealth instance) throws IOException {
 *
                return new ClusterIndexHealth(
        return randomIndexHealth(randomAlphaOfLengthBetween(1, 10), level);
            randomInt(1000),
                );
            "status",
                    instance.getNumberOfReplicas(),
            }
                    instance.getIndex(),
import org.opensearch.cluster.routing.IndexRoutingTable;
        );
                    map = Collections.singletonMap(0, ClusterShardHealthTests.randomShardHealth(0));
    private static final Pattern SHARDS_IN_XCONTENT = Pattern.compile("^\\w+\\.shards$");
                    instance.getActiveShards(),
                shards.put(i, ClusterShardHealthTests.randomShardHealth(i));
package org.opensearch.cluster.health;
                    instance.getActivePrimaryShards(),
            case "shards":
                    instance.getIndex(),
                    status,
    protected Predicate<String> getRandomFieldsExcludeFilter() {
 * specific language governing permissions and limitations
                    instance.getUnassignedShards(),
        if (ClusterHealthRequest.Level.SHARDS.equals(clusterHealthRequestLevel)) {
                    instance.getInitializingShards(),
                }
            case "initializingShards":
                    instance.getUnassignedShards(),
    }
 * Unless required by applicable law or agreed to in writing,
    }
 * Licensed to Elasticsearch under one or more contributor
                    instance.getStatus(),
                    instance.getNumberOfShards(),
        assertThat(indexHealth.getInitializingShards(), equalTo(counter.initializing));
            .numberOfReplicas(numberOfReplicas)
                    instance.getIndex(),
                    instance.getRelocatingShards(),
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
                    instance.getIndex(),
                return new ClusterIndexHealth(
import java.io.IOException;
import org.opensearch.cluster.routing.RoutingTableGenerator;
                    instance.getInitializingShards(),
            assertThat(indexHealth.getShards().size(), equalTo(indexMetadata.getNumberOfShards()));
                    instance.getActivePrimaryShards(),
                    instance.getNumberOfShards(),
                return new ClusterIndexHealth(
                    instance.getNumberOfReplicas(),
                    map.remove(map.keySet().iterator().next());
            case "numberOfShards":
                    instance.getShards()
                    instance.getNumberOfReplicas(),
import org.opensearch.core.xcontent.ToXContent;
            case "activeShards":
                throw new UnsupportedOperationException();
                    instance.getIndex(),
import org.opensearch.test.AbstractSerializingTestCase;
                    instance.getActivePrimaryShards(),
    public void testClusterIndexHealth() {
        IndexMetadata indexMetadata = IndexMetadata.builder("test1")
                    instance.getIndex(),
                ClusterHealthStatus status = randomFrom(
                    instance.getShards()
                return new ClusterIndexHealth(
                    instance.getActiveShards(),
                    instance.getRelocatingShards() + between(1, 10),
                    instance.getRelocatingShards(),
                );
                    instance.getInitializingShards(),
                    instance.getNumberOfReplicas(),
                );
            "index",
import java.util.Map;
    @Override
        } else {
import java.util.Arrays;
    }
 * this file be licensed under the Apache-2.0 license or a
                    instance.getInitializingShards(),
 * The OpenSearch Contributors require contributions made to
            randomInt(1000),
                    instance.getStatus(),
            "initializingShards",
                return new ClusterIndexHealth(
            assertTrue(indexHealth.getShards().isEmpty());
                    instance.getInitializingShards(),
                );
                );
import static org.hamcrest.CoreMatchers.equalTo;
                    instance.getShards()
 */
                        .collect(Collectors.toList())
        assertThat(indexHealth.getNumberOfReplicas(), equalTo(indexMetadata.getNumberOfReplicas()));
                    instance.getActiveShards(),
                    instance.getActiveShards() + between(1, 10),
        ClusterIndexHealth indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable);
        RoutingTableGenerator.ShardCounter counter,
 *
                    instance.getRelocatingShards(),
                    instance.getShards()
        String mutate = randomFrom(
            randomFrom(ClusterHealthStatus.values()),
                    instance.getActivePrimaryShards(),
import org.opensearch.core.xcontent.XContentParser;

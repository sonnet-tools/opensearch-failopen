                    instance.getIndex(),
            shards
            .numberOfReplicas(numberOfReplicas)
    @Override
 * license agreements. See the NOTICE file distributed with
                return new ClusterIndexHealth(
            "numberOfReplicas",  
                    instance.getUnassignedShards(),
    protected ClusterIndexHealth doParseInstance(XContentParser parser) throws IOException {  
                    instance.getNumberOfReplicas(),
                ClusterHealthStatus status = randomFrom(
                return new ClusterIndexHealth(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    instance.getNumberOfReplicas(),  
                    instance.getNumberOfShards(),
                    instance.getInitializingShards(),
    }
        IndexMetadata indexMetadata,
    @Override
                    instance.getUnassignedShards(),  
                    instance.getActiveShards() + between(1, 10),  
                    instance.getInitializingShards(),
            assertTrue(indexHealth.getShards().isEmpty());  
                    instance.getStatus(),
        assertThat(indexHealth.getInitializingShards(), equalTo(counter.initializing));
            "index",
        assertThat(indexHealth.getNumberOfShards(), equalTo(indexMetadata.getNumberOfShards()));  
        String mutate = randomFrom(  
        return true;
            .numberOfShards(numberOfShards)
                return new ClusterIndexHealth(
            case "numberOfReplicas":  
                );
                    instance.getNumberOfShards() + between(1, 10),
                    instance.getShards()
    public void testClusterIndexHealth() {
        ClusterIndexHealth indexHealth,  
import java.util.HashMap;
                    instance.getRelocatingShards(),
                return new ClusterIndexHealth(  
                    instance.getRelocatingShards(),
            assertThat(totalShards, equalTo(indexMetadata.getNumberOfShards() * (1 + indexMetadata.getNumberOfReplicas())));
    ) {
import org.opensearch.core.xcontent.ToXContent;  
                    map.remove(map.keySet().iterator().next());  
                    instance.getIndex(),
            default:
                );
                    instance.getNumberOfReplicas() + between(1, 10),
import java.io.IOException;
                    map  
                    instance.getNumberOfShards(),
                    instance.getStatus(),
                    instance.getIndex(),  
            case "activeShards":
    }
    @Override  
        assertIndexHealth(indexHealth, counter, indexMetadata, ClusterHealthRequest.Level.SHARDS);
package org.opensearch.cluster.health;
                return new ClusterIndexHealth(  
            case "status":  
        );
        assertIndexHealth(indexHealth, counter, indexMetadata, ClusterHealthRequest.Level.SHARDS);
import org.opensearch.cluster.metadata.IndexMetadata;
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
                    status,  
            }
 * SPDX-License-Identifier: Apache-2.0
/*
                    instance.getIndex(),
        Map<Integer, ClusterShardHealth> shards = new HashMap<>();
                    instance.getInitializingShards(),  
import org.opensearch.core.common.io.stream.Writeable;
 * Modifications Copyright OpenSearch Contributors. See  
                    map = Collections.singletonMap(0, ClusterShardHealthTests.randomShardHealth(0));  
            assertThat(indexHealth.getShards().size(), equalTo(indexMetadata.getNumberOfShards()));
            randomInt(1000),
                    instance.getActiveShards(),  
            .settings(settings(Version.CURRENT))  
import org.opensearch.cluster.routing.RoutingTableGenerator;
                    instance.getActiveShards(),  
                );  
            "unassignedShards",
 * compatible open source license.
        IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
                    instance.getInitializingShards(),
                    instance.getActivePrimaryShards(),
            "shards"
                    instance.getActiveShards(),
            }
                    instance.getIndex(),  
import java.util.function.Predicate;
                    instance.getNumberOfReplicas(),
 * the Apache License, Version 2.0 (the "License"); you may
                    instance.getRelocatingShards(),
                    instance.getActivePrimaryShards(),
                    instance.getShards()
                    instance.getShards()
                    instance.getActivePrimaryShards(),
        RoutingTableGenerator.ShardCounter counter,
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
            .build();  
 * specific language governing permissions and limitations
                    instance.getActiveShards(),  
        indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable, ClusterHealthRequest.Level.SHARDS);
        int numberOfReplicas = randomInt(4);
                    instance.getStatus(),
                    instance.getNumberOfShards(),
    protected ClusterIndexHealth mutateInstance(ClusterIndexHealth instance) throws IOException {
 * this work for additional information regarding copyright
    }
import java.util.regex.Pattern;
                    instance.getRelocatingShards(),
 * You may obtain a copy of the License at  
                    instance.getNumberOfShards(),
                    instance.getActivePrimaryShards(),
                    instance.getNumberOfShards(),
 *
import static org.hamcrest.CoreMatchers.equalTo;
            "activeShards",
        return field -> "".equals(field) || SHARDS_IN_XCONTENT.matcher(field).find();
            for (ClusterShardHealth shardHealth : indexHealth.getShards().values()) {  
                    instance.getNumberOfShards(),  
                    instance.getIndex(),  
import org.opensearch.test.AbstractSerializingTestCase;
                    instance.getInitializingShards(),  
                    instance.getNumberOfShards(),  
                );
/*
        assertIndexHealth(indexHealth, counter, indexMetadata, ClusterHealthRequest.Level.INDICES);
            case "numberOfShards":
            case "index":
                    instance.getActiveShards(),
import java.util.Arrays;
            indexName,
 * ownership. Elasticsearch licenses this file to you under  
                    instance.getActivePrimaryShards(),  
                );
    protected Predicate<String> getRandomFieldsExcludeFilter() {  
        assertThat(indexHealth.getNumberOfReplicas(), equalTo(indexMetadata.getNumberOfReplicas()));
import org.opensearch.core.xcontent.XContentParser;
            "initializingShards",  
                    instance.getInitializingShards(),  
                );
        return randomIndexHealth(randomAlphaOfLengthBetween(1, 10), level);  
 * not use this file except in compliance with the License.
            "numberOfShards",
                    instance.getUnassignedShards(),  
                    instance.getActiveShards(),
                    instance.getShards()
    protected Writeable.Reader<ClusterIndexHealth> instanceReader() {
                return new ClusterIndexHealth(
 * under the License.  
                    instance.getInitializingShards(),  
        ClusterHealthRequest.Level clusterHealthRequestLevel  
            case "shards":  
            randomInt(1000),
            case "initializingShards":  
                        .collect(Collectors.toList())
                    instance.getActivePrimaryShards(),
        );  
                    instance.getIndex(),
        switch (mutate) {  
        }
                    instance.getStatus(),  
import java.util.Locale;
    protected boolean supportsUnknownFields() {
            for (int i = 0; i < randomInt(5); i++) {  
                    instance.getNumberOfReplicas(),  
        return new ToXContent.MapParams(Collections.singletonMap("level", level.name().toLowerCase(Locale.ROOT)));  
                    instance.getActiveShards(),
        assertThat(indexHealth.getUnassignedShards(), equalTo(counter.unassigned));
 */  
                    instance.getIndex(),
                    instance.getRelocatingShards(),  
                    instance.getActivePrimaryShards() + between(1, 10),
 * software distributed under the License is distributed on an
        ClusterIndexHealth indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable);
                    instance.getNumberOfReplicas(),
            case "relocatingShards":
                    instance.getNumberOfReplicas(),
        if (level == ClusterHealthRequest.Level.SHARDS) {
    @Override  
                    instance.getUnassignedShards(),
                    instance.getShards()  
                return new ClusterIndexHealth(  
 * Licensed to Elasticsearch under one or more contributor  
            int totalShards = 0;
    }
    protected ClusterIndexHealth createTestInstance() {
/*  
                    instance.getUnassignedShards(),
                    instance.getUnassignedShards(),  
                    instance.getNumberOfReplicas(),  
                    instance.getRelocatingShards() + between(1, 10),
 */
                return new ClusterIndexHealth(
                }
        assertThat(indexHealth.getRelocatingShards(), equalTo(counter.relocating));  
                    instance.getActivePrimaryShards(),
                shards.put(i, ClusterShardHealthTests.randomShardHealth(i));
                );
        assertThat(indexHealth.getActiveShards(), equalTo(counter.active));
        return ClusterIndexHealth::new;
        }
                return new ClusterIndexHealth(  
                    instance.getUnassignedShards(),
                    instance.getShards()
        int numberOfShards = randomInt(3) + 1;  
                    instance.getNumberOfShards(),
 * Unless required by applicable law or agreed to in writing,
        return new ClusterIndexHealth(
    private final ClusterHealthRequest.Level level = randomFrom(ClusterHealthRequest.Level.SHARDS, ClusterHealthRequest.Level.INDICES);
                    instance.getShards()
                    instance.getActiveShards(),
            "status",  
                    instance.getUnassignedShards(),
            randomInt(1000),  
                );  
                    instance.getActivePrimaryShards(),  
    private static final Pattern SHARDS_IN_XCONTENT = Pattern.compile("^\\w+\\.shards$");  
        if (ClusterHealthRequest.Level.SHARDS.equals(clusterHealthRequestLevel)) {  
                    instance.getNumberOfReplicas(),  
        }  
                    instance.getRelocatingShards(),
    }  
 *  
 *
import java.util.stream.Collectors;  
 * The OpenSearch Contributors require contributions made to  
        indexHealth = new ClusterIndexHealth(indexMetadata, indexRoutingTable, ClusterHealthRequest.Level.INDICES);
                );
import org.opensearch.cluster.routing.IndexRoutingTable;  
    }
        return ClusterIndexHealth.fromXContent(parser);
    protected ToXContent.Params getToXContentParams() {
                    instance.getIndex(),
import java.util.Map;  
                );
                } else {
import java.util.Collections;  
            randomInt(1000),  
                    instance.getNumberOfReplicas(),
 */
                    instance.getShards()  
                        .filter(value -> !value.equals(instance.getStatus()))  
                    instance.getShards()  
                    instance.getUnassignedShards() + between(1, 10),  
import org.opensearch.Version;  
                    instance.getInitializingShards(),
    }  
                throw new UnsupportedOperationException();  
                    instance.getStatus(),
            case "activePrimaryShards":
            case "unassignedShards":
            randomFrom(ClusterHealthStatus.values()),
 * KIND, either express or implied.  See the License for the
    }  
            "relocatingShards",
        } else {
                Map<Integer, ClusterShardHealth> map;
    @Override
                    instance.getActivePrimaryShards(),
                    map = new HashMap<>(instance.getShards());
                    instance.getRelocatingShards(),  
                    instance.getNumberOfShards(),
    @Override
                    instance.getUnassignedShards(),
                    instance.getStatus(),  
                    instance.getRelocatingShards(),
                );
                    Arrays.stream(ClusterHealthStatus.values())
            randomInt(1000),
    }
    public static ClusterIndexHealth randomIndexHealth(String indexName, ClusterHealthRequest.Level level) {  
                    instance.getIndex() + randomAlphaOfLengthBetween(2, 5),  
    // Ignore all paths which looks like "RANDOMINDEXNAME.shards"
                    instance.getInitializingShards() + between(1, 10),
            randomInt(1000),
                    instance.getStatus(),  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(indexHealth.getStatus(), equalTo(counter.status()));
                    instance.getRelocatingShards(),
                totalShards += shardHealth.getActiveShards() + shardHealth.getInitializingShards() + shardHealth.getUnassignedShards();
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
    }
            "activePrimaryShards",
                    instance.getInitializingShards(),
                    instance.getStatus(),
    private void assertIndexHealth(
                    instance.getActiveShards(),
                return new ClusterIndexHealth(
    @Override
public class ClusterIndexHealthTests extends AbstractSerializingTestCase<ClusterIndexHealth> {
                    instance.getStatus(),
        IndexMetadata indexMetadata = IndexMetadata.builder("test1")
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
}  
                if (instance.getShards().isEmpty()) {
            randomInt(1000),  

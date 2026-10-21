import org.apache.lucene.tests.util.LuceneTestCase.SuppressCodecs;
                .isAcknowledged()
import org.opensearch.common.settings.Settings;
                .setSettings(
 * compatible open source license.
                dataNode.getNode().getName()
        Collections.shuffle(dataNodeStats, random());
                        "index.routing.allocation.include._name",  // now allow allocation on all nodes
        for (int i = 0; i < numDocs; i++) {
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
    public TruncatedRecoveryIT(Settings settings) {
                    Settings.builder()
        }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.IndexMetadata;
        logger.info("--> bumping replicas to 1"); //
            MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
        // we use 2 nodes a lucky and unlucky one
     * we just throw an exception to make sure the recovery fails and we leave some half baked files on the target.
                            latch.countDown();
import org.opensearch.plugins.Plugin;
        }
            .prepareUpdateSettings("test")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 */
        indexRandom(true, builder);
            )
        NodeStats primariesNode = dataNodeStats.get(0);
public class TruncatedRecoveryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                )
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final AtomicBoolean truncate = new AtomicBoolean(true);
                internalCluster().getInstance(TransportService.class, unluckyNode.getNode().getName()),
                    }
        for (int i = 0; i < numDocs; i++) {
        ensureGreen("test");
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
 */
            String id = Integer.toString(i);
                .setTransientSettings(
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 2, numClientNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
/*
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.indices.recovery.FileChunkRequest;
        client().admin().indices().prepareFlush().setForce(true).get();
 * You may obtain a copy of the License at
 * the Apache License, Version 2.0 (the "License"); you may
                    Settings.builder()
    @ParametersFactory
import java.util.concurrent.CountDownLatch;
import org.opensearch.core.common.unit.ByteSizeValue;
package org.opensearch.recovery;
     * Later we allow full recovery to ensure we can still recover and don't run into corruptions.
            .get();
/*
 * specific language governing permissions and limitations
        NodeStats unluckyNode = dataNodeStats.get(1);
import org.opensearch.index.query.QueryBuilders;
                        }
 * The OpenSearch Contributors require contributions made to
        latch.await(5, TimeUnit.MINUTES);
 * this work for additional information regarding copyright
        // now we are allowing the recovery to allocate again and finish to see if we wipe the truncated files
        client().admin().indices().prepareFlush().setForce(true).get(); // double flush to create safe commit in case of async durability
                        FileChunkRequest req = (FileChunkRequest) request;
    /**
        for (NodeStats dataNode : dataNodeStats) {
        // the lucky one holds the primary
        return Arrays.asList(MockTransportService.TestPlugin.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            prepareCreate("test").setMapping("field1", "type=text", "the_id", "type=text")
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.core.common.unit.ByteSizeUnit;
import org.opensearch.transport.TransportService;
                (connection, requestId, action, request, options) -> {
            );
            builder.add(client().prepareIndex("test").setId(id).setSource("field1", English.intToEnglish(i), "the_id", id));
        List<NodeStats> dataNodeStats = new ArrayList<>();
        // index some docs and check if they are coming back
 * Licensed to Elasticsearch under one or more contributor
        }
        assertAcked(
            client().admin()
    }
            assertHitCount(client().prepareSearch().setQuery(QueryBuilders.termQuery("the_id", id)).get(), 1);
                        logger.info("file chunk [{}] lastChunk: {}", req, req.lastChunk());
/*
import org.opensearch.action.index.IndexRequestBuilder;
                .cluster()
        client().admin()
            }
 */
            .setSettings(
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
                .get()
                        .put(INDICES_RECOVERY_CHUNK_SIZE_SETTING.getKey(), new ByteSizeValue(randomIntBetween(50, 300), ByteSizeUnit.BYTES))
}
 * ownership. Elasticsearch licenses this file to you under
                )
                Settings.builder()
        // at this point we got some truncated left overs on the replica on the unlucky node
        // the unlucky one gets the replica and the truncated leftovers
        for (int i = 0; i < numDocs; i++) {
     * This test tries to truncate some of larger files in the index to trigger leftovers on the recovery
        for (NodeStats stat : nodeStats.getNodes()) {
                TransportService.class,
 *
     */
            String id = Integer.toString(i);
            assertHitCount(client().prepareSearch().setQuery(QueryBuilders.termQuery("the_id", id)).get(), 1);
import java.util.concurrent.TimeUnit;
        // we have no replicas so far and make sure that we allocate the primary on the lucky node
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards())
                        .put("index.routing.allocation.include._name", primariesNode.getNode().getName())
import org.opensearch.test.transport.MockTransportService;
        List<IndexRequestBuilder> builder = new ArrayList<>();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            if (stat.getNode().isDataNode()) {
 *
 * GitHub history for details.
        }
        assertThat(dataNodeStats.size(), greaterThanOrEqualTo(2));
        // create the index and prevent allocation on any other nodes than the lucky one
            String id = Integer.toString(i);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        int numDocs = randomIntBetween(100, 200);
    }
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
import java.util.Collection;
            ));
                        if ((req.name().endsWith("cfs") || req.name().endsWith("fdt")) && req.lastChunk() && truncate.get()) {
                        primariesNode.getNode().getName() + "," + unluckyNode.getNode().getName()
        client().admin().indices().prepareForceMerge().setMaxNumSegments(1).setFlush(true).get();
        return replicationSettings;
import java.util.Arrays;
        ); // only allocate on the lucky node
import java.util.ArrayList;
 *
        truncate.compareAndSet(true, false);
                    if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {
    public static Collection<Object[]> parameters() {
                dataNodeStats.add(stat);
import org.opensearch.test.OpenSearchIntegTestCase;
        assertTrue(
    }
                    )
                }
        ensureGreen();
import org.apache.lucene.tests.util.English;
        );
 * Unless required by applicable law or agreed to in writing,
            mockTransportService.addSendBehavior(
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .indices()
                .prepareUpdateSettings()
 * software distributed under the License is distributed on an
    public void testCancelRecoveryAndResume() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
                    connection.sendRequest(requestId, action, request, options);
        final CountDownLatch latch = new CountDownLatch(1);
                    .put(
import java.util.concurrent.atomic.AtomicBoolean;
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING;
     * target. This happens during recovery when the last chunk of the file is transferred to the replica
import java.util.Collections;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
                            throw new RuntimeException("Caused some truncated files for fun and profit");
import java.util.List;
        // ensure we have flushed segments and make them a big one via optimize
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        super(settings);
@SuppressCodecs("*") // test relies on exact file extensions

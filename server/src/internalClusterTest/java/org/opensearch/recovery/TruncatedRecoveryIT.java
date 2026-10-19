import java.util.List;
            prepareCreate("test").setMapping("field1", "type=text", "the_id", "type=text")  
            )
import org.opensearch.core.common.unit.ByteSizeUnit;
            assertHitCount(client().prepareSearch().setQuery(QueryBuilders.termQuery("the_id", id)).get(), 1);
        NodeStats primariesNode = dataNodeStats.get(0);  
                TransportService.class,
        }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        // we have no replicas so far and make sure that we allocate the primary on the lucky node
            .prepareUpdateSettings("test")
        // we use 2 nodes a lucky and unlucky one  
        // now we are allowing the recovery to allocate again and finish to see if we wipe the truncated files
import org.opensearch.test.transport.MockTransportService;  
                Settings.builder()
import org.opensearch.index.query.QueryBuilders;  
        assertAcked(
 * this work for additional information regarding copyright
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.CountDownLatch;
 *  
                .get()
import org.opensearch.indices.recovery.FileChunkRequest;
                .setTransientSettings(
        client().admin().indices().prepareForceMerge().setMaxNumSegments(1).setFlush(true).get();
 * software distributed under the License is distributed on an
        NodeStats unluckyNode = dataNodeStats.get(1);
        for (int i = 0; i < numDocs; i++) {
                        logger.info("file chunk [{}] lastChunk: {}", req, req.lastChunk());  
                )  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
        assertThat(dataNodeStats.size(), greaterThanOrEqualTo(2));
import org.apache.lucene.tests.util.English;  
import java.util.concurrent.TimeUnit;  
            }
                            throw new RuntimeException("Caused some truncated files for fun and profit");  
            String id = Integer.toString(i);
 * specific language governing permissions and limitations
    /**
    }
                dataNodeStats.add(stat);
import java.util.ArrayList;  
            );
import org.apache.lucene.tests.util.LuceneTestCase.SuppressCodecs;
 */
     * target. This happens during recovery when the last chunk of the file is transferred to the replica
@SuppressCodecs("*") // test relies on exact file extensions  
                .setSettings(
                        }
/*  
        }
    public void testCancelRecoveryAndResume() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        client().admin().indices().prepareFlush().setForce(true).get(); // double flush to create safe commit in case of async durability  
 * under the License.  
            assertHitCount(client().prepareSearch().setQuery(QueryBuilders.termQuery("the_id", id)).get(), 1);  
        logger.info("--> bumping replicas to 1"); //
                .isAcknowledged()  
        Collections.shuffle(dataNodeStats, random());
     */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.IndexMetadata;
                        "index.routing.allocation.include._name",  // now allow allocation on all nodes
 * ownership. Elasticsearch licenses this file to you under  
                dataNode.getNode().getName()
                .prepareUpdateSettings()  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
    }
        final CountDownLatch latch = new CountDownLatch(1);  
 */  
                    .put(  
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING;  
                    }
            .indices()
import org.opensearch.transport.TransportService;
        List<IndexRequestBuilder> builder = new ArrayList<>();
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
                            latch.countDown();
        ensureGreen("test");  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    Settings.builder()
import java.util.Collection;
 * KIND, either express or implied.  See the License for the
     * we just throw an exception to make sure the recovery fails and we leave some half baked files on the target.
            String id = Integer.toString(i);
            mockTransportService.addSendBehavior(
        int numDocs = randomIntBetween(100, 200);
 */  
                        FileChunkRequest req = (FileChunkRequest) request;
public class TruncatedRecoveryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
/*
        ); // only allocate on the lucky node
        final AtomicBoolean truncate = new AtomicBoolean(true);
            client().admin()
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        for (int i = 0; i < numDocs; i++) {
                .cluster()
                }
 * license agreements. See the NOTICE file distributed with
     * This test tries to truncate some of larger files in the index to trigger leftovers on the recovery  
        // at this point we got some truncated left overs on the replica on the unlucky node  
 * the Apache License, Version 2.0 (the "License"); you may
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 2, numClientNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
                        primariesNode.getNode().getName() + "," + unluckyNode.getNode().getName()
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.plugins.Plugin;  
 * Modifications Copyright OpenSearch Contributors. See
            .get();
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
                    )  
    @Override  
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < numDocs; i++) {  
                    if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {
        for (NodeStats dataNode : dataNodeStats) {
import org.opensearch.action.index.IndexRequestBuilder;
        }
            builder.add(client().prepareIndex("test").setId(id).setSource("field1", English.intToEnglish(i), "the_id", id));
 *
    public static Collection<Object[]> parameters() {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 * SPDX-License-Identifier: Apache-2.0
    public TruncatedRecoveryIT(Settings settings) {  
 * compatible open source license.
        ensureGreen();  
        indexRandom(true, builder);
        }  
        return replicationSettings;  
        );
                        .put(INDICES_RECOVERY_CHUNK_SIZE_SETTING.getKey(), new ByteSizeValue(randomIntBetween(50, 300), ByteSizeUnit.BYTES))  
                    Settings.builder()
        super(settings);
                    connection.sendRequest(requestId, action, request, options);  
            if (stat.getNode().isDataNode()) {  
                )
            String id = Integer.toString(i);  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        client().admin().indices().prepareFlush().setForce(true).get();
    }
        // the lucky one holds the primary
/*  
        assertTrue(  
    }  
import java.util.Collections;  
import org.opensearch.test.OpenSearchIntegTestCase;
        // ensure we have flushed segments and make them a big one via optimize
        for (NodeStats stat : nodeStats.getNodes()) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        List<NodeStats> dataNodeStats = new ArrayList<>();
                (connection, requestId, action, request, options) -> {  
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
        }  
                        if ((req.name().endsWith("cfs") || req.name().endsWith("fdt")) && req.lastChunk() && truncate.get()) {
        // the unlucky one gets the replica and the truncated leftovers
        // create the index and prevent allocation on any other nodes than the lucky one  
}  
                internalCluster().getInstance(TransportService.class, unluckyNode.getNode().getName()),
 * not use this file except in compliance with the License.
        truncate.compareAndSet(true, false);
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();  
            ));  
                        .put("index.routing.allocation.include._name", primariesNode.getNode().getName())
            .setSettings(  
import org.opensearch.common.settings.Settings;  
package org.opensearch.recovery;
        // index some docs and check if they are coming back  
        client().admin()  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards())
        return Arrays.asList(MockTransportService.TestPlugin.class);
     * Later we allow full recovery to ensure we can still recover and don't run into corruptions.  
    @ParametersFactory
        latch.await(5, TimeUnit.MINUTES);
import java.util.Arrays;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  

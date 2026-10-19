 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
                client().admin()  
 * compatible open source license.
            .get();
            flushAndRefresh();  
                .cluster()
                assertEquals(targetSeqNoStats.getMaxSeqNo(), targetSeqNoStats.getLocalCheckpoint());
        // to the require._name below.  
            if (createWithReplicas == false) {
            }
        final int docs = randomIntBetween(0, 128);
            ensureGreen();
            );  
import org.opensearch.index.seqno.SeqNoStats;
                // bump replicas
                    .get();
 */
            // clean up  
 *
    }  
import static org.hamcrest.Matchers.equalTo;
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), (String) null)
        Version version = VersionUtils.randomIndexCompatibleVersion(random());  
 * GitHub history for details.
            .cluster()
            for (int i = docs; i < 2 * docs; i++) {  
 * ownership. Elasticsearch licenses this file to you under  
                    .setSettings(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .get();
        ).get();
            assertThat(targetStats.getIndex("target").getIndexShards().keySet().size(), equalTo(numPrimaryShards));
 * software distributed under the License is distributed on an
            client().admin()
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
                    .setSettings(Settings.builder().put("index.number_of_replicas", 1))  
        internalCluster().ensureAtLeastNumDataNodes(2);  
 * license agreements. See the NOTICE file distributed with
                assertEquals(sourceSeqNoStats.getMaxSeqNo(), targetSeqNoStats.getMaxSeqNo());  
                final SeqNoStats targetSeqNoStats = targetStats.getIndex("target").getIndexShards().get(i).getAt(0).getSeqNoStats();
    @Override  
                )  
                assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);  
            }
            final int size = docs > 0 ? 2 * docs : 1;
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.query.TermsQueryBuilder;
        prepareCreate("source").setSettings(
                .setTransientSettings(
            }
 *
/*
/*  
                2 * docs  
 * the Apache License, Version 2.0 (the "License"); you may
                    .indices()
        }
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                client().prepareIndex("target").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
import org.opensearch.common.settings.Settings;
            Settings.builder().put(indexSettings()).put("number_of_shards", numPrimaryShards).put("index.version.created", version)  
            client().prepareIndex("source").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
        client().admin().indices().prepareUpdateSettings("source").setSettings(Settings.builder().put("index.blocks.write", true)).get();  
        int numPrimaryShards = randomIntBetween(1, 5);
import org.opensearch.test.OpenSearchIntegTestCase;  
        client().admin()
        final IndicesStatsResponse sourceStats = client().admin().indices().prepareStats("source").setSegments(true).get();  
            final boolean createWithReplicas = randomBoolean();
public class CloneIndexIT extends OpenSearchIntegTestCase {
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                    .get()
package org.opensearch.action.admin.indices.create;
    public void testCreateCloneIndex() {
            assertEquals(version, target.getIndexToSettings().get("target").getAsVersion("index.version.created", null));
import org.opensearch.test.VersionUtils;
        try {  
                    )
            );
        // relocate all shards to one node such that we can merge it.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        // disable rebalancing to be able to capture the right stats. balancing can move the target primary
    protected boolean forbidPrivateIndexSettings() {
        for (int i = 0; i < docs; i++) {  
}  
        return false;
 * this file be licensed under the Apache-2.0 license or a
 */
                client().admin()
                .prepareUpdateSettings()  
                    .prepareUpdateSettings("target")
                        Settings.builder().put("index.number_of_replicas", createWithReplicas ? 1 : 0).putNull("index.blocks.write").build()  
            assertHitCount(client().prepareSearch("target").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
        }
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            assertAcked(  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        ensureGreen();
        // making it hard to pin point the source shards.  
                    .setResizeType(ResizeType.CLONE)
                    .prepareResizeIndex("source", "target")  
        ensureGreen();
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 * Unless required by applicable law or agreed to in writing,
            final IndicesStatsResponse targetStats = client().admin().indices().prepareStats("target").get();  
 *  
            GetSettingsResponse target = client().admin().indices().prepareGetSettings("target").get();  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
            for (int i = 0; i < numPrimaryShards; i++) {  
            assertHitCount(client().prepareSearch("source").setSize(size).setQuery(new TermsQueryBuilder("foo", "bar")).get(), docs);
                ensureGreen();
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
            assertHitCount(
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                    .indices()
import org.opensearch.Version;  
import org.opensearch.action.admin.indices.shrink.ResizeType;
        } finally {
 */  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
                final SeqNoStats sourceSeqNoStats = sourceStats.getIndex("source").getIndexShards().get(i).getAt(0).getSeqNoStats();
            .prepareUpdateSettings()  
            .setTransientSettings(Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none"))
/*
                client().prepareSearch("target").setSize(2 * size).setQuery(new TermsQueryBuilder("foo", "bar")).get(),

            ensureGreen();
            // block writes on index before performing shrink operation
                assertHitCount(  
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                client().prepareSearch("target")
                client().prepareIndex("test").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
                );  
            client().admin()
    }
                    .indices()
import java.util.Map;  
                .cluster()  
        // to the require._name below.  
        internalCluster().ensureAtLeastNumDataNodes(3);
            final int docs = 500;  
            final int docs = 500;
                    .get(),
        ).get();
                    .indices()
import org.opensearch.test.OpenSearchIntegTestCase;  
                            .put("index.number_of_replicas", 1)
                .prepareUpdateSettings()
                    .setResizeType(ResizeType.SHRINK)
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")  
                    .get()
                    docs
                            .putNull("index.blocks.write")
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
            for (int i = 0; i < docs; i++) {
            );
                "Replication still in progress for index [test]. Please wait for replication to complete and retry. "  
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
        prepareCreate("test").setSettings(  
            // Trigger split operation  
                    Settings.builder()  
        }
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
                            .putNull("index.blocks.write")
                    .setQuery(new TermsQueryBuilder("foo", "bar"))  
    }
import org.opensearch.cluster.node.DiscoveryNode;
                client().prepareIndex("test").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();  
                .put("index.refresh_interval", -1)
            IllegalStateException exception = assertThrows(
                    .setPreference(Preference.PRIMARY.type())  
            // block writes on index before performing split operation  
        // create index with -1 as refresh interval as we are blocking segrep and we want to control refreshes.  
                .prepareUpdateSettings("test")
                            .build()
        internalCluster().ensureAtLeastNumDataNodes(3);  
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
                .put(indexSettings())  
 * this file be licensed under the Apache-2.0 license or a
                            .put("index.number_of_replicas", 1)
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.blocks.write", true)).get();
                exception.getMessage()
            // Trigger split operation
package org.opensearch.indices.replication;
            final int docs = 500;
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node  
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    client().prepareSearch("test")
            for (int i = 0; i < docs; i++) {  
                    )  
            assertBusy(() -> {  
                assertHitCount(
    public void testCloneIndex() throws Exception {
    }  
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
            );
 * compatible open source license.
            ensureGreen();
                        Settings.builder()
                    + "Use the _cat/segment_replication/test api to check if the index is up to date (e.g. bytes_behind == 0).",
            client().admin()
                () -> client().admin()
                )  
                        .put("index.blocks.write", true)
                    .get()  
                .put("index.number_of_replicas", 1)
                client().prepareIndex("test").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            Settings.builder()
        // to the require._name below.
            Settings.builder()
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
import java.util.List;
        }
                    .setSettings(  
                );
                    .indices()  
        CountDownLatch latch = new CountDownLatch(1);  
                    .setSettings(Settings.builder().put("index.number_of_replicas", 1).putNull("index.blocks.write").build())
        ensureGreen();  
                    .prepareResizeIndex("test", "target")
/*  
            assertEquals(
            );  
            // Trigger Shrink operation, as replicas don't have any docs it will throw exception that replicas haven't caught up
            assertAcked(
                    .setSettings(
                    .prepareResizeIndex("test", "target")
                    .setPreference(Preference.PRIMARY.type())
 * SPDX-License-Identifier: Apache-2.0
        try (final Releasable ignored = blockReplication(List.of(discoveryNodes[0].getName()), latch)) {  
            refresh();
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
            assertBusy(() -> {
                .put("index.number_of_replicas", 1)
            }  
                .get();
                client().prepareSearch("target")
        try (final Releasable ignored = blockReplication(List.of(discoveryNodes[0].getName()), latch)) {
import org.opensearch.common.lease.Releasable;
import org.opensearch.index.query.TermsQueryBuilder;
                client().admin()  
            assertHitCount(  
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        // create index with -1 as refresh interval as we are blocking segrep and we want to control refreshes.  
 *
        // to the require._name below.
                            .build()
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
            );  
            }
                    .setResizeType(ResizeType.SPLIT)
 */  
            // verify that all docs are present in new target index  
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node  
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
                docs
        }
                )
                    .prepareResizeIndex("test", "target")  
        CountDownLatch latch = new CountDownLatch(1);  
                        .setPreference(Preference.PRIMARY.type())  
            assertAcked(
                .cluster()
            }
            ensureGreen();  
 * This test class verifies Resize Reequests (Shrink, Split, Clone) with segment replication as replication strategy.
            for (int i = 0; i < docs; i++) {
                .put("number_of_shards", 3)  
                    .setQuery(new TermsQueryBuilder("foo", "bar"))
                .setTransientSettings(
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();  
                .put("index.refresh_interval", -1)
                .setSettings(
import org.opensearch.action.admin.indices.shrink.ResizeType;
                .get();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.Preference;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)  
                        .setQuery(new TermsQueryBuilder("foo", "bar"))  
            });
                            .put("index.number_of_shards", 6)  
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();  
                    .get()
                        .get(),
    public void testCreateShrinkIndexThrowsExceptionWhenReplicasBehind() throws Exception {
                        .setQuery(new TermsQueryBuilder("foo", "bar"))
        ).get();
import org.opensearch.common.settings.Settings;  
                        .get(),
            // block writes on index before performing clone operation
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.blocks.write", true)).get();
        CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.CountDownLatch;
                    docs  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                )  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17552")  
                            .putNull("index.routing.allocation.require._name")  
            refresh();
            );  
        prepareCreate("test").setSettings(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            assertHitCount(
                    )
public class SegmentReplicationResizeRequestIT extends SegmentReplicationBaseIT {
                        Settings.builder()  
    public void testCreateSplitIndexWithSegmentReplicationBlocked() throws Exception {  
                .indices()  
                        .setPreference(Preference.PRIMARY.type())
                    client().prepareSearch("test")
                        .put("index.routing.allocation.require._name", discoveryNodes[0].getName())
                IllegalStateException.class,  
        // create index with -1 as refresh interval as we are blocking segrep and we want to control refreshes.
                .prepareUpdateSettings()  
                .get();
            client().admin()
            Settings.builder().put(indexSettings()).put("index.number_of_replicas", 1).put("number_of_shards", randomIntBetween(1, 5))
/**  
                    .setResizeType(ResizeType.CLONE)  
                .put(indexSettings())  
        // block Segment Replication so that replicas never get the docs from primary
            // verify that all docs are present in new target index
        // block Segment Replication so that replicas never get the docs from primary
 */
                    .get(),
        ensureGreen();  
        ensureGreen();
        ).get();
            );
        prepareCreate("test").setSettings(
                .setTransientSettings(
        // block Segment Replication so that replicas never get the docs from primary
}  
                .put("number_of_shards", 2)  
            });
                client().admin()
                docs  
            ensureGreen();  
        try (final Releasable ignored = blockReplication(List.of(discoveryNodes[0].getName()), latch)) {
            ensureGreen();

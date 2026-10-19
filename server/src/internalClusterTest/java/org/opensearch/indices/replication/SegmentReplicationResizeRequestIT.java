                .cluster()
            assertAcked(
        CountDownLatch latch = new CountDownLatch(1);
            // Trigger Shrink operation, as replicas don't have any docs it will throw exception that replicas haven't caught up
                )
                .prepareUpdateSettings("test")
        // block Segment Replication so that replicas never get the docs from primary
        // block Segment Replication so that replicas never get the docs from primary
                .put(indexSettings())
                "Replication still in progress for index [test]. Please wait for replication to complete and retry. "
import java.util.concurrent.CountDownLatch;
        CountDownLatch latch = new CountDownLatch(1);
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
        }
                )
        ensureGreen();
                .setTransientSettings(
            ensureGreen();
            assertHitCount(
 */
                    .setResizeType(ResizeType.SPLIT)
                .put("index.refresh_interval", -1)
            }
                .put("index.refresh_interval", -1)
            final int docs = 500;
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
                    .setPreference(Preference.PRIMARY.type())
        ensureGreen();
                    .setResizeType(ResizeType.SHRINK)
            }
        ensureGreen();
            for (int i = 0; i < docs; i++) {
        // create index with -1 as refresh interval as we are blocking segrep and we want to control refreshes.
            // verify that all docs are present in new target index
            ensureGreen();
            client().admin()
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
 * SPDX-License-Identifier: Apache-2.0
                    .setSettings(
            for (int i = 0; i < docs; i++) {
 * compatible open source license.
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                .put("number_of_shards", 2)
        // create index with -1 as refresh interval as we are blocking segrep and we want to control refreshes.
            // block writes on index before performing shrink operation
                    + "Use the _cat/segment_replication/test api to check if the index is up to date (e.g. bytes_behind == 0).",
        internalCluster().ensureAtLeastNumDataNodes(3);
        ).get();
            // verify that all docs are present in new target index
            client().admin()
            for (int i = 0; i < docs; i++) {
            );
                    .setSettings(
                        Settings.builder()
            // block writes on index before performing split operation
                    .get()
            Settings.builder()
            );
        DiscoveryNode[] discoveryNodes = dataNodes.values().toArray(new DiscoveryNode[0]);
                .prepareUpdateSettings()
                        .put("index.blocks.write", true)
 * The OpenSearch Contributors require contributions made to
                        .get(),
        try (final Releasable ignored = blockReplication(List.of(discoveryNodes[0].getName()), latch)) {
                .setSettings(
                .put("index.number_of_replicas", 1)
        ).get();
                            .build()
            ensureGreen();
 * This test class verifies Resize Reequests (Shrink, Split, Clone) with segment replication as replication strategy.
                );
            assertEquals(
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
        // to the require._name below.
import org.opensearch.index.query.TermsQueryBuilder;
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            ensureGreen();
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                        .setQuery(new TermsQueryBuilder("foo", "bar"))
                    .setResizeType(ResizeType.CLONE)
                () -> client().admin()
                    .get()
package org.opensearch.indices.replication;
/*
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
            assertBusy(() -> {
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
                client().prepareSearch("target")
        ).get();
        assertTrue("at least 2 nodes but was: " + dataNodes.size(), dataNodes.size() >= 2);
    public void testCloneIndex() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.util.Map;
                .cluster()
            final int docs = 500;
                            .putNull("index.routing.allocation.require._name")
import org.opensearch.core.xcontent.MediaTypeRegistry;
                .put("index.number_of_replicas", 1)
        internalCluster().ensureAtLeastNumDataNodes(3);
                    .indices()
                    docs
                        .get(),
                        .setPreference(Preference.PRIMARY.type())
                        .setPreference(Preference.PRIMARY.type())
 * this file be licensed under the Apache-2.0 license or a
                            .put("index.number_of_replicas", 1)
                assertHitCount(
                .indices()
                client().prepareIndex("test").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/17552")
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
                    .get()
            assertAcked(
            // Trigger split operation
                            .putNull("index.blocks.write")
    }
                .get();
import org.opensearch.common.settings.Settings;
        CountDownLatch latch = new CountDownLatch(1);
 *
        try (final Releasable ignored = blockReplication(List.of(discoveryNodes[0].getName()), latch)) {
                );
                client().prepareIndex("test").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            refresh();
            // block writes on index before performing clone operation
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2)
            IllegalStateException exception = assertThrows(
                .get();
                .get();
                        .setQuery(new TermsQueryBuilder("foo", "bar"))
                    )
            Settings.builder().put(indexSettings()).put("index.number_of_replicas", 1).put("number_of_shards", randomIntBetween(1, 5))
            refresh();
                    )
            );
                        Settings.builder()
public class SegmentReplicationResizeRequestIT extends SegmentReplicationBaseIT {
                    .get(),
                client().prepareSearch("target")
        // ensure all shards are allocated otherwise the ensure green below might not succeed since we require the merge node
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
                )
        prepareCreate("test").setSettings(
                    client().prepareSearch("test")
                client().admin()
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
}
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                    .get(),
            ensureGreen();
    }
                    .setPreference(Preference.PRIMARY.type())
        try (final Releasable ignored = blockReplication(List.of(discoveryNodes[0].getName()), latch)) {
                            .build()
        prepareCreate("test").setSettings(
                    .setSettings(Settings.builder().put("index.number_of_replicas", 1).putNull("index.blocks.write").build())
                    .prepareResizeIndex("test", "target")
                    .setQuery(new TermsQueryBuilder("foo", "bar"))
import org.opensearch.cluster.node.DiscoveryNode;
            }
import org.opensearch.action.admin.indices.shrink.ResizeType;
            final int docs = 500;
                .put("number_of_shards", 3)
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.blocks.write", true)).get();
            // Trigger split operation
                    docs
            });
                    .setQuery(new TermsQueryBuilder("foo", "bar"))
        // block Segment Replication so that replicas never get the docs from primary
/**
    }
                        .put("index.routing.allocation.require._name", discoveryNodes[0].getName())
        // create index with -1 as refresh interval as we are blocking segrep and we want to control refreshes.
                    .prepareResizeIndex("test", "target")
                assertHitCount(
    public void testCreateShrinkIndexThrowsExceptionWhenReplicasBehind() throws Exception {
        prepareCreate("test").setSettings(
                    client().prepareSearch("test")
        }
            );
                    .prepareResizeIndex("test", "target")
            });
        // if we change the setting too quickly we will end up with one replica unassigned which can't be assigned anymore due
                IllegalStateException.class,
                            .putNull("index.blocks.write")
    public void testCreateSplitIndexWithSegmentReplicationBlocked() throws Exception {
            assertHitCount(
                    .indices()
            Settings.builder()
            client().admin()
                .prepareUpdateSettings()
                docs
                client().admin()
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.blocks.write", true)).get();
                .put(indexSettings())
                .setTransientSettings(
import java.util.List;
                            .put("index.number_of_replicas", 1)
                            .put("index.number_of_shards", 6)
                docs
        final Map<String, DiscoveryNode> dataNodes = client().admin().cluster().prepareState().get().getState().nodes().getDataNodes();
                exception.getMessage()
                    .indices()
        // to the require._name below.
            assertBusy(() -> {
            );
import org.opensearch.cluster.routing.Preference;
                client().prepareIndex("test").setSource("{\"foo\" : \"bar\", \"i\" : " + i + "}", MediaTypeRegistry.JSON).get();
            );
                    Settings.builder()
 */
        // to the require._name below.
import org.opensearch.common.lease.Releasable;

    }
        assertTrue("nothing runs on the cluster manager thread", first.calls.isEmpty() && second.calls.isEmpty());
        return entry(uuid, Map.of(new ShardId(new Index("index", "index-uuid"), 0), RestoreInProgress.State.SUCCESS));
import org.opensearch.core.index.Index;
        assertFalse(taskQueue.hasRunnableTasks());
        assertEquals(List.of(first, second), context.restoredIndices());  
            shardStates.keySet().stream().map(ShardId::getIndexName).distinct().toList(),
    public void testContextListsOnlyIndicesWhoseEveryShardWasRestored() {
 * SPDX-License-Identifier: Apache-2.0
/*  
        public void onRestore(RestoreContext context) {
            failed ? RestoreInProgress.State.FAILURE : RestoreInProgress.State.SUCCESS,  
import org.opensearch.plugins.RestoreListenerPlugin;
        );  
        notifier(List.of(plugin)).restoreCompleted(entry);  
    }
                new ShardId(restored, 0),
import org.opensearch.common.settings.Settings;  
    public void testRestoreWithNoFullyRestoredIndexIsNotReported() {
                RestoreInProgress.State.FAILURE
        );
            )  
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(taskQueue.hasRunnableTasks());
        assertTrue(context.partialFailure());
public class RestoreCompletionNotifierTests extends OpenSearchTestCase {  
            new Snapshot("repo", new SnapshotId("snapshot", "snapshot-uuid")),
        final RestoreInProgress.Entry entry = entry(
                new ShardId(failed, 1),
            return calls.stream().map(RestoreContext::restoreUUID).toList();
        private final Consumer<RestoreContext> behaviour;
 */  
            "restore-uuid",  
        RecordingPlugin(Consumer<RestoreContext> behaviour) {  
        assertEquals(List.of("restore-uuid"), second.restoreUUIDs());  
        private final List<RestoreContext> calls = new CopyOnWriteArrayList<>();
    }  
        final Index failed = new Index("failed", "failed-uuid");  
import java.util.concurrent.CopyOnWriteArrayList;
        @Override
    }
    }
        assertEquals("a failed call is not retried", List.of("restore-uuid"), failing.restoreUUIDs());
import java.util.HashMap;
import org.opensearch.plugins.Plugin;  
        );
        notifier(List.of()).restoreCompleted(restoredEntry("restore-uuid"));
            Map.of(  
        taskQueue = new DeterministicTaskQueue(Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build(), random());
        super.setUp();  
    public void testContextListsIndicesByName() {
        final RecordingPlugin other = new RecordingPlugin(context -> {});
 * The OpenSearch Contributors require contributions made to  
        final RestoreInProgress.Entry entry = entry(
        List<String> restoreUUIDs() {
            this.behaviour = behaviour;
    }  
    private static final class RecordingPlugin extends Plugin implements RestoreListenerPlugin {  
    public void testFailingPluginDoesNotStopTheOthers() {  
            "restore-uuid",  
        assertEquals(entry.snapshot(), context.snapshot());
        }
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
        notifier.restoreCompleted(restoredEntry("restore-uuid"));
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards = new HashMap<>();  
import java.util.List;
            "restore-uuid",
    }  
        final RecordingPlugin second = new RecordingPlugin(context -> {});
    public void setUp() throws Exception {
            uuid,
        final Index restored = new Index("restored", "restored-uuid");
import static org.opensearch.node.Node.NODE_NAME_SETTING;
    }
        assertEquals(List.of("restore-uuid"), first.restoreUUIDs());
        }
        final RecordingPlugin first = new RecordingPlugin(context -> {});  
    }
        final Index first = new Index("a-index", "uuid-2");  
}
    @Override
import org.opensearch.cluster.RestoreInProgress;
    public void testEveryPluginIsCalledOnTheThreadPoolNotTheCallingThread() {
        final RestoreContext context = RestoreCompletionNotifier.contextOf(entry);
        final RestoreContext context = RestoreCompletionNotifier.contextOf(entry);  
            Map.of(new ShardId(new Index("failed", "failed-uuid"), 0), RestoreInProgress.State.FAILURE)
 * compatible open source license.
        assertEquals(List.of("restore-uuid"), other.restoreUUIDs());  
        );
        final RestoreCompletionNotifier notifier = notifier(List.of(first, second));
            calls.add(context);  
package org.opensearch.snapshots;
                RestoreInProgress.State.SUCCESS,
        assertTrue(plugin.calls.isEmpty());  
        }  
                new ShardId(failed, 0),
    private RestoreCompletionNotifier notifier(List<RestoreListenerPlugin> plugins) {  
        assertFalse(context.partialFailure());
        final RecordingPlugin failing = new RecordingPlugin(context -> { throw new RuntimeException("simulated"); });
import java.util.Map;  
        assertEquals(List.of(restored), context.restoredIndices());
        assertNull(RestoreCompletionNotifier.contextOf(entry));  
    private DeterministicTaskQueue taskQueue;
                RestoreInProgress.State.SUCCESS,  
import java.util.function.Consumer;
        return new RestoreCompletionNotifier(taskQueue.getThreadPool(), plugins);
        final Index second = new Index("b-index", "uuid-1");
        taskQueue.runAllTasks();  
        notifier.restoreCompleted(restoredEntry("restore-uuid"));
        final RestoreCompletionNotifier notifier = notifier(List.of(failing, other));  
        final boolean failed = shardStates.containsValue(RestoreInProgress.State.FAILURE);
        assertEquals("restore-uuid", context.restoreUUID());  
        return new RestoreInProgress.Entry(  
    }
 *
                RestoreInProgress.State.SUCCESS,
 * this file be licensed under the Apache-2.0 license or a
    private static RestoreInProgress.Entry restoredEntry(String uuid) {
    }
        shardStates.forEach((shardId, state) -> shards.put(shardId, new RestoreInProgress.ShardRestoreStatus("node", state)));
    private static RestoreInProgress.Entry entry(String uuid, Map<ShardId, RestoreInProgress.State> shardStates) {
            Map.of(new ShardId(second, 0), RestoreInProgress.State.SUCCESS, new ShardId(first, 0), RestoreInProgress.State.SUCCESS)
            shards
import org.opensearch.core.index.shard.ShardId;
        taskQueue.runAllTasks();  
            behaviour.accept(context);
        final RecordingPlugin plugin = new RecordingPlugin(context -> {});
        final RestoreInProgress.Entry entry = entry(
                new ShardId(restored, 1),  
    public void testNoPluginsIsANoOp() {  

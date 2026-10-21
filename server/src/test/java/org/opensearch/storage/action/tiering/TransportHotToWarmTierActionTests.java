    }
            stateAfterCleanup.get().blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
    @FunctionalInterface
            before.getSettingsVersion(),
        executePrepareTiering(indexName, (request, listener) -> {
     * Adds a write block to the cluster state (same logic as TransportHotToWarmTierAction.addWriteBlockAndPrepare).
            listener.onResponse(new BroadcastResponse(2, 2, 0, Collections.emptyList()));
        assertTrue("Block should be present", stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
    }
        executePrepareTiering(indexName, (request, listener) -> {
        if (indexMetadata == null) {
    /** Error message for shard failure path must contain the actual failed shard count. */
     */
    public void testApplyWriteBlock_RemoveWhenAlreadyCleared_DoesNotBumpVersion() {
            // Validation passes: no exception
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        // removeWriteBlock should still work (settings.put(false) on already-false value)
     */
        assertFalse(
            }, ex -> fail("unexpected")),
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        if (validationPassed) {
            .numberOfShards(1)
        // New master retries: adds block again (idempotent) then runs prepare
            .build();
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
        return indexMetadata.getSettings().getAsBoolean(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false);
        AtomicInteger prepareCalls = new AtomicInteger(0);
    }
    }
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
        );
    /**
        assertEquals(
import org.opensearch.cluster.routing.RoutingTable;
            "settingsVersion must NOT change when blocks.write is already false/absent",
        assertFalse(
        int attempt
        String indexName = "test-dfa-index";
            new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard sync failed"))
    private ClusterState removeWriteBlock(ClusterState currentState, String indexName) {
        assertTrue("isDfaIndex should return true when pluggable dataformat is enabled", isDfaIndex(indexName, state));
        assertTrue(
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
            stateAfterBlock.get().blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        );
    public void testIsDfaIndex_PluggableDataformatEnabled_ReturnsTrue() {
     * 5. removeWriteBlock → block removed from cluster state
        boolean validationPassed;
            .settings(indexSettingsBuilder)
            .build();
        blocks.removeIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
        assertNotNull("Block state must not be null", stateWithBlock);
            1 // starts at 1
        );
        // Verify: failure captured, nothing else done
        assertEquals("Prepare should have been called 3 times", 3, prepareCalls.get());
                new DefaultShardOperationFailedException(indexName, 2, new RuntimeException("shard 2 failed"))
                listener.onResponse(new BroadcastResponse(2, 1, 1, shardFailures));
            stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            "Read-only setting should be false",
    // ── applyWriteBlock idempotency: settingsVersion must bump IFF the setting actually changes ──
            fail("addReadOnlyBlock must NOT be called when validation fails");
        executePrepareTiering(indexName, (request, listener) -> {
            MAX_PREPARE_RETRIES,
            stateWithBlock.metadata().index(indexName).getSettings().get(IndexModule.INDEX_TIERING_STATE.getKey())
    }
                new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("fail"))
            );
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .settingsVersion(1 + indexMetadata.getSettingsVersion());
        }
            } else {
        assertTrue(
    }
    /**
            // Simulate removing the write block on failure
import java.util.Collections;
    /**
 * this file be licensed under the Apache-2.0 license or a
        // Simulate clusterManagerOperation logic: validate FIRST
            .build();
        // Verify prepare still works after idempotent block add
        executePrepareTiering(indexName, (request, listener) -> {
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
        );
        );
        },
     * cluster setting ({@link TieringUtils#PREPARE_TIERING_TIMEOUT}) — the same expression
    /** Adding the write block must set the write-block setting and cluster block without touching tiering state. */
    }
            listener.onResponse(response);
        );
     * and calls prepareTieringAction. On success, tiering proceeds.
            .numberOfReplicas(0)
     * Full failure path for DFA index — preflight passes but prepare exhausts retries:
        IndexMetadata indexMetadata = state.metadata().index(indexName);
            "cluster block should still be present (re-asserted idempotently)",
        ClusterState result = TransportHotToWarmTierAction.applyWriteBlock(blocked, before, true);
        } catch (Exception e) {
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
            }
            stateAfterBlock.set(addReadOnlyBlock(state, indexName));
        AtomicInteger prepareCalls = new AtomicInteger(0);
        String indexName = "test-dfa-index";
    public void testRemoveReadOnlyBlock_WhenBlockNotPresent_IsNoOp() {
        assertTrue(
        assertFalse("Index should NOT be detected as DFA", isDfaIndex(indexName, state));
    public void testPrepareTiering_ExceptionCauseChained() {
            "Read-only block must NOT be present when validation fails",
            .build();
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
import org.opensearch.common.settings.Settings;
        // removeWriteBlock should handle null metadata gracefully (return state unchanged)
    /**
import org.opensearch.test.OpenSearchTestCase;
        );
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
     */
            listener.onResponse(new BroadcastResponse(1, 0, 1, failures));
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
            result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
 * The OpenSearch Contributors require contributions made to
            1
        executePrepareTiering(indexName, (request, listener) -> {
        // Verify: write block was NOT added (state unchanged)
            "Attempt counter must reach exactly MAX_PREPARE_RETRIES (3) on final failure",
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
            prepareCalls.incrementAndGet();
                BroadcastResponse response = new BroadcastResponse(2, 1, 1, shardFailures);
        ClusterState blocked = TransportHotToWarmTierAction.applyWriteBlock(state, state.metadata().index(indexName), true);
        assertTrue(
     * 1. isDfaIndex → true
            listener.onFailure(new RuntimeException("always fails"));
        if (isDfaIndex(indexName, state)) {
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
            ActionListener.wrap(v -> fail("Should not succeed when all shards fail"), e -> fail("unexpected")),
        assertTrue("Index should be detected as DFA", isDfaIndex(indexName, state));
        // Step 4: prepare fails all retries
            stateAfterAttempt.get().blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        Metadata emptyMetadata = Metadata.builder().build();
        assertTrue("Write block must be present", stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
            .numberOfReplicas(1)
    ) {
            stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
     * When preflight validation passes for a DFA index, the flow proceeds to add the
    // bumped without a settings change) hit on cancel-then-re-tier.
        );
        Settings indexSettings = Settings.builder()
            .build();
            @Override
        },
        );
        ClusterState state = buildClusterStateWithNonDfaIndex(indexName);
        } else {
    public void testIsDfaIndex_PluggableDataformatDisabled_ReturnsFalse() {
     * Tests that the write block is properly removed from the cluster state.
    /** removeWriteBlock on a state where block was never added must return state unchanged (no-op). */
        return ClusterState.builder(ClusterName.DEFAULT)
        );
        try {
        IndexMetadata after = result.metadata().index(indexName);
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
            .build();
            // In real code: hotToWarmTieringService.preflightValidate(state, index)
            } else {
        );
        String indexName = "test-dfa-index";
     * 2. Preflight validation passes (no exception)
    }
            1
        AtomicInteger prepareCalls = new AtomicInteger(0);
        );
        Settings custom = Settings.builder().put(TieringUtils.PREPARE_TIERING_TIMEOUT_KEY, "75s").build();
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true);
        assertNotNull("Step 6: failure must be captured", capturedFailure.get());
            "settingsVersion must increment by 1 when write block is removed",
        assertNotNull("Failure must be captured immediately", capturedFailure.get());
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
        executePrepareTiering(indexName, (request, listener) -> {
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
                }
    }
    public void testPrepareTiering_ErrorMessageContainsShardCount() {
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
        );
 * compatible open source license.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
    }
            indexName,
    }
    /**
        Settings.Builder settings = Settings.builder()
        ActionListener<Exception> onFinalFailure,
        try {
    /** First attempt: partial shard failure. Second: onFailure (exception). Third: full success. */
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            1
        // Simulate removeWriteBlock with null metadata (index deleted)
     * Validates that the DFA check gate (isDfaIndex) correctly distinguishes them.
    }
        long originalVersion = state.metadata().index(indexName).getSettingsVersion();
        ClusterState result = TransportHotToWarmTierAction.applyWriteBlock(blocked, before, false);
        );
            prepareCalls.incrementAndGet();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            "Step 5: write block must be removed after prepare failure",
            int call = prepareCalls.incrementAndGet();
    }
        assertEquals("Prepare should have been called exactly 2 times", 2, prepareCalls.get());
            stateAfterRetryBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            listener.onResponse(new BroadcastResponse(1, 1, 0, Collections.emptyList()));
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
            prepareCalls.incrementAndGet();
    public void testDfaIndex_PrepareExceptionRetries() {
    public void testRemoveWriteBlock_RemovesBlock_DoesNotMutateTieringState() {
     * Tests that isDfaIndex returns false when index metadata is null (index not found).
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
     * Checks if an index is a DFA index (same logic as TransportHotToWarmTierAction.isDfaIndex).
        // Build a non-DFA index (no PLUGGABLE_DATAFORMAT_ENABLED_SETTING)
            .build();
        ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
        AtomicInteger prepareCalls = new AtomicInteger(0);
            prepareCalls.incrementAndGet();
import java.util.concurrent.atomic.AtomicReference;
        String indexName = "test-explicit-false";
        // Second add while already blocked (e.g. re-tier after a cancel that retained the block):
        PrepareTieringRequest customReq = new PrepareTieringRequest("test-dfa-index");
        ClusterState result = removeWriteBlock(state, indexName);
        Settings.Builder indexSettingsBuilder = Settings.builder()
    public void testApplyWriteBlock_AddWhenUnblocked_SetsBlockAndBumpsVersion() {
     */
     */
            // All 3 shards fail
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
        assertFalse("isDfaIndex should return false when pluggable dataformat is not set", isDfaIndex(indexName, state));
    /** isDfaIndex must return false when the setting is explicitly set to false (not just absent). */
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("Should not fail for zero shards")),
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        }
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
    /** Error message for shard failure path must contain the index name. */
        String indexName = "test-dfa-index";
        assertTrue("Tiering should have been called directly", tieringCalled.get());
        // — it does NOT return the same state object because it rebuilds, but it must not throw
                .getSettings()
        RuntimeException validationError = new IllegalArgumentException("Warm tier has no capacity");
    }
        assertTrue("Tiering should proceed after idempotent block add", tieringCalled.get());
        // Precondition
        assertEquals(
                restored.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
    public void testPrepareTiering_SucceedsOnThirdAttempt() {
     * Tests retry logic: partial shard failures trigger retry up to MAX_PREPARE_RETRIES.
            capturedFailure.set(e);
        assertFalse(
        String indexName = "dfa-validate-pass";
        // Call the logic that would run in clusterManagerOperation:
        assertEquals(
        },
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        // Default: 90s when the setting is unset (matches PREPARE_TIERING_TIMEOUT default).
        String indexName = "test-dfa-index";
    }
}
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
        assertNotNull("Failure should be captured", capturedFailure.get());
        AtomicReference<ClusterState> stateAfterBlock = new AtomicReference<>(state);
        executePrepareTiering(indexName, (request, listener) -> {
                listener.onResponse(new BroadcastResponse(2, 2, 0, Collections.emptyList()));
    /**
    private ClusterState buildClusterStateWithNonDfaIndex(String indexName) {
    }
        Settings indexSettings = Settings.builder()
import org.opensearch.index.IndexModule;
                        + "] after "
            stateWithoutBlock.metadata()
        String indexName = "test-dfa-index";
        );
        assertTrue("Tiering must proceed when zero shards succeed", tieringCalled.get());
                new DefaultShardOperationFailedException(indexName, 1, new RuntimeException("shard 1 failed")),
     */
        if (validationPassed) {
            "Tiering state must not be written when adding the write block",
import org.opensearch.index.IndexSettings;
        }, ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")), ActionListener.wrap(e -> {
        }
        );
import java.util.List;
public class TransportHotToWarmTierActionTests extends OpenSearchTestCase {
        Settings dfaSettings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                new DefaultShardOperationFailedException(indexName, 1, new RuntimeException("fail1"))
    public void testDfaIndex_IndexDeletedDuringPrepare_HandlesGracefully() {
            IndexModule.TieringState.HOT_TO_WARM.name(),
            .put(indexMetadata.getSettings())
            "Write-block setting must be true",
        IndexMetadata indexMetadata = currentState.metadata().index(indexName);
        ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
        );
        String indexName = "full-happy-dfa";
        String indexName = "dfa-validate-fail";
        // Step 3: add write block
        // Simulate block already set from a previous attempt (before master failover)
            validationPassed = false;
     * Tests that all MAX_PREPARE_RETRIES exception failures result in final failure.
        // Step 6: verify failure and block removal
        }
            indexName,
 * - Failure handling removes write block
        // Verify: no write block is added for non-DFA (non-DFA goes directly to super.clusterManagerOperation)
            ActionListener.wrap(e -> {
    /** addReadOnlyBlock must preserve all pre-existing index settings (shards, replicas, uuid, etc.). */
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
    }
        IndexMetadata after = result.metadata().index(indexName);
                        + " shard(s) failed. Please retry the tiering request.";
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index(indexName)).build();
        String indexName = "test-dfa-index";
    }
        // For non-DFA indices, the action goes directly to tier() without calling prepare
            .build();
        ClusterState stateWithoutIndex = ClusterState.builder(ClusterName.DEFAULT)
            originalVersion + 2,
        // Build a cluster state without the target index
    /**
        );
        String indexName = "test-dfa-index";
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
    }
            "Read-only block setting should be true",
        // Simulate the decision logic in clusterManagerOperation
            .numberOfShards(numShards)
        // Precondition: no write block yet
        );
        String indexName,
    public void testPrepareTiering_SucceedsOnFirstAttempt_NoRetry() {
            .numberOfReplicas(numReplicas)
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
            state.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            .settings(nonDfaSettings)
            prepareCalls.incrementAndGet();
        assertEquals("Prepare should have been called once", 1, prepareCalls.get());
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),
    public void testDfaIndex_MasterFailoverScenario_RetryWorksWithExistingBlock() {
            "settingsVersion must NOT change when blocks.write is already true",
        assertFalse(
        // Step 2: preflight validation passes (simulated by no exception)
            "Step 3: write block must be present",
     */
        Metadata metadata = Metadata.builder().build();
            .settings(indexSettings)
    }
    public void testDfaPreflightValidationPassesThenAddsReadOnlyBlock() {
        String indexName = "test-dfa-index";
    public void testAddReadOnlyBlock_IncrementsSettingsVersion() {
            .put(indexMetadata.getSettings())
            result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
    // ── Mixed failure modes ────────────────────────────────────────────────────
        String indexName = "full-failure-dfa";
        );
        assertSame("The captured failure must be the validation error", validationError, capturedFailure.get());
        assertTrue("Error should mention shard failures", capturedFailure.get().getMessage().contains("shard(s) failed"));
        );
    public void testNonDfaIndexSkipsPreflightValidationGate() {
            List<DefaultShardOperationFailedException> failures = List.of(
            } else if (call == 2) {
        String indexName = "non-dfa-index";
            .settingsVersion(1 + indexMetadata.getSettingsVersion());
     */
        assertTrue("Tiering should have been called after retry", tieringCalled.get());
        );
        );
        Settings indexSettings = Settings.builder()
        String indexName = "test-dfa-index";
     * Non-DFA indices skip preflight validation entirely and go directly to tiering.
     */
     * {@code executePrepareTiering} uses — and NOT the outer request's 30s AcknowledgedRequest default.
        );
            after.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
            "settingsVersion must increment by 1 when write block is added",
    /** removeWriteBlock must increment settingsVersion by 1. */
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        return ClusterState.builder(ClusterName.DEFAULT)
     */
            .numberOfShards(1)
    // is the fix for the node-fatal AssertionError at IndexService.updateMetadata (settingsVersion
    /** All shards fail on every attempt — prepare exhausted with failedShards == totalShards. */
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),
            new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard sync failed"))
    }
        assertFalse(
    }
        assertEquals(
            "blocks.write setting should be true",
        assertTrue(
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
        assertEquals("numberOfShards must be preserved", original.getNumberOfShards(), after.getNumberOfShards());
     * This is the key ordering fix: validate BEFORE adding block or running prepare.
        String indexName = "test-dfa-index";
        PrepareHandler prepareHandler,
            stateAfterBlock.set(addReadOnlyBlock(state, indexName));
        // Verify: the DFA gate correctly identifies this as non-DFA
            );
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
        },
            // NOTE: no IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING → not DFA
            } else {
        assertFalse(
     */
        );
        AtomicInteger prepareCalls = new AtomicInteger(0);
        );
    public void testPrepareTiering_ZeroShards_SucceedsImmediately() {
            afterSecondAdd.metadata().index(indexName).getSettingsVersion()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private void executePrepareTiering(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    /** Prepare fails twice then succeeds on the third attempt. */
        // Simulate preflight validation failure (e.g. warm nodes full)
    }
    public void testFullFailurePath_DfaIndex_ValidationPassesPrepareFails_BlockRemoved() {
    /**
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
        assertFalse("isDfaIndex must return false when setting is explicitly false", isDfaIndex(indexName, state));
        assertEquals("All 3 retry attempts must be exhausted", 3, prepareCalls.get());
    /** Zero total shards (empty cluster) — BroadcastResponse(0,0,0,[]) should succeed immediately. */
        );
    /**
    private static final int MAX_PREPARE_RETRIES = 3;
        executePrepareTiering(
        RuntimeException originalCause = new RuntimeException("original network error");
 * <p>
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            if (call == 1) {
        String indexName = "test-dfa-index";
     * Simulates: block already present from previous attempt, prepare runs again and succeeds.
        });
        assertTrue("Error must mention attempts", capturedFailure.get().getMessage().contains("attempts"));
        long originalVersion = state.metadata().index(indexName).getSettingsVersion();
        assertTrue(
        assertFalse(
        assertEquals("Must try exactly 3 times with mixed failures", 3, prepareCalls.get());
            ClusterState restored = removeWriteBlock(stateWithBlock, indexName);
        executePrepareTiering(indexName, (request, listener) -> {
            .numberOfReplicas(1)
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
    /**
        assertTrue(
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
        );
            stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        assertFalse("isDfaIndex should return false for non-existent index", isDfaIndex("non-existent-index", state));
            listener.onResponse(new BroadcastResponse(2, 2, 0, Collections.emptyList()));
        // Only add block if validation passed
        );
        }
            .build();
            new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard fail"))
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
            1
                listener.onResponse(new BroadcastResponse(2, 1, 1, shardFailures));
        },
        },
     * write block and run prepare. This is the happy-path ordering.
        IndexMetadata after = stateWithBlock.metadata().index(indexName);
        );
        assertFalse(
        ClusterState result = TransportHotToWarmTierAction.applyWriteBlock(state, before, false);
        String indexName = "test-dfa-index";
            if (call == 1) {
    // ── write-block add/remove ──────────────────────────────────────────────────
                new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard 0 failed")),
            @Override
        assertTrue("Precondition: index must be DFA", isDfaIndex(indexName, state));
        );
    }
            "Write-block setting must be false after removal",
    }
        executePrepareTiering(indexName, (request, listener) -> {
     * Tests that non-DFA indices skip the prepare step entirely and go straight to tier().
                .index(indexName)
                listener.onFailure(new RuntimeException("network error on attempt 1"));
            capturedFailure.set(e);
            );
        );
    }
        String indexName = "test-dfa-index";
     * 1. isDfaIndex → true
            "INDEX_WRITE_BLOCK cluster block should be removed",
        );
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
        );
        RuntimeException validationError = new IllegalArgumentException("Warm nodes have insufficient disk space");
            stateAfterAttempt.set(addReadOnlyBlock(state, indexName));
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
            (request, listener) -> listener.onResponse(new BroadcastResponse(1, 1, 0, Collections.emptyList())),
        assertTrue("Other index must be detected as DFA", isDfaIndex(dfaIndex, state));
     */
        assertTrue("Error message must contain the index name", capturedFailure.get().getMessage().contains(indexName));
     * 3. addReadOnlyBlock → block present
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false) // explicitly false
     */
    private boolean isDfaIndex(String indexName, ClusterState state) {
        );
            }
            1
    // These exercise the REAL TransportHotToWarmTierAction.applyWriteBlock (not a local copy), which
            } else if (call == 2) {
            int call = prepareCalls.incrementAndGet();
            stateWithBlock = addReadOnlyBlock(state, indexName);
            "Read-only setting must be false after removing a non-existent block",
                String errorMsg = "Pre-tiering sync failed for DFA index ["
            .settings(indexSettings)
        assertFalse(
    public void testIsDfaIndex_SettingExplicitlyFalse_ReturnsFalse() {
        // Must not regress to the old 30s ack-timeout default.
        );
            // Always return partial shard failures
            "Block must not be present after removing a non-existent block",
            stateWithBlock.metadata().index(indexName).getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
                listener.onResponse(response);
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
        },
        AtomicInteger prepareCalls = new AtomicInteger(0);
            prepareCalls.get()
        }, ex -> fail("unexpected")), 1);
            stateAfterBlock.get().blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
                // Third attempt: success
     * 4. executePrepareTiering → succeeds on first attempt
    }
    public void testIsDfaIndex_NullIndexMetadata_ReturnsFalse() {
            // This block must NOT execute
     * Tests that isDfaIndex returns true when pluggable dataformat is enabled.
            } else {
        IndexMetadata after = result.metadata().index(indexName);
import org.opensearch.storage.common.tiering.TieringUtils;
            .build();
        ClusterBlocks blocks = ClusterBlocks.builder()
        assertTrue("Precondition: index must be DFA", isDfaIndex(indexName, state));
        );
            prepareCalls.incrementAndGet();
        String indexName = "test-dfa-index";
            .metadata(Metadata.builder().put(dfaMeta, false).put(nonDfaMeta, false).build())
        assertNull("No failure should occur in happy path", failureCalled.get());
            listener.onResponse(new BroadcastResponse(5, 3, 2, failures));
        );
    }
            "Non-DFA index must not have a write block added (no DFA path taken)",
                new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("fail0")),
        assertEquals(
        AtomicReference<Exception> failureCalled = new AtomicReference<>();
        // Add block
        assertEquals("numberOfReplicas must be preserved", original.getNumberOfReplicas(), after.getNumberOfReplicas());
        );
                .index(indexName)
                    executePrepareTiering(indexName, prepareHandler, onSuccess, onFinalFailure, attempt + 1);
     * Simulates the executePrepareTiering retry logic from TransportHotToWarmTierAction.
            result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
            after.getSettingsVersion()
        executePrepareTiering(indexName, (request, listener) -> {
                    + " attempts. Please retry.";
            listener.onFailure(new RuntimeException("Remote store sync failed"));
        assertEquals("settingsVersion should bump by 1 on a real change", before.getSettingsVersion() + 1, after.getSettingsVersion());
            stateWithBlockAgain.metadata()
        );
            return currentState;
    public void testAddReadOnlyBlock_SettingsVersionIncrementsOnSecondAdd() {
        Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
    // ── Preflight validation ordering tests ──────────────────────────────────────
        String indexName = "test-dfa-index";
        assertTrue("Tiering should proceed after master failover retry", tieringCalled.get());
        );
    public void testRemoveReadOnlyBlock_RestoresOriginalState() {
        IndexMetadata dfaMeta = IndexMetadata.builder(dfaIndex).settings(dfaSettings).numberOfShards(1).numberOfReplicas(0).build();
            1
        assertTrue("Tiering must succeed after mixed failure recovery", tieringCalled.get());
            );
        ClusterState blocked = TransportHotToWarmTierAction.applyWriteBlock(state, state.metadata().index(indexName), true);
     * Tests that prepare failure via onFailure (exception path) also retries.
        IndexMetadata indexMetadata = currentState.metadata().index(indexName);
import org.opensearch.cluster.ClusterName;
                        + " attempts: "
        );
    }
        );
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
            List<DefaultShardOperationFailedException> failures = List.of(
                    return;
            1
        // Precondition: index is DFA
     * Tests that after a master failover, retry works correctly when the block is already set.
        ClusterState result = removeWriteBlock(stateWithoutIndex, indexName);
        String indexName = "test-dfa-index";
        String indexName = "test-dfa-index";
    private ClusterState addReadOnlyBlock(ClusterState currentState, String indexName) {
     * NO write block added, NO prepare called, immediate failure returned.
        assertTrue("Step 1: must be DFA", isDfaIndex(indexName, state));
     *
     * Tests that isDfaIndex returns false when pluggable dataformat is not enabled.
     * Full happy path for DFA index:
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("Should not fail")),
 *
            .routingTable(routingTable)
        assertNotNull("Failure should be captured", capturedFailure.get());
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)
        assertTrue(
            .settings(indexSettings)
        IndexMetadata before = state.metadata().index(indexName);
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        },
    }
        assertTrue("Precondition: must be DFA", isDfaIndex(indexName, state));
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
            fail("Should not reach prepare for non-DFA index");
                    return;
                // Attempts 1 and 2: partial failure
        executePrepareTiering(
                stateAfterCleanup.set(removeWriteBlock(stateWithBlock, indexName));
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata()).put(indexMetadataBuilder);
        // Simulate index deletion: prepare fails because index no longer exists
        assertTrue("Step 1: index must be DFA", isDfaIndex(indexName, state));
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        );
        );
        IndexMetadata before = state.metadata().index(indexName);
     */
    public void testPrepareTiering_MixedFailureModes_PartialThenExceptionThenSuccess() {
            .blocks(state.blocks())
        assertFalse(
            throw validationError; // simulates validation failure
    public void testDfaIndex_PartialShardFailuresRetryUpToMax() {
    public void testFullHappyPath_DfaIndex_ValidatesBlocksPreparesTiers() {
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
    /** addReadOnlyBlock must increment settingsVersion by exactly 1. */
        AtomicInteger prepareCalls = new AtomicInteger(0);
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
        // must NOT bump settingsVersion, or IndexService.updateMetadata's invariant trips.
        assertTrue(
        if (validationPassed) {
        assertFalse("Target index must NOT be detected as DFA — isolation check", isDfaIndex(nonDfaTarget, state));
        executePrepareTiering(indexName, (request, listener) -> {
        // Verify: failure was captured
        String indexName = "my-specific-index";
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK).build();
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        AtomicInteger prepareCalls = new AtomicInteger(0);
    public void testDfaIndex_PrepareFailureAfterRetriesRemovesBlockAndFails() {
            .metadata(metadata)
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            validationPassed = false;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .metadata(Metadata.builder().put(indexMetadata, false).build())
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            "blocks.write setting should be false",
        }
    public void testPrepareTiering_ErrorMessageContainsIndexName() {
     */
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
    }
        }
        String indexName = "test-dfa-index";
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
    public void testIsDfaIndex_OtherIndexIsDfa_TargetIsNot() {
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
        long versionBeforeRemove = stateWithBlock.metadata().index(indexName).getSettingsVersion();
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
                // First two attempts: exception
     * Full failure path: preflight validation fails immediately —
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
                listener.onFailure(new RuntimeException("Network error"));
     * 3. addReadOnlyBlock → block present in cluster state
        Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
     * Tests that adding a write block when it is already present (retry scenario) is idempotent.
            .build();
            "INDEX_WRITE_BLOCK cluster block should be present",
            listener.onFailure(new RuntimeException("Persistent network error"));
    /**
        assertTrue(
    /**
            int call = prepareCalls.incrementAndGet();
            int call = prepareCalls.incrementAndGet();
    public void testApplyWriteBlock_RemoveWhenBlocked_ClearsAndBumpsVersion() {
        ClusterState afterSecondAdd = addReadOnlyBlock(afterFirstAdd, indexName);
            after.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
            stateWithBlock.metadata().index(indexName).getSettingsVersion()
            listener.onResponse(new BroadcastResponse(5, 5, 0, Collections.emptyList()));
     * Tests that prepare action failure (after retries) removes the write block and fails the request.
        assertEquals("index UUID must be preserved", original.getIndexUUID(), after.getIndexUUID());
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
        ClusterState stateWithBlockAgain = addReadOnlyBlock(stateWithBlock, indexName);
        assertTrue(
     * When preflight validation fails for a DFA index, the write block must NOT be added
        assertEquals("Prepare should have been called 3 times (MAX_PREPARE_RETRIES)", 3, prepareCalls.get());
        // Simulate prepare tiering succeeding
        // Verify: no failure
            after.getSettingsVersion()
            prepareCalls.incrementAndGet();
            prepareCalls.incrementAndGet();
        assertTrue(
        assertNotEquals(TimeValue.timeValueSeconds(30), customReq.timeout());
        // 1. preflightValidate → throws
            1
        PrepareTieringRequest defaultReq = new PrepareTieringRequest("test-dfa-index");
    }
            1
            .build();
            public void onResponse(BroadcastResponse broadcastResponse) {
     */
                onSuccess.onResponse(null);
            result.metadata().index(indexName).getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
        );
            ActionListener.wrap(e -> failureCalled.set(e), ex -> fail("unexpected")),
     */
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 2, 1);
        // Add block
                onFinalFailure.onResponse(new IllegalStateException(errorMsg, e));
                capturedFailure.set(e);
        String indexName = "test-dfa-index";
        String indexName = "test-dfa-index";
        assertNotNull("Failure must be captured", capturedFailure.get());
        assertEquals("Prepare should have been called 3 times", 3, prepareCalls.get());
     * 6. Failure callback invoked with error message
            "Read-only block setting must be true after add",
        ClusterState afterFirstAdd = addReadOnlyBlock(state, indexName);
            }
        // 2. listener.onFailure should be called
        AtomicInteger prepareCalls = new AtomicInteger(0);
/*
    public void testApplyWriteBlock_AddWhenAlreadyBlocked_DoesNotBumpVersion() {
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
        );
        );
     */
            1
            "settingsVersion must be original + 2 after two addReadOnlyBlock calls",
        String indexName = "test-dfa-index";
import org.opensearch.core.action.ActionListener;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    onFinalFailure.onResponse(new IllegalStateException(errorMsg));
        assertEquals("Must try exactly 3 times with mixed failure order", 3, prepareCalls.get());
        AtomicReference<ClusterState> stateAfterAttempt = new AtomicReference<>(state);
        String indexName = "test-non-dfa-index";
    /**
        AtomicInteger prepareCalls = new AtomicInteger(0);
            "blocks.write should remain true",
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
            state.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            BroadcastResponse response = new BroadcastResponse(3, 2, 1, shardFailures);
import org.opensearch.action.support.broadcast.BroadcastResponse;
                .getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
                        + indexName
        assertFalse(
            .settings(indexSettings)
        AtomicReference<ClusterState> stateAfterCleanup = new AtomicReference<>(stateWithBlock);
                // Attempt 3: success
        );
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),
     */
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
                    + MAX_PREPARE_RETRIES
    /** Adding the block twice must increment settingsVersion by 2 total (idempotent logic still mutates version). */
        prepareHandler.prepare(prepareTieringRequest, new ActionListener<BroadcastResponse>() {
    // ── BroadcastResponse edge cases ───────────────────────────────────────────
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        Metadata metadata = Metadata.builder(state.metadata())
        // Simulate preflight validation SUCCESS (no exception thrown)
            List<DefaultShardOperationFailedException> failures = Collections.singletonList(
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("Should not fail")),
        // Step 5: verify outcomes
     */
            stateAfterRemove.metadata().index(indexName).getSettingsVersion()
        },
        assertFalse("Block should be removed", stateWithoutBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
            (request, listener) -> listener.onFailure(new RuntimeException("sync failed")),
        }
            new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard failed"))
            .routingTable(routingTable)
    public void testNonDfaIndex_SkipsPrepareAndGoesDirectlyToTier() {
    }
            throw validationError; // preflight throws
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT_TO_WARM.name());
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
            "Read-only block must NOT be added when preflight validation fails",
    public void testDfaPreflightValidationFailsBeforeReadOnlyBlockIsAdded() {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            if (call <= 2) {
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
        ClusterState stateAfterRemove = removeWriteBlock(stateWithBlock, indexName);
     * Tests that for DFA indices, the action adds a write block
        );
import org.opensearch.common.unit.TimeValue;
     */
    }
import org.opensearch.Version;
    /** Removing the write block must lift the block and leave the tiering state untouched. */
        boolean validationPassed;
    }
        return ClusterState.builder(currentState).metadata(metadataBuilder).blocks(blocks).build();
        ActionListener<Void> onSuccess,
        AtomicInteger prepareCalls = new AtomicInteger(0);
/**
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        assertTrue("Tiering must succeed after third attempt", tieringCalled.get());
        },
    private ClusterState buildClusterStateWithDfaIndex(String indexName, int numShards, int numReplicas) {
            new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard fail"))
    public void testAddWriteBlock_SetsWriteBlock_DoesNotMutateTieringState() {
            public void onFailure(Exception e) {
    public void testPrepareTiering_MixedFailureModes_ExceptionThenPartialThenSuccess() {
            return false;
            .build();
     * Removes the write block (same logic as TransportHotToWarmTierAction.removeWriteBlock). The tiering
        assertNull("Listener must NOT have received a failure when validation passes", capturedFailure.get());
        // Steps 1-3: DFA, validate passes, block added
        // Block is NOT present
            .put(IndexMetadata.SETTING_INDEX_UUID, "dfa-uuid")
        String indexName = "test-dfa-index";
        assertTrue("Error should mention attempts", capturedFailure.get().getMessage().contains("3 attempts"));
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(
        // Remove block
        assertTrue("Tiering should have been called after retries", tieringCalled.get());
        );
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 2, 1);
            "Read-only setting should still be true",
        executePrepareTiering(indexName, (request, listener) -> {
            prepareCalls.incrementAndGet();
        AtomicReference<ClusterState> stateAfterBlock = new AtomicReference<>(state);
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
 * Unit tests for the pre-tiering flush logic in {@link TransportHotToWarmTierAction}.
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1); // starts unblocked
            listener.onResponse(new BroadcastResponse(3, 0, 3, failures));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index(indexName)).build();
        );
    /**
        assertEquals("Step 4: prepare called exactly once", 1, prepareCalls.get());
    }
import org.opensearch.cluster.metadata.Metadata;
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        String indexName = "test-dfa-index";
            indexName,
        assertEquals("Prepare must be called exactly once — no retry on success", 1, prepareCalls.get());
     * Throughout: no failures, no retries.
        AtomicInteger prepareCalls = new AtomicInteger(0);
    /** The attempt counter must reach exactly MAX_PREPARE_RETRIES (3) on final failure. */
    }
        assertSame("State should be unchanged when index metadata is null", stateWithoutIndex, result);
            if (call == 1) {
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 3, 2);
            1
    public void testPrepareRequestTimeout_DerivedFromPrepareTieringTimeoutSetting() {
    public void testAddReadOnlyBlock_PreservesExistingSettings() {
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
            .build();
     * 4. executePrepareTiering → fails all 3 retries
        IndexMetadata before = blocked.metadata().index(indexName);
        );
            tieringCalled.set(true);
            "Read-only cluster block should be present",
     */
        assertTrue("Step 5: tiering must be called after prepare succeeds", tieringCalled.get());
        assertFalse("Precondition: block must not be present", state.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
            // 2 shards failed out of 5
        },
        assertEquals(TimeValue.timeValueSeconds(75), customReq.timeout());
        },
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
        assertTrue("Block should be present", stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
        );
            if (call <= 2) {
            capturedFailure.set(e);
            .build();
            // Non-DFA path: go directly to tier
            1
        if (validationPassed) {
        assertSame("The original exception must be chained as cause", originalCause, capturedFailure.get().getCause());
    }
 */
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            before.getSettingsVersion(),
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
    /**
    /**
    /** isDfaIndex on the target index must return false even if another index in the cluster IS DFA. */
            after.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
            "Block should already be present (from previous master)",
        PrepareTieringRequest prepareTieringRequest = new PrepareTieringRequest(indexName);
                listener.onResponse(new BroadcastResponse(2, 2, 0, Collections.emptyList()));
     * 5. Tiering proceeds (success callback invoked)
        assertNull(
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(
        assertTrue(
            int call = prepareCalls.incrementAndGet();
            } else {
            "Tiering state must be left untouched by write-block removal",
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     */
        executePrepareTiering(indexName, (request, listener) -> {
        String nonDfaTarget = "non-dfa-target";
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        } catch (Exception e) {
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
     * prepare fails and block removal handles null metadata gracefully.
            stateWithBlockAgain.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            .build();
        assertFalse("Non-DFA index must not pass isDfaIndex() check — preflight not called for non-DFA", isDfaIndex(indexName, state));
        assertEquals("Prepare should have been called once", 1, prepareCalls.get());
        assertNotNull("Failure must be captured", capturedFailure.get());
        executePrepareTiering(
        assertTrue("Tiering should have been called", tieringCalled.get());
        assertTrue("Error message must contain the failed shard count (2)", capturedFailure.get().getMessage().contains("2"));
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            "blocks.write should remain unset",
            (request, listener) -> listener.onFailure(new IllegalStateException("Index [" + indexName + "] not found")),
        String indexName = "test-dfa-index";
        // Add block again (simulates retry scenario)
            .put(IndexMetadata.SETTING_INDEX_UUID, "non-dfa-uuid")
        assertFalse(
        assertFalse(
 * - DFA indices get write block + prepare + tier
    /** The IllegalStateException created on exception path must chain the original cause. */
            1
        ClusterState blockedState = ClusterState.builder(state).metadata(metadata).blocks(blocks).build();
        executePrepareTiering(
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        // Simulate the DFA branch: validate first
            "DFA setting must be preserved",
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
            capturedFailure.get().getMessage().contains("after") && capturedFailure.get().getMessage().contains("attempts")
            after.getSettings().getAsBoolean(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
package org.opensearch.storage.action.tiering;
            }
        assertTrue("Tiering must succeed after mixed failure recovery", tieringCalled.get());
        assertTrue("Error must mention shard(s) failed", capturedFailure.get().getMessage().contains("shard(s) failed"));
        // Only add block if validation passed
    /**
        String indexName = "test-dfa-index";
    }
            "Precondition: no write block before validation",
        },
            validationPassed = false;
        executePrepareTiering(indexName, (request, listener) -> {
                if (broadcastResponse.getFailedShards() > 0) {
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
     * The prepare request's timeout must be derived from the {@code cluster.tiering.prepare_timeout}
     */
        assertEquals("Prepare must be called exactly once for zero shards", 1, prepareCalls.get());
    public void testPrepareTiering_AllShardsFailAllRetries() {
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
                    + "] after "
    public void testDfaIndex_ReadOnlyBlockAlreadyPresent_IsIdempotent() {
        String indexName = "test-dfa-index";
            blockRemoved.set(true);
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        assertEquals(
        ClusterState state = buildClusterStateWithNonDfaIndex(indexName);
            1
    interface PrepareHandler {
     * Tests that when prepare succeeds on retry (after initial shard failures), tiering proceeds.
            1
            1
        assertTrue("Tiering must proceed immediately on first-attempt success", tieringCalled.get());
        );
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
        // Simulate the write block present and the tiering state already advanced to HOT_TO_WARM.
                    if (attempt < MAX_PREPARE_RETRIES) {
    public void testDfaIndex_AllRetriesExhaustedViaException() {
import org.opensearch.cluster.block.ClusterBlocks;
     * Tests that if an index is deleted between adding the block and running prepare,
        );
        assertNotNull("Listener must have received validation failure", capturedFailure.get());
    /** Prepare succeeds on the first attempt — must not retry at all. */
     * state is never mutated.
            .numberOfShards(1)
                        + broadcastResponse.getFailedShards()
            .put(IndexMetadata.builder(indexMetadata).settings(settings).settingsVersion(1 + indexMetadata.getSettingsVersion()))
        Settings nonDfaSettings = Settings.builder()
        Settings indexSettings = Settings.builder()
import org.opensearch.cluster.ClusterState;
        // Step 1: detect DFA
 * The tests use a testable helper that replicates the action's logic without
            capturedFailure.set(e);
        assertEquals("Prepare should NOT have been called", 0, prepareCalls.get());
            .settings(indexSettingsBuilder)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // Verify: write block WAS added (flow proceeded)
            state.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
                }
@SuppressWarnings("unchecked")
        AtomicReference<Boolean> blockRemoved = new AtomicReference<>(false);
 * - Non-DFA indices skip prepare and go directly to tier
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("Should not fail")),
            result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            "Error message should mention retry exhaustion",
        assertEquals("settingsVersion should bump by 1 on a real change", before.getSettingsVersion() + 1, after.getSettingsVersion());
     */
        assertNotNull("Failure must be captured", capturedFailure.get());
            .numberOfReplicas(0)
    // ── isDfaIndex edge cases ───────────────────────────────────────────────────
        assertTrue("Step 3: block must be present", stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
                // Second attempt: success
        blocks.addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
            // In real code: hotToWarmTieringService.preflightValidate(state, index)
    public void testFullFailurePath_DfaIndex_ValidationFails_NothingDone() {
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 3, 1);
            versionBeforeRemove + 1,
        String indexName = "validation-fail-dfa";
        );
            indexName,
 * - Retry logic on partial shard failures
    /**
        String dfaIndex = "dfa-other";
    /**
    /**
                listener.onResponse(response);
        String indexName = "test-dfa-index";
            prepareCalls.incrementAndGet();
        },
        },
        String indexName = "test-non-dfa-index";
     * 2. Preflight validation passes
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
            "Block should remain present after retry",
            }
                        return;
    /**
        // First add → blocked (this is the legitimate version bump).
                "Read-only block should be removed after failure",
        boolean validationPassed = true; // no exception thrown
                listener.onFailure(new RuntimeException("network error on attempt 2"));
        );
            .put(indexMetadata.getSettings())
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(
        IndexMetadata after = result.metadata().index(indexName);
 * <p>
        IndexMetadata nonDfaMeta = IndexMetadata.builder(nonDfaTarget)
    /** First attempt: onFailure (exception). Second: partial shard failure. Third: full success. */
        String indexName = "test-dfa-index";
            "Read-only block must be added after preflight validation passes",
        ClusterState stateWithoutBlock = removeWriteBlock(stateWithBlock, indexName);
            "Block should be present after first add",
                // Step 5: simulate removeWriteBlock on failure
        customReq.timeout(TieringUtils.PREPARE_TIERING_TIMEOUT.get(custom));
        }
        String indexName = "test-dfa-index";
    /**
            originalVersion + 1,
                    String errorMsg = "Pre-tiering sync failed for index ["
            .metadata(Metadata.builder().put(indexMetadata, false).build())
        assertTrue("Read-only block should have been removed", blockRemoved.get());
    }
        // Add write block
        // A custom (dynamic) value flows through to the prepare request.
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
 */
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
        Settings.Builder indexSettingsBuilder = Settings.builder()
        // Prepare succeeds on first attempt after failover
        assertNotNull("Result should not be null", result);
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 2, 1);
            1
        );
        assertTrue(
        assertFalse("Write block must be removed", result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
        ClusterState stateAfterRetryBlock = addReadOnlyBlock(stateWithBlock, indexName);
            "Block should still be present after second add",
        assertNotNull("Failure should be captured", capturedFailure.get());
    /**
import java.util.concurrent.atomic.AtomicInteger;
            after.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
                listener.onResponse(new BroadcastResponse(2, 2, 0, Collections.emptyList()));
        assertEquals("Failure must be the validation error", validationError, capturedFailure.get());
            .numberOfShards(1)
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false);
        void prepare(PrepareTieringRequest request, ActionListener<BroadcastResponse> listener);
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
            .addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            .build();
            (request, listener) -> listener.onFailure(originalCause),
        } catch (Exception e) {
            assertFalse(
            1
        // 3. addReadOnlyBlock should NOT be called
            prepareCalls.incrementAndGet();
        IndexMetadata before = blocked.metadata().index(indexName);
            result.metadata().index(indexName).getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
        assertTrue(
        assertNotNull("Failure should be captured", capturedFailure.get());
        );
    /**
                if (attempt < MAX_PREPARE_RETRIES) {
        assertEquals(TimeValue.timeValueSeconds(90), defaultReq.timeout());
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
    }
        assertEquals(
    // ── Full functional orchestration scenarios ─────────────────────────────────
                        executePrepareTiering(indexName, prepareHandler, onSuccess, onFinalFailure, attempt + 1);
            .metadata(metadata)
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
    }
    public void testDfaIndex_PrepareSucceedsOnRetry() {
        String indexName = "test-dfa-index";
        // Step 4: prepare tiering — succeeds immediately
        return ClusterState.builder(currentState).metadata(metadataBuilder).blocks(blocks).build();
        // Add block first time
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
                .getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
            stateWithBlock.metadata().index(indexName).getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
        assertNotNull("Failure must be captured", capturedFailure.get());
    }
        defaultReq.timeout(TieringUtils.PREPARE_TIERING_TIMEOUT.get(Settings.EMPTY));
        AtomicInteger prepareCalls = new AtomicInteger(0);
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
        if (indexMetadata == null) {
    public void testDfaIndex_AddsReadOnlyBlockAndCallsPrepareTiering() {
        executePrepareTiering(indexName, (request, listener) -> {
                        + MAX_PREPARE_RETRIES
    }
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
                BroadcastResponse response = new BroadcastResponse(2, 2, 0, Collections.emptyList());
        try {
        AtomicInteger prepareCalls = new AtomicInteger(0);
            .put(IndexMetadata.SETTING_INDEX_UUID, "non-dfa-uuid")
            validationPassed = true;
        assertFalse("cluster block should be absent", result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
    // ── State mutation correctness ──────────────────────────────────────────────
 * SPDX-License-Identifier: Apache-2.0
        // Add write block (simulates the cluster state update task)
            stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            .metadata(emptyMetadata)
                // First attempt: partial failure
        ClusterState result = TransportHotToWarmTierAction.applyWriteBlock(state, before, true);
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(
 * requiring a full transport layer, since TransportAction.execute() is final.
        );
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("Should not fail")),
        assertNotNull("Result must not be null", result);
            .build();
                    }
        assertTrue(
    }
    }
        ClusterState stateWithBlock = null;
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
    // ── Retry sequence correctness ─────────────────────────────────────────────
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
            }
        AtomicInteger prepareCalls = new AtomicInteger(0);
        );
        assertEquals("Prepare must NOT be called when validation fails", 0, prepareCalls.get());
        executePrepareTiering(indexName, (request, listener) -> {
        executePrepareTiering(indexName, (request, listener) -> {
        boolean validationPassed;
    }
            result.metadata().index(indexName).getSettings().get(IndexModule.INDEX_TIERING_STATE.getKey())
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
    // ── Error message content verification ─────────────────────────────────────
        }
        AtomicInteger prepareCalls = new AtomicInteger(0);
        assertNotNull("Failure must be captured", capturedFailure.get());
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
        assertEquals("Prepare should have been called 3 times (MAX_PREPARE_RETRIES)", 3, prepareCalls.get());
        IndexMetadata indexMetadata = state.metadata().index(indexName);
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        AtomicInteger prepareCalls = new AtomicInteger(0);
    public void testAttemptCounterStartsAtOne_MatchesMaxOnFinalFailure() {
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
            }
        },
            .build();
                    + indexName
            1
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
                listener.onResponse(new BroadcastResponse(2, 1, 1, shardFailures));
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata()).put(indexMetadataBuilder);
    }
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
                .getSettings()
        IndexMetadata original = state.metadata().index(indexName);
        // Verify block was added
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
            listener.onResponse(new BroadcastResponse(0, 0, 0, Collections.emptyList()));
        assertEquals("Prepare must be called exactly 3 times", 3, prepareCalls.get());
                listener.onResponse(new BroadcastResponse(1, 1, 0, Collections.emptyList()));
    /**
     * and the listener must receive the failure immediately.
        ClusterState result = removeWriteBlock(blockedState, indexName);
        assertTrue(
            "Precondition: no write block before validation",
 * These tests verify the core decision logic:
    public void testRemoveReadOnlyBlock_IncrementsSettingsVersion() {
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
        );
            after.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)

        assertTrue("Tiering must proceed when zero shards succeed", tieringCalled.get());
    }
    }
        executePrepareTiering(  
        );  
                }  
     * Tests that for DFA indices, the action adds a write block  
                // Step 5: simulate removeWriteBlock on failure
        );  
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 2, 1);
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
        String indexName = "test-non-dfa-index";
    // ── Error message content verification ─────────────────────────────────────  
        );  
        assertEquals("Prepare should have been called once", 1, prepareCalls.get());
            stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
                // Third attempt: success  
        Settings.Builder indexSettingsBuilder = Settings.builder()
        ClusterState blocked = TransportHotToWarmTierAction.applyWriteBlock(state, state.metadata().index(indexName), true);
     * Adds a write block to the cluster state (same logic as TransportHotToWarmTierAction.addWriteBlockAndPrepare).  
        assertTrue("Tiering must succeed after mixed failure recovery", tieringCalled.get());
    public void testApplyWriteBlock_RemoveWhenAlreadyCleared_DoesNotBumpVersion() {
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
        );  
            new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard sync failed"))
    /**
     * When preflight validation passes for a DFA index, the flow proceeds to add the  
                BroadcastResponse response = new BroadcastResponse(2, 2, 0, Collections.emptyList());
        // For non-DFA indices, the action goes directly to tier() without calling prepare
        ActionListener<Exception> onFinalFailure,
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        String indexName,
                listener.onFailure(new RuntimeException("network error on attempt 1"));
        );
            stateAfterBlock.get().blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        assertFalse(
    }  
        );  
            1  
            1  
    }  
        assertEquals("numberOfShards must be preserved", original.getNumberOfShards(), after.getNumberOfShards());
        ClusterState stateWithoutIndex = ClusterState.builder(ClusterName.DEFAULT)  
import java.util.concurrent.atomic.AtomicInteger;
            new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard sync failed"))
            .settings(indexSettings)
            "Tiering state must not be written when adding the write block",  
    /**
        Settings nonDfaSettings = Settings.builder()
            .numberOfReplicas(1)  
    private static final int MAX_PREPARE_RETRIES = 3;
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
        RuntimeException originalCause = new RuntimeException("original network error");
        // Step 5: verify outcomes  
        AtomicInteger prepareCalls = new AtomicInteger(0);  
        // Block is NOT present
        assertEquals(
        // Simulate index deletion: prepare fails because index no longer exists
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.action.support.broadcast.BroadcastResponse;
                .getSettings()  
        );
    public void testNonDfaIndexSkipsPreflightValidationGate() {
        RuntimeException validationError = new IllegalArgumentException("Warm nodes have insufficient disk space");
            tieringCalled.set(true);
    /**  
     */  
            );
        assertTrue(
        assertNotNull("Failure should be captured", capturedFailure.get());
        // Verify block was added  
            after.getSettings().getAsBoolean(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false)
        try {
        // Verify prepare still works after idempotent block add
    }
            indexName,  
            validationPassed = true;
    public void testApplyWriteBlock_RemoveWhenBlocked_ClearsAndBumpsVersion() {
        AtomicInteger prepareCalls = new AtomicInteger(0);  
                new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("fail0")),
            "Error message should mention retry exhaustion",
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("Should not fail for zero shards")),
        assertTrue("Error should mention attempts", capturedFailure.get().getMessage().contains("3 attempts"));  
        );
    /** Prepare fails twice then succeeds on the third attempt. */
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1); // starts unblocked  
        // Default: 90s when the setting is unset (matches PREPARE_TIERING_TIMEOUT default).
    public void testDfaIndex_PrepareExceptionRetries() {  
    public void testDfaPreflightValidationFailsBeforeReadOnlyBlockIsAdded() {
        assertTrue("Step 5: tiering must be called after prepare succeeds", tieringCalled.get());
            "settingsVersion must increment by 1 when write block is added",
     */
        assertTrue(
     * Tests that prepare action failure (after retries) removes the write block and fails the request.
    public void testDfaIndex_PartialShardFailuresRetryUpToMax() {  
        assertTrue(  
    }
     * Validates that the DFA check gate (isDfaIndex) correctly distinguishes them.  
            .put(IndexMetadata.SETTING_INDEX_UUID, "dfa-uuid")
    public void testRemoveReadOnlyBlock_WhenBlockNotPresent_IsNoOp() {  
     */
     * Tests that the write block is properly removed from the cluster state.
        assertEquals("Must try exactly 3 times with mixed failure order", 3, prepareCalls.get());
    // ── Preflight validation ordering tests ──────────────────────────────────────
        // Build a non-DFA index (no PLUGGABLE_DATAFORMAT_ENABLED_SETTING)
            before.getSettingsVersion(),
     * 1. isDfaIndex → true  
@SuppressWarnings("unchecked")
            if (call <= 2) {
        // Second add while already blocked (e.g. re-tier after a cancel that retained the block):  
        assertTrue("Tiering should have been called directly", tieringCalled.get());  
    public void testDfaIndex_AddsReadOnlyBlockAndCallsPrepareTiering() {  
            stateWithBlockAgain.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)  
    public void testRemoveWriteBlock_RemovesBlock_DoesNotMutateTieringState() {  
    public void testPrepareTiering_SucceedsOnFirstAttempt_NoRetry() {
        }
            1
            IndexModule.TieringState.HOT_TO_WARM.name(),
        AtomicInteger prepareCalls = new AtomicInteger(0);
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
            stateWithBlock.metadata().index(indexName).getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)  
            stateAfterBlock.get().blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)  
        assertSame("State should be unchanged when index metadata is null", stateWithoutIndex, result);
    public void testPrepareTiering_MixedFailureModes_PartialThenExceptionThenSuccess() {
        // A custom (dynamic) value flows through to the prepare request.
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
 * Unit tests for the pre-tiering flush logic in {@link TransportHotToWarmTierAction}.  
            capturedFailure.set(e);  
    /**  
        },
                    onFinalFailure.onResponse(new IllegalStateException(errorMsg));
        String indexName = "test-dfa-index";  
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
     * and calls prepareTieringAction. On success, tiering proceeds.
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);  
            "Step 3: write block must be present",  
import org.opensearch.cluster.metadata.IndexMetadata;  
        executePrepareTiering(indexName, (request, listener) -> {
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
            // In real code: hotToWarmTieringService.preflightValidate(state, index)
 * - DFA indices get write block + prepare + tier  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();  
import java.util.List;
        // Verify: no write block is added for non-DFA (non-DFA goes directly to super.clusterManagerOperation)
            "settingsVersion must NOT change when blocks.write is already false/absent",
        ClusterState state = buildClusterStateWithNonDfaIndex(indexName);  
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();  
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),  
        // Simulate prepare tiering succeeding
        // Build a cluster state without the target index  
        );  
            if (call <= 2) {
     * 4. executePrepareTiering → fails all 3 retries
        );  
     * cluster setting ({@link TieringUtils#PREPARE_TIERING_TIMEOUT}) — the same expression
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("Should not fail")),  
        // must NOT bump settingsVersion, or IndexService.updateMetadata's invariant trips.
    /**  
                listener.onResponse(new BroadcastResponse(2, 2, 0, Collections.emptyList()));  
     * 3. addReadOnlyBlock → block present in cluster state
        );
                listener.onFailure(new RuntimeException("Network error"));
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        assertTrue("Step 3: block must be present", stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
            prepareCalls.incrementAndGet();  
    public void testPrepareTiering_ErrorMessageContainsShardCount() {
        // Simulate block already set from a previous attempt (before master failover)
        executePrepareTiering(indexName, (request, listener) -> {
import org.opensearch.common.unit.TimeValue;
        );  
     */
                        + MAX_PREPARE_RETRIES  
            stateAfterCleanup.get().blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)  
        // Simulate preflight validation SUCCESS (no exception thrown)
import org.opensearch.core.action.ActionListener;
        },
    public void testFullFailurePath_DfaIndex_ValidationFails_NothingDone() {
            state.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
    }  
        assertTrue("Write block must be present", stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));  
        return ClusterState.builder(currentState).metadata(metadataBuilder).blocks(blocks).build();
            .build();
            versionBeforeRemove + 1,  
            stateWithBlock.metadata().index(indexName).getSettings().get(IndexModule.INDEX_TIERING_STATE.getKey())
    // These exercise the REAL TransportHotToWarmTierAction.applyWriteBlock (not a local copy), which  
            // Always return partial shard failures
     */  
            result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            prepareCalls.incrementAndGet();  
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
    }
            1
        );
                restored.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        // Only add block if validation passed
            ActionListener.wrap(e -> {
            return currentState;
        assertNotNull("Failure must be captured immediately", capturedFailure.get());
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 3, 1);
        }
    public void testDfaIndex_AllRetriesExhaustedViaException() {
        );
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
                        return;
            List<DefaultShardOperationFailedException> failures = List.of(
        assertFalse("isDfaIndex should return false when pluggable dataformat is not set", isDfaIndex(indexName, state));
        ClusterState state = buildClusterStateWithNonDfaIndex(indexName);  
        );  
            stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        assertEquals("index UUID must be preserved", original.getIndexUUID(), after.getIndexUUID());
        AtomicInteger prepareCalls = new AtomicInteger(0);  
            after.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)  
        assertNotNull("Failure must be captured", capturedFailure.get());  
            stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            "Step 5: write block must be removed after prepare failure",
    }
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),
                if (broadcastResponse.getFailedShards() > 0) {
            .build();
            listener.onFailure(new RuntimeException("Persistent network error"));  
            listener.onResponse(new BroadcastResponse(2, 2, 0, Collections.emptyList()));  
     */
        );
        executePrepareTiering(indexName, (request, listener) -> {
     */
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
    /**  
        assertNull("Listener must NOT have received a failure when validation passes", capturedFailure.get());
    @FunctionalInterface
    public void testPrepareTiering_SucceedsOnThirdAttempt() {
    }  
        assertTrue(
        assertEquals("Must try exactly 3 times with mixed failures", 3, prepareCalls.get());
            prepareCalls.incrementAndGet();
    // ── Retry sequence correctness ─────────────────────────────────────────────
        executePrepareTiering(indexName, (request, listener) -> {
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    }
            // 2 shards failed out of 5
        IndexMetadata after = result.metadata().index(indexName);  
        ClusterState result = TransportHotToWarmTierAction.applyWriteBlock(state, before, true);  
            indexName,
     * Tests that isDfaIndex returns false when index metadata is null (index not found).  
        try {
        String indexName = "test-dfa-index";
        // Verify: write block WAS added (flow proceeded)  
    }
 * this file be licensed under the Apache-2.0 license or a
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);  
     */  
        // Precondition: index is DFA
        },  
        // Verify: the DFA gate correctly identifies this as non-DFA
        }
        assertTrue("Block should be present", stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
 * - Non-DFA indices skip prepare and go directly to tier
            1
        assertNotNull("Failure must be captured", capturedFailure.get());  
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();  
        });
        assertFalse("Precondition: block must not be present", state.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
        AtomicReference<Boolean> blockRemoved = new AtomicReference<>(false);  
            capturedFailure.set(e);  
            fail("addReadOnlyBlock must NOT be called when validation fails");
            assertFalse(  
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),
    /**
        );
        },
        ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
        String indexName = "test-dfa-index";
        ClusterState afterSecondAdd = addReadOnlyBlock(afterFirstAdd, indexName);
        // Step 6: verify failure and block removal
     * When preflight validation fails for a DFA index, the write block must NOT be added
    }  
            .build();  
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata()).put(indexMetadataBuilder);  
        assertEquals(TimeValue.timeValueSeconds(90), defaultReq.timeout());
            int call = prepareCalls.incrementAndGet();  
            .build();  
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
    }  
            throw validationError; // simulates validation failure
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),
        executePrepareTiering(indexName, (request, listener) -> {
            int call = prepareCalls.incrementAndGet();  
        Settings indexSettings = Settings.builder()  
        assertNotNull("Block state must not be null", stateWithBlock);
    }
     * 4. executePrepareTiering → succeeds on first attempt  
            List<DefaultShardOperationFailedException> failures = Collections.singletonList(
        assertFalse(
        }  
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
        assertFalse("Block should be removed", stateWithoutBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));
            } else if (call == 2) {
import org.opensearch.cluster.ClusterName;  
        } catch (Exception e) {
        assertTrue("Error message must contain the index name", capturedFailure.get().getMessage().contains(indexName));
                    + MAX_PREPARE_RETRIES
        );  
     * Tests retry logic: partial shard failures trigger retry up to MAX_PREPARE_RETRIES.
import org.opensearch.index.IndexSettings;
            "Tiering state must be left untouched by write-block removal",  
            prepareCalls.incrementAndGet();  
     *
            int call = prepareCalls.incrementAndGet();  
        assertNotNull("Failure should be captured", capturedFailure.get());
 * - Retry logic on partial shard failures
        assertFalse(  
/**
            .build();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    private void executePrepareTiering(
        // Add block  
            "Non-DFA index must not have a write block added (no DFA path taken)",
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
        assertEquals("Failure must be the validation error", validationError, capturedFailure.get());
        assertEquals(
        assertEquals("Prepare must NOT be called when validation fails", 0, prepareCalls.get());
        IndexMetadata nonDfaMeta = IndexMetadata.builder(nonDfaTarget)  
        boolean validationPassed = true; // no exception thrown  
    }
    /** Adding the block twice must increment settingsVersion by 2 total (idempotent logic still mutates version). */  
        assertFalse("isDfaIndex should return false for non-existent index", isDfaIndex("non-existent-index", state));
            .numberOfReplicas(1)
        // 3. addReadOnlyBlock should NOT be called
        AtomicReference<ClusterState> stateAfterBlock = new AtomicReference<>(state);
        IndexMetadata indexMetadata = state.metadata().index(indexName);
            // Validation passes: no exception  
        assertFalse(
            .metadata(metadata)  
            stateWithBlock.metadata().index(indexName).getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)  
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
     */
                listener.onResponse(new BroadcastResponse(2, 2, 0, Collections.emptyList()));  
        PrepareHandler prepareHandler,  
        executePrepareTiering(indexName, (request, listener) -> {
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
        String indexName = "test-dfa-index";  
        AtomicInteger prepareCalls = new AtomicInteger(0);
     * Tests that non-DFA indices skip the prepare step entirely and go straight to tier().
        );  
        String indexName = "test-dfa-index";  
        // 1. preflightValidate → throws
            .put(IndexMetadata.SETTING_INDEX_UUID, "non-dfa-uuid")
        executePrepareTiering(indexName, (request, listener) -> {  
            }
            listener.onResponse(new BroadcastResponse(1, 0, 1, failures));
        assertNotNull("Step 6: failure must be captured", capturedFailure.get());
            afterSecondAdd.metadata().index(indexName).getSettingsVersion()  
            after.getSettingsVersion()
        IndexMetadata indexMetadata = currentState.metadata().index(indexName);  
import org.opensearch.test.OpenSearchTestCase;
    public void testApplyWriteBlock_AddWhenAlreadyBlocked_DoesNotBumpVersion() {
            1
import org.opensearch.Version;
        Metadata metadata = Metadata.builder().put(indexMetadata, false).build();  
        Settings.Builder settings = Settings.builder()  
    /** isDfaIndex on the target index must return false even if another index in the cluster IS DFA. */
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK).build();
                // Attempt 3: success
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("Should not fail")),
    /**
        assertEquals(
        assertTrue(  
            // All 3 shards fail
                new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard 0 failed")),  
        executePrepareTiering(indexName, (request, listener) -> {
        int attempt  
     * 2. Preflight validation passes  
        assertTrue("Tiering should have been called", tieringCalled.get());  
        // Verify: failure was captured  
        IndexMetadata before = state.metadata().index(indexName);
            }
    // ── State mutation correctness ──────────────────────────────────────────────  
            result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
            .build();  
        // Verify: no failure  
    /**
        assertTrue("isDfaIndex should return true when pluggable dataformat is enabled", isDfaIndex(indexName, state));  
        },  
            .build();
        assertTrue(
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),  
        );
            .routingTable(routingTable)
        },  
import org.opensearch.storage.common.tiering.TieringUtils;  
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 2, 1);  
        blocks.removeIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
    private ClusterState addReadOnlyBlock(ClusterState currentState, String indexName) {
            }  
            1
            1
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // removeWriteBlock should still work (settings.put(false) on already-false value)
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(
            prepareCalls.incrementAndGet();
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("Should not fail")),  
            indexName,
        IndexMetadata indexMetadata = currentState.metadata().index(indexName);  
                    executePrepareTiering(indexName, prepareHandler, onSuccess, onFinalFailure, attempt + 1);
            stateWithoutBlock.metadata()
            .put(IndexMetadata.SETTING_INDEX_UUID, "non-dfa-uuid")  
    ) {
            "Read-only block must be added after preflight validation passes",
            (request, listener) -> listener.onFailure(new RuntimeException("sync failed")),  
        String indexName = "test-dfa-index";
    /**  
        assertTrue(  
            1
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
        },
            listener.onResponse(new BroadcastResponse(2, 2, 0, Collections.emptyList()));
            // This block must NOT execute
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            listener.onResponse(new BroadcastResponse(3, 0, 3, failures));
            stateAfterRetryBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)  
        // Simulate preflight validation failure (e.g. warm nodes full)
            .numberOfShards(1)
     * Removes the write block (same logic as TransportHotToWarmTierAction.removeWriteBlock). The tiering
            );
            (request, listener) -> listener.onResponse(new BroadcastResponse(1, 1, 0, Collections.emptyList())),
        // Add block again (simulates retry scenario)
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
        assertEquals("Step 4: prepare called exactly once", 1, prepareCalls.get());
                String errorMsg = "Pre-tiering sync failed for DFA index ["
            .build();
        Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(
        // — it does NOT return the same state object because it rebuilds, but it must not throw
        blocks.addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
 */
        String indexName = "test-dfa-index";
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        assertEquals("Prepare should NOT have been called", 0, prepareCalls.get());
    }
    }
        assertTrue(  
                stateAfterCleanup.set(removeWriteBlock(stateWithBlock, indexName));
    /**
    /**
    interface PrepareHandler {  
            blockRemoved.set(true);
        ClusterState result = TransportHotToWarmTierAction.applyWriteBlock(blocked, before, true);
        Settings indexSettings = Settings.builder()
        assertEquals("settingsVersion should bump by 1 on a real change", before.getSettingsVersion() + 1, after.getSettingsVersion());
            "Attempt counter must reach exactly MAX_PREPARE_RETRIES (3) on final failure",
            .build();
            .metadata(Metadata.builder().put(dfaMeta, false).put(nonDfaMeta, false).build())
        AtomicInteger prepareCalls = new AtomicInteger(0);
            .build();  
        if (indexMetadata == null) {
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
            stateAfterBlock.set(addReadOnlyBlock(state, indexName));  
        // Simulate removeWriteBlock with null metadata (index deleted)
    }  
        ClusterState result = TransportHotToWarmTierAction.applyWriteBlock(blocked, before, false);
        }
        String indexName = "test-explicit-false";
                        + broadcastResponse.getFailedShards()
            1  
        assertFalse(  
     * Non-DFA indices skip preflight validation entirely and go directly to tiering.
        },
    /** addReadOnlyBlock must increment settingsVersion by exactly 1. */
        // Add write block
            }, ex -> fail("unexpected")),  
        assertNotEquals(TimeValue.timeValueSeconds(30), customReq.timeout());
    // ── isDfaIndex edge cases ───────────────────────────────────────────────────  
 * <p>
    }  
            // NOTE: no IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING → not DFA
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);  
            .build();
            .routingTable(routingTable)
        );
        Settings indexSettings = Settings.builder()
    public void testIsDfaIndex_OtherIndexIsDfa_TargetIsNot() {
            .build();
        assertTrue("Other index must be detected as DFA", isDfaIndex(dfaIndex, state));
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),  
            "INDEX_WRITE_BLOCK cluster block should be removed",
    }  
        );
                // First two attempts: exception  
            @Override
            if (call == 1) {
        // Simulate the DFA branch: validate first  
            }  
            .metadata(Metadata.builder().put(indexMetadata, false).build())  
            "Block should be present after first add",
            } else if (call == 2) {  
    /** isDfaIndex must return false when the setting is explicitly set to false (not just absent). */
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    // ── write-block add/remove ──────────────────────────────────────────────────  
            prepareCalls.incrementAndGet();
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
    /**  
     * 2. Preflight validation passes (no exception)
        executePrepareTiering(indexName, (request, listener) -> {  
    }
import org.opensearch.common.settings.Settings;  
            listener.onResponse(response);  
 * The OpenSearch Contributors require contributions made to  
    /** The attempt counter must reach exactly MAX_PREPARE_RETRIES (3) on final failure. */
     * 6. Failure callback invoked with error message
        boolean validationPassed;
            "Read-only block setting should be true",
    public void testAttemptCounterStartsAtOne_MatchesMaxOnFinalFailure() {
        assertFalse(
        assertTrue(
        );
            fail("Should not reach prepare for non-DFA index");
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
        );
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
        String indexName = "test-dfa-index";
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
    /**
        String indexName = "test-dfa-index";
        },
            MAX_PREPARE_RETRIES,  
        assertNotNull("Failure must be captured", capturedFailure.get());
        assertTrue("Tiering should proceed after idempotent block add", tieringCalled.get());
        );  
        );
                }  
        // Verify: write block was NOT added (state unchanged)
        assertEquals(TimeValue.timeValueSeconds(75), customReq.timeout());
        if (validationPassed) {
        if (indexMetadata == null) {
     */
    }  
     */  
        String indexName = "test-dfa-index";
            .settings(indexSettings)
            .build();
    public void testDfaIndex_PrepareSucceedsOnRetry() {  
    private boolean isDfaIndex(String indexName, ClusterState state) {  
        );
        );  
        Metadata emptyMetadata = Metadata.builder().build();
        String indexName = "test-dfa-index";
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        // New master retries: adds block again (idempotent) then runs prepare
        String indexName = "test-dfa-index";  
    /** removeWriteBlock on a state where block was never added must return state unchanged (no-op). */
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),  
        assertEquals("Prepare should have been called 3 times (MAX_PREPARE_RETRIES)", 3, prepareCalls.get());
        // First add → blocked (this is the legitimate version bump).
     * Tests that isDfaIndex returns false when pluggable dataformat is not enabled.
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
            new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard fail"))
        AtomicReference<ClusterState> stateAfterBlock = new AtomicReference<>(state);
     * write block and run prepare. This is the happy-path ordering.
        executePrepareTiering(
        assertNull(
            after.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)
            stateWithBlock.metadata().index(indexName).getSettingsVersion()
        IndexMetadata before = blocked.metadata().index(indexName);  
        );
    }  
        // 2. listener.onFailure should be called  
            .build();  
        Settings indexSettings = Settings.builder()
            1
            capturedFailure.set(e);  
    /**
     */
        assertEquals("Prepare must be called exactly once — no retry on success", 1, prepareCalls.get());  
     * and the listener must receive the failure immediately.  
     * Tests that prepare failure via onFailure (exception path) also retries.
            1
        if (validationPassed) {
        executePrepareTiering(indexName, (request, listener) -> {
 * requiring a full transport layer, since TransportAction.execute() is final.  
    public void testNonDfaIndex_SkipsPrepareAndGoesDirectlyToTier() {
            .settings(indexSettingsBuilder)  
            1  
        }  
        AtomicInteger prepareCalls = new AtomicInteger(0);
     */
        ClusterState stateWithBlock = null;  
            stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
     * Tests that if an index is deleted between adding the block and running prepare,
            .metadata(Metadata.builder().put(indexMetadata, false).build())
        }
            before.getSettingsVersion(),
    }
    public void testApplyWriteBlock_AddWhenUnblocked_SetsBlockAndBumpsVersion() {
            .settings(nonDfaSettings)
    /**
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),
            .put(indexMetadata.getSettings())
            "blocks.write should remain true",
        ClusterState stateWithBlockAgain = addReadOnlyBlock(stateWithBlock, indexName);  
 * compatible open source license.
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);  
        assertFalse("Target index must NOT be detected as DFA — isolation check", isDfaIndex(nonDfaTarget, state));  
        String indexName = "my-specific-index";
    /** All shards fail on every attempt — prepare exhausted with failedShards == totalShards. */
            after.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
                listener.onFailure(new RuntimeException("network error on attempt 2"));  
        long originalVersion = state.metadata().index(indexName).getSettingsVersion();  
                .getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
            "Write-block setting must be true",
    }  
        PrepareTieringRequest defaultReq = new PrepareTieringRequest("test-dfa-index");  
        assertEquals("Prepare must be called exactly 3 times", 3, prepareCalls.get());
        );  
     */
            state.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata()).put(indexMetadataBuilder);  
    /**
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),  
        assertTrue("Tiering must proceed immediately on first-attempt success", tieringCalled.get());
     * The prepare request's timeout must be derived from the {@code cluster.tiering.prepare_timeout}  
    /** Adding the write block must set the write-block setting and cluster block without touching tiering state. */
            prepareCalls.incrementAndGet();
            listener.onResponse(new BroadcastResponse(5, 3, 2, failures));  
        executePrepareTiering(indexName, (request, listener) -> {
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),
        assertEquals("Prepare should have been called 3 times", 3, prepareCalls.get());  
                .getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
            1
    public void testDfaPreflightValidationPassesThenAddsReadOnlyBlock() {  
                new DefaultShardOperationFailedException(indexName, 2, new RuntimeException("shard 2 failed"))
            "Precondition: no write block before validation",  
package org.opensearch.storage.action.tiering;
    }  
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
        // Precondition
     * Tests that all MAX_PREPARE_RETRIES exception failures result in final failure.
                BroadcastResponse response = new BroadcastResponse(2, 1, 1, shardFailures);  
    private ClusterState removeWriteBlock(ClusterState currentState, String indexName) {
    public void testDfaIndex_PrepareFailureAfterRetriesRemovesBlockAndFails() {  
     * 5. removeWriteBlock → block removed from cluster state  
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);  
            } else {
            .numberOfReplicas(0)  
        ClusterState blocked = TransportHotToWarmTierAction.applyWriteBlock(state, state.metadata().index(indexName), true);  
        assertTrue(  
    /**
    }  
                new DefaultShardOperationFailedException(indexName, 1, new RuntimeException("fail1"))  
        );  
    public void testIsDfaIndex_SettingExplicitlyFalse_ReturnsFalse() {  
            @Override
        );
            indexName,
        String indexName = "dfa-validate-pass";
            .build();
        assertTrue("Step 1: must be DFA", isDfaIndex(indexName, state));
        if (validationPassed) {
        // Precondition: no write block yet
        ClusterState result = removeWriteBlock(blockedState, indexName);
    /**
import org.opensearch.cluster.metadata.Metadata;
            originalVersion + 2,
            );  
        IndexMetadata after = result.metadata().index(indexName);
        assertTrue("Precondition: must be DFA", isDfaIndex(indexName, state));  
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true)
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
            "blocks.write setting should be true",
        AtomicInteger prepareCalls = new AtomicInteger(0);
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index(indexName)).build();
    public void testDfaIndex_IndexDeletedDuringPrepare_HandlesGracefully() {
        }
 * - Failure handling removes write block  
            prepareCalls.incrementAndGet();  
    public void testAddReadOnlyBlock_SettingsVersionIncrementsOnSecondAdd() {
        );
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
        // Remove block
    public void testPrepareTiering_MixedFailureModes_ExceptionThenPartialThenSuccess() {
        assertSame("The original exception must be chained as cause", originalCause, capturedFailure.get().getCause());
        assertTrue("Error must mention attempts", capturedFailure.get().getMessage().contains("attempts"));  
        assertTrue("Index should be detected as DFA", isDfaIndex(indexName, state));
        ClusterState blockedState = ClusterState.builder(state).metadata(metadata).blocks(blocks).build();
    }  
        );  
    public void testIsDfaIndex_NullIndexMetadata_ReturnsFalse() {
            // Simulate removing the write block on failure
            stateWithBlockAgain.metadata()
        }, ex -> fail("unexpected")), 1);
    }
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),  
            .build();
    // ── applyWriteBlock idempotency: settingsVersion must bump IFF the setting actually changes ──
     * prepare fails and block removal handles null metadata gracefully.  
            new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard fail"))
            "Read-only block setting must be true after add",
            ClusterState restored = removeWriteBlock(stateWithBlock, indexName);
     * Tests that after a master failover, retry works correctly when the block is already set.  
        assertEquals("settingsVersion should bump by 1 on a real change", before.getSettingsVersion() + 1, after.getSettingsVersion());
            } else {
            prepareCalls.incrementAndGet();
            ActionListener.wrap(e -> failureCalled.set(e), ex -> fail("unexpected")),
    /** Zero total shards (empty cluster) — BroadcastResponse(0,0,0,[]) should succeed immediately. */
        ClusterState result = removeWriteBlock(state, indexName);  
        ClusterState result = TransportHotToWarmTierAction.applyWriteBlock(state, before, false);  
            "blocks.write setting should be false",  
            BroadcastResponse response = new BroadcastResponse(3, 2, 1, shardFailures);
        assertTrue("Tiering should proceed after master failover retry", tieringCalled.get());
    }  
                    if (attempt < MAX_PREPARE_RETRIES) {
            }
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        // Prepare succeeds on first attempt after failover  
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true);  
                    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
        // Step 3: add write block
        Metadata metadata = Metadata.builder(state.metadata())
    public void testDfaIndex_ReadOnlyBlockAlreadyPresent_IsIdempotent() {  
        String indexName = "dfa-validate-fail";
        );
        AtomicInteger prepareCalls = new AtomicInteger(0);
        executePrepareTiering(
            stateAfterBlock.set(addReadOnlyBlock(state, indexName));  
            // In real code: hotToWarmTieringService.preflightValidate(state, index)  
        String indexName = "test-non-dfa-index";
    /** Prepare succeeds on the first attempt — must not retry at all. */  
        // Add block first time
    }  
        String indexName = "test-dfa-index";
        );  
    /** Removing the write block must lift the block and leave the tiering state untouched. */
        assertTrue("Precondition: index must be DFA", isDfaIndex(indexName, state));  
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
    }
            (request, listener) -> listener.onFailure(new IllegalStateException("Index [" + indexName + "] not found")),
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
    }
        // Only add block if validation passed
import org.opensearch.index.IndexModule;
            1
        assertTrue("Tiering should have been called after retry", tieringCalled.get());
    // ── BroadcastResponse edge cases ───────────────────────────────────────────  
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
            after.getSettingsVersion()  
        },
        assertFalse("Non-DFA index must not pass isDfaIndex() check — preflight not called for non-DFA", isDfaIndex(indexName, state));  
        String indexName = "non-dfa-index";  
            );  
        Settings.Builder indexSettingsBuilder = Settings.builder()
    // is the fix for the node-fatal AssertionError at IndexService.updateMetadata (settingsVersion
        return ClusterState.builder(ClusterName.DEFAULT)  
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        assertNotNull("Result should not be null", result);
            .settings(indexSettings)
        // Call the logic that would run in clusterManagerOperation:
        executePrepareTiering(indexName, (request, listener) -> {  
            stateAfterRemove.metadata().index(indexName).getSettingsVersion()
            new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("shard failed"))
        executePrepareTiering(indexName, (request, listener) -> {
 * The tests use a testable helper that replicates the action's logic without
            "Block should still be present after second add",
        },
            "Write-block setting must be false after removal",
        // removeWriteBlock should handle null metadata gracefully (return state unchanged)
        );  
     * Full failure path for DFA index — preflight passes but prepare exhausts retries:
        String indexName = "test-dfa-index";
        assertEquals(  
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
            capturedFailure.set(e);  
 * These tests verify the core decision logic:
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            "settingsVersion must NOT change when blocks.write is already true",  
                    return;
                    + indexName
            after.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
    }
        AtomicInteger prepareCalls = new AtomicInteger(0);
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),  
     * Throughout: no failures, no retries.
            result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)  
        try {  
        );
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),
        assertTrue("Error message must contain the failed shard count (2)", capturedFailure.get().getMessage().contains("2"));
    public void testRemoveReadOnlyBlock_IncrementsSettingsVersion() {
            1 // starts at 1
    }  
            .numberOfShards(1)  
        },
        String indexName = "test-dfa-index";  
        return ClusterState.builder(currentState).metadata(metadataBuilder).blocks(blocks).build();
        ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
    /**
            "Read-only setting should still be true",  
     */
        IndexMetadata before = state.metadata().index(indexName);
            } else {
        String indexName = "test-dfa-index";  
     * Full failure path: preflight validation fails immediately —
        return ClusterState.builder(ClusterName.DEFAULT)
        assertEquals(
    }
        Metadata metadata = Metadata.builder().build();
                // Attempts 1 and 2: partial failure
        );
    /** First attempt: onFailure (exception). Second: partial shard failure. Third: full success. */
import java.util.Collections;  
            .settings(indexSettingsBuilder)  
        boolean validationPassed;  
        AtomicInteger prepareCalls = new AtomicInteger(0);
        assertFalse(  
     */  
            ActionListener.wrap(e -> fail("Should not reach final failure"), ex -> fail("unexpected")),  
            listener.onFailure(new RuntimeException("always fails"));  
            "Read-only setting should be false",  
        prepareHandler.prepare(prepareTieringRequest, new ActionListener<BroadcastResponse>() {
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
    private ClusterState buildClusterStateWithDfaIndex(String indexName, int numShards, int numReplicas) {
            1
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertTrue("Tiering must succeed after mixed failure recovery", tieringCalled.get());  
                listener.onResponse(response);
    /** removeWriteBlock must increment settingsVersion by 1. */
        assertFalse(
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
            if (call == 1) {  
        // Add block
        assertTrue(
                    return;
            "DFA setting must be preserved",  
    public void testPrepareRequestTimeout_DerivedFromPrepareTieringTimeoutSetting() {
    public void testPrepareTiering_ExceptionCauseChained() {  
                        + "] after "
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(
            listener.onResponse(new BroadcastResponse(0, 0, 0, Collections.emptyList()));  
        );
            .settings(indexSettings)
import org.opensearch.cluster.block.ClusterBlocks;
        assertTrue(
        );
            listener.onResponse(new BroadcastResponse(5, 5, 0, Collections.emptyList()));
            1
        ClusterState stateAfterRemove = removeWriteBlock(stateWithBlock, indexName);
        assertEquals("Prepare should have been called exactly 2 times", 2, prepareCalls.get());
                "Read-only block should be removed after failure",
        AtomicInteger prepareCalls = new AtomicInteger(0);
     * Simulates the executePrepareTiering retry logic from TransportHotToWarmTierAction.
        String nonDfaTarget = "non-dfa-target";
     */
                listener.onResponse(response);
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(
    }
            } else {
            // Non-DFA path: go directly to tier
        assertEquals(  
            validationPassed = false;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.cluster.routing.RoutingTable;
        );
                .getSettings()  
        PrepareTieringRequest prepareTieringRequest = new PrepareTieringRequest(indexName);
        ClusterState afterFirstAdd = addReadOnlyBlock(state, indexName);  
    public void testFullFailurePath_DfaIndex_ValidationPassesPrepareFails_BlockRemoved() {  
        IndexMetadata after = result.metadata().index(indexName);  
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(  
                        + " shard(s) failed. Please retry the tiering request.";  
            .put(IndexMetadata.builder(indexMetadata).settings(settings).settingsVersion(1 + indexMetadata.getSettingsVersion()))
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
            "INDEX_WRITE_BLOCK cluster block should be present",
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        String indexName = "test-dfa-index";
        }, ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")), ActionListener.wrap(e -> {
            } else {
 *
            listener.onResponse(new BroadcastResponse(1, 1, 0, Collections.emptyList()));
            }
     * state is never mutated.  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false) // explicitly false
        IndexMetadata indexMetadata = state.metadata().index(indexName);
    // ── Full functional orchestration scenarios ─────────────────────────────────
     * Simulates: block already present from previous attempt, prepare runs again and succeeds.
public class TransportHotToWarmTierActionTests extends OpenSearchTestCase {  
        assertFalse(
            "Block should remain present after retry",
                listener.onResponse(new BroadcastResponse(2, 1, 1, shardFailures));  
        String indexName = "test-dfa-index";
 */  
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);  
        );
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
        IndexMetadata before = blocked.metadata().index(indexName);
        );
    }
            result.metadata().index(indexName).getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)  
        },
    private ClusterState buildClusterStateWithNonDfaIndex(String indexName) {
     * NO write block added, NO prepare called, immediate failure returned.  
    public void testAddReadOnlyBlock_IncrementsSettingsVersion() {  
    /** addReadOnlyBlock must preserve all pre-existing index settings (shards, replicas, uuid, etc.). */
        assertSame("The captured failure must be the validation error", validationError, capturedFailure.get());  
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false);  
            "Block should already be present (from previous master)",
        // Step 1: detect DFA
        String indexName = "test-dfa-index";  
        assertTrue("Step 1: index must be DFA", isDfaIndex(indexName, state));  
            stateWithBlock = addReadOnlyBlock(state, indexName);
        assertFalse(  
        );
        assertNull("No failure should occur in happy path", failureCalled.get());  
        );
            result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        },  
        String indexName = "test-dfa-index";
            .build();  
    /**
    }
    /**  
            "Read-only setting must be false after removing a non-existent block",
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
            .put(indexMetadata.getSettings())
        AtomicInteger prepareCalls = new AtomicInteger(0);
        assertEquals("Prepare should have been called once", 1, prepareCalls.get());
        // Verify: failure captured, nothing else done
        executePrepareTiering(  
        IndexMetadata original = state.metadata().index(indexName);  
        defaultReq.timeout(TieringUtils.PREPARE_TIERING_TIMEOUT.get(Settings.EMPTY));
        AtomicReference<ClusterState> stateAfterAttempt = new AtomicReference<>(state);
            1
    }
     */
     * {@code executePrepareTiering} uses — and NOT the outer request's 30s AcknowledgedRequest default.
        }
        );
        );
            }
     */
        executePrepareTiering(indexName, (request, listener) -> {
        );
            .numberOfShards(1)
    }
        String indexName = "test-dfa-index";  
            .addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)  
            .numberOfShards(numShards)  
        assertTrue("Precondition: index must be DFA", isDfaIndex(indexName, state));
            .settingsVersion(1 + indexMetadata.getSettingsVersion());
        assertFalse("isDfaIndex must return false when setting is explicitly false", isDfaIndex(indexName, state));
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
                listener.onResponse(new BroadcastResponse(2, 1, 1, shardFailures));
        assertNotNull("Result must not be null", result);
import org.opensearch.cluster.ClusterState;
     * 5. Tiering proceeds (success callback invoked)
     */
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 2, 1);
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index(indexName)).build();
                new DefaultShardOperationFailedException(indexName, 1, new RuntimeException("shard 1 failed")),
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)  
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        assertTrue("Tiering must succeed after third attempt", tieringCalled.get());  
            int call = prepareCalls.incrementAndGet();
                    + " attempts. Please retry.";
        String dfaIndex = "dfa-other";  
            after.getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
     * Tests that when prepare succeeds on retry (after initial shard failures), tiering proceeds.
            .numberOfShards(1)
     */  
            validationPassed = false;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
 * <p>
            .numberOfReplicas(0)  
            .numberOfReplicas(numReplicas)
    /**
        AtomicReference<ClusterState> stateAfterCleanup = new AtomicReference<>(stateWithBlock);
            prepareCalls.incrementAndGet();
        );
        long originalVersion = state.metadata().index(indexName).getSettingsVersion();
        assertEquals("Prepare must be called exactly once for zero shards", 1, prepareCalls.get());
            .metadata(emptyMetadata)
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
        );
        String indexName = "test-dfa-index";  
    /** Error message for shard failure path must contain the index name. */
        String indexName = "full-failure-dfa";
        assertEquals("All 3 retry attempts must be exhausted", 3, prepareCalls.get());
        assertFalse("cluster block should be absent", result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));  
        } catch (Exception e) {
            prepareCalls.incrementAndGet();
            List<DefaultShardOperationFailedException> failures = List.of(
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        );
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        AtomicReference<Boolean> tieringCalled = new AtomicReference<>(false);
    // bumped without a settings change) hit on cancel-then-re-tier.
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
     */
            .metadata(metadata)
            public void onResponse(BroadcastResponse broadcastResponse) {  
     * 1. isDfaIndex → true
    }
        assertFalse(
        AtomicInteger prepareCalls = new AtomicInteger(0);
            1
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        );
        void prepare(PrepareTieringRequest request, ActionListener<BroadcastResponse> listener);
            state.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        assertNotNull("Failure should be captured", capturedFailure.get());
        String indexName = "test-dfa-index";
        String indexName = "test-dfa-index";
     * Tests that isDfaIndex returns true when pluggable dataformat is enabled.  
        assertEquals("Prepare should have been called 3 times", 3, prepareCalls.get());
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        Settings custom = Settings.builder().put(TieringUtils.PREPARE_TIERING_TIMEOUT_KEY, "75s").build();
    public void testDfaIndex_MasterFailoverScenario_RetryWorksWithExistingBlock() {  
            listener.onFailure(new RuntimeException("Remote store sync failed"));
                listener.onResponse(new BroadcastResponse(2, 1, 1, shardFailures));
    public void testAddWriteBlock_SetsWriteBlock_DoesNotMutateTieringState() {  
        );
        assertTrue(
    public void testIsDfaIndex_PluggableDataformatDisabled_ReturnsFalse() {
            "settingsVersion must increment by 1 when write block is removed",
    }
        String indexName = "test-dfa-index";
            "Read-only block must NOT be present when validation fails",  
                        executePrepareTiering(indexName, prepareHandler, onSuccess, onFinalFailure, attempt + 1);  
        AtomicInteger prepareCalls = new AtomicInteger(0);
        assertNotNull("Listener must have received validation failure", capturedFailure.get());
                capturedFailure.set(e);  
    /** Error message for shard failure path must contain the actual failed shard count. */
                onFinalFailure.onResponse(new IllegalStateException(errorMsg, e));  
        IndexMetadata after = result.metadata().index(indexName);
        assertTrue("Block should be present", stateWithBlock.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));  
                .index(indexName)
            return false;  
            "Read-only block must NOT be added when preflight validation fails",  
            capturedFailure.get().getMessage().contains("after") && capturedFailure.get().getMessage().contains("attempts")
}  
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),  
     * This is the key ordering fix: validate BEFORE adding block or running prepare.
        assertFalse("Index should NOT be detected as DFA", isDfaIndex(indexName, state));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)  
        assertTrue("Error must mention shard(s) failed", capturedFailure.get().getMessage().contains("shard(s) failed"));
        executePrepareTiering(indexName, (request, listener) -> {
            stateAfterAttempt.get().blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
        PrepareTieringRequest customReq = new PrepareTieringRequest("test-dfa-index");  
                new DefaultShardOperationFailedException(indexName, 0, new RuntimeException("fail"))  
    public void testFullHappyPath_DfaIndex_ValidatesBlocksPreparesTiers() {
    }
            throw validationError; // preflight throws
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("Should not fail")),
        ClusterBlocks blocks = ClusterBlocks.builder()
        assertFalse("Write block must be removed", result.blocks().hasIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK));  
    }  
        );
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();  
    /**
    public void testPrepareTiering_ZeroShards_SucceedsImmediately() {
        );
            .put(indexMetadata.getSettings())
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)  
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            "settingsVersion must be original + 2 after two addReadOnlyBlock calls",
        String indexName = "full-happy-dfa";
                listener.onResponse(new BroadcastResponse(2, 2, 0, Collections.emptyList()));
            .build();  
        ClusterState result = removeWriteBlock(stateWithoutIndex, indexName);  
    public void testPrepareTiering_AllShardsFailAllRetries() {  
            .blocks(state.blocks())
        boolean validationPassed;
        // Must not regress to the old 30s ack-timeout default.
    public void testRemoveReadOnlyBlock_RestoresOriginalState() {  
        },
        assertTrue("Error should mention shard failures", capturedFailure.get().getMessage().contains("shard(s) failed"));  
                if (attempt < MAX_PREPARE_RETRIES) {  
        if (isDfaIndex(indexName, state)) {  
        assertTrue("Tiering should have been called after retries", tieringCalled.get());
        // Steps 1-3: DFA, validate passes, block added
            int call = prepareCalls.incrementAndGet();
        assertNotNull("Failure must be captured", capturedFailure.get());  
                onSuccess.onResponse(null);
        String indexName = "test-dfa-index";
        ActionListener<Void> onSuccess,
        );  
        List<DefaultShardOperationFailedException> shardFailures = Collections.singletonList(
        assertTrue(
    public void testIsDfaIndex_PluggableDataformatEnabled_ReturnsTrue() {
        Settings dfaSettings = Settings.builder()  
        RuntimeException validationError = new IllegalArgumentException("Warm tier has no capacity");
/*  
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        executePrepareTiering(indexName, (request, listener) -> {
            "cluster block should still be present (re-asserted idempotently)",  
                    + "] after "  
                // Second attempt: success  
        // Simulate clusterManagerOperation logic: validate FIRST
            "blocks.write should remain unset",  
        assertTrue("Read-only block should have been removed", blockRemoved.get());
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
            .settingsVersion(1 + indexMetadata.getSettingsVersion());
     * 3. addReadOnlyBlock → block present
     * Tests that adding a write block when it is already present (retry scenario) is idempotent.
        // Simulate the write block present and the tiering state already advanced to HOT_TO_WARM.
    public void testAddReadOnlyBlock_PreservesExistingSettings() {  
        } else {  
    public void testPrepareTiering_ErrorMessageContainsIndexName() {  
            validationPassed = false;
        long versionBeforeRemove = stateWithBlock.metadata().index(indexName).getSettingsVersion();  
                listener.onResponse(new BroadcastResponse(1, 1, 0, Collections.emptyList()));
        String indexName = "test-dfa-index";
        // Add write block (simulates the cluster state update task)  
     */
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        ClusterState stateWithoutBlock = removeWriteBlock(stateWithBlock, indexName);  
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        return indexMetadata.getSettings().getAsBoolean(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false);
        String indexName = "test-dfa-index";
        executePrepareTiering(indexName, (request, listener) -> {  
     */
     * Checks if an index is a DFA index (same logic as TransportHotToWarmTierAction.isDfaIndex).
        // Step 2: preflight validation passes (simulated by no exception)
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 3, 2);
        },
        );  
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT_TO_WARM.name());  
            ActionListener.wrap(e -> capturedFailure.set(e), ex -> fail("unexpected")),  
        } catch (Exception e) {
        AtomicInteger prepareCalls = new AtomicInteger(0);
    }
        );  
                        + " attempts: "
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
        String indexName = "test-dfa-index";
        assertEquals("numberOfReplicas must be preserved", original.getNumberOfReplicas(), after.getNumberOfReplicas());  
            "Read-only cluster block should be present",  
        ClusterState stateAfterRetryBlock = addReadOnlyBlock(stateWithBlock, indexName);  
        // Simulate the decision logic in clusterManagerOperation
    }
            ActionListener.wrap(v -> fail("Should not succeed"), e -> fail("unexpected")),
     */  
            "Block must not be present after removing a non-existent block",  
        assertTrue(
        assertFalse(
            originalVersion + 1,  
            result.metadata().index(indexName).getSettings().get(IndexModule.INDEX_TIERING_STATE.getKey())
            (request, listener) -> listener.onFailure(originalCause),
        assertTrue(
            stateAfterAttempt.set(addReadOnlyBlock(state, indexName));  
        }  
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)  
        ClusterState stateWithBlock = addReadOnlyBlock(state, indexName);
                        + indexName
        String indexName = "test-dfa-index";
                    String errorMsg = "Pre-tiering sync failed for index ["  
        AtomicReference<Exception> failureCalled = new AtomicReference<>();
    /**  
        assertTrue(
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)
        IndexMetadata dfaMeta = IndexMetadata.builder(dfaIndex).settings(dfaSettings).numberOfShards(1).numberOfReplicas(0).build();
            public void onFailure(Exception e) {
        ClusterState state = buildClusterStateWithDfaIndex(indexName, 1, 1);
        assertNotNull("Failure must be captured", capturedFailure.get());
    // ── Mixed failure modes ────────────────────────────────────────────────────
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        customReq.timeout(TieringUtils.PREPARE_TIERING_TIMEOUT.get(custom));
        AtomicInteger prepareCalls = new AtomicInteger(0);
        assertEquals(
        );
            ActionListener.wrap(v -> fail("Should not succeed when all shards fail"), e -> fail("unexpected")),  
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
        String indexName = "test-dfa-index";  
            "Precondition: no write block before validation",
            .build();  
        // Step 4: prepare fails all retries  
        IndexMetadata after = stateWithBlock.metadata().index(indexName);  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    }
        );
    /** First attempt: partial shard failure. Second: onFailure (exception). Third: full success. */  
        assertEquals("Prepare should have been called 3 times (MAX_PREPARE_RETRIES)", 3, prepareCalls.get());
     * Full happy path for DFA index:
                .index(indexName)
            ActionListener.wrap(v -> tieringCalled.set(true), e -> fail("unexpected")),  
            prepareCalls.get()
import java.util.concurrent.atomic.AtomicReference;  
            result.metadata().index(indexName).getSettings().getAsBoolean(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false)
        assertNotNull("Failure should be captured", capturedFailure.get());
            if (call == 1) {
                // First attempt: partial failure
        String indexName = "validation-fail-dfa";  
        AtomicReference<Exception> capturedFailure = new AtomicReference<>();
        // Step 4: prepare tiering — succeeds immediately
    }
        if (validationPassed) {
    /** The IllegalStateException created on exception path must chain the original cause. */

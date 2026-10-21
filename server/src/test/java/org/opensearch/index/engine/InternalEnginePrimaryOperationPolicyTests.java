     * policy is keyed off is updated. A single operation reads the policy at more than one point, so the
            System.nanoTime(),
                );
            primaryTerm.get(),
            engineUnderTest.close();
    }
                assertEquals("the upstream version must be applied verbatim", 3L, result.getVersion());
    public void testProviderCanSkipCompareAndSwapChecks() throws IOException {
                    "a provider whose seq no. space is owned upstream must not record promotion no-ops",
                // seq no. 7 comes from the upstream authority and must be used verbatim rather than
                // replaced by a locally generated one
        Engine.IndexResult conflicted = engine.index(
import java.io.IOException;
    public void testFillSeqNoGapsOnClosedEngineThrowsUnderNonDefaultProvider() throws IOException {
        assertTrue(
    public void testDefaultProviderFillsSeqNoGaps() throws IOException {
    }
 * compatible open source license.
        assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
            try (InternalEngine engineUnderTest = createEngine(preAssignedSeqNoConfig(store, createTempDir()))) {
                    engineUnderTest.fillSeqNoGaps(primaryTerm.get())
                // leaves gaps at seq nos. 2 and 3
    /**
    public void testRefreshLetsPrimaryAcceptPreAssignedSeqNos() throws IOException {
        }
        engine.index(replicaIndexForDoc(createParsedDoc("1", null), 1L, 1L, false));
                    FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
                // leaves a gap at seq no. 0
                engineUnderTest.index(replicaIndexForDoc(createParsedDoc("2", null), 1L, 4L, false));
                    "the engine must keep using the policy it snapshotted until it is refreshed",
/*
                );
                .build();
                    upstreamIndexForDoc(createParsedDoc("1", null), 7L, 3L, SequenceNumbers.UNASSIGNED_SEQ_NO, 0L)
                );
     * A provider may plan primary-origin operations with replica semantics, so a compare-and-swap the
        }
        assertEquals(1, engine.fillSeqNoGaps(primaryTerm.get()));
            }
}
        }
            ifSeqNo,
                Engine.IndexResult result = defaultEngine.index(indexForDoc(createParsedDoc("1", null)));
     */
                    "the engine must keep serving the policy it snapshotted until it is refreshed",
                    engineUnderTest.getPrimaryOperationPolicy()
            conflicted.getFailure() instanceof VersionConflictEngineException
import org.apache.lucene.store.AlreadyClosedException;
                assertNotSame(DefaultPrimaryOperationPolicy.INSTANCE, engineUnderTest.config().getPrimaryOperationPolicy());
                );
        try (Store store = createStore()) {
                engineUnderTest.index(upstreamIndexForDoc(createParsedDoc("1", null), 1L, 1L, SequenceNumbers.UNASSIGNED_SEQ_NO, 0L));
     * engine must serve a snapshot and pick the change up only when the shard refreshes it with
                assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
     * The whole point of refreshing is that the primary path changes behavior: an operation carrying an
            try (InternalEngine engineUnderTest = createEngine(preAssignedSeqNoConfig(store, createTempDir()))) {
    public void testPolicyChangeIsObservedOnlyOnRefresh() throws IOException {
                    upstreamIndexForDoc(createParsedDoc("1", null), 7L, 3L, SequenceNumbers.UNASSIGNED_SEQ_NO, 0L)
                engineUnderTest.index(replicaIndexForDoc(createParsedDoc("1", null), 1L, 1L, false));
                );
 *
import java.util.concurrent.atomic.AtomicReference;
     */
import org.opensearch.index.VersionType;
            InternalEngine engineUnderTest = createEngine(preAssignedSeqNoConfig(store, createTempDir()));
                // leaves a gap at seq no. 1, which the default provider fills on promotion
        try (Store store = createStore()) {
        }
     * A plugin may change its answer over the lifetime of one engine, for example when the setting its
                .primaryOperationPolicySupplier(pluginPolicy::get)
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
        // leaves a gap at seq no. 0
            }
                // ifSeqNo=99 against an empty engine is an unsatisfiable CAS precondition
                assertEquals(0L, result.getSeqNo());
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.action.index.IndexRequest;
                    0,
                    0,
    public void testProviderThatAcceptsPreAssignedSeqNosPreservesThem() throws IOException {
            "expected a version conflict but got " + conflicted.getFailure(),
            .build();
            InternalEngine engineUnderTest = createEngine(preAssignedSeqNoConfig(store, createTempDir()));
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
                Engine.IndexResult result = engineUnderTest.index(upstreamIndexForDoc(createParsedDoc("1", null), 0L, 1L, 99L, 1L));
    /**
                assertSame(
     */
                assertEquals(7L, result.getSeqNo());
        try (Store store = createStore()) {
    }
                assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
                    FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
     */
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null).toBuilder()
            false,
        try (Store store = createStore()) {
    /**
    }
        assertEquals(Engine.Result.Type.FAILURE, conflicted.getResultType());
    public void testProviderCanSuppressSeqNoGapFilling() throws IOException {
        Engine.IndexResult result = engine.index(indexForDoc(createParsedDoc("1", null)));
        try (Store store = createStore()) {
                assertEquals(1, defaultEngine.fillSeqNoGaps(primaryTerm.get()));
                assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
                assertEquals(
            EngineConfig explicitDefault = config(defaultSettings, store, createTempDir(), newMergePolicy(), null).toBuilder()
     * as a version conflict under the default provider.
                assertEquals("an explicit default provider must generate seq nos. exactly as the implicit one does", 0L, result.getSeqNo());
            try (InternalEngine engineUnderTest = createEngine(config)) {
            Engine.Operation.Origin.PRIMARY,
    }
        return new Engine.Index(
                assertVisibleCount(engineUnderTest, 1);
            doc,
                    engineUnderTest.fillSeqNoGaps(primaryTerm.get())
            }
                    "the config resolves the plugin's new answer immediately",
    }
    public void testRefreshOnClosedEngineThrows() throws IOException {
                assertSame(
        // the standard primary path still generates its own sequence numbers from zero
                .primaryOperationPolicy(DefaultPrimaryOperationPolicy.INSTANCE)
                    config.getPrimaryOperationPolicy()
                );
            version,
    }
    public void testExplicitDefaultProviderMatchesUnset() throws IOException {
                assertEquals(
    private EngineConfig preAssignedSeqNoConfig(Store store, Path translogPath) {
            try (InternalEngine engineUnderTest = createEngine(config)) {
        try (Store store = createStore()) {
                    engineUnderTest.getPrimaryOperationPolicy()
                    "the refresh must install the plugin's new answer",
    private Engine.Index upstreamIndexForDoc(ParsedDocument doc, long seqNo, long version, long ifSeqNo, long ifPrimaryTerm) {
            upstreamIndexForDoc(createParsedDoc("1", null), SequenceNumbers.UNASSIGNED_SEQ_NO, 1L, 99L, 1L)
                Engine.IndexResult result = engineUnderTest.index(
                assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
            try (InternalEngine defaultEngine = createEngine(explicitDefault)) {
                .build();
        );
     * still enforce {@code ensureOpen()}: a closed engine throws rather than silently returning 0.
                pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
        return config(defaultSettings, store, translogPath, newMergePolicy(), null).toBuilder()
            seqNo,
            expectThrows(AlreadyClosedException.class, () -> engineUnderTest.fillSeqNoGaps(primaryTerm.get()));
                engineUnderTest.refreshPrimaryOperationPolicy();
                assertEquals("the upstream seq no. must be applied verbatim after the refresh", 7L, result.getSeqNo());
                assertSame(
                .build();
                    DefaultPrimaryOperationPolicy.INSTANCE,
        );
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
            expectThrows(AlreadyClosedException.class, engineUnderTest::refreshPrimaryOperationPolicy);
        }
                defaultEngine.index(replicaIndexForDoc(createParsedDoc("2", null), 1L, 2L, false));
import org.opensearch.index.mapper.ParsedDocument;
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
    public void testDefaultProviderIsUsedWhenUnset() throws IOException {
                );
    }
 */
                    "the refreshed policy owns its seq no. space upstream, so gaps must not be filled",
            engineUnderTest.close();
        try (Store store = createStore()) {
            .primaryOperationPolicy(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE)
        try (Store store = createStore()) {
                // leaves a gap at seq no. 0
            }
            newUid(doc),
     * upstream-assigned sequence number is only accepted once the refreshed policy is in effect.
package org.opensearch.index.engine;
                Engine.IndexResult result = engineUnderTest.index(
import org.opensearch.index.store.Store;
     * Even when the provider suppresses gap filling, {@link InternalEngine#fillSeqNoGaps(long)} must
            try (InternalEngine engineUnderTest = createEngine(preAssignedSeqNoConfig(store, createTempDir()))) {
        assertEquals(0L, result.getSeqNo());
                .primaryOperationPolicySupplier(pluginPolicy::get)
        assertSame(DefaultPrimaryOperationPolicy.INSTANCE, engine.config().getPrimaryOperationPolicy());
    }
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null).toBuilder()
     * upstream authority already resolved is not re-evaluated locally. The same operation is rejected
    }
        // same precondition on a default-provider engine, with the seq no. left for the engine to assign
            VersionType.EXTERNAL,
public class InternalEnginePrimaryOperationPolicyTests extends EngineTestCase {
            ifPrimaryTerm
            }
        }
    /**
            }
     * operations blocked, rather than resolving the policy per read.
                pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
    /** A primary-origin op carrying an upstream-assigned seq no., as a replication plugin replays. */
                );
import java.nio.file.Path;
        }
                    engineUnderTest.fillSeqNoGaps(primaryTerm.get())
    }
                    1,
        );
    }
                engineUnderTest.refreshPrimaryOperationPolicy();
                assertEquals(
 * this file be licensed under the Apache-2.0 license or a
        }

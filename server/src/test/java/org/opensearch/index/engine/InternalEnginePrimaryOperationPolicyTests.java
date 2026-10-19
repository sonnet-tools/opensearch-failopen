        try (Store store = createStore()) {  
                assertEquals(0L, result.getSeqNo());
                .build();  
    }
        }
 * The OpenSearch Contributors require contributions made to  
                // leaves gaps at seq nos. 2 and 3
        );
 * this file be licensed under the Apache-2.0 license or a
        return config(defaultSettings, store, translogPath, newMergePolicy(), null).toBuilder()  
     * Even when the provider suppresses gap filling, {@link InternalEngine#fillSeqNoGaps(long)} must
    }  
    /**
            System.nanoTime(),  
import org.opensearch.action.index.IndexRequest;
        assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());  
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null).toBuilder()
            VersionType.EXTERNAL,
                // replaced by a locally generated one  
        Engine.IndexResult conflicted = engine.index(
                    1,  
                // leaves a gap at seq no. 1, which the default provider fills on promotion
 * SPDX-License-Identifier: Apache-2.0
                );
        // the standard primary path still generates its own sequence numbers from zero
                assertSame(
     */
                Engine.IndexResult result = engineUnderTest.index(upstreamIndexForDoc(createParsedDoc("1", null), 0L, 1L, 99L, 1L));  
            expectThrows(AlreadyClosedException.class, () -> engineUnderTest.fillSeqNoGaps(primaryTerm.get()));  
                .build();
                );  
            "expected a version conflict but got " + conflicted.getFailure(),  
                assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());  
        }  
        }
                .primaryOperationPolicySupplier(pluginPolicy::get)
                    upstreamIndexForDoc(createParsedDoc("1", null), 7L, 3L, SequenceNumbers.UNASSIGNED_SEQ_NO, 0L)
     * policy is keyed off is updated. A single operation reads the policy at more than one point, so the  
import org.opensearch.index.VersionType;  
            engineUnderTest.close();  
                assertVisibleCount(engineUnderTest, 1);
     * A plugin may change its answer over the lifetime of one engine, for example when the setting its
                // leaves a gap at seq no. 0
    public void testDefaultProviderFillsSeqNoGaps() throws IOException {
                .build();
            try (InternalEngine engineUnderTest = createEngine(config)) {
     * engine must serve a snapshot and pick the change up only when the shard refreshes it with
     */
            .build();
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
                    engineUnderTest.getPrimaryOperationPolicy()
    public void testDefaultProviderIsUsedWhenUnset() throws IOException {
                // ifSeqNo=99 against an empty engine is an unsatisfiable CAS precondition
    private EngineConfig preAssignedSeqNoConfig(Store store, Path translogPath) {
        return new Engine.Index(
        );  
    }
     * The whole point of refreshing is that the primary path changes behavior: an operation carrying an
                engineUnderTest.index(replicaIndexForDoc(createParsedDoc("1", null), 1L, 1L, false));  
                    config.getPrimaryOperationPolicy()  
                Engine.IndexResult result = defaultEngine.index(indexForDoc(createParsedDoc("1", null)));
    public void testExplicitDefaultProviderMatchesUnset() throws IOException {
                assertEquals("the upstream version must be applied verbatim", 3L, result.getVersion());  
import org.opensearch.index.seqno.SequenceNumbers;
     * operations blocked, rather than resolving the policy per read.
            }
    }
        try (Store store = createStore()) {  
                assertEquals(
            Engine.Operation.Origin.PRIMARY,
                assertEquals(
import org.apache.lucene.store.AlreadyClosedException;
            ifSeqNo,  
 *
            engineUnderTest.close();
                Engine.IndexResult result = engineUnderTest.index(
                    "the refreshed policy owns its seq no. space upstream, so gaps must not be filled",
                engineUnderTest.index(upstreamIndexForDoc(createParsedDoc("1", null), 1L, 1L, SequenceNumbers.UNASSIGNED_SEQ_NO, 0L));  
                    "the engine must keep serving the policy it snapshotted until it is refreshed",  
import java.io.IOException;
        }  
                    "the engine must keep using the policy it snapshotted until it is refreshed",
    /**
import org.opensearch.index.store.Store;  
        assertTrue(
                // seq no. 7 comes from the upstream authority and must be used verbatim rather than
            .primaryOperationPolicy(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE)
            seqNo,
            try (InternalEngine engineUnderTest = createEngine(preAssignedSeqNoConfig(store, createTempDir()))) {
        engine.index(replicaIndexForDoc(createParsedDoc("1", null), 1L, 1L, false));  
    public void testPolicyChangeIsObservedOnlyOnRefresh() throws IOException {
                engineUnderTest.refreshPrimaryOperationPolicy();
/*  
    private Engine.Index upstreamIndexForDoc(ParsedDocument doc, long seqNo, long version, long ifSeqNo, long ifPrimaryTerm) {  
                assertNotSame(DefaultPrimaryOperationPolicy.INSTANCE, engineUnderTest.config().getPrimaryOperationPolicy());  
        try (Store store = createStore()) {
        try (Store store = createStore()) {
                    upstreamIndexForDoc(createParsedDoc("1", null), 7L, 3L, SequenceNumbers.UNASSIGNED_SEQ_NO, 0L)
                    "the refresh must install the plugin's new answer",  
            version,  
    public void testRefreshOnClosedEngineThrows() throws IOException {  
        }  
                pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);  
                    engineUnderTest.getPrimaryOperationPolicy()
            InternalEngine engineUnderTest = createEngine(preAssignedSeqNoConfig(store, createTempDir()));
            }  
                engineUnderTest.index(replicaIndexForDoc(createParsedDoc("2", null), 1L, 4L, false));  
        }
        }
                assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
                assertEquals("an explicit default provider must generate seq nos. exactly as the implicit one does", 0L, result.getSeqNo());  
                );
                    0,  
                );  
    }
    public void testFillSeqNoGapsOnClosedEngineThrowsUnderNonDefaultProvider() throws IOException {
     * upstream authority already resolved is not re-evaluated locally. The same operation is rejected
    /**  
     * still enforce {@code ensureOpen()}: a closed engine throws rather than silently returning 0.  
                Engine.IndexResult result = engineUnderTest.index(  
                .primaryOperationPolicySupplier(pluginPolicy::get)  
            EngineConfig config = config(defaultSettings, store, createTempDir(), newMergePolicy(), null).toBuilder()
    }  
                );
                defaultEngine.index(replicaIndexForDoc(createParsedDoc("2", null), 1L, 2L, false));  
                assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
    }
    }  
    public void testRefreshLetsPrimaryAcceptPreAssignedSeqNos() throws IOException {
 * compatible open source license.
        );
                assertEquals(1, defaultEngine.fillSeqNoGaps(primaryTerm.get()));
            ifPrimaryTerm
        }
            false,
import org.opensearch.index.mapper.ParsedDocument;
    public void testProviderCanSkipCompareAndSwapChecks() throws IOException {
            upstreamIndexForDoc(createParsedDoc("1", null), SequenceNumbers.UNASSIGNED_SEQ_NO, 1L, 99L, 1L)
            InternalEngine engineUnderTest = createEngine(preAssignedSeqNoConfig(store, createTempDir()));
        Engine.IndexResult result = engine.index(indexForDoc(createParsedDoc("1", null)));
            try (InternalEngine engineUnderTest = createEngine(preAssignedSeqNoConfig(store, createTempDir()))) {
}
                pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
            }  
 */  
     * upstream-assigned sequence number is only accepted once the refreshed policy is in effect.  
                assertEquals("the upstream seq no. must be applied verbatim after the refresh", 7L, result.getSeqNo());
                assertSame(  
                assertEquals(7L, result.getSeqNo());
        // same precondition on a default-provider engine, with the seq no. left for the engine to assign  
            primaryTerm.get(),
     */  
                assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
                );
                    engineUnderTest.fillSeqNoGaps(primaryTerm.get())
     * A provider may plan primary-origin operations with replica semantics, so a compare-and-swap the
        assertEquals(0L, result.getSeqNo());
            try (InternalEngine defaultEngine = createEngine(explicitDefault)) {  
    public void testProviderThatAcceptsPreAssignedSeqNosPreservesThem() throws IOException {  
    /** A primary-origin op carrying an upstream-assigned seq no., as a replication plugin replays. */
        try (Store store = createStore()) {
                    FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
    }
import java.util.concurrent.atomic.AtomicReference;
package org.opensearch.index.engine;
                engineUnderTest.refreshPrimaryOperationPolicy();
                    "a provider whose seq no. space is owned upstream must not record promotion no-ops",
            }
                    DefaultPrimaryOperationPolicy.INSTANCE,
    }  
                );
            conflicted.getFailure() instanceof VersionConflictEngineException
        // leaves a gap at seq no. 0
        try (Store store = createStore()) {  
        try (Store store = createStore()) {  
            EngineConfig explicitDefault = config(defaultSettings, store, createTempDir(), newMergePolicy(), null).toBuilder()  
            try (InternalEngine engineUnderTest = createEngine(preAssignedSeqNoConfig(store, createTempDir()))) {
                assertEquals(
                assertSame(
                );  
    public void testProviderCanSuppressSeqNoGapFilling() throws IOException {
    }
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);  
public class InternalEnginePrimaryOperationPolicyTests extends EngineTestCase {  
                // leaves a gap at seq no. 0
                    engineUnderTest.fillSeqNoGaps(primaryTerm.get())
        try (Store store = createStore()) {
    /**
            doc,  
import java.nio.file.Path;  
            newUid(doc),
            try (InternalEngine engineUnderTest = createEngine(config)) {
            }  
                    FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
        assertEquals(1, engine.fillSeqNoGaps(primaryTerm.get()));
                    "the config resolves the plugin's new answer immediately",
                .primaryOperationPolicy(DefaultPrimaryOperationPolicy.INSTANCE)
        assertSame(DefaultPrimaryOperationPolicy.INSTANCE, engine.config().getPrimaryOperationPolicy());  
            }
                    0,  
            expectThrows(AlreadyClosedException.class, engineUnderTest::refreshPrimaryOperationPolicy);
                    engineUnderTest.fillSeqNoGaps(primaryTerm.get())
        assertEquals(Engine.Result.Type.FAILURE, conflicted.getResultType());
     * as a version conflict under the default provider.  
     */
    }

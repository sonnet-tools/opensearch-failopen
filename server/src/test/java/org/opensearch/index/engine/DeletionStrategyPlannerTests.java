        assertEquals(Versions.NOT_FOUND, plannedStrategy.version);
            1L
        assertEquals(0, plannedStrategy.reservedDocs);
            1L,
            5L,
        assertFalse(plannedStrategy.addStaleOpToEngine);
        assertFalse(plannedStrategy.executeOpOnEngine);
            (op, refresh) -> null,
            UNASSIGNED_SEQ_NO,
            (op, refresh) -> versionValue,
        assertEquals(Versions.NOT_FOUND, plannedStrategy.version);
        DeletionStrategyPlanner planner = constructDeletionStrategyPlanner(new IndexVersionValue(null, 1L, 1L, 1L));
        DeletionStrategy expectedStrategy = DeletionStrategy.processNormally(false, delete.version(), 0);
        DeletionStrategyPlanner planner = new DeletionStrategyPlanner(
            Engine.Operation.Origin.REPLICA,
            null,
        );
            System.currentTimeMillis(),
            VersionType.INTERNAL,
        Engine.Delete delete = new Engine.Delete(
            5L,
            (op, refresh) -> null,
            System.currentTimeMillis(),
    public void testPlanOperationAsPrimaryVersionConflictForWrites() throws IOException {
            VersionType.INTERNAL,
import java.io.IOException;
        assertFalse(plannedStrategy.executeOpOnEngine);
            2L,
        DeletionStrategy expectedStrategy = DeletionStrategy.processAsStaleOp(delete.version());
        );
            primaryTerm.get(),
        Engine.Delete delete = new Engine.Delete(
            VersionType.EXTERNAL,
            UNASSIGNED_SEQ_NO,
        Engine.Delete delete = new Engine.Delete(
            1L,
        assertFalse(plannedStrategy.earlyResultOnPreFlightError.isPresent());
        );
        DeletionStrategy plannedStrategy = planner.planOperationAsNonPrimary(delete);
            newUid("1"),
    }
        assertEquals(expectedStrategy, plannedStrategy);
            (op, refresh) -> new DeleteVersionValue(1L, 5L, 1L, 1L),
 * SPDX-License-Identifier: Apache-2.0
            Engine.Operation.Origin.REPLICA,
            Engine.Operation.Origin.PRIMARY,
            primaryTerm.get(),
        Engine.Delete delete = new Engine.Delete(
            op -> processedBefore,
        assertFalse(plannedStrategy.addStaleOpToEngine);
            1L,
            (op, docs) -> null,
            "1",
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
}
            primaryTerm.get(),
            3L,
            engine.shardId,
            Engine.Operation.Origin.REPLICA,
            System.currentTimeMillis(),
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);
            "1",
        assertTrue(plannedStrategy.earlyResultOnPreFlightError.isPresent());
            "1",
            primaryTerm.get(),
    public void testPlanOperationAsPrimaryVersionConflictSeqNoMismatch() throws IOException {
        Engine.Delete delete = new Engine.Delete(
            () -> true
        assertEquals(0, plannedStrategy.reservedDocs);
        Settings.Builder settings = Settings.builder()
            Engine.Operation.Origin.REPLICA,
    public void testPlanOperationAsPrimaryVersionConflictDocumentDeleted() throws IOException {
    }
        assertEquals(expectedStrategy, plannedStrategy);
            (op, refresh) -> null,
            newUid("1"),
    public void testPlanOperationAsPrimaryVersionConflict() throws IOException {
        Exception reserveError = new IllegalStateException("Too many documents");
        assertFalse(plannedStrategy.executeOpOnEngine);
        DeletionStrategy expectedStrategy = DeletionStrategy.failAsTooManyDocs(reserveError);
        assertEquals(expectedStrategy, plannedStrategy);
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);
            engine.engineConfig.getIndexSettings(),
        );
        VersionValue versionValue = new IndexVersionValue(null, 2L, 10L, 2L);
            engine.engineConfig.getIndexSettings(),
        assertFalse(plannedStrategy.earlyResultOnPreFlightError.isPresent());
        );
        assertEquals(Versions.NOT_FOUND, plannedStrategy.version);
            Engine.Operation.Origin.REPLICA,
        DeletionStrategy expectedStrategy = DeletionStrategy.processButSkipEngine(false, delete.version());
            UNASSIGNED_SEQ_NO,
        Engine.Delete delete = new Engine.Delete(
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT");
            1L,
        Engine.Delete delete = new Engine.Delete(
            System.currentTimeMillis(),
            1L,
            UNASSIGNED_SEQ_NO,
            System.currentTimeMillis(),
            1L
        assertFalse(plannedStrategy.earlyResultOnPreFlightError.isPresent());
 * this file be licensed under the Apache-2.0 license or a
            UNASSIGNED_SEQ_NO,
        assertFalse(plannedStrategy.executeOpOnEngine);
            "1",
        assertTrue(plannedStrategy.earlyResultOnPreFlightError.isPresent());
    }
    public void testPlanOperationAsNonPrimaryProcessAsStaleOp() throws IOException {
    private DeletionStrategyPlanner constructDeletionStrategyPlannerForNonPrimary(boolean processedBefore, OpVsEngineDocStatus docStatus) {
        assertEquals(0, plannedStrategy.reservedDocs);
        assertEquals(Versions.NOT_FOUND, plannedStrategy.version);
            newUid("1"),
            newUid("1"),
 */
            "1",
            UNASSIGNED_PRIMARY_TERM
            "1",
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
        );
        Engine.Delete delete = new Engine.Delete(
        assertEquals(expectedStrategy, plannedStrategy);
    }
        );
            engineConfig.getIndexSettings(),
        DeletionStrategyPlanner planner = constructDeletionStrategyPlannerForNonPrimary(false, OpVsEngineDocStatus.OP_STALE_OR_EQUAL);
 * The OpenSearch Contributors require contributions made to
            null,
        );
        DeletionStrategyPlanner planner = constructDeletionStrategyPlanner(new DeleteVersionValue(1L, 5L, 1L, 1L));
            () -> true
            VersionType.INTERNAL,
            System.currentTimeMillis(),
            replicaEngine.shardId,
        );
        EngineConfig engineConfig = config(indexSettings, store, createTempDir(), newMergePolicy(), null);
        return new DeletionStrategyPlanner(
            op -> false,
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);
            null,
        DeletionStrategyPlanner planner = constructDeletionStrategyPlanner(new DeleteVersionValue(1L, 5L, 1L, 1L));
    public void testPlanOperationAsNonPrimaryWithSegRepEnabled() throws IOException {
/*
        Engine.Delete delete = new Engine.Delete(
    }
            newUid("1"),
            null,
        );
        assertEquals(0, plannedStrategy.reservedDocs);
            newUid("1"),
            () -> true
            (op, docs) -> null,
            op -> false,
        );
            "1",
            1L
        DeletionStrategy expectedStrategy = DeletionStrategy.processNormally(true, 2, 1);
 *
public class DeletionStrategyPlannerTests extends EngineTestCase {
import org.opensearch.common.settings.Settings;
    public void testPlanOperationAsNonPrimaryProcessNormallyDocumentExists() throws IOException {
import org.opensearch.test.IndexSettingsModule;
            .put(defaultSettings.getSettings())
            newUid("1"),
        assertFalse(plannedStrategy.currentlyDeleted);
        );
        assertFalse(plannedStrategy.addStaleOpToEngine);
            UNASSIGNED_SEQ_NO,
        DeletionStrategy plannedStrategy = planner.planOperationAsNonPrimary(delete);
    public void testPlanOperationAsPrimary() throws IOException {
            replicaEngine.engineConfig.getIndexSettings(),
            System.currentTimeMillis(),
    }
        Engine.Delete delete = new Engine.Delete(
            UNASSIGNED_SEQ_NO,
            primaryTerm.get(),
        DeletionStrategyPlanner planner = constructDeletionStrategyPlannerForNonPrimary(false, OpVsEngineDocStatus.DOC_NOT_FOUND);
            System.currentTimeMillis(),
            UNASSIGNED_SEQ_NO,
import org.opensearch.common.lucene.uid.Versions;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
            replicaEngine.shardId,
            primaryTerm.get(),
            Engine.Operation.Origin.PRIMARY,
            replicaEngine.shardId,
            "1",
            UNASSIGNED_SEQ_NO,
            UNASSIGNED_SEQ_NO,
            Engine.Operation.Origin.PRIMARY,
            () -> true
        assertTrue(plannedStrategy.earlyResultOnPreFlightError.isPresent());
            UNASSIGNED_SEQ_NO,
        DeletionStrategyPlanner planner = constructDeletionStrategyPlanner(versionValue);
        assertEquals(expectedStrategy, plannedStrategy);
        DeletionStrategyPlanner planner = new DeletionStrategyPlanner(
            primaryTerm.get(),
            Engine.Operation.Origin.PRIMARY,
            UNASSIGNED_SEQ_NO,
            UNASSIGNED_SEQ_NO,
            op -> false,
            VersionType.INTERNAL,
        assertFalse(plannedStrategy.currentlyDeleted);
            UNASSIGNED_SEQ_NO,
        DeletionStrategyPlanner planner = new DeletionStrategyPlanner(
            UNASSIGNED_PRIMARY_TERM
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);
            Engine.Operation.Origin.PRIMARY,
            2L,
            (op, docs) -> reserveError,
            0L
 * compatible open source license.
            newUid("1"),
            op -> OpVsEngineDocStatus.DOC_NOT_FOUND,
            UNASSIGNED_SEQ_NO,
            (op, docs) -> null,
            op -> OpVsEngineDocStatus.OP_NEWER,
import org.opensearch.index.VersionType;
            newUid("1"),
            engine.shardId,
    }
            0L
            "1",
        DeletionStrategy plannedStrategy = planner.planOperationAsNonPrimary(delete);
            newUid("1"),
        assertTrue(plannedStrategy.earlyResultOnPreFlightError.isPresent());
        assertFalse(plannedStrategy.earlyResultOnPreFlightError.isPresent());
            "1",
            UNASSIGNED_PRIMARY_TERM
            (op, docs) -> null,
            primaryTerm.get(),
            op -> OpVsEngineDocStatus.DOC_NOT_FOUND,
            op -> OpVsEngineDocStatus.OP_STALE_OR_EQUAL,
        DeletionStrategy plannedStrategy = planner.planOperationAsNonPrimary(delete);
    public void testPlanOperationAsPrimaryFailAsTooManyDocs() throws IOException {
        DeletionStrategy plannedStrategy = planner.planOperationAsNonPrimary(delete);
    }
        );
    }
            UNASSIGNED_SEQ_NO,
    public void testPlanOperationAsNonPrimaryProcessedBefore() throws IOException {
import org.opensearch.index.IndexSettings;
            System.currentTimeMillis(),
            System.currentTimeMillis(),
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);
            newUid("1"),
            op -> false,
            Engine.Operation.Origin.PRIMARY,
            primaryTerm.get(),
            op -> docStatus,
            0L
            () -> true
        DeletionStrategy expectedStrategy = DeletionStrategy.processButSkipEngine(false, delete.version());
        assertTrue(plannedStrategy.currentlyDeleted);
        assertTrue(plannedStrategy.earlyResultOnPreFlightError.isPresent());
            UNASSIGNED_PRIMARY_TERM
            null,
package org.opensearch.index.engine;
        );
            1L,
            1L,
            primaryTerm.get(),
        assertFalse(plannedStrategy.earlyResultOnPreFlightError.isPresent());
            VersionType.INTERNAL,
        return new DeletionStrategyPlanner(
            10L,
            1L,
            primaryTerm.get(),
        assertTrue(plannedStrategy.currentlyDeleted);
        Engine.Delete delete = new Engine.Delete(
            0L
            10L,
    }
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
        DeletionStrategyPlanner planner = constructDeletionStrategyPlanner(new DeleteVersionValue(1L, 5L, 1L, 1L));
            "1",
    }
            1L,
        assertEquals(expectedStrategy, plannedStrategy);
            UNASSIGNED_SEQ_NO,
        DeletionStrategyPlanner planner = constructDeletionStrategyPlannerForNonPrimary(true, OpVsEngineDocStatus.DOC_NOT_FOUND);
import org.opensearch.cluster.metadata.IndexMetadata;
        );
        assertFalse(plannedStrategy.addStaleOpToEngine);
    private DeletionStrategyPlanner constructDeletionStrategyPlanner(VersionValue versionValue) {
        assertEquals(expectedStrategy, plannedStrategy);
    public void testPlanOperationAsNonPrimaryProcessNormally() throws IOException {
    }
            System.currentTimeMillis(),
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);
        );
    }
            replicaEngine.engineConfig.getIndexSettings(),
        DeletionStrategy expectedStrategy = DeletionStrategy.processNormally(true, delete.version(), 0);

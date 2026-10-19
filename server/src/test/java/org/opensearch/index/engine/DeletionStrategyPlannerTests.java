        assertFalse(plannedStrategy.addStaleOpToEngine);
        DeletionStrategyPlanner planner = constructDeletionStrategyPlannerForNonPrimary(false, OpVsEngineDocStatus.OP_STALE_OR_EQUAL);
        VersionValue versionValue = new IndexVersionValue(null, 2L, 10L, 2L);
            newUid("1"),
            () -> true
            0L
    }  
        assertEquals(Versions.NOT_FOUND, plannedStrategy.version);  
        assertTrue(plannedStrategy.earlyResultOnPreFlightError.isPresent());
            System.currentTimeMillis(),
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);  
    }  
            0L
            replicaEngine.engineConfig.getIndexSettings(),  
/*  
    }  
            op -> OpVsEngineDocStatus.DOC_NOT_FOUND,  
        DeletionStrategy expectedStrategy = DeletionStrategy.failAsTooManyDocs(reserveError);
            2L,  
            System.currentTimeMillis(),  
            primaryTerm.get(),  
        DeletionStrategyPlanner planner = new DeletionStrategyPlanner(
            op -> false,
import org.opensearch.cluster.metadata.IndexMetadata;
        Engine.Delete delete = new Engine.Delete(  
            Engine.Operation.Origin.REPLICA,
        assertEquals(expectedStrategy, plannedStrategy);  
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);
            1L,
            1L,
            (op, refresh) -> null,
    public void testPlanOperationAsNonPrimaryProcessedBefore() throws IOException {  
        assertTrue(plannedStrategy.currentlyDeleted);
        );
            "1",
        Engine.Delete delete = new Engine.Delete(
    public void testPlanOperationAsNonPrimaryProcessNormally() throws IOException {
            primaryTerm.get(),
package org.opensearch.index.engine;
        EngineConfig engineConfig = config(indexSettings, store, createTempDir(), newMergePolicy(), null);  
            primaryTerm.get(),
        );  
            primaryTerm.get(),  
            (op, docs) -> null,
    }
        assertEquals(0, plannedStrategy.reservedDocs);
        Engine.Delete delete = new Engine.Delete(
            3L,
        DeletionStrategyPlanner planner = constructDeletionStrategyPlanner(new DeleteVersionValue(1L, 5L, 1L, 1L));  
            UNASSIGNED_SEQ_NO,  
            (op, refresh) -> null,  
            "1",
        assertEquals(expectedStrategy, plannedStrategy);  
    }
            UNASSIGNED_SEQ_NO,
            engine.engineConfig.getIndexSettings(),  
        DeletionStrategyPlanner planner = new DeletionStrategyPlanner(
            UNASSIGNED_PRIMARY_TERM
        DeletionStrategy plannedStrategy = planner.planOperationAsNonPrimary(delete);
 */  
            UNASSIGNED_SEQ_NO,
            engineConfig.getIndexSettings(),  
        assertEquals(0, plannedStrategy.reservedDocs);
        );  
            UNASSIGNED_SEQ_NO,  
            "1",
        assertFalse(plannedStrategy.earlyResultOnPreFlightError.isPresent());
    }
            op -> OpVsEngineDocStatus.OP_STALE_OR_EQUAL,  
            primaryTerm.get(),
        assertTrue(plannedStrategy.earlyResultOnPreFlightError.isPresent());  
            newUid("1"),  
        assertEquals(expectedStrategy, plannedStrategy);
        );
            1L,  
    private DeletionStrategyPlanner constructDeletionStrategyPlanner(VersionValue versionValue) {
import org.opensearch.index.VersionType;
            VersionType.INTERNAL,  
    }
        Engine.Delete delete = new Engine.Delete(
            Engine.Operation.Origin.PRIMARY,
        DeletionStrategy expectedStrategy = DeletionStrategy.processButSkipEngine(false, delete.version());
            null,  
public class DeletionStrategyPlannerTests extends EngineTestCase {
            "1",  
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT");  
        Engine.Delete delete = new Engine.Delete(  
        );
        Engine.Delete delete = new Engine.Delete(
            "1",
        assertFalse(plannedStrategy.executeOpOnEngine);  
            0L  
            UNASSIGNED_SEQ_NO,
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);
        Engine.Delete delete = new Engine.Delete(  
        assertTrue(plannedStrategy.earlyResultOnPreFlightError.isPresent());  
            op -> processedBefore,
            Engine.Operation.Origin.PRIMARY,
        );  
import java.io.IOException;
        assertEquals(Versions.NOT_FOUND, plannedStrategy.version);  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
            0L
            System.currentTimeMillis(),
            newUid("1"),  
            UNASSIGNED_SEQ_NO,  
        assertEquals(expectedStrategy, plannedStrategy);
        assertEquals(Versions.NOT_FOUND, plannedStrategy.version);
        assertFalse(plannedStrategy.earlyResultOnPreFlightError.isPresent());  
            newUid("1"),
        assertTrue(plannedStrategy.earlyResultOnPreFlightError.isPresent());
            (op, refresh) -> null,
            VersionType.EXTERNAL,
            null,
            replicaEngine.shardId,
            newUid("1"),
            newUid("1"),
            (op, docs) -> null,
        DeletionStrategy plannedStrategy = planner.planOperationAsNonPrimary(delete);  
            UNASSIGNED_SEQ_NO,
            primaryTerm.get(),
    public void testPlanOperationAsNonPrimaryWithSegRepEnabled() throws IOException {  
            UNASSIGNED_SEQ_NO,
            Engine.Operation.Origin.REPLICA,
            System.currentTimeMillis(),
            System.currentTimeMillis(),  
        assertEquals(expectedStrategy, plannedStrategy);
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);
import org.opensearch.common.settings.Settings;  
        assertFalse(plannedStrategy.earlyResultOnPreFlightError.isPresent());
        final IndexMetadata indexMetadata = IndexMetadata.builder(defaultSettings.getIndexMetadata()).settings(settings).build();
    public void testPlanOperationAsPrimaryVersionConflictSeqNoMismatch() throws IOException {  
    public void testPlanOperationAsPrimaryFailAsTooManyDocs() throws IOException {  
            UNASSIGNED_PRIMARY_TERM  
            System.currentTimeMillis(),
            "1",  
            op -> OpVsEngineDocStatus.OP_NEWER,
            System.currentTimeMillis(),
        DeletionStrategy expectedStrategy = DeletionStrategy.processNormally(true, 2, 1);
 * SPDX-License-Identifier: Apache-2.0
        DeletionStrategyPlanner planner = constructDeletionStrategyPlanner(new DeleteVersionValue(1L, 5L, 1L, 1L));  
            primaryTerm.get(),
            10L,  
            replicaEngine.shardId,  
        DeletionStrategyPlanner planner = constructDeletionStrategyPlanner(versionValue);
            UNASSIGNED_SEQ_NO,  
        assertEquals(Versions.NOT_FOUND, plannedStrategy.version);
    public void testPlanOperationAsPrimaryVersionConflictForWrites() throws IOException {
            UNASSIGNED_SEQ_NO,
            (op, docs) -> reserveError,
            VersionType.INTERNAL,
    }
            newUid("1"),
        DeletionStrategy expectedStrategy = DeletionStrategy.processAsStaleOp(delete.version());
            "1",  
    }
            5L,
            UNASSIGNED_SEQ_NO,
            "1",  
            () -> true  
        DeletionStrategyPlanner planner = constructDeletionStrategyPlannerForNonPrimary(false, OpVsEngineDocStatus.DOC_NOT_FOUND);  
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);
            () -> true  
            UNASSIGNED_PRIMARY_TERM
            op -> docStatus,  
    public void testPlanOperationAsPrimary() throws IOException {  
            System.currentTimeMillis(),
        DeletionStrategy plannedStrategy = planner.planOperationAsNonPrimary(delete);  
            "1",
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
            1L,  
            1L,
            null,  
            "1",
            .put(defaultSettings.getSettings())
 * compatible open source license.
    }
        assertEquals(0, plannedStrategy.reservedDocs);
 * The OpenSearch Contributors require contributions made to  
            newUid("1"),
            engine.engineConfig.getIndexSettings(),  
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexMetadata);
            System.currentTimeMillis(),
            op -> false,
            primaryTerm.get(),  
            Engine.Operation.Origin.REPLICA,
        assertFalse(plannedStrategy.addStaleOpToEngine);  
            op -> OpVsEngineDocStatus.DOC_NOT_FOUND,  
            (op, refresh) -> new DeleteVersionValue(1L, 5L, 1L, 1L),
            Engine.Operation.Origin.PRIMARY,  
            5L,
            1L,
        return new DeletionStrategyPlanner(
            primaryTerm.get(),  
        assertFalse(plannedStrategy.executeOpOnEngine);  
        assertFalse(plannedStrategy.currentlyDeleted);
            (op, refresh) -> versionValue,
        DeletionStrategyPlanner planner = new DeletionStrategyPlanner(
        Engine.Delete delete = new Engine.Delete(
            newUid("1"),
            Engine.Operation.Origin.PRIMARY,
        Engine.Delete delete = new Engine.Delete(  
        DeletionStrategy plannedStrategy = planner.planOperationAsNonPrimary(delete);
        Exception reserveError = new IllegalStateException("Too many documents");
        );
            primaryTerm.get(),
            System.currentTimeMillis(),  
}  
            engine.shardId,
            null,
 * this file be licensed under the Apache-2.0 license or a
        );
        DeletionStrategy expectedStrategy = DeletionStrategy.processButSkipEngine(false, delete.version());
        );
        assertFalse(plannedStrategy.currentlyDeleted);
    public void testPlanOperationAsNonPrimaryProcessAsStaleOp() throws IOException {
        assertFalse(plannedStrategy.addStaleOpToEngine);
            2L,
            replicaEngine.engineConfig.getIndexSettings(),
        assertFalse(plannedStrategy.executeOpOnEngine);
            Engine.Operation.Origin.PRIMARY,
        DeletionStrategyPlanner planner = constructDeletionStrategyPlanner(new IndexVersionValue(null, 1L, 1L, 1L));
            1L,
            newUid("1"),
            "1",
            UNASSIGNED_SEQ_NO,
        );
        );
        assertEquals(0, plannedStrategy.reservedDocs);
            op -> false,
    }
            10L,  
    }
 *
            VersionType.INTERNAL,
    }
            1L  
        );
    public void testPlanOperationAsNonPrimaryProcessNormallyDocumentExists() throws IOException {  
        DeletionStrategy plannedStrategy = planner.planOperationAsNonPrimary(delete);
        Engine.Delete delete = new Engine.Delete(
        return new DeletionStrategyPlanner(
            UNASSIGNED_SEQ_NO,
        DeletionStrategy expectedStrategy = DeletionStrategy.processNormally(false, delete.version(), 0);  
        DeletionStrategy plannedStrategy = planner.planOperationAsPrimary(delete);  
        assertFalse(plannedStrategy.earlyResultOnPreFlightError.isPresent());
            (op, docs) -> null,
            1L
        assertEquals(expectedStrategy, plannedStrategy);  
import org.opensearch.test.IndexSettingsModule;  
        assertFalse(plannedStrategy.executeOpOnEngine);
        );
            UNASSIGNED_SEQ_NO,  
        assertEquals(expectedStrategy, plannedStrategy);  
    private DeletionStrategyPlanner constructDeletionStrategyPlannerForNonPrimary(boolean processedBefore, OpVsEngineDocStatus docStatus) {
            Engine.Operation.Origin.REPLICA,  
        );
            primaryTerm.get(),
            VersionType.INTERNAL,
            UNASSIGNED_PRIMARY_TERM  
            UNASSIGNED_SEQ_NO,  
            op -> false,
        assertFalse(plannedStrategy.addStaleOpToEngine);  
            UNASSIGNED_SEQ_NO,
            1L
        assertFalse(plannedStrategy.earlyResultOnPreFlightError.isPresent());  
            VersionType.INTERNAL,  
            () -> true  
            replicaEngine.shardId,
            () -> true  
        Settings.Builder settings = Settings.builder()
        assertTrue(plannedStrategy.currentlyDeleted);
            UNASSIGNED_SEQ_NO,
        );
        assertTrue(plannedStrategy.earlyResultOnPreFlightError.isPresent());
            1L,
        DeletionStrategyPlanner planner = constructDeletionStrategyPlannerForNonPrimary(true, OpVsEngineDocStatus.DOC_NOT_FOUND);
            1L,
    public void testPlanOperationAsPrimaryVersionConflict() throws IOException {
            engine.shardId,
import org.opensearch.common.lucene.uid.Versions;
            newUid("1"),  
import org.opensearch.index.IndexSettings;
        Engine.Delete delete = new Engine.Delete(
            Engine.Operation.Origin.PRIMARY,  
            System.currentTimeMillis(),
        DeletionStrategyPlanner planner = constructDeletionStrategyPlanner(new DeleteVersionValue(1L, 5L, 1L, 1L));
            null,
        );  
        DeletionStrategy expectedStrategy = DeletionStrategy.processNormally(true, delete.version(), 0);  
            (op, docs) -> null,
    public void testPlanOperationAsPrimaryVersionConflictDocumentDeleted() throws IOException {
            Engine.Operation.Origin.REPLICA,  

        PrimaryOperationPolicy provider = DefaultPrimaryOperationPolicy.INSTANCE;
        RecordingPlanner<Engine.Index, IndexingStrategy> indexPlanner = new RecordingPlanner<>();
 * SPDX-License-Identifier: Apache-2.0
        Engine.Index index = primaryIndex(SequenceNumbers.UNASSIGNED_SEQ_NO);
    }
        DefaultPrimaryOperationPolicy.INSTANCE.planDelete(deletePlanner, delete);  
            new Term(IdFieldMapper.NAME, "1"),  
 */
            5L,
        T asNonPrimary;
        T asPrimary;  
            asNonPrimary = operation;
    public void testDefaultPolicyCapabilities() {
}
 * compatible open source license.
            seqNo,
            3L,
            return null;  
    public void testDefaultPolicyPlansAsPrimaryWithoutCopying() throws IOException {  
        public V planOperationAsPrimary(T operation) throws IOException {
            System.nanoTime(),  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        assertNull(indexPlanner.asNonPrimary);
            3L
            new Term(IdFieldMapper.NAME, "1"),  
import org.opensearch.index.VersionType;
            System.nanoTime(),
        RecordingPlanner<Engine.Delete, DeletionStrategy> deletePlanner = new RecordingPlanner<>();
        );  
import org.opensearch.index.mapper.IdFieldMapper;  
        return new Engine.Delete(
        DefaultPrimaryOperationPolicy.INSTANCE.planIndex(indexPlanner, index);  
            VersionType.INTERNAL,
import org.opensearch.index.seqno.SequenceNumbers;
            "route-1"  
/*  
    }  
 */  
        }
            5L,  
/**  
            null,
            asPrimary = operation;
    }
            Engine.Operation.Origin.PRIMARY,  
package org.opensearch.index.engine;
        assertSame(delete, deletePlanner.asPrimary);
 * this file be licensed under the Apache-2.0 license or a
        public V planOperationAsNonPrimary(T operation) throws IOException {
            seqNo,
            7L,
    private static Engine.Index primaryIndex(long seqNo) {
 *
            "1",
        return new Engine.Index(
            VersionType.INTERNAL,
import org.apache.lucene.index.Term;
        Engine.Delete delete = primaryDelete(SequenceNumbers.UNASSIGNED_SEQ_NO);
            Engine.Operation.Origin.PRIMARY,
    }
import java.io.IOException;
        implements
            return null;  
        @Override  
        assertFalse(provider.acceptsPreAssignedSeqNos());  
    /** Captures which planning path was invoked and with what operation. */
    }
    private static Engine.Delete primaryDelete(long seqNo) {  
            2L,  
            -1L,
            2L,
        );
        assertNull(deletePlanner.asNonPrimary);
            false,  
 * operation, without needing a live engine.
        }
            OperationStrategyPlanner<T, V> {
        @Override  
            7L,
        assertSame("default provider must pass the operation through untouched", index, indexPlanner.asPrimary);
public class PrimaryOperationPolicyTests extends OpenSearchTestCase {  
 * {@link PrimaryOperationPolicy} interface gives plugin implementations. Planning is verified
 * against a recording planner so the tests assert which planning path was taken and with which  
    private static class RecordingPlanner<T extends Engine.Operation, V extends OperationStrategy>  
 * Tests {@link DefaultPrimaryOperationPolicy}, the only provider core owns, and the defaults the

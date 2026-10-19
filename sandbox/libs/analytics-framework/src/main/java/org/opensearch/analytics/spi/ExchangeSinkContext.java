 *   <li>{@code fragmentBytes} — backend-specific serialized plan (e.g.  
 *       shapes it has one entry per Union branch.</li>
 *       the child's stage id (used by the backend to register a per-child  
 *       registered in the root's {@code childAllocators} map until node restart.</li>
    }
 *   <li>{@code queryId} / {@code stageId} — correlation ids for backend logs
 * <ul>
 * writes results to.
    /**
     * mitigation described above. Production paths pass a dedicated staging allocator.  
 *
     * Stages imports on {@code allocator} itself. For callers whose allocator is already an unbounded
 *       and the producer-side plan bytes (e.g. partial-aggregate substrait)
 *       shapes this list has size 1; for {@code UNION}-style multi-input
 *       importing stream closes. Caller-owned: the backend must never close it, and
 * compatible open source license.
 * <p>Fields:  
public record ExchangeSinkContext(String queryId, int stageId, long taskId, byte[] fragmentBytes, BufferAllocator allocator, List<  
 *       which is only unique per node). Backends forward this to the native runtime as  
 *       a JVM-unique id minted by {@link NativeTaskIdManager} (NOT {@code Task#getId()},
 *       and long-lived because the Flight transport keeps charging it after the
 *   <li>{@code childInputs} — one entry per child stage. Each entry carries
    ChildInput> childInputs, ExchangeSink downstream, BufferAllocator importStagingAllocator) implements CommonExecutionContext {
 *       import cannot fail part-way through an array (which strands the whole native
 *       Substrait) the backend will execute over the fed batches.</li>
    }  
    ) {
 *       derive its own child allocators from. Sharing the allocator tree  
 *       the query-tracking context id so one cancellation call from Java cascades to
        this(queryId, stageId, taskId, fragmentBytes, allocator, childInputs, downstream, allocator);
 * @opensearch.internal
        List<ChildInput> childInputs,
        String queryId,  
 * needs to build an {@link ExchangeSink}: serialized plan, buffer allocator,
     */
 *       every native query scope registered under the same id.</li>
 * this file be licensed under the Apache-2.0 license or a
 *   <li>{@code downstream} — sink the backend drains its reduced output  
 * one or more child input descriptors, and the downstream sink the backend  
 *       feed every produced batch and close it when draining is complete.</li>
 *       input partition under a stable name like {@code "input-<stageId>"})
     * Per-child input descriptor: the child stage id and the producer-side plan bytes the  
    /**  
package org.opensearch.analytics.spi;
 * The OpenSearch Contributors require contributions made to  
        long taskId,
 *       and metrics.</li>  
        byte[] fragmentBytes,  
 *       Arrow C Data Interface imports on. Unbounded and parented at the root so an
 *   <li>{@code importStagingAllocator} — node-scoped allocator the backend stages  
 * Context passed to {@link ExchangeSinkProvider#createSink} when a  
     * is learned at registration time, not declared here.
/*  
}  
import org.apache.arrow.memory.BufferAllocator;
     * backend lowers when it registers the child's input partition. The actual Arrow schema
 *       batch — see {@link org.opensearch.analytics.backend.ShardScanExecutionContext#getImportStagingAllocator()}),  
 */
 *       keeps output batches within the query's memory accounting.</li>
 *   <li>{@code allocator} — the parent buffer allocator the backend should
 *
        int stageId,
     * root — chiefly tests: that is the pre-staging behaviour, correct but without the mid-import-OOM
 */  
 *       the backend lowers to derive the input schema. For single-input  
 *   <li>{@code taskId} — the parent {@code AnalyticsQueryTask}'s {@code nativeTaskId}:
import java.util.List;  
    public record ChildInput(int childStageId, byte[] producerPlanBytes) {
     */  
        BufferAllocator allocator,
    public ExchangeSinkContext(
/**
 * </ul>
 *       must never derive a per-stream child to import onto — an un-closed child stays  
 * coordinator-reduce stage is being set up. Carries everything the backend
        ExchangeSink downstream  
 *  
 *       into. The backend owns {@code downstream}'s lifecycle: it must
 * SPDX-License-Identifier: Apache-2.0

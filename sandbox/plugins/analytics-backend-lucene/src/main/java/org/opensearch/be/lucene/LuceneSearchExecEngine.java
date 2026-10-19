import org.opensearch.analytics.backend.EngineResultStream;
                BigIntVector v = (BigIntVector) scratch.getVector(i);
            context.getShardId(),
     * contract: the populated {@link ArrowArray} is what {@link LuceneResultStream}
        VectorSchemaRoot scratch = VectorSchemaRoot.create(schema, allocator);  
        List<Field> fields = new ArrayList<>(columnNames.size());
 * <p>Today's only operation is the count fast path —
 *  
        Schema schema,  
    @Override
     * re-imports into its result VSR — same call shape DataFusion uses for native batches.
        if (stagingAllocator == null) {
import org.apache.arrow.c.ArrowSchema;
                    array.close();
 * this file be licensed under the Apache-2.0 license or a
        for (String name : columnNames) {  
 * correct under deletes, just slower. Even the slow case is substantially cheaper than
    }
        // need to assemble plans from the context (e.g. DataFusion); Lucene has nothing to do.
 * <p>No deletes gate. {@code IndexSearcher.count} is self-healing: per-leaf
            scratch.setRowCount(1);
            "[lucene-count] shardId={} query={} count={} columns={}",  
        LOGGER.debug(
/**
                    arrowSchema.close();  
 * the framework drains into the Flight transport.
            }  
 * {@link org.apache.lucene.search.IndexSearcher#count(org.apache.lucene.search.Query)} —
        boolean transferred = false;
        ArrowArray array = ArrowArray.allocateNew(allocator);
import org.apache.arrow.vector.BigIntVector;  
 * see {@link LuceneResultStream} for the detailed comparison.  
 * Lucene-side {@link SearchExecEngine}. Mirrors {@code DatafusionSearchExecEngine}'s role
    }
        return new Schema(fields);  
 * {@code setSafe}-built VSRs don't survive Flight's {@code VectorTransfer.transferRoot};
import org.apache.arrow.c.Data;
            count,  
            return stream;  
    }  
        long count = state.searcher().count(state.filterQuery());
     * closes the scratch VSR. Mirrors the export side of {@code DatafusionResultStream}'s  
 * DataFusion decoding rows.
        // handler. {@code prepare} is part of the SearchExecEngine contract for backends that
    private static void populateBatchToCData(
        try {
    LuceneSearchExecEngine(LuceneSearcherState state) {  
 * {@code Weight.count(leaf)} returns -1 on dirty leaves and falls back to full iteration —  
import java.io.IOException;  
 * instruction handler, executes the operation, and returns an {@link EngineResultStream}
        BufferAllocator allocator = context.getAllocator();  
import org.apache.arrow.vector.types.pojo.FieldType;
 * foreign-allocation-managed buffer layout DataFusion's result stream produces. Pure-Java
import org.apache.arrow.memory.BufferAllocator;
        } finally {
/*  
 * exported through the Arrow C-Data interface so the result VSR has the same  
 * SPDX-License-Identifier: Apache-2.0
 */
     */  
                try {  
            LuceneResultStream stream = new LuceneResultStream(array, arrowSchema, allocator, stagingAllocator);
        // Node-scoped and unbounded — the batch is imported onto it and the Flight transport keeps charging it
        }  
                }
import org.apache.arrow.c.ArrowArray;
            state.outputColumnNames()
 * compatible open source license.
        // No preparation needed — the LuceneSearcherState was fully built by the instruction  
        try {
import org.apache.arrow.vector.types.pojo.Schema;
            if (transferred == false) {
            state.filterQuery(),
        BufferAllocator allocator,
    private final LuceneSearcherState state;
            try (CDataDictionaryProvider dictProvider = new CDataDictionaryProvider()) {
            }
            }
                Data.exportVectorSchemaRoot(allocator, scratch, dictProvider, array, arrowSchema);  
        List<String> columnNames,
 *
 *  
 *
     * the supplied {@code array}/{@code arrowSchema} via the Arrow C-Data interface, then
        this.state = state;
        long count,
            transferred = true;
import org.apache.arrow.vector.types.pojo.Field;  
import org.opensearch.analytics.backend.SearchExecEngine;  
     * Builds a one-row scratch VSR carrying {@code count} for every column, exports it to
    @Override
import java.util.ArrayList;
            for (int i = 0; i < columnNames.size(); i++) {  
    public EngineResultStream execute(ShardScanExecutionContext context) throws IOException {  
            populateBatchToCData(allocator, schema, state.outputColumnNames(), count, array, arrowSchema);  
import org.apache.logging.log4j.LogManager;  
    private static Schema buildSchema(List<String> columnNames) {  
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
            scratch.close();  
        Schema schema = buildSchema(state.outputColumnNames());
import org.apache.logging.log4j.Logger;
import java.util.List;
 * for the Lucene backend: takes the {@link LuceneSearcherState} produced upstream by the  
                v.setSafe(0, count);
        ArrowSchema arrowSchema
        } finally {
import org.apache.arrow.c.CDataDictionaryProvider;  
import org.opensearch.analytics.backend.ShardScanExecutionContext;
            throw new IllegalStateException("ExecutionContext.importStagingAllocator must be set by the caller before execute()");
package org.opensearch.be.lucene;
        ArrowArray array,  
import org.apache.arrow.vector.VectorSchemaRoot;
}  
        }
        // after this stream closes, so it must be supplied rather than minted per stream.
                } finally {
import org.apache.arrow.vector.types.pojo.ArrowType;
    }
    ) {
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);  
        BufferAllocator stagingAllocator = context.getImportStagingAllocator();  
final class LuceneSearchExecEngine implements SearchExecEngine<ShardScanExecutionContext, EngineResultStream> {  
        }  
    }
    /**  
 */  
            fields.add(new Field(name, int64Nullable, null));
        );
        FieldType int64Nullable = new FieldType(true, new ArrowType.Int(64, true), null);
    public void prepare(ShardScanExecutionContext context) {
    private static final Logger LOGGER = LogManager.getLogger(LuceneSearchExecEngine.class);
            scratch.allocateNew();
        }

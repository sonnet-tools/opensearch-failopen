        return new LuceneSearcherState(searcher, decoded.filterQuery, decoded.columnNames);
            } else {  
import org.opensearch.analytics.spi.CommonExecutionContext;
        IndexSearcher searcher = luceneReader.searcher(shardCtx.getQueryCache(), shardCtx.getQueryCachingPolicy());
/*  
/**
 * Lucene-side shard-scan instruction handler. Reads a {@link ShardScanInstructionNode}
        // Shared per-reader searcher (see LuceneReader#searcher).
 * @opensearch.internal
import org.apache.logging.log4j.LogManager;
 * compatible open source license.
     * {@code [columnNames String[]] [hasFilter boolean] [QueryBuilder NamedWriteable]?}.  
     * happen on the Lucene-driver path but stays safe if the wire shape ever drifts).
import org.opensearch.analytics.spi.BackendExecutionContext;
import org.opensearch.analytics.spi.FragmentInstructionHandler;  
        Decoded decoded = decodeFragmentBytes(shardCtx, searcher);  
            if (hasFilter) {
        }
            Query filterQuery;
    }
    /**
            boolean hasFilter = input.readBoolean();  
 */
                // the Lucene-driver scan path (count + non-count) executed by LuceneSearchExecEngine.
 * {@link LuceneSearchExecEngine} to execute.  
    private static final Logger LOGGER = LogManager.getLogger(LuceneScanInstructionHandler.class);
 * The OpenSearch Contributors require contributions made to  
    private Decoded decodeFragmentBytes(ShardScanExecutionContext shardCtx, IndexSearcher searcher) {
                filterQuery = new MatchAllDocsQuery();
        LuceneReader luceneReader = reader.getReader(plugin.getDataFormat(), LuceneReader.class);  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.apache.lucene.search.IndexSearcher;  
            java.util.List<String> columnNames = input.readStringList();
 * <p>Empty {@code fragmentBytes} → {@link MatchAllDocsQuery} (count(*) over the whole shard).
        LOGGER.debug(
        byte[] bytes = shardCtx.getFragmentBytes();
import org.opensearch.analytics.spi.ShardScanInstructionNode;
            return new Decoded(filterQuery, columnNames);  
            decoded.columnNames
     * Empty bytes → no filter, no column names (legacy/defensive fallback that shouldn't
        }  
    ) {  
package org.opensearch.be.lucene;
import org.opensearch.index.engine.exec.IndexReaderProvider;
                // Rewrite FieldExistsQuery → postings-only equivalent for the doc-values-less
                QueryBuilder queryBuilder = input.readNamedWriteable(QueryBuilder.class);
import org.opensearch.index.query.QueryShardContext;  
 * this file be licensed under the Apache-2.0 license or a
        }  
 *
        ShardScanExecutionContext shardCtx = (ShardScanExecutionContext) commonContext;
            decoded.filterQuery,
    LuceneScanInstructionHandler(LucenePlugin plugin) {  
            return new Decoded(new MatchAllDocsQuery(), java.util.List.of());
                QueryShardContext qsc = LuceneAnalyticsBackendPlugin.buildMinimalQueryShardContext(shardCtx, searcher);  
 *
    private record Decoded(Query filterQuery, java.util.List<String> columnNames) {  
    }
final class LuceneScanInstructionHandler implements FragmentInstructionHandler<ShardScanInstructionNode> {  
 * compiles it to a Lucene {@link Query}, and returns a {@link LuceneSearcherState} for
import org.apache.logging.log4j.Logger;
    public BackendExecutionContext apply(
    }
            throw new IllegalStateException("Failed to deserialize Lucene-driver fragment bytes", e);
            StreamInput input = new NamedWriteableAwareStreamInput(rawInput, shardCtx.getNamedWriteableRegistry());
import org.opensearch.analytics.backend.ShardScanExecutionContext;  
        ShardScanInstructionNode node,  
        BackendExecutionContext backendContext
import org.apache.lucene.search.Query;
        try (StreamInput rawInput = StreamInput.wrap(bytes)) {  
    @Override
import org.opensearch.index.query.QueryBuilder;
        this.plugin = plugin;
 * SPDX-License-Identifier: Apache-2.0
        IndexReaderProvider.Reader reader = shardCtx.getReader();
 *  
        } catch (IOException e) {
            }
                // lucene-secondary segment (same reason as the filter-delegation path). This covers  
 * produced for a Lucene {@code StagePlan}, acquires the shard's Lucene reader, deserialises  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            "[lucene-count] shardId={} filterQuery={} columnNames={}",
        );  
import org.apache.lucene.search.MatchAllDocsQuery;
     * Deserializes the wire format produced by {@link LuceneFragmentConvertor#convertFragment}:
            throw new IllegalStateException("Lucene-driver fragment dispatched to a shard with no LuceneReader");
            shardCtx.getShardId(),  
                filterQuery = LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(queryBuilder.toQuery(qsc));
     */  
import java.io.IOException;
        CommonExecutionContext commonContext,
 */  
    private final LucenePlugin plugin;
        if (luceneReader == null) {
    }
 * the filter {@link QueryBuilder} from {@code ShardScanExecutionContext.getFragmentBytes()},
}
        if (bytes == null || bytes.length == 0) {  

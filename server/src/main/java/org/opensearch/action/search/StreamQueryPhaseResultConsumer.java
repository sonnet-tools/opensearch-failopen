/**  
 * Streaming query phase result consumer
        // For streaming, we skip the ArraySearchPhaseResults.consumeResult() call
 *
import org.opensearch.core.common.breaker.CircuitBreaker;
        QuerySearchResult querySearchResult = result.queryResult();  
        return super.getBatchReduceSize(requestBatchedReduceSize, minBatchReduceSize * 10);  
            onPartialMergeFailure
 * compatible open source license.
import org.opensearch.search.SearchPhaseResult;  
     *
        pendingReduces.consume(querySearchResult, next);
    @Override
    int getBatchReduceSize(int requestBatchedReduceSize, int minBatchReduceSize) {
            executor,
     * @param minBatchReduceSize: pass as number of shard
    void consumeStreamResult(SearchPhaseResult result, Runnable next) {  
/*  
        // since it doesn't support multiple results from the same shard.
import org.opensearch.search.query.QuerySearchResult;
import java.util.concurrent.Executor;  
        SearchPhaseController controller,
            controller,  
public class StreamQueryPhaseResultConsumer extends QueryPhaseResultConsumer {
            request,  
        );
 * this file be licensed under the Apache-2.0 license or a
        CircuitBreaker circuitBreaker,
 *
 * The OpenSearch Contributors require contributions made to  
        SearchProgressListener progressListener,  
 * @opensearch.internal  
    }  
 */  
        super(
    }
        Consumer<Exception> onPartialMergeFailure  
        Executor executor,  
 * SPDX-License-Identifier: Apache-2.0
            namedWriteableRegistry,
 */
     */  
    }
    /**
}  
    ) {
            circuitBreaker,
import java.util.function.Consumer;
            progressListener,
            expectedResultSize,  
        NamedWriteableRegistry namedWriteableRegistry,
     * For stream search, the minBatchReduceSize is set higher than shard number  
package org.opensearch.action.search;
    public StreamQueryPhaseResultConsumer(
        SearchRequest request,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        int expectedResultSize,

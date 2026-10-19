    <Result extends SearchPhaseResult> void process(
     */
    SearchPhaseName getAfterPhase();  
     * @param searchPhaseContext {@link SearchContext}
    default <Result extends SearchPhaseResult> void process(  
 * The OpenSearch Contributors require contributions made to  
     * SearchPhase. Receives the {@link PipelineProcessingContext} passed to other processors.  
     * The phase which should run after, this processor execution.  
     */
     * Processes the {@link SearchPhaseResults} obtained from a SearchPhase which will be returned to next
 * Creates a processor that runs between Phases of the Search.
     * The phase which should have run before, this processor can start executing.  
/**
 * this file be licensed under the Apache-2.0 license or a
    /**
     * SearchPhase.  
    );
import org.opensearch.action.search.SearchPhaseContext;
        final SearchPhaseResults<Result> searchPhaseResult,  
 * SPDX-License-Identifier: Apache-2.0
    }  
public interface SearchPhaseResultsProcessor extends Processor {
     * @param searchPhaseResult {@link SearchPhaseResults}
 *
     * @return {@link SearchPhaseName}
     * @param searchPhaseContext {@link SearchContext}
     * @param <Result> {@link SearchPhaseResult}  
 */  
     */
    SearchPhaseName getBeforePhase();  
     * Processes the {@link SearchPhaseResults} obtained from a SearchPhase which will be returned to next
 * compatible open source license.
     * @param searchPhaseResult {@link SearchPhaseResults}
import org.opensearch.search.SearchPhaseResult;
/*  
package org.opensearch.search.pipeline;
        final PipelineProcessingContext requestContext  
        final SearchPhaseContext searchPhaseContext
     */
        final SearchPhaseResults<Result> searchPhaseResult,
        process(searchPhaseResult, searchPhaseContext);
import org.opensearch.search.internal.SearchContext;
     * @param <Result> {@link SearchPhaseResult}
import org.opensearch.action.search.SearchPhaseName;
    ) {
import org.opensearch.action.search.SearchPhaseResults;  
    /**
}
     * @param requestContext {@link PipelineProcessingContext}  
 * @opensearch.api  
    /**
 */
        final SearchPhaseContext searchPhaseContext,
     * @return {@link SearchPhaseName}
    /**

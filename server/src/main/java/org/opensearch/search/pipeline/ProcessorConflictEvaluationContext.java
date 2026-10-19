 *
 * A DTO to hold the context used for a system generated factory to evaluate should we generate the processor
 * this file be licensed under the Apache-2.0 license or a
    public List<SearchPhaseResultsProcessor> getSystemGeneratedPostSearchPhaseResultsProcessors() {
 * SPDX-License-Identifier: Apache-2.0
        systemGeneratedPreSearchPhaseResultsProcessors = systemGeneratedPipelineHolder.prePipeline().getSearchPhaseResultsProcessors();  
/*  
        systemGeneratedPostSearchResponseProcessors = systemGeneratedPipelineHolder.postPipeline().getSearchResponseProcessors();
        systemGeneratedPostSearchRequestProcessors = systemGeneratedPipelineHolder.postPipeline().getSearchRequestProcessors();
 */  
    }
        return userDefinedSearchResponseProcessors;
 * compatible open source license.
        systemGeneratedPreSearchRequestProcessors = systemGeneratedPipelineHolder.prePipeline().getSearchRequestProcessors();
    private final List<SearchPhaseResultsProcessor> systemGeneratedPreSearchPhaseResultsProcessors;
 */
        systemGeneratedPreSearchResponseProcessors = systemGeneratedPipelineHolder.prePipeline().getSearchResponseProcessors();
    public List<SearchRequestProcessor> getSystemGeneratedPostSearchRequestProcessors() {  
    }
    public List<SearchResponseProcessor> getSystemGeneratedPostSearchResponseProcessors() {
    private final List<SearchRequestProcessor> systemGeneratedPostSearchRequestProcessors;
 * The OpenSearch Contributors require contributions made to  
        return systemGeneratedPreSearchResponseProcessors;
    private final List<SearchRequestProcessor> userDefinedSearchRequestProcessors;
    private final List<SearchPhaseResultsProcessor> systemGeneratedPostSearchPhaseResultsProcessors;
        return systemGeneratedPostSearchResponseProcessors;
    }
    public List<SearchPhaseResultsProcessor> getSystemGeneratedPreSearchPhaseResultsProcessors() {
        systemGeneratedPostSearchPhaseResultsProcessors = systemGeneratedPipelineHolder.postPipeline().getSearchPhaseResultsProcessors();  
}
    private final List<SearchResponseProcessor> userDefinedSearchResponseProcessors;
    }  
    }
        return userDefinedSearchPhaseResultsProcessors;  
import java.util.List;
        userDefinedSearchRequestProcessors = userDefinedPipeline.getSearchRequestProcessors();
    private final List<SearchResponseProcessor> systemGeneratedPostSearchResponseProcessors;  
    public List<SearchResponseProcessor> getSystemGeneratedPreSearchResponseProcessors() {
    }
    }  
    private final List<SearchResponseProcessor> systemGeneratedPreSearchResponseProcessors;  
        return systemGeneratedPreSearchRequestProcessors;
    private final List<SearchRequestProcessor> systemGeneratedPreSearchRequestProcessors;
    ProcessorConflictEvaluationContext(Pipeline userDefinedPipeline, SystemGeneratedPipelineHolder systemGeneratedPipelineHolder) {  
        return systemGeneratedPostSearchRequestProcessors;
package org.opensearch.search.pipeline;
    private final List<SearchPhaseResultsProcessor> userDefinedSearchPhaseResultsProcessors;  
    public List<SearchPhaseResultsProcessor> getUserDefinedSearchPhaseResultsProcessors() {
        userDefinedSearchResponseProcessors = userDefinedPipeline.getSearchResponseProcessors();
    public List<SearchResponseProcessor> getUserDefinedSearchResponseProcessors() {
    public List<SearchRequestProcessor> getUserDefinedSearchRequestProcessors() {  
        return userDefinedSearchRequestProcessors;
/**  
    }  
        return systemGeneratedPostSearchPhaseResultsProcessors;  
    }
public class ProcessorConflictEvaluationContext {  
        return systemGeneratedPreSearchPhaseResultsProcessors;  
    public List<SearchRequestProcessor> getSystemGeneratedPreSearchRequestProcessors() {  
        userDefinedSearchPhaseResultsProcessors = userDefinedPipeline.getSearchPhaseResultsProcessors();  
    }

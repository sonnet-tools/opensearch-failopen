        int slot,  
    ) {
    public IndexRequestWrapper(
    private final List<IngestPipelineInfo> pipelineInfoList;  
import org.opensearch.action.DocWriteRequest;
    /**
    private final DocWriteRequest<?> actionRequest;
 * SPDX-License-Identifier: Apache-2.0
        return pipelineInfoList;  
        IndexRequest indexRequest,
    public DocWriteRequest<?> getActionRequest() {
        this.pipelineInfoList = pipelineInfoList;
        return slot;
    private final int childSlot;  
        DocWriteRequest<?> actionRequest,  
package org.opensearch.ingest;
        this.indexRequest = indexRequest;
     * For example, update requests with doc and upsert defined can have two child index requests  
    }  
     */
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
/*  
    }
    public List<IngestPipelineInfo> getIngestPipelineInfoList() {
        List<IngestPipelineInfo> pipelineInfoList
/**  
 */
        return indexRequest;
    public IndexRequest getIndexRequest() {  
 */  
     * slot of the IndexRequestWrapper is the index of the request in the list of the requests.
        this.childSlot = childSlot;
        this.slot = slot;  
    }
    }  
import org.opensearch.action.index.IndexRequest;
    }
    /**
    public int getChildSlot() {
     */
public class IndexRequestWrapper {  
    }
     * It can be used to map the ingested result or exception to right index request.  
    public int getSlot() {
 * A wrapper for the index request to help execute the ingest pipelines.
}
    private final int slot;
 * this file be licensed under the Apache-2.0 license or a
 *
        int childSlot,
import java.util.List;
    private final IndexRequest indexRequest;
     * with the same slot but different results/failures, differentiated by their child slot
     * Child slot maps a index request to its potential parent action request.
        this.actionRequest = actionRequest;  
        return actionRequest;
        return childSlot;  

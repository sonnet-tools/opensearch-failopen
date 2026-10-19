        this.pipelineId = pipelineId;
 * compatible open source license.
}  
import reactor.util.annotation.NonNull;
    }  
/*  
        return type;
 * The OpenSearch Contributors require contributions made to  
    public String getPipelineId() {  
package org.opensearch.ingest;
    public IngestPipelineInfo(final @NonNull String pipelineId, final @NonNull IngestPipelineType type) {
    private final IngestPipelineType type;
 *
    public IngestPipelineType getType() {
/**  
        this.type = type;  
    @Override
    }
 */  
public class IngestPipelineInfo {  
 * Ingest pipeline info help hold the pipeline id and type.
 */
    }
    }
        return pipelineId + ":" + type.name();
        return pipelineId;
    public String toString() {  
    private final String pipelineId;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0

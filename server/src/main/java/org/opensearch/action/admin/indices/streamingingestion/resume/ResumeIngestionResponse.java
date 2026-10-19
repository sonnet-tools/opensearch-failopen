package org.opensearch.action.admin.indices.streamingingestion.resume;
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.core.common.io.stream.StreamInput;
        final IngestionStateShardFailure[] shardFailuresList,
        final boolean acknowledged,  
import org.opensearch.action.admin.indices.streamingingestion.IngestionUpdateStateResponse;
import org.opensearch.action.admin.indices.streamingingestion.IngestionStateShardFailure;
    }  
/**
 *
 *
    public ResumeIngestionResponse(
 * this file be licensed under the Apache-2.0 license or a
        String errorMessage  
    ) {
@PublicApi(since = "3.6.0")
 * The OpenSearch Contributors require contributions made to  
/*  
}
 */  
    ResumeIngestionResponse(StreamInput in) throws IOException {
    }  
 */  
        final boolean shardsAcknowledged,
 * SPDX-License-Identifier: Apache-2.0
 * Transport response for resume ingestion.  
        super(in);
import java.io.IOException;  
 * compatible open source license.
 * @opensearch.api
public class ResumeIngestionResponse extends IngestionUpdateStateResponse {
        super(acknowledged, shardsAcknowledged, shardFailuresList, errorMessage);

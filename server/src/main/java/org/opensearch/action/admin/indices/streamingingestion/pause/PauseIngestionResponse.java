 *
 * @opensearch.api
        super(in);
        final boolean shardsAcknowledged,
    }  
 * Transport response for pausing ingestion.  
        final IngestionStateShardFailure[] shardFailuresList,
    public PauseIngestionResponse(
    PauseIngestionResponse(StreamInput in) throws IOException {
 * compatible open source license.
import org.opensearch.common.annotation.PublicApi;  
import java.io.IOException;  
/**
import org.opensearch.action.admin.indices.streamingingestion.IngestionUpdateStateResponse;
 *
        final boolean acknowledged,  
@PublicApi(since = "3.6.0")
    }  
 * SPDX-License-Identifier: Apache-2.0
public class PauseIngestionResponse extends IngestionUpdateStateResponse {
    ) {
import org.opensearch.action.admin.indices.streamingingestion.IngestionStateShardFailure;
package org.opensearch.action.admin.indices.streamingingestion.pause;
 * The OpenSearch Contributors require contributions made to  
 */  
 * this file be licensed under the Apache-2.0 license or a
}
 */  
        super(acknowledged, shardsAcknowledged, shardFailuresList, errorMessage);
import org.opensearch.core.common.io.stream.StreamInput;
        String errorMessage  
/*  

 * The OpenSearch Contributors require contributions made to  
    public SearchShardTaskCancellationStats(long currentTaskCount, long totalTaskCount) {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
}
 * SPDX-License-Identifier: Apache-2.0
    }  
package org.opensearch.tasks;
import java.io.IOException;  
        super(in);  
 *
        super(currentTaskCount, totalTaskCount);
 * Holds monitoring service stats specific to search shard task.  
import org.opensearch.core.common.io.stream.StreamInput;
public class SearchShardTaskCancellationStats extends BaseSearchTaskCancellationStats {
/**
    public SearchShardTaskCancellationStats(StreamInput in) throws IOException {
 */
    }
/*  
 */  

    private final int requiredSize;
 * compatible open source license.
 * @opensearch.api
 *
    public int getRequiredSize() {  
 * SPDX-License-Identifier: Apache-2.0
}
 * Similar to {@link TermsAggregator.BucketCountThresholds} however only provides getters for the local members and no setters.  
package org.opensearch.search.aggregations.bucket;
        this.requiredSize = localRequiredSize;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
/*  
 * BucketCountThresholds type that holds the local (either shard level or request level) bucket count thresholds in minDocCount and requireSize fields.
    }
    public long getMinDocCount() {
        return minDocCount;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
    private final long minDocCount;
 */  
public class LocalBucketCountThresholds {
    }
/**
 *
    public LocalBucketCountThresholds(long localminDocCount, int localRequiredSize) {
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "1.0.0")
        this.minDocCount = localminDocCount;
    }  
        return requiredSize;
 */  

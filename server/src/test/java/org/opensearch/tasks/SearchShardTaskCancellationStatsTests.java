import org.opensearch.core.common.io.stream.Writeable;
    }
        return randomInstance();  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.tasks;
public class SearchShardTaskCancellationStatsTests extends AbstractWireSerializingTestCase<SearchShardTaskCancellationStats> {
/*  
 * The OpenSearch Contributors require contributions made to  
}  
 * this file be licensed under the Apache-2.0 license or a
    public static SearchShardTaskCancellationStats randomInstance() {  
    @Override
 * compatible open source license.
    protected Writeable.Reader<SearchShardTaskCancellationStats> instanceReader() {  
        return new SearchShardTaskCancellationStats(randomNonNegativeLong(), randomNonNegativeLong());
    @Override
        return SearchShardTaskCancellationStats::new;
    protected SearchShardTaskCancellationStats createTestInstance() {
    }
 */  
 *
    }
import org.opensearch.test.AbstractWireSerializingTestCase;

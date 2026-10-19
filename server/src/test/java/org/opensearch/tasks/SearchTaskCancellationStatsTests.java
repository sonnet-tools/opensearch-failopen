 */  
import org.opensearch.core.common.io.stream.Writeable;
 * The OpenSearch Contributors require contributions made to  
    public static SearchTaskCancellationStats randomInstance() {  
 * SPDX-License-Identifier: Apache-2.0
        return SearchTaskCancellationStats::new;
        return new SearchTaskCancellationStats(randomNonNegativeLong(), randomNonNegativeLong());
package org.opensearch.tasks;
    }
        return randomInstance();  
    @Override
    protected Writeable.Reader<SearchTaskCancellationStats> instanceReader() {  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
}  
 *
public class SearchTaskCancellationStatsTests extends AbstractWireSerializingTestCase<SearchTaskCancellationStats> {
import org.opensearch.test.AbstractWireSerializingTestCase;
    }
    }
    @Override
/*  
    protected SearchTaskCancellationStats createTestInstance() {

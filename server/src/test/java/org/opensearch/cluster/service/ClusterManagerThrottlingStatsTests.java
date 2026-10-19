        return randomStats;  
    public static ClusterManagerThrottlingStats randomInstance() {  
        randomStats.onThrottle(randomAlphaOfLengthBetween(3, 10), randomInt());
        return ClusterManagerThrottlingStats::new;
    @Override
 */  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    }
    @Override
    protected Writeable.Reader<ClusterManagerThrottlingStats> instanceReader() {  
public class ClusterManagerThrottlingStatsTests extends AbstractWireSerializingTestCase<ClusterManagerThrottlingStats> {
}
    protected ClusterManagerThrottlingStats createTestInstance() {
        return randomInstance();  
package org.opensearch.cluster.service;
 *
import org.opensearch.core.common.io.stream.Writeable;
    }
 * SPDX-License-Identifier: Apache-2.0
/*  
    }
        ClusterManagerThrottlingStats randomStats = new ClusterManagerThrottlingStats();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.AbstractWireSerializingTestCase;

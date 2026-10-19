    }
        stages.put("COORDINATOR_REDUCE", new AnalyticsStats.StageBucket(5, 5, 0, 0, 0, new AnalyticsStats.LatencyStats(5, 50)));  
    }  
                return reader.apply(in);  
 * {@link org.opensearch.analytics.stats.transport.AnalyticsStatsNodeResponse}
 * this file be licensed under the Apache-2.0 license or a
    public void testAnalyticsStatsRoundTrip() throws IOException {  
import java.util.Map;  
        assertEquals(original, copy);  
import org.opensearch.common.io.stream.BytesStreamOutput;
 */  
        R apply(T t) throws IOException;
 * to the coordinator inside an  
        AnalyticsStats.Fragments copy = roundTrip(original, AnalyticsStats.Fragments::new);
        throws IOException {
        assertEquals(original.fragments(), copy.fragments());
        assertEquals(original.queries(), copy.queries());  
 */  
            new TreeMap<>(),
 * via {@link org.opensearch.action.support.nodes.TransportNodesAction}.
 *
public class AnalyticsStatsTests extends OpenSearchTestCase {
            new AnalyticsStats.Queries(new AnalyticsStats.LatencyStats(25, 600), new AnalyticsStats.LatencyStats(25, 100)),  
        );
import org.opensearch.core.common.io.stream.StreamInput;
        );  
 * Wire-format round-trip tests for {@link AnalyticsStats} and its nested
    private static <T extends org.opensearch.core.common.io.stream.Writeable> T roundTrip(T original, IOFunction<StreamInput, T> reader)
 * compatible open source license.
    public void testEmptyAnalyticsStatsRoundTrip() throws IOException {
        Map<String, AnalyticsStats.StageBucket> stages = new TreeMap<>();
        assertEquals(original.queries(), copy.queries());  
    }
            new AnalyticsStats.LatencyStats(50, 5000),
    }
import org.opensearch.test.OpenSearchTestCase;  
    public void testFragmentsRoundTrip() throws IOException {  
}
    private interface IOFunction<T, R> {  
    public void testLatencyStatsRoundTrip() throws IOException {  
/**  
import java.io.IOException;
        assertEquals(original, copy);  
        }
        AnalyticsStats original = new AnalyticsStats(  
            try (StreamInput in = out.bytes().streamInput()) {
            new AnalyticsStats.Fragments(0, 0, 0, AnalyticsStats.LatencyStats.EMPTY)  
        AnalyticsStats copy = roundTrip(original, AnalyticsStats::new);
    }
 * SPDX-License-Identifier: Apache-2.0
            original.writeTo(out);
        assertEquals(original.stagesByType(), copy.stagesByType());
    }
        );
        AnalyticsStats.LatencyStats copy = roundTrip(original, AnalyticsStats.LatencyStats::new);
        assertEquals(original, copy);  
            new AnalyticsStats.Fragments(40, 38, 2, new AnalyticsStats.LatencyStats(40, 750))
    public void testStageBucketRoundTrip() throws IOException {  
package org.opensearch.analytics.stats;
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        AnalyticsStats.Fragments original = new AnalyticsStats.Fragments(42, 40, 2, new AnalyticsStats.LatencyStats(42, 800));
    public void testQueriesRoundTrip() throws IOException {  
            new AnalyticsStats.Queries(AnalyticsStats.LatencyStats.EMPTY, AnalyticsStats.LatencyStats.EMPTY),
    }  
        AnalyticsStats original = new AnalyticsStats(
        AnalyticsStats.Queries original = new AnalyticsStats.Queries(
        AnalyticsStats.StageBucket original = new AnalyticsStats.StageBucket(10, 8, 1, 1, 12345, new AnalyticsStats.LatencyStats(10, 500));
        assertEquals(original, copy);  
import java.util.TreeMap;
        assertEquals(original.fragments(), copy.fragments());
        assertTrue("empty stages map round-trips empty", copy.stagesByType().isEmpty());
        AnalyticsStats.Queries copy = roundTrip(original, AnalyticsStats.Queries::new);
/*  
            stages,
        stages.put("SHARD_FRAGMENT", new AnalyticsStats.StageBucket(20, 18, 1, 1, 99999, new AnalyticsStats.LatencyStats(20, 400)));
    }  
        AnalyticsStats copy = roundTrip(original, AnalyticsStats::new);
        AnalyticsStats.StageBucket copy = roundTrip(original, AnalyticsStats.StageBucket::new);
 * The OpenSearch Contributors require contributions made to  
        AnalyticsStats.LatencyStats original = new AnalyticsStats.LatencyStats(100, 12345);
    @FunctionalInterface
 * records. Required because {@link AnalyticsStats} is shipped from each node
            new AnalyticsStats.LatencyStats(50, 1500)  
            }

        AdaptiveBudgetStats deserialized = new AdaptiveBudgetStats(in);
            assertEquals("rejections mismatch", original.rejections, deserialized.rejections);  
/**
    }
            AdaptiveBudgetStats original = randomAdaptiveBudgetStats();
    // ---- Property: StreamOutput/StreamInput round trip produces equal object ----
import org.opensearch.test.OpenSearchTestCase;  
    }
        AdaptiveBudgetStats zeroed = new AdaptiveBudgetStats(0L, 0L);  
public class AdaptiveBudgetStatsTests extends OpenSearchTestCase {
            // Deserialize
            // Serialize
import org.opensearch.core.xcontent.ToXContent;
        return randomLongBetween(0, Long.MAX_VALUE / 2);  
            // Verify equality  
    }
import java.io.IOException;
            builder.startObject();  
        zeroed.writeTo(out);  
            assertTrue("adaptive_budget key must be present", root.containsKey("adaptive_budget"));
    @SuppressWarnings("unchecked")  
        }  
import org.opensearch.common.xcontent.XContentFactory;
            AdaptiveBudgetStats deserialized = new AdaptiveBudgetStats(in);
import org.opensearch.core.common.io.stream.StreamInput;  
            // adaptive_budget wrapper must be present  
 * <p><b>Validates: Requirements 2.6, 2.7</b> — AdaptiveBudgetStats survives StreamOutput/StreamInput
import org.opensearch.common.xcontent.XContentHelper;  
 */  
            BytesStreamOutput out = new BytesStreamOutput();
            AdaptiveBudgetStats original = randomAdaptiveBudgetStats();  
    private static final int TRIES = 200;
            // Verify field values  
    // ---- Generators ----  
import java.util.Map;  
        for (int i = 0; i < TRIES; i++) {
            original.writeTo(out);  
            Map<String, Object> root = XContentHelper.convertToMap(BytesReference.bytes(builder), false, XContentType.JSON).v2();
    }
    }
 * compatible open source license.
    private long nonNegLong() {
    public void testToXContentRoundTrip() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        return new AdaptiveBudgetStats(nonNegLong(), nonNegLong());
import org.opensearch.common.io.stream.BytesStreamOutput;
            assertEquals("adaptive_budget must have exactly 2 fields", 2, budgetNode.size());
            assertEquals("fallbacks mismatch", original.fallbacks, deserialized.fallbacks);
        }
            assertEquals(original.rejections, ((Number) budgetNode.get("rejections")).longValue());
 * Randomized tests for {@link AdaptiveBudgetStats} serialization round-trip and JSON rendering.  
 *
        assertEquals(zeroed, deserialized);
 * round-trip and renders correct JSON.  
}
        assertEquals(0L, deserialized.fallbacks);
package org.opensearch.be.datafusion.stats;
            original.toXContent(builder, ToXContent.EMPTY_PARAMS);
    // ---- Edge case: zero values ----  
 * this file be licensed under the Apache-2.0 license or a
            builder.endObject();
    private AdaptiveBudgetStats randomAdaptiveBudgetStats() {  
            XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.xcontent.XContentBuilder;
        StreamInput in = out.bytes().streamInput();
 */
            assertNotNull("adaptive_budget object must not be null", budgetNode);  
            assertEquals("hashCode must be consistent after round trip", original.hashCode(), deserialized.hashCode());
        for (int i = 0; i < TRIES; i++) {
            Map<String, Object> budgetNode = (Map<String, Object>) root.get("adaptive_budget");
            assertEquals("StreamOutput/StreamInput round trip must preserve all fields", original, deserialized);
 *
            // Verify individual fields
    public void testZeroValues() throws IOException {
/*  
            StreamInput in = out.bytes().streamInput();  
 * SPDX-License-Identifier: Apache-2.0
    // ---- Property: toXContent renders correct JSON shape ----
            assertEquals(original.fallbacks, ((Number) budgetNode.get("fallbacks")).longValue());
import org.opensearch.common.xcontent.XContentType;
    public void testRoundTripPreservesAllFields() throws IOException {  
        assertEquals(0L, deserialized.rejections);  
        BytesStreamOutput out = new BytesStreamOutput();

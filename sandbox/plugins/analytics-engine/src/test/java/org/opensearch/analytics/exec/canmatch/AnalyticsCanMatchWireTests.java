            ShardSortBounds.VALUE_KIND_INT32,
                assertEquals("hasNulls must survive the wire", hasNulls, copy.bounds().hasNulls());
    }
 * The OpenSearch Contributors require contributions made to  
    }
            "datafusion",  
    /** A matching shard with no statistics (e.g. a {@code keyword} sort) must serialize cleanly as no-bounds. */
    }
    /** The single-arg constructor is the pre-existing shape and must keep meaning "no bounds". */
        assertFalse(copy.bounds().hasNulls());  
                return new AnalyticsCanMatchRequest(in);
        assertTrue(copy.canMatch());
}
        AnalyticsCanMatchRequest original = new AnalyticsCanMatchRequest(
            "datafusion"
import org.opensearch.common.io.stream.BytesStreamOutput;
    public void testBoundsRoundTripPreservesEveryValueKindAndHasNulls() throws Exception {
            try (StreamInput in = out.bytes().streamInput()) {  
     */
        assertEquals(original.getShardId(), copy.getShardId());  
        assertEquals("datafusion", copy.getBackendId());
 * this file be licensed under the Apache-2.0 license or a
        }  
            }
        ShardSortBounds bounds = new ShardSortBounds(100L, 5000L, false, ShardSortBounds.VALUE_KIND_INT64);
            new byte[] { 7, 8, 9 },
import org.opensearch.core.index.shard.ShardId;
        );
        assertEquals("datafusion", copy.getBackendId());
            request.writeTo(out);
            ShardSortBounds.VALUE_KIND_INT64_MILLIS,  
    }
            ShardSortBounds.VALUE_KIND_INT64_NANOS }) {
        AnalyticsCanMatchResponse copy = roundTrip(new AnalyticsCanMatchResponse(false));
            new ShardId(new Index("logs", "_na_"), 0),
     * Every value kind and {@code hasNulls} must round-trip: the coordinator compares kinds for
 * SPDX-License-Identifier: Apache-2.0
            try (StreamInput in = out.bytes().streamInput()) {  
        assertNotNull(copy.bounds());  
        AnalyticsCanMatchResponse copy = roundTrip(new AnalyticsCanMatchResponse(true, bounds));  
                assertEquals("value kind " + kind + " must round-trip", kind, copy.bounds().valueKind());
     * equality, and a dropped {@code hasNulls=true} would let it eliminate a shard holding a top null.  
    }  
    public void testBoundsRoundTripPreservesNegativeAndExtremeValues() throws Exception {
    private static AnalyticsCanMatchRequest roundTrip(AnalyticsCanMatchRequest request) throws Exception {  
    /**
 */  
    public void testMatchingShardWithoutBoundsRoundTrips() throws Exception {
    }
            for (boolean hasNulls : new boolean[] { false, true }) {  
        AnalyticsCanMatchResponse copy = roundTrip(new AnalyticsCanMatchResponse(true, null));  
        assertNull("bounds must be optional on the wire", copy.bounds());
                ShardSortBounds bounds = new ShardSortBounds(0L, 1L, hasNulls, kind);
import org.opensearch.core.common.io.stream.StreamInput;  
        assertTrue(copy.canMatch());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 */
        assertArrayEquals(original.getFilterBytes(), copy.getFilterBytes());
/*  
 * Wire round-trip coverage for the can-match request/response, focused on the optional sort-bounds  
        }
        assertEquals(100L, copy.bounds().min());
            "@timestamp"
import org.opensearch.analytics.spi.ShardSortBounds;
        for (byte kind : new byte[] {  
    private static AnalyticsCanMatchResponse roundTrip(AnalyticsCanMatchResponse response) throws Exception {  
    public void testResponseRoundTripWithBounds() throws Exception {
 *
        AnalyticsCanMatchRequest copy = roundTrip(original);
            new ShardId(new Index("logs", "_na_"), 3),
    public void testResponseBooleanOnlyConstructorHasNoBounds() {  
        ShardSortBounds bounds = new ShardSortBounds(Long.MIN_VALUE, Long.MAX_VALUE, false, ShardSortBounds.VALUE_KIND_INT32);
 * compatible open source license.
        assertNull(copy.bounds());  
        assertEquals(Long.MIN_VALUE, copy.bounds().min());
public class AnalyticsCanMatchWireTests extends OpenSearchTestCase {  
            ShardSortBounds.VALUE_KIND_INT64,
package org.opensearch.analytics.exec.canmatch;
    }
                return new AnalyticsCanMatchResponse(in);
    }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }
            new byte[] { 1 },  
        assertFalse(copy.canMatch());
        assertEquals(ShardSortBounds.VALUE_KIND_INT32, copy.bounds().valueKind());
        assertEquals(ShardSortBounds.VALUE_KIND_INT64, copy.bounds().valueKind());
        assertEquals("@timestamp", copy.getSortColumn());  
/**
    public void testRequestRoundTripWithSortColumn() throws Exception {
    public void testRequestRoundTripWithoutSortColumn() throws Exception {  
        AnalyticsCanMatchRequest original = new AnalyticsCanMatchRequest(  
        assertNull(new AnalyticsCanMatchResponse(true).bounds());
                AnalyticsCanMatchResponse copy = roundTrip(new AnalyticsCanMatchResponse(true, bounds));
        );
        }  
 * fields: they must survive serialization intact and, when absent, leave the boolean-only shape unchanged.
import org.opensearch.core.index.Index;
        assertNull("absent sort column must stay absent", copy.getSortColumn());  
        assertEquals(Long.MAX_VALUE, copy.bounds().max());  
            }  
import org.opensearch.test.OpenSearchTestCase;  
        AnalyticsCanMatchResponse copy = roundTrip(new AnalyticsCanMatchResponse(true, bounds));  
            response.writeTo(out);
        AnalyticsCanMatchRequest copy = roundTrip(original);
    public void testResponseRoundTripWithoutBounds() throws Exception {
    }
            ShardSortBounds.VALUE_KIND_INT64_MICROS,
        assertEquals(5000L, copy.bounds().max());
    }

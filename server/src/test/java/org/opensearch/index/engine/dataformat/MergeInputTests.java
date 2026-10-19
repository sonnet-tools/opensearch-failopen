import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.engine.exec.Segment;
    public void testBuilderDefaultsLiveDocsToAllAlive() {
        assertSame(MergePreparation.EMPTY, preparation);  
        assertSame(LiveDocs.ALL_ALIVE, input.liveDocs());  
/**
        MergeInput input = MergeInput.builder().segments(List.of()).newWriterGeneration(1L).build();
        Merger merger = mergeInput -> null;
        segments.add(Segment.builder(1L).build());  
    }  
    }
import java.util.Map;  
        assertTrue(e.getMessage().contains("liveDocs must not be null"));
    public void testGetLiveDocsForSegmentDelegatesToLiveDocs() {  
        expectThrows(UnsupportedOperationException.class, () -> input.segments().add(Segment.builder(3L).build()));
/*  
 */
import java.io.IOException;
    }
    }
        MergeInput input = MergeInput.builder().segments(List.of()).newWriterGeneration(1L).liveDocs(liveDocs).build();  
    public void testMergerDefaultPrepareMergeReturnsEmptyPreparation() throws IOException {
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(3L, bits));
 *
package org.opensearch.index.engine.dataformat;
        NullPointerException e = expectThrows(NullPointerException.class, () -> MergeInput.builder().liveDocs(null));
        LiveDocs liveDocs = LiveDocs.fromPackedBits(Map.of(3L, new long[] { 0b1L }));
        NullPointerException e = expectThrows(NullPointerException.class, () -> new MergeInput(List.of(), null, 1L, null));  
    // ========== getLiveDocsForSegment ==========
        assertEquals("MergeInput must copy the segment list", 1, input.segments().size());
        assertArrayEquals(bits, input.getLiveDocsForSegment(3L));
    public void testEmptyPreparationCloseIsIdempotentNoOp() throws IOException {  
    public void testBuilderCarriesExplicitLiveDocs() {
    }
public class MergeInputTests extends OpenSearchTestCase {  
    public void testMergerDefaultDoesNotProvideMergeLiveDocs() {
        List<Segment> segments = new java.util.ArrayList<>();
 */  
    public void testCanonicalConstructorRejectsNullLiveDocs() {
        MergeInput input = MergeInput.builder().segments(List.of()).newWriterGeneration(1L).build();
 * SPDX-License-Identifier: Apache-2.0
        MergePreparation.EMPTY.close(); // idempotent
import java.util.List;
        MergeInput input = MergeInput.builder().segments(List.of()).newWriterGeneration(1L).liveDocs(liveDocs).build();  
    }
        MergePreparation preparation = merger.prepareMerge(input);
        MergePreparation.EMPTY.close(); // must not throw
    // ========== liveDocs defaults and validation ==========
        long[] bits = new long[] { 0b101L };
    }  
    }  
        assertSame(LiveDocs.ALL_ALIVE, preparation.liveDocs());
        MergeInput input = MergeInput.builder().segments(List.of()).newWriterGeneration(1L).build();  
    }
        assertTrue(e.getMessage().contains("liveDocs must not be null"));
        MergeInput input = MergeInput.builder().segments(segments).newWriterGeneration(1L).build();
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(merger.providesMergeLiveDocs());  
 * Unit tests for {@link MergeInput} live-docs plumbing and the {@link Merger}  
        assertNull("segments without deletes must return null", input.getLiveDocsForSegment(4L));  
 * compatible open source license.
        assertNull(input.getLiveDocsForSegment(randomLong()));
    }
    // ========== Merger default prepare hooks ==========
    public void testBuilderRejectsNullLiveDocs() {  
 * prepare/abort default implementations.
    public void testGetLiveDocsForSegmentAllAliveReturnsNull() {  
    public void testSegmentsAreCopiedDefensively() {
}
    // ========== segments immutability ==========
 * The OpenSearch Contributors require contributions made to  
        assertTrue(MergePreparation.EMPTY.liveDocs().allAlive());  
        assertSame(liveDocs, input.liveDocs());
        segments.add(Segment.builder(2L).build());  
        Merger merger = mergeInput -> null; // lambda implements only merge()

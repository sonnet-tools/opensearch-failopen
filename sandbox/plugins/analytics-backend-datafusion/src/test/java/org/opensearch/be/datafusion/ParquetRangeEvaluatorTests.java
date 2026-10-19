    }  
        IndexShard shard = mock(IndexShard.class);  
        CanMatchResult result = ParquetRangeEvaluator.evaluateWithBounds(shard, new byte[0], "latency", plugin);  
     * No filters and no sort column: there is nothing to evaluate, so the evaluator must return
public class ParquetRangeEvaluatorTests extends OpenSearchTestCase {
import static org.mockito.Mockito.verifyNoInteractions;
        assertNull("no bounds when the probe could not run", result.bounds());  
     * A sort column is requested but the DataFusion service is unavailable. The prune answer is  
     * "match, no bounds" WITHOUT touching the shard — the reader-acquire cost is skipped entirely.
     */
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(result.canMatch());
        DataFusionPlugin plugin = mock(DataFusionPlugin.class);
        when(plugin.getDataFusionService()).thenReturn(null);
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.index.shard.IndexShard;
        DataFusionPlugin plugin = mock(DataFusionPlugin.class);  
     */
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin.CanMatchResult;  
/**
     */
        verifyNoInteractions(shard);
    public void testBoundsOnlyServiceUnavailableFailsOpen() {
 */  
        CanMatchResult result = ParquetRangeEvaluator.evaluateWithBounds(shard, filters, "latency", plugin);  
package org.opensearch.be.datafusion;
}
/*  
import java.util.List;
        IndexShard shard = mock(IndexShard.class);
        DataFusionPlugin plugin = mock(DataFusionPlugin.class);
        when(plugin.getDataFusionService()).thenReturn(null);
     * then a fail-open default (match), and no bounds can be produced.
        IndexShard shard = mock(IndexShard.class);  
 * short-circuit contract that the design leans on.
        CanMatchResult result = ParquetRangeEvaluator.evaluateWithBounds(shard, new byte[0], null, plugin);  
import org.opensearch.analytics.exec.canmatch.LongRange;
import static org.mockito.Mockito.mock;  
        DataFusionPlugin plugin = mock(DataFusionPlugin.class);
        // The whole point of the short-circuit: no reader, no service, no shard interaction.
    }
import org.opensearch.test.OpenSearchTestCase;
import static org.mockito.Mockito.when;
 * The OpenSearch Contributors require contributions made to  
    /**  
     */  
     * {@code evaluate(...)} is the boolean-only entry the shipped prune path uses. It must keep
 *
        assertNull(result.bounds());  
        assertTrue("unavailable service must not prune", result.canMatch());
    public void testNoFiltersNoSortColumnShortCircuitsWithoutTouchingShard() {
     * open rather than throw — a bare sort must never be penalised by a probe failure.
        byte[] filters = CanMatchFilterSerializer.serialize(List.of(new LongRange("latency", 0, 100)));
 * Fail-open coverage for {@link ParquetRangeEvaluator} that needs no native library or real
        assertTrue(ParquetRangeEvaluator.evaluate(shard, filters, plugin));
 * shard. The happy path (an actual parquet fold) is exercised by the end-to-end IT and the  
        assertNull(result.bounds());  
     * degraded backend.  
    }  
    /**  
        IndexShard shard = mock(IndexShard.class);
        when(plugin.getDataFusionService()).thenReturn(null);  
     * delegating to the combined method and expose only the prune bit — never throw on a
    /**
 */  
    }
    /**  
        assertTrue("empty work must fail open to match", result.canMatch());
import org.opensearch.analytics.exec.canmatch.CanMatchFilterSerializer;
     * This is the common bare-`sort | head N` short-circuit before it even reaches a sort column.  
        byte[] filters = CanMatchFilterSerializer.serialize(List.of(new LongRange("latency", 0, 100)));
     * The bounds-only path (a sort column, no filters) with the service unavailable must also fail
    public void testLegacyEvaluateDelegatesAndFailsOpen() throws Exception {
 * Rust-side {@code can_match} unit tests; these lock in the Java-side control flow and the
    public void testServiceUnavailableFailsOpen() throws Exception {  

            w.w.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);
                HierarchyCircuitBreakerService breakerService = new HierarchyCircuitBreakerService(
                    )
import org.apache.lucene.index.NoMergePolicy;
                );
                expectThrows(
                        reader,
                IndexOrdinalsFieldData globalOrdinals = GlobalOrdinalsBuilder.build(
        try (Directory dir = newDirectory()) {
public class GlobalOrdinalsBuilderTests extends OpenSearchTestCase {
                        new NoneCircuitBreakerService(),
import org.apache.lucene.document.Field;
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
                public java.util.Collection<org.apache.lucene.util.Accountable> getChildResources() {
        when(fieldData.getFieldName()).thenReturn(fieldName);
import org.apache.lucene.document.StringField;
                        logger,
                    Document doc = new Document();
                    } catch (IOException e) {
                public long ramBytesUsed() {
import static org.mockito.Mockito.when;
                        reader,
                    Collections.emptyList(),
                }
                }
                        AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION
                IndexOrdinalsFieldData fieldData = mockFieldData("field", reader);
import org.apache.lucene.index.IndexReader;
import static org.mockito.ArgumentMatchers.any;
                // Original method (no Runnable param) should still work
                            throw new TaskCancelledException("cancelled");
                assertTrue("global ordinals should report memory usage", ((Accountable) globalOrdinals).ramBytesUsed() > 1L);
                IndexOrdinalsFieldData fieldData = mockFieldData("field", reader);
                    TaskCancelledException.class,
/*
                assertNotNull(
            }
                    }
    public void testBuildWithCancellationBetweenSegments() throws IOException {
        try (Directory dir = newDirectory()) {
        IndexOrdinalsFieldData fieldData = mock(IndexOrdinalsFieldData.class);
                        reader,
            for (int seg = 0; seg < 2; seg++) {
                    TaskCancelledException.class,
            try (IndexReader reader = w.getReader()) {
                        }
            }
            for (int seg = 0; seg < 3; seg++) {
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
                }
                        logger,
                    w.addDocument(doc);
                        new NoneCircuitBreakerService(),
    private static IndexOrdinalsFieldData mockFieldData(String fieldName, IndexReader reader) {
                            }
    }
                        fieldData,
        }
                        fieldData,
 * The OpenSearch Contributors require contributions made to
import java.util.Collections;
                        .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
            }
                        logger,
 * SPDX-License-Identifier: Apache-2.0
                    )
    }
                    doc.add(new StringField("field", "seg" + seg + "_term" + i, Field.Store.NO));
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
            for (int seg = 0; seg < 3; seg++) {
                        reader,
                    logger,
                        throw new RuntimeException(e);
                    new NoneCircuitBreakerService(),
                assertTrue(reader.leaves().size() > 1);
                    reader,
import org.apache.lucene.store.Directory;
 *
                @Override
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
import org.apache.lucene.index.SortedSetDocValues;
import org.opensearch.common.settings.Settings;
                    GlobalOrdinalsBuilder.build(
                AtomicBoolean cancelled = new AtomicBoolean(false);
                Document doc = new Document();
                        new NoneCircuitBreakerService(),
                    return Collections.emptyList();
        try (Directory dir = newDirectory()) {
                @Override
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("seg" + seg + "_term" + i)));
                            if (cancelled.get()) {
            for (int seg = 0; seg < 3; seg++) {
                        }
                        () -> {
            }
                    )
        return fieldData;
                for (int i = 0; i < 10; i++) {
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.util.Accountable;
                w.close();
                IndexOrdinalsFieldData fieldData = mockFieldData("field", reader);
                    try {
import org.apache.lucene.util.BytesRef;
    }
                w.close();
                        breakerService,
                public void close() {}
                }
                        reader,
                );
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
                    () -> GlobalOrdinalsBuilder.build(
                );
                CircuitBreakingException exception = expectThrows(
                assertTrue(reader.leaves().size() > 1);
}
                                throw new TaskCancelledException("cancelled after first segment");
                        logger,
                assertNotNull(
                        fieldData,
        }
                expectThrows(
                @Override
                w.flush();
                    Document doc = new Document();
            try (IndexReader reader = w.getReader()) {
                assertTrue("Need multiple segments for global ordinals", reader.leaves().size() > 1);
import org.opensearch.core.common.breaker.CircuitBreakingException;
                    AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION
                );
                    )
                        .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "1b")
                assertEquals(1L, breakerService.getBreaker(CircuitBreaker.FIELDDATA).getTrippedCount());
                    Settings.builder()
                        AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION
import org.apache.lucene.index.LeafReaderContext;
                            cancelled.set(true); // arm cancellation after first check passes
                        AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION,
import org.opensearch.common.settings.ClusterSettings;
            }
                // Build with immediate cancellation — should throw between segments
        }
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                    () -> GlobalOrdinalsBuilder.build(
 */
                        fieldData,
            }
import static org.mockito.Mockito.mock;
                        return dv != null ? dv : DocValues.emptySortedSet();
import org.apache.lucene.tests.index.RandomIndexWriter;
            try (IndexReader reader = w.getReader()) {
import org.opensearch.test.OpenSearchTestCase;
                assertTrue(exception.getMessage(), exception.getMessage().contains("data for [field]"));
            w.w.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);
            // Create 3 segments with distinct terms
                @Override
        });
            w.w.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);
            }
        when(fieldData.load(any(LeafReaderContext.class))).thenAnswer(invocation -> {
                        SortedSetDocValues dv = ctx.reader().getSortedSetDocValues(fieldName);
                        AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION,
            w.w.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);
    }
                Document doc = new Document();
            return new AbstractLeafOrdinalsFieldData(AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
                    GlobalOrdinalsBuilder.build(
                w.flush();
import org.opensearch.core.common.breaker.CircuitBreaker;
                }
                    CircuitBreakingException.class,
import org.apache.lucene.index.DocValues;
package org.opensearch.index.fielddata.ordinals;
            try (IndexReader reader = w.getReader()) {
                IndexOrdinalsFieldData fieldData = mockFieldData("field", reader);
import java.io.IOException;
                public SortedSetDocValues getOrdinalsValues() {
                w.addDocument(doc);
        }
        try (Directory dir = newDirectory()) {
                );
                    w.addDocument(doc);
                );
                for (int i = 0; i < 10; i++) {
                );
 * compatible open source license.
    public void testOriginalBuildMethodStillWorks() throws IOException {
import org.apache.lucene.document.SortedSetDocValuesField;
                    )
import org.opensearch.index.fielddata.plain.AbstractLeafOrdinalsFieldData;
    }
    public void testBuildTripsFieldDataBreaker() throws IOException {
                        () -> {
                // Cancel after first segment — should still throw
                        new NoneCircuitBreakerService(),
                        logger,
                        .build(),
import org.opensearch.core.tasks.TaskCancelledException;
                    return 0;
                    () -> GlobalOrdinalsBuilder.build(
                assertTrue("Need multiple segments for global ordinals", reader.leaves().size() > 1);
                w.close();
                        AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION,
import org.apache.lucene.document.Document;
                        () -> {}
                assertEquals(0L, breakerService.getBreaker(CircuitBreaker.FIELDDATA).getUsed());
                w.flush();
                doc.add(new StringField("field", "term" + seg, Field.Store.NO));
                    fieldData,
                assertTrue(exception.getMessage(), exception.getMessage().contains("[fielddata] Data too large"));
                w.close();
                w.flush();
            LeafReaderContext ctx = invocation.getArgument(0);
            }
                w.addDocument(doc);
    public void testBuildWithDelayedCancellation() throws IOException {
import java.util.concurrent.atomic.AtomicBoolean;
                        fieldData,
                // Build without cancellation — should succeed
            };
                doc.add(new StringField("field", "term" + seg, Field.Store.NO));

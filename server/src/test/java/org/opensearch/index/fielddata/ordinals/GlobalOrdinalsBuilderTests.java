                    )
                w.addDocument(doc);  
            }
import org.opensearch.common.settings.Settings;  
        }  
            w.w.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);  
                        new NoneCircuitBreakerService(),
            for (int seg = 0; seg < 3; seg++) {  
    public void testBuildWithDelayedCancellation() throws IOException {  
                // Build without cancellation — should succeed  
    }
                }
                CircuitBreakingException exception = expectThrows(  
import org.opensearch.index.fielddata.plain.AbstractLeafOrdinalsFieldData;  
        try (Directory dir = newDirectory()) {
                        breakerService,
                    () -> GlobalOrdinalsBuilder.build(
                @Override  
                IndexOrdinalsFieldData globalOrdinals = GlobalOrdinalsBuilder.build(  
                doc.add(new StringField("field", "term" + seg, Field.Store.NO));
                    }
                    GlobalOrdinalsBuilder.build(  
                w.flush();  
                // Original method (no Runnable param) should still work
    }
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
        try (Directory dir = newDirectory()) {  
                    )  
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
                HierarchyCircuitBreakerService breakerService = new HierarchyCircuitBreakerService(  
                        fieldData,  
import org.apache.lucene.index.IndexReader;  
                w.flush();
                    AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION
            // Create 3 segments with distinct terms
import org.apache.lucene.index.NoMergePolicy;
            for (int seg = 0; seg < 2; seg++) {  
                        reader,
import static org.mockito.ArgumentMatchers.any;
            }
import java.io.IOException;
import static org.mockito.Mockito.when;
                assertNotNull(
            return new AbstractLeafOrdinalsFieldData(AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION) {
                w.close();
import org.apache.lucene.document.Document;
                        logger,
                        }
                    TaskCancelledException.class,
                        .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false)
                    try {
 * The OpenSearch Contributors require contributions made to  
                    } catch (IOException e) {
                        .put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.getKey(), "1b")  
        when(fieldData.load(any(LeafReaderContext.class))).thenAnswer(invocation -> {  
        return fieldData;  
                        logger,
                        reader,
                                throw new TaskCancelledException("cancelled after first segment");  
 */  
import org.opensearch.core.tasks.TaskCancelledException;
                Document doc = new Document();  
                        }  
                    () -> GlobalOrdinalsBuilder.build(  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
                    CircuitBreakingException.class,
                        throw new RuntimeException(e);  
                @Override
                            cancelled.set(true); // arm cancellation after first check passes
                    w.addDocument(doc);
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("seg" + seg + "_term" + i)));
                IndexOrdinalsFieldData fieldData = mockFieldData("field", reader);
                AtomicBoolean cancelled = new AtomicBoolean(false);
                        .build(),
                    Document doc = new Document();  
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
import java.util.Collections;
                IndexOrdinalsFieldData fieldData = mockFieldData("field", reader);
            w.w.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);  
        });
                    new NoneCircuitBreakerService(),  
                }
                w.addDocument(doc);
            LeafReaderContext ctx = invocation.getArgument(0);
                        AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION,
                expectThrows(
import org.apache.lucene.tests.index.RandomIndexWriter;
                }  
        }  
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
import org.opensearch.core.common.breaker.CircuitBreaker;
            }  
                );
                );
            w.w.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);
import org.apache.lucene.index.SortedSetDocValues;  
                    Settings.builder()
                        AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION,
                for (int i = 0; i < 10; i++) {
                    () -> GlobalOrdinalsBuilder.build(
                expectThrows(
import org.apache.lucene.store.Directory;
                        SortedSetDocValues dv = ctx.reader().getSortedSetDocValues(fieldName);  
                assertNotNull(
            }
                public java.util.Collection<org.apache.lucene.util.Accountable> getChildResources() {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
                        AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION
 *
            try (IndexReader reader = w.getReader()) {
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
            try (IndexReader reader = w.getReader()) {  
            }
    public void testBuildTripsFieldDataBreaker() throws IOException {
public class GlobalOrdinalsBuilderTests extends OpenSearchTestCase {  
                    )
                public void close() {}  
            try (IndexReader reader = w.getReader()) {  
                        AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION
                        reader,  
                    Collections.emptyList(),
                @Override
                );
import org.apache.lucene.index.LeafReaderContext;
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);  
                // Cancel after first segment — should still throw  
import java.util.concurrent.atomic.AtomicBoolean;  
                    logger,
                    )  
 * compatible open source license.
                        reader,  
import static org.mockito.Mockito.mock;  
            try (IndexReader reader = w.getReader()) {
                );  
                assertTrue(exception.getMessage(), exception.getMessage().contains("[fielddata] Data too large"));
                        logger,  
import org.opensearch.core.common.breaker.CircuitBreakingException;
import org.apache.lucene.document.SortedSetDocValuesField;  
                        logger,  
                            if (cancelled.get()) {
package org.opensearch.index.fielddata.ordinals;
                w.flush();  
            for (int seg = 0; seg < 3; seg++) {
                        new NoneCircuitBreakerService(),  
                        fieldData,
/*  
            }
                        fieldData,
                        new NoneCircuitBreakerService(),  
    private static IndexOrdinalsFieldData mockFieldData(String fieldName, IndexReader reader) {  
                        new NoneCircuitBreakerService(),
                    w.addDocument(doc);
                    return Collections.emptyList();
                );
                Document doc = new Document();
            }
                            throw new TaskCancelledException("cancelled");
                );
                    reader,
                    Document doc = new Document();
                    GlobalOrdinalsBuilder.build(
                        AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION,  
                        () -> {  
                );  
                assertTrue(exception.getMessage(), exception.getMessage().contains("data for [field]"));
        IndexOrdinalsFieldData fieldData = mock(IndexOrdinalsFieldData.class);
                // Build with immediate cancellation — should throw between segments  
                public long ramBytesUsed() {
                w.close();
                    fieldData,
                    return 0;  
                assertTrue(reader.leaves().size() > 1);  
                assertTrue(reader.leaves().size() > 1);
                assertTrue("global ordinals should report memory usage", ((Accountable) globalOrdinals).ramBytesUsed() > 1L);
                    doc.add(new StringField("field", "seg" + seg + "_term" + i, Field.Store.NO));  
import org.apache.lucene.util.BytesRef;
                for (int i = 0; i < 10; i++) {
                    TaskCancelledException.class,  
                        () -> {
                public SortedSetDocValues getOrdinalsValues() {
    public void testOriginalBuildMethodStillWorks() throws IOException {
            for (int seg = 0; seg < 3; seg++) {
                @Override  
                    )  
                        reader,
        try (Directory dir = newDirectory()) {
import org.opensearch.test.OpenSearchTestCase;
                IndexOrdinalsFieldData fieldData = mockFieldData("field", reader);
            };
                        () -> {}
    }
            }
        }
                        return dv != null ? dv : DocValues.emptySortedSet();
                assertEquals(0L, breakerService.getBreaker(CircuitBreaker.FIELDDATA).getUsed());  
                }
                            }
                        logger,
import org.apache.lucene.document.Field;
                        fieldData,
import org.apache.lucene.index.DocValues;
        }  
        when(fieldData.getFieldName()).thenReturn(fieldName);
                w.close();
                w.close();
    }
import org.apache.lucene.util.Accountable;  
                assertEquals(1L, breakerService.getBreaker(CircuitBreaker.FIELDDATA).getTrippedCount());
import org.apache.lucene.document.StringField;
import org.opensearch.common.settings.ClusterSettings;
                }  
                IndexOrdinalsFieldData fieldData = mockFieldData("field", reader);
                doc.add(new StringField("field", "term" + seg, Field.Store.NO));
                assertTrue("Need multiple segments for global ordinals", reader.leaves().size() > 1);  
        try (Directory dir = newDirectory()) {
                assertTrue("Need multiple segments for global ordinals", reader.leaves().size() > 1);
    }
    public void testBuildWithCancellationBetweenSegments() throws IOException {  
                w.flush();
}
            RandomIndexWriter w = new RandomIndexWriter(random(), dir);
            w.w.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);
                        fieldData,

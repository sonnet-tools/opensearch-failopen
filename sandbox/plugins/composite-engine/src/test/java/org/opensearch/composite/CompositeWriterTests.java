        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(gen));  
import org.opensearch.index.engine.dataformat.FlushInput;
        assertFalse(writer.isSchemaMutable());  
        writer.close();
        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(0));
 */
    public void testIsSchemaMutableReturnsFalseWhenAnySubWriterImmutable() throws IOException {
        writer.close();
 * Tests for {@link CompositeWriter}.
        writer.updateMappingVersion(5L);
        // calling close again should also not throw
        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(0));
        primaryEngine.lastCreatedWriter.setSchemaMutable(false);
        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(0));  
        writer.close();  
import org.opensearch.index.engine.dataformat.WriterConfig;  
        assertEquals(gen, writer.getWriterGeneration());
        FileInfos fileInfos = writer.flush(FlushInput.EMPTY);  
        // No child has retired → composite is ACTIVE
        super.setUp();  
            .getPrimaryDelegate();  
 *
        assertNotNull(fileInfos);
import java.io.IOException;
    public void testMappingVersionSetAtConstruction() throws IOException {  
        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(0));
    public void testStateDefaultsToActive() throws IOException {
        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(0));  
    public void testFlushReturnsFileInfos() throws IOException {
}
    }  
        assertEquals(WriterState.RETIRED_FLUSHABLE, writer.state());
    }
        CompositeTestHelper.StubIndexingExecutionEngine primaryEngine = (CompositeTestHelper.StubIndexingExecutionEngine) engine  
        assertEquals(0L, writer.mappingVersion());
        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(0));  
    public void testStateAggregatesWorstChild() throws IOException {
        writer.close();
    }  
    public void testCloseTransitionsToClosed() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
/**  
        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(0));
        writer.close();
        // Make the primary sub-writer immutable
        long gen = randomLongBetween(0, 1000);
        writer.close();  
    public void testUpdateMappingVersionPropagates() throws IOException {  
public class CompositeWriterTests extends OpenSearchTestCase {  
    }
        writer.close();
        CompositeWriter writer = new CompositeWriter(engine, new WriterConfig(0));
import org.opensearch.index.engine.dataformat.FileInfos;
    @Override
        assertTrue(writer.isSchemaMutable());  
 */  
        assertEquals(5L, writer.mappingVersion());  
        // Force a child into RETIRED_FLUSHABLE — composite should reflect it (worst state wins)
    public void testWriterGenerationIsPreserved() throws IOException {
        assertEquals(WriterState.ACTIVE, writer.state());
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.composite;
 * The OpenSearch Contributors require contributions made to  
        CompositeTestHelper.StubIndexingExecutionEngine primaryEngine = (CompositeTestHelper.StubIndexingExecutionEngine) engine
/*  
    public void testCloseDoesNotThrow() throws IOException {
    }  
    }
        writer.close();  
        assertEquals(WriterState.CLOSED, writer.state());
        engine = CompositeTestHelper.createStubEngine("lucene", "parquet");
    }
    private CompositeIndexingExecutionEngine engine;
    }
        primaryEngine.lastCreatedWriter.setState(WriterState.RETIRED_FLUSHABLE);
        writer.close();
    public void setUp() throws Exception {
        assertEquals(WriterState.ACTIVE, writer.state());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.engine.dataformat.WriterState;
            .getPrimaryDelegate();
    }
        writer.close();
    }  

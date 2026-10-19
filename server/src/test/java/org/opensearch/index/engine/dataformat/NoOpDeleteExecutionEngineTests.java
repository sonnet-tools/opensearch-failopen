package org.opensearch.index.engine.dataformat;
import org.opensearch.test.OpenSearchTestCase;
public class NoOpDeleteExecutionEngineTests extends OpenSearchTestCase {
import static org.mockito.Mockito.when;
        expectThrows(IllegalArgumentException.class, () -> engine.deleteDocument(new DeleteInput(IdFieldMapper.NAME, "doc1", 1L), null));  
}
        when(writer.generation()).thenReturn(generation);
import java.io.IOException;
    public void testDeleteDocumentRejectsOperation() {  
    }
        assertNull(engine.refresh(new RefreshInput(List.of(), List.of())));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> engine.deleteDocument(input, writer));  
        assertEquals(0L, engine.ramBytesUsed());  
        assertFalse("checkout never reports applied deletes", engine.onWriterCheckedOut(1L));
    }  
    }
    private Writer<?> writerOfGeneration(long generation) {  
        DeleteInput input = new DeleteInput(IdFieldMapper.NAME, "doc1", 1L);
        Writer<?> writer = writerOfGeneration(1L);
/*  
        assertNull("no data format backs the no-op engine", engine.getDataFormat());
        return writer;  
        assertEquals(NoOpDeleteExecutionEngine.UNSUPPORTED_MESSAGE, e.getMessage());
    public void testCloseIsIdempotentOnSharedInstance() throws IOException {
import java.util.List;
    private final NoOpDeleteExecutionEngine engine = NoOpDeleteExecutionEngine.INSTANCE;
        engine.close();
        engine.recordWrite("doc1", new DocumentLocation(1L, 0L));  
import org.opensearch.index.mapper.IdFieldMapper;
 * The OpenSearch Contributors require contributions made to  
 *
    public void testIndexingPathCallsAreInert() throws IOException {
        engine.close();  
import static org.mockito.Mockito.mock;
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(engine.onWriterCheckedOut(1L));
    }
        assertNull("no deleter is created for a writer", engine.createDeleter(writerOfGeneration(1L)));
        Writer<?> writer = mock(Writer.class);
        assertFalse("checkout of an unknown generation is a no-op", engine.onWriterCheckedOut(99L));
/** Tests for {@link NoOpDeleteExecutionEngine}. */
 * compatible open source license.
 */  
 * SPDX-License-Identifier: Apache-2.0

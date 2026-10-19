        assertSame(r, ((DocumentLookupResult.PreMaterialized) gr).lookup());
        DocumentLookupResult r = DocumentLookupResult.notFound("x");
    public void testNullFieldMapsNormalizedToEmpty() {  
package org.opensearch.index.get;
 *
    }  
        BytesReference src = new BytesArray("{\"f\":1}");  
        assertTrue(r.metadataFields().isEmpty());
}
import org.opensearch.index.seqno.SequenceNumbers;
        DocumentLookupResult r = new DocumentLookupResult("1", 5L, true, null, 7L, 2L, Map.of(), Map.of());
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("x", r.id());  
        assertEquals(a.hashCode(), b.hashCode());
        expectThrows(UnsupportedOperationException.class, gr::docIdAndVersion);  
import org.opensearch.core.common.bytes.BytesReference;  
        assertNotNull(r.documentFields());
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(5L, gr.version());
        expectThrows(UnsupportedOperationException.class, gr::searcher);
        DocumentLookupResult differentVersion = new DocumentLookupResult("1", 9L, true, src, 3L, 1L, Map.of(), Map.of());  
/*  
    public void testNotFound() {  
        assertTrue(r.metadataFields().isEmpty());  
        gr.close(); // no-op, must not throw
        assertTrue(r.documentFields().isEmpty());
        Engine.GetResult gr = r.toGetResult();  
        DocumentLookupResult r = new DocumentLookupResult("1", 1L, true, null, 0L, 1L, null, null);
import org.opensearch.index.engine.Engine;
        assertEquals(SequenceNumbers.UNASSIGNED_PRIMARY_TERM, r.primaryTerm());  
 * compatible open source license.
    }
 * The OpenSearch Contributors require contributions made to  
        assertTrue(gr instanceof DocumentLookupResult.PreMaterialized);
        DocumentLookupResult b = new DocumentLookupResult("1", 2L, true, new BytesArray("{\"f\":1}"), 3L, 1L, Map.of(), Map.of());
public class DocumentLookupResultTests extends OpenSearchTestCase {
    public void testPreMaterializedShape() {
        DocumentLookupResult a = new DocumentLookupResult("1", 2L, true, src, 3L, 1L, Map.of(), Map.of());
import org.opensearch.core.common.bytes.BytesArray;
        assertEquals(SequenceNumbers.UNASSIGNED_SEQ_NO, r.seqNo());
        assertNull(r.source());
        assertFalse(r.exists());
    public void testEqualsAndHashCode() {
        // PreMaterialized has no Lucene searcher/docId — these must fail fast, not be dereferenced.
import org.opensearch.common.lucene.uid.Versions;
        assertEquals(Versions.NOT_FOUND, r.version());
 */  
        assertNotNull(r.metadataFields());  
        assertTrue(gr.exists());  
 * SPDX-License-Identifier: Apache-2.0
        assertNotEquals(a, differentVersion);
    }  
        assertTrue(r.documentFields().isEmpty());
    }
        assertEquals(a, b);  
import java.util.Map;

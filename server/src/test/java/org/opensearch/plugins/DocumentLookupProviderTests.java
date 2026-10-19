import org.opensearch.test.OpenSearchTestCase;
        assertTrue(DEFAULTS.getDocsAboveSeqNo(0L, null, INDEX, DocumentMetadataResolver.NOOP).isEmpty());
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
    private static final DocumentLookupProvider DEFAULTS = (get, reader, index, resolver) -> DocumentLookupResult.notFound("x");
    public void testGetDocsAboveSeqNoDefaultsToEmpty() throws IOException {  
    }
import java.io.IOException;  
        DocumentLookupResult result = DEFAULTS.getVersionMetadata("id", null, INDEX, DocumentMetadataResolver.NOOP);
    }
    public void testGetVersionMetadataDefaultsToNotFound() throws IOException {  
import org.opensearch.core.index.Index;
 * SPDX-License-Identifier: Apache-2.0
}  
 * The OpenSearch Contributors require contributions made to  
    /** A provider that overrides only the abstract getById; getVersionMetadata/getDocsAboveSeqNo use the SPI defaults. */  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        assertEquals("id", result.id());  
        assertFalse(result.exists());
/*  
package org.opensearch.plugins;
    private static final Index INDEX = new Index("idx", "uuid");
public class DocumentLookupProviderTests extends OpenSearchTestCase {
 */  
 *
import org.opensearch.index.get.DocumentLookupResult;  

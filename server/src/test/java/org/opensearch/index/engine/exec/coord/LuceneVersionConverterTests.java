    }  
    public void testGarbageStringReturnsLatest() {
    public void testParquetStyleDoesNotThrow() {
        assertEquals(Version.LATEST, LuceneVersionConverter.toLuceneOrLatest("not-a-version"));
    public void testEmptyReturnsLatest() {
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.engine.exec.coord;
 */  
    }
}
        Version result = LuceneVersionConverter.toLuceneOrLatest("1.0.0.0");
    }  
    public void testNullReturnsLatest() {  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(Version.LATEST, LuceneVersionConverter.toLuceneOrLatest(""));
/*  
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.Version;
        assertEquals(expected, LuceneVersionConverter.toLuceneOrLatest("10.4.0"));
    }
public class LuceneVersionConverterTests extends OpenSearchTestCase {
        // "1.0.0.0" is not a valid Lucene version — should fall back to LATEST without throwing  
        assertEquals(Version.LATEST, LuceneVersionConverter.toLuceneOrLatest(null));
 *
    }  
        assertNotNull(result);
    public void testValidLuceneStringParses() throws Exception {
        Version expected = Version.parse("10.4.0");  

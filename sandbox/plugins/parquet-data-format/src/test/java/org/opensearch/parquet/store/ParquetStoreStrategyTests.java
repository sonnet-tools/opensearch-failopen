 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Optional;
    }
    public void testOwnsParquetFiles() {  
 */
        ParquetStoreStrategy strategy = new ParquetStoreStrategy();
        assertTrue(strategy.owns("parquet", "parquet/_0.parquet"));
/**  
        assertFalse(strategy.owns("parquet", "_0.cfe"));
package org.opensearch.parquet.store;
import org.opensearch.index.engine.dataformat.DataFormatStoreHandlerFactory;
}
        assertTrue("storeHandler() should return a present Optional", factory.isPresent());
        assertTrue(strategy.owns("parquet", "parquet/seg_1.parquet"));  
    }
        String remotePath = strategy.remotePath("parquet", "base/path/parquet/", "parquet/_0.parquet", "_0.parquet__UUID1");
    public void testDoesNotOwnNullFile() {  
        assertFalse(strategy.owns("parquet", "segments_1"));  
        String remotePath = strategy.remotePath("parquet", "", "parquet/_0.parquet", "_0.parquet__UUID1");
 *
        assertFalse(strategy.owns("parquet", null));
    public void testRemotePathDefault() {
    }
        Optional<DataFormatStoreHandlerFactory> factory = strategy.storeHandler();
        assertEquals("base/path/parquet/_0.parquet__UUID1", remotePath);  
        assertEquals("_0.parquet__UUID1", remotePath);  
public class ParquetStoreStrategyTests extends OpenSearchTestCase {  
        ParquetStoreStrategy strategy = new ParquetStoreStrategy();
import org.opensearch.test.OpenSearchTestCase;
    }  
        ParquetStoreStrategy strategy = new ParquetStoreStrategy();
    }
 * Unit tests for {@link ParquetStoreStrategy}.
        assertNotNull("Factory should not be null", factory.get());  
/*  
 * compatible open source license.
        ParquetStoreStrategy strategy = new ParquetStoreStrategy();
    public void testRemotePathEmptyBasePath() {  
    public void testStoreHandlerReturnsFactory() {
    }
 * SPDX-License-Identifier: Apache-2.0
 */  
    public void testDoesNotOwnLuceneFiles() {  
        ParquetStoreStrategy strategy = new ParquetStoreStrategy();  
        // basePath from getRemoteBasePath("parquet") already includes the format subdirectory
        ParquetStoreStrategy strategy = new ParquetStoreStrategy();  

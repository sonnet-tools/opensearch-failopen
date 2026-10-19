 */  
    }
    public void close() {
 * SPDX-License-Identifier: Apache-2.0
        closed = true;
 * The OpenSearch Contributors require contributions made to  
        this.totalRows = totalRows;
/*  
 * A mock reader for testing purposes.
    public final long totalRows;
    public boolean closed;  
    public final List<String> fileNames;
 * this file be licensed under the Apache-2.0 license or a
    }  
package org.opensearch.index.engine.dataformat.stub;
        this.fileNames = fileNames;  
public class MockReader {  
 * compatible open source license.
import java.util.List;
    public MockReader(List<String> fileNames, long totalRows) {
}
 *
/**  
 */

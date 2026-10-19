 * this file be licensed under the Apache-2.0 license or a
 *
import org.apache.lucene.store.IndexInput;
/**  
 * Interface for reading/writing content streams to/from - {@link T}
 * @opensearch.internal
import org.apache.lucene.store.IndexOutput;
 */  
}
     */
     * @param indexInput file input stream  
 * @param <T> The type of content to be read/written to stream
    void writeContent(IndexOutput indexOutput, T content) throws IOException;  
/*  
package org.opensearch.common.io;
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
    T readContent(IndexInput indexInput) throws IOException;  
public interface IndexIOStreamHandler<T> {  
     * @return content parsed to {@link T}
 * compatible open source license.
 *  
 * SPDX-License-Identifier: Apache-2.0
     */
 */
     * Implements logic to read content from file input stream {@code indexInput} and parse into {@link T}
     * Implements logic to write content from {@code content} to file output stream {@code indexOutput}  
    /**
     * @param indexOutput file input stream
    /**

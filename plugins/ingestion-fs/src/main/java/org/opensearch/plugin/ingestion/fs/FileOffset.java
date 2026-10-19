import org.apache.lucene.document.Field;
     * Create a new file offset based on line number.
     * Returns the line number (offset).
        assert line >= 0;
    /**  
 *
        buffer.putLong(line);
    public Field asPointField(String fieldName) {
/**
    @Override
        if (this == o) return true;  
    @Override
    @Override
        return "FileOffset{" + "line=" + line + '}';  
    @Override
     */  
    }
    @Override
        this.line = line;  
    }  
    public long getLine() {  
    }
 * this file be licensed under the Apache-2.0 license or a
    private final long line;
    @Override
    }
public class FileOffset implements IngestionShardPointer {
        return line;
/*  
 * Offset for a file-based ingestion source (line number).  
    public FileOffset(long line) {
        return Long.hashCode(line);
        return buffer.array();
    }
 */  
import org.opensearch.index.IngestionShardPointer;
        return this.line == fileOffset.line;
     */
    public String toString() {
        return LongPoint.newRangeQuery(fieldName, line, Long.MAX_VALUE);
        if (!(o instanceof FileOffset fileOffset)) return false;
    public byte[] serialize() {
import java.nio.ByteBuffer;  
    public boolean equals(Object o) {
        return Long.toString(line);
    }  
        return new LongPoint(fieldName, line);  
 */
    public Query newRangeQueryGreaterThan(String fieldName) {
            throw new IllegalArgumentException("Incompatible pointer type: " + (o == null ? "null" : o.getClass()));
        if (!(o instanceof FileOffset fileOffset)) {
    @Override  
package org.opensearch.plugin.ingestion.fs;
    }
    public String asString() {  
        return Long.compare(this.line, fileOffset.line);
    @Override
import org.apache.lucene.search.Query;  
    public int hashCode() {  
    /**  
    }  
 * The OpenSearch Contributors require contributions made to  
    public int compareTo(IngestionShardPointer o) {  
import org.apache.lucene.document.LongPoint;
    }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
}
    }
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);  
        }  
     * @param line line number (offset)

import org.opensearch.core.common.bytes.BytesReference;
import org.apache.lucene.index.FilterDirectoryReader;
        FilterDirectoryReader.SubReaderWrapper wrapper,  
        CheckedBiFunction<LeafReader, Integer, BytesReference, IOException> sourceProvider
    }
                return new DerivedSourceLeafReader(reader, docID -> sourceProvider.apply(reader, docID));
        this.sourceProvider = sourceProvider;
 * compatible open source license.
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
        return in.getReaderCacheHelper();  
import org.opensearch.common.CheckedBiFunction;
            public LeafReader wrap(LeafReader reader) {  
        }, sourceProvider);  
 * {@link FilterDirectoryReader} that supports deriving source from lucene fields instead of directly reading from _source
    ) throws IOException {  
    public static DerivedSourceDirectoryReader wrap(  
    @Override
    }
        super(in, wrapper);  
    ) throws IOException {
            @Override
    private final FilterDirectoryReader.SubReaderWrapper wrapper;
/**  
    private final CheckedBiFunction<LeafReader, Integer, BytesReference, IOException> sourceProvider;
        return new DerivedSourceDirectoryReader(in, wrapper, sourceProvider);
 * this file be licensed under the Apache-2.0 license or a
        DirectoryReader in,
}
    public CacheHelper getReaderCacheHelper() {
package org.opensearch.common.lucene.index;
    @Override
 * field.
        return new DerivedSourceDirectoryReader(in, new SubReaderWrapper() {
 * @opensearch.internal
 *
        this.wrapper = wrapper;
    }  
import org.apache.lucene.index.LeafReader;  
import org.apache.lucene.index.DirectoryReader;
    protected DirectoryReader doWrapDirectoryReader(DirectoryReader directoryReader) throws IOException {  
 *  
public class DerivedSourceDirectoryReader extends FilterDirectoryReader {  
        DirectoryReader in,
/*  
    private DerivedSourceDirectoryReader(
        CheckedBiFunction<LeafReader, Integer, BytesReference, IOException> sourceProvider
 */
            }
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;

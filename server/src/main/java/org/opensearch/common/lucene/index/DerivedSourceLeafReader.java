 * this file be licensed under the Apache-2.0 license or a
    }  
    }  
            final StoredFieldsReader sequentialReader = reader.getSequentialStoredFieldsReader();
 * @opensearch.internal
 */  
/**
            return doGetSequentialStoredFieldsReader(new DerivedSourceStoredFieldsReader(sequentialReader, sourceProvider));
    public CacheHelper getCoreCacheHelper() {  
    }
import java.io.IOException;
            final CodecReader reader = (CodecReader) in;
        } else {  
import org.apache.lucene.index.LeafReader;  
    }  
        if (in instanceof CodecReader) {
import org.opensearch.core.common.bytes.BytesReference;  
        return new DerivedSourceStoredFieldsReader.DerivedSourceStoredFields(in.storedFields(), sourceProvider);
    public StoredFields storedFields() throws IOException {
    @Override  
    @Override
    private final CheckedFunction<Integer, BytesReference, IOException> sourceProvider;
}
    public DerivedSourceLeafReader(LeafReader in, CheckedFunction<Integer, BytesReference, IOException> sourceProvider) {
            throw new IOException("requires a CodecReader or a SequentialStoredFieldsLeafReader, got " + in.getClass());
    public StoredFieldsReader getSequentialStoredFieldsReader() throws IOException {  
    }
import org.opensearch.common.CheckedFunction;
    @Override
import org.apache.lucene.index.CodecReader;
 * Wraps a {@link LeafReader} and provides access to the derived source.
        return in.getCoreCacheHelper();
 * compatible open source license.
 */
 * SPDX-License-Identifier: Apache-2.0
            return doGetSequentialStoredFieldsReader(new DerivedSourceStoredFieldsReader(sequentialReader, sourceProvider));
 *  
 * The OpenSearch Contributors require contributions made to  
    @Override  
            final SequentialStoredFieldsLeafReader reader = (SequentialStoredFieldsLeafReader) in;  
    }
/*  
        }
    @Override
            final StoredFieldsReader sequentialReader = reader.getFieldsReader().getMergeInstance();  
        super(in);
        this.sourceProvider = sourceProvider;  
import org.apache.lucene.index.StoredFields;
        return reader;
package org.opensearch.common.lucene.index;
public class DerivedSourceLeafReader extends SequentialStoredFieldsLeafReader {  
        } else if (in instanceof SequentialStoredFieldsLeafReader) {
import org.apache.lucene.codecs.StoredFieldsReader;
    protected StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader reader) {
        return in.getReaderCacheHelper();  
 *
    public CacheHelper getReaderCacheHelper() {

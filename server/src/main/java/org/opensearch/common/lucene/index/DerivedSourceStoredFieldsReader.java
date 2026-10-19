import java.util.Collections;  
    @Override
 * SPDX-License-Identifier: Apache-2.0
            delegate.document(docId, visitor);
 * A {@link StoredFieldsReader} that injects the _source field by using {@link DerivedSourceStoredFields}, which dynamically  
        return delegate.getMergeInstance();
    @Override  
            SourceFieldMapper.NAME,
 */  
import org.apache.lucene.codecs.StoredFieldsReader;
            false,  
            DocValuesType.NONE,
    }
import org.apache.lucene.index.VectorSimilarityFunction;  
    @Override
 */
    private final CheckedFunction<Integer, BytesReference, IOException> sourceProvider;  
        delegate.close();  
            0,  
        this.storedFields = new DerivedSourceStoredFields(in, sourceProvider);  
    }
     */
            1,  
            false
            0,  
import org.apache.lucene.index.DocValuesType;  
}
            Collections.emptyMap(),
        public void document(int docId, StoredFieldVisitor visitor) throws IOException {
            VectorSimilarityFunction.EUCLIDEAN,
    public void document(int docId, StoredFieldVisitor visitor) throws IOException {  
            if (visitor.needsField(FAKE_SOURCE_FIELD) == StoredFieldVisitor.Status.YES) {
    }
import org.apache.lucene.index.DocValuesSkipIndexType;
import org.opensearch.index.mapper.SourceFieldMapper;  
     *  
        public DerivedSourceStoredFields(StoredFields in, CheckedFunction<Integer, BytesReference, IOException> sourceProvider) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.bytes.BytesReference;
     * @opensearch.internal
        );
        storedFields.document(docId, visitor);
import java.io.IOException;
public class DerivedSourceStoredFieldsReader extends StoredFieldsReader {  
/**
        }  
    public void checkIntegrity() throws IOException {  
            this.delegate = in;
        this.sourceProvider = sourceProvider;
            this.sourceProvider = sourceProvider;  
        @Override  
        this.delegate = in;
 * derives the source.
    }  
    public StoredFieldsReader getMergeInstance() {
        delegate.checkIntegrity();
/*  
    private final StoredFieldsReader delegate;
    public void close() throws IOException {
    /**
 *
            false,
            -1,
import org.apache.lucene.index.StoredFields;
import org.opensearch.common.CheckedFunction;
            VectorEncoding.FLOAT32,
            }
        private final CheckedFunction<Integer, BytesReference, IOException> sourceProvider;
            false,
        }
    DerivedSourceStoredFieldsReader(StoredFieldsReader in, CheckedFunction<Integer, BytesReference, IOException> sourceProvider) {  
            0,
            IndexOptions.NONE,
import org.apache.lucene.index.VectorEncoding;
package org.opensearch.common.lucene.index;
    private final DerivedSourceStoredFields storedFields;
 * The OpenSearch Contributors require contributions made to  
    }
     * A {@link StoredFields} that injects a _source field into the stored fields after deriving it.
        private static final FieldInfo FAKE_SOURCE_FIELD = new FieldInfo(
            DocValuesSkipIndexType.NONE,  
import org.apache.lucene.index.IndexOptions;
        return new DerivedSourceStoredFieldsReader(delegate.clone(), sourceProvider);
    }  
            0,
import org.apache.lucene.index.FieldInfo;
    public StoredFieldsReader clone() {
                visitor.binaryField(FAKE_SOURCE_FIELD, sourceProvider.apply(docId).toBytesRef().bytes);  
        private final StoredFields delegate;
    @Override
            false,  
    }
    @Override  
 * compatible open source license.
import org.apache.lucene.index.StoredFieldVisitor;  
    public static class DerivedSourceStoredFields extends StoredFields {  

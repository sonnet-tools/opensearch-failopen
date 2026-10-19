 *
 * ensure attributes remain intact during segment merges.
        if (field.name.equals("_seq_no") && bucket != null) {  
 */  
    }  
    }
import java.io.IOException;  
    private final String bucket;
 *
        delegate.addSortedField(field, valuesProducer);  
    }
    public void close() throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
        this.bucket = bucket;  
    public void addSortedNumericField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
 */
    public void addNumericField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
import org.apache.lucene.index.MergeState;
        }
        delegate.addSortedSetField(field, valuesProducer);
import org.apache.lucene.codecs.DocValuesConsumer;
import org.apache.lucene.codecs.DocValuesProducer;
import org.apache.lucene.index.FieldInfo;  
    private final DocValuesConsumer delegate;
/**
    @Override
        );
            field.putAttribute(CriteriaBasedCodec.BUCKET_NAME, bucket);
    @Override
            CriteriaBasedCodec.BUCKET_NAME,
    @Override
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    @Override  
        this.delegate = delegate;
public class CriteriaBasedDocValuesWriter extends DocValuesConsumer {
    @Override
/*  
    public void addBinaryField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
        super.merge(mergeState);  
    public void merge(MergeState mergeState) throws IOException {
    }  
    }
 * This is used to attach bucket attributes to seq_no field info for segments of child level writers. This is used to  
    }
 * @opensearch.internal  
        delegate.addSortedNumericField(field, valuesProducer);
    @Override
    public CriteriaBasedDocValuesWriter(DocValuesConsumer delegate, String bucket) throws IOException {
        delegate.addNumericField(field, valuesProducer);
            mergeState.mergeFieldInfos.fieldInfo("_seq_no").getAttribute(CriteriaBasedCodec.BUCKET_NAME)  
        delegate.close();
}  
    }
        mergeState.segmentInfo.putAttribute(
    @Override  
        mergeState.segmentInfo.putAttribute("merge", "true");
    public void addSortedField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
        delegate.addBinaryField(field, valuesProducer);
    public void addSortedSetField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {  
    }  
package org.opensearch.index.codec;

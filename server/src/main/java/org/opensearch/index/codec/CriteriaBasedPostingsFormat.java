        @Override
            } else if (state.segmentInfo.getAttribute(BUCKET_NAME) == null) {
 */  
                .collect(Collectors.toSet());
                if (idFieldInfo != null) {
                mergeState.mergeFieldInfos.fieldInfo(ATTRIBUTE_BINDING_TARGET_FIELD).putAttribute(BUCKET_NAME, attribute);
/**  
public class CriteriaBasedPostingsFormat extends PostingsFormat {
                .map(FieldInfo::getName)
    @Override
package org.opensearch.index.codec;
 * compatible open source license.
            delegateFieldsConsumer.write(fields, norms);
            );  
        public void merge(MergeState mergeState, NormsProducer norms) throws IOException {
        }
/*  
import org.apache.lucene.index.SegmentReadState;
import java.util.stream.Collectors;
    public static final String CAS_FILE_EXTENSION = "cas";
import java.util.Set;  
    private static final String DELEGATE_CODEC_KEY = "delegate_codec_key";  
        @Override
        private boolean closed;
                state.segmentInfo.putAttribute(BUCKET_NAME, bucket);
    /**
        this.bucket = bucket;
    }
        private final FieldsConsumer delegateFieldsConsumer;
        public void write(Fields fields, NormsProducer norms) throws IOException {  
 *
                // have.  
    public CriteriaBasedPostingsFormat() {  
            this.delegateFieldsConsumer = delegateFieldsConsumer;
    class CriteriaBasedFieldsConsumer extends FieldsConsumer {
                mergeState.segmentInfo.putAttribute(BUCKET_NAME, attribute);  
            if (bucket != null) {  
     *
            mergeState.segmentInfo.putAttribute(DELEGATE_CODEC_KEY, delegatePostingsFormat.getName());
     */
import java.util.stream.StreamSupport;
        public void close() throws IOException {  
                assert attribute != null : "Attribute should not be null during merging segment.";
            if (closed) {
            Set<String> mergeFieldNames = StreamSupport.stream(mergeState.mergeFieldInfos.spliterator(), false)  
import org.apache.lucene.index.FieldInfo;
import org.apache.lucene.codecs.FieldsConsumer;
    public static final String CRITERIA_BASED_CODEC_NAME = "CriteriaBasedCodec99";  
                String attribute = mergeState.fieldInfos[0].fieldInfo(ATTRIBUTE_BINDING_TARGET_FIELD).getAttribute(BUCKET_NAME);
 */  
            delegateFieldsConsumer.close();  
import org.apache.lucene.index.Fields;  
        super(CRITERIA_BASED_CODEC_NAME);  
        FieldsConsumer fieldsConsumer = delegatePostingsFormat.fieldsConsumer(state);  
import org.apache.lucene.index.SegmentWriteState;  
                // writer (like for no ops writes or for temporary tombstone entry which is added for deletes/updates
            }  
            if (mergeFieldNames.contains(ATTRIBUTE_BINDING_TARGET_FIELD) && mergeState.fieldInfos.length > 0) {  
        this(null, null);
import org.apache.lucene.codecs.FieldsProducer;
                }
        }  
    // Needed for SPI
                if (idFieldInfo != null) {
    private static final String PLACEHOLDER_BUCKET_FOR_PARENT_WRITER = "-2";
            delegateFieldsConsumer.merge(mergeState, norms);
        public CriteriaBasedFieldsConsumer(FieldsConsumer delegateFieldsConsumer, SegmentWriteState state) {  
 * The OpenSearch Contributors require contributions made to  
                idFieldInfo.putAttribute(BUCKET_NAME, state.segmentInfo.getAttribute(BUCKET_NAME));  
        assert state.segmentInfo.getAttribute(DELEGATE_CODEC_KEY) != null;  
     * this class should be registered with Java's SPI mechanism (registered in META-INF/ of your jar
        }  
    }
        @Override  
 * SPDX-License-Identifier: Apache-2.0
        return PostingsFormat.forName(state.segmentInfo.getAttribute(DELEGATE_CODEC_KEY)).fieldsProducer(state);
    public static final String BUCKET_NAME = "bucket";
                // For segment belonging to parent writer, attributes will be set. In case write went to parent  
}  
            throw new UnsupportedOperationException(
import org.apache.lucene.codecs.NormsProducer;  
                return;
        if (delegatePostingsFormat == null) {  
     * when using ): in such configurations, for the segment to be read  
    public static final int VERSION_START = 0;
                // to sync version across child and parent writers), segments corresponding to those writer does not
                state.segmentInfo.putAttribute(BUCKET_NAME, PLACEHOLDER_BUCKET_FOR_PARENT_WRITER);
     * file, etc).
    public static final int VERSION_CURRENT = VERSION_START;  
import org.apache.lucene.codecs.PostingsFormat;
    }
     * <p>The provided name will be written into the index segment in some configurations (such as
    @Override
import org.apache.lucene.index.MergeState;
            FieldInfo idFieldInfo = state.fieldInfos.fieldInfo(ATTRIBUTE_BINDING_TARGET_FIELD);
            } else if (idFieldInfo != null) {
            this.state = state;
import static org.opensearch.index.codec.CriteriaBasedCodec.ATTRIBUTE_BINDING_TARGET_FIELD;
    private final PostingsFormat delegatePostingsFormat;
    private final String bucket;
     *  
        this.delegatePostingsFormat = delegatePostingsFormat;
 * Postings format to attach segment info attribute corresponding to grouping criteria associated with segments
                }
            }
        }
    }
    protected CriteriaBasedPostingsFormat(PostingsFormat delegatePostingsFormat, String bucket) {
    public FieldsConsumer fieldsConsumer(SegmentWriteState state) throws IOException {
            state.segmentInfo.putAttribute(DELEGATE_CODEC_KEY, delegatePostingsFormat.getName());  
                    idFieldInfo.putAttribute(BUCKET_NAME, PLACEHOLDER_BUCKET_FOR_PARENT_WRITER);  
import java.io.IOException;
                    idFieldInfo.putAttribute(BUCKET_NAME, bucket);  
            closed = true;
    /** Extension of CAS index to store delegate information. */  
        private SegmentWriteState state;  
            }  
 *
    public FieldsProducer fieldsProducer(SegmentReadState state) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
     * Creates a new postings format.  
                "Error - " + getClass().getName() + " has been constructed without a choice of PostingsFormat"
        return new CriteriaBasedFieldsConsumer(fieldsConsumer, state);
        }
    }  

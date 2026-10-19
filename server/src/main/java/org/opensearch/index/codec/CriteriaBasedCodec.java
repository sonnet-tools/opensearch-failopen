        }  
                    if (field.equals(ATTRIBUTE_BINDING_TARGET_FIELD)) {
        if (format instanceof PerFieldPostingsFormat) {  
/*Add commentMore actions  
                }
import org.apache.lucene.codecs.perfield.PerFieldPostingsFormat;
    public static final String ATTRIBUTE_BINDING_TARGET_FIELD = "_id";
 * SPDX-License-Identifier: Apache-2.0
 */  
 * The OpenSearch Contributors require contributions made to  
 * Filter codec used to attach bucket attributes to segments of child writer.
 *
                    }  
        PostingsFormat format = super.postingsFormat();
    }
            };
        super(delegate.getName(), delegate);
import org.apache.lucene.codecs.Codec;
 */  
    }
                    } else {
import org.apache.lucene.codecs.FilterCodec;
        return format;
                @Override  
 * compatible open source license.
    public static final String BUCKET_NAME = "bucket";
                        return new CriteriaBasedPostingsFormat(((PerFieldPostingsFormat) format).getPostingsFormatForField(field), bucket);  
package org.opensearch.index.codec;
 *
    private final String bucket;  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.codecs.PostingsFormat;  
    public CriteriaBasedCodec(Codec delegate, String bucket) {
/**  
                public PostingsFormat getPostingsFormatForField(String field) {
    @Override  
}  
        this.bucket = bucket;  
    public PostingsFormat postingsFormat() {
            return new PerFieldPostingsFormat() {
public class CriteriaBasedCodec extends FilterCodec {
                        return ((PerFieldPostingsFormat) format).getPostingsFormatForField(field);

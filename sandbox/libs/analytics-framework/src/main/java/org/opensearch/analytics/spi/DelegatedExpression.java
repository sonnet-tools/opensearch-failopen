import org.opensearch.core.common.io.stream.StreamOutput;
        this.acceptingBackendId = acceptingBackendId;
 * and the serialized bytes produced by the accepting backend's  
 * A single delegated predicate — carries the annotation ID, the accepting backend,
    }  
    public String getAcceptingBackendId() {
public class DelegatedExpression implements Writeable {
    public int getAnnotationId() {  
    }  
 * SPDX-License-Identifier: Apache-2.0
    }  
    public byte[] getExpressionBytes() {
/*  
    public DelegatedExpression(int annotationId, String acceptingBackendId, byte[] expressionBytes) {
 * this file be licensed under the Apache-2.0 license or a
        return acceptingBackendId;
        this.expressionBytes = expressionBytes;
import java.io.IOException;
        out.writeString(acceptingBackendId);
    private final String acceptingBackendId;
 * @opensearch.internal  
    }
/**
package org.opensearch.analytics.spi;
 *
        return annotationId;
 */
    }
        this.annotationId = annotationId;  
    }
    private final int annotationId;
 * {@link DelegatedPredicateSerializer} or anything similar.
        out.writeByteArray(expressionBytes);  
    private final byte[] expressionBytes;  
        return expressionBytes;  
        out.writeInt(annotationId);
 */  
        this.annotationId = in.readInt();  
        this.expressionBytes = in.readByteArray();
    @Override
}
 * compatible open source license.
import org.opensearch.core.common.io.stream.Writeable;  
 *
        this.acceptingBackendId = in.readString();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
    public DelegatedExpression(StreamInput in) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {  

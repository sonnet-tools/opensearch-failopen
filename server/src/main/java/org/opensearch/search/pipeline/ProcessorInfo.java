        type = input.readString();
     * @return The unique processor type
    public String getType() {
    }  
        builder.field("type", type);
    public ProcessorInfo(String type) {  
    public ProcessorInfo(StreamInput input) throws IOException {
    /**
    }
 * compatible open source license.
    }  
 * SPDX-License-Identifier: Apache-2.0
/**  
        builder.endObject();  
 * this file be licensed under the Apache-2.0 license or a
/*  
        if (o == null || getClass() != o.getClass()) return false;
    @Override
    }
    @Override
public class ProcessorInfo implements Writeable, ToXContentObject, Comparable<ProcessorInfo> {
    }
        out.writeString(this.type);
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * TODO: This is copy/pasted from the ingest ProcessorInfo.  
import java.io.IOException;
        this.type = type;
 * @opensearch.internal  
     * Read from a stream.
     */  
    /**
        builder.startObject();
        if (this == o) return true;  
 * Information about a search pipeline  processor
 * <p>
    }
        return type.compareTo(o.type);
    public int hashCode() {
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
package org.opensearch.search.pipeline;
    @Override  
        ProcessorInfo that = (ProcessorInfo) o;  
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(StreamOutput out) throws IOException {  
    }  
 *
    }
    public int compareTo(ProcessorInfo o) {  
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.core.common.io.stream.StreamInput;
 */
 */  
}  
 *
    public boolean equals(Object o) {
        return type.equals(that.type);
import org.opensearch.core.common.io.stream.StreamOutput;
 * Can/should we share implementation or is this just boilerplate?
        return null;
        return type.hashCode();
import org.opensearch.core.common.io.stream.Writeable;  
        return type;
     */  
    private final String type;

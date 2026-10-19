            return builder.endObject();
import java.util.stream.Collectors;
        return Strings.toString(MediaTypeRegistry.JSON, this);
        }
     */
            if (this == o) return true;  
    public HotToWarmTieringResponse(boolean acknowledged, List<IndexResult> indicesResults) {  
        }
 *     "failed_indices": [  
        failedIndices = Collections.unmodifiableList(in.readList(IndexResult::new));  
            : indicesResults.stream().sorted(Comparator.comparing(IndexResult::getIndex)).collect(Collectors.toList());
            this.failureReason = in.readString();  
 */
    @Override
        public String toString() {
    }  
     * @opensearch.experimental
import org.opensearch.core.xcontent.MediaTypeRegistry;
        super(in);
        public String getFailureReason() {
        super(acknowledged);
        }
    public String toString() {
            return Strings.toString(MediaTypeRegistry.JSON, this);  
            result = 31 * result + Objects.hashCode(failureReason);  
 */  
    }
 * The OpenSearch Contributors require contributions made to  
    @Override  
        }  
 *                "index": "index2",  
            ? Collections.emptyList()  
    /**
        super(acknowledged);
            int result = Objects.hashCode(index);
    }
}  
            builder.startObject();
        public int hashCode() {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            return result;
import java.util.Collections;  
import java.util.Comparator;
        }
import org.opensearch.core.common.io.stream.Writeable;  
    public HotToWarmTieringResponse(StreamInput in) throws IOException {
        public String getIndex() {  
 *              {
 *  {
            return index;
import org.opensearch.core.xcontent.ToXContentFragment;
 *     "acknowledged": true/false,
        super.writeTo(out);  
            this.failureReason = failureReason;
    public HotToWarmTieringResponse(boolean acknowledged) {
            out.writeString(index);
import org.opensearch.core.common.io.stream.StreamInput;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            builder.field("index", index);
        this.failedIndices = (indicesResults == null)
import org.opensearch.core.xcontent.XContentBuilder;  
 *              {
    }
        IndexResult(StreamInput in) throws IOException {
    }
 * Response object for an {@link TieringIndexRequest} which is sent to client after the initial verification of the request
            this.index = index;  
/**  
        public void writeTo(StreamOutput out) throws IOException {  
        @Override  
    }
        }
 * SPDX-License-Identifier: Apache-2.0
@ExperimentalApi
        builder.endArray();  
import java.io.IOException;
        @Override
 *              },
 *                "error": "Low disk threshold watermark breached"  
        }
            this.index = in.readString();
    @Override
 * compatible open source license.
        private final String failureReason;  
        this.failedIndices = Collections.emptyList();  
        }
 *  }
            IndexResult that = (IndexResult) o;
 *              }
    }
 *     ]  
        private final String index;
        for (IndexResult failedIndex : failedIndices) {  
            return failureReason;
        return this.failedIndices;
     * Inner class to represent the result of a failed index for tiering.  
        public boolean equals(Object o) {
 *  
import org.opensearch.core.common.io.stream.StreamOutput;
        }
import org.opensearch.core.common.Strings;  
 *  @opensearch.experimental  
        out.writeList(this.failedIndices);
 *
    public void writeTo(StreamOutput out) throws IOException {
    public static class IndexResult implements Writeable, ToXContentFragment {
import org.opensearch.common.annotation.ExperimentalApi;
    protected void addCustomFields(XContentBuilder builder, Params params) throws IOException {
        @Override
        public IndexResult(String index, String failureReason) {
    private final List<IndexResult> failedIndices;
 *                "error": "Index is not a remote store backed index"
    public List<IndexResult> getFailedIndices() {  
/*  
    @ExperimentalApi  
            builder.field("error", failureReason);  
            if (o == null || getClass() != o.getClass()) return false;
        @Override
package org.opensearch.action.admin.indices.tiering;
        builder.startArray("failed_indices");
            out.writeString(failureReason);
            failedIndex.toXContent(builder, params);
        super.addCustomFields(builder, params);  
        }  
 *
        @Override
import java.util.Objects;  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
public class HotToWarmTieringResponse extends AcknowledgedResponse {  
 *                "index": "index1",
 * by the backend service. The format of the response object will be as below:
    }
            return Objects.equals(index, that.index) && Objects.equals(failureReason, that.failureReason);  

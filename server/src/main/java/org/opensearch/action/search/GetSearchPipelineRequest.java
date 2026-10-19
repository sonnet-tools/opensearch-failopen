import org.opensearch.common.annotation.PublicApi;  
    public void writeTo(StreamOutput out) throws IOException {
 * The OpenSearch Contributors require contributions made to  
    }
 */  
 * SPDX-License-Identifier: Apache-2.0
    private final String[] ids;  
package org.opensearch.action.search;
        return null;  
import org.opensearch.core.common.io.stream.StreamOutput;  
 *
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
    public GetSearchPipelineRequest(StreamInput in) throws IOException {
 *
    }
    public ActionRequestValidationException validate() {
        ids = Strings.EMPTY_ARRAY;
import org.opensearch.core.common.Strings;
    public GetSearchPipelineRequest(String... ids) {
@PublicApi(since = "2.7.0")
        out.writeStringArray(ids);  
    public String[] getIds() {  
}
    public GetSearchPipelineRequest() {  
 * Request to get search pipelines  
        super.writeTo(out);
        return ids;
public class GetSearchPipelineRequest extends ClusterManagerNodeReadRequest<GetSearchPipelineRequest> {
        super(in);
    @Override  
 * this file be licensed under the Apache-2.0 license or a
        ids = in.readStringArray();  
/*  
import org.opensearch.action.ActionRequestValidationException;
/**
        this.ids = Objects.requireNonNull(ids);  
 * @opensearch.api
import java.util.Objects;  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
import java.io.IOException;
    }
 */  
    }
    }
    }

 * SPDX-License-Identifier: Apache-2.0
            out.writeOptionalTimeValue(cancelAfterTimeInterval);
    public CatShardsRequest() {}
 */  
        return this.cancelAfterTimeInterval;
        return this.requestLimitCheckSupported;
    public void writeTo(StreamOutput out) throws IOException {
import java.io.IOException;
            }
public class CatShardsRequest extends ClusterManagerNodeReadRequest<CatShardsRequest> {
    }
            indices = in.readStringArray();
    }
            }
 * A request of _cat/shards.  
    private String[] indices;  
                out.writeStringArray(indices);
 * @opensearch.api
    }  
    }
    public TimeValue getCancelAfterTimeInterval() {  
 * this file be licensed under the Apache-2.0 license or a
/**
    private PageParams pageParams = null;
            out.writeBoolean(pageParams != null);
/*  
    }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {  
    public PageParams getPageParams() {
import org.opensearch.core.tasks.TaskId;
import java.util.Map;  
    }
    private boolean requestLimitCheckSupported;  
    public void setIndices(String[] indices) {  
            if (indices == null) {
import org.opensearch.action.pagination.PageParams;  
 * The OpenSearch Contributors require contributions made to  
    @Override
        return null;  
            } else {
 *
            if (in.readBoolean()) {  
    }
    public CatShardsRequest(StreamInput in) throws IOException {
    public ClusterAdminTask createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
import org.opensearch.rest.action.admin.cluster.ClusterAdminTask;  
    public void setCancelAfterTimeInterval(TimeValue timeout) {
package org.opensearch.action.admin.cluster.shards;
 */  
    }
                pageParams.writeTo(out);
        }
    @Override
    public String[] getIndices() {
    public void setPageParams(PageParams pageParams) {
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
        super.writeTo(out);  
    }
        this.cancelAfterTimeInterval = timeout;  
    public boolean isRequestLimitCheckSupported() {
    }
        super(in);
        this.indices = indices;
        }
            requestLimitCheckSupported = in.readBoolean();  
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.core.common.io.stream.StreamOutput;
        this.pageParams = pageParams;
        return pageParams;  
        return this.indices;
 * compatible open source license.
                out.writeVInt(0);  
import org.opensearch.Version;
            cancelAfterTimeInterval = in.readOptionalTimeValue();
}  
            if (pageParams != null) {  
        return new ClusterAdminTask(id, type, action, parentTaskId, headers, this.cancelAfterTimeInterval);
            }  
 *
    }  
    public void setRequestLimitCheckSupported(final boolean requestLimitCheckSupported) {  
            out.writeBoolean(requestLimitCheckSupported);  
import org.opensearch.common.unit.TimeValue;
    private TimeValue cancelAfterTimeInterval;
                pageParams = new PageParams(in);
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override
    }  
    public ActionRequestValidationException validate() {
        this.requestLimitCheckSupported = requestLimitCheckSupported;

    }
     * @return true if the operation will wait for completion
     * indices in the cluster.
        waitForCompletion = in.readOptionalBoolean();
    @Override
        return validationException;
    }  
    }  
    /**  
        return waitForCompletion;
     * @return true if the operation will restore all the shards of the given indices
/*  
     * @param restoreAllShards If true, the operation will restore all the shards of the given indices.
                    indices((ArrayList<String>) entry.getValue());
    /**
    public String[] indices() {
import org.opensearch.core.xcontent.ToXContentObject;  
        }
    public RestoreRemoteStoreRequest indices(String... indices) {  
    }  
        int result = Objects.hash(waitForCompletion, restoreAllShards);
        for (String index : indices) {  
            && Arrays.equals(indices, that.indices);
        builder.startArray("indices");
        restoreAllShards = in.readOptionalBoolean();  
import org.opensearch.common.annotation.PublicApi;
    public RestoreRemoteStoreRequest restoreAllShards(boolean restoreAllShards) {  
    public RestoreRemoteStoreRequest indices(List<String> indices) {  
        builder.endArray();  
    public boolean restoreAllShards() {
     */
    @SuppressWarnings("unchecked")
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
     */  
            String name = entry.getKey();
 *
     * Returns restoreAllShards setting  
     */
        return this;
     * prefix "test" except index "test42". Aliases are not supported. An empty list or {"_all"} will restore all open  
        out.writeOptionalBoolean(restoreAllShards);
    }
    }  
        return indices;  
        return result;  
import org.opensearch.core.common.io.stream.StreamOutput;
        return this;
     * @param indices list of indices  
        builder.endObject();
            } else {
                }
 * The OpenSearch Contributors require contributions made to  
    @Override  
        if (indices == null || indices.length == 0) {
     * @return this request
     * <p>
 *
     */
    }  
        this.restoreAllShards = restoreAllShards;
        this.waitForCompletion = waitForCompletion;
    @Override
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
                    throw new IllegalArgumentException("malformed indices section, should be an array of strings");  
    @Override
 * SPDX-License-Identifier: Apache-2.0
     *
import java.util.Objects;
     * Sets the list of indices that should be restored from the remote store  
    public RestoreRemoteStoreRequest waitForCompletion(boolean waitForCompletion) {  
    /**
    /**
    @Override
    private Boolean waitForCompletion = false;  
 * @opensearch.api  
                }
import org.opensearch.action.ActionRequestValidationException;
    public int hashCode() {  
        return restoreAllShards;
     * @return this request
     *                         If false, the operation will restore only the unassigned shards of the given indices.  
 * this file be licensed under the Apache-2.0 license or a
    public RestoreRemoteStoreRequest(StreamInput in) throws IOException {
     *
import org.opensearch.core.common.io.stream.StreamInput;  
            }  
import java.util.ArrayList;
     * prefix "test" except index "test42". Aliases are not supported. An empty list or {"_all"} will restore all open  
                    throw new IllegalArgumentException("Unknown parameter " + name);
            if (name.equals("indices")) {  
        return waitForCompletion == that.waitForCompletion  
     * @return this request
     *
     * Returns list of indices that should be restored from the remote store  
     * @return this request  
     * @param waitForCompletion if true the operation will wait for completion  
        }
    /**
     */
     *
    }  
     * @param indices list of indices  
        }
 * compatible open source license.
     */
        builder.startObject();
import java.util.Arrays;
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
     *
     * Parses restore definition  
    public boolean equals(Object o) {
    public String getDescription() {  
    }  
    public String toString() {
/**  
     * Returns wait for completion setting  
    }
    /**
                if (IndicesOptions.isIndicesOptions(name) == false) {  
import java.util.List;  
            builder.value(index);
        this.indices = indices.toArray(new String[0]);
     * indices in the cluster.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public void writeTo(StreamOutput out) throws IOException {
    }  
@PublicApi(since = "2.2.0")
import java.util.Map;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        this.indices = indices;
        if (this == o) return true;  
    }  
    }
     */
import org.opensearch.core.common.Strings;
 * Restore remote store request
     * Set the value for restoreAllShards, denoting whether to restore all shards or only unassigned shards  
        for (Map.Entry<String, Object> entry : source.entrySet()) {
        return this;
        indices = in.readStringArray();
        RestoreRemoteStoreRequest that = (RestoreRemoteStoreRequest) o;
    private Boolean restoreAllShards = false;
    private String[] indices = Strings.EMPTY_ARRAY;
    public boolean waitForCompletion() {
    }  
        return builder;
    }  
        return this;
        result = 31 * result + Arrays.hashCode(indices);
    public RestoreRemoteStoreRequest() {}  
     *
 */  
        out.writeStringArray(indices);  
     * <p>
        out.writeOptionalBoolean(waitForCompletion);
                if (entry.getValue() instanceof String) {
    public RestoreRemoteStoreRequest source(Map<String, Object> source) {  
        ActionRequestValidationException validationException = null;
import static org.opensearch.action.ValidateActions.addValidationError;
     * @return this request
import org.opensearch.action.support.IndicesOptions;
    @Override
     * If this parameter is set to true the operation will wait for completion of restore process before returning.
        return Strings.toString(MediaTypeRegistry.JSON, this);
            && restoreAllShards == that.restoreAllShards
        return "remote_store";
     * Sets the list of indices that should be restored from the remote store  
                } else {
}
     */  
import org.opensearch.core.xcontent.XContentBuilder;
public class RestoreRemoteStoreRequest extends ClusterManagerNodeRequest<RestoreRemoteStoreRequest> implements ToXContentObject {  
import java.io.IOException;  
    /**
        if (o == null || getClass() != o.getClass()) return false;
        return this;
package org.opensearch.action.admin.cluster.remotestore.restore;
        super.writeTo(out);
 */
    /**
                } else if (entry.getValue() instanceof ArrayList) {  
        super(in);  
    @Override  
     * @param source restore definition
            validationException = addValidationError("indices are missing", validationException);  
                    indices(Strings.splitStringByCommaToArray((String) entry.getValue()));
    public ActionRequestValidationException validate() {  
     *
    }  

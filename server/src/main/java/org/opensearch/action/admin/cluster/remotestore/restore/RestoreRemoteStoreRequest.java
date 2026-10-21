        return waitForCompletion;
 *
     * If this parameter is set to true the operation will wait for completion of restore process before returning.
     * Sets the list of indices that should be restored from the remote store
            && Arrays.equals(indices, that.indices);
    public String[] indices() {
     * indices in the cluster.
    }
    private Boolean waitForCompletion = false;
        out.writeOptionalBoolean(restoreAllShards);
     * prefix "test" except index "test42". Aliases are not supported. An empty list or {"_all"} will restore all open
        }
 * SPDX-License-Identifier: Apache-2.0
        RestoreRemoteStoreRequest that = (RestoreRemoteStoreRequest) o;
        return this;
    /**
    public int hashCode() {
package org.opensearch.action.admin.cluster.remotestore.restore;
import org.opensearch.core.common.io.stream.StreamInput;
                }
     *
    @Override
     * Returns wait for completion setting
import org.opensearch.action.support.IndicesOptions;
    public RestoreRemoteStoreRequest waitForCompletion(boolean waitForCompletion) {
     * Sets the list of indices that should be restored from the remote store
     * @param source restore definition
import org.opensearch.core.xcontent.ToXContentObject;
                    throw new IllegalArgumentException("Unknown parameter " + name);
     * Returns restoreAllShards setting
import org.opensearch.core.common.Strings;
     * @param indices list of indices
     *
    /**
     * @return this request
        builder.endArray();
     *
            } else {
    }
        for (Map.Entry<String, Object> entry : source.entrySet()) {
                } else {
    }
    @Override
    }
        if (this == o) return true;
        return validationException;
import java.io.IOException;
    /**
     * @return this request
            validationException = addValidationError("indices are missing", validationException);
        indices = in.readStringArray();
import org.opensearch.action.ActionRequestValidationException;
    private Boolean restoreAllShards = false;
            }
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
                if (IndicesOptions.isIndicesOptions(name) == false) {
    public boolean equals(Object o) {
        if (indices == null || indices.length == 0) {
     */
        result = 31 * result + Arrays.hashCode(indices);
    @Override
     */
/**
        return this;
 */
     *
import org.opensearch.common.annotation.PublicApi;
            if (name.equals("indices")) {
    public RestoreRemoteStoreRequest(StreamInput in) throws IOException {
    }
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.Arrays;
    public RestoreRemoteStoreRequest() {}
import java.util.Objects;
        this.indices = indices.toArray(new String[0]);
    }
    public ActionRequestValidationException validate() {
     */
     * @return true if the operation will restore all the shards of the given indices
     * prefix "test" except index "test42". Aliases are not supported. An empty list or {"_all"} will restore all open
    @SuppressWarnings("unchecked")
    public String getDescription() {
        builder.endObject();
 * @opensearch.api
        this.waitForCompletion = waitForCompletion;
    public RestoreRemoteStoreRequest source(Map<String, Object> source) {
    /**
import org.opensearch.core.xcontent.MediaTypeRegistry;
        if (o == null || getClass() != o.getClass()) return false;
        return waitForCompletion == that.waitForCompletion
        this.restoreAllShards = restoreAllShards;
     */
    private String[] indices = Strings.EMPTY_ARRAY;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        return this;
     * <p>
        out.writeStringArray(indices);
    /**
import org.opensearch.core.xcontent.XContentBuilder;
        ActionRequestValidationException validationException = null;
import java.util.List;
        super(in);
     * Set the value for restoreAllShards, denoting whether to restore all shards or only unassigned shards
     * The list of indices supports multi-index syntax. For example: "+test*" ,"-test42" will index all indices with
     * Returns list of indices that should be restored from the remote store
    @Override
    }
    /**
    public void writeTo(StreamOutput out) throws IOException {
    }
 * Restore remote store request
        }
import static org.opensearch.action.ValidateActions.addValidationError;
        waitForCompletion = in.readOptionalBoolean();
 *
 * compatible open source license.
        super.writeTo(out);
     */
/*
     */
    public RestoreRemoteStoreRequest indices(List<String> indices) {
        return builder;
    }
     *
                    indices((ArrayList<String>) entry.getValue());
    }
    }
        int result = Objects.hash(waitForCompletion, restoreAllShards);
     *
        return indices;
    }
    }
     * <p>
        return Strings.toString(MediaTypeRegistry.JSON, this);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public RestoreRemoteStoreRequest restoreAllShards(boolean restoreAllShards) {
    public String toString() {
     * indices in the cluster.
     * @return true if the operation will wait for completion
        return "remote_store";
 */
    public boolean restoreAllShards() {
                if (entry.getValue() instanceof String) {
import java.util.ArrayList;
 * this file be licensed under the Apache-2.0 license or a
        return result;
     * @param restoreAllShards If true, the operation will restore all the shards of the given indices.
     *                         If false, the operation will restore only the unassigned shards of the given indices.
        return this;
public class RestoreRemoteStoreRequest extends ClusterManagerNodeRequest<RestoreRemoteStoreRequest> implements ToXContentObject {
 * The OpenSearch Contributors require contributions made to
    }
     */
    @Override
     * @param waitForCompletion if true the operation will wait for completion
        for (String index : indices) {
}
        }
    }
    public boolean waitForCompletion() {
                } else if (entry.getValue() instanceof ArrayList) {
import java.util.Map;
     * @return this request
        this.indices = indices;
     * Parses restore definition
        builder.startArray("indices");
     */
        out.writeOptionalBoolean(waitForCompletion);
    @Override
        restoreAllShards = in.readOptionalBoolean();
    public RestoreRemoteStoreRequest indices(String... indices) {
        return this;
    /**
        builder.startObject();
    @Override
            String name = entry.getKey();
     * @param indices list of indices
            builder.value(index);
        return restoreAllShards;
                    indices(Strings.splitStringByCommaToArray((String) entry.getValue()));
            && restoreAllShards == that.restoreAllShards
     * @return this request
                }
    }
    /**
     * @return this request
@PublicApi(since = "2.2.0")
                    throw new IllegalArgumentException("malformed indices section, should be an array of strings");
     *

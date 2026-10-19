 * compatible open source license.
    public TimeValue getKeepAlive() {
    private TimeValue keepAlive;
        }  
        Objects.requireNonNull(indices, "indices must not be null");
    @Override
        keepAlive = in.readTimeValue();  
import java.util.Objects;  
        sb.append("], ");
    }
        }  
        return new Task(id, type, action, this.buildDescription(), parentTaskId, headers);  
        if (indices != null) {  
    public String getRouting() {  
import static org.opensearch.action.ValidateActions.addValidationError;
        this.indices = indices;
    }
        return indicesOptions;  
 * @opensearch.api
    public void setKeepAlive(TimeValue keepAlive) {
        for (String index : indices) {
    public String[] getIndices() {
        return searchRequest;
        return routing;
    }
        allowPartialPitCreation = in.readOptionalBoolean();
import org.opensearch.core.common.io.stream.StreamInput;  
        out.writeOptionalString(preference);
        searchRequest.indicesOptions(this.getIndicesOptions());
import org.opensearch.action.ActionRequest;
    }
    private String preference = null;
    }  
    // keep alive for pit reader context  
    public CreatePitRequest indicesOptions(IndicesOptions indicesOptions) {  
        return allowPartialPitCreation;
        return keepAlive;
        SearchRequest searchRequest = new SearchRequest(this.getIndices());
            builder.endArray();
    public String[] indices() {  
    }  
    }  
import org.opensearch.action.IndicesRequest;  
    private void validateIndices(String... indices) {  
    /**
 * SPDX-License-Identifier: Apache-2.0
        return indices;  
import org.opensearch.core.xcontent.ToXContent;  
    }
    }
    @Nullable
        sb.append("pointintime[").append(keepAlive).append("], ");
    public String getPreference() {
@PublicApi(since = "2.3.0")  
public class CreatePitRequest extends ActionRequest implements IndicesRequest.Replaceable, ToXContent {
    }
        this.indices = indices;  
        builder.field("keep_alive", keepAlive);
    }
import org.opensearch.tasks.Task;
        validateIndices(indices);  
    public void setRouting(String routing) {
     * Sets if this request should allow partial results.  
        sb.append("allowPartialPitCreation[").append(allowPartialPitCreation).append("], ");  
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.action.search;
                builder.value(index);  
 * A request to make create point in time against one or more indices.
        this.keepAlive = keepAlive;  
        this.routing = routing;
    }  
    @Override
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
import java.util.Map;
        super(in);
/*  
    public boolean shouldAllowPartialPitCreation() {  
    public CreatePitRequest(TimeValue keepAlive, Boolean allowPartialPitCreation, String... indices) {  
    public IndicesOptions getIndicesOptions() {  
        routing = in.readOptionalString();
        super.writeTo(out);  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.tasks.TaskId;
    }
        out.writeTimeValue(keepAlive);
    private String routing = null;  
import org.opensearch.action.ActionRequestValidationException;
        indices = in.readStringArray();
            }
        this.indicesOptions = Objects.requireNonNull(indicesOptions, "indicesOptions must not be null");
        this.allowPartialPitCreation = allowPartialPitCreation;  
 *  
        Strings.arrayToDelimitedString(indices, ",", sb);  
/**
 */
        return validationException;
 */  
        out.writeStringArray(indices);
    private String[] indices = Strings.EMPTY_ARRAY;  
    public ActionRequestValidationException validate() {  
    }
        return indicesOptions;
        builder.field("allow_partial_pit_creation", allowPartialPitCreation);
    }
            Objects.requireNonNull(index, "index must not be null");  
        return this;
        this.allowPartialPitCreation = allowPartialPitCreation;
    public void setIndicesOptions(IndicesOptions indicesOptions) {
    @Nullable
    public void setPreference(String preference) {
    }
        out.writeOptionalBoolean(allowPartialPitCreation);  
    public void allowPartialPitCreation(Boolean allowPartialPitCreation) {
    @Override
        return preference;
        StringBuilder sb = new StringBuilder();
        out.writeOptionalString(routing);  
     */
        if (keepAlive == null) {
    @Override
    }
    public void writeTo(StreamOutput out) throws IOException {
    public CreatePitRequest indices(String... indices) {
        searchRequest.routing(this.getRouting());
        this.indicesOptions = Objects.requireNonNull(indicesOptions, "indicesOptions must not be null");
    SearchRequest toSearchRequest() {
    public final String buildDescription() {  
        return this;
            for (String index : indices) {
    }
        this.indices = indices;
    }  
 * The OpenSearch Contributors require contributions made to  
        }
    @Override
        indicesOptions = IndicesOptions.readIndicesOptions(in);  
import org.opensearch.action.support.IndicesOptions;
        searchRequest.preference(this.getPreference());  
    }
    @Override
        ActionRequestValidationException validationException = null;
import org.opensearch.core.common.Strings;
import org.opensearch.common.annotation.PublicApi;  
    private IndicesOptions indicesOptions = SearchRequest.DEFAULT_INDICES_OPTIONS;
 *
    // this describes whether PIT can be created with partial failures  
import org.opensearch.common.unit.TimeValue;
    public void setIndices(String[] indices) {  
        indicesOptions.writeIndicesOptions(out);
    }
    @Override
            indicesOptions.toXContent(builder, params);
            builder.startArray("indices");
        return indices;
    private Boolean allowPartialPitCreation;
        searchRequest.allowPartialSearchResults(this.shouldAllowPartialPitCreation());  
        if (indicesOptions != null) {
            validationException = addValidationError("keep alive not specified", validationException);  
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        return sb.toString();
        preference = in.readOptionalString();
import java.io.IOException;
        return builder;
    }  
        this.keepAlive = keepAlive;
}  
        }
    }
 * this file be licensed under the Apache-2.0 license or a
    public CreatePitRequest(StreamInput in) throws IOException {  
        sb.append("indices[");
    }
        this.preference = preference;  
import org.opensearch.common.Nullable;
    public IndicesOptions indicesOptions() {

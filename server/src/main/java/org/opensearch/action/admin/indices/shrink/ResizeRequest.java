import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See  
import java.io.IOException;
        }
     * Returns the source index name  
    }
     * This parameter can be used to calculate the lowest factor of the source index's shards number  
                    alias.toXContent(builder, params);
        return targetIndexRequest;
            );
     * The type of the resize operation
    }
    }
        return shouldStoreResult;
    }  
        StringBuilder b = new StringBuilder();
    private boolean shouldStoreResult;
    public String toString() {  
                for (Alias alias : targetIndexRequest.aliases()) {  
            (parser, request, context) -> request.getTargetIndexRequest().aliases(parser.map()),  
import org.opensearch.core.xcontent.ToXContentObject;  
        b.append(" [").append(sourceIndex).append("]");  
 * KIND, either express or implied.  See the License for the
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
            builder.startObject(CreateIndexRequest.ALIASES.getPreferredName());
     *
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
import java.util.Objects;
        return type;
    @Override
            (p, c) -> ByteSizeValue.parseBytesSizeValue(p.text(), MAX_SHARD_SIZE.getPreferredName()),  
        targetIndexRequest = new CreateIndexRequest(in);  
 * license agreements. See the NOTICE file distributed with
            new ParseField("settings"),
        // Check target index's settings, if `index.blocks.read_only` is `true`, the target index's metadata writes will be disabled  
 *
import org.opensearch.core.common.io.stream.StreamOutput;  
    public void setShouldStoreResult(boolean shouldStoreResult) {
                "Cannot set max_shard_size and index.number_of_shards at the same time!",
            validationException = addValidationError("Unsupported parameter [max_shard_size]", validationException);
    public ResizeType getResizeType() {
    public void setSourceIndex(String index) {
public class ResizeRequest extends AcknowledgedRequest<ResizeRequest> implements IndicesRequest, ToXContentObject {  
        this.type = Objects.requireNonNull(type);
    @Override
        builder.startObject();  
 *
    }
        PARSER.declareField(
    }
     */  
     * Sets the maximum size of a primary shard in the new shrunken index.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
     */
        {
 * The OpenSearch Contributors require contributions made to  
                builder.field(MAX_SHARD_SIZE.getPreferredName(), maxShardSize);  
     * Returns the type of the resize operation
    /**
    /**  
            default:  
            builder.startObject(CreateIndexRequest.SETTINGS.getPreferredName());
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
    }  
     * to get the ActiveShardCount.  
            {  
            ResizeRequest::setMaxShardSize,
                    + "] will be blocked by [index.blocks.metadata=true], this will disable metadata writes and cause the shards to be unassigned",
     * Returns the maximum size of a primary shard in the new shrunken index.
    public String[] indices() {  
 */  
    }
    public static final ObjectParser<ResizeRequest, Void> PARSER = new ObjectParser<>("resize_request");
            && IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(targetIndexRequest.settings())
        }
                targetIndexRequest.settings().toXContent(builder, params);
    public ByteSizeValue getMaxShardSize() {  
package org.opensearch.action.admin.indices.shrink;
    /**  
    }  
        sourceIndex = in.readString();
    public String getDescription() {  
        copySettings = in.readOptionalBoolean();  
                    + "] will be blocked by [index.blocks.read_only=true], this will disable metadata writes and cause the shards to be unassigned",  
        // max_shard_size conflicts with the index.number_of_shards setting  
     * wait for one shard copy (the primary) to become active. Set this value to  
     * @param maxShardSize the maximum size of a primary shard in the new shrunken index  
            validationException = addValidationError(
 * @opensearch.api  
    }
    }
    }
        targetIndexRequest.writeTo(out);
        return this.toString();
    @Override
    }
            ObjectParser.ValueType.OBJECT  
    public CreateIndexRequest getTargetIndexRequest() {
        return builder;
 * software distributed under the License is distributed on an
                    + targetIndexRequest.index()
            validationException = addValidationError("can't override index sort when resizing an index", validationException);
        // Check target index's settings, if `index.blocks.metadata` is `true`, the target index's metadata writes will be disabled
        out.writeEnum(type);
            validationException = addValidationError("target index request is missing", validationException);
        // and then cause the new shards to be unassigned.
 * GitHub history for details.
            maxShardSize = in.readOptionalWriteable(ByteSizeValue::new);
     * Sets the number of shard copies that should be active for creation of the
        }  
import org.opensearch.core.xcontent.XContentBuilder;
     * which satisfies the maximum shard size requirement.
        this.sourceIndex = sourceIndex;
    public ActionRequestValidationException validate() {
        return copySettings;
    }  
    private ByteSizeValue maxShardSize;
import org.opensearch.common.annotation.PublicApi;  
    }
        );
            validationException = addValidationError(
    public void setWaitForActiveShards(final int waitForActiveShards) {
    /**
                validationException  
                b.append("split from");
    @Override
        this.copySettings = copySettings;  
                break;
        );  
        this.getTargetIndexRequest().waitForActiveShards(waitForActiveShards);  
        );  
        return IndicesOptions.lenientExpandOpen();  
                validationException
    public void setMaxShardSize(ByteSizeValue maxShardSize) {
        }
import org.opensearch.action.support.ActiveShardCount;
import org.opensearch.core.ParseField;
        if (IndexMetadata.INDEX_ROUTING_PARTITION_SIZE_SETTING.exists(targetIndexRequest.settings())) {
            MAX_SHARD_SIZE,
            ObjectParser.ValueType.STRING
    }  
     * to wait for the desired amount of shard copies to become active before returning.
     * to be active before returning.  Check {@link ResizeResponse#isShardsAcknowledged()} to  
                    + targetIndexRequest.index()
        if (IndexMetadata.INDEX_READ_ONLY_SETTING.get(targetIndexRequest.settings()) == true) {
    public boolean getShouldStoreResult() {  
        PARSER.parse(parser, this, null);
 * compatible open source license.
            ObjectParser.ValueType.OBJECT
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        return maxShardSize;
     */
     * {@link ActiveShardCount#ALL} to wait for all shards (primary and all replicas) to be active
        super.writeTo(out);
    public void setWaitForActiveShards(ActiveShardCount waitForActiveShards) {
        return b.toString();
        }
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    /**
            throw new IllegalArgumentException("[copySettings] can not be explicitly set to [false]");
            );
     */
                "target index ["  
    static {
        }
 *  
/*
    }
 * ownership. Elasticsearch licenses this file to you under  
    public IndicesOptions indicesOptions() {
    private ResizeType type = ResizeType.SHRINK;
import org.opensearch.action.support.IndicesOptions;  
}  
            new ParseField("aliases"),
 * not use this file except in compliance with the License.
        this.shouldStoreResult = shouldStoreResult;
        this.maxShardSize = maxShardSize;  
import org.opensearch.action.ActionRequestValidationException;
    /**  
        out.writeOptionalBoolean(copySettings);
        if (IndexMetadata.INDEX_BLOCKS_METADATA_SETTING.get(targetIndexRequest.settings()) == true) {
/*
    private static final ParseField MAX_SHARD_SIZE = new ParseField("max_shard_size");  
    public ResizeRequest(StreamInput in) throws IOException {
        ActionRequestValidationException validationException = targetIndexRequest == null ? null : targetIndexRequest.validate();  
 * SPDX-License-Identifier: Apache-2.0
        // and then cause the new shards to be unassigned.  
        type = in.readEnum(ResizeType.class);
            validationException = addValidationError("index.number_of_shards is required for split operations", validationException);
 * the Apache License, Version 2.0 (the "License"); you may
    public void setCopySettings(final Boolean copySettings) {
        if (type == ResizeType.SPLIT && IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(targetIndexRequest.settings()) == false) {
        }  
        switch (getResizeType()) {
            case CLONE:  
import org.opensearch.cluster.metadata.IndexMetadata;
     * Returns the {@link CreateIndexRequest} for the shrink index
                validationException  
    }
            case SPLIT:  
            if (maxShardSize != null) {
 */
                }
    public void fromXContent(XContentParser parser) throws IOException {
     * before returning. Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any
    public String getSourceIndex() {
/**  
        if (type != ResizeType.SHRINK && maxShardSize != null) {  
        if (copySettings != null && copySettings == false) {  
    public Boolean getCopySettings() {  
        }  
        if (in.getVersion().onOrAfter(Version.V_2_5_0)) {
 */
    }
        PARSER.declareField(  
        if (maxShardSize != null && maxShardSize.getBytes() <= 0) {  
@PublicApi(since = "1.0.0")
 * Unless required by applicable law or agreed to in writing,
    @Override
import org.opensearch.core.common.unit.ByteSizeValue;
        }
        this.targetIndexRequest = Objects.requireNonNull(targetIndexRequest, "target index request must not be null");
        if (targetIndexRequest.settings().getByPrefix("index.sort.").isEmpty() == false) {
 */
    }  
    public void setTargetIndex(CreateIndexRequest targetIndexRequest) {  
    public ResizeRequest(String targetIndex, String sourceIndex) {
            }  
import static org.opensearch.action.ValidateActions.addValidationError;
     */
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
                validationException
        if (type == ResizeType.SHRINK
 * You may obtain a copy of the License at  
    /**
            builder.endObject();  
            validationException = addValidationError("max_shard_size must be greater than 0", validationException);
    }
            builder.endObject();
        return validationException;
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),  
     * determine if the requisite shard copies were all started before returning or timing out.
     * Index creation will only wait up until the timeout value for the number of shard copies
                break;
    private String sourceIndex;
     * @param waitForActiveShards number of active shard copies to wait on  
 *
 * under the License.  
        this.targetIndexRequest = new CreateIndexRequest(targetIndex);  
        this.sourceIndex = index;
     */
/*  
            validationException = addValidationError(
        }  
    public void writeTo(StreamOutput out) throws IOException {  
     */
        }
        out.writeString(sourceIndex);  
    public void setResizeType(ResizeType type) {  
    }
                b.append("clone from");
     */  
            {
        setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));  
     * Should this task store its result after it has finished?
    @Override
        if (sourceIndex == null) {
                "cannot provide a routing partition size value when resizing an index",  
import org.opensearch.core.xcontent.XContentParser;
        if (out.getVersion().onOrAfter(Version.V_2_5_0)) {  
import org.opensearch.core.xcontent.ObjectParser;
    }
        // max_shard_size is only supported for shrink
                b.append("shrink from");
            && maxShardSize != null) {  
    }
     */  
 *     http://www.apache.org/licenses/LICENSE-2.0
            validationException = addValidationError("source index is missing", validationException);
            validationException = addValidationError(  
        return sourceIndex;  
            out.writeOptionalWriteable(maxShardSize);
            }
            (parser, request, context) -> request.getTargetIndexRequest().settings(parser.map()),
        super(in);
 * this work for additional information regarding copyright
     *
                "target index ["
        PARSER.declareField(
import org.opensearch.action.admin.indices.alias.Alias;  
 * Request class to shrink an index into a single shard
    private CreateIndexRequest targetIndexRequest;  
            }
        b.append(" to [").append(getTargetIndexRequest().index()).append(']');
            );
        return new String[] { sourceIndex };
        }
     * new shrunken index to return. Defaults to {@link ActiveShardCount#DEFAULT}, which will
        builder.endObject();  
import org.opensearch.action.IndicesRequest;
    ResizeRequest() {}  
    }  
import org.opensearch.Version;  
        }  
        assert copySettings == null || copySettings;  
            );
 * this file be licensed under the Apache-2.0 license or a
        }  
        }  
        if (targetIndexRequest == null) {
    private Boolean copySettings = true;  
    /**  
    /**

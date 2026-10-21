     */
        );
 *
        }
public class ResizeRequest extends AcknowledgedRequest<ResizeRequest> implements IndicesRequest, ToXContentObject {
            && maxShardSize != null) {
 * under the License.
        );
        out.writeOptionalBoolean(copySettings);
 * this file be licensed under the Apache-2.0 license or a
 *
        return maxShardSize;
    private Boolean copySettings = true;
     * Returns the {@link CreateIndexRequest} for the shrink index
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
     * Returns the maximum size of a primary shard in the new shrunken index.
            validationException = addValidationError("can't override index sort when resizing an index", validationException);
import org.opensearch.action.ActionRequestValidationException;
                validationException
    private CreateIndexRequest targetIndexRequest;
                "cannot provide a routing partition size value when resizing an index",
    public void setSourceIndex(String index) {
     * Should this task store its result after it has finished?
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    }
        this.sourceIndex = sourceIndex;
        PARSER.declareField(
            );
        return targetIndexRequest;
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                    + targetIndexRequest.index()
            throw new IllegalArgumentException("[copySettings] can not be explicitly set to [false]");
        return sourceIndex;
                "target index ["
            {
     * wait for one shard copy (the primary) to become active. Set this value to
    public void setWaitForActiveShards(final int waitForActiveShards) {
    @Override
            validationException = addValidationError("target index request is missing", validationException);
 * not use this file except in compliance with the License.
        type = in.readEnum(ResizeType.class);
 * license agreements. See the NOTICE file distributed with
            builder.startObject(CreateIndexRequest.ALIASES.getPreferredName());
    }
            validationException = addValidationError("source index is missing", validationException);
        if (out.getVersion().onOrAfter(Version.V_2_5_0)) {
    }
        );
        // max_shard_size conflicts with the index.number_of_shards setting
        return b.toString();
                b.append("split from");
    }
import static org.opensearch.action.ValidateActions.addValidationError;
        }
 * SPDX-License-Identifier: Apache-2.0
            ObjectParser.ValueType.OBJECT
    public IndicesOptions indicesOptions() {
    private static final ParseField MAX_SHARD_SIZE = new ParseField("max_shard_size");
        if (IndexMetadata.INDEX_BLOCKS_METADATA_SETTING.get(targetIndexRequest.settings()) == true) {
     * to get the ActiveShardCount.
        }
            validationException = addValidationError("max_shard_size must be greater than 0", validationException);
        ActionRequestValidationException validationException = targetIndexRequest == null ? null : targetIndexRequest.validate();
            );
    static {
    }
     * to wait for the desired amount of shard copies to become active before returning.
 * the Apache License, Version 2.0 (the "License"); you may
        assert copySettings == null || copySettings;
     * @param maxShardSize the maximum size of a primary shard in the new shrunken index
        return shouldStoreResult;
/*
    public ResizeType getResizeType() {
        PARSER.parse(parser, this, null);
                targetIndexRequest.settings().toXContent(builder, params);
     */
        return this.toString();
                    alias.toXContent(builder, params);
        this.targetIndexRequest = Objects.requireNonNull(targetIndexRequest, "target index request must not be null");
import org.opensearch.action.support.IndicesOptions;
     */
     * Returns the source index name
        if (in.getVersion().onOrAfter(Version.V_2_5_0)) {
import org.opensearch.Version;
     * This parameter can be used to calculate the lowest factor of the source index's shards number
        super.writeTo(out);
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.action.admin.indices.alias.Alias;
        b.append(" [").append(sourceIndex).append("]");
    public void setShouldStoreResult(boolean shouldStoreResult) {
     */
    @Override
        if (targetIndexRequest.settings().getByPrefix("index.sort.").isEmpty() == false) {
        targetIndexRequest = new CreateIndexRequest(in);
                "Cannot set max_shard_size and index.number_of_shards at the same time!",
     * The type of the resize operation
    public void fromXContent(XContentParser parser) throws IOException {
            }
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        return type;
 */
        builder.endObject();
import org.opensearch.cluster.metadata.IndexMetadata;
            ObjectParser.ValueType.OBJECT
        }
    /**
            (parser, request, context) -> request.getTargetIndexRequest().settings(parser.map()),
package org.opensearch.action.admin.indices.shrink;
     */
                validationException
    public Boolean getCopySettings() {
        b.append(" to [").append(getTargetIndexRequest().index()).append(']');
    public CreateIndexRequest getTargetIndexRequest() {
     * Sets the number of shard copies that should be active for creation of the
    public void setTargetIndex(CreateIndexRequest targetIndexRequest) {
                    + "] will be blocked by [index.blocks.metadata=true], this will disable metadata writes and cause the shards to be unassigned",
     */
            validationException = addValidationError("Unsupported parameter [max_shard_size]", validationException);
        return IndicesOptions.lenientExpandOpen();
        this.copySettings = copySettings;
    }
            builder.startObject(CreateIndexRequest.SETTINGS.getPreferredName());
                break;
     * Index creation will only wait up until the timeout value for the number of shard copies
                b.append("shrink from");
import org.opensearch.action.IndicesRequest;
        targetIndexRequest.writeTo(out);
    }
                for (Alias alias : targetIndexRequest.aliases()) {
        // and then cause the new shards to be unassigned.
 * @opensearch.api
                validationException
        return validationException;
            builder.endObject();
import java.io.IOException;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    public String getDescription() {
 * GitHub history for details.
        if (copySettings != null && copySettings == false) {
            validationException = addValidationError("index.number_of_shards is required for split operations", validationException);
        StringBuilder b = new StringBuilder();
        // Check target index's settings, if `index.blocks.read_only` is `true`, the target index's metadata writes will be disabled
        if (targetIndexRequest == null) {
                    + "] will be blocked by [index.blocks.read_only=true], this will disable metadata writes and cause the shards to be unassigned",
        }
/**
    }
     * new shrunken index to return. Defaults to {@link ActiveShardCount#DEFAULT}, which will
            if (maxShardSize != null) {
    /**
        }
 * compatible open source license.
import org.opensearch.core.xcontent.ToXContentObject;
    /**
            out.writeOptionalWriteable(maxShardSize);
        return copySettings;
    }
    }
import org.opensearch.action.support.ActiveShardCount;
import org.opensearch.core.common.io.stream.StreamInput;
        this.targetIndexRequest = new CreateIndexRequest(targetIndex);
            case CLONE:
                builder.field(MAX_SHARD_SIZE.getPreferredName(), maxShardSize);
        if (IndexMetadata.INDEX_READ_ONLY_SETTING.get(targetIndexRequest.settings()) == true) {
        this.sourceIndex = index;
        setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));
    @Override
    /**
    public ActionRequestValidationException validate() {
        return builder;
        if (maxShardSize != null && maxShardSize.getBytes() <= 0) {
     */
        }
 */
        // and then cause the new shards to be unassigned.
    }
    }
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
    public String[] indices() {
    public void setResizeType(ResizeType type) {
 *
        {
        switch (getResizeType()) {
            default:
    private String sourceIndex;
        // max_shard_size is only supported for shrink
            MAX_SHARD_SIZE,
            case SPLIT:
    public boolean getShouldStoreResult() {
    public void writeTo(StreamOutput out) throws IOException {
    public static final ObjectParser<ResizeRequest, Void> PARSER = new ObjectParser<>("resize_request");
     * determine if the requisite shard copies were all started before returning or timing out.
    ResizeRequest() {}
     * before returning. Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any
    public ResizeRequest(String targetIndex, String sourceIndex) {
    }
            validationException = addValidationError(
    public void setCopySettings(final Boolean copySettings) {
 *
     * @param waitForActiveShards number of active shard copies to wait on
    }
        out.writeEnum(type);
    /**
        }
     * Returns the type of the resize operation
            ObjectParser.ValueType.STRING
            ResizeRequest::setMaxShardSize,
        if (sourceIndex == null) {
            }
     * to be active before returning.  Check {@link ResizeResponse#isShardsAcknowledged()} to
                "target index ["
        }
 * The OpenSearch Contributors require contributions made to
        }
    }
    }
import org.opensearch.core.common.unit.ByteSizeValue;
            {
     */
            );
/*
    }
    @Override
            && IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(targetIndexRequest.settings())
            validationException = addValidationError(
import org.opensearch.core.xcontent.XContentBuilder;
    /**
 * this work for additional information regarding copyright
    }
     *
            new ParseField("aliases"),
        this.shouldStoreResult = shouldStoreResult;
        if (type == ResizeType.SHRINK
            maxShardSize = in.readOptionalWriteable(ByteSizeValue::new);
     * Sets the maximum size of a primary shard in the new shrunken index.
 * Licensed to Elasticsearch under one or more contributor
    }
        out.writeString(sourceIndex);
    /**
    @Override
 * software distributed under the License is distributed on an
    }
 * Unless required by applicable law or agreed to in writing,
     */
 * Modifications Copyright OpenSearch Contributors. See
    private ResizeType type = ResizeType.SHRINK;
    public void setWaitForActiveShards(ActiveShardCount waitForActiveShards) {
        }
import java.util.Objects;
            new ParseField("settings"),
        copySettings = in.readOptionalBoolean();
    }
@PublicApi(since = "1.0.0")
                break;
            validationException = addValidationError(
 * You may obtain a copy of the License at
     * {@link ActiveShardCount#ALL} to wait for all shards (primary and all replicas) to be active
        }
    public ResizeRequest(StreamInput in) throws IOException {
        this.maxShardSize = maxShardSize;
                validationException
    }
    }
                }
import org.opensearch.core.ParseField;
     *
        // Check target index's settings, if `index.blocks.metadata` is `true`, the target index's metadata writes will be disabled
 */
        sourceIndex = in.readString();
 * Request class to shrink an index into a single shard
import org.opensearch.common.annotation.PublicApi;
    public void setMaxShardSize(ByteSizeValue maxShardSize) {
                b.append("clone from");
        }
        if (type == ResizeType.SPLIT && IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.exists(targetIndexRequest.settings()) == false) {
 * ownership. Elasticsearch licenses this file to you under
    public String toString() {
        super(in);
    @Override
    public String getSourceIndex() {
/*
                    + targetIndexRequest.index()
        builder.startObject();
        }
    private boolean shouldStoreResult;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public ByteSizeValue getMaxShardSize() {
 * KIND, either express or implied.  See the License for the
        this.type = Objects.requireNonNull(type);
 * specific language governing permissions and limitations
            );
        if (IndexMetadata.INDEX_ROUTING_PARTITION_SIZE_SETTING.exists(targetIndexRequest.settings())) {
import org.opensearch.core.xcontent.ObjectParser;
            (parser, request, context) -> request.getTargetIndexRequest().aliases(parser.map()),
            (p, c) -> ByteSizeValue.parseBytesSizeValue(p.text(), MAX_SHARD_SIZE.getPreferredName()),
        if (type != ResizeType.SHRINK && maxShardSize != null) {
    @Override
            builder.endObject();
    /**
        return new String[] { sourceIndex };
    private ByteSizeValue maxShardSize;
            validationException = addValidationError(
            }
        PARSER.declareField(
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
    /**
}
     * which satisfies the maximum shard size requirement.
        PARSER.declareField(
        this.getTargetIndexRequest().waitForActiveShards(waitForActiveShards);

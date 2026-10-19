    public void addMaxIndexSizeCondition(ByteSizeValue size) {
/*
        this.conditions.put(maxSizeCondition.name, maxSizeCondition);
/*
        out.writeString(rolloverTarget);
 *
     * Returns the inner {@link CreateIndexRequest}. Allows to configure mappings, settings and aliases for the new index.
    }
    }
        MaxSizeCondition maxSizeCondition = new MaxSizeCondition(size);
    }
     * Sets the rollover target to rollover to another index
package org.opensearch.action.admin.indices.rollover;
 * this file be licensed under the Apache-2.0 license or a
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Request class to swap index under an alias or increment data stream generation upon satisfying conditions
     */
    public String getNewIndexName() {
    public void dryRun(boolean dryRun) {
    public void setNewIndexName(String newIndexName) {
    /**
        int size = in.readVInt();
    private static final ParseField CONDITIONS = new ParseField("conditions");
import org.opensearch.action.support.ActiveShardCount;
        return IndicesOptions.strictSingleIndexNoExpandForbidClosed();
        return new String[] { rolloverTarget };
import org.opensearch.core.common.io.stream.StreamOutput;
import static org.opensearch.action.ValidateActions.addValidationError;
    public boolean includeDataStreams() {
     * Adds a size-based condition to check if the index size is at least <code>size</code>.
    }
    public void setWaitForActiveShards(ActiveShardCount waitForActiveShards) {
 *
        return conditions;
        this.conditions.put(maxDocsCondition.name, maxDocsCondition);
import org.opensearch.action.IndicesRequest;
 * license agreements. See the NOTICE file distributed with
        if (this.conditions.containsKey(maxAgeCondition.name)) {
    }
                MaxSizeCondition.NAME,
    }
            // a type is not included, add a dummy _doc type
        PARSER.declareField((parser, request, context) -> {
            validationException = addValidationError("rollover target is missing", validationException);
        PARSER.declareField(
        out.writeBoolean(dryRun);
    public void addMaxIndexDocsCondition(long numDocs) {
     * Adds condition to check if the index has at least <code>numDocs</code>
    public ActionRequestValidationException validate() {
    public CreateIndexRequest getCreateIndexRequest() {
            Map<String, Object> mappings = parser.map();
            (parser, request, context) -> request.createIndexRequest.settings(parser.map()),
 * Note: there is a new class with the same name for the Java HLRC that uses a typeless format.
 * ownership. Elasticsearch licenses this file to you under
            (parser, request, context) -> request.createIndexRequest.aliases(parser.map()),
        return validationException;
    public Map<String, Condition<?>> getConditions() {
        PARSER.declareField(
            (conditions, value) -> conditions.put(MaxDocsCondition.NAME, new MaxDocsCondition(value)),
    }
import org.opensearch.core.common.unit.ByteSizeValue;
     */
import java.util.Map;
            request.createIndexRequest.mapping(mappings);
import org.opensearch.core.xcontent.ObjectParser;
    public void writeTo(StreamOutput out) throws IOException {
    public void addMaxIndexAgeCondition(TimeValue age) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
        MaxDocsCondition maxDocsCondition = new MaxDocsCondition(numDocs);
            (conditions, s) -> conditions.put(
    public void setRolloverTarget(String rolloverTarget) {
     */
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.ParseField;
        if (this.conditions.containsKey(maxDocsCondition.name)) {
 * under the License.
            ),
import java.util.HashMap;
        for (Condition<?> condition : conditions.values()) {
            if (MapperService.isMappingSourceTyped(MapperService.SINGLE_MAPPING_NAME, mappings)) {
    }
    private final Map<String, Condition<?>> conditions = new HashMap<>(2);
    private static final ObjectParser<Map<String, Condition<?>>, Void> CONDITION_PARSER = new ObjectParser<>("conditions");
            ObjectParser.ValueType.OBJECT
     */
            throw new IllegalArgumentException(maxSizeCondition + " condition is already set");
 * GitHub history for details.
            throw new IllegalArgumentException(maxDocsCondition.name + " condition is already set");
        this.conditions.put(maxAgeCondition.name, maxAgeCondition);
    }
    private static final ParseField MAX_AGE_CONDITION = new ParseField(MaxAgeCondition.NAME);
    }
        return createIndexRequest;
        super.writeTo(out);
import org.opensearch.common.unit.TimeValue;
    }
/**
 * software distributed under the License is distributed on an
     */
            CreateIndexRequest.ALIASES,
 */
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    }
        );
     * Sets if the rollover should not be executed when conditions are met
     */
        }
                new MaxSizeCondition(ByteSizeValue.parseBytesSizeValue(s, MaxSizeCondition.NAME))
        );
 * Any changes done to this class should also go to that client class.
    }
import org.opensearch.core.xcontent.XContentParser;
            MAX_DOCS_CONDITION
        createIndexRequest.waitForActiveShards(waitForActiveShards);
    private boolean dryRun;
        );
 */
    }
    }
/*
    private String rolloverTarget;
     * Sets the alias to rollover to another index
    /**
    }
            ObjectParser.ValueType.OBJECT
            CreateIndexRequest.SETTINGS,
    public IndicesOptions indicesOptions() {
    public RolloverRequest(String rolloverTarget, String newIndexName) {
                throw new IllegalArgumentException("The mapping definition cannot be nested under a type");
        PARSER.parse(parser, this, null);
    /**
            this.conditions.put(condition.name, condition);
        return rolloverTarget;
        for (int i = 0; i < size; i++) {
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")
    static {
     */
    private static final ObjectParser<RolloverRequest, Void> PARSER = new ObjectParser<>("rollover");
    // param isTypeIncluded decides how mappings should be parsed from XContent
import org.opensearch.action.support.IndicesOptions;
        return true;
    /**
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        );
            (parser, request, context) -> CONDITION_PARSER.parse(parser, request.conditions, null),
 * Modifications Copyright OpenSearch Contributors. See
     */
        }, CreateIndexRequest.MAPPINGS, ObjectParser.ValueType.OBJECT);
 */
        out.writeOptionalString(newIndexName);
        if (this.conditions.containsKey(maxSizeCondition.name)) {
    }
        rolloverTarget = in.readString();
        PARSER.declareField(
    public boolean isDryRun() {
        this.dryRun = dryRun;
        );
            throw new IllegalArgumentException(maxAgeCondition.name + " condition is already set");
        }
        MaxAgeCondition maxAgeCondition = new MaxAgeCondition(age);
    @Override
    @Override
        }
import java.io.IOException;
 * compatible open source license.
    @Override
    public void fromXContent(XContentParser parser) throws IOException {
        return newIndexName;
     * Sets the wait for active shards configuration for the rolled index that gets created.
        createIndexRequest = new CreateIndexRequest(in);
        return dryRun;
    /**
    public RolloverRequest(StreamInput in) throws IOException {
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        this.newIndexName = newIndexName;
    private static final ParseField MAX_SIZE_CONDITION = new ParseField(MaxSizeCondition.NAME);
        }
import org.opensearch.action.ActionRequestValidationException;
            (conditions, s) -> conditions.put(MaxAgeCondition.NAME, new MaxAgeCondition(TimeValue.parseTimeValue(s, MaxAgeCondition.NAME))),
        CONDITION_PARSER.declareLong(
    public String getRolloverTarget() {
        this.rolloverTarget = rolloverTarget;
    public String[] indices() {
            ObjectParser.ValueType.OBJECT
        dryRun = in.readBoolean();
    // the index name "_na_" is never read back, what matters are settings, mappings and aliases
            CONDITIONS,
            MAX_AGE_CONDITION
        this.newIndexName = newIndexName;
        }
        ActionRequestValidationException validationException = createIndexRequest.validate();
        out.writeVInt(conditions.size());
            Condition<?> condition = in.readNamedWriteable(Condition.class);
        createIndexRequest.writeTo(out);
 *
        super(in);
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
                out.writeNamedWriteable(condition);
 * You may obtain a copy of the License at
 * <p>
    private CreateIndexRequest createIndexRequest = new CreateIndexRequest("_na_");
    private String newIndexName;
        newIndexName = in.readOptionalString();
 * Unless required by applicable law or agreed to in writing,
    /**
    }
    }
 * Licensed to Elasticsearch under one or more contributor
 *
        this.rolloverTarget = rolloverTarget;
    }
import org.opensearch.index.mapper.MapperService;
 * @opensearch.api
public class RolloverRequest extends AcknowledgedRequest<RolloverRequest> implements IndicesRequest {
 * specific language governing permissions and limitations
    }
 * not use this file except in compliance with the License.
    private static final ParseField MAX_DOCS_CONDITION = new ParseField(MaxDocsCondition.NAME);
 */
        if (rolloverTarget == null) {
    @Override
        CONDITION_PARSER.declareString(
    RolloverRequest() {}
 * The OpenSearch Contributors require contributions made to
            }
        }
 * KIND, either express or implied.  See the License for the
}
        );
            MAX_SIZE_CONDITION
            if (condition.includedInVersion(out.getVersion())) {
        CONDITION_PARSER.declareString(
     * Adds condition to check if the index is at least <code>age</code> old

import org.opensearch.common.annotation.PublicApi;  
        PARSER.declareField(  
    @Override  
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
 * SPDX-License-Identifier: Apache-2.0
            }  
    public String getNewIndexName() {  
 * software distributed under the License is distributed on an
    public RolloverRequest(StreamInput in) throws IOException {  
 *  
     */  
    public void addMaxIndexAgeCondition(TimeValue age) {  
package org.opensearch.action.admin.indices.rollover;
    RolloverRequest() {}
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeString(rolloverTarget);
    }
            throw new IllegalArgumentException(maxSizeCondition + " condition is already set");
    }
                new MaxSizeCondition(ByteSizeValue.parseBytesSizeValue(s, MaxSizeCondition.NAME))
    public RolloverRequest(String rolloverTarget, String newIndexName) {  
        MaxAgeCondition maxAgeCondition = new MaxAgeCondition(age);
     * Adds condition to check if the index has at least <code>numDocs</code>  
    }
        return IndicesOptions.strictSingleIndexNoExpandForbidClosed();  
/*
        MaxSizeCondition maxSizeCondition = new MaxSizeCondition(size);
                out.writeNamedWriteable(condition);
        this.dryRun = dryRun;
        PARSER.declareField(
            if (MapperService.isMappingSourceTyped(MapperService.SINGLE_MAPPING_NAME, mappings)) {
            request.createIndexRequest.mapping(mappings);
        createIndexRequest = new CreateIndexRequest(in);
     * Sets the rollover target to rollover to another index  
    /**
            ObjectParser.ValueType.OBJECT  
            (parser, request, context) -> request.createIndexRequest.aliases(parser.map()),
        }
            validationException = addValidationError("rollover target is missing", validationException);  
/**
        this.newIndexName = newIndexName;
        if (this.conditions.containsKey(maxDocsCondition.name)) {
    public Map<String, Condition<?>> getConditions() {
 * Any changes done to this class should also go to that client class.
 * Licensed to Elasticsearch under one or more contributor  
        );  
            MAX_SIZE_CONDITION
        }
        if (this.conditions.containsKey(maxSizeCondition.name)) {  
import org.opensearch.index.mapper.MapperService;
    public void setWaitForActiveShards(ActiveShardCount waitForActiveShards) {
public class RolloverRequest extends AcknowledgedRequest<RolloverRequest> implements IndicesRequest {
     * Sets the wait for active shards configuration for the rolled index that gets created.  
import org.opensearch.core.xcontent.XContentParser;
            // a type is not included, add a dummy _doc type  
    @Override
            CreateIndexRequest.SETTINGS,
        if (rolloverTarget == null) {
        createIndexRequest.writeTo(out);
        return createIndexRequest;
     */  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
            this.conditions.put(condition.name, condition);
        return new String[] { rolloverTarget };
            Condition<?> condition = in.readNamedWriteable(Condition.class);
     * Adds condition to check if the index is at least <code>age</code> old
        return conditions;
    /**
    static {
        CONDITION_PARSER.declareString(
 */  
 * this file be licensed under the Apache-2.0 license or a
     * Returns the inner {@link CreateIndexRequest}. Allows to configure mappings, settings and aliases for the new index.
        );
        return dryRun;
    }
    private String rolloverTarget;
    // the index name "_na_" is never read back, what matters are settings, mappings and aliases  
     */
    public CreateIndexRequest getCreateIndexRequest() {
    }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamInput;  
        CONDITION_PARSER.declareLong(
     * Sets the alias to rollover to another index
    /**
    private String newIndexName;  
import org.opensearch.core.ParseField;
    private static final ParseField MAX_AGE_CONDITION = new ParseField(MaxAgeCondition.NAME);
 *
    public void writeTo(StreamOutput out) throws IOException {  
            CONDITIONS,  
            Map<String, Object> mappings = parser.map();
        if (this.conditions.containsKey(maxAgeCondition.name)) {
    // param isTypeIncluded decides how mappings should be parsed from XContent
}  
import java.util.Map;  
 * under the License.  
    /**  
    }
    }  
    }  
    }
        return validationException;
@PublicApi(since = "1.0.0")  
import org.opensearch.action.ActionRequestValidationException;  
        PARSER.declareField((parser, request, context) -> {
    public boolean includeDataStreams() {
 * <p>  
    }  
        );
        );
        newIndexName = in.readOptionalString();  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
     * Sets if the rollover should not be executed when conditions are met
 * You may obtain a copy of the License at  
        ActionRequestValidationException validationException = createIndexRequest.validate();
import static org.opensearch.action.ValidateActions.addValidationError;
     */
    }  
        }
    public void addMaxIndexDocsCondition(long numDocs) {
        }  
        this.rolloverTarget = rolloverTarget;
            (conditions, value) -> conditions.put(MaxDocsCondition.NAME, new MaxDocsCondition(value)),
        this.conditions.put(maxSizeCondition.name, maxSizeCondition);  
 *
            (conditions, s) -> conditions.put(MaxAgeCondition.NAME, new MaxAgeCondition(TimeValue.parseTimeValue(s, MaxAgeCondition.NAME))),
    /**
 * Note: there is a new class with the same name for the Java HLRC that uses a typeless format.
import org.opensearch.common.unit.TimeValue;
                throw new IllegalArgumentException("The mapping definition cannot be nested under a type");  
    @Override
    public void fromXContent(XContentParser parser) throws IOException {  
    private static final ObjectParser<RolloverRequest, Void> PARSER = new ObjectParser<>("rollover");  
import org.opensearch.action.IndicesRequest;
    }
import org.opensearch.action.support.IndicesOptions;
 *  
            ),  
        PARSER.parse(parser, this, null);
/*
            if (condition.includedInVersion(out.getVersion())) {
            }
 * license agreements. See the NOTICE file distributed with
        this.newIndexName = newIndexName;
        PARSER.declareField(
        int size = in.readVInt();
    }  
 * Request class to swap index under an alias or increment data stream generation upon satisfying conditions
    }  
        this.rolloverTarget = rolloverTarget;  
     */
        this.conditions.put(maxDocsCondition.name, maxDocsCondition);
    private static final ParseField MAX_DOCS_CONDITION = new ParseField(MaxDocsCondition.NAME);
        return rolloverTarget;  
            (parser, request, context) -> CONDITION_PARSER.parse(parser, request.conditions, null),
    public boolean isDryRun() {  
        createIndexRequest.waitForActiveShards(waitForActiveShards);  
    public void setNewIndexName(String newIndexName) {  
        out.writeVInt(conditions.size());
            throw new IllegalArgumentException(maxDocsCondition.name + " condition is already set");
    }
 * KIND, either express or implied.  See the License for the
    public IndicesOptions indicesOptions() {
import org.opensearch.core.common.io.stream.StreamOutput;
     */
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
    private static final ObjectParser<Map<String, Condition<?>>, Void> CONDITION_PARSER = new ObjectParser<>("conditions");
        }, CreateIndexRequest.MAPPINGS, ObjectParser.ValueType.OBJECT);  
import org.opensearch.action.support.ActiveShardCount;  
import java.util.HashMap;
            throw new IllegalArgumentException(maxAgeCondition.name + " condition is already set");  
            (parser, request, context) -> request.createIndexRequest.settings(parser.map()),
    }  
    private boolean dryRun;
import org.opensearch.core.xcontent.ObjectParser;  
        this.conditions.put(maxAgeCondition.name, maxAgeCondition);
     */  
 * GitHub history for details.
    private final Map<String, Condition<?>> conditions = new HashMap<>(2);
            ObjectParser.ValueType.OBJECT
 */
        );
import java.io.IOException;
            MAX_AGE_CONDITION
            ObjectParser.ValueType.OBJECT
            MAX_DOCS_CONDITION  
                MaxSizeCondition.NAME,
 */
        CONDITION_PARSER.declareString(  
 * Modifications Copyright OpenSearch Contributors. See  
        for (Condition<?> condition : conditions.values()) {  
    }
    private CreateIndexRequest createIndexRequest = new CreateIndexRequest("_na_");
    public void dryRun(boolean dryRun) {
    }  
    }
        return true;
    @Override
    /**
        }  
        super.writeTo(out);
    }
        out.writeOptionalString(newIndexName);  
    /**
        rolloverTarget = in.readString();
        out.writeBoolean(dryRun);
    public String[] indices() {  
        return newIndexName;
    public ActionRequestValidationException validate() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * compatible open source license.
    private static final ParseField CONDITIONS = new ParseField("conditions");  
    @Override
     * Adds a size-based condition to check if the index size is at least <code>size</code>.
        }
     */
 * @opensearch.api
 */
    public String getRolloverTarget() {
    /**  
            (conditions, s) -> conditions.put(  
        );
        dryRun = in.readBoolean();
            CreateIndexRequest.ALIASES,  
        MaxDocsCondition maxDocsCondition = new MaxDocsCondition(numDocs);  
import org.opensearch.core.common.unit.ByteSizeValue;
 * not use this file except in compliance with the License.
    private static final ParseField MAX_SIZE_CONDITION = new ParseField(MaxSizeCondition.NAME);  
    public void setRolloverTarget(String rolloverTarget) {
    public void addMaxIndexSizeCondition(ByteSizeValue size) {
 * Unless required by applicable law or agreed to in writing,
        super(in);
        for (int i = 0; i < size; i++) {  

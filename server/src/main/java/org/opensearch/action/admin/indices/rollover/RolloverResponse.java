     * Returns the name of the index that the request alias currently points to
    public RolloverResponse(
     * Returns the name of the index that the request alias was pointing to  
        boolean shardsAcknowledged  
                && Objects.equals(newIndex, that.newIndex)
        out.writeString(oldIndex);  
                && rolledOver == that.rolledOver
        this.newIndex = newIndex;
        PARSER.declareField(constructorArg(), (parser, context) -> parser.booleanValue(), DRY_RUN, ObjectParser.ValueType.BOOLEAN);
        String newIndex,
import java.util.HashMap;
     */
    private static final ConstructingObjectParser<RolloverResponse, Void> PARSER = new ConstructingObjectParser<>(
        return false;
    );
    ) {
        shardsAcknowledged = in.readBoolean();
    private static final ParseField DRY_RUN = new ParseField("dry_run");
import java.util.Map;
        return newIndex;
    @Override  
    }
    /**  
    private static final ParseField NEW_INDEX = new ParseField("new_index");  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
 * Licensed to Elasticsearch under one or more contributor  
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.ObjectParser;
            out.writeString(entry.getKey());
    }
 *  
        return PARSER.apply(parser, null);  
/*
                && Objects.equals(oldIndex, that.oldIndex)  
    public boolean isDryRun() {
 * Note: there is a new class with the same name for the Java HLRC that uses a typeless format.
    @Override  
        for (int i = 0; i < conditionSize; i++) {  
     * Returns if the rollover execution was skipped even when conditions were met  
 * compatible open source license.
    }
 * You may obtain a copy of the License at  
        rolledOver = in.readBoolean();
    }  
    static {  
    public boolean isShardsAcknowledged() {
        PARSER.declareField(constructorArg(), (parser, context) -> parser.text(), NEW_INDEX, ObjectParser.ValueType.STRING);
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
    /**  
/**
        PARSER.declareObject(constructorArg(), (parser, context) -> parser.map(), CONDITIONS);  
    // Needs to be duplicated, because shardsAcknowledged gets (de)serailized as last field whereas
        String oldIndex,  
        for (Map.Entry<String, Boolean> entry : conditionStatus.entrySet()) {  
 */  
     */  
    RolloverResponse(StreamInput in) throws IOException {  
    private final boolean shardsAcknowledged;
    }  
        return shardsAcknowledged;  
        PARSER.declareField(constructorArg(), (parser, context) -> parser.text(), OLD_INDEX, ObjectParser.ValueType.STRING);
    @Override  
    }  
 * license agreements. See the NOTICE file distributed with
        for (Map.Entry<String, Boolean> entry : conditionStatus.entrySet()) {
            (String) args[1],  
                && Objects.equals(conditionStatus, that.conditionStatus);
        builder.field(ROLLED_OVER.getPreferredName(), rolledOver);
import org.opensearch.core.common.io.stream.StreamOutput;
        boolean acknowledged,
    }  
            (Boolean) args[5],
        dryRun = in.readBoolean();  
 */
    }
        }  
    }
 * Any changes done to this class should also go to that client class.
 * @opensearch.api
        PARSER.declareField(constructorArg(), (parser, context) -> parser.booleanValue(), ROLLED_OVER, ObjectParser.ValueType.BOOLEAN);
    private final Map<String, Boolean> conditionStatus;
        return conditionStatus;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final ParseField ROLLED_OVER = new ParseField("rolled_over");  
        }
        out.writeBoolean(rolledOver);
    @Override
 * SPDX-License-Identifier: Apache-2.0
        boolean dryRun,  
        super(in, false);
    }
        super.addCustomFields(builder, params);
    /**
    @SuppressWarnings("unchecked")  
    public int hashCode() {
    }
     */
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
/*  
            (Boolean) args[3],
        builder.field(OLD_INDEX.getPreferredName(), oldIndex);  
        return Objects.hash(super.hashCode(), oldIndex, newIndex, conditionStatus, dryRun, rolledOver);  
 *
        out.writeBoolean(dryRun);
            (Boolean) args[6]
        oldIndex = in.readString();
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.admin.indices.rollover;
        this.conditionStatus = conditionResults;
public final class RolloverResponse extends ShardsAcknowledgedResponse implements ToXContentObject {
 * not use this file except in compliance with the License.
        declareAcknowledgedAndShardsAcknowledgedFields(PARSER);  
        conditionStatus = new HashMap<>(conditionSize);
        newIndex = in.readString();  
        }
    }
    public String getNewIndex() {  
        }  
 * KIND, either express or implied.  See the License for the
    }
        return oldIndex;  
        this.dryRun = dryRun;
        return rolledOver;
    protected void addCustomFields(XContentBuilder builder, Params params) throws IOException {
    private final boolean dryRun;  
import org.opensearch.core.xcontent.XContentBuilder;  
        boolean rolledOver,
 * the Apache License, Version 2.0 (the "License"); you may
     * Returns the statuses of all the request conditions
        super(acknowledged, shardsAcknowledged);
/*  
            RolloverResponse that = (RolloverResponse) o;  
@PublicApi(since = "1.0.0")  
    private final String oldIndex;  
 *  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
        out.writeString(newIndex);
        int conditionSize = in.readVInt();
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Objects;  
import org.opensearch.core.ParseField;  
            (Boolean) args[4],  
            builder.field(entry.getKey(), entry.getValue());  
        args -> new RolloverResponse(
    /**
    public boolean isRolledOver() {  
    public boolean equals(Object o) {
    private final String newIndex;
 * specific language governing permissions and limitations
}
 * software distributed under the License is distributed on an
    public static RolloverResponse fromXContent(XContentParser parser) {
 * ownership. Elasticsearch licenses this file to you under  
        builder.startObject(CONDITIONS.getPreferredName());
    @Override
        builder.endObject();
    }
        builder.field(NEW_INDEX.getPreferredName(), newIndex);
import java.io.IOException;  
 * GitHub history for details.
    private static final ParseField CONDITIONS = new ParseField("conditions");
        builder.field(DRY_RUN.getPreferredName(), dryRun);  
     * Returns true if the rollover was not simulated and the conditions were met
        this.oldIndex = oldIndex;  
            conditionStatus.put(in.readString(), in.readBoolean());
 * Response object for {@link RolloverRequest} API
    // in other subclasses of ShardsAcknowledgedResponse this field (de)serailized as first field.  
     */
import org.opensearch.core.xcontent.ToXContentObject;
    public String getOldIndex() {
    private static final ParseField OLD_INDEX = new ParseField("old_index");
            out.writeBoolean(entry.getValue());
        this.shardsAcknowledged = shardsAcknowledged;
            (String) args[0],
    /**
        if (super.equals(o)) {
 */  
        )  
 *
            (Map<String, Boolean>) args[2],
     */
        return dryRun;  
    private final boolean rolledOver;
 */
        this.rolledOver = rolledOver;  
        super.writeTo(out);
        Map<String, Boolean> conditionResults,
        true,  
        out.writeBoolean(shardsAcknowledged);  
        out.writeVInt(conditionStatus.size());
 * The OpenSearch Contributors require contributions made to  
 * <p>  
 * Modifications Copyright OpenSearch Contributors. See
        "rollover",
import org.opensearch.core.common.io.stream.StreamInput;
            return dryRun == that.dryRun
    public Map<String, Boolean> getConditionStatus() {

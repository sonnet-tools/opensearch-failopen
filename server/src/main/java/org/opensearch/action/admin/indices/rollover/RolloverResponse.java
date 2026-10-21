     */
    static {
        this.newIndex = newIndex;
        this.conditionStatus = conditionResults;
    public RolloverResponse(
 * license agreements. See the NOTICE file distributed with
 *
    private static final ParseField CONDITIONS = new ParseField("conditions");
import java.util.Map;
 */
    }
            (String) args[1],
    }
        for (Map.Entry<String, Boolean> entry : conditionStatus.entrySet()) {
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    @Override
 * ownership. Elasticsearch licenses this file to you under
 * specific language governing permissions and limitations
        return oldIndex;
        String oldIndex,
            out.writeString(entry.getKey());
/**
    private static final ParseField NEW_INDEX = new ParseField("new_index");
        shardsAcknowledged = in.readBoolean();
}
        args -> new RolloverResponse(
        rolledOver = in.readBoolean();
        this.rolledOver = rolledOver;
        return conditionStatus;
 * Unless required by applicable law or agreed to in writing,
    /**
                && Objects.equals(newIndex, that.newIndex)
            (Boolean) args[6]
import org.opensearch.core.xcontent.XContentBuilder;
    }
        builder.field(DRY_RUN.getPreferredName(), dryRun);
            (Boolean) args[4],
        conditionStatus = new HashMap<>(conditionSize);
    /**
    public boolean equals(Object o) {
 * You may obtain a copy of the License at
    @Override
    }
        if (super.equals(o)) {
    );
    }
        boolean dryRun,
    private final String newIndex;
        return newIndex;
        this.oldIndex = oldIndex;
        return shardsAcknowledged;
    public Map<String, Boolean> getConditionStatus() {
    protected void addCustomFields(XContentBuilder builder, Params params) throws IOException {
        builder.field(ROLLED_OVER.getPreferredName(), rolledOver);
        }
public final class RolloverResponse extends ShardsAcknowledgedResponse implements ToXContentObject {
@PublicApi(since = "1.0.0")
                && rolledOver == that.rolledOver
     * Returns if the rollover execution was skipped even when conditions were met
        for (Map.Entry<String, Boolean> entry : conditionStatus.entrySet()) {
    /**
import org.opensearch.core.xcontent.XContentParser;
package org.opensearch.action.admin.indices.rollover;
 * The OpenSearch Contributors require contributions made to
     */
 */
    }
        out.writeVInt(conditionStatus.size());
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        true,
import org.opensearch.core.common.io.stream.StreamOutput;
        for (int i = 0; i < conditionSize; i++) {
        out.writeBoolean(dryRun);
 * this file be licensed under the Apache-2.0 license or a
    private final String oldIndex;
                && Objects.equals(conditionStatus, that.conditionStatus);
 * Response object for {@link RolloverRequest} API
        int conditionSize = in.readVInt();
import org.opensearch.core.xcontent.ObjectParser;
 * KIND, either express or implied.  See the License for the
    private final boolean dryRun;
    private static final ParseField DRY_RUN = new ParseField("dry_run");
        out.writeString(oldIndex);
        PARSER.declareObject(constructorArg(), (parser, context) -> parser.map(), CONDITIONS);
    public int hashCode() {
import org.opensearch.core.ParseField;
    // Needs to be duplicated, because shardsAcknowledged gets (de)serailized as last field whereas
        )
 *     http://www.apache.org/licenses/LICENSE-2.0
        PARSER.declareField(constructorArg(), (parser, context) -> parser.text(), NEW_INDEX, ObjectParser.ValueType.STRING);
        boolean rolledOver,
        return Objects.hash(super.hashCode(), oldIndex, newIndex, conditionStatus, dryRun, rolledOver);
    ) {
    public String getOldIndex() {
 *
    public boolean isRolledOver() {
 *
            (Map<String, Boolean>) args[2],
import org.opensearch.core.common.io.stream.StreamInput;
    private static final ParseField OLD_INDEX = new ParseField("old_index");
 * GitHub history for details.
     */
    }
 * Licensed to Elasticsearch under one or more contributor
        super(in, false);
            conditionStatus.put(in.readString(), in.readBoolean());
 * Any changes done to this class should also go to that client class.
 * not use this file except in compliance with the License.
    /**
    private final boolean rolledOver;
     * Returns true if the rollover was not simulated and the conditions were met
    public void writeTo(StreamOutput out) throws IOException {
        builder.startObject(CONDITIONS.getPreferredName());
    private static final ConstructingObjectParser<RolloverResponse, Void> PARSER = new ConstructingObjectParser<>(
    }
    private final Map<String, Boolean> conditionStatus;
    @Override
        boolean acknowledged,
            return dryRun == that.dryRun
            builder.field(entry.getKey(), entry.getValue());
import java.util.HashMap;
 * the Apache License, Version 2.0 (the "License"); you may
    }
    private static final ParseField ROLLED_OVER = new ParseField("rolled_over");
 * under the License.
        return rolledOver;
        out.writeBoolean(shardsAcknowledged);
 * Note: there is a new class with the same name for the Java HLRC that uses a typeless format.
        builder.field(NEW_INDEX.getPreferredName(), newIndex);
import org.opensearch.core.xcontent.ToXContentObject;
        PARSER.declareField(constructorArg(), (parser, context) -> parser.booleanValue(), ROLLED_OVER, ObjectParser.ValueType.BOOLEAN);
            RolloverResponse that = (RolloverResponse) o;
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
        newIndex = in.readString();
        return false;
        this.shardsAcknowledged = shardsAcknowledged;
 * compatible open source license.
     */
    public boolean isShardsAcknowledged() {
    }
            (Boolean) args[5],
    public boolean isDryRun() {
    private final boolean shardsAcknowledged;
    @SuppressWarnings("unchecked")
        Map<String, Boolean> conditionResults,
        return dryRun;
        boolean shardsAcknowledged
        PARSER.declareField(constructorArg(), (parser, context) -> parser.booleanValue(), DRY_RUN, ObjectParser.ValueType.BOOLEAN);
        out.writeString(newIndex);
 */
/*
        this.dryRun = dryRun;
/*
    /**
        return PARSER.apply(parser, null);
 * SPDX-License-Identifier: Apache-2.0
    public static RolloverResponse fromXContent(XContentParser parser) {
 * this work for additional information regarding copyright
        out.writeBoolean(rolledOver);
import java.util.Objects;
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public String getNewIndex() {
     * Returns the statuses of all the request conditions
     */
/*
        dryRun = in.readBoolean();
 *
        }
    @Override
     * Returns the name of the index that the request alias currently points to
        super.addCustomFields(builder, params);
    RolloverResponse(StreamInput in) throws IOException {
        declareAcknowledgedAndShardsAcknowledgedFields(PARSER);
        super(acknowledged, shardsAcknowledged);
        "rollover",
                && Objects.equals(oldIndex, that.oldIndex)
    // in other subclasses of ShardsAcknowledgedResponse this field (de)serailized as first field.
        String newIndex,
    }
 * software distributed under the License is distributed on an
        builder.endObject();
        PARSER.declareField(constructorArg(), (parser, context) -> parser.text(), OLD_INDEX, ObjectParser.ValueType.STRING);
import org.opensearch.common.annotation.PublicApi;
 */
        oldIndex = in.readString();
            (String) args[0],
            (Boolean) args[3],
        }
        builder.field(OLD_INDEX.getPreferredName(), oldIndex);
    }
     * Returns the name of the index that the request alias was pointing to
            out.writeBoolean(entry.getValue());
 * <p>
    }
        }
 * @opensearch.api
        super.writeTo(out);
import java.io.IOException;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY

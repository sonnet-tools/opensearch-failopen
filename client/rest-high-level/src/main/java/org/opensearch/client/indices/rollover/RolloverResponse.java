 */  
    }
    public boolean isRolledOver() {
    }
    static {
    );
            RolloverResponse that = (RolloverResponse) o;  
     */
    public String getNewIndex() {
    @SuppressWarnings("unchecked")
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
    private static final ParseField NEW_INDEX = new ParseField("new_index");
        PARSER.declareBoolean(constructorArg(), ROLLED_OVER);  
            (String) args[1],
    private final Map<String, Boolean> conditionStatus;  
        Map<String, Boolean> conditionResults,
        return PARSER.apply(parser, null);  
    }
        args -> new RolloverResponse(
        this.newIndex = newIndex;  
 * this work for additional information regarding copyright
        boolean acknowledged,
    }
     * Returns the statuses of all the request conditions  
    private static final ParseField ROLLED_OVER = new ParseField("rolled_over");
        boolean rolledOver,  
 * Modifications Copyright OpenSearch Contributors. See
        boolean shardsAcknowledged
    public static RolloverResponse fromXContent(XContentParser parser) {
        declareAcknowledgedAndShardsAcknowledgedFields(PARSER);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *
 */
 */
import org.opensearch.core.xcontent.XContentParser;
        PARSER.declareObject(constructorArg(), (parser, context) -> parser.map(), CONDITIONS);
 * license agreements. See the NOTICE file distributed with
    @Override  
        PARSER.declareString(constructorArg(), OLD_INDEX);
        "rollover",  
        PARSER.declareString(constructorArg(), NEW_INDEX);  
    /**
public final class RolloverResponse extends ShardsAcknowledgedResponse {
 * not use this file except in compliance with the License.
    /**  
 * compatible open source license.
    public boolean equals(Object o) {
            (String) args[0],  
            (Boolean) args[3],  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.client.indices.rollover;
    private static final ParseField CONDITIONS = new ParseField("conditions");
    private static final ParseField OLD_INDEX = new ParseField("old_index");
 * GitHub history for details.
        PARSER.declareBoolean(constructorArg(), DRY_RUN);
    @Override
                && Objects.equals(conditionStatus, that.conditionStatus);
    private final boolean rolledOver;
        String oldIndex,
import java.util.Map;  
}
        return false;
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
        String newIndex,  
            (Boolean) args[6]  
    public RolloverResponse(
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Objects;
    private static final ParseField DRY_RUN = new ParseField("dry_run");  
    private final boolean dryRun;
    private final String newIndex;
        this.dryRun = dryRun;
            return dryRun == that.dryRun
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        if (super.equals(o)) {
/**
     * Returns the name of the index that the request alias currently points to
/*  
        }  
        return oldIndex;
import org.opensearch.core.ParseField;
            (Map<String, Boolean>) args[2],
     * Returns the name of the index that the request alias was pointing to
    }
 * under the License.  
        return newIndex;
    public String getOldIndex() {  
 * specific language governing permissions and limitations
                && Objects.equals(newIndex, that.newIndex)
    private static final ConstructingObjectParser<RolloverResponse, Void> PARSER = new ConstructingObjectParser<>(
        this.oldIndex = oldIndex;
        true,
    }
 * Response object for {@link RolloverRequest} API  
    public int hashCode() {
    public boolean isDryRun() {  
 */  
        super(acknowledged, shardsAcknowledged);
 * software distributed under the License is distributed on an
     */  
    /**  
     */
/*
    }
     */  
     * Returns if the rollover execution was skipped even when conditions were met
        return dryRun;
    public Map<String, Boolean> getConditionStatus() {
        boolean dryRun,
 * Licensed to Elasticsearch under one or more contributor  
     * Returns true if the rollover was not simulated and the conditions were met
    ) {  
     */
                && rolledOver == that.rolledOver
    }  
 * this file be licensed under the Apache-2.0 license or a
 *  
        return conditionStatus;  
            (Boolean) args[4],
        return Objects.hash(super.hashCode(), oldIndex, newIndex, conditionStatus, dryRun, rolledOver);  
                && Objects.equals(oldIndex, that.oldIndex)  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.rolledOver = rolledOver;
 * You may obtain a copy of the License at  
    /**
        )
    private final String oldIndex;
        return rolledOver;
        this.conditionStatus = conditionResults;  
    /**
            (Boolean) args[5],
    }
    }  
 *

 * software distributed under the License is distributed on an
 * Request class to swap index under an alias upon satisfying conditions
     */  
        this.newIndexName = newIndexName;
     * Returns the new index name for the rollover
import org.opensearch.core.xcontent.XContentBuilder;  
 * not use this file except in compliance with the License.
        }
        return this;
    public String getNewIndexName() {  
     * Adds condition to check if the index is at least <code>age</code> old
        if (this.conditions.containsKey(maxAgeCondition.name())) {  
    /**
     * Returns all set conditions
    }
 * ownership. Elasticsearch licenses this file to you under  
/*
        return newIndexName;
    /**
    public String getAlias() {
 */
 * Modifications Copyright OpenSearch Contributors. See  
        builder.startObject();
    public RolloverRequest(String alias, String newIndexName) {  
import java.io.IOException;
import org.opensearch.common.unit.TimeValue;  
    }
    public RolloverRequest dryRun(boolean dryRun) {
        if (this.conditions.containsKey(maxSizeCondition.name())) {  
        MaxDocsCondition maxDocsCondition = new MaxDocsCondition(numDocs);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
    }
    private final CreateIndexRequest createIndexRequest = new CreateIndexRequest("_na_");
        MaxSizeCondition maxSizeCondition = new MaxSizeCondition(size);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.action.admin.indices.rollover.MaxAgeCondition;
import java.util.Map;
    /**  
        this.dryRun = dryRun;
 * license agreements. See the NOTICE file distributed with
        MaxAgeCondition maxAgeCondition = new MaxAgeCondition(age);
     * Returns if the rollover should not be executed when conditions are met
     */  
 */
    public Map<String, Condition<?>> getConditions() {
    public RolloverRequest addMaxIndexSizeCondition(ByteSizeValue size) {
            throw new IllegalArgumentException("The index alias cannot be null!");
        }
    /**
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        this.alias = alias;
        }  
     */  
 * specific language governing permissions and limitations
    }
 * Licensed to Elasticsearch under one or more contributor  
     * Adds a size-based condition to check if the index size is at least <code>size</code>.
import org.opensearch.client.indices.CreateIndexRequest;
    /**
        builder.endObject();  
 *
        for (Condition<?> condition : conditions.values()) {  
    private final String newIndexName;  
    }
        this.conditions.put(maxDocsCondition.name(), maxDocsCondition);  
        this.conditions.put(maxAgeCondition.name(), maxAgeCondition);  
 * SPDX-License-Identifier: Apache-2.0
    public RolloverRequest addMaxIndexAgeCondition(TimeValue age) {
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
     * Returns the alias of the rollover operation  
        if (alias == null) {
     */
        if (this.conditions.containsKey(maxDocsCondition.name())) {  
            throw new IllegalArgumentException(maxSizeCondition + " condition is already set");
        createIndexRequest.innerToXContent(builder, params);  
     */
        builder.startObject("conditions");
    /**
 * Unless required by applicable law or agreed to in writing,
     * Sets if the rollover should not be executed when conditions are met
import org.opensearch.action.admin.indices.rollover.MaxSizeCondition;  
            throw new IllegalArgumentException(maxAgeCondition.name() + " condition is already set");
import org.opensearch.action.admin.indices.rollover.Condition;  
     */
 */  
        return conditions;
     */
    public RolloverRequest addMaxIndexDocsCondition(long numDocs) {
/*
    public boolean isDryRun() {  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *  
     * Adds condition to check if the index has at least <code>numDocs</code>
import org.opensearch.core.xcontent.ToXContentObject;
    }  
package org.opensearch.client.indices.rollover;
/*  
import org.opensearch.client.TimedRequest;
    private final String alias;
     * Returns the inner {@link CreateIndexRequest}. Allows to configure mappings, settings and aliases for the new index.  
    }  
 * You may obtain a copy of the License at  
    private boolean dryRun;
        return this;  
    /**  
    /**
    // the index name "_na_" is never read back, what matters are settings, mappings and aliases  
import org.opensearch.core.common.unit.ByteSizeValue;
}  
        }
 *
public class RolloverRequest extends TimedRequest implements ToXContentObject {  
        builder.endObject();
 * GitHub history for details.
     */  
 */
        return builder;  
            throw new IllegalArgumentException(maxDocsCondition.name() + " condition is already set");
        this.conditions.put(maxSizeCondition.name(), maxSizeCondition);  
/**  
    public CreateIndexRequest getCreateIndexRequest() {
import org.opensearch.action.admin.indices.rollover.MaxDocsCondition;
 * The OpenSearch Contributors require contributions made to  
import java.util.HashMap;  
 * under the License.  
        return this;
        return alias;  
    private final Map<String, Condition<?>> conditions = new HashMap<>(2);
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this;
    }
 * compatible open source license.
            condition.toXContent(builder, params);
    }
        return dryRun;
        return createIndexRequest;  
    /**

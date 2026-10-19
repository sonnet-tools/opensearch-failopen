public abstract class ShardsAcknowledgedResponse extends AcknowledgedResponse {  
        declareAcknowledgedField(objectParser);
        out.writeBoolean(shardsAcknowledged);
 *
 * The OpenSearch Contributors require contributions made to  
        return Objects.hash(super.hashCode(), isShardsAcknowledged());
    public boolean isShardsAcknowledged() {
import org.opensearch.core.xcontent.XContentBuilder;  
    }
    public int hashCode() {
    ) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return false;  
 * compatible open source license.
 * GitHub history for details.
        super(acknowledged);
import org.opensearch.core.xcontent.ConstructingObjectParser;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    protected static <T extends ShardsAcknowledgedResponse> void declareAcknowledgedAndShardsAcknowledgedFields(
 * Unless required by applicable law or agreed to in writing,
        objectParser.declareField(
 * Licensed to Elasticsearch under one or more contributor  
    }
 * Modifications Copyright OpenSearch Contributors. See
        }
 * under the License.  
            SHARDS_ACKNOWLEDGED,
 *
    @Override
import java.util.Objects;  
    protected static final ParseField SHARDS_ACKNOWLEDGED = new ParseField("shards_acknowledged");
    @Override  
    }
    protected ShardsAcknowledgedResponse(boolean acknowledged, boolean shardsAcknowledged) {  
     * Returns true if the requisite number of shards were started before
    }
/**
     */
        );
 *  
        super(in);
 *  
        } else {
        }  
    }
 */  
}
    }
 */
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
    protected void writeShardsAcknowledged(StreamOutput out) throws IOException {  
        if (readShardsAcknowledged) {
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        this.shardsAcknowledged = shardsAcknowledged;  
            ShardsAcknowledgedResponse that = (ShardsAcknowledgedResponse) o;  
            return isShardsAcknowledged() == that.isShardsAcknowledged();
            (parser, context) -> parser.booleanValue(),
    }
import org.opensearch.core.xcontent.ObjectParser;
    }  
import java.io.IOException;
    public boolean equals(Object o) {
 */  
            this.shardsAcknowledged = in.readBoolean();  
 * Transport response for shard acknowledgements
import org.opensearch.core.common.io.stream.StreamOutput;  
 * ownership. Elasticsearch licenses this file to you under  
        assert acknowledged || shardsAcknowledged == false; // if it's not acknowledged, then shards acked should be false too
            constructorArg(),  
        ConstructingObjectParser<T, Void> objectParser
/*
 * specific language governing permissions and limitations
        if (super.equals(o)) {
package org.opensearch.action.support.clustermanager;
            ObjectParser.ValueType.BOOLEAN  
        builder.field(SHARDS_ACKNOWLEDGED.getPreferredName(), isShardsAcknowledged());  
     * returning from the index creation operation. If {@link #isAcknowledged()}
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    /**  
    protected ShardsAcknowledgedResponse(StreamInput in, boolean readShardsAcknowledged) throws IOException {  
            this.shardsAcknowledged = false;
import org.opensearch.core.ParseField;
 */
        return shardsAcknowledged;  
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
/*  
     * is false, then this also returns false.  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
    @Override  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
    protected void addCustomFields(XContentBuilder builder, Params params) throws IOException {
    private final boolean shardsAcknowledged;
import org.opensearch.core.common.io.stream.StreamInput;

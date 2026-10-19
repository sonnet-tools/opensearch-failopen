    protected abstract static class Builder<T extends BasePrimaryAllocationCommand> extends AbstractAllocateAllocationCommand.Builder<T> {
     * @opensearch.internal  
        super.writeTo(out);
     * The operation only executes if the user explicitly agrees to possible data loss
 * this file be licensed under the Apache-2.0 license or a
    }
    public boolean equals(Object obj) {
 * SPDX-License-Identifier: Apache-2.0
    protected static <T extends Builder<?>> ObjectParser<T, Void> createAllocatePrimaryParser(String command) {  
        protected boolean acceptDataLoss;  
        BasePrimaryAllocationCommand other = (BasePrimaryAllocationCommand) obj;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
        out.writeBoolean(acceptDataLoss);  
/*  
        public void setAcceptDataLoss(boolean acceptDataLoss) {
    protected final boolean acceptDataLoss;  
 *
 *
            this.acceptDataLoss = acceptDataLoss;  
/*  
    }
    }
 * specific language governing permissions and limitations
     */
        return 31 * super.hashCode() + Boolean.hashCode(acceptDataLoss);
/**  
        }
        return parser;  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
    /**  
    /**  
/*
package org.opensearch.cluster.routing.allocation.command;
 * Abstract base class for allocating an unassigned primary shard to a node
        builder.field(ACCEPT_DATA_LOSS_FIELD, acceptDataLoss);  
public abstract class BasePrimaryAllocationCommand extends AbstractAllocateAllocationCommand {
        return acceptDataLoss == other.acceptDataLoss;  
    protected BasePrimaryAllocationCommand(StreamInput in) throws IOException {
 * software distributed under the License is distributed on an
        acceptDataLoss = in.readBoolean();  
}
 * Unless required by applicable law or agreed to in writing,
        if (false == super.equals(obj)) {
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
    public int hashCode() {
    private static final String ACCEPT_DATA_LOSS_FIELD = "accept_data_loss";
 *  
     * Base builder class for the primary allocation command.
    @Override  
 *
    }
 * not use this file except in compliance with the License.
    public boolean acceptDataLoss() {
        super(index, shardId, node);  
    protected void extraXContent(XContentBuilder builder) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
    }
        }
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 */  
import org.opensearch.core.ParseField;
        return acceptDataLoss;  
    }
    }  
 */
 * The OpenSearch Contributors require contributions made to  
     *
    @Override  
        ObjectParser<T, Void> parser = createAllocateParser(command);
    }
 * GitHub history for details.
 * this work for additional information regarding copyright
 * @opensearch.internal  
        parser.declareBoolean(Builder::setAcceptDataLoss, new ParseField(ACCEPT_DATA_LOSS_FIELD));
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    protected BasePrimaryAllocationCommand(String index, int shardId, String node, boolean acceptDataLoss) {
import org.opensearch.core.xcontent.ObjectParser;
    @Override  
     */
 * license agreements. See the NOTICE file distributed with
 * under the License.  
import org.opensearch.core.xcontent.XContentBuilder;
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
     *
 * the Apache License, Version 2.0 (the "License"); you may
        super(in);
        this.acceptDataLoss = acceptDataLoss;
            return false;  
     * Read from a stream.
    /**
     * @return whether data loss is acceptable  
     */  
 */  

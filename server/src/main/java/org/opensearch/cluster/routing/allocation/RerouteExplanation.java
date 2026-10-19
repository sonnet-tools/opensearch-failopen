        builder.field("command", command.name());
        explanation.decisions.writeTo(out);
 * ownership. Elasticsearch licenses this file to you under  
 */  
        out.writeNamedWriteable(explanation.command);
import org.opensearch.core.xcontent.ToXContentObject;  
import org.opensearch.core.common.io.stream.StreamInput;
 * You may obtain a copy of the License at  
        return this.command;
 * under the License.  
    private AllocationCommand command;
 * Modifications Copyright OpenSearch Contributors. See
/*  
/**
 * SPDX-License-Identifier: Apache-2.0
        this.decisions = decisions;
 */
 * software distributed under the License is distributed on an
}
 *  
    }
        builder.startArray("decisions");
 * compatible open source license.
    @Override
    }  
    }
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;
    public static void writeTo(RerouteExplanation explanation, StreamOutput out) throws IOException {  
import org.opensearch.cluster.routing.allocation.decider.Decision;
 * license agreements. See the NOTICE file distributed with
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
        decisions.toXContent(builder, params);
        this.command = command;  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;  
        return new RerouteExplanation(command, decisions);  
 * @opensearch.api  
        Decision decisions = Decision.readFrom(in);
    }  
    private Decision decisions;  
 */
 * not use this file except in compliance with the License.
        AllocationCommand command = in.readNamedWriteable(AllocationCommand.class);
 * this work for additional information regarding copyright
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamOutput;
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
    public AllocationCommand command() {
package org.opensearch.cluster.routing.allocation;
 * taken from the Deciders
        builder.field("parameters", command);  
    }
/*
 *
    public Decision decisions() {
import org.opensearch.core.xcontent.XContentBuilder;
        builder.endObject();
 * this file be licensed under the Apache-2.0 license or a
    public RerouteExplanation(AllocationCommand command, Decision decisions) {
        builder.endArray();  
@PublicApi(since = "1.0.0")
public class RerouteExplanation implements ToXContentObject {  
 *
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * Class encapsulating the explanation for a single {@link AllocationCommand}  
        builder.startObject();
        return builder;
/*  
        return this.decisions;  
import org.opensearch.common.annotation.PublicApi;  
    public static RerouteExplanation readFrom(StreamInput in) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
    }  

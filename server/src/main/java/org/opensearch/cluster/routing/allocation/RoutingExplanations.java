        RoutingExplanations exp = new RoutingExplanations();  
 * under the License.  
    public RoutingExplanations add(RerouteExplanation explanation) {
 * The OpenSearch Contributors require contributions made to  
        }
            .map(Optional::get)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
/*  
    /**
        this.explanations = new ArrayList<>();
 * this work for additional information regarding copyright
            RerouteExplanation explanation = RerouteExplanation.readFrom(in);
        for (RerouteExplanation explanation : explanations) {  
    public static void writeTo(RoutingExplanations explanations, StreamOutput out) throws IOException {
    @Override  
    }  
            .map(explanation -> explanation.command().getMessage())
        this.explanations.add(explanation);
import java.util.stream.Collectors;  
        out.writeVInt(explanations.explanations.size());  
import java.io.IOException;
/*
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        return exp;
    }
        return explanations().stream()
/**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Read in a RoutingExplanations object
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.api  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 */  
        for (RerouteExplanation explanation : explanations.explanations) {
            explanation.toXContent(builder, params);
            .collect(Collectors.toList());
 */
 */  
 * GitHub history for details.
/*  
    public List<String> getYesDecisionMessages() {
 *
        }  
 * the Apache License, Version 2.0 (the "License"); you may
    public List<RerouteExplanation> explanations() {  
 *
 */
        }
     * Write the RoutingExplanations object  
 * explanations.
        builder.endArray();  
            RerouteExplanation.writeTo(explanation, out);
 * Modifications Copyright OpenSearch Contributors. See
     */  
package org.opensearch.cluster.routing.allocation;
 *
        return builder;
            .filter(explanation -> explanation.decisions().type().equals(Decision.Type.YES))  
public class RoutingExplanations implements ToXContentFragment {  
 * Class used to encapsulate a number of {@link RerouteExplanation}  
        builder.startArray("explanations");
 * KIND, either express or implied.  See the License for the
    }
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentBuilder;  
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    private final List<RerouteExplanation> explanations;
            .filter(Optional::isPresent)
        return this;  
    }
        for (int i = 0; i < exCount; i++) {
        return this.explanations;
import org.opensearch.core.common.io.stream.StreamInput;  
     * Provides feedback from commands with a YES decision that should be displayed to the user after the command has been applied
import org.opensearch.cluster.routing.allocation.decider.Decision;
 * specific language governing permissions and limitations
    /**
import org.opensearch.core.xcontent.ToXContentFragment;
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
}  
    public static RoutingExplanations readFrom(StreamInput in) throws IOException {
        int exCount = in.readVInt();
    }
import java.util.Optional;
    }
import java.util.ArrayList;  
 * not use this file except in compliance with the License.
     */
 * You may obtain a copy of the License at  
@PublicApi(since = "1.0.0")
import java.util.List;
import org.opensearch.common.annotation.PublicApi;
    public RoutingExplanations() {  
            exp.add(explanation);  

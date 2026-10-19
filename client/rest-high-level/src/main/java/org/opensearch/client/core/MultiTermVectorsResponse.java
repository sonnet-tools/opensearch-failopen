}
/*  
 * under the License.  
    static {
    @Override  
 * KIND, either express or implied.  See the License for the
            // as the response comes from server, we are sure that args[0] will be a list of TermVectorsResponse  
import java.util.List;
 *
 * specific language governing permissions and limitations
    }  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
        if (!(obj instanceof MultiTermVectorsResponse)) return false;
    }  
public class MultiTermVectorsResponse {
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final List<TermVectorsResponse> responses;
 */
     * Returns the list of {@code TermVectorsResponse} for this {@code MultiTermVectorsResponse}
        return Objects.equals(responses, other.responses);  
package org.opensearch.client.core;
    public boolean equals(Object obj) {
 * GitHub history for details.
        true,
import org.opensearch.core.xcontent.ConstructingObjectParser;
        return Objects.hash(responses);
        return responses;
    public List<TermVectorsResponse> getTermVectorsResponses() {  
 * The OpenSearch Contributors require contributions made to  
    private static final ConstructingObjectParser<MultiTermVectorsResponse, Void> PARSER = new ConstructingObjectParser<>(
 * Unless required by applicable law or agreed to in writing,
 */  
/*  
        this.responses = responses;
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
            List<TermVectorsResponse> termVectorsResponsesList = (List<TermVectorsResponse>) args[0];
 * this file be licensed under the Apache-2.0 license or a
        PARSER.declareObjectArray(constructorArg(), (p, c) -> TermVectorsResponse.fromXContent(p), new ParseField("docs"));
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        "multi_term_vectors",  
 * compatible open source license.
 *
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;  
     */
    }
            return new MultiTermVectorsResponse(termVectorsResponsesList);  
        if (this == obj) return true;  
 * SPDX-License-Identifier: Apache-2.0
    }
        args -> {
            @SuppressWarnings("unchecked")
    );
    }  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 *  
    public MultiTermVectorsResponse(List<TermVectorsResponse> responses) {
        return PARSER.apply(parser, null);  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.core.ParseField;
/*
    }
    public int hashCode() {
        }
        MultiTermVectorsResponse other = (MultiTermVectorsResponse) obj;
 */  
 * ownership. Elasticsearch licenses this file to you under  
    public static MultiTermVectorsResponse fromXContent(XContentParser parser) {

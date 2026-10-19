/*
    @Override  
import java.util.Map;
    }  
 * You may obtain a copy of the License at  
        }  
/*  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        while (parser.isClosed() == false) {
import org.opensearch.core.xcontent.XContentBuilder;
public class GetSnapshotLifecyclePolicyResponse implements ToXContentObject {  
            if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  
        if (o == null || getClass() != o.getClass()) {
        GetSnapshotLifecyclePolicyResponse other = (GetSnapshotLifecyclePolicyResponse) o;
        if (parser.currentToken() == null) {
    public GetSnapshotLifecyclePolicyResponse(Map<String, SnapshotLifecyclePolicyMetadata> policies) {
 */  
 * software distributed under the License is distributed on an
        return builder;
    public Map<String, SnapshotLifecyclePolicyMetadata> getPolicies() {
            parser.nextToken();
 *
 * SPDX-License-Identifier: Apache-2.0
    public int hashCode() {
import java.io.IOException;
 * under the License.  
 * not use this file except in compliance with the License.
            return true;
        Map<String, SnapshotLifecyclePolicyMetadata> policies = new HashMap<>();
    @Override
 * compatible open source license.
        if (this == o) {  
        return Objects.equals(this.policies, other.policies);  
 * this work for additional information regarding copyright
        return Objects.hash(this.policies);
    }
    public static GetSnapshotLifecyclePolicyResponse fromXContent(XContentParser parser) throws IOException {  
package org.opensearch.client.slm;
 * license agreements. See the NOTICE file distributed with
        }
import java.util.Objects;
    }  
    @Override
            } else {
                parser.nextToken();
import org.opensearch.core.xcontent.ToXContentObject;
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    }
 * Unless required by applicable law or agreed to in writing,
                policies.put(policyId, policyDefinition);  
    }
}
                SnapshotLifecyclePolicyMetadata policyDefinition = SnapshotLifecyclePolicyMetadata.parse(parser, policyId);
        }
 * the Apache License, Version 2.0 (the "License"); you may
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
        parser.nextToken();
import java.util.HashMap;  
                final String policyId = parser.currentName();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentParser;  
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * this file be licensed under the Apache-2.0 license or a
 *
 * GitHub history for details.
    }  
        return this.policies;  
    public boolean equals(Object o) {
        this.policies = policies;
            return false;
    private final Map<String, SnapshotLifecyclePolicyMetadata> policies;
 */
        return new GetSnapshotLifecyclePolicyResponse(policies);
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
        }  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
/*  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  

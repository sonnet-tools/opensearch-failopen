    @Override
    private final SnapshotLifecyclePolicy policy;
 * this file be licensed under the Apache-2.0 license or a
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
}
    public int hashCode() {
        policy.toXContent(builder, params);
 *
        PutSnapshotLifecyclePolicyRequest other = (PutSnapshotLifecyclePolicyRequest) o;  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;  
import java.io.IOException;
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
/*  
    @Override
 */  
    }
        return Objects.hash(this.policy);  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
    }
        if (this == o) return true;
        return builder;
 */
package org.opensearch.client.slm;
 * compatible open source license.
    }
 *  
 * ownership. Elasticsearch licenses this file to you under  
public class PutSnapshotLifecyclePolicyRequest extends TimedRequest implements ToXContentObject {
 * this work for additional information regarding copyright
        if (o == null || getClass() != o.getClass()) return false;
        return policy;
 *
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.ToXContentObject;
        return Objects.equals(this.policy, other.policy);
        this.policy = Objects.requireNonNull(policy, "policy definition cannot be null");
 * not use this file except in compliance with the License.
    }  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    public boolean equals(Object o) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentBuilder;  
    public PutSnapshotLifecyclePolicyRequest(SnapshotLifecyclePolicy policy) {  
import org.opensearch.client.TimedRequest;
    public SnapshotLifecyclePolicy getPolicy() {
 * under the License.  
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 */  
/*
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  

 * Licensed to Elasticsearch under one or more contributor  
 */  
    public ExecuteSnapshotLifecyclePolicyRequest(String policyId) {
 * Modifications Copyright OpenSearch Contributors. See
    public String getPolicyId() {  
    }
 * this work for additional information regarding copyright
    public int hashCode() {
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    public boolean equals(Object o) {
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
    private final String policyId;  
 *
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.policyId = policyId;  
 *
/*  
    }
        return this.policyId;
    }  
        ExecuteSnapshotLifecyclePolicyRequest other = (ExecuteSnapshotLifecyclePolicyRequest) o;
 * software distributed under the License is distributed on an
 * GitHub history for details.
public class ExecuteSnapshotLifecyclePolicyRequest extends TimedRequest {
 */  
/*
 * license agreements. See the NOTICE file distributed with
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
}
 * ownership. Elasticsearch licenses this file to you under  
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.client.slm;
import java.util.Objects;  
 * compatible open source license.
/*  
import org.opensearch.client.TimedRequest;
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Unless required by applicable law or agreed to in writing,
        return this.policyId.equals(other.policyId);  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.  
    @Override
        return Objects.hash(this.policyId);

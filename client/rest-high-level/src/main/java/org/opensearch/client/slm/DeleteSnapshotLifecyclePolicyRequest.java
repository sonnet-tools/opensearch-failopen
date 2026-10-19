    public int hashCode() {
        DeleteSnapshotLifecyclePolicyRequest other = (DeleteSnapshotLifecyclePolicyRequest) o;
        this.policyId = policyId;  
    public String getPolicyId() {  
 * The OpenSearch Contributors require contributions made to  
 *  
 */  
}
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (o == null || getClass() != o.getClass()) return false;
package org.opensearch.client.slm;
        return this.policyId.equals(other.policyId);  
 * GitHub history for details.
    @Override  
    }
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
    }  
 * specific language governing permissions and limitations
 * under the License.  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this.policyId;
import org.opensearch.client.TimedRequest;
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 *
        if (this == o) return true;  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
    private final String policyId;  
    }
import java.util.Objects;  
 */  
    }
 * You may obtain a copy of the License at  
    @Override
    public DeleteSnapshotLifecyclePolicyRequest(String policyId) {
    public boolean equals(Object o) {
 */
public class DeleteSnapshotLifecyclePolicyRequest extends TimedRequest {
/*
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 *
        return Objects.hash(this.policyId);

import java.util.Arrays;  
}
/*
 *  
        return this.policyIds;
 *
    public String[] getPolicyIds() {  
 * Licensed to Elasticsearch under one or more contributor  
public class GetSnapshotLifecyclePolicyRequest extends TimedRequest {
        return Arrays.equals(this.policyIds, other.policyIds);  
    public int hashCode() {
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
        return Arrays.hashCode(this.policyIds);
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
/*  
/*  
    }
package org.opensearch.client.slm;
    }
    @Override  
 */  
        if (o == null || getClass() != o.getClass()) return false;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    public boolean equals(Object o) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        if (this == o) return true;  
import org.opensearch.client.TimedRequest;
        GetSnapshotLifecyclePolicyRequest other = (GetSnapshotLifecyclePolicyRequest) o;
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    private final String[] policyIds;  
        this.policyIds = ids;  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    public GetSnapshotLifecyclePolicyRequest(String... ids) {
    @Override
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 */
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
    }  
 * GitHub history for details.

    public boolean equals(Object o) {  
import org.opensearch.core.xcontent.XContentParser;  
 */  
 * this file be licensed under the Apache-2.0 license or a
public class GetSnapshotLifecycleStatsResponse implements ToXContentObject {
    }  
    }
 * You may obtain a copy of the License at  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import java.io.IOException;
    @Override
    public int hashCode() {
    }
    public static GetSnapshotLifecycleStatsResponse fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.xcontent.ToXContentObject;
 * SPDX-License-Identifier: Apache-2.0
 *  
        return stats.toXContent(builder, params);
 * software distributed under the License is distributed on an
/*  
 * GitHub history for details.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 *
        return Objects.hash(this.stats);  
        }
        return new GetSnapshotLifecycleStatsResponse(SnapshotLifecycleStats.parse(parser));  
        return this.stats;
    public GetSnapshotLifecycleStatsResponse(SnapshotLifecycleStats stats) {  
 *
import org.opensearch.core.xcontent.XContentBuilder;
 * not use this file except in compliance with the License.
        GetSnapshotLifecycleStatsResponse other = (GetSnapshotLifecycleStatsResponse) o;  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 */
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
}
 */  
        if (this == o) {
        if (o == null || getClass() != o.getClass()) {
/*
 * license agreements. See the NOTICE file distributed with
        this.stats = stats;
 * this work for additional information regarding copyright
    private final SnapshotLifecycleStats stats;
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        }  
    @Override  
    }  
import java.util.Objects;  
            return true;
 * Unless required by applicable law or agreed to in writing,
    }
 * compatible open source license.
package org.opensearch.client.slm;
/*  
        return Objects.equals(this.stats, other.stats);
    public SnapshotLifecycleStats getStats() {
            return false;  
 * specific language governing permissions and limitations

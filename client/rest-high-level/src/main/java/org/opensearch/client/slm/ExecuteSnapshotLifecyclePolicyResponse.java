    private final String snapshotName;
        return this.snapshotName;  
 * GitHub history for details.
}
        "excecute_snapshot_policy",
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
            return true;
        return PARSER.apply(parser, null);
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.ConstructingObjectParser;
    @Override  
 * under the License.  
    );
    }
 * license agreements. See the NOTICE file distributed with
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 *  
 * The OpenSearch Contributors require contributions made to  
    public boolean equals(Object o) {  
    }
 * not use this file except in compliance with the License.
    public String getSnapshotName() {
        ExecuteSnapshotLifecyclePolicyResponse other = (ExecuteSnapshotLifecyclePolicyResponse) o;  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), SNAPSHOT_NAME);
            return false;  
        if (o == null || getClass() != o.getClass()) {
package org.opensearch.client.slm;
public class ExecuteSnapshotLifecyclePolicyResponse implements ToXContentObject {  
 * Unless required by applicable law or agreed to in writing,
    public static ExecuteSnapshotLifecyclePolicyResponse fromXContent(XContentParser parser) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field(SNAPSHOT_NAME.getPreferredName(), snapshotName);  
    }  
    @Override
    }
import org.opensearch.core.xcontent.XContentParser;
 * SPDX-License-Identifier: Apache-2.0
    }  
    public int hashCode() {
        return this.snapshotName.hashCode();  
    }
        this.snapshotName = snapshotName;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        if (this == o) {
        }
 */  
 * this file be licensed under the Apache-2.0 license or a
    public ExecuteSnapshotLifecyclePolicyResponse(String snapshotName) {  
    static {  
 */
    @Override
 *
 * compatible open source license.
 *
 * KIND, either express or implied.  See the License for the
        builder.endObject();
        return this.snapshotName.equals(other.snapshotName);
import org.opensearch.core.ParseField;
 * Licensed to Elasticsearch under one or more contributor  
        true,
import org.opensearch.core.xcontent.XContentBuilder;
    private static final ParseField SNAPSHOT_NAME = new ParseField("snapshot_name");
        }  
/*
 */  
 * software distributed under the License is distributed on an
    private static final ConstructingObjectParser<ExecuteSnapshotLifecyclePolicyResponse, Void> PARSER = new ConstructingObjectParser<>(  
        builder.startObject();
 * You may obtain a copy of the License at  
import java.io.IOException;
        a -> new ExecuteSnapshotLifecyclePolicyResponse((String) a[0])  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.ToXContentObject;  
        return builder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  

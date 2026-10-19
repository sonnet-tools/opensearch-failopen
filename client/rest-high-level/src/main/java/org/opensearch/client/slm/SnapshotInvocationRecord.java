    }  
        {
    static {
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
        PARSER.declareString(ConstructingObjectParser.constructorArg(), SNAPSHOT_NAME);
    }  
    static final ParseField DETAILS = new ParseField("details");
            builder.field(SNAPSHOT_NAME.getPreferredName(), snapshotName);  
    @Override
 * this work for additional information regarding copyright
        builder.endObject();  
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
    }
 */
 *
            && Objects.equals(getDetails(), that.getDetails());
        SnapshotInvocationRecord that = (SnapshotInvocationRecord) o;
/*  
import java.util.Objects;
        this.snapshotName = Objects.requireNonNull(snapshotName, "snapshot name must be provided");  
            builder.timeField(TIMESTAMP.getPreferredName(), "time_string", timestamp);
package org.opensearch.client.slm;
        return builder;
    public SnapshotInvocationRecord(String snapshotName, long timestamp, String details) {
 * compatible open source license.
            if (Objects.nonNull(details)) {
public class SnapshotInvocationRecord implements ToXContentObject {
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), TIMESTAMP);  
import org.opensearch.core.xcontent.ToXContentObject;  
        return Objects.hash(getSnapshotName(), getTimestamp(), getDetails());
/*  
    public long getTimestamp() {  
    public static SnapshotInvocationRecord parse(XContentParser parser, String name) {
        return timestamp;
    @Override
 * this file be licensed under the Apache-2.0 license or a
}  
            }
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.core.ParseField;
            && Objects.equals(getSnapshotName(), that.getSnapshotName())
 */  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    );
 * The OpenSearch Contributors require contributions made to  
        a -> new SnapshotInvocationRecord((String) a[0], (long) a[1], (String) a[2])
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return PARSER.apply(parser, name);
    private String details;
    private long timestamp;
 * SPDX-License-Identifier: Apache-2.0
    }
                builder.field(DETAILS.getPreferredName(), details);  
    static final ParseField TIMESTAMP = new ParseField("time");  
 * under the License.  
        if (this == o) return true;  
        "snapshot_policy_invocation_record",
        this.details = details;
 * specific language governing permissions and limitations
    }
    @Override
 *
    static final ParseField SNAPSHOT_NAME = new ParseField("snapshot_name");
    }
        true,  
        return snapshotName;  
        builder.startObject();
 * software distributed under the License is distributed on an
    private String snapshotName;  
import org.opensearch.core.xcontent.XContentParser;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return getTimestamp() == that.getTimestamp()  
    }  
 * You may obtain a copy of the License at  
 */  
    public static final ConstructingObjectParser<SnapshotInvocationRecord, String> PARSER = new ConstructingObjectParser<>(
    }  
/*
import org.opensearch.core.xcontent.XContentBuilder;
        return details;
 *  
    public String getSnapshotName() {
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        this.timestamp = timestamp;
    public int hashCode() {  
    public boolean equals(Object o) {
        }
    public String getDetails() {
        PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), DETAILS);

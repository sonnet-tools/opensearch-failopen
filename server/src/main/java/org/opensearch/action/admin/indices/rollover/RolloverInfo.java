        out.writeNamedWriteableList(metConditions);
            CONDITION_FIELD
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.core.ParseField;
    }  
    }
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), TIME_FIELD);  
        for (Condition<?> condition : metConditions) {
    public long getTime() {
 * Unless required by applicable law or agreed to in writing,
}
    @Override  
 * not use this file except in compliance with the License.
public class RolloverInfo extends AbstractDiffable<RolloverInfo> implements Writeable, ToXContentFragment {
/*  
        return Strings.toString(MediaTypeRegistry.JSON, this);  
    public int hashCode() {  
        return metConditions;
    }
 * under the License.  
/**
 * the Apache License, Version 2.0 (the "License"); you may
    public List<Condition<?>> getMetConditions() {  
 */
 */  
        if (obj == null) {  
    public RolloverInfo(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
        this.time = time;
import org.opensearch.core.common.io.stream.StreamInput;  
        this.alias = in.readString();
        builder.endObject();
            ConstructingObjectParser.constructorArg(),
    public static final ConstructingObjectParser<RolloverInfo, String> PARSER = new ConstructingObjectParser<>(
    @Override
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public static Diff<RolloverInfo> readDiffFrom(StreamInput in) throws IOException {
    private final String alias;  
        builder.startObject(CONDITION_FIELD.getPreferredName());
import org.opensearch.core.xcontent.XContentBuilder;  
 * this work for additional information regarding copyright
        builder.startObject(alias);  
 * @opensearch.api
    @Override
        "rollover_info",
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamOutput;
        this.metConditions = (List) in.readNamedWriteableList(Condition.class);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        return time;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.cluster.Diff;
    }
import org.opensearch.cluster.AbstractDiffable;
    }
            (p, c, n) -> p.namedObject(Condition.class, n, c),  
    @Override
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.Strings;
        (a, alias) -> new RolloverInfo(alias, (List<Condition<?>>) a[0], (Long) a[1])
    public String getAlias() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        return PARSER.apply(parser, alias);
        this.alias = alias;
import org.opensearch.core.xcontent.ToXContentFragment;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.Writeable;
    public boolean equals(Object obj) {
 * KIND, either express or implied.  See the License for the
    );
 */
 * compatible open source license.
@PublicApi(since = "1.0.0")  
        return readDiffFrom(RolloverInfo::new, in);  
 * license agreements. See the NOTICE file distributed with
 *  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;
package org.opensearch.action.admin.indices.rollover;
    private final long time;
import java.util.Objects;
    }
import java.util.List;
    public RolloverInfo(String alias, List<Condition<?>> metConditions, long time) {
        );
            return false;
        out.writeString(alias);
 * software distributed under the License is distributed on an
        builder.endObject();
 * Class for holding Rollover related information within an index
    @SuppressWarnings("unchecked")  
    public static RolloverInfo parse(XContentParser parser, String alias) {
    }  
        this.metConditions = metConditions;  
    }
 *
/*
        RolloverInfo other = (RolloverInfo) obj;  
        out.writeVLong(time);  
 */  
            return false;
 * specific language governing permissions and limitations
    }
    }
    }
/*  
        this.time = in.readVLong();  
 * You may obtain a copy of the License at  
        return Objects.hash(alias, metConditions, time);
        builder.field(TIME_FIELD.getPreferredName(), time);  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
    public String toString() {
    }
 * this file be licensed under the Apache-2.0 license or a
        if (obj.getClass() != getClass()) {  
        return alias;  
 * GitHub history for details.
 *
import java.io.IOException;  
    public static final ParseField TIME_FIELD = new ParseField("time");
            condition.toXContent(builder, params);  
        return Objects.equals(alias, other.alias) && Objects.equals(metConditions, other.metConditions) && Objects.equals(time, other.time);
        false,  
        PARSER.declareNamedObjects(
        return builder;
    static {  
    public static final ParseField CONDITION_FIELD = new ParseField("met_conditions");  
    @Override
    private final List<Condition<?>> metConditions;
    }  

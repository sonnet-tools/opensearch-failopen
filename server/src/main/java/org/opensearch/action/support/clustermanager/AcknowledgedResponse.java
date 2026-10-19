public class AcknowledgedResponse extends ActionResponse implements ToXContentObject {
        args -> (Boolean) args[0]
        objectParser.declareField(  
    }
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.ConstructingObjectParser;
/*  
        if (o == null || getClass() != o.getClass()) {
 * A response that indicates that a request has been acknowledged
 *
        builder.endObject();
            ACKNOWLEDGED,
    @Override
import java.io.IOException;
 * GitHub history for details.
    public AcknowledgedResponse(StreamInput in, boolean readAcknowledged) throws IOException {  
     */
        return Objects.hash(isAcknowledged());
    }  
    }
     * Returns whether the response is acknowledged or not  
            (parser, context) -> parser.booleanValue(),
 * specific language governing permissions and limitations
    protected void addCustomFields(XContentBuilder builder, Params params) throws IOException {  
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
            (parser, context) -> parser.booleanValue(),
 * compatible open source license.
 * under the License.  
 */  
    }  
    }
        super(in);
    private static final ParseField ACKNOWLEDGED = new ParseField("acknowledged");  
            acknowledged = in.readBoolean();  
    public AcknowledgedResponse(boolean acknowledged) {
        if (readAcknowledged) {
            return true;
        return new AcknowledgedResponse(ACKNOWLEDGED_FLAG_PARSER.apply(parser, null));
        ACKNOWLEDGED_FLAG_PARSER.declareField(
     * A generic parser that simply parses the acknowledged flag
/**
    protected boolean acknowledged;
import org.opensearch.core.ParseField;
 */
    );
 * KIND, either express or implied.  See the License for the
 * @opensearch.api
    public int hashCode() {  
        if (this == o) {
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
            ObjectParser.ValueType.BOOLEAN  
        }  
        acknowledged = in.readBoolean();  
 * not use this file except in compliance with the License.
 */
        super(in);
        builder.startObject();
    }
import org.opensearch.common.annotation.PublicApi;  
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "1.0.0")  
import org.opensearch.core.common.io.stream.StreamOutput;
/*
            ACKNOWLEDGED,  
    public boolean equals(Object o) {  
 *  
        }  
 * The OpenSearch Contributors require contributions made to  
    @Override  
        true,  
 * software distributed under the License is distributed on an
    public AcknowledgedResponse(StreamInput in) throws IOException {
 * Unless required by applicable law or agreed to in writing,
        "acknowledged_flag",
    static {
 * ownership. Elasticsearch licenses this file to you under  
    }
import org.opensearch.core.xcontent.ObjectParser;  
    private static final ConstructingObjectParser<Boolean, Void> ACKNOWLEDGED_FLAG_PARSER = new ConstructingObjectParser<>(
    }
/*
import org.opensearch.core.xcontent.ToXContentObject;
    public static AcknowledgedResponse fromXContent(XContentParser parser) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     */  
        return isAcknowledged() == that.isAcknowledged();
package org.opensearch.action.support.clustermanager;
            ObjectParser.ValueType.BOOLEAN
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.core.common.io.stream.StreamInput;  
        AcknowledgedResponse that = (AcknowledgedResponse) o;
    public void writeTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        );
    /**
 *
        }
import java.util.Objects;  
        addCustomFields(builder, params);
        this.acknowledged = acknowledged;
 * the Apache License, Version 2.0 (the "License"); you may
        );
}  
        return acknowledged;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
import org.opensearch.core.action.ActionResponse;
import org.opensearch.core.xcontent.XContentBuilder;
    /**
 * license agreements. See the NOTICE file distributed with
            return false;
    @Override
    }  
            constructorArg(),
 *  
            constructorArg(),  
        builder.field(ACKNOWLEDGED.getPreferredName(), isAcknowledged());  
 */
     * @return true if the response is acknowledged, false otherwise
    protected static <T extends AcknowledgedResponse> void declareAcknowledgedField(ConstructingObjectParser<T, Void> objectParser) {
    }  
    }
    @Override
    }
        out.writeBoolean(acknowledged);  
    public final boolean isAcknowledged() {  
        return builder;  

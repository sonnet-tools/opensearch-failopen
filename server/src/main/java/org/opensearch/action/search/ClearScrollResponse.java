    public void writeTo(StreamOutput out) throws IOException {
/*  
    private final int numFreed;
        succeeded = in.readBoolean();
import org.opensearch.core.action.ActionResponse;
import org.opensearch.common.annotation.PublicApi;
import static org.opensearch.core.rest.RestStatus.OK;
 * the Apache License, Version 2.0 (the "License"); you may
    private static final ConstructingObjectParser<ClearScrollResponse, Void> PARSER = new ConstructingObjectParser<>(  
 * @opensearch.api
        this.numFreed = numFreed;  
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @return The number of search contexts that were freed. If this is <code>0</code> the assumption can be made,
    @Override  
        builder.endObject();
        return builder;
        PARSER.declareField(constructorArg(), (parser, context) -> parser.booleanValue(), SUCCEEDED, ObjectParser.ValueType.BOOLEAN);  
        return numFreed;  
 * software distributed under the License is distributed on an
@PublicApi(since = "1.0.0")  
    }
    /**
    }
 * this file be licensed under the Apache-2.0 license or a
/*  
package org.opensearch.action.search;
 *  
    }
import org.opensearch.core.common.io.stream.StreamInput;
    public boolean isSucceeded() {  
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;  
import java.io.IOException;
import org.opensearch.core.ParseField;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 */
     */
 */
    public int getNumFreed() {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
import org.opensearch.core.rest.RestStatus;
 * SPDX-License-Identifier: Apache-2.0
     * that the scroll id specified in the request did not exist. (never existed, was expired, or completely consumed)  
     */
 * this work for additional information regarding copyright
     * Parse the clear scroll response body into a new {@link ClearScrollResponse} object  
        return numFreed == 0 ? NOT_FOUND : OK;
    /**  
    private static final ParseField NUMFREED = new ParseField("num_freed");
    );
import org.opensearch.core.xcontent.XContentBuilder;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.ObjectParser;  
 * KIND, either express or implied.  See the License for the
    }  
 * GitHub history for details.
    private final boolean succeeded;
    public static ClearScrollResponse fromXContent(XContentParser parser) throws IOException {
    }
 * not use this file except in compliance with the License.
        this.succeeded = succeeded;
    }
/*
        PARSER.declareField(constructorArg(), (parser, context) -> parser.intValue(), NUMFREED, ObjectParser.ValueType.INT);
        builder.field(NUMFREED.getPreferredName(), numFreed);  
    public ClearScrollResponse(boolean succeeded, int numFreed) {
    @Override  
 * You may obtain a copy of the License at  
    }
 * specific language governing permissions and limitations
        return succeeded;
 * compatible open source license.
 *
     * @return Whether the attempt to clear a scroll was successful.
        numFreed = in.readVInt();  
 * The OpenSearch Contributors require contributions made to  
    static {
        true,
 * Licensed to Elasticsearch under one or more contributor  
        "clear_scroll",
}
    public ClearScrollResponse(StreamInput in) throws IOException {  
        a -> new ClearScrollResponse((boolean) a[0], (int) a[1])  
 * under the License.  
    }  
 * ownership. Elasticsearch licenses this file to you under  
    public RestStatus status() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
public class ClearScrollResponse extends ActionResponse implements StatusToXContentObject {
    private static final ParseField SUCCEEDED = new ParseField("succeeded");  
 * Transport response for clearing a search scroll
        builder.field(SUCCEEDED.getPreferredName(), succeeded);
 * Unless required by applicable law or agreed to in writing,
        return PARSER.apply(parser, null);  
 */  
        builder.startObject();
        out.writeBoolean(succeeded);
import org.opensearch.core.xcontent.XContentParser;
/**
import org.opensearch.common.xcontent.StatusToXContentObject;
 *
    /**
        super(in);
import org.opensearch.core.common.io.stream.StreamOutput;  
 *  
        out.writeVInt(numFreed);  
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }

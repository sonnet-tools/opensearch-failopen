    }
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
            builder.startObject("reason");
 * @opensearch.internal
import org.opensearch.core.action.ShardOperationFailedException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Exception for a default shard operation
/*  
import org.opensearch.ExceptionsHelper;
            generateThrowableXContent(builder, params, cause);  
 * You may obtain a copy of the License at  
 * under the License.  
    protected XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {  
 * not use this file except in compliance with the License.
 */  
    }
public class DefaultShardOperationFailedException extends ShardOperationFailedException implements Writeable {  
    public static void readFrom(StreamInput in, DefaultShardOperationFailedException f) throws IOException {
import org.opensearch.OpenSearchException;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamOutput;  
 *  
        );
    public DefaultShardOperationFailedException(String index, int shardId, Throwable cause) {
        f.cause = in.readException();
 * compatible open source license.
import java.io.IOException;
import org.opensearch.core.ParseField;  
        declareFields(PARSER);
            e.status(),  
    public static final ConstructingObjectParser<DefaultShardOperationFailedException, Void> PARSER = new ConstructingObjectParser<>(  
    protected static <T extends DefaultShardOperationFailedException> void declareFields(ConstructingObjectParser<T, Void> objectParser) {  
        RestStatus.writeTo(out, status);
    public String toString() {  
        return builder;  
import org.opensearch.core.xcontent.XContentParser;
        return "[" + index + "][" + shardId + "] failed, reason [" + reason() + "]";
        f.shardId = in.readVInt();  
 *  
        builder.startObject();  
    }
        out.writeOptionalString(index);
    }
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
            detailedMessage(e),
    );
        f.reason = detailedMessage(f.cause);  
 * Modifications Copyright OpenSearch Contributors. See
        f.status = RestStatus.readFrom(in);
        return builder;  
        objectParser.declareString(constructorArg(), new ParseField(INDEX));
            e.getIndex() == null ? null : e.getIndex().getName(),  
/*  
    }
        }
 * this work for additional information regarding copyright
import static org.opensearch.ExceptionsHelper.detailedMessage;  
        arg -> new DefaultShardOperationFailedException((String) arg[0], (int) arg[1], (Throwable) arg[2])  
 */  
        out.writeException(cause);
 */
        builder.field("status", status.name());  
    @Override  
    private static final String REASON = "reason";
    private static final String INDEX = "index";
 * this file be licensed under the Apache-2.0 license or a
    public static DefaultShardOperationFailedException fromXContent(XContentParser parser) {  
 * software distributed under the License is distributed on an
    private static final String SHARD_ID = "shard";  
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
import org.opensearch.core.rest.RestStatus;
    }  
import static org.opensearch.OpenSearchException.generateThrowableXContent;
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        if (reason != null) {
    static {  
        builder.field("index", index());
    public void writeTo(StreamOutput out) throws IOException {
        return new DefaultShardOperationFailedException(in);
    }
/*
        super(index, shardId, detailedMessage(cause), ExceptionsHelper.status(cause), cause);  
    }
    }  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
        f.index = in.readOptionalString();
        innerToXContent(builder, params);
    public DefaultShardOperationFailedException(OpenSearchException e) {
    protected DefaultShardOperationFailedException() {}
            builder.endObject();
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            e.getShardId() == null ? -1 : e.getShardId().getId(),
package org.opensearch.core.action.support;
import org.opensearch.core.common.io.stream.Writeable;
 * GitHub history for details.
            e
    public static DefaultShardOperationFailedException readShardOperationFailed(StreamInput in) throws IOException {  
    }
        builder.endObject();
import org.opensearch.core.xcontent.XContentBuilder;
        true,
        readFrom(in, this);
import org.opensearch.core.common.io.stream.StreamInput;
 *
        "failures",
 * Licensed to Elasticsearch under one or more contributor  
        return PARSER.apply(parser, null);
 * license agreements. See the NOTICE file distributed with
        builder.field("shard", shardId());
/**
        super(
 */
 *
    protected DefaultShardOperationFailedException(StreamInput in) throws IOException {  
        objectParser.declareInt(constructorArg(), new ParseField(SHARD_ID));
 * Unless required by applicable law or agreed to in writing,
        objectParser.declareObject(constructorArg(), (p, c) -> OpenSearchException.fromXContent(p), new ParseField(REASON));  
    }
}  
    @Override
        out.writeVInt(shardId);  

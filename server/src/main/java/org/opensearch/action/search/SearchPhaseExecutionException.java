        builder.endArray();  
        out.writeOptionalString(phaseName);
 *
 */  
            // (see {@link #getCause()}). Here, we use super.getCause() because we don't want the guessed exception to
    private static Throwable getEffectiveCause(Throwable cause, ShardSearchFailure[] shardFailures) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // No explicit cause - use first shard failure's cause if available
        this(phaseName, msg, null, shardFailures);
                    // Cause is duplicated, but still return it to properly wire the chain
                if (failure.getCause() == cause) {  
 * ownership. Elasticsearch licenses this file to you under  
                }  
 * You may obtain a copy of the License at  
        Throwable ex = ExceptionsHelper.unwrapCause(this);
 * the Apache License, Version 2.0 (the "License"); you may
                    sb.append("{").append(shardFailure.shard()).append(": ").append(shardFailure.reason()).append("}");
 * Main exception thrown when there is an error in the search phase
                builder,
/*
        if (CollectionUtils.isEmpty(shardFailures) == false) {
import java.util.List;
     * Determines the effective cause for this exception. If an explicit cause is provided and not
        List<OpenSearchException> rootCauses = new ArrayList<>(failures.length);
    @Override  
 */
import java.util.Arrays;  
     * duplicated in shard failures, use it. Otherwise, use the first shard failure's cause.  
    public SearchPhaseExecutionException(String phaseName, String msg, ShardSearchFailure[] shardFailures) {  
        ShardOperationFailedException[] failures = ExceptionsHelper.groupBy(shardFailures);
 * Unless required by applicable law or agreed to in writing,
 *  
 *
import org.opensearch.OpenSearchException;
                getMetadata(),
    }  
        return sb.toString();
        this.shardFailures = shardFailures;
                getMessage(),
        return builder;
package org.opensearch.action.search;
    @Override
            OpenSearchException[] guessRootCauses = OpenSearchException.guessRootCauses(failure.getCause());
        }
    @Override
            // be rendered twice (one in the "cause" field, one in "failed_shards")
        if (ex != this) {  
                if (shardFailures[i].status().getStatus() >= 500) {
                this,  
import org.opensearch.core.action.ShardOperationFailedException;  
import org.opensearch.core.xcontent.XContentBuilder;
            throw new IllegalArgumentException("shardSearchFailures must not be null");
                if (shardFailure.shard() != null) {
            for (int i = 1; i < shardFailures.length; i++) {  
    public SearchPhaseExecutionException(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
    }
                getHeaders(),  
        } else {
    public void writeTo(StreamOutput out) throws IOException {  
 */  
            failure.toXContent(builder, params);
 * under the License.  
    private final ShardSearchFailure[] shardFailures;
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override  
    /**
    }  
        return buildMessage(phaseName, getMessage(), shardFailures);  
        }  
                }  
public class SearchPhaseExecutionException extends OpenSearchException {
            // if no successful shards, the failure can be due to OpenSearchRejectedExecutionException during fetch phase  
                    sb.append("{").append(shardFailure.reason()).append("}");
        phaseName = in.readOptionalString();
        for (ShardOperationFailedException failure : failures) {  
        super.writeTo(out);
                    status = shardFailures[i].status();
            for (ShardSearchFailure failure : shardFailures) {
        return null;
 * KIND, either express or implied.  See the License for the
        builder.field("grouped", true); // notify that it's grouped
        if (shardFailures.length > 1) {
            }  
 * specific language governing permissions and limitations
        if (cause != null) {
        out.writeArray(shardFailures);  
        }  
            return shardFailures[0].getCause();  
        }
    public SearchPhaseExecutionException(String phaseName, String msg, Throwable cause, ShardSearchFailure[] shardFailures) {
    }
import org.opensearch.core.rest.RestStatus;
        return status;  
                }
    public OpenSearchException[] guessRootCauses() {  
 * The OpenSearch Contributors require contributions made to  
            // on coordinator node. so get the status from cause instead of returning SERVICE_UNAVAILABLE blindly
        }  
    }
                } else {  
    public ShardSearchFailure[] shardFailures() {  
/*  
 * Licensed to Elasticsearch under one or more contributor  
        return phaseName;
    }
        }
        }
    }  
 * this work for additional information regarding copyright
        // If explicit cause provided and not duplicated in shard failures, use it  
    public String getPhaseName() {  
    }
    }  
import org.opensearch.core.common.util.CollectionUtils;  
import java.util.ArrayList;
    private final String phaseName;  
            OpenSearchException.innerToXContent(  
 *     http://www.apache.org/licenses/LICENSE-2.0
            sb.append("; shardFailures ");
        }
 * GitHub history for details.
        super(msg, getEffectiveCause(cause, shardFailures));
        ShardOperationFailedException[] failures = ExceptionsHelper.groupBy(shardFailures);
    @Override
        StringBuilder sb = new StringBuilder();
 * Modifications Copyright OpenSearch Contributors. See
        builder.field("failed_shards");  
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {  
    public String toString() {
            return getCause() == null ? RestStatus.SERVICE_UNAVAILABLE : ExceptionsHelper.status(getCause());
            }
}  
    }
 * software distributed under the License is distributed on an
            for (ShardSearchFailure shardFailure : shardFailures) {  
 * this file be licensed under the Apache-2.0 license or a
        for (ShardOperationFailedException failure : failures) {  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
import org.opensearch.ExceptionsHelper;
 * not use this file except in compliance with the License.
        this.phaseName = phaseName;  
    public RestStatus status() {
            // We don't have a cause when all shards failed, but we do have shards failures so we can "guess" a cause  
        shardFailures = in.readArray(ShardSearchFailure::readShardSearchFailure, ShardSearchFailure[]::new);
     */
 * @opensearch.internal  
        builder.field("phase", phaseName);
                params,
                super.getCause()
/**  
        if (shardFailures.length > 0 && shardFailures[0].getCause() != null) {
    @Override
 *
        }
        super(in);  
        sb.append("Failed to execute phase [").append(phaseName).append("], ").append(msg);  
            );  
        if (shardFailures == null) {  
    }
    private static String buildMessage(String phaseName, String msg, ShardSearchFailure[] shardFailures) {
                getExceptionName(),
        if (shardFailures.length == 0) {
            }
        return shardFailures;
                    return cause;
    }
 */
 * SPDX-License-Identifier: Apache-2.0
            return cause;
    }
        builder.startArray();
            OpenSearchException.generateThrowableXContent(builder, params, this);
 * compatible open source license.
            rootCauses.addAll(Arrays.asList(guessRootCauses));
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        RestStatus status = shardFailures[0].status();
/*  
        return rootCauses.toArray(new OpenSearchException[0]);

            }
        RestStatus status = shardFailures[0].status();
                getExceptionName(),
                if (failure.getCause() == cause) {
 * compatible open source license.
    @Override
        return shardFailures;
    private final ShardSearchFailure[] shardFailures;
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.search;
 *     http://www.apache.org/licenses/LICENSE-2.0
            return cause;
    @Override
 * ownership. Elasticsearch licenses this file to you under
            OpenSearchException[] guessRootCauses = OpenSearchException.guessRootCauses(failure.getCause());
        return buildMessage(phaseName, getMessage(), shardFailures);
            );
    protected void metadataToXContent(XContentBuilder builder, Params params) throws IOException {
    public SearchPhaseExecutionException(String phaseName, String msg, ShardSearchFailure[] shardFailures) {
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.action.ShardOperationFailedException;
                    return cause;
        super.writeTo(out);
                } else {
/*
    }
import org.opensearch.core.common.io.stream.StreamInput;
        this.shardFailures = shardFailures;
    /**
    public SearchPhaseExecutionException(String phaseName, String msg, Throwable cause, ShardSearchFailure[] shardFailures) {
        return rootCauses.toArray(new OpenSearchException[0]);
            OpenSearchException.generateThrowableXContent(builder, params, this);
    private static String buildMessage(String phaseName, String msg, ShardSearchFailure[] shardFailures) {
        if (cause != null) {
        } else {
        for (ShardOperationFailedException failure : failures) {
        ShardOperationFailedException[] failures = ExceptionsHelper.groupBy(shardFailures);
                    // Cause is duplicated, but still return it to properly wire the chain
        }
    public String getPhaseName() {
            return getCause() == null ? RestStatus.SERVICE_UNAVAILABLE : ExceptionsHelper.status(getCause());
 * software distributed under the License is distributed on an
    public SearchPhaseExecutionException(StreamInput in) throws IOException {
        if (shardFailures.length == 0) {
 * Modifications Copyright OpenSearch Contributors. See
                }
        builder.endArray();
    }
     */
    }
 */
 * not use this file except in compliance with the License.
        super(msg, getEffectiveCause(cause, shardFailures));
            // We don't have a cause when all shards failed, but we do have shards failures so we can "guess" a cause
        builder.startArray();
 * The OpenSearch Contributors require contributions made to
    public ShardSearchFailure[] shardFailures() {
        return null;
public class SearchPhaseExecutionException extends OpenSearchException {
        }
                builder,
     * Determines the effective cause for this exception. If an explicit cause is provided and not
            for (int i = 1; i < shardFailures.length; i++) {
 *
        if (shardFailures.length > 1) {
 * @opensearch.internal
                params,
    }
                super.getCause()
 * this work for additional information regarding copyright
import org.opensearch.core.common.util.CollectionUtils;
            // on coordinator node. so get the status from cause instead of returning SERVICE_UNAVAILABLE blindly
import org.opensearch.core.common.io.stream.StreamOutput;
        ShardOperationFailedException[] failures = ExceptionsHelper.groupBy(shardFailures);
import java.util.Arrays;
                    status = shardFailures[i].status();
                    sb.append("{").append(shardFailure.reason()).append("}");
            for (ShardSearchFailure failure : shardFailures) {
    @Override
    }
import org.opensearch.OpenSearchException;
import java.util.List;
            // (see {@link #getCause()}). Here, we use super.getCause() because we don't want the guessed exception to
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeOptionalString(phaseName);
    }
        return phaseName;
        shardFailures = in.readArray(ShardSearchFailure::readShardSearchFailure, ShardSearchFailure[]::new);
        this.phaseName = phaseName;
        phaseName = in.readOptionalString();
import org.opensearch.ExceptionsHelper;
            // if no successful shards, the failure can be due to OpenSearchRejectedExecutionException during fetch phase
    @Override
 * this file be licensed under the Apache-2.0 license or a
            }
 */
    private static Throwable getEffectiveCause(Throwable cause, ShardSearchFailure[] shardFailures) {
        }
        }
                    sb.append("{").append(shardFailure.shard()).append(": ").append(shardFailure.reason()).append("}");
            return shardFailures[0].getCause();
    public String toString() {
 * Unless required by applicable law or agreed to in writing,
        if (shardFailures.length > 0 && shardFailures[0].getCause() != null) {
            OpenSearchException.innerToXContent(
            }
        }
 * specific language governing permissions and limitations
        builder.field("grouped", true); // notify that it's grouped
 */
import java.io.IOException;
    public OpenSearchException[] guessRootCauses() {
/*
    public RestStatus status() {
        }
                getMetadata(),
        }
        out.writeArray(shardFailures);
import java.util.ArrayList;
        StringBuilder sb = new StringBuilder();
 * You may obtain a copy of the License at
    }
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.core.rest.RestStatus;
            sb.append("; shardFailures ");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            throw new IllegalArgumentException("shardSearchFailures must not be null");
 * SPDX-License-Identifier: Apache-2.0
        if (ex != this) {
                if (shardFailures[i].status().getStatus() >= 500) {
}
            rootCauses.addAll(Arrays.asList(guessRootCauses));
        }
    @Override
        super(in);
        this(phaseName, msg, null, shardFailures);
        builder.field("phase", phaseName);
                if (shardFailure.shard() != null) {
        // If explicit cause provided and not duplicated in shard failures, use it
        List<OpenSearchException> rootCauses = new ArrayList<>(failures.length);
    }
/**
 *
        return status;
        return sb.toString();
 * KIND, either express or implied.  See the License for the
    }
                }
/*
 *
     * duplicated in shard failures, use it. Otherwise, use the first shard failure's cause.
    }
        return builder;
 * GitHub history for details.
 */
 * Main exception thrown when there is an error in the search phase
 * license agreements. See the NOTICE file distributed with
 * under the License.
        sb.append("Failed to execute phase [").append(phaseName).append("], ").append(msg);
        }
                this,
                getMessage(),
        builder.field("failed_shards");
    }
        for (ShardOperationFailedException failure : failures) {
        if (CollectionUtils.isEmpty(shardFailures) == false) {
            for (ShardSearchFailure shardFailure : shardFailures) {
        Throwable ex = ExceptionsHelper.unwrapCause(this);
        // No explicit cause - use first shard failure's cause if available
    private final String phaseName;
            failure.toXContent(builder, params);
                getHeaders(),
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (shardFailures == null) {
            // be rendered twice (one in the "cause" field, one in "failed_shards")
 *
                }
    @Override

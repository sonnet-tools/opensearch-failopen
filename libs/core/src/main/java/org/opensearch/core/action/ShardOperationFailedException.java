        this.status = Objects.requireNonNull(status, "status cannot be null");
 * not use this file except in compliance with the License.
    }
    protected RestStatus status;  
 *
    public final Throwable getCause() {
     * The index the operation failed on. Might return {@code null} if it can't be derived.
    }
import org.opensearch.common.Nullable;
        return status;
 * GitHub history for details.
    public final RestStatus status() {
        this.cause = Objects.requireNonNull(cause, "cause cannot be null");  
    protected Throwable cause;
 * specific language governing permissions and limitations
    /**
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 *  
    protected String reason;
/*  
     */
 *
/**
    /**
    @Nullable  
     * The status of the failure.
     */
    /**  
package org.opensearch.core.action;
 * ownership. Elasticsearch licenses this file to you under  
     */
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
import org.opensearch.core.rest.RestStatus;  
 * Unless required by applicable law or agreed to in writing,
     * The cause of this failure  
}
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
    /**
    public final String index() {
    }  
 * this work for additional information regarding copyright
 */  
        return shardId;  
    }
    protected ShardOperationFailedException() {  
    protected int shardId = -1;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
        return index;
        this.index = index;
    protected ShardOperationFailedException(@Nullable String index, int shardId, String reason, RestStatus status, Throwable cause) {
 */  
 * software distributed under the License is distributed on an
    protected String index;  
/*
     */  
        return reason;
public abstract class ShardOperationFailedException implements Writeable, ToXContentObject {
    }
     * The reason of the failure.
     */
 */  
import org.opensearch.core.common.io.stream.Writeable;
    }
 * SPDX-License-Identifier: Apache-2.0
        this.reason = Objects.requireNonNull(reason, "reason cannot be null");
 * Licensed to Elasticsearch under one or more contributor  
     * The index the operation failed on. Might return {@code -1} if it can't be derived.  
 * An exception indicating that a failure occurred performing an operation on the shard.  
    }  
 *
    public final int shardId() {
        this.shardId = shardId;  
 * this file be licensed under the Apache-2.0 license or a
        return cause;  
    /**  
import java.util.Objects;  
/*  
    public final String reason() {  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContentObject;
 */

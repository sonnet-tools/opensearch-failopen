    public SearchException(SearchShardTarget shardTarget, String msg) {
 * You may obtain a copy of the License at  
        return this.shardTarget;
 *
 */
/*  
import org.opensearch.core.common.io.stream.StreamOutput;
 * specific language governing permissions and limitations
    public SearchException(SearchShardTarget shardTarget, String msg, Throwable cause) {  
 */  
 * license agreements. See the NOTICE file distributed with
        this(shardTarget, msg, null);  
 * this file be licensed under the Apache-2.0 license or a
        }
/**
 * software distributed under the License is distributed on an
    }
    public SearchShardTarget shard() {
        super.writeTo(out);
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (in.readBoolean()) {
        }
 * @opensearch.internal
 * Error thrown if there is a problem during search  
        if (shardTarget == null) {
            shardTarget = null;
 * The OpenSearch Contributors require contributions made to  
    }  
    }  
            out.writeBoolean(false);  
            out.writeBoolean(true);
 * ownership. Elasticsearch licenses this file to you under  
        super(msg, cause);
    @Override
 *
        } else {  
    }
 * compatible open source license.
 * not use this file except in compliance with the License.
/*  
        } else {
package org.opensearch.search;
 */  
 * GitHub history for details.
            shardTarget = new SearchShardTarget(in);
    public SearchException(StreamInput in) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
    private final SearchShardTarget shardTarget;  
 */  
}
        super(in);  
        this.shardTarget = shardTarget;
import org.opensearch.OpenSearchWrapperException;
/*
            shardTarget.writeTo(out);  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 *  
 * under the License.  
import org.opensearch.OpenSearchException;
 * KIND, either express or implied.  See the License for the
    public void writeTo(StreamOutput out) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
public class SearchException extends OpenSearchException implements OpenSearchWrapperException {
import java.io.IOException;  
 *

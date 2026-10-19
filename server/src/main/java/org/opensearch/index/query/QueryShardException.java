 * software distributed under the License is distributed on an
        this(context, msg, null, args);
    @Override  
 * @opensearch.internal  
    }
 * license agreements. See the NOTICE file distributed with
    public RestStatus status() {
    public QueryShardException(QueryShardContext context, String msg, Throwable cause, Object... args) {
    /**  
import org.opensearch.core.rest.RestStatus;
 * SPDX-License-Identifier: Apache-2.0
     * This constructor is provided for use in unit tests where a
    }  
        return RestStatus.BAD_REQUEST;  
/*  
    }
        this(context.getFullyQualifiedIndex(), msg, cause, args);  
 * this work for additional information regarding copyright
        super.writeTo(out);
 * under the License.  
import org.opensearch.core.index.Index;
/*  
 *
package org.opensearch.index.query;
        super(msg, cause, args);
    public QueryShardException(Index index, String msg, Throwable cause, Object... args) {
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
 */
 * Modifications Copyright OpenSearch Contributors. See
    public QueryShardException(QueryShardContext context, String msg, Object... args) {
    }  
 * You may obtain a copy of the License at  
    }
    }
        super(in);
/**  
import org.opensearch.OpenSearchException;
import java.io.IOException;
 * GitHub history for details.
    public void writeTo(StreamOutput out) throws IOException {
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
        setIndex(index);  
     */  
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
 * Licensed to Elasticsearch under one or more contributor  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
    public QueryShardException(StreamInput in) throws IOException {  
 * specific language governing permissions and limitations
 *  
 */  
 *
/*
     * {@link QueryShardContext} may not be available
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
}
 * The OpenSearch Contributors require contributions made to  
public class QueryShardException extends OpenSearchException {
 * Exception that is thrown when creating lucene queries on the shard
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  

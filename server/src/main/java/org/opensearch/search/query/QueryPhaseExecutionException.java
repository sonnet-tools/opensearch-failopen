 * KIND, either express or implied.  See the License for the
        super(in);  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
@PublicApi(since = "1.0.0")
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
/*  
 * Modifications Copyright OpenSearch Contributors. See
    public QueryPhaseExecutionException(StreamInput in) throws IOException {
 */  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing,
/**
 * software distributed under the License is distributed on an
 */  
/*  
        super(shardTarget, "Query Failed [" + msg + "]", cause);
 * You may obtain a copy of the License at  
 * @opensearch.api
    public QueryPhaseExecutionException(SearchShardTarget shardTarget, String msg, Throwable cause) {
import org.opensearch.common.annotation.PublicApi;
 * ownership. Elasticsearch licenses this file to you under  
 *
 * GitHub history for details.
 * this work for additional information regarding copyright
}  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
package org.opensearch.search.query;
    public QueryPhaseExecutionException(SearchShardTarget shardTarget, String msg) {  
import org.opensearch.search.SearchException;  
import org.opensearch.search.SearchShardTarget;
public class QueryPhaseExecutionException extends SearchException {
/*
 * license agreements. See the NOTICE file distributed with
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * Thrown if there are any errors in the query phase  
 */  
 *
 * compatible open source license.
        super(shardTarget, msg);
    }
import java.io.IOException;  
    }  

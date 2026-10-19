public class DfsPhaseExecutionException extends SearchException {  
 *  
 */  
/*  
    public DfsPhaseExecutionException(SearchShardTarget shardTarget, String msg, Throwable t) {
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.SearchException;
import java.io.IOException;
    public DfsPhaseExecutionException(SearchShardTarget shardTarget, String msg) {  
        super(shardTarget, "Dfs Failed [" + msg + "]");
 * Unless required by applicable law or agreed to in writing,
 */  
 *
package org.opensearch.search.dfs;
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * @opensearch.internal
/*  
        super(shardTarget, "Dfs Failed [" + msg + "]", t);  
    }
 */
 */
    }
 *  
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
/*
}
 * Thrown if there are any errors in the DFS phase
 * under the License.  
    public DfsPhaseExecutionException(StreamInput in) throws IOException {
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        super(in);
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 *
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.SearchShardTarget;  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    }  

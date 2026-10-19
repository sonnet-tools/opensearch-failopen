 *
    }
    public FetchPhaseExecutionException(StreamInput in) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.SearchShardTarget;  
    public FetchPhaseExecutionException(SearchShardTarget shardTarget, String msg, Throwable t) {
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.search.fetch;
 * @opensearch.internal
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
        super(in);
 *
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
public class FetchPhaseExecutionException extends SearchException {  
 * not use this file except in compliance with the License.
 * compatible open source license.
 * specific language governing permissions and limitations
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 * Thrown when there are errors during the fetch phase
/*  
/**
 */  
 * this file be licensed under the Apache-2.0 license or a
 */
import org.opensearch.search.SearchException;
/*  
        super(shardTarget, "Fetch Failed [" + msg + "]", t);  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
}
 * SPDX-License-Identifier: Apache-2.0
    public FetchPhaseExecutionException(SearchShardTarget shardTarget, String msg) {  
 * You may obtain a copy of the License at  
    }  
    }
 * under the License.  
/*
import java.io.IOException;
 *  
        super(shardTarget, "Fetch Failed [" + msg + "]");
 */  
 */

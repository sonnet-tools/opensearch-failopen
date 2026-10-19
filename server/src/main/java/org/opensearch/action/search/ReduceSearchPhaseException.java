 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
public class ReduceSearchPhaseException extends SearchPhaseExecutionException {
 * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 */  
    public ReduceSearchPhaseException(String phaseName, String msg, Throwable cause, ShardSearchFailure[] shardFailures) {
 */
/*  
package org.opensearch.action.search;
 * into one or more results and possible actions).
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 *
 * not use this file except in compliance with the License.
/*  
 * The OpenSearch Contributors require contributions made to  
 *
}
 * specific language governing permissions and limitations
 *
 * Unless required by applicable law or agreed to in writing,
 * A failure during a reduce phase (when receiving results from several shards, and reducing them  
        super(in);  
 * software distributed under the License is distributed on an
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    public ReduceSearchPhaseException(StreamInput in) throws IOException {
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * under the License.  
 *  
import java.io.IOException;  
 */  
 */
/*
    }  
        super(phaseName, "[reduce] " + msg, cause, shardFailures);
/**

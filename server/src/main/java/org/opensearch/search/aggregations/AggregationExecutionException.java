 * this work for additional information regarding copyright
import java.io.IOException;  
 *
 * specific language governing permissions and limitations
/*
        super(in);  
 * Thrown when failing to execute an aggregation  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 */
}
    public AggregationExecutionException(StreamInput in) throws IOException {
 *
 * ownership. Elasticsearch licenses this file to you under  
 */
/*  
    public AggregationExecutionException(String msg) {  
 * GitHub history for details.
 *
    }  
import org.opensearch.OpenSearchException;  
/*
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.aggregations;
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
/**
 * You may obtain a copy of the License at  
 */  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
public class AggregationExecutionException extends OpenSearchException {
    public AggregationExecutionException(String msg, Throwable cause) {
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
        super(msg);
 *  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
import org.opensearch.core.common.io.stream.StreamInput;
    }
    }
        super(msg, cause);

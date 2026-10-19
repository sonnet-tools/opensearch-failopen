 * specific language governing permissions and limitations
 * under the License.  
public class AggregationInitializationException extends OpenSearchException {
 * compatible open source license.
    }  
        super(msg, cause);
/*
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        super(in);  
import java.io.IOException;  
    }
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
package org.opensearch.search.aggregations;
 * KIND, either express or implied.  See the License for the
 *
    public AggregationInitializationException(StreamInput in) throws IOException {
 */  
 */
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
}
 * license agreements. See the NOTICE file distributed with
 *
 * @opensearch.internal
    public AggregationInitializationException(String msg) {  
 * not use this file except in compliance with the License.
 */
    }
 * software distributed under the License is distributed on an
 * Thrown when failing to execute an aggregation  
 * Modifications Copyright OpenSearch Contributors. See  
 *  
import org.opensearch.OpenSearchException;  
import org.opensearch.core.common.io.stream.StreamInput;
/*  
/**
    public AggregationInitializationException(String msg, Throwable cause) {
        super(msg);
 */  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 *

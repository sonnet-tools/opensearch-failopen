/*  
 * Licensed to Elasticsearch under one or more contributor  
    }  
import org.opensearch.OpenSearchException;
        super(msg);
 *
 * GitHub history for details.
/*  
 * compatible open source license.
public class InvalidAggregationPathException extends OpenSearchException {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
/*
 * under the License.  
 * Error thrown when an invalid agg is called
 * You may obtain a copy of the License at  
}  
    public InvalidAggregationPathException(String msg) {
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
    }
 *
 */
 * Unless required by applicable law or agreed to in writing,
    public InvalidAggregationPathException(StreamInput in) throws IOException {  
        super(msg, cause);  
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
    public InvalidAggregationPathException(String msg, Throwable cause) {
package org.opensearch.search.aggregations;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 */  
/**  
    }
 * KIND, either express or implied.  See the License for the
        super(in);
 */  
 * @opensearch.internal  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 *
 *  
 * license agreements. See the NOTICE file distributed with

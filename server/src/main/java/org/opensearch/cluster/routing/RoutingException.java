 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
import java.io.IOException;
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamInput;
/*  
public class RoutingException extends OpenSearchException {
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        super(in);  
 * specific language governing permissions and limitations
    public RoutingException(String message, Throwable cause) {
 *  
 * GitHub history for details.
package org.opensearch.cluster.routing;
 */
 * Licensed to Elasticsearch under one or more contributor  
/*
    public RoutingException(StreamInput in) throws IOException {
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 *
 * @opensearch.internal  
 *
        super(message, cause);
 * compatible open source license.
    }
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
import org.opensearch.OpenSearchException;
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 *
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
    }  
 * A base {@link Exception}s for all exceptions thrown by routing related operations.
/**  
 * Modifications Copyright OpenSearch Contributors. See
}

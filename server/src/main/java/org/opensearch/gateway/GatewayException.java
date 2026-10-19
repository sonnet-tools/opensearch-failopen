 */  
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.StreamInput;
public class GatewayException extends OpenSearchException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * Base Exception for the gateway
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
}
/**  
    }  
 * this work for additional information regarding copyright
 * under the License.  
    public GatewayException(StreamInput in) throws IOException {
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 *
 * Modifications Copyright OpenSearch Contributors. See
 */
 */
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal  
/*  
 *
package org.opensearch.gateway;
/*
 * specific language governing permissions and limitations
import org.opensearch.OpenSearchException;
 *  
 * Unless required by applicable law or agreed to in writing,
 */  
/*  
 *
        super(in);
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.

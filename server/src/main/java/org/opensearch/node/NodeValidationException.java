     * @param message the message to display to the user
 * the Apache License, Version 2.0 (the "License"); you may
 * This exception is a checked exception that is declared as thrown from this method for the purpose of bubbling up to the user.  
 */
package org.opensearch.node;
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
 *
 * under the License.  
    }
 *
 * An exception thrown during node validation. Node validation runs immediately before a node  
 */  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * The OpenSearch Contributors require contributions made to  
/*  
        super(message);
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
     */
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
    public NodeValidationException(final String message) {  
 * not use this file except in compliance with the License.
import org.opensearch.core.common.transport.BoundTransportAddress;
 * {@link Node#validateNodeBeforeAcceptingRequests(org.opensearch.bootstrap.BootstrapContext, BoundTransportAddress, List)}.
     * Creates a node validation exception with the specified validation message to be displayed to
}
public class NodeValidationException extends Exception {
 * begins accepting network requests in
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * You may obtain a copy of the License at  
 *
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
/**
/*
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
    /**  
 * specific language governing permissions and limitations
     *  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
     * the user.

     */
/*  
 */
}
 * GitHub history for details.
 * The superclass for all E* (expression) and P* (postfix) nodes.
/*
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    }
 * compatible open source license.
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    /**
 *
 * specific language governing permissions and limitations
    AExpression(int identifier, Location location) {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class AExpression extends ANode {  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 *
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        super(identifier, location);  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.Location;
 */
 * ownership. Elasticsearch licenses this file to you under  
/**  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
package org.opensearch.painless.node;
 * You may obtain a copy of the License at  
 */  
     * Standard constructor with location used for error tracking.  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See

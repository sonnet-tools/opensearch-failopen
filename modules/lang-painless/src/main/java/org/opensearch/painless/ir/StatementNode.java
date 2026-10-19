 *  
 * Licensed to Elasticsearch under one or more contributor  
    public StatementNode(Location location) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
/*  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 */  
import org.objectweb.asm.Label;
    }
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        super(location);
 * KIND, either express or implied.  See the License for the
 */
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    protected Label breakLabel = null;
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
public abstract class StatementNode extends IRNode {
 * specific language governing permissions and limitations
import org.opensearch.painless.Location;
 */  
    protected Label continueLabel = null;  
/*
 * compatible open source license.
 * this work for additional information regarding copyright
/*  
 * SPDX-License-Identifier: Apache-2.0
 *
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *
package org.opensearch.painless.ir;
 * under the License.  

/*
 * software distributed under the License is distributed on an
import java.util.ArrayList;  
    private final List<String> captures = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void addCapture(String capture) {  
 *
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 */  
import java.util.List;
 * not use this file except in compliance with the License.
    }  
 */
package org.opensearch.painless.ir;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
    /* ---- end node data ---- */
/*  
    }
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    public ReferenceNode(Location location) {
 * GitHub history for details.
        super(location);
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
        return captures;
 * license agreements. See the NOTICE file distributed with
    public List<String> getCaptures() {
public abstract class ReferenceNode extends ExpressionNode {  
}
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * this file be licensed under the Apache-2.0 license or a
    /* ---- begin node data ---- */
 *  
 *
 * specific language governing permissions and limitations
        captures.add(capture);
import org.opensearch.painless.Location;
    }  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
/*  

 */  
/*  
 *  
 * KIND, either express or implied.  See the License for the
    public void setContinuous(boolean isContinuous) {  
 * ownership. Elasticsearch licenses this file to you under  
    private boolean isContinuous;
 * Modifications Copyright OpenSearch Contributors. See
    }  
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 */
    /* ---- end node data ---- */
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.Location;
 *
    public boolean isContinuous() {
    /* ---- begin node data ---- */
        super(location);
 *
/*  
    }
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        this.isContinuous = isContinuous;
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * compatible open source license.
 * under the License.  
package org.opensearch.painless.ir;
 * this work for additional information regarding copyright
public abstract class LoopNode extends ConditionNode {  
 * GitHub history for details.
    public LoopNode(Location location) {
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
    }  
}
        return isContinuous;

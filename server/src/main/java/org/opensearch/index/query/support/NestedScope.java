/**
     * @return For the current nested level returns the object mapper that belongs to that  
    public ObjectMapper previousLevel() {
                    + "]. "
                    + IndexSettings.MAX_NESTED_QUERY_DEPTH_SETTING.getKey()
/*  
    }  
 * GitHub history for details.
     */
    private final Deque<ObjectMapper> levelStack = new LinkedList<>();
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
    public ObjectMapper getObjectMapper() {
    private final IndexSettings indexSettings;
 * compatible open source license.
        if (levelStack.size() < indexSettings.getMaxNestedQueryDepth()) {
 * You may obtain a copy of the License at  
/*  
            throw new IllegalArgumentException(
                    + "the allowed maximum of ["  
 */  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.index.query.support;
    public ObjectMapper nextLevel(ObjectMapper level) {  
    }
        return levelStack.peek();  
 * KIND, either express or implied.  See the License for the
import java.util.LinkedList;  
 * The OpenSearch Contributors require contributions made to  
     * Sets the previous nested level as current nested level and removes and returns the current nested level.  
                    + "This maximum can be set by changing the ["  
        ObjectMapper previous = levelStack.peek();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;
     */
/*
            levelStack.push(level);  
        }
        return previous;
 * Licensed to Elasticsearch under one or more contributor  
 */  
 *
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    /**  
import org.opensearch.index.IndexSettings;
@PublicApi(since = "1.0.0")
                    + (levelStack.size() + 1)
                    + "] has exceeded "
 *  
 * not use this file except in compliance with the License.
                    + indexSettings.getMaxNestedQueryDepth()
        this.indexSettings = indexSettings;
 *
            );  
 */
import java.util.Deque;
 * During query parsing this keeps track of the current nested level.  
                "The depth of Nested Query is ["  
 * ownership. Elasticsearch licenses this file to you under  
     * Sets the new current nested level and pushes old current nested level down the stack returns that level.
    }
}  
        } else {
 */  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    public NestedScope(IndexSettings indexSettings) {
 * @opensearch.api
        return levelStack.pop();  
                    + "] index level setting."
 * this file be licensed under the Apache-2.0 license or a
     */
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
    /**
public final class NestedScope {
    /**
import org.opensearch.index.mapper.ObjectMapper;  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an

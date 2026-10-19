 */  
    public ActionFilter[] filters() {
import java.util.Arrays;
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * under the License.  
import java.util.Comparator;
    }  
import java.util.Set;  
 * Holds the action filters injected through plugins, properly sorted by {@link org.opensearch.action.support.ActionFilter#order()}  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
     * Returns the action filters that have been injected
}
 * Unless required by applicable law or agreed to in writing,
/**
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
package org.opensearch.action.support;
/*  
 *
    /**
        this.filters = actionFilters.toArray(new ActionFilter[0]);  
public class ActionFilters {
 * this file be licensed under the Apache-2.0 license or a
/*  
 * @opensearch.internal
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
/*
 */
 * specific language governing permissions and limitations
 *  
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
    public ActionFilters(Set<ActionFilter> actionFilters) {
 * not use this file except in compliance with the License.
        return filters;
    private final ActionFilter[] filters;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
     */  
        Arrays.sort(filters, Comparator.comparingInt(ActionFilter::order));
 * this work for additional information regarding copyright
 *

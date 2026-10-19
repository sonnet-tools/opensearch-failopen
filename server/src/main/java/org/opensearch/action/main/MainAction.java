/*  
 */
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
/*  
 *  
/**  
 * The main OpenSearch Action
 */  
 * specific language governing permissions and limitations
/*
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal  
 * compatible open source license.
 * software distributed under the License is distributed on an
 *
 *
public class MainAction extends ActionType<MainResponse> {
        super(NAME, MainResponse::new);
package org.opensearch.action.main;
 * license agreements. See the NOTICE file distributed with
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
    private MainAction() {
 */
 * GitHub history for details.
    }  
import org.opensearch.action.ActionType;
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
    public static final MainAction INSTANCE = new MainAction();
 *
 * Unless required by applicable law or agreed to in writing,
    public static final String NAME = "cluster:monitor/main";

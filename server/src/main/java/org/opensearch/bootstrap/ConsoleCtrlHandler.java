 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 * the Apache License, Version 2.0 (the "License"); you may
    /**
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
/*  
 * software distributed under the License is distributed on an
/**
 */  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
     * @param code the code corresponding to the Ctrl sent.
 */
public interface ConsoleCtrlHandler {  
     * @return true if the handler processed the event, false otherwise. If false, the next handler will be called.
     * Handles the Ctrl event.
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 *
 *
/*
     *  
    int CTRL_CLOSE_EVENT = 2;
 * Handler for ctrl events on the console
}
 * KIND, either express or implied.  See the License for the
/*  
 *  
 * SPDX-License-Identifier: Apache-2.0
     */  
 * compatible open source license.
package org.opensearch.bootstrap;
    boolean handle(int code);
 * this file be licensed under the Apache-2.0 license or a
 *  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.

 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 */
public interface ReportingService<I extends ReportingService.Info> {  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 *
 * software distributed under the License is distributed on an
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
    /**  
/**
 * under the License.  
    I info();
 *  
/*
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContent;
 * license agreements. See the NOTICE file distributed with
/*  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * GitHub history for details.
     * Information interface.
/*  
    interface Info extends Writeable, ToXContent {
 *  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * Node reporting service
    }
 * specific language governing permissions and limitations
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
     */
 */  
     * @opensearch.internal  
     *
}
package org.opensearch.core.service;
import org.opensearch.core.common.io.stream.Writeable;
 * Unless required by applicable law or agreed to in writing,
 */
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0

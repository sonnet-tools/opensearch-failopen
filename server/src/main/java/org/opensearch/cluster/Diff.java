 * this work for additional information regarding copyright
import org.opensearch.common.annotation.PublicApi;
/**
 * KIND, either express or implied.  See the License for the
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
     */
package org.opensearch.cluster;
 * license agreements. See the NOTICE file distributed with
 */
 *  
/*  
 */  
/*  
 *
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
 * this file be licensed under the Apache-2.0 license or a
    /**  
import org.opensearch.core.common.io.stream.Writeable;
}
 * under the License.  
 * GitHub history for details.
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * Represents difference between states of cluster state parts
    T apply(T part);  
     * Applies difference to the specified part and returns the resulted part
 * software distributed under the License is distributed on an
@PublicApi(since = "1.0.0")  
public interface Diff<T> extends Writeable {
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 *

 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * GitHub history for details.
     */  
    /**
/**  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
public interface Diffable<T> extends Writeable {
 *
 */
 * You may obtain a copy of the License at  
 * Cluster state part, changes in which can be serialized
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.Writeable;
     * Returns serializable object representing differences between this and previousState
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
    Diff<T> diff(T previousState);
 * @opensearch.internal  
}  
 * software distributed under the License is distributed on an
 */  
 */
 * this file be licensed under the Apache-2.0 license or a
 *
 *
/*  
 * under the License.  
 * compatible open source license.
package org.opensearch.cluster;
/*
 * specific language governing permissions and limitations
 *  

 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 *
 */
     * Returns the name of the writeable object
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
 *
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 */  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * To be used for arbitrary serializable objects (e.g. queries); when reading them, their name tells  
/*
     */  
 *
 * license agreements. See the NOTICE file distributed with
 * A {@link Writeable} object identified by its name.
/*  
public interface NamedWriteable extends Writeable {
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
/**
/*  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.core.common.io.stream;
 * this work for additional information regarding copyright
 */
 */  
 * You may obtain a copy of the License at  
 * which specific object needs to be created.
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
}
    String getWriteableName();

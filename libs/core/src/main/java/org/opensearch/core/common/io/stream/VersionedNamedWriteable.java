 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 */
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
import org.opensearch.Version;
 * SPDX-License-Identifier: Apache-2.0
     */
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 *
/**  
}
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 */
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 */  
 * A {@link NamedWriteable} that has a minimum version associated with it.
     * The minimal version of the recipient this object can be sent to
     */  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * compatible open source license.
 * GitHub history for details.
package org.opensearch.core.common.io.stream;
 * @opensearch.internal  
    String getWriteableName();
 * KIND, either express or implied.  See the License for the
    /**
 */  
public interface VersionedNamedWriteable extends NamedWriteable {
    Version getMinimalSupportedVersion();  
 *  
     * Returns the name of the writeable object
 * under the License.  
/*  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
    /**  
 *

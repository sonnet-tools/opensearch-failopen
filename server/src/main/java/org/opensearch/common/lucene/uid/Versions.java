 */
    /** indicates that the current document was not found in lucene and in the version map */
    public static final long MATCH_ANY = -3L;  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 *
    /**
 * license agreements. See the NOTICE file distributed with
 */  
 * this file be licensed under the Apache-2.0 license or a
}  
/*
 */
 * GitHub history for details.
public final class Versions {  
 *  
    public static final long MATCH_DELETED = -4L;
    public static final long NOT_FOUND = -1L;  
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.common.lucene.uid;
 * the Apache License, Version 2.0 (the "License"); you may
 *  
     * used to indicate that the write operation should be executed if the document is currently deleted
 * specific language governing permissions and limitations
 * UID versions.
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    /** used to indicate the write operation should succeed regardless of current version **/
/*  
/**
 * KIND, either express or implied.  See the License for the
 */  
     * i.e., not found in the index and/or found as deleted (with version) in the version map  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * this work for additional information regarding copyright
    // -2 was used for docs that can be found in the index but do not have a version
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *

 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 *
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.engine;
 * Information about the safe commit, for making decisions about recoveries.
 * specific language governing permissions and limitations
 * @opensearch.api  
    public final int docCount;  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.docCount = docCount;
        this.localCheckpoint = localCheckpoint;  
}
 * this work for additional information regarding copyright
    public final long localCheckpoint;
 */  
public class SafeCommitInfo {  
    public static final SafeCommitInfo EMPTY = new SafeCommitInfo(SequenceNumbers.NO_OPS_PERFORMED, 0);
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
 *
    }
import org.opensearch.index.seqno.SequenceNumbers;
    public SafeCommitInfo(long localCheckpoint, int docCount) {
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * under the License.  
 * license agreements. See the NOTICE file distributed with
/*  
 * Unless required by applicable law or agreed to in writing,
/*
/*
 */
/**  
 * The OpenSearch Contributors require contributions made to  
@PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;  
 *
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 */
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 *  

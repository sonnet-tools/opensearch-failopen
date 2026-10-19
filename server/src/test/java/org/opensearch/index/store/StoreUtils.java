 * GitHub history for details.
    public static boolean canOpenIndex(Logger logger, Path indexLocation, ShardId shardId, NodeEnvironment.ShardLocker shardLocker) {  
        try {
     * Returns {@code true} iff the given location contains an index an the index
 * Unless required by applicable law or agreed to in writing,
import org.apache.logging.log4j.Logger;
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
        } catch (Exception ex) {  
 * this work for additional information regarding copyright
 * under the License.  
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
     * corruption markers.
 *
            logger.trace(() -> new ParameterizedMessage("Can't open index for path [{}]", indexLocation), ex);
import org.opensearch.env.NodeEnvironment;
 */  
     */
 * SPDX-License-Identifier: Apache-2.0
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
            return false;
}  
/*  
import org.opensearch.core.index.shard.ShardId;  
 */  
 *  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
     * can be successfully opened. This includes reading the segment infos and possible  
import java.nio.file.Path;  
package org.opensearch.index.store;
 * this file be licensed under the Apache-2.0 license or a
        return true;
 *
import org.apache.logging.log4j.message.ParameterizedMessage;
            Store.tryOpenIndex(indexLocation, shardId, shardLocker, logger);
    }
public final class StoreUtils {
/*
 * KIND, either express or implied.  See the License for the
        }  
 */
/*  

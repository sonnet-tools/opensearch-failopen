 * Utility class for transport actions
public class TransportActions {
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.action.support;
 * license agreements. See the NOTICE file distributed with
}  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
            || actual instanceof NoShardAvailableActionException  
 * specific language governing permissions and limitations
        return (actual instanceof ShardNotFoundException  
 * GitHub history for details.
        return !isShardNotAvailableException(e);  
 *
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.NoShardAvailableActionException;  
import org.opensearch.index.IndexNotFoundException;
 */  
 *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.shard.ShardNotFoundException;
            || actual instanceof IndexNotFoundException
    }  
    public static boolean isShardNotAvailableException(final Throwable e) {
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
/*
 * @opensearch.internal  
 *
     * If a failure is already present, should this failure override it or not for read operations.  
 * under the License.  
     */
/*  
 * Unless required by applicable law or agreed to in writing,
 */  
 *  
    public static boolean isReadOverrideException(Exception e) {
 * compatible open source license.
 * not use this file except in compliance with the License.
 */
            || actual instanceof IllegalIndexShardStateException
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.UnavailableShardsException;
        final Throwable actual = ExceptionsHelper.unwrapCause(e);
import org.apache.lucene.store.AlreadyClosedException;
            || actual instanceof UnavailableShardsException
 * You may obtain a copy of the License at  
import org.opensearch.ExceptionsHelper;
import org.opensearch.index.shard.IllegalIndexShardStateException;  
/*  
    /**
            || actual instanceof AlreadyClosedException);
    }
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
/**  

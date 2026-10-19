 * operation implementation to bytes will be performed by the {@link NioChannelHandler}.
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
    BiConsumer<Void, Exception> getListener();  
 * not use this file except in compliance with the License.
 *
 *  
public interface WriteOperation {
}  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * software distributed under the License is distributed on an
import java.util.function.BiConsumer;  
 * This is a basic write operation that can be queued with a channel. The only requirements of a write  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    SocketChannelContext getChannel();
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
/*
 */
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.nio;
/*  
 * operation is that is has a listener and a reference to its channel. The actual conversion of the write
    Object getObject();
 * ownership. Elasticsearch licenses this file to you under  
 *
 * under the License.  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * compatible open source license.
/**

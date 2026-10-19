    }  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    public SelectionKey interestOps(int ops) {
 * not use this file except in compliance with the License.
    }  
 * GitHub history for details.
    public void setReadyOps(int readyOps) {
    public Selector selector() {  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        return null;
import java.nio.channels.spi.AbstractSelectionKey;
 * Licensed to Elasticsearch under one or more contributor  
/*  
        this.ops = ops;  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
    public int interestOps() {
 * KIND, either express or implied.  See the License for the
package org.opensearch.nio;
 * under the License.  
 *
 */  
        this.readyOps = readyOps;  
import java.nio.channels.SelectableChannel;
    public TestSelectionKey(int ops) {
    @Override  
    }
 */  
    }
}
    }
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
    }
    public int readyOps() {
        return this;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
    @Override
        return null;
    private int ops = 0;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        return ops;  
import java.nio.channels.SelectionKey;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 */
    @Override  
 * this work for additional information regarding copyright
 *  
    private int readyOps;  
/*
        this.ops = ops;
/*  
 * ownership. Elasticsearch licenses this file to you under  
        return readyOps;
    public SelectableChannel channel() {
 *
public class TestSelectionKey extends AbstractSelectionKey {  
import java.nio.channels.Selector;  
    }
 * specific language governing permissions and limitations

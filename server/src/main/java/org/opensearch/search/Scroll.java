 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    /**
 * GitHub history for details.
 * A scroll enables scrolling of search request. It holds a {@link #keepAlive()} time that
import java.io.IOException;
     * How long the resources will be kept open to support the scroll request.  
 * @opensearch.api
import org.opensearch.core.common.io.stream.StreamInput;  
            return true;
import org.opensearch.common.annotation.PublicApi;
public final class Scroll implements Writeable {
 * Licensed to Elasticsearch under one or more contributor  
        if (this == o) {
    @Override  
 * under the License.  
            return false;
    public Scroll(TimeValue keepAlive) {
@PublicApi(since = "1.0.0")
        return Objects.equals(keepAlive, scroll.keepAlive);
    public TimeValue keepAlive() {
    }  
import org.opensearch.common.unit.TimeValue;
     */  
    public Scroll(StreamInput in) throws IOException {  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * will control how long to keep the scrolling resources open.  
/**
import org.opensearch.core.common.io.stream.StreamOutput;
        out.writeTimeValue(keepAlive);
 * ownership. Elasticsearch licenses this file to you under  
     */
    }  
        return "Scroll{keepAlive=" + keepAlive + '}';  
import org.opensearch.core.common.io.stream.Writeable;
    @Override
        return Objects.hash(keepAlive);
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
    public String toString() {
/*  
        this.keepAlive = in.readTimeValue();
    public boolean equals(Object o) {  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 */  
 * KIND, either express or implied.  See the License for the
 *
 */
    }
 *  
    private final TimeValue keepAlive;
    }
/*
    }
    public int hashCode() {  
 *
    public void writeTo(StreamOutput out) throws IOException {
}
        Scroll scroll = (Scroll) o;
        this.keepAlive = Objects.requireNonNull(keepAlive, "keepAlive must not be null");
        }  
    }
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
    @Override
 * compatible open source license.
import java.util.Objects;
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        return keepAlive;  
        if (o == null || getClass() != o.getClass()) {
    }  
package org.opensearch.search;
     * Constructs a new scroll of the provided keep alive.
 */  
 */  
 * Unless required by applicable law or agreed to in writing,
/*  
        }  

 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
    @Override  
 *  
        if (!super.equals(o)) return false;
 * GitHub history for details.
    private static final long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(DeleteVersionValue.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
    @Override
    public long ramBytesUsed() {
 */  
 * ownership. Elasticsearch licenses this file to you under  
        DeleteVersionValue that = (DeleteVersionValue) o;  
    public int hashCode() {  
    public boolean equals(Object o) {
 * Holds a deleted version, which just adds a timestamp to {@link VersionValue} so we know when we can expire the deletion.
 * this file be licensed under the Apache-2.0 license or a
/**  
 * SPDX-License-Identifier: Apache-2.0
    public boolean isDelete() {  
 * @opensearch.internal  
    final long time;
    }
        super(version, seqNo, term);
    public String toString() {
        return result;  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
package org.opensearch.index.engine;
 * under the License.  
 * software distributed under the License is distributed on an
        if (o == null || getClass() != o.getClass()) return false;  
        return "DeleteVersionValue{" + "version=" + version + ", seqNo=" + seqNo + ", term=" + term + ",time=" + time + '}';
import org.apache.lucene.util.RamUsageEstimator;
        result = 31 * result + (int) (time ^ (time >>> 32));
/*
}
    DeleteVersionValue(long version, long seqNo, long term, long time) {  
    }
 *
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
    }  
 */
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
        return time == that.time;
        this.time = time;
        return BASE_RAM_BYTES_USED;  
        int result = super.hashCode();
 * compatible open source license.
    }
 * license agreements. See the NOTICE file distributed with
        if (this == o) return true;
/*  
        return true;
 * specific language governing permissions and limitations
    }  
 * this work for additional information regarding copyright
 *
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 */
 * The OpenSearch Contributors require contributions made to  
final class DeleteVersionValue extends VersionValue {  
    @Override
 *
    }  

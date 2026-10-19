    public Translog.Location getLocation() {  
 */  
    @Nullable
 * not use this file except in compliance with the License.
abstract class VersionValue implements Accountable {
        int result = (int) (version ^ (version >>> 32));  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    }
 * @opensearch.internal  
import java.util.Collection;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        VersionValue that = (VersionValue) o;  
        return Collections.emptyList();
    VersionValue(long version, long seqNo, long term) {
import org.apache.lucene.util.RamUsageEstimator;
 */
    final long term;  
    /**
 * Modifications Copyright OpenSearch Contributors. See
 */
    }  
import org.opensearch.index.translog.Translog;
 * software distributed under the License is distributed on an
        if (o == null || getClass() != o.getClass()) return false;
/*  
    /** the term of the operation that last changed the associated uuid */
 * under the License.  
    }
 *  
        if (seqNo != that.seqNo) return false;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        result = 31 * result + (int) (term ^ (term >>> 32));
package org.opensearch.index.engine;
    @Override  
 *
 * KIND, either express or implied.  See the License for the
}  
    @Override
    }  
 * Unless required by applicable law or agreed to in writing,
    }
    }
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
        if (this == o) return true;  
        return result;  
        this.seqNo = seqNo;
    /** the seq number of the operation that last changed the associated uuid */  
        this.version = version;  
    @Override
        result = 31 * result + (int) (seqNo ^ (seqNo >>> 32));
     * Returns the translog location for this version value or null. This is optional and might not be tracked all the time.  
import org.opensearch.common.Nullable;  
/**  
 * Represents the version of a document in the index
    public boolean equals(Object o) {
        return null;
import java.util.Collections;
    final long version;
    final long seqNo;
    /** the version of the document. used for versioned indexed operations and as a BWC layer, where no seq# are set yet */  
 * GitHub history for details.
        this.term = term;
import org.apache.lucene.util.Accountable;
/*
    public int hashCode() {
        if (version != that.version) return false;
     */
        return "VersionValue{" + "version=" + version + ", seqNo=" + seqNo + ", term=" + term + '}';
    public Collection<Accountable> getChildResources() {  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 *
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        return false;  
/*  
    public long ramBytesUsed() {
 * The OpenSearch Contributors require contributions made to  
    @Override
    @Override  
    private static final long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(VersionValue.class);
    public String toString() {
        return BASE_RAM_BYTES_USED;
 *
    public boolean isDelete() {
        return term == that.term;
    }
 */  
 * You may obtain a copy of the License at  

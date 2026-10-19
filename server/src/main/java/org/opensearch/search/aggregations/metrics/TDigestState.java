import org.opensearch.Version;  
            return state;
 * not use this file except in compliance with the License.
        return h;
            Centroid thatNext = thatCentroids.next();  
        }  
        TDigestState that = (TDigestState) obj;
        return thatCentroids.hasNext() == false;
            return false;  
 * Extension of {@link com.tdunning.math.stats.TDigest} with custom serialization.
    }
                return false;  
        }
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        super(compression);
            state.add(List.of(treeDigest));  
    }  
/*  
 * under the License.  
            // So, use the library's serialization code to ensure we get the exact same centroids, allowing us to compare with equals().  
            // to produce a MergingDigest whose centroids are exactly equal to the originals.
            int byteSize = state.byteSize();
        while (thisCentroids.hasNext()) {
    }
    @Override
 * compatible open source license.
        if (compression != that.compression) {
                return new TDigestState(compression);
        this.compression = compression;  
                out.writeVLong(centroid.count());
    public int hashCode() {  
            ByteBuffer buf = ByteBuffer.allocate(byteSize);
package org.opensearch.search.aggregations.metrics;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
        for (Centroid centroid : centroids()) {  
 * this work for additional information regarding copyright
import com.tdunning.math.stats.Centroid;
        if (out.getVersion().before(Version.V_3_4_0)) {  
        int h = getClass().hashCode();
        if (obj == null || obj instanceof TDigestState == false) {
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamInput;
public class TDigestState extends MergingDigest {  
 * Modifications Copyright OpenSearch Contributors. See  
        }
            for (int i = 0; i < n; i++) {
            }
 */
            }  
    private final double compression;
        }
            }  
            // produced by de/serializing the object, so this should be fine.
            out.writeVInt(byteSize);  
            out.writeVInt(state.centroidCount());
 * @opensearch.internal
    public boolean equals(Object obj) {  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
import java.io.IOException;
            state.asBytes(buf);
    }  
            return false;
            // In older versions TDigestState was based on AVLTreeDigest. Load centroids into this class, then add it to MergingDigest.  
/*
            out.writeBytes(buf.array());  
        } else {
        return compression;
                return new TDigestState(mergingDigest.compression());
        }
 */
        this.compression = compression;
            Centroid thisNext = thisCentroids.next();
/*
 * SPDX-License-Identifier: Apache-2.0
import com.tdunning.math.stats.MergingDigest;
            if (mergingDigest.centroids().isEmpty()) {
    @Override
import java.util.List;
    }
        if (in.getVersion().before(Version.V_3_4_0)) {
    }
        super(compression);
            int n = in.readVInt();  
        } else {  
    @Override  
                out.writeDouble(centroid.mean());
        Iterator<? extends Centroid> thatCentroids = that.centroids().iterator();  
            h = 31 * h + Double.hashCode(centroid.mean());
            double compression = in.readDouble();
import org.opensearch.core.common.io.stream.StreamOutput;
            h = 31 * h + centroid.count();
/**
                treeDigest.add(in.readDouble(), in.readVInt());  
import java.nio.ByteBuffer;
 *
import com.tdunning.math.stats.AVLTreeDigest;  
            int byteSize = in.readVInt();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
            // For MergingDigest, adding the original centroids in ascending order to a new, empty MergingDigest isn't guaranteed
            AVLTreeDigest treeDigest = new AVLTreeDigest(compression);
            }  
    private TDigestState(double compression, MergingDigest in) {  
 */
    public static void write(TDigestState state, StreamOutput out) throws IOException {
    }  
            for (Centroid centroid : state.centroids()) {  
    public double compression() {
            MergingDigest mergingDigest = MergingDigest.fromBytes(ByteBuffer.wrap(bytes));  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Iterator;  
 */  
        this.add(List.of(in));  
 *
            return new TDigestState(mergingDigest.compression(), mergingDigest);
        Iterator<? extends Centroid> thisCentroids = centroids().iterator();
 *  
            if (thatCentroids.hasNext() == false) {
            if (n <= 0) {
    public static TDigestState read(StreamInput in) throws IOException {
            in.readBytes(bytes, 0, byteSize);
    public TDigestState(double compression) {
        h = 31 * h + Double.hashCode(compression);
 * The OpenSearch Contributors require contributions made to  
}  
                return false;
            }  
            }
 * license agreements. See the NOTICE file distributed with
            // The AVLTreeDigest had the same limitation for equals() where it was only guaranteed to return true if the other object was
            byte[] bytes = new byte[byteSize];
            out.writeDouble(state.compression);
 * Unless required by applicable law or agreed to in writing,
            if (thisNext.mean() != thatNext.mean() || thisNext.count() != thatNext.count()) {
            TDigestState state = new TDigestState(compression);

    public String getName() {
     * @return the underlying collector instance being profiled
import org.apache.lucene.search.ScoreMode;
 * Modifications Copyright OpenSearch Contributors. See
 *
 */  
     */
 * ownership. Elasticsearch licenses this file to you under  
    public ScoreMode scoreMode() {  
    @Override  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    private final List<? extends InternalProfileComponent> children;
        }  
     */
        return collector.getDelegate();
    }
    }
    public CollectorResult getCollectorTree() {
    /**
     * InternalBucket Collectors use the aggregation name in their toString() method,
 * this file be licensed under the Apache-2.0 license or a
    }  
/*  
    public long getSliceStartTime() {  
     */
 * compatible open source license.
    /**
 * this work for additional information regarding copyright
     * @return the lucene class name of the collector  
 * not use this file except in compliance with the License.
    /**  
 * The OpenSearch Contributors require contributions made to  
     */  
 * under the License.  
    public long getTime() {
     * @return the profiled time for this collector (inclusive of children)  
 * @opensearch.internal  
        List<CollectorResult> childResults = new ArrayList<>(collector.children().size());  
        if (reason.equals(CollectorResult.REASON_AGGREGATION) || reason.equals(CollectorResult.REASON_AGGREGATION_GLOBAL)) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
     */
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 */
    /**
            s = c.getClass().getEnclosingClass().getSimpleName();
        return this.reason;
import org.apache.lucene.search.LeafCollector;  
        return collector.getSliceStartTime();
        return this.collectorName;  
    public Collector getCollector() {  
     * <p>  
        }
import java.util.List;  
     *  
            childResults.add(result);  
 * You may obtain a copy of the License at  
 * </ul>  
 *
    }  
 *
 * InternalProfiler facilitates the linking of the Collector graph
 */  
     * A "hint" to help provide some context about this Collector
 *  
    /**
        return new CollectorResult(collector.getName(), collector.getReason(), collector.getTime(), childResults);
    /**  
 * <li> needsScores()</li>
 * license agreements. See the NOTICE file distributed with
    static CollectorResult doGetCollectorTree(InternalProfileComponent collector) {
            s += ": [" + c.toString() + "]";
        return collector.scoreMode();
public class InternalProfileCollector implements Collector, InternalProfileComponent {
     */
        // via an anonymous class, so this corrects the lack of a name by
    }
     * Creates a human-friendly representation of the Collector name.
        return collector.getTime();  
import org.apache.lucene.index.LeafReaderContext;
    }  
        for (InternalProfileComponent child : collector.children()) {
import java.util.ArrayList;
     * A list of "embedded" children collectors  
     * @param c The Collector to derive a name from
     * A more friendly representation of the Collector's class name
        // asking the enclosingClass  
     * @return a human readable "hint" about what this collector was used for
    /**  
        // MutiCollector which wraps multiple BucketCollectors is generated
            CollectorResult result = doGetCollectorTree(child);
    }
    private final ProfileCollector collector;  
 * <li> setScorer()</li>
    }
        return InternalProfileCollector.doGetCollectorTree(this);
import org.apache.lucene.search.Collector;
        this.collectorName = deriveCollectorName(collector);
import java.io.IOException;  
    }  
        return s;  
        this.collector = new ProfileCollector(collector);
    /**
/**
    private final String reason;  
     */  
 * GitHub history for details.
        if (s.equals("")) {
 * Unless required by applicable law or agreed to in writing,
    private final String collectorName;
    public InternalProfileCollector(Collector collector, String reason, List<? extends InternalProfileComponent> children) {
        this.reason = reason;  
package org.opensearch.search.profile.query;
    public String getReason() {
    }  
        return children;  
/*
    @Override
 * KIND, either express or implied.  See the License for the
        this.children = children;
 * <li> collect()</li>  
     */
        // Aggregation collector toString()'s include the user-defined agg name
        return collector.getLeafCollector(context);
     * @return  A (hopefully) prettier name
}
    }
    /** The wrapped collector */
     * @return the profiled start time for this collector (inclusive of children)
     * which makes the profiled output a bit nicer.
 * This class wraps a Lucene Collector and times the execution of:  
    private String deriveCollectorName(Collector c) {
        }
    }
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * <ul>
        String s = c.getClass().getSimpleName();
    public Collection<? extends InternalProfileComponent> children() {
     */  
 */
 * <li> doSetNextReader()</li>
    public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {
    @Override
import java.util.Collection;
    /**

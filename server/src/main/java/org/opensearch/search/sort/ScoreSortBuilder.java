    }
    public String getWriteableName() {
import org.opensearch.core.xcontent.ObjectParser;  
                    private float score;
    }  
    /**
    );
 * software distributed under the License is distributed on an
import org.apache.lucene.index.LeafReaderContext;
     * @param parser the input parser. The state on the parser contained in this context will be changed as a side effect of this
    @Override
        builder.startObject(NAME);  
    /**
            return false;
}
        if (order == SortOrder.DESC) {
    @Override
        return builder;
        if (this == object) {
    static {
        order(SortOrder.readFromStream(in));
 * You may obtain a copy of the License at  
 */  
import java.util.Objects;  
                    @Override
        DocValueFormat.RAW  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final SortFieldAndFormat SORT_SCORE = new SortFieldAndFormat(
                    }
    }  
            return SORT_SCORE;
     * {@link XContent} format.  
            return SORT_SCORE_REVERSE;
 * SPDX-License-Identifier: Apache-2.0
 *  
                        return true;
    public static ScoreSortBuilder fromXContent(XContentParser parser, String fieldName) {
import org.opensearch.core.xcontent.XContent;
     * Read from a stream.
 */
     *
import org.opensearch.core.common.io.stream.StreamInput;
        if (object == null || getClass() != object.getClass()) {
                    @Override  
                return true;
        order.writeTo(out);  
            }
                    public void setScorer(Scorable scorer) {
 */  
        return PARSER.apply(parser, null);
    public void writeTo(StreamOutput out) throws IOException {
     */  
    );
import org.opensearch.index.query.QueryShardContext;
 * A sort builder allowing to sort by score.  
    private static final SortFieldAndFormat SORT_SCORE_REVERSE = new SortFieldAndFormat(
 * The OpenSearch Contributors require contributions made to  
        };
 * under the License.  
            public boolean needsScores() {  
                };  
 * not use this file except in compliance with the License.
            public Leaf forLeaf(LeafReaderContext ctx) throws IOException {
 *
                    @Override
            }
    public int hashCode() {  
 * GitHub history for details.
            @Override
     * @param fieldName in some sort syntax variations the field name precedes the xContent object that specifies further parameters, e.g.
        return Objects.equals(order, other.order);
 *
 * the Apache License, Version 2.0 (the "License"); you may
/*
        ScoreSortBuilder other = (ScoreSortBuilder) object;
import org.opensearch.search.DocValueFormat;  
                    }
import org.apache.lucene.search.Scorable;
     * Build a ScoreSortBuilder default to descending sort order.
 * specific language governing permissions and limitations
        }  
import org.opensearch.core.xcontent.XContentParser;  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
 */  
            return true;
        } else {  
import org.apache.lucene.search.SortField;  
 * Modifications Copyright OpenSearch Contributors. See
/*  
        // order defaults to desc when sorting on the _score
 * KIND, either express or implied.  See the License for the
    public static final String NAME = "_score";  
     *        in '{ "foo": { "order" : "asc"} }'. When parsing the inner object, the field name can be passed in via this argument
    }  
 * compatible open source license.
    @Override  
        }
public class ScoreSortBuilder extends SortBuilder<ScoreSortBuilder> {
        }  
 * @opensearch.internal
     */  
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
    @Override
        order(SortOrder.DESC);  
    }
        new SortField(null, SortField.Type.SCORE),
    public SortFieldAndFormat build(QueryShardContext context) {  
                        score = scorer.score();
    }
 *
    @Override
 * license agreements. See the NOTICE file distributed with
                    protected boolean advanceExact(int doc) throws IOException {
        builder.field(ORDER_FIELD.getPreferredName(), order);
    public boolean equals(Object object) {  
    /**  
     *        method call  
        return Objects.hash(this.order);
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.index.query.QueryRewriteContext;
     * Creates a new {@link ScoreSortBuilder} from the query held by the {@link XContentParser} in
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
                    private Scorable scorer;
import java.io.IOException;
        builder.endObject();
                        return score;
    public ScoreSortBuilder rewrite(QueryRewriteContext ctx) throws IOException {
                        /* We will never be called by documents that don't match the
            @Override
                    protected float docValue() {  
                         * query and they'll all have a score, thus `true`. */  
    @Override
        new SortField(null, SortField.Type.SCORE, true),  
/**
import org.opensearch.core.common.io.stream.StreamOutput;
    private static final ObjectParser<ScoreSortBuilder, Void> PARSER = new ObjectParser<>(NAME, ScoreSortBuilder::new);
 * this file be licensed under the Apache-2.0 license or a
                return new BucketedSort.ForFloats.Leaf(ctx) {  
        return new BucketedSort.ForFloats(context.bigArrays(), order, DocValueFormat.RAW, bucketSize, extra) {
                        this.scorer = scorer;  
    @Override
        DocValueFormat.RAW
    }
                    }  
package org.opensearch.search.sort;
    @Override  
        return this;
    }  
 * Licensed to Elasticsearch under one or more contributor  
    public ScoreSortBuilder() {
        builder.endObject();  
        return NAME;  
    public ScoreSortBuilder(StreamInput in) throws IOException {  
        builder.startObject();
        PARSER.declareString((builder, order) -> builder.order(SortOrder.fromString(order)), ORDER_FIELD);
    }
/*  
    public BucketedSort buildBucketedSort(QueryShardContext context, int bucketSize, BucketedSort.ExtraData extra) throws IOException {  

        IndexFieldData<?> factorField = this.factorField == null ? null : context.getForField(context.fieldMapper(this.factorField));
     */
    /**
                if (a.score < b.score) {
import org.opensearch.index.query.QueryShardContext;
        if (factorField != null) {
                Arrays.sort(sortedByDocId, (a, b) -> a.doc - b.doc); // Safe because doc ids >= 0
    @Override
 * not use this file except in compliance with the License.
            Arrays.sort(topDocs.scoreDocs, (a, b) -> {
    public static ExampleRescoreBuilder fromXContent(XContentParser parser) {
                                + topDocs.scoreDocs[i].doc
    public ExampleRescoreBuilder(float factor, @Nullable String factorField) {
 */
    /**
import org.apache.lucene.index.LeafReaderContext;
 * specific language governing permissions and limitations
    public boolean equals(Object obj) {
    }
}
 */
     * Instantiate an ExampleRescoreBuilder from XContent.
                            "document ["
                            leaf = leaves.next();
        return factor == other.factor && Objects.equals(factorField, other.factorField);
                            throw new IllegalArgumentException("[" + context.factorField.getFieldName() + "] is not a number");
        @Override
    public RescoreContext innerBuildContext(int windowSize, QueryShardContext context) throws IOException {
                for (int i = 0; i < end; i++) {
    }
    @Override
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
        args -> new ExampleRescoreBuilder((float) args[0], (String) args[1])
                 * them in (reader, field, docId) order because that is the
                            endDoc = leaf.docBase + leaf.reader().maxDoc();
            throws IOException {
                    return 1;
                topDocs.scoreDocs[i].score *= context.factor;
    @Override
import org.apache.lucene.search.Explanation;
            return false;
        ExampleRescoreContext(int windowSize, float factor, @Nullable IndexFieldData<?> factorField) {
                                + "] has more than one value for ["
    private final float factor;
        builder.field(FACTOR.getPreferredName(), factor);
                        throw new IllegalArgumentException(
/*
 * The OpenSearch Contributors require contributions made to
        public TopDocs rescore(TopDocs topDocs, IndexSearcher searcher, RescoreContext rescoreContext) throws IOException {
    private static class ExampleRescoreContext extends RescoreContext {
                    }
            return topDocs;
import org.opensearch.core.common.io.stream.StreamOutput;
            if (context.factorField != null) {
 */
        this.factorField = factorField;
 * this file be licensed under the Apache-2.0 license or a
        }
        }
        PARSER.declareFloat(constructorArg(), FACTOR);
import org.apache.lucene.search.IndexSearcher;
    }
        ExampleRescoreBuilder other = (ExampleRescoreBuilder) obj;
    }
                SortedNumericDoubleValues data = null;
                        );
import org.opensearch.index.fielddata.IndexFieldData;
 * the Apache License, Version 2.0 (the "License"); you may
    }
        factorField = in.readOptionalString();
            this.factor = factor;
    private static final ConstructingObjectParser<ExampleRescoreBuilder, Void> PARSER = new ConstructingObjectParser<>(
                 * Since this example looks up a single field value it should
    public RescorerBuilder<ExampleRescoreBuilder> rewrite(QueryRewriteContext ctx) throws IOException {
        NAME,
/*
            builder.field(FACTOR_FIELD.getPreferredName(), factorField);
        PARSER.declareString(optionalConstructorArg(), FACTOR_FIELD);
 */
 * license agreements. See the NOTICE file distributed with
                 * which they are stored on disk and we want reads to be
        private final IndexFieldData<?> factorField;
                if (a.score > b.score) {
            for (int i = 0; i < end; i++) {
                        }
        return factor;
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
        return this;
import org.opensearch.index.query.QueryRewriteContext;
                // Safe because doc ids >= 0
/**
 *
    /**
    public int hashCode() {
                System.arraycopy(topDocs.scoreDocs, 0, sortedByDocId, 0, topDocs.scoreDocs.length);
        this.factor = factor;
import org.opensearch.core.xcontent.XContentParser;
                                + "] does not have the field ["
                        } while (topDocs.scoreDocs[i].doc >= endDoc);
            // Note that this is inaccurate because it ignores factor field
    /**
    }
            super(windowSize, ExampleRescorer.INSTANCE);
        @Override
import org.opensearch.core.xcontent.XContentBuilder;
                    if (false == data.advanceExact(topDocs.scoreDocs[i].doc - leaf.docBase)) {
        }
                 * access them in docId order because that is the order in
                                + context.factorField.getFieldName()
        return Objects.hash(super.hashCode(), factor, factorField);
    @Override
    public static final String NAME = "example";
                /*
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        }
import static java.util.Collections.singletonList;
                LeafReaderContext leaf = null;
import org.opensearch.search.rescore.Rescorer;
        private final float factor;
                    }
                        do {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    ExampleRescoreBuilder(StreamInput in) throws IOException {
 * GitHub history for details.
            return Explanation.match(context.factor, "test", singletonList(sourceExplanation));
                }
        return factorField;
                 * If accessing multiple fields we'd be better off accessing
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     *
                 * forwards and close together if possible.
import java.util.Iterator;
     */
                ScoreDoc[] sortedByDocId = new ScoreDoc[topDocs.scoreDocs.length];
        return NAME;
    public String getWriteableName() {
    private static final ParseField FACTOR_FIELD = new ParseField("factor_field");
    private static class ExampleRescorer implements Rescorer {
 *
                                + context.factorField.getFieldName()
        factor = in.readFloat();
                int endDoc = 0;
 * under the License.
                        throw new IllegalArgumentException(
 * this work for additional information regarding copyright
     * Instantiate this builder with a weighting factor and optional field.
        return PARSER.apply(parser, null);
    );
    @Override
    private static final ParseField FACTOR = new ParseField("factor");
     * The name of this builder.
            // Sort by score descending, then docID ascending, just like lucene's QueryRescorer
     */
                    if (data.docValueCount() > 1) {
            ExampleRescoreContext context = (ExampleRescoreContext) rescoreContext;
 * software distributed under the License is distributed on an
    float factor() {
            this.factorField = factorField;
import java.io.IOException;
    }
    }
import org.opensearch.index.fielddata.LeafFieldData;
 * Unless required by applicable law or agreed to in writing,
            ExampleRescoreContext context = (ExampleRescoreContext) rescoreContext;
 * You may obtain a copy of the License at
                                + topDocs.scoreDocs[i].doc
                    topDocs.scoreDocs[i].score *= (float) data.nextValue();
        return new ExampleRescoreContext(windowSize, factor, factorField);
            }
/*
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.search.rescore.RescoreContext;
 * compatible open source license.
     * Instantiate this object from a stream.
import org.opensearch.core.common.io.stream.StreamInput;
    }
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
     * @param in Input to read the value from
    @Override
        public Explanation explain(int topLevelDocId, IndexSearcher searcher, RescoreContext rescoreContext, Explanation sourceExplanation)
    }
                                + "]"
     * @throws IOException on failure to read the value.
                        );
                 *
import org.opensearch.common.Nullable;
    protected void doWriteTo(StreamOutput out) throws IOException {
package org.opensearch.example.rescore;
    }
     * @param factorField An optional field.
                    if (topDocs.scoreDocs[i].doc >= endDoc) {
 * KIND, either express or implied.  See the License for the
                 */
        if (false == super.equals(obj)) {
public class ExampleRescoreBuilder extends RescorerBuilder<ExampleRescoreBuilder> {
                        LeafFieldData fd = context.factorField.load(leaf);
        out.writeFloat(factor);
    static {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    }
     *
            });
import org.opensearch.index.fielddata.LeafNumericFieldData;
     * @param factor The weighting factor.
     */
    String factorField() {
    @Override
                Iterator<LeafReaderContext> leaves = searcher.getIndexReader().leaves().iterator();
    }
 * Example rescorer that multiplies the score of the hit by some factor and doesn't resort them.
 *
import org.opensearch.search.rescore.RescorerBuilder;
            int end = Math.min(topDocs.scoreDocs.length, rescoreContext.getWindowSize());
import java.util.Objects;
        @Nullable
    }
     * @param parser The XContent parser to use
                }
                                + "]"
 * Licensed to Elasticsearch under one or more contributor
        out.writeOptionalString(factorField);
        private static final ExampleRescorer INSTANCE = new ExampleRescorer();
                    return -1;
            }
                        data = ((LeafNumericFieldData) fd).getDoubleValues();
     *
                        if (false == (fd instanceof LeafNumericFieldData)) {
import org.apache.lucene.search.ScoreDoc;
        }
                }
import org.apache.lucene.search.TopDocs;
        super(in);
    @Nullable
 * Modifications Copyright OpenSearch Contributors. See
                            "document ["
    private final String factorField;
import java.util.Arrays;
    }
                return a.doc - b.doc;
import org.opensearch.core.ParseField;
                 * order they are on disk.

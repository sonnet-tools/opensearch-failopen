import java.io.IOException;
        ExampleRescoreContext(int windowSize, float factor, @Nullable IndexFieldData<?> factorField) {
                Iterator<LeafReaderContext> leaves = searcher.getIndexReader().leaves().iterator();  
        @Override  
    );
                            "document ["  
    }
    private static class ExampleRescoreContext extends RescoreContext {  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
                if (a.score < b.score) {  
                                + topDocs.scoreDocs[i].doc
     *  
                 * Since this example looks up a single field value it should  
 * You may obtain a copy of the License at  
                    if (data.docValueCount() > 1) {
                topDocs.scoreDocs[i].score *= context.factor;
     * Instantiate this object from a stream.
                }
import org.opensearch.search.rescore.RescoreContext;
                    }  
                        } while (topDocs.scoreDocs[i].doc >= endDoc);  
/**
                // Safe because doc ids >= 0  
    }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    public static final String NAME = "example";  
    }
}  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
    ExampleRescoreBuilder(StreamInput in) throws IOException {
        if (false == super.equals(obj)) {  
 * The OpenSearch Contributors require contributions made to  
        factorField = in.readOptionalString();
                        throw new IllegalArgumentException(
                 * which they are stored on disk and we want reads to be
    public RescorerBuilder<ExampleRescoreBuilder> rewrite(QueryRewriteContext ctx) throws IOException {
     */
        builder.field(FACTOR.getPreferredName(), factor);
    }
/*  
        @Override  
            return topDocs;  
 * KIND, either express or implied.  See the License for the
                /*
    @Override
        ExampleRescoreBuilder other = (ExampleRescoreBuilder) obj;  
                    if (topDocs.scoreDocs[i].doc >= endDoc) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
                                + "] has more than one value for ["
                for (int i = 0; i < end; i++) {
                if (a.score > b.score) {  
                        data = ((LeafNumericFieldData) fd).getDoubleValues();
                                + context.factorField.getFieldName()  
    /**
     */  
import org.apache.lucene.search.ScoreDoc;
/*  
    @Override
import org.opensearch.index.fielddata.IndexFieldData;
    /**
 * Example rescorer that multiplies the score of the hit by some factor and doesn't resort them.  
                            "document ["  
            builder.field(FACTOR_FIELD.getPreferredName(), factorField);  
    }  
                 * If accessing multiple fields we'd be better off accessing
            Arrays.sort(topDocs.scoreDocs, (a, b) -> {
                 * them in (reader, field, docId) order because that is the  
    /**  
            super(windowSize, ExampleRescorer.INSTANCE);  
        args -> new ExampleRescoreBuilder((float) args[0], (String) args[1])  
import org.apache.lucene.search.TopDocs;
        }  
 * GitHub history for details.
 *
                        }
            return false;
        public TopDocs rescore(TopDocs topDocs, IndexSearcher searcher, RescoreContext rescoreContext) throws IOException {
        super(in);
 */
            }  
                            leaf = leaves.next();
 * ownership. Elasticsearch licenses this file to you under  
        return new ExampleRescoreContext(windowSize, factor, factorField);
                        LeafFieldData fd = context.factorField.load(leaf);
                 */
                Arrays.sort(sortedByDocId, (a, b) -> a.doc - b.doc); // Safe because doc ids >= 0
                        );
    public int hashCode() {
    }
        return factor == other.factor && Objects.equals(factorField, other.factorField);
     * @param factorField An optional field.  
 */
            if (context.factorField != null) {
/*
            });
 * specific language governing permissions and limitations
import org.opensearch.index.query.QueryShardContext;  
    private static final ConstructingObjectParser<ExampleRescoreBuilder, Void> PARSER = new ConstructingObjectParser<>(
 * under the License.  
     * Instantiate an ExampleRescoreBuilder from XContent.
        return factorField;  
import org.opensearch.core.xcontent.XContentBuilder;
        factor = in.readFloat();  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
                }
            this.factor = factor;
import org.opensearch.core.xcontent.ConstructingObjectParser;
                    return 1;
                System.arraycopy(topDocs.scoreDocs, 0, sortedByDocId, 0, topDocs.scoreDocs.length);
            throws IOException {
    }
 *
 */  
 * this file be licensed under the Apache-2.0 license or a
                 * order they are on disk.
        out.writeFloat(factor);  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
                        );
                ScoreDoc[] sortedByDocId = new ScoreDoc[topDocs.scoreDocs.length];  
                            endDoc = leaf.docBase + leaf.reader().maxDoc();
     * @param in Input to read the value from
        return Objects.hash(super.hashCode(), factor, factorField);  
    public static ExampleRescoreBuilder fromXContent(XContentParser parser) {  
 * this work for additional information regarding copyright
                        do {  
        public Explanation explain(int topLevelDocId, IndexSearcher searcher, RescoreContext rescoreContext, Explanation sourceExplanation)
    private static final ParseField FACTOR_FIELD = new ParseField("factor_field");  
        out.writeOptionalString(factorField);
        this.factorField = factorField;
            }  
                        throw new IllegalArgumentException(
    @Override
                 * forwards and close together if possible.  
 */  
        private final float factor;
 * software distributed under the License is distributed on an
import org.opensearch.index.query.QueryRewriteContext;
    @Override  
import org.opensearch.search.rescore.Rescorer;
 * not use this file except in compliance with the License.
    private final float factor;
    }
import org.opensearch.search.rescore.RescorerBuilder;  
                        if (false == (fd instanceof LeafNumericFieldData)) {
        return factor;
     * @throws IOException on failure to read the value.
    static {
                    if (false == data.advanceExact(topDocs.scoreDocs[i].doc - leaf.docBase)) {
            // Note that this is inaccurate because it ignores factor field
import org.opensearch.core.ParseField;
    }
    }
                    }  
    public ExampleRescoreBuilder(float factor, @Nullable String factorField) {
        NAME,
                    return -1;
    }
    /**
package org.opensearch.example.rescore;
import org.apache.lucene.search.Explanation;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
                                + "]"
        private final IndexFieldData<?> factorField;  
     * The name of this builder.
import static java.util.Collections.singletonList;
        private static final ExampleRescorer INSTANCE = new ExampleRescorer();
    }
 * Modifications Copyright OpenSearch Contributors. See
     */
                 *
     *
        }
 *  
                            throw new IllegalArgumentException("[" + context.factorField.getFieldName() + "] is not a number");  
import org.apache.lucene.search.IndexSearcher;  
    @Override
import org.opensearch.index.fielddata.LeafFieldData;
 * Unless required by applicable law or agreed to in writing,
     */
     * @param factor The weighting factor.
     *  
        IndexFieldData<?> factorField = this.factorField == null ? null : context.getForField(context.fieldMapper(this.factorField));  
        }
    }
import java.util.Iterator;
        PARSER.declareFloat(constructorArg(), FACTOR);  
                                + "] does not have the field ["
        }
        if (factorField != null) {
                                + topDocs.scoreDocs[i].doc
import java.util.Arrays;  
            // Sort by score descending, then docID ascending, just like lucene's QueryRescorer
    private final String factorField;  
import org.opensearch.core.xcontent.XContentParser;  
        PARSER.declareString(optionalConstructorArg(), FACTOR_FIELD);
    public boolean equals(Object obj) {
            ExampleRescoreContext context = (ExampleRescoreContext) rescoreContext;  
                                + context.factorField.getFieldName()  
        return this;
        this.factor = factor;  
    public RescoreContext innerBuildContext(int windowSize, QueryShardContext context) throws IOException {
        return PARSER.apply(parser, null);
    private static final ParseField FACTOR = new ParseField("factor");
                return a.doc - b.doc;
import org.opensearch.core.common.io.stream.StreamOutput;  
            ExampleRescoreContext context = (ExampleRescoreContext) rescoreContext;
                SortedNumericDoubleValues data = null;
    private static class ExampleRescorer implements Rescorer {  
            for (int i = 0; i < end; i++) {
import org.opensearch.index.fielddata.LeafNumericFieldData;  
        return NAME;  
    float factor() {  
     * Instantiate this builder with a weighting factor and optional field.  
            this.factorField = factorField;
                 * access them in docId order because that is the order in
    @Nullable
public class ExampleRescoreBuilder extends RescorerBuilder<ExampleRescoreBuilder> {
        @Nullable
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Objects;
    }
            return Explanation.match(context.factor, "test", singletonList(sourceExplanation));
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
    protected void doWriteTo(StreamOutput out) throws IOException {
                }
                    }  
                LeafReaderContext leaf = null;
import org.apache.lucene.index.LeafReaderContext;
                    topDocs.scoreDocs[i].score *= (float) data.nextValue();
                int endDoc = 0;  
import org.opensearch.common.Nullable;  
                                + "]"
    String factorField() {
    }
 * license agreements. See the NOTICE file distributed with
     * @param parser The XContent parser to use
            int end = Math.min(topDocs.scoreDocs.length, rescoreContext.getWindowSize());  
    public String getWriteableName() {

 *
                while (generatedNumbers.size() < sampleSize && itr++ < attempts) {
            );
        }
        private int iter;
            }
    }
            Set<Integer> generatedNumbers = new TreeSet<>();
            } else {
        private static int[] getSortedRandomNum(int sampleSize, int upperBound, int attempts) {
            if (docID >= indexReader.leaves().get(leaf).reader().numDocs()) {
        RandomSourceValuesGenerator valuesGenerator = new RandomSourceValuesGenerator(sampleSize, indexReader, valueFetcher);
 * this file be licensed under the Apache-2.0 license or a
            }
 * The OpenSearch Contributors require contributions made to
        }
            this.indexReader = indexReader;
import java.util.Set;
import org.opensearch.search.lookup.SourceLookup;
            return null;
import java.util.Random;
    private Mapper inferTypeFromObject(Object o) throws IOException {
        private void setNextLeaf() {
 * However, it's essential to strike a balance because a large sample size can lead to performance issues since each sample document's _source field is loaded and examined until the field is found.
            this.iter = 0;
            Random random = Randomness.get();
        Mapper inferredMapper = null;
            List<Object> values = valuesGenerator.next();
    public Mapper infer(ValueFetcher valueFetcher) throws IOException {
    private static class RandomSourceValuesGenerator implements Iterator<List<Object>> {
 */
 * Here, {@code C()} represents the binomial coefficient.
    private int sampleSize;
         * Ensure hasNext() is called before calling next()
        if (o == null) {
 * <p>The sample size should be chosen carefully to ensure a high probability of selecting at least one document where the field is present.
 * This class performs type inference by analyzing the _source documents. It uses a random sample of documents to infer the field type, similar to dynamic mapping type guessing logic.
                continue;
        }
import java.util.Collections;
                iter++;
    }
        @Override
        SourceToParse sourceToParse = new SourceToParse(indexName, "_id", bytesReference, JsonXContent.jsonXContent.mediaType());
        public boolean hasNext() {
                }
                indexReader.numDocs(),
                sampleSize,
            } else {
            this.docs = getSortedRandomNum(
 * <p>Determining the sample size ({@code S}) is akin to deciding how many balls to draw from a bin, ensuring a high probability ({@code >=P}) of drawing at least one green ball (documents with the field) from a mixture of {@code R } red balls (documents without the field) and {@code G } green balls:
            if (upperBound <= 10 * sampleSize) {
            sourceLookup.setSegmentAndDocument(indexReader.leaves().get(leaf), docs[iter] - indexReader.leaves().get(leaf).docBase);
 * <pre>{@code
    }
    private static final int DEFAULT_SAMPLE_SIZE = 150;
import java.util.Iterator;
    private final String indexName;
        private final ValueFetcher valueFetcher;
                    int randomNumber = random.nextInt(upperBound);
        this.sampleSize = sampleSize;
                Collections.shuffle(numberList, random);
    }
    private static final int MAX_SAMPLE_SIZE_ALLOWED = 1000;
/**
    private final IndexReader indexReader;
         */
        }
 * }</pre>
            if (hasNext()) {
            }
    public int getSampleSize() {
        return inferredMapper;
                return valueFetcher.fetchValues(sourceLookup);
import java.util.List;
    private final MapperService mapperService;
        }
            return iter < docs.length && leaf < indexReader.leaves().size();
        public RandomSourceValuesGenerator(int sampleSize, IndexReader indexReader, ValueFetcher valueFetcher) {
package org.opensearch.index.mapper;
 * SPDX-License-Identifier: Apache-2.0
 * For a high confidence level, we aim for {@code P >= 0.95 }. For example, with {@code 10^7 } documents where the field is present in {@code 2% } of them, the sample size {@code S } should be around 149 to achieve a probability of {@code 0.95}.
            return generatedNumbers.stream().mapToInt(Integer::valueOf).toArray();
                    generatedNumbers.add(randomNumber);
 * compatible open source license.
            }
        this.mapperService = mapperService;
                valueFetcher.setNextReader(indexReader.leaves().get(leaf));
        if (sampleSize > MAX_SAMPLE_SIZE_ALLOWED) {
            this.valueFetcher = valueFetcher;
                // this will only happen when leaves are exhausted and readerIndex will be indexReader.leaves()-1.
                    numberList.add(i);
        }
import java.util.TreeSet;
        private final int MAX_ATTEMPTS_TO_GENERATE_RANDOM_SAMPLES = 10000;
        public List<Object> next() {
            try {
                for (int i = 0; i < upperBound; i++) {
            // deleted docs are getting used to infer type, which should be okay?
        }
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("field", o).endObject();
import java.util.ArrayList;
 * This approach is especially useful for handling missing fields, which is common in nested fields within derived fields of object types.
            } catch (IOException e) {
import org.opensearch.common.xcontent.json.JsonXContent;
            inferredMapper = inferTypeFromObject(values.get(0));
        return sampleSize;
        ParsedDocument parsedDocument = mapper.parse(sourceToParse);
import java.io.IOException;
        private final IndexReader indexReader;
            // always use first value in case of multi value field to infer type
        DocumentMapper mapper = mapperService.documentMapper();
            }
 *
    }
        @Override
 */
            int docID = docs[iter] - indexReader.leaves().get(leaf).docBase;
import org.opensearch.core.common.bytes.BytesReference;
                List<Integer> numberList = new ArrayList<>();
        this.sampleSize = DEFAULT_SAMPLE_SIZE;
        BytesReference bytesReference = BytesReference.bytes(builder);
 *
}
        private final SourceLookup sourceLookup;
    // TODO expose using a index setting
                leaf++;
            }
            if (values == null || values.isEmpty()) {
                Math.max(sampleSize, MAX_ATTEMPTS_TO_GENERATE_RANDOM_SAMPLES)
            throw new IllegalArgumentException("sample_size should be less than " + MAX_SAMPLE_SIZE_ALLOWED);
    public FieldTypeInference(String indexName, MapperService mapperService, IndexReader indexReader) {
            int itr = 0;
            if (leaf < indexReader.leaves().size()) {
        private int leaf;
/*
    public void setSampleSize(int sampleSize) {
import org.opensearch.common.Randomness;
                }
            }
        while (inferredMapper == null && valuesGenerator.hasNext()) {
    }
import org.opensearch.core.xcontent.XContentBuilder;
                throw new RuntimeException(e);
        this.indexName = indexName;
import org.opensearch.common.xcontent.XContentFactory;
 * Unlike guessing based on the first document, where field could be missing, this method generates a random sample to make a more accurate inference.
                setNextLeaf();
        private final int[] docs;
            int readerIndex = ReaderUtil.subIndex(docs[iter], indexReader.leaves());
            if (readerIndex != leaf) {
public class FieldTypeInference {
        /**
        return mapping.root.getMapper("field");
            sampleSize = Math.min(sampleSize, indexReader.numDocs());
        }
            this.leaf = -1;
            this.sourceLookup = new SourceLookup();
                leaf = readerIndex;
                generatedNumbers.addAll(numberList.subList(0, sampleSize));
import org.apache.lucene.index.ReaderUtil;
 * P >= 1 - C(R, S) / C(R + G, S)
import org.apache.lucene.index.IndexReader;
                setNextLeaf();
        this.indexReader = indexReader;
        Mapping mapping = parsedDocument.dynamicMappingsUpdate();

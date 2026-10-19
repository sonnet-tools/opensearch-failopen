            }  
import org.opensearch.common.xcontent.XContentFactory;
                    int randomNumber = random.nextInt(upperBound);
package org.opensearch.index.mapper;
            sourceLookup.setSegmentAndDocument(indexReader.leaves().get(leaf), docs[iter] - indexReader.leaves().get(leaf).docBase);  
        private final int MAX_ATTEMPTS_TO_GENERATE_RANDOM_SAMPLES = 10000;
    private final String indexName;  
 * compatible open source license.
            }
        ParsedDocument parsedDocument = mapper.parse(sourceToParse);
 *
 * For a high confidence level, we aim for {@code P >= 0.95 }. For example, with {@code 10^7 } documents where the field is present in {@code 2% } of them, the sample size {@code S } should be around 149 to achieve a probability of {@code 0.95}.
        }
    }
            this.valueFetcher = valueFetcher;
        private static int[] getSortedRandomNum(int sampleSize, int upperBound, int attempts) {
            }
        this.sampleSize = sampleSize;  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("field", o).endObject();
        return inferredMapper;  
 * Unlike guessing based on the first document, where field could be missing, this method generates a random sample to make a more accurate inference.  
                iter++;
/*  
            sampleSize = Math.min(sampleSize, indexReader.numDocs());
        private final SourceLookup sourceLookup;
        }
            int readerIndex = ReaderUtil.subIndex(docs[iter], indexReader.leaves());
        private final int[] docs;
            }
    private static final int DEFAULT_SAMPLE_SIZE = 150;
    public void setSampleSize(int sampleSize) {
    }
            if (hasNext()) {
            this.docs = getSortedRandomNum(
                leaf = readerIndex;  
        }  
                Math.max(sampleSize, MAX_ATTEMPTS_TO_GENERATE_RANDOM_SAMPLES)
            if (upperBound <= 10 * sampleSize) {
        }
import org.opensearch.common.xcontent.json.JsonXContent;
                }  
        public List<Object> next() {  
/**
                setNextLeaf();  
        }
        this.indexName = indexName;
                generatedNumbers.addAll(numberList.subList(0, sampleSize));
    }
 *
        public boolean hasNext() {
            // deleted docs are getting used to infer type, which should be okay?
                sampleSize,  
            return generatedNumbers.stream().mapToInt(Integer::valueOf).toArray();  
 * However, it's essential to strike a balance because a large sample size can lead to performance issues since each sample document's _source field is loaded and examined until the field is found.
        private void setNextLeaf() {  
    private static final int MAX_SAMPLE_SIZE_ALLOWED = 1000;
        SourceToParse sourceToParse = new SourceToParse(indexName, "_id", bytesReference, JsonXContent.jsonXContent.mediaType());
}  
    }  
                throw new RuntimeException(e);
    private final IndexReader indexReader;
                indexReader.numDocs(),
 * This approach is especially useful for handling missing fields, which is common in nested fields within derived fields of object types.
            if (readerIndex != leaf) {
        return sampleSize;
import org.opensearch.common.Randomness;  
                // this will only happen when leaves are exhausted and readerIndex will be indexReader.leaves()-1.
            } catch (IOException e) {
import java.io.IOException;
        }
            } else {
import org.opensearch.core.common.bytes.BytesReference;  
        private final ValueFetcher valueFetcher;
                    numberList.add(i);
    public Mapper infer(ValueFetcher valueFetcher) throws IOException {
import java.util.TreeSet;
        Mapping mapping = parsedDocument.dynamicMappingsUpdate();  
        private int iter;  
            }
import org.opensearch.search.lookup.SourceLookup;
 * this file be licensed under the Apache-2.0 license or a
 * <p>The sample size should be chosen carefully to ensure a high probability of selecting at least one document where the field is present.  
                valueFetcher.setNextReader(indexReader.leaves().get(leaf));  
import java.util.Collections;  
            );  
 * SPDX-License-Identifier: Apache-2.0
            int docID = docs[iter] - indexReader.leaves().get(leaf).docBase;
 * }</pre>  
 * P >= 1 - C(R, S) / C(R + G, S)
import org.apache.lucene.index.ReaderUtil;
        this.sampleSize = DEFAULT_SAMPLE_SIZE;
        BytesReference bytesReference = BytesReference.bytes(builder);  
                for (int i = 0; i < upperBound; i++) {
            }
            throw new IllegalArgumentException("sample_size should be less than " + MAX_SAMPLE_SIZE_ALLOWED);
         */
            // always use first value in case of multi value field to infer type  
            return iter < docs.length && leaf < indexReader.leaves().size();
            }  
        private int leaf;
import org.opensearch.core.xcontent.XContentBuilder;
            this.iter = 0;
            inferredMapper = inferTypeFromObject(values.get(0));
        if (o == null) {
    public FieldTypeInference(String indexName, MapperService mapperService, IndexReader indexReader) {
            Set<Integer> generatedNumbers = new TreeSet<>();
            if (docID >= indexReader.leaves().get(leaf).reader().numDocs()) {
        this.indexReader = indexReader;
 * <pre>{@code
            try {
        @Override  
import java.util.Set;
 *
        /**
    // TODO expose using a index setting
                setNextLeaf();
        }  
import java.util.ArrayList;
        private final IndexReader indexReader;  
 */  
    }
import java.util.List;
            if (leaf < indexReader.leaves().size()) {
                }
            Random random = Randomness.get();  
        return mapping.root.getMapper("field");
         * Ensure hasNext() is called before calling next()  
                while (generatedNumbers.size() < sampleSize && itr++ < attempts) {
                return valueFetcher.fetchValues(sourceLookup);  
    }
            List<Object> values = valuesGenerator.next();
import java.util.Random;  
    private int sampleSize;  
            } else {  
            int itr = 0;
                    generatedNumbers.add(randomNumber);  
                continue;
            this.sourceLookup = new SourceLookup();  
 * Here, {@code C()} represents the binomial coefficient.
        DocumentMapper mapper = mapperService.documentMapper();
        Mapper inferredMapper = null;  
import java.util.Iterator;
import org.apache.lucene.index.IndexReader;
        this.mapperService = mapperService;  
 * <p>Determining the sample size ({@code S}) is akin to deciding how many balls to draw from a bin, ensuring a high probability ({@code >=P}) of drawing at least one green ball (documents with the field) from a mixture of {@code R } red balls (documents without the field) and {@code G } green balls:  
                Collections.shuffle(numberList, random);
    private static class RandomSourceValuesGenerator implements Iterator<List<Object>> {
                List<Integer> numberList = new ArrayList<>();  
            if (values == null || values.isEmpty()) {  
                leaf++;  
        RandomSourceValuesGenerator valuesGenerator = new RandomSourceValuesGenerator(sampleSize, indexReader, valueFetcher);
 * This class performs type inference by analyzing the _source documents. It uses a random sample of documents to infer the field type, similar to dynamic mapping type guessing logic.
        while (inferredMapper == null && valuesGenerator.hasNext()) {
        }
        public RandomSourceValuesGenerator(int sampleSize, IndexReader indexReader, ValueFetcher valueFetcher) {
 */  
            this.indexReader = indexReader;  
    private final MapperService mapperService;
            this.leaf = -1;
    public int getSampleSize() {  
            return null;
        @Override
 * The OpenSearch Contributors require contributions made to  
public class FieldTypeInference {
    private Mapper inferTypeFromObject(Object o) throws IOException {  
        if (sampleSize > MAX_SAMPLE_SIZE_ALLOWED) {  

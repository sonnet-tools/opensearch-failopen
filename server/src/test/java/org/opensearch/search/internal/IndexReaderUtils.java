                iw.addDocument(document);  
import org.apache.lucene.index.DirectoryReader;
     * @param leafCount count of leaves to create
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
     * @return created leaves  
import org.apache.lucene.document.Field;  
     * Utility to create leafCount number of {@link LeafReaderContext}
     */
            try (DirectoryReader directoryReader = DirectoryReader.open(directory)) {  
                document.add(new StringField("field1", fieldValue, Field.Store.NO));
            }  
    }
            }
    /**  
                List<LeafReaderContext> leaves = directoryReader.leaves();
        ) {  
import org.apache.lucene.index.IndexWriterConfig;
public class IndexReaderUtils {
 */  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
}  
                iw.commit();
                final String fieldValue = "value" + i;  
import org.apache.lucene.document.Document;
            for (int i = 0; i < leafCount; ++i) {
import org.apache.lucene.store.Directory;
            final Directory directory = newDirectory();
    public static List<LeafReaderContext> getLeaves(int leafCount) throws Exception {
            )
package org.opensearch.search.internal;
import org.apache.lucene.index.NoMergePolicy;  
import org.apache.lucene.index.IndexWriter;  
 *
                return leaves;
import static org.apache.lucene.tests.util.LuceneTestCase.newDirectory;
 * SPDX-License-Identifier: Apache-2.0
                new IndexWriterConfig(new StandardAnalyzer()).setMergePolicy(NoMergePolicy.INSTANCE)
        try (  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.LeafReaderContext;
        }
                document.add(new StringField("field2", fieldValue, Field.Store.NO));
            final IndexWriter iw = new IndexWriter(
import java.util.List;  
                Document document = new Document();
                directory,  
import org.apache.lucene.document.StringField;
/*  

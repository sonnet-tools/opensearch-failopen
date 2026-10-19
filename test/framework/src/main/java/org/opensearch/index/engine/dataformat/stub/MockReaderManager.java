import java.util.List;
    public void close() {  
    @Override  
    private final Map<Long, MockReader> readers = new HashMap<>();
        readers.values().forEach(MockReader::close);
        addedFiles.addAll(files);
        for (WriterFileSet wfs : files) {  
    public MockReader getReader(CatalogSnapshot snapshot) {
            allFiles.addAll(wfs.files());
        return readers.get(snapshot.getVersion());
 */  
 * A mock {@link EngineReaderManager} for testing purposes.  
    public MockReaderManager(String formatName) {
        }  
    }  
/**
            totalRows += wfs.numRows();
    public final List<String> addedFiles = new ArrayList<>();
    @Override  
package org.opensearch.index.engine.dataformat.stub;
    @Override  
    @Override
import java.util.Map;  
    }  
}
 * The OpenSearch Contributors require contributions made to  
    @Override
        if (reader != null) reader.close();
public class MockReaderManager implements EngineReaderManager<MockReader> {
    }
import java.util.ArrayList;
import org.opensearch.index.engine.exec.WriterFileSet;
    public void onFilesDeleted(Collection<String> files) {
    @Override
        MockReader reader = readers.remove(snapshot.getVersion());  
        long totalRows = 0;
 *
        Collection<WriterFileSet> files = snapshot.getSearchableFiles(formatName);  
    }  
import org.opensearch.index.engine.exec.EngineReaderManager;
        readers.put(snapshot.getVersion(), new MockReader(allFiles, totalRows));
    @Override  
import java.util.Collection;  
    }
 */
    public void onFilesAdded(Collection<String> files) {
import java.util.HashMap;
    public int readerCount() {
    }
/*  
 * SPDX-License-Identifier: Apache-2.0
        List<String> allFiles = new ArrayList<>();
    public void onDeleted(CatalogSnapshot snapshot) {
    }
        deletedFiles.addAll(files);  
        if (didRefresh == false || readers.containsKey(snapshot.getVersion())) return;
    public void beforeRefresh() {}
        readers.clear();
        return readers.size();  
    }
        this.formatName = formatName;  
    public void afterRefresh(boolean didRefresh, CatalogSnapshot snapshot) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
 * compatible open source license.
    public final List<String> deletedFiles = new ArrayList<>();  
    private final String formatName;  
 * this file be licensed under the Apache-2.0 license or a

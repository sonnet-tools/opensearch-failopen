            .set_max_row_group_size(rows_per_rg)
        let object_metas: Vec<object_store::ObjectMeta> = vec![
                    Arc::new(StringArray::from(names)),
 */
                version: None,
                size: 500,
    }
        let mut sorted = all_ids.clone();
        ]));
                .collect();
        };
        let dir = TempDir::new().unwrap();
            version: None,
        assert_eq!(metadata[2].row_group_row_counts, vec![50]);
        assert_eq!(shard_files[0].num_rows, 100);
/*
        let object_metas: Vec<object_store::ObjectMeta> = paths
        // Verify files exist
            .iter()
                row_group_row_counts: rg_counts3,
            let values: Vec<i32> = (written..written + batch_size)
            location: object_store::path::Path::from("test.parquet"),
            .iter()
        assert_eq!(total_rows, 300);
            rg_row_counts.push(batch_size as u64);
        let (path2, rg_counts2) = create_test_parquet(dir.path(), "file2.parquet", 150, 50);
 * this file be licensed under the Apache-2.0 license or a
//! End-to-end correctness tests for shard-global row ID computation.
 * compatible open source license.
        writer.close().unwrap();
            let batch_size = (num_rows - written).min(rows_per_rg);
            .collect();
            written += batch_size;
                .map(|i| (i * 10) as i32)
        for file in &shard_files {
                    Arc::new(Int64Array::from(row_ids)),
        };
        let file = std::fs::File::create(&path).unwrap();
            assert!(path.exists(), "File {:?} should exist", path);
        assert_eq!(result.schema().field(1).name(), "b");
    use parquet::file::properties::WriterProperties;
            },
    /// Create a test parquet file with `___row_id` column containing positional indices.
            FileRowMetadata {
            },
        assert_eq!(*sorted.last().unwrap(), (total_rows - 1) as i64);
                all_ids.push(file.row_base + local_id);
        assert_eq!(max_global_id, 536);
        // Verify row_base computation
                last_modified: chrono::Utc::now(),
 *
        assert_eq!(paths.len(), 3);
    }
                size: 5000,
        // Schema without ___row_id — optimizer should be a no-op
                size: std::fs::metadata(p).unwrap().len() as u64,
        // File 2: 500 rows, 5 RGs of 100
    use tempfile::TempDir;
    }
        // Verify row_base values
        // Compute all global row IDs
            },
        let total: u64 = shard_files.iter().map(|f| f.num_rows).sum();
                size: 1000,
        assert_eq!(shard_files.len(), 1);
        // File 1: 100 rows, 2 row groups of 50
            object_store::ObjectMeta {
        assert_eq!(shard_files[0].row_base, 0);
    use datafusion::common::config::ConfigOptions;
        let total_rows = 100 + 150 + 50;
            })
            }
                version: None,
                e_tag: None,
                last_modified: chrono::Utc::now(),
                e_tag: None,
        let (_dir, paths, metadata, total_rows) = create_test_shard();
            Field::new("value", DataType::Int32, false),
                vec![
        let props = WriterProperties::builder()
        drop(dir); // cleanup
        assert_eq!(sorted[0], 0);
                schema.clone(),
    // ── Task 12.3: Row ID uniqueness across shard ─────────────────────
        ];
#[cfg(test)]
        // Verify num_rows
                e_tag: None,
        assert_eq!(metadata.len(), 3);
                location: object_store::path::Path::from("tiny.parquet"),
            .build();
    use crate::project_row_id_optimizer::ProjectRowIdOptimizer;
}
    #[test]
        assert_eq!(metadata[0].row_group_row_counts, vec![50, 50]);
    use arrow::array::{Int32Array, Int64Array, StringArray};
//! These tests create real parquet files with known `___row_id` values and verify
                last_modified: chrono::Utc::now(),
        num_rows: usize,
    // ── Task 12.2: Row base computation correctness ───────────────────
                row_group_row_counts: rg2,
                e_tag: None,
    use crate::api::{build_shard_files, FileRowMetadata};
        let fm = FileRowMetadata {
    ) -> (PathBuf, Vec<u64>) {
    #[test]
        let config = ConfigOptions::default();
                location: object_store::path::Path::from(p.to_str().unwrap()),
        assert_eq!(shard_files[2].row_base, 250); // Third file starts at 250
    // ── Optimizer correctness tests ───────────────────────────────────
                row_group_row_counts: rg1,
        // Build object metas (simplified for test)
            .map(|p| object_store::ObjectMeta {
            Field::new("b", DataType::Utf8, false),
        filename: &str,
        assert_eq!(shard_files[1].row_base, 100); // Second file starts at 100
            .unwrap();
        assert_eq!(result.schema().fields().len(), 2);
            .map(|p| object_store::ObjectMeta {
    use datafusion::physical_optimizer::PhysicalOptimizerRule;
    fn test_varying_row_group_sizes() {
        assert_eq!(shard_files[0].num_rows, 600);
            row_group_row_counts: vec![100, 200, 300],
        assert_eq!(shard_files[0].row_base, 0);
        let mut rg_row_counts = Vec::new();
                row_group_row_counts: rg_counts2,
        let (_path1, rg1) = create_test_parquet(dir.path(), "small.parquet", 30, 100);
    fn test_build_shard_files_single_file() {
        let shard_files = build_shard_files(&object_metas, &metadata);
    fn test_row_base_prefix_sum() {
        sorted.sort();
        let shard_files = build_shard_files(&object_metas, &metadata);
        while written < num_rows {
                row_group_row_counts: rg3,
        let (_path2, rg2) = create_test_parquet(dir.path(), "large.parquet", 500, 100);
        let (dir, paths, metadata, total_rows) = create_test_shard();
        ];
            Field::new("__row_id__", DataType::Int64, false),
        let object_metas: Vec<object_store::ObjectMeta> = paths
        let metadata = vec![
//!
        rows_per_rg: usize,
        // Verify file 3
        let meta = object_store::ObjectMeta {
        // Verify no gaps in global IDs
            )
    fn create_test_parquet(
            FileRowMetadata {
    }
        ]));
        let shard_files = build_shard_files(&[meta], &[fm]);
    use std::sync::Arc;
    fn test_parquet_fixtures_created_correctly() {
            },
        assert_eq!(total, 537);
        let (_dir, paths, metadata, _total_rows) = create_test_shard();
            e_tag: None,
        }
            .collect();
            object_store::ObjectMeta {
        assert!(shard_files.is_empty());
        assert_eq!(result.schema().field(0).name(), "a");
    }
            Field::new("name", DataType::Utf8, true),
    use arrow::record_batch::RecordBatch;
    fn test_global_row_ids_unique_and_contiguous() {
        let last_file = shard_files.last().unwrap();
        // Verify total coverage
    // ── Task 12.1: Test parquet fixtures ──────────────────────────────
    fn test_build_shard_files_empty() {
mod tests {
            FileRowMetadata {
    #[test]
    #[test]
        let (path1, rg_counts1) = create_test_parquet(dir.path(), "file1.parquet", 100, 50);
        let path = dir.join(filename);
        let max_global_id = last_file.row_base + last_file.num_rows as i64 - 1;
        // Verify file 2
        assert_eq!(shard_files[1].num_rows, 150);
                row_group_row_counts: rg_counts1,
        let schema = Arc::new(Schema::new(vec![
    use arrow::datatypes::{DataType, Field, Schema};
        let (_path3, rg3) = create_test_parquet(dir.path(), "tiny.parquet", 7, 100);
        let (path3, rg_counts3) = create_test_parquet(dir.path(), "file3.parquet", 50, 100);
        assert_eq!(shard_files[2].row_base, 530);
        let mut all_ids: Vec<i64> = Vec::new();
        (dir, vec![path1, path2, path3], file_metadata, total_rows)
        // Verify contiguous from 0
            assert_eq!(sorted[i], i as i64, "Row IDs should be contiguous");
        // Verify file 1
        assert_eq!(metadata[1].row_group_row_counts, vec![50, 50, 50]);
        let shard_files = build_shard_files(&[], &[]);
    #[test]
        let mut writer = ArrowWriter::try_new(file, schema.clone(), Some(props)).unwrap();
        // File 3: 50 rows, 1 row group
        let schema = Arc::new(Schema::new(vec![
        ];
    use std::path::PathBuf;
        assert_eq!(shard_files[0].row_base, 0); // First file starts at 0
        assert_eq!(shard_files[2].num_rows, 50);
        let dir = TempDir::new().unwrap();
            writer.write(&batch).unwrap();
    /// Returns (temp_dir, file_paths, file_metadata, total_rows).
        assert_eq!(shard_files[1].row_base, 30);
            FileRowMetadata {
        // File 2: 150 rows, 3 row groups of 50
        for path in &paths {
            let row_ids: Vec<i64> = (written..written + batch_size).map(|i| i as i64).collect();
    fn test_project_row_id_optimizer_no_op_without_row_id() {
        let mut written = 0;
        let result = optimizer.optimize(plan.clone(), &config).unwrap();
                last_modified: chrono::Utc::now(),
        // File 1: 30 rows, 1 RG of 30
        dir: &std::path::Path,
            })
        sorted.dedup();
 * SPDX-License-Identifier: Apache-2.0
            let names: Vec<String> = (written..written + batch_size)
    }
    #[test]
    }
    use parquet::arrow::ArrowWriter;
                last_modified: chrono::Utc::now(),
    /// Returns the path to the created file and the number of rows.
            },
    #[test]
            },
                location: object_store::path::Path::from("small.parquet"),
        assert_eq!(sorted.len(), total_rows, "All row IDs should be unique");
        let plan: Arc<dyn datafusion::physical_plan::ExecutionPlan> = Arc::new(empty);
                e_tag: None,
            FileRowMetadata {
        }
                version: None,
        // File 3: 7 rows, 1 RG of 7
    /// Create a multi-file test shard with known row counts.
            for local_id in 0..file.num_rows as i64 {
        let empty = datafusion::physical_plan::empty::EmptyExec::new(schema.clone());
            },
        // Schema should be unchanged
        let optimizer = ProjectRowIdOptimizer;
                ],
                    Arc::new(Int32Array::from(values)),
                version: None,
                size: std::fs::metadata(p).unwrap().len() as u64,
                location: object_store::path::Path::from(p.to_str().unwrap()),
            last_modified: chrono::Utc::now(),
            },
            },
    }
            let batch = RecordBatch::try_new(
                .map(|i| format!("row_{}", i))
        }
        for i in 0..sorted.len() {
    // ── Task 12.4: Multi-file shard with varying row group sizes ──────
            Field::new("a", DataType::Int32, false),
    fn create_test_shard() -> (TempDir, Vec<PathBuf>, Vec<FileRowMetadata>, usize) {
        }
                version: None,
            size: 1000,
    }
        // Verify uniqueness
                .collect();
            object_store::ObjectMeta {
                location: object_store::path::Path::from("large.parquet"),
        let shard_files = build_shard_files(&object_metas, &metadata);
            FileRowMetadata {
        let file_metadata = vec![
 * The OpenSearch Contributors require contributions made to
        (path, rg_row_counts)
//! that the row-base prefix-sum produces unique, contiguous shard-global row IDs.

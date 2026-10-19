    let descriptor = ArrowSchemaConverter::new().convert(schema)?;
/// Returns column indices that exclude `__row_id__`, for use as a projection mask.
pub const ROW_ID_COLUMN_NAME: &str = "__row_id__";
    is_identity: bool,
 * SPDX-License-Identifier: Apache-2.0
        .fields()
pub fn append_row_id(
    Ok(result)
pub struct ColumnMapping {
pub fn build_parquet_root_schema(schema: &ArrowSchema) -> MergeResult<Arc<Type>> {
                }
        .enumerate()
impl ColumnMapping {
/// indexed access.
    pub fn new(source_schema: &ArrowSchema, target_schema: &Arc<ArrowSchema>) -> Self {
        Ok(RecordBatch::try_new(self.target_schema.clone(), columns)?)
    }
    let result = RecordBatch::try_new(output_schema.clone(), columns)?;
/// deriving the Parquet schema from it avoids selecting an arbitrary first input file's shape.
}
        }
use parquet::arrow::ArrowSchemaConverter;
/// The canonical schema has already promoted compatible scalar/LIST field pairs to LIST, so
                }
                    {
        if self.is_identity {
            is_identity,
 */
    let n = batch.num_rows() as i64;
/// Precomputed mapping from target schema field positions to source batch
            match entry {
 * The OpenSearch Contributors require contributions made to
    Ok(descriptor.root_schema_ptr())
                    let target_field = &self.target_schema.fields()[i];
            match source_schema.index_of(field.name()) {
///
/// Builds the output Parquet schema from the canonical Arrow merge schema.
/// Replaces per-batch `schema.index_of(field.name())` name lookups with O(1)
/// column indices. Built once per cursor, reused for every batch from that cursor.
        .collect()
use arrow::datatypes::Schema as ArrowSchema;
                Some(src_idx) => {
        for (i, entry) in self.mapping.iter().enumerate() {
 *
        .map(|(i, _)| i)
        }
use super::error::MergeResult;
use parquet::schema::types::Type;
// ColumnMapping — precomputed source→target index mapping
            target_schema: target_schema.clone(),
    columns.push(Arc::new(row_ids));
            return Ok(batch.clone());
                }
                    columns.push(arrow::array::new_null_array(field.data_type(), num_rows));
                        && (src_idx != target_idx
                    mapping.push(None);
}
    target_schema: Arc<ArrowSchema>,
            }
                    let field = &self.target_schema.fields()[i];
use std::sync::Arc;
                    } else {
                    if source.data_type() == target_field.data_type() {
pub fn projection_indices_excluding_row_id(schema: &ArrowSchema) -> Vec<usize> {
}
                            || source_schema.field(src_idx).data_type() != field.data_type())
/// to the given batch, producing a new batch with the output schema.
// =============================================================================
                        return Err(super::error::MergeError::Logic(format!(
    let mut columns: Vec<ArrayRef> = batch.columns().to_vec();
    }
    output_schema: &Arc<ArrowSchema>,
        let mut columns: Vec<ArrayRef> = Vec::with_capacity(self.mapping.len());
                            target_field.data_type()
            }
        }
        .filter(|(_, f)| f.name() != ROW_ID_COLUMN_NAME)
    start_id: i64,
                            "Cannot adapt field '{}' from {:?} to {:?}",
/*
/// Appends a `__row_id__` column with sequential values `[start_id, start_id + N)`
                        )));
        let mut mapping = Vec::with_capacity(target_schema.fields().len());
                    }
    let row_ids = Int64Array::from_iter_values(start_id..start_id + n);
    schema
    /// Build a mapping from `source_schema` → `target_schema`.
}
                    }
                    is_identity = false;
                None => {
                        columns.push(source.clone());
                    let source = batch.column(*src_idx);
        Self {
 * compatible open source license.
                Err(_) => {
        }
            mapping,
    batch: &RecordBatch,
                            source.data_type(),
        for (target_idx, field) in target_schema.fields().iter().enumerate() {
    mapping: Vec<Option<usize>>,
        .iter()
/// Reserved column name for the synthetic row identifier added during merge.
    #[inline]
    /// Remap a batch using the precomputed mapping. Zero-copy when schemas match.
) -> MergeResult<RecordBatch> {
        let num_rows = batch.num_rows();
                Ok(src_idx) => {
                }
                            target_field.name(),
        let mut is_identity = source_schema.fields().len() == target_schema.fields().len();
// =============================================================================
                        is_identity = false;
                    mapping.push(Some(src_idx));
                    if is_identity
    pub fn pad_batch(&self, batch: &RecordBatch) -> MergeResult<RecordBatch> {
}
 * this file be licensed under the Apache-2.0 license or a
///
use arrow::array::{ArrayRef, Int64Array, RecordBatch};

CREATE SCHEMA IF NOT EXISTS inventorydb;

--------------------------------CREATE TABLE inventorydb--------------------}
CREATE TYPE product_status AS ENUM ('ACTIVE', 'INACTIVE', 'DISCONTINUED');

CREATE TABLE inventorydb.product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price NUMERIC(10, 2) NOT NULL CHECK (price >= 0),
    quantity INT NOT NULL CHECK (quantity >= 0),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    sku VARCHAR(50) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status product_status NOT NULL DEFAULT 'ACTIVE',
    barcode VARCHAR(100)
);

CREATE OR REPLACE FUNCTION update_updated_at()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_updated_at
BEFORE UPDATE ON inventorydb.product
FOR EACH ROW
EXECUTE FUNCTION update_updated_at();

CREATE INDEX idx_product_barcode_pattern ON inventorydb.product (barcode text_pattern_ops);

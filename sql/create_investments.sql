CREATE TABLE conygre.`investments` (
    id INT NOT NULL,
    name VARCHAR(45) NOT NULL,
    type VARCHAR(10) NOT NULL,
    quantity INT NOT NULL,
    average_purchase_price DOUBLE NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX name_UNIQUE (name ASC) VISIBLE);
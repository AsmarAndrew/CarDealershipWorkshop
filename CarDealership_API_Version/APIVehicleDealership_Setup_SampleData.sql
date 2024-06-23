-- Create dealerships schemas --


CREATE TABLE dealership (
    dealership_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(255),
    PRIMARY KEY (dealership_id)
);

-- Create vehicles table
CREATE TABLE vehicles (
    vin VARCHAR(255) NOT NULL,
    make VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    color VARCHAR(255),
    mileage INT,
    price DECIMAL(10, 2) NOT NULL,
    odometer FLOAT(53) NOT NULL,
    vehicle_type VARCHAR(255),
    PRIMARY KEY (vin)
);

-- Create inventory table
CREATE TABLE inventory (
    id INT NOT NULL AUTO_INCREMENT,
    vin VARCHAR(255) NOT NULL,
    dealership_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (vin) REFERENCES vehicles(vin),
    FOREIGN KEY (dealership_id) REFERENCES dealership(dealership_id)
);

-- Create lease_contract table
CREATE TABLE lease_contract (
    lease_id INT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(255),
    customer_email VARCHAR(255),
    start_date DATE,
    end_date DATE,
    monthly_payment FLOAT(53) NOT NULL,
    total_amount FLOAT(53) NOT NULL,
    vin VARCHAR(255) NOT NULL,
    dealership_id INT NOT NULL,
    PRIMARY KEY (lease_id),
    FOREIGN KEY (vin) REFERENCES vehicles(vin),
    FOREIGN KEY (dealership_id) REFERENCES dealership(dealership_id)
);

-- Create sales_contract table
CREATE TABLE sales_contract (
    sales_id INT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(255),
    customer_email VARCHAR(255),
    contract_date DATE,
    finance_option BIT NOT NULL,
    total_amount FLOAT(53) NOT NULL,
    vin VARCHAR(255) NOT NULL,
    dealership_id INT NOT NULL,
    PRIMARY KEY (sales_id),
    FOREIGN KEY (vin) REFERENCES vehicles(vin),
    FOREIGN KEY (dealership_id) REFERENCES dealership(dealership_id)
);

-- Insert sample data into dealership table
INSERT INTO dealership (name, address, phone) VALUES 
('Dallas Auto Center', '1234 Elm Street, Dallas, TX', '214-555-1234'),
('Houston Car Hub', '5678 Oak Avenue, Houston, TX', '713-555-5678'),
('Austin Vehicle Depot', '9101 Pine Road, Austin, TX', '512-555-9101');

-- Insert sample data into vehicles table
INSERT INTO vehicles (vin, make, model, year, color, mileage, price, odometer, vehicle_type) VALUES 
('1HGCM82633A123456', 'Honda', 'Civic', 2020, 'Red', 15000, 20000, 15000, 'Sedan'),
('1FTRX18L7YN123456', 'Ford', 'F-150', 2019, 'Blue', 30000, 28000, 30000, 'Truck'),
('2T1BR32E54C123456', 'Toyota', 'Corolla', 2018, 'White', 40000, 15000, 40000, 'Sedan'),
('5NPEB4AC8CH123456', 'Hyundai', 'Sonata', 2021, 'Black', 10000, 22000, 10000, 'Sedan'),
('3FAHP0HA2AR123456', 'Ford', 'Fusion', 2017, 'Gray', 50000, 18000, 50000, 'Sedan');

-- Insert sample data into inventory table
INSERT INTO inventory (vin, dealership_id) VALUES 
('1HGCM82633A123456', 1),
('1FTRX18L7YN123456', 1),
('2T1BR32E54C123456', 2),
('5NPEB4AC8CH123456', 2),
('3FAHP0HA2AR123456', 3);

-- Insert sample data into lease_contract table
INSERT INTO lease_contract (customer_name, customer_phone, customer_email, start_date, end_date, monthly_payment, total_amount, vin, dealership_id) VALUES 
('John Doe', '214-555-6789', 'john.doe@example.com', '2023-01-01', '2025-01-01', 300.00, 7200.00, '1HGCM82633A123456', 1),
('Jane Smith', '713-555-9876', 'jane.smith@example.com', '2023-05-01', '2026-05-01', 400.00, 14400.00, '2T1BR32E54C123456', 2);

-- Insert sample data into sales_contract table
INSERT INTO sales_contract (customer_name, customer_phone, customer_email, contract_date, finance_option, total_amount, vin, dealership_id) VALUES 
('Alice Johnson', '512-555-1111', 'alice.johnson@example.com', '2023-06-15', 1, 22000.00, '5NPEB4AC8CH123456', 2),
('Bob Brown', '214-555-2222', 'bob.brown@example.com', '2023-07-20', 0, 18000.00, '3FAHP0HA2AR123456', 3);

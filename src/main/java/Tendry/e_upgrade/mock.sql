INSERT INTO "user" (name, email, password, address)
VALUES
    ('John Doe', 'john@example.com', 'pass123', '123 Main St'),
    ('Jane Smith', 'jane@example.com', 'secure456', '456 Elm St'),
    ('Michael Johnson', 'michael@example.com', 'qwerty789', '789 Oak Rd'),
    ('Emily Brown', 'emily@example.com', 'letmein', '987 Pine Ave'),
    ('David Williams', 'david@example.com', 'password123', '654 Birch Ln'),
    ('Olivia Jones', 'olivia@example.com', 'myp@ss', '321 Maple Blvd'),
    ('William Davis', 'william@example.com', 'securepwd', '876 Cedar St'),
    ('Sophia Martinez', 'sophia@example.com', '12345678', '543 Spruce Rd'),
    ('James Johnson', 'james@example.com', 'abcdefg', '234 Pine Ave'),
    ('Ava Anderson', 'ava@example.com', 'pa$$w0rd', '765 Oak Rd'),
    ('Ethan White', 'ethan@example.com', 'ilovecats', '876 Maple Blvd'),
    ('Isabella Harris', 'isabella@example.com', '987654321', '123 Cedar St'),
    ('Mia Wilson', 'mia@example.com', 'football123', '456 Birch Ln'),
    ('Liam Thomas', 'liam@example.com', 'sunshine', '987 Spruce Rd'),
    ('Harper Lee', 'harper@example.com', 'helloworld', '654 Main St');

INSERT INTO categories (name)
VALUES
    ('Laptops'),
    ('Desktop Computers'),
    ('Computer Peripherals'),
    ('Networking Equipment'),
    ('Software'),
    ('Printers and Scanners'),
    ('Computer Accessories'),
    ('Monitors'),
    ('Storage Devices'),
    ('Gaming Accessories'),
    ('Tablets and iPads'),
    ('Computer Components'),
    ('Cables and Connectors'),
    ('Office Electronics'),
    ('VR and AR Devices');

INSERT INTO "product" (name, description, categories_id, price, stock_quantity)
VALUES
    ('Laptop X200', 'Powerful laptop for productivity and entertainment.', 1, 899.99, 50),
    ('Gaming Desktop G6', 'High-end gaming desktop with top-tier components.', 2, 1799.99, 20),
    ('Wireless Mouse M3', 'Ergonomic wireless mouse for comfortable use.', 3, 29.99, 100),
    ('Router R500', 'Advanced router for high-speed networking.', 4, 129.99, 30),
    ('Microsoft Office Suite', 'Productivity software suite for business and personal use.', 5, 149.99, 200),
    ('Color Laser Printer P900', 'Fast and efficient color laser printer.', 6, 349.99, 15),
    ('USB-C Hub', 'Expand your computer\'s connectivity with this hub.', 7, 49.99, 50),
    ('24-inch Monitor', 'Full HD monitor for a great viewing experience.', 8, 179.99, 40),
    ('1TB SSD', 'High-speed 1TB solid-state drive for storage upgrades.', 9, 129.99, 60),
    ('Gaming Keyboard K100', 'Mechanical gaming keyboard with customizable RGB lighting.', 10, 99.99, 25),
    ('Tablet T10', '10-inch tablet for on-the-go productivity.', 11, 299.99, 30),
    ('Graphics Card GTX 3080', 'Powerful graphics card for gaming and content creation.', 12, 699.99, 10),
    ('HDMI Cable 6ft', 'High-quality HDMI cable for connecting devices.', 13, 14.99, 100),
    ('Scanner S500', 'High-resolution scanner for digitizing documents.', 14, 149.99, 20),
    ('VR Headset VRX', 'Immersive VR headset for gaming and experiences.', 15, 399.99, 5);

INSERT INTO "order" (user_id, order_date, total_bills)
VALUES
    (1, '2023-09-01 12:00:00', 599.99),
    (3, '2023-09-02 16:30:00', 219.99),
    (2, '2023-09-03 09:45:00', 999.99),
    (4, '2023-09-04 14:15:00', 499.99),
    (5, '2023-09-05 10:00:00', 349.99),
    (1, '2023-09-06 11:30:00', 799.99),
    (2, '2023-09-07 13:45:00', 649.99),
    (3, '2023-09-08 08:15:00', 299.99),
    (4, '2023-09-09 17:00:00', 199.99),
    (5, '2023-09-10 10:45:00', 449.99),
    (1, '2023-09-11 12:30:00', 799.99),
    (3, '2023-09-12 15:30:00', 249.99),
    (2, '2023-09-13 10:15:00', 1099.99),
    (4, '2023-09-14 14:45:00', 599.99),
    (5, '2023-09-15 11:30:00', 399.99);

INSERT INTO order_details (order_id, product_id, quantity, unit_price)
VALUES
    (1, 1, 2, 899.99),
    (1, 3, 1, 29.99),
    (2, 5, 3, 149.99),
    (2, 9, 1, 129.99),
    (3, 7, 2, 49.99),
    (3, 10, 1, 99.99),
    (4, 12, 1, 699.99),
    (4, 13, 2, 14.99),
    (5, 8, 1, 179.99),
    (5, 4, 1, 129.99),
    (6, 15, 1, 399.99),
    (6, 6, 2, 349.99),
    (7, 2, 1, 1799.99),
    (7, 11, 1, 299.99),
    (8, 14, 3, 149.99),
    (8, 3, 2, 29.99),
    (9, 1, 1, 899.99),
    (9, 8, 2, 179.99),
    (10, 5, 1, 349.99),
    (10, 7, 1, 49.99);


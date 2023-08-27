CREATE DATABASE IF NOT EXISTS e_upgrade;
\c e_upgrade;

CREATE TABLE "user" (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(300),
                        email VARCHAR(100) NOT NULL,
                        password VARCHAR(100),
                        adress VARCHAR(200)
);


CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(50)
);

CREATE TABLE "product" (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100),
                         description TEXT,
                         categories_id INT REFERENCES categories(id),
                         price float DEFAULT 0,
                         stock_quantity INT
);


CREATE TABLE order (
                       id SERIAL PRIMARY KEY,
                       user_id INT REFERENCES "user"(id),
                       order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       total_bills float DEFAULT 0
);


CREATE TABLE order_details (
                               id SERIAL PRIMARY KEY,
                               order_id INT REFERENCES order(id),
                               product_id INT REFERENCES product(id),
                               quantity INT,
                               unit_price float DEFAULT 0q
);


/*CREATE TABLE cart (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES "user"(id),
    product_id INT REFERENCES product(id),
    quantity INT
);*/

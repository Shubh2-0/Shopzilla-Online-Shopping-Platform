CREATE DATABASE shopzilla;

use shopzilla;

show tables;



select * from buyer;
desc buyer;

select * from seller;
desc seller;

select * from category;
desc category;

select * from product;
desc product;

select * from transactions;
desc transactions;

select * from returnproduct;
desc returnproduct;



CREATE TABLE seller (
  SellerId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  UserName VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(15) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  mobile_no VARCHAR(15) NOT NULL,
  address VARCHAR(70) NOT NULL,
  income DECIMAL(15, 2) NOT NULL,
  is_deleted INT DEFAULT 0,
  pending_amount DECIMAL(10, 2) DEFAULT 0.00,
  deleted_date DATE
);



INSERT INTO Seller (UserName, password, first_name, last_name, mobile_no, address, income)
VALUES 
    ('Raj_2345', 'password1', 'Raj', 'Kumar', '9876543210', '123 ABC Street, Mumbai', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
    ('Neha_6789', 'password2', 'Neha', 'Sharma', '8765432109', '456 XYZ Street, Delhi', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
    ('Manish_8910', 'password3', 'Manish', 'Verma', '7654321098', '789 PQR Street, Bangalore', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
    ('Priya_1112', 'password4', 'Priya', 'Gupta', '6543210987', '321 LMN Street, Kolkata', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
    ('Amit_1314', 'password5', 'Amit', 'Singh', '5432109876', '987 XYZ Street, Chennai', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
    ('Anita_1516', 'password6', 'Anita', 'Patel', '4321098765', '654 PQR Street, Hyderabad', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
    ('Deepak_1718', 'password7', 'Deepak', 'Joshi', '3210987654', '987 ABC Street, Pune', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
    ('Sonia_1920', 'password8', 'Sonia', 'Malhotra', '2109876543', '789 XYZ Street, Ahmedabad', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
    ('Vikas_2122', 'password9', 'Vikas', 'Shah', '1098765432', '456 PQR Street, Jaipur', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
    ('Pooja_2324', 'password10', 'Pooja', 'Rajput', '0987654321', '321 ABC Street, Chandigarh', ROUND(RAND() * (300000 - 50000) + 50000, 2));



CREATE TABLE Buyer (
  UserName VARCHAR(50) UNIQUE KEY NOT NULL,
  password VARCHAR(15) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  mobile_no VARCHAR(15) NOT NULL,
  address VARCHAR(70) NOT NULL,
  balance Decimal(15,2) NOT NULL,
  is_deleted INT DEFAULT 0,
  deleted_date DATE DEFAULT NULL 
);



 
-- Insert into the Buyer table with random balance amounts between 50000 and 300000
INSERT INTO Buyer (UserName, password, first_name, last_name, mobile_no, address, balance)
VALUES
  ('Amit_271', 'password1', 'Amit', 'Sharma', '9876543210', '123 Main St, Delhi', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
  ('Neha_87','password2', 'Neha', 'Patel', '8765432109', '456 Oak St, Mumbai', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
  ('Rahul_901', 'password3', 'Rahul', 'Singh', '7654321098', '789 Maple St, Bangalore', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
  ('Pooja_72', 'password4', 'Pooja', 'Gupta', '6543210987', '456 Elm St, Chennai', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
  ('Priya_2', 'password5', 'Priya', 'Verma', '9876543211', '345 Park St, Kolkata', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
  ('Raj_28', 'password6', 'Raj', 'Gandhi', '8765432108', '567 Beach Rd, Goa', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
  ('Sneha_278', 'password7', 'Sneha', 'Kapoor', '7654321097', '789 Hill St, Hyderabad', ROUND(RAND() * (300000 - 50000) + 50000, 2)),
  ('Vikram_271', 'password8', 'Vikram', 'Mehra', '6543210986', '234 Lake Ave, Chandigarh', ROUND(RAND() * (300000 - 50000) + 50000, 2));



CREATE TABLE category (
  cat_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cat_name VARCHAR(25),
  gst_per INT
);


INSERT INTO category (cat_name, gst_per)
VALUES 
    ('Clothing', 5),
    ('Electronics', 7),
    ('Grocery', 9),
    ('Miscellaneous', 12);




CREATE TABLE product (
  product_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  product_name VARCHAR(40),
  price_per_piece DECIMAL(8, 2),
  seller_unique_num INT,
  seller_username VARCHAR(50) NOT NULL,
  seller_name VARCHAR(70) NOT NULL,
  quantity INT,
  description TEXT,
  category_id INT,
  sold_status INT DEFAULT 0,
  is_hide INT DEFAULT 0,
  return_policy INT DEFAULT 1,
  FOREIGN KEY (seller_unique_num) REFERENCES seller(SellerId),
  FOREIGN KEY (category_id) REFERENCES category(cat_id)
);





-- Clothing category
INSERT INTO product (product_name, price_per_piece, seller_unique_num, seller_username, seller_name, quantity, description, category_id)
VALUES
    ('Silk Saree', 2999.99, 1, 'Raj_2345', 'Raj Kumar', 40, 'Premium quality silk saree with intricate designs and luxurious feel.', 1),
    ('Leather Wallet', 499.50, 5, 'Anita_1516', 'Anita Patel', 80, 'Stylish and durable leather wallet with multiple compartments.', 1),
    ('Block Print Scarf', 499.50, 9, 'Anjali_2324', 'Anjali Gupta', 80, 'Lightweight scarf with beautiful block prints, perfect for adding a touch of Indian fashion.', 1),
    ('Handloom Cotton Saree', 1999.99, 1, 'Raj_2345', 'Raj Kumar', 30, 'Traditional handloom cotton saree with intricate patterns.', 1),
    ('Handcrafted Leather Bag', 799.50, 5, 'Anita_1516', 'Anita Patel', 40, 'Handmade leather bag with spacious compartments and trendy design.', 1),
    ('Traditional Kundan Jewelry Set', 2999.99, 9, 'Anjali_2324', 'Anjali Gupta', 20, 'Exquisite Kundan jewelry set with intricate craftsmanship.', 1),
    ('Men\'s Casual Shirt', 699.99, 2, 'Neha_6789', 'Neha Sharma', 50, 'Stylish and comfortable casual shirt for men.', 1),
    ('Women\'s Ethnic Kurti', 899.50, 6, 'Anjali_2324', 'Anjali Gupta', 60, 'Trendy and fashionable ethnic kurti for women.', 1),
    ('Sports Shoes', 1299.00, 3, 'Priya_1112', 'Priya Gupta', 30, 'High-quality sports shoes for enhanced performance and comfort.', 1),
    ('Kids\' Party Dress', 599.50, 7, 'Deepak_1718', 'Deepak Joshi', 40, 'Adorable party dress for kids to make them look cute and stylish.', 1);

-- Electronics category
INSERT INTO product (product_name, price_per_piece, seller_unique_num, seller_username, seller_name, quantity, description, category_id)
VALUES
    ('Bluetooth Earphones', 999.00, 2, 'Neha_6789', 'Neha Sharma', 100, 'High-quality wireless earphones for a seamless music experience.', 2),
    ('Classical Music CD Set', 699.00, 7, 'Deepak_1718', 'Deepak Joshi', 120, 'A curated collection of classical music CDs by renowned Indian artists.', 2),
    ('Smartphone', 14999.00, 2, 'Neha_6789', 'Neha Sharma', 50, 'Advanced smartphone with powerful features and high-quality camera.', 2),
    ('Wireless Bluetooth Speaker', 1299.00, 7, 'Deepak_1718', 'Deepak Joshi', 80, 'Portable wireless speaker with rich sound quality and long battery life.', 2),
    ('Air Purifier', 3999.00, 4, 'Priya_1112', 'Priya Gupta', 30, 'Efficient air purifier to improve the air quality in your home or office.', 2),
    ('HD LED TV', 21999.00, 3, 'Manish_8910', 'Manish Verma', 25, 'High-definition LED TV with a large screen for an immersive viewing experience.', 2),
    ('Digital Camera', 7999.00, 3, 'Manish_8910', 'Manish Verma', 35, 'Professional-grade digital camera for capturing stunning photos and videos.', 2),
    ('Gaming Console', 16999.00, 7, 'Deepak_1718', 'Deepak Joshi', 20, 'Next-generation gaming console for an immersive gaming experience.', 2),
    ('Laptop', 34999.00, 3, 'Manish_8910', 'Manish Verma', 15, 'Powerful laptop for seamless multitasking and high-performance computing.', 2),
    ('Wireless Headphones', 1499.00, 2, 'Neha_6789', 'Neha Sharma', 40, 'Wireless headphones with excellent sound quality and comfortable fit.', 2);

-- Grocery category
INSERT INTO product (product_name, price_per_piece, seller_unique_num, seller_username, seller_name, quantity, description, category_id)
VALUES
    ('Organic Green Tea', 199.00, 10, 'Pooja_2324', 'Pooja Rajput', 200, 'Premium quality organic green tea for a refreshing and healthy beverage.', 3),
    ('Extra Virgin Olive Oil', 299.50, 6, 'Anjali_2324', 'Anjali Gupta', 150, 'Imported extra virgin olive oil for enhancing the taste of your dishes.', 3),
    ('Ground Coffee', 249.00, 10, 'Pooja_2324', 'Pooja Rajput', 120, 'Finely ground coffee beans for a rich and aromatic coffee experience.', 3),
    ('Organic Quinoa', 149.50, 9, 'Anjali_2324', 'Anjali Gupta', 100, 'Healthy and nutritious organic quinoa grains for wholesome meals.', 3),
    ('Premium Chocolate', 99.00, 8, 'Vikas_2122', 'Vikas Shah', 200, 'Indulgent and high-quality chocolate bars for a sweet treat.', 3),
    ('Organic Honey', 249.50, 9, 'Anjali_2324', 'Anjali Gupta', 150, 'Pure and natural organic honey sourced from trusted beekeepers.', 3),
    ('Spices Gift Set', 199.00, 10, 'Pooja_2324', 'Pooja Rajput', 80, 'A collection of aromatic spices to add flavors to your dishes.', 3),
    ('Healthy Snack Pack', 149.50, 8, 'Vikas_2122', 'Vikas Shah', 120, 'Assortment of healthy and tasty snacks for guilt-free snacking.', 3),
    ('Organic Dried Fruits', 299.00, 9, 'Anjali_2324', 'Anjali Gupta', 100, 'Assorted organic dried fruits for a nutritious and delicious snack.', 3),
    ('Gluten-Free Pasta', 199.50, 10, 'Pooja_2324', 'Pooja Rajput', 80, 'Delicious gluten-free pasta made from high-quality ingredients.', 3);

-- Miscellaneous category products
INSERT INTO product (product_name, price_per_piece, seller_unique_num, seller_username, seller_name, quantity, description, category_id)
VALUES
    ('Decorative Wall Clock', 499.00, 6, 'Anita_1516', 'Anita Patel', 50, 'Aesthetic wall clock to enhance the look of your living space.', 4),
    ('Handmade Ceramic Vase', 299.50, 7, 'Deepak_1718', 'Deepak Joshi', 60, 'Unique and elegant handmade ceramic vase for showcasing flowers.', 4),
    ('Fragrance Diffuser Set', 399.00, 8, 'Sonia_1920', 'Sonia Malhotra', 40, 'Aromatic fragrance diffuser set to create a pleasant ambiance.', 4),
    ('Vintage Leather Journal', 199.50, 9, 'Vikas_2122', 'Vikas Shah', 70, 'Vintage-style leather journal for writing and sketching.', 4),
    ('Scented Candles Set', 299.00, 10, 'Pooja_2324', 'Pooja Rajput', 50, 'Set of scented candles to create a relaxing and soothing atmosphere.', 4),
    ('Home Decorative Cushions', 249.50, 1, 'Raj_2345', 'Raj Kumar', 80, 'Stylish and comfortable decorative cushions for your living room.', 4),
    ('Wall Art Painting', 599.00, 2, 'Neha_6789', 'Neha Sharma', 30, 'Captivating wall art painting to add a touch of elegance to your home.', 4),
    ('Antique Brass Showpiece', 799.50, 3, 'Manish_8910', 'Manish Verma', 20, 'Exquisite antique brass showpiece for displaying in your showcase.', 4),
    ('Handwoven Cotton Rug', 499.00, 4, 'Priya_1112', 'Priya Gupta', 40, 'Handwoven cotton rug with beautiful patterns and vibrant colors.', 4),
    ('Decorative Table Lamp', 349.50, 5, 'Amit_1314', 'Amit Singh', 30, 'Elegant and decorative table lamp to illuminate your space.', 4);


  

CREATE TABLE transactions (
  transaction_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  product_id INT NOT NULL,
  product_name VARCHAR(50) NOT NULL,
  buyer_id VARCHAR(15) NOT NULL,
  buyer_name VARCHAR(100) NOT NULL,
  quantity INT DEFAULT 1,
  purchase_date DATE NOT NULL,
  amount_per_piece DECIMAL(15, 2) NOT NULL,
  price DECIMAL(30, 2) NOT NULL,
  gst_percentage INT NOT NULL,
  tax_amount DECIMAL(20, 2) NOT NULL,
  total_price DECIMAL(20, 2) NOT NULL,
  return_policy TINYINT(1) DEFAULT 1,
  is_hide INT DEFAULT 0,
  FOREIGN KEY (product_id) REFERENCES product(product_id),
  FOREIGN KEY (buyer_id) REFERENCES buyer(UserName)
);



CREATE TABLE returnproduct (
  return_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  product_id INT NOT NULL,
  product_name VARCHAR(60),
  reason_for_return TEXT NOT NULL,
  return_date DATE NOT NULL,
  buyer_id VARCHAR(15) NOT NULL,
  buyer_name VARCHAR(50) NOT NULL,
  quantity INT,
  return_type VARCHAR(20),
  transaction_id INT,
  FOREIGN KEY (product_id) REFERENCES product(product_id),
  FOREIGN KEY (buyer_id) REFERENCES buyer(UserName),
  FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id)
);


























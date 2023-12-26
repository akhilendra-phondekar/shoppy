INSERT INTO users (username, email, password, otp_code, is_verified, reset_token, cart_id, created_at)
VALUES
  ('john_doe', 'john.doe@example.com', 'hashed_password_1', NULL, true, NULL, 1, '2023-01-01 12:00:00'),
  ('jane_smith', 'jane.smith@example.com', 'hashed_password_2', NULL, true, NULL, 2, '2023-01-02 10:30:00'),
  ('alice_jones', 'alice.jones@example.com', 'hashed_password_3', NULL, true, NULL, 3, '2023-01-03 15:45:00'),
  ('bob_jenkins', 'bob.jenkins@example.com', 'hashed_password_4', NULL, true, NULL, 4, '2023-01-04 18:20:00'),
  ('emma_white', 'emma.white@example.com', 'hashed_password_5', NULL, true, NULL, 5, '2023-01-05 08:55:00'),
  ('samuel_parker', 'samuel.parker@example.com', 'hashed_password_6', NULL, true, NULL, 6, '2023-01-06 14:10:00'),
  ('lily_wilson', 'lily.wilson@example.com', 'hashed_password_7', NULL, true, NULL, 7, '2023-01-07 09:30:00'),
  ('oliver_clark', 'oliver.clark@example.com', 'hashed_password_8', NULL, true, NULL, 8, '2023-01-08 16:45:00'),
  ('mia_hall', 'mia.hall@example.com', 'hashed_password_9', NULL, true, NULL, 9, '2023-01-09 11:20:00'),
  ('ethan_brown', 'ethan.brown@example.com', 'hashed_password_10', NULL, true, NULL, 10, '2023-01-10 13:40:00');

INSERT INTO products (name, description, price, stock_quantity, created_at)
VALUES
  ('Laptop', 'Powerful laptop with high-performance specs', 1299.99, 50, '2023-01-01 12:00:00'),
  ('Smartphone', 'Latest flagship smartphone with advanced features', 799.99, 100, '2023-01-02 10:30:00'),
  ('Coffee Maker', 'Modern coffee maker with programmable settings', 79.99, 80, '2023-01-03 15:45:00'),
  ('Wireless Headphones', 'Noise-canceling wireless headphones for immersive audio', 199.99, 120, '2023-01-04 18:20:00'),
  ('Fitness Tracker', 'Smart fitness tracker with heart rate monitoring', 49.99, 150, '2023-01-05 08:55:00'),
  ('Digital Camera', 'High-resolution digital camera with multiple shooting modes', 599.99, 60, '2023-01-06 14:10:00'),
  ('Gaming Console', 'Next-gen gaming console with 4K capabilities', 499.99, 70, '2023-01-07 09:30:00'),
  ('Bluetooth Speaker', 'Portable Bluetooth speaker with rich sound quality', 89.99, 90, '2023-01-08 16:45:00'),
  ('Electric Toothbrush', 'Smart electric toothbrush for effective oral care', 39.99, 110, '2023-01-09 11:20:00'),
  ('Smartwatch', 'Fashionable smartwatch with health monitoring features', 129.99, 130, '2023-01-10 13:40:00'),
  ('Desk Chair', 'Ergonomic office chair for comfortable work hours', 149.99, 40, '2023-01-11 16:20:00'),
  ('Wireless Mouse', 'Wireless mouse with precision tracking for productivity', 29.99, 100, '2023-01-12 14:00:00'),
  ('Air Purifier', 'HEPA air purifier for clean and fresh indoor air', 159.99, 30, '2023-01-13 17:30:00'),
  ('External Hard Drive', 'High-capacity external hard drive for data storage', 89.99, 80, '2023-01-14 10:15:00'),
  ('Smart Thermostat', 'Programmable smart thermostat for energy efficiency', 129.99, 60, '2023-01-15 11:45:00'),
  ('Blender', 'Versatile blender for smoothies, soups, and more', 69.99, 90, '2023-01-16 09:00:00'),
  ('4K Smart TV', 'Large 4K smart TV with streaming capabilities', 899.99, 20, '2023-01-17 13:20:00'),
  ('Digital Drawing Tablet', 'Graphics tablet for digital artists and designers', 199.99, 50, '2023-01-18 15:10:00'),
  ('Coffee Grinder', 'Adjustable coffee grinder for a perfect grind every time', 49.99, 75, '2023-01-19 12:30:00'),
  ('Portable Power Bank', 'High-capacity power bank for on-the-go charging', 29.99, 110, '2023-01-20 14:45:00');


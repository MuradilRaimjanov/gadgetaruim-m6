INSERT INTO baskets(discount_percent_sum, sum, end_sum, quantity_of_products)
VALUES (0, 0, 0, 0),
       (0, 0, 0, 0);

INSERT INTO wishlist(count_of_product)
VALUES (0),
       (0);

INSERT INTO users(email, basket_id, wishlist_id, first_name, last_name, password, role)
VALUES ('admin@gmail.com', 1, 1, 'admin', 'admin last_name', '$2a$12$lPtGrHLi.FYsf8xSJt5fceuGEuzMF3XZZBM9vp91LsaoXl7lEyGSe', 'ROLE_ADMIN'),
       ('user@gmail.com', 2, 2, 'user', 'user last_name', '$2a$12$rV1HO7BO/.e4aRqVotmCBebjD7cDyGDx7T7uKk3aLbbi/N1bSlicy', 'ROLE_USER');


UPDATE baskets SET user_id = 1 WHERE id = 1;
UPDATE baskets SET user_id = 2 WHERE id = 2;

UPDATE wishlist SET user_id = 1 WHERE id = 1;
UPDATE wishlist SET user_id = 2 WHERE id = 2;


INSERT INTO discounts(finish, percent, start)
VALUES (CAST('2023-12-10' AS DATE), 10, CAST('2023-09-10' AS DATE)),
    (CAST('2023-12-01' AS DATE), 10, CAST('2023-09-01' AS DATE)),
    (CAST('2024-02-10' AS DATE), 10, CAST('2023-08-01' AS DATE)),
    (CAST('2024-01-01' AS DATE), 10, CAST('2023-10-01' AS DATE)),
    (CAST('2023-12-25' AS DATE), 10, CAST('2023-08-10' AS DATE)),
    (CAST('2023-11-01' AS DATE), 10, CAST('2023-10-03' AS DATE));

INSERT INTO addresses(country_name, name, street_name, user_id)
VALUES ('Russia', 'Moscow', '5th Avenue', 1),
       ('Russia', 'Piter', '6th Avenue', 2);

INSERT INTO brands(id, brand_name, image)
VALUES (1, 'APPLE', null),
       (2, 'SAMSUNG', null);

INSERT INTO products(article_number, quantity_sim_cards, release_date, weight, discount_id, category_type, color, description, diameter_of_the_rear,
                     engine_power, engine_type, guarantee, image, memory_rom, memory_ram, name, os, price, processor, program_training,
                     punning_track, screen, slope_of_the_treadmill, speed_adjustment, track_type, quantity_of_product, brand_id)
VALUES (1235, 2, CAST('2022-02-23' AS DATE), 187, 1, 'SMARTPHONES', 'WHITE',
        'The Apple iPhone 15 Blue smartphone received a 6.1-inch diagonal display made using Super Retina XBM technology', NULL,
        NULL, NULL, NULL, NULL, 'TWO_HUNDRED_FIFTY_SIX_GB', 'EIGHT_GB', 'IPhone 15 pro', 'IOS', 1000,  'Apple A15 Bionic', NULL,
        NULL, '6.1', NULL, NULL, NULL, 3, 1),

       (5432, 1, CAST('2023-07-10' AS DATE), 187, 2, 'SMARTPHONES', 'RED',
        'The Samsung Galaxy Z Flip5 Lavender smartphone (SM-F731B) is a device with a folding case and two screens, which expands its capabilities', NULL,
        NULL, NULL, NULL, NULL, 'TWO_HUNDRED_FIFTY_SIX_GB', 'EIGHT_GB', 'Samsung Galaxy Z Flip5', 'ANDROID', 1000, 'Qualcomm Snapdragon 8 Gen2', NULL,
        NULL, '6.7', NULL, NULL, NULL, 3, 2),

       (7868, 2, CAST('2022-05-08' AS DATE), 178, 3, 'SMARTPHONES', 'RED',
        'The Honor 70 smartphone in a Midnight Black glass case runs on the Android Magic UI 6.1 operating system', NULL,
        NULL, NULL, NULL, NULL, 'TWO_HUNDRED_FIFTY_SIX_GB', 'EIGHT_GB', 'Honor 70', 'ANDROID', 1000, 'Qualcomm Snapdragon 778G Plus', NULL,
        NULL, '6.67', NULL, NULL, NULL, 3, 1),

       (5675, 1, CAST('2022-11-20' AS DATE), 466, 4, 'TABLETS', 'BEIGE',
        'The Apple iPad Pro 11 2022 tablet is a model with chopped edges and rounded corners,made in an aluminum case. The design color is black', NULL,
        NULL, NULL, NULL, NULL, 'HUNDRED_TWENTY_EIGHT_GB', 'EIGHT_GB', 'IPad Pro 11 ', 'IOS', 1000, 'Apple A12X Bionic processor with 64 bit architecture', NULL,
        NULL, '11', NULL, NULL, NULL, 3, 2),

       (6864, 1, CAST('2023-02-15' AS DATE), 737, 5, 'TABLETS', 'BLACK',
        'The Samsung Galaxy Tab S9 5G Beige tablet (SM-X716B) is an 11-inch model, the screen of which is made using Dynamic AMOLED 2X technology', NULL,
        NULL, NULL, NULL, NULL, 'FIVE_HUNDRED_TWELVE_GB', 'EIGHT_GB', 'Samsung Galaxy Tab S9 Ultra', 'ANDROID', 1000, 'Qualcomm Snapdragon 8 Gen', NULL,
        NULL, '6.1', NULL, NULL, NULL, 3, 1),

       (2346, 2, CAST('2022-01-12' AS DATE), 172, 6, 'SMARTPHONES', 'GREY',
        'this product produced in 2022', NULL,
        NULL, NULL, NULL, NULL, 'HUNDRED_TWENTY_EIGHT_GB', 'EIGHT_GB', 'IPhone 14 ', 'IOS', 1000, 'Apple A15 Bionic', NULL,
        NULL, '6.1', NULL, NULL, NULL, 3, 2);

INSERT INTO delivery(name, last_name, phone_number)
VALUES ('Gigi', 'Mark', '8(926)797_79_83');

INSERT INTO orders(count_of_products, total_sum, basket_id, delivery_person_id, user_id)
VALUES (5, 199, 1, 1, 1);

INSERT INTO payments(amount, creat, user_id)
VALUES (200.000, CAST('2023-01-23' AS DATE), 1),
       (300.000, CAST('2023-02-23' AS DATE), 2);

INSERT INTO feedbacks(created_at, evaluation, name, product_id, user_id)
VALUES (current_date, 'five star', 'perfect', 1, 1);

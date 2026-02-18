-- Sample / dummy data
INSERT INTO public.product (
                            id,
                            product_type,
                            sku,
                            price,
                            cost,
                            upc,
                            gs1,
                            created_at,
                            created_by,
                            modified_at,
                            modified_by)
VALUES ('52ac1e08-2ccb-4c6f-9694-238da5cf7f53', 'FULL', 'WRLS-HP-001', 799.99, 520.00, '012345678905', '012345678905', '2025-03-15 09:12:34', 'admin', '2025-06-20 14:45:22', 'admin'),
       ('0abfbf0e-6058-476e-9ec8-4afaad1e7552', 'FULL', 'TSH-BLK-M', 29.99, 12.50, '840123456789', NULL, '2025-01-08 10:30:00', 'store1', '2025-04-12 16:20:11', 'manager'),
       ('494c1883-7b63-457b-bfd1-d06e37928a54', 'FULL', 'BLNDR-PRO-800', 89.95, 42.00, '036000241457', '036000241457', '2024-11-20 13:15:45', 'admin', '2025-07-01 09:08:56', 'admin'),
       ('89259426-990f-4590-9572-b96fd8ab5541', 'FULL', 'LIPSTK-RED-01', 18.50, 7.80, NULL, NULL, '2025-02-03 11:22:19', 'beauty1', '2025-05-18 15:40:33', 'beauty1'),
       ('e045807d-4361-4920-836b-cc37819f7b4e', 'FULL', 'LEGO-SET-42100', 149.99, 95.00, '673419312004', '673419312004', '2024-12-05 08:45:12', 'admin', '2025-03-30 10:55:47', 'admin'),
       ('d5ec756f-1897-4fbb-942f-a3bb89c47275', 'FULL', 'FTBL-SKR-M', 59.99, 28.00, '885652345678', NULL, '2025-04-10 14:20:00', 'sports', '2025-06-15 17:10:22', 'sports'),
       ('0b67918f-374c-4004-aba0-010aca518f3f', 'FULL', 'PHN-CASE-IP16', 34.99, 9.75, NULL, NULL, '2025-05-22 09:30:55', 'admin', '2025-07-10 11:25:41', 'admin'),
       ('b13384a8-a4d0-43b5-bc3d-bcabd62d402f', 'FULL', 'ISBN-978014312', 14.95, 6.20, '9780143128540', '9780143128540', '2024-10-15 16:40:22', 'admin', '2025-02-28 13:15:09', 'admin'),
       ('93c6c3ba-bd90-40cd-81e8-25655cb1c623', 'FULL', 'JKT-DNM-BLU-L', 89.00, 45.00, '840987654321', NULL, '2025-03-01 10:05:33', 'fashion', '2025-06-05 09:50:17', 'fashion'),
       ('4ebd64af-9faa-4322-9ca1-99af78ebbc4a', 'FULL', 'COFF-MKR-12C', 69.99, 38.50, '072868912345', '072868912345', '2025-01-25 11:55:00', 'admin', '2025-04-20 14:30:44', 'admin'),
       ('0f700e41-6881-4ee1-8bf5-770334c32e0e', 'FULL', 'EARB-TWS-BLK', 129.99, 65.00, NULL, NULL, '2025-06-12 08:15:27', 'audio', '2025-07-14 10:22:19', 'audio'),
       ('633b051f-2ee6-4cce-8efe-988e06a1bf19', 'FULL', 'SHAM-500ML', 12.99, 4.80, '078773412345', NULL, '2024-09-30 15:20:10', 'admin', '2025-03-10 12:45:55', 'admin'),
       ('ee45609f-d1bb-4b0b-a17d-10fdc92ef1c9', 'FULL', 'PUZZ-1000PC', 19.99, 8.50, NULL, NULL, '2025-02-14 13:10:40', 'toys', '2025-05-25 16:35:12', 'toys'),
       ('fb056435-a27c-4a0d-ad73-a72f83f88f54', 'BASIC', 'YOGA-MAT-6MM', 24.99, 11.00, '852345678901', '852345678901', '2025-04-01 09:40:00', 'admin', '2025-06-30 11:15:33', 'admin'),
       ('d0a0ba07-9df2-4d95-bcbe-2ae7dda4396b', 'BASIC', 'SOCK-PK6-WHT', 14.99, 5.90, NULL, NULL, '2025-03-20 12:25:18', 'basics', '2025-07-05 14:50:09', 'basics'),
       ('0a0f13ca-5ce5-46fb-bf42-1ad60cadd256', 'BASIC', 'CHRG-CBL-USBC', 9.99, 2.50, '085000123456', NULL, '2025-01-10 10:00:00', 'admin', '2025-04-15 09:30:22', 'admin'),
       ('d31c40c3-c0c3-4de9-8099-2ea5fbb52e8a', 'BASIC', 'POTS-SET-10PC', 129.99, 78.00, '008834902345', '008834902345', '2024-11-05 14:35:47', 'kitchen', '2025-05-10 16:20:41', 'kitchen'),
       ('c665d949-55f2-4d7f-9fd9-fd913e051807', 'BASIC', 'MSK-FCL-5PK', 22.50, 9.00, NULL, NULL, '2025-05-05 11:45:30', 'admin', '2025-06-25 13:10:55', 'admin'),
       ('5f81fbe5-3146-431d-94ef-653f19e2467c', 'BASIC', 'ISBN-978198218', 16.99, 7.10, '9781982186555', '9781982186555', '2025-02-01 09:15:22', 'admin', '2025-04-30 10:40:18', 'admin'),
       ('4a4762ba-21f6-436a-a9ea-d61371f38254', 'BASIC', 'TENIS-RKT-PRO', 179.99, 110.00, '883652341234', NULL, '2025-03-15 16:20:00', 'tennis', '2025-07-01 15:55:33', 'tennis'),
       ('b4475128-22ea-487a-bea1-3db4e3d5bfe9', 'BASIC', 'TAB-10IN-128G', 249.99, 160.00, '019425612345', '019425612345', '2025-04-20 10:30:45', 'admin', '2025-06-10 12:15:27', 'admin'),
       ('971ff03b-62ec-4209-837d-46ef181fe602', 'BASIC', 'HOD-BLK-XL', 49.99, 22.00, NULL, NULL, '2025-01-30 13:55:10', 'street', '2025-05-15 17:30:44', 'street'),
       ('67e928d0-937f-47ac-b803-de64fa1fd8e0', 'BASIC', 'VAC-CORDLS', 199.99, 125.00, '088591234567', '088591234567', '2024-12-10 09:25:33', 'admin', '2025-03-25 11:40:19', 'admin'),
       ('8cddafb2-1ed7-4057-97ba-52074d75d59c', 'BASIC', 'DRON-KID-4K', 79.99, 45.00, NULL, NULL, '2025-06-01 14:10:00', 'toys', '2025-07-12 10:05:36', 'toys'),
       ('8b0f8a4b-1448-4189-b5f1-c08c7ae0f844', 'BASIC', 'PRFUME-50ML', 89.00, 38.00, '370123456789', NULL, '2025-02-25 12:40:22', 'admin', '2025-06-05 15:20:11', 'admin'),
       ('54c87dbf-77f6-437d-a37e-5ec09313f3de', 'BASIC', 'MOU-WRLS-ERG', 39.99, 18.00, '097855123456', NULL, '2025-03-10 08:50:00', 'admin', '2025-05-20 09:35:48', 'admin'),
       ('95a11c51-b017-4b27-9933-dccddc1f2a08', 'BASIC', 'BIKE-HELM-M', 64.99, 32.00, NULL, NULL, '2025-05-15 11:30:15', 'cycle', '2025-07-08 14:10:22', 'cycle'),
       ('7531f0d0-bc31-4fe1-bd5c-30ac49d72bc7', 'BASIC', 'SHEET-SET-QN', 59.99, 25.00, '084234567890', '084234567890', '2025-01-05 15:45:40', 'admin', '2025-04-10 16:55:19', 'admin'),
       ('2fff0ca1-2e90-46f8-ab3a-b0a5a4cc6cf8', 'BASIC', 'CAP-BASEBL-BLK', 24.99, 10.50, NULL, NULL, '2025-04-05 10:20:33', 'headwear', '2025-06-18 13:40:07', 'headwear'),
       ('670830e9-a459-4bd6-a1d2-701d07b0ad6d', 'BASIC', 'SPKR-BT-MINI', 49.99, 20.00, '019578912345', '019578912345', '2025-02-20 09:10:55', 'admin', '2025-07-15 11:25:30', 'admin');


INSERT INTO public.orders (name, street_1, street_2, city, state, postal_code, total,
                           creation_timestamp, marketplace, shipped, fulfilled, tracking_number, status, id)
VALUES ('John Doe', '777 Spring Creek dr', NULL, 'Phoenix', 'AZ', '85392', 99.95,
        '2026-01-07 11:30:16.782001', 'Shopify', false, false, NULL, NULL, '439372ec-b842-4126-ba5c-bce27dddc714'),

       ('Bob Upton', '7 Diane rd', '1', 'Columbia Falls', 'MT', '59912', 599.00,
        '2026-01-07 11:33:29.574796', 'Webment', false, false, NULL, NULL, 'cee4e056-b0c6-4b20-bd07-685911d0fc99'),

       ('Jane blah', '1065 savannah rd', 'apt d302', 'Kalispell', 'MT', '59901', 1099.99,
        '2026-01-07 11:31:30.284662', 'Amazon', true, true, '1Z1251234512', NULL,
        '08217182-b30a-463d-9603-18556918db44'),

       ('Alice Johnson', '123 Maple Street', 'Apt 4B', 'Seattle', 'WA', '98101', 89.99,
        '2026-01-09 10:43:18.262892', 'Amazon', false, false, NULL, NULL, 'aeb11b63-cb16-45bf-b05c-7c8634cca0c4'),

       ('Robert Chen', '456 Oak Avenue', NULL, 'San Francisco', 'CA', '94107', 149.50,
        '2026-01-09 10:43:18.300402', 'eBay', false, false, NULL, NULL, '0ad0e2fc-c6ec-4a42-871a-170acb242644'),

       ('Maria Gonzalez', '789 Elm Road', 'Suite 200', 'Austin', 'TX', '78701', 45.75,
        '2026-01-09 10:43:18.303490', 'Walmart', false, false, NULL, NULL, 'f5c4f92a-01a0-43ef-a90a-4fc4b2350d8b'),

       ('James Wilson', '321 Pine Lane', NULL, 'Chicago', 'IL', '60614', 299.00,
        '2026-01-09 10:43:18.306175', 'Amazon', false, false, NULL, NULL, '529f9e98-c8c5-4770-81ef-19f999b506ae'),

       ('Emma Davis', '555 Cedar Blvd', 'Unit 12', 'Denver', 'CO', '80202', 67.20,
        '2026-01-09 10:43:18.308729', 'Shopify', false, false, NULL, NULL, '7289a477-a20f-4a07-a9e1-bbe8ed2ee0dd'),

       ('Liam Martinez', '246 Birch Street', NULL, 'Miami', 'FL', '33131', 124.99,
        '2026-01-09 10:43:18.311301', 'eBay', false, false, NULL, NULL, '0d98fd31-b56d-4415-85b2-cb32c1015024'),

       ('Jason Johnson', '123 Division Street', 'Apt 4B', 'Spokane', 'WA', '99207', 102.00,
        '2026-01-08 14:41:00.921710', 'Stripe', true, false, '1Z423143123', 'shipped',
        '52c09bfb-43e5-4c07-8e48-b94b690eef77'),

       ('Olivia Ramirez', '1420 Sunset Boulevard', 'Apt 305', 'Los Angeles', 'CA', '90026', 78.45,
        '2026-01-09 20:21:35.233767', 'Amazon', false, false, NULL, NULL, 'bfb6afcb-8187-4364-8ba3-5a8f879ff07c'),

       ('Ethan Thompson', '819 Riverfront Drive', NULL, 'Boston', 'MA', '02108', 189.99,
        '2026-01-09 20:21:35.250574', 'eBay', false, false, NULL, NULL, '5e15d690-a247-469f-983d-71c7766f2cc6'),

       ('Isabella Nguyen', '6734 Peachtree Street', 'Suite 140', 'Atlanta', 'GA', '30308', 34.20,
        '2026-01-09 20:21:35.252865', 'Walmart', false, false, NULL, NULL, '6341b4e0-175a-4b9b-9b3b-d541056b3821'),

       ('Noah Patel', '2910 Highland Avenue', 'Unit 7', 'Phoenix', 'AZ', '85016', 256.80,
        '2026-01-09 20:21:35.255283', 'Amazon', false, false, NULL, NULL, '38d204e5-b780-4678-9770-b3d5b7bc7dbc'),

       ('Ava Kim', '4582 Lakeview Terrace', NULL, 'Las Vegas', 'NV', '89109', 112.30,
        '2026-01-09 20:21:35.257649', 'Shopify', false, false, NULL, NULL, 'd5fe1060-c73a-435e-a393-8fe899926311'),

       ('Lucas Rodriguez', '305 Forest Hills Road', 'Apt 22', 'Nashville', 'TN', '37215', 95.60,
        '2026-01-09 20:21:35.260113', 'eBay', false, false, NULL, NULL, '411c1c58-498b-4509-af12-def9ad028893'),

       ('Mia Anderson', '1776 Liberty Lane', NULL, 'Philadelphia', 'PA', '19103', 167.75,
        '2026-01-09 20:21:35.262460', 'Amazon', false, false, NULL, NULL, '03eb989c-1692-4072-a9ea-fe4199664f12'),

       ('Benjamin Wright', '8902 Coastal Highway', 'Condo 409', 'San Diego', 'CA', '92101', 43.99,
        '2026-01-09 20:21:35.264752', 'Walmart', false, false, NULL, NULL, '194fdbbb-6442-4358-b5f6-fa3548def1fa'),

       ('Alan Harper', '2320 Pacific Coast Highway', 'Beach House B', 'Malibu', 'CA', '90265', 158.40,
        '2026-01-09 20:22:16.570654', 'Amazon', true, false, '1Z5A7B9C0234567890', 'shipped',
        '3e2c7e16-7f39-4165-9bae-c88a9abadf7b'),

       ('Jake Harper', '417 Palm Breeze Drive', 'Unit 12B', 'Malibu', 'CA', '90265', 20.99,
        '2026-01-10 12:45:43.980123', 'Shopify', true, false, '1Z9A7B9C5234567980', 'shipped',
        'a4a596eb-7429-46cb-986c-173b6f345125'),

       ('Charlie Harper', '23850 Pacific Coast Highway', 'Suite 4', 'Malibu', 'CA', '90265', 489.99,
        '2026-01-10 12:50:26.288178', 'Shopify', false, false, NULL, NULL,
        'e02b7a37-8ce0-42f3-ad72-38159e598da6') ON CONFLICT DO NOTHING;


INSERT INTO public.order_item (
    id,
    sku,
    item_name,
    quantity,
    base_price,
    creation_timestamp,
    fk_order_id,
    fk_product_id
)
VALUES
-- Order 1: John Doe (total ~99.95)
('b6c67d71-5ab1-40ab-bc98-4cb60b2b66e6', 'TSH-BLK-M', 'Black T-Shirt Medium', 2, 29.99, '2026-01-07 11:35:00', '439372ec-b842-4126-ba5c-bce27dddc714', '0abfbf0e-6058-476e-9ec8-4afaad1e7552'),
('4f0e4c45-f4a5-4be9-85ea-7e97475f8672', 'SOCK-PK6-WHT', 'White Sock Pack (6)', 3, 14.99, '2026-01-07 11:35:10', '439372ec-b842-4126-ba5c-bce27dddc714', 'd5ec756f-1897-4fbb-942f-a3bb89c47275'),

-- Order 2: Bob Upton (total ~599)
('536deb39-8b76-4567-96dd-c471d59a9c5b', 'TAB-10IN-128G', '10-inch Tablet 128GB', 2, 249.99, '2026-01-07 11:38:00', 'cee4e056-b0c6-4b20-bd07-685911d0fc99', 'b4475128-22ea-487a-bea1-3db4e3d5bfe9'),
('8d155346-a2fb-490f-9381-d9ce7023d7c1', 'EARB-TWS-BLK', 'True Wireless Earbuds Black', 1, 129.99, '2026-01-07 11:38:05', 'cee4e056-b0c6-4b20-bd07-685911d0fc99', '0f700e41-6881-4ee1-8bf5-770334c32e0e'),

-- Order 3: Jane blah (total 1099.99)
('97a5860a-18b9-4b5c-816f-3668a6a414b6', 'WRLS-HP-001', 'Wireless Headphones Premium', 1, 799.99, '2026-01-07 11:40:00', '08217182-b30a-463d-9603-18556918db44', '52ac1e08-2ccb-4c6f-9694-238da5cf7f53'),
('d7f56a49-1121-407a-acaf-4007482784e0', 'SPKR-BT-MINI', 'Mini Bluetooth Speaker', 2, 49.99, '2026-01-07 11:40:10', '08217182-b30a-463d-9603-18556918db44', '670830e9-a459-4bd6-a1d2-701d07b0ad6d'),
('d54046c1-7147-4f8d-b1a4-db37da08211e', 'CHRG-CBL-USBC', 'USB-C Charging Cable', 3, 9.99, '2026-01-07 11:40:15', '08217182-b30a-463d-9603-18556918db44', '0a0f13ca-5ce5-46fb-bf42-1ad60cadd256'),

-- Order 4: Alice Johnson
('5ce3b02d-0192-492b-bd20-32d9a1bbe993', 'BLNDR-PRO-800', 'Professional Blender 800W', 1, 89.95, '2026-01-09 10:50:00', 'aeb11b63-cb16-45bf-b05c-7c8634cca0c4', '494c1883-7b63-457b-bfd1-d06e37928a54'),

-- Order 5: Robert Chen
('1bb9cac0-e756-42e7-9d1b-48cb17229007', 'LEGO-SET-42100', 'LEGO Technic Set 42100', 1, 149.99, '2026-01-09 10:55:00', '0ad0e2fc-c6ec-4a42-871a-170acb242644', 'e045807d-4361-4920-836b-cc37819f7b4e'),

-- Order 6: Maria Gonzalez
('3ab1bfb7-ddfb-41dc-ae93-e25d603def8f', 'LIPSTK-RED-01', 'Red Lipstick Longwear', 2, 18.50, '2026-01-09 11:00:00', 'f5c4f92a-01a0-43ef-a90a-4fc4b2350d8b', '89259426-990f-4590-9572-b96fd8ab5541'),
('c9318c54-7310-4cdb-a62e-171c2e58325d', 'MSK-FCL-5PK', 'Facial Mask Pack (5)', 1, 22.50, '2026-01-09 11:00:10', 'f5c4f92a-01a0-43ef-a90a-4fc4b2350d8b', 'c665d949-55f2-4d7f-9fd9-fd913e051807'),

-- Order 7: James Wilson
('134eddf8-16a5-47cd-90ce-41268e52c4a6', 'VAC-CORDLS', 'Cordless Vacuum Cleaner', 1, 199.99, '2026-01-09 11:05:00', '529f9e98-c8c5-4770-81ef-19f999b506ae', '67e928d0-937f-47ac-b803-de64fa1fd8e0'),
('5e667b0c-dcc8-41e7-86bd-3923352e0e3e', 'POTS-SET-10PC', '10-Piece Cookware Set', 1, 129.99, '2026-01-09 11:05:10', '529f9e98-c8c5-4770-81ef-19f999b506ae', 'd31c40c3-c0c3-4de9-8099-2ea5fbb52e8a'),

-- Order 8: Emma Davis
('24441424-99cb-4390-8b65-ee1b03fd3645', 'COFF-MKR-12C', '12-Cup Coffee Maker', 1, 69.99, '2026-01-09 11:10:00', '7289a477-a20f-4a07-a9e1-bbe8ed2ee0dd', '4ebd64af-9faa-4322-9ca1-99af78ebbc4a'),

-- Order 9: Liam Martinez
('67d3ddb1-8d7a-4716-a113-751452706b31', 'TENIS-RKT-PRO', 'Professional Tennis Racket', 1, 179.99, '2026-01-09 11:15:00', '0d98fd31-b56d-4415-85b2-cb32c1015024', '4a4762ba-21f6-436a-a9ea-d61371f38254'),

-- Order 10: Jason Johnson
('8607ad87-77e2-4f5e-949b-9e5e9ceb23cc', 'JKT-DNM-BLU-L', 'Blue Denim Jacket Large', 1, 89.00, '2026-01-08 14:45:00', '52c09bfb-43e5-4c07-8e48-b94b690eef77', '93c6c3ba-bd90-40cd-81e8-25655cb1c623'),
('ac1a7486-1c6a-42bd-bbc6-b2519510c385', 'CAP-BASEBL-BLK', 'Black Baseball Cap', 1, 24.99, '2026-01-08 14:45:10', '52c09bfb-43e5-4c07-8e48-b94b690eef77', '2fff0ca1-2e90-46f8-ab3a-b0a5a4cc6cf8'),

-- Order 11: Olivia Ramirez
('b89a47b0-0e35-40df-88b5-0c4492332429', 'SHAM-500ML', 'Shampoo 500ml', 3, 12.99, '2026-01-09 20:30:00', 'bfb6afcb-8187-4364-8ba3-5a8f879ff07c', '633b051f-2ee6-4cce-8efe-988e06a1bf19'),

-- Order 12: Ethan Thompson
('ef1b8bec-f0d6-4f15-9ad3-9f259ee1a03e', 'FTBL-SKR-M', 'Soccer Skirt Medium', 2, 59.99, '2026-01-09 20:35:00', '5e15d690-a247-469f-983d-71c7766f2cc6', 'd5ec756f-1897-4fbb-942f-a3bb89c47275'),
('fc594bf6-ac82-43de-9803-22b41c27e053', 'YOGA-MAT-6MM', '6mm Yoga Mat', 1, 24.99, '2026-01-09 20:35:10', '5e15d690-a247-469f-983d-71c7766f2cc6', 'fb056435-a27c-4a0d-ad73-a72f83f88f54'),

-- Order 13: Isabella Nguyen
('7902436a-baba-4e73-b015-d88e436dbf3e', 'MOU-WRLS-ERG', 'Wireless Ergonomic Mouse', 1, 39.99, '2026-01-09 20:40:00', '6341b4e0-175a-4b9b-9b3b-d541056b3821', '54c87dbf-77f6-437d-a37e-5ec09313f3de'),

-- Order 14: Noah Patel
('55976b5a-a37e-4a2d-8f19-5d20f3ad2e17', 'PHN-CASE-IP16', 'iPhone 16 Case', 4, 34.99, '2026-01-09 20:45:00', '38d204e5-b780-4678-9770-b3d5b7bc7dbc', '0b67918f-374c-4004-aba0-010aca518f3f'),
('01e31500-a9a1-44db-bb58-d08bac09098d', 'CHRG-CBL-USBC', 'USB-C Charging Cable', 2, 9.99, '2026-01-09 20:45:10', '38d204e5-b780-4678-9770-b3d5b7bc7dbc', '0a0f13ca-5ce5-46fb-bf42-1ad60cadd256'),

-- Order 15: Ava Kim
('bf84a67a-4808-466c-983e-6c05cef27fc1', 'HOD-BLK-XL', 'Black Hoodie XL', 1, 49.99, '2026-01-09 20:50:00', 'd5fe1060-c73a-435e-a393-8fe899926311', '971ff03b-62ec-4209-837d-46ef181fe602'),
('0f92db74-be0f-4c98-ae94-bc039c1101bf', 'SOCK-PK6-WHT', 'White Sock Pack (6)', 2, 14.99, '2026-01-09 20:50:10', 'd5fe1060-c73a-435e-a393-8fe899926311', 'd5ec756f-1897-4fbb-942f-a3bb89c47275'),

-- Order 16: Lucas Rodriguez
('7c5b0d1c-dd0b-4601-ac25-55e8cc7b882b', 'PUZZ-1000PC', '1000-Piece Puzzle', 1, 19.99, '2026-01-09 20:55:00', '411c1c58-498b-4509-af12-def9ad028893', 'ee45609f-d1bb-4b0b-a17d-10fdc92ef1c9'),
('4e2b1ea3-30f3-42e7-addf-e789a3f42077', 'DRON-KID-4K', 'Kids 4K Drone', 1, 79.99, '2026-01-09 20:55:10', '411c1c58-498b-4509-af12-def9ad028893', '8cddafb2-1ed7-4057-97ba-52074d75d59c'),

-- Order 17: Mia Anderson
('31d7b444-807c-4aec-a428-d7403c6dd696', 'SHEET-SET-QN', 'Queen Sheet Set', 1, 59.99, '2026-01-09 21:00:00', '03eb989c-1692-4072-a9ea-fe4199664f12', '7531f0d0-bc31-4fe1-bd5c-30ac49d72bc7'),
('8bbb9c92-8fa8-40ff-bdfc-d4ffcd05a157', 'COFF-MKR-12C', '12-Cup Coffee Maker', 1, 69.99, '2026-01-09 21:00:10', '03eb989c-1692-4072-a9ea-fe4199664f12', '4ebd64af-9faa-4322-9ca1-99af78ebbc4a'),

-- Order 18: Benjamin Wright
('a01cefaa-02dd-4107-a64a-31340ae9656b', 'PRFUME-50ML', 'Perfume 50ml', 1, 89.00, '2026-01-09 21:05:00', '194fdbbb-6442-4358-b5f6-fa3548def1fa', '8b0f8a4b-1448-4189-b5f1-c08c7ae0f844'),

-- Order 19: Alan Harper
('b70ba798-c8d5-4c87-944a-a3d4e7bdc1fc', 'BIKE-HELM-M', 'Medium Bike Helmet', 1, 64.99, '2026-01-09 21:10:00', '3e2c7e16-7f39-4165-9bae-c88a9abadf7b', '95a11c51-b017-4b27-9933-dccddc1f2a08'),
('5ae7578f-63b6-4129-9e34-475c622f2a38', 'YOGA-MAT-6MM', '6mm Yoga Mat', 2, 24.99, '2026-01-09 21:10:10', '3e2c7e16-7f39-4165-9bae-c88a9abadf7b', 'fb056435-a27c-4a0d-ad73-a72f83f88f54'),
('446bc1db-9771-4590-bbb3-bbc1d41f2b45', 'FTBL-SKR-M', 'Soccer Skirt Medium', 1, 59.99, '2026-01-09 21:10:20', '3e2c7e16-7f39-4165-9bae-c88a9abadf7b', 'd5ec756f-1897-4fbb-942f-a3bb89c47275'),

-- Order 20: Jake Harper
('84d1c072-dbf3-400e-aa23-f0760f83959f', 'ISBN-978014312', 'Book: The Great Gatsby', 1, 14.95, '2026-01-10 12:50:00', 'a4a596eb-7429-46cb-986c-173b6f345125', 'b13384a8-a4d0-43b5-bc3d-bcabd62d402f'),

-- Order 21: Charlie Harper
('3b373480-f88d-4291-8999-ea19e8febabb', 'WRLS-HP-001', 'Wireless Headphones Premium', 1, 799.99, '2026-01-10 13:00:00', 'e02b7a37-8ce0-42f3-ad72-38159e598da6', '52ac1e08-2ccb-4c6f-9694-238da5cf7f53');


INSERT INTO public.privilege (id,
                              name,
                              resource_name,
                              read_privilege,
                              write_privilege,
                              update_privilege,
                              delete_privilege)
VALUES ('e5a46dec-51f2-4cf7-aafc-9b1e3d5a00f1', 'Order FA', 'Order', true, true, true, true),
       ('5915143b-a5ec-4f10-a830-478a31e73c20', 'Order R/W', 'Order', true, true, true, false),
       ('76063414-b71f-42c1-9c4e-09716d35153d', 'Order R/C', 'Order', true, true, false, false),
       ('011e344c-1e32-4b72-9541-51bad77458b5', 'Order R', 'Order', true, false, false, false) ON CONFLICT DO NOTHING;

INSERT INTO public.role (id,
    name)
VALUES ('ccdc3990-98b3-4022-bb4a-ca70d5d10ab7', 'ROLE_ADMIN'),
       ('94e83ffc-15d1-4498-8e96-38f0b65360d1', 'ROLE_MANAGER'),
       ('fd72b270-1b87-4a75-bc68-1ea9ff34ef32', 'ROLE_EMPLOYEE'),
       ('586afaa4-2107-4f2b-bdb4-56c55a5f33f7', 'ROLE_TRAINEE') ON CONFLICT DO NOTHING;

INSERT INTO public.app_user (id,
                             email,
                             username,
                             password,
                             active,
                             admin,
                             mfa_type,
                             created_at,
                             created_by)
VALUES
    -- 1. Regular user (just signed up, not yet activated)
    ('4b76f15c-afc4-4b82-90a2-94bad52a5d62',
     'sarah.connor.1984@gmail.com',
     'sarahc84',
     '{bcrypt}$2y$12$udhJ9LrAuoz6CSvtWlSg2u0HwiU4ZV165rGQC6E0tpm5jFoWIi1Sa',
     false,
     false,
     'email',
     '2025-11-12 14:35:22',
     'system'),

    -- 2. Active normal user
    ('60559c7d-ec6b-4934-8485-0fce9c4ca4c3',
     'michael.rivera.work@proton.me',
     'mrivera89',
     '{bcrypt}$2y$12$cvbf/SS0yvGL4aK8umw86OywGpTwjpIm7ZAo4JK9kQsxUcQOX9Mp.',
     true,
     false,
     'authenticator',
     '2025-10-03 09:17:45',
     'system'),

    -- 3. Admin user
    ('2bfdf263-9a88-4d37-a44c-2bd9a19cd845',
     'admin.jessica@company.io',
     'jessica_admin98',
     '{bcrypt}$2y$12$ZsKLfGO5fDLnvLLpdTce0u2PfNCTSMzv.XWQ3EX8OU9oReCCCup.e',
     true,
     true,
     'email',
     '2025-06-15 11:22:10',
     'system'),

    -- 4. Another regular active user (using email as username)
    ('a33cb313-11b3-4807-9bac-b9a22cbfe274',
     'david.kim1999@outlook.com',
     'david.kim1999@outlook.com',
     '{bcrypt}$2y$12$It3Vxwm4R5N0JvEtgwiQqODpjADUfPCcdErLwxIAGdHckBDfO9JBq',
     true,
     false,
     'email',
     '2026-01-29 16:40:55',
     'system') ON CONFLICT (email) DO NOTHING; -- or (username) or (email, username) depending on your unique constraints


INSERT INTO public.role_privilege (fk_role_id, fk_privilege_id)
VALUES
    -- admin → full privileges on Order
    ('ccdc3990-98b3-4022-bb4a-ca70d5d10ab7', 'e5a46dec-51f2-4cf7-aafc-9b1e3d5a00f1'),

    -- manager → read/write/update (no delete)
    ('94e83ffc-15d1-4498-8e96-38f0b65360d1', '5915143b-a5ec-4f10-a830-478a31e73c20'),

    -- employee → read/write only
    ('fd72b270-1b87-4a75-bc68-1ea9ff34ef32', '76063414-b71f-42c1-9c4e-09716d35153d'),

    -- trainee → read only
    ('586afaa4-2107-4f2b-bdb4-56c55a5f33f7', '011e344c-1e32-4b72-9541-51bad77458b5')
    ON CONFLICT DO NOTHING;
INSERT INTO public.app_user_role (fk_role_id, fk_app_user_id)
VALUES
    -- Jessica → admin
    ('ccdc3990-98b3-4022-bb4a-ca70d5d10ab7', '2bfdf263-9a88-4d37-a44c-2bd9a19cd845'),

    -- Michael → manager
    ('94e83ffc-15d1-4498-8e96-38f0b65360d1', '60559c7d-ec6b-4934-8485-0fce9c4ca4c3'),

    -- David → employee
    ('fd72b270-1b87-4a75-bc68-1ea9ff34ef32', 'a33cb313-11b3-4807-9bac-b9a22cbfe274')

    -- Sarah has no role yet (can be added later when activated)
    ON CONFLICT DO NOTHING;

INSERT INTO public.app_user_privilege (fk_privilege_id, fk_app_user_id)
VALUES
    ('e5a46dec-51f2-4cf7-aafc-9b1e3d5a00f1', '2bfdf263-9a88-4d37-a44c-2bd9a19cd845')
ON CONFLICT DO NOTHING;
-- Sample / dummy data

INSERT INTO public.orders (id_viewable, name, street_1, street_2, city, state, postal_code, total,
                           creation_timestamp, marketplace, shipped, fulfilled, tracking_number, status, id)
VALUES (6, 'John Doe', '777 Spring Creek dr', NULL, 'Phoenix', 'AZ', '85392', 99.95,
        '2026-01-07 11:30:16.782001', 'Shopify', false, false, NULL, NULL, '439372ec-b842-4126-ba5c-bce27dddc714'),

       (9, 'Bob Upton', '7 Diane rd', '1', 'Columbia Falls', 'MT', '59912', 599.00,
        '2026-01-07 11:33:29.574796', 'Webment', false, false, NULL, NULL, 'cee4e056-b0c6-4b20-bd07-685911d0fc99'),

       (7, 'Jane blah', '1065 savannah rd', 'apt d302', 'Kalispell', 'MT', '59901', 1099.99,
        '2026-01-07 11:31:30.284662', 'Amazon', true, true, '1Z1251234512', NULL,
        '08217182-b30a-463d-9603-18556918db44'),

       (11, 'Alice Johnson', '123 Maple Street', 'Apt 4B', 'Seattle', 'WA', '98101', 89.99,
        '2026-01-09 10:43:18.262892', 'Amazon', false, false, NULL, NULL, 'aeb11b63-cb16-45bf-b05c-7c8634cca0c4'),

       (12, 'Robert Chen', '456 Oak Avenue', NULL, 'San Francisco', 'CA', '94107', 149.50,
        '2026-01-09 10:43:18.300402', 'eBay', false, false, NULL, NULL, '0ad0e2fc-c6ec-4a42-871a-170acb242644'),

       (13, 'Maria Gonzalez', '789 Elm Road', 'Suite 200', 'Austin', 'TX', '78701', 45.75,
        '2026-01-09 10:43:18.303490', 'Walmart', false, false, NULL, NULL, 'f5c4f92a-01a0-43ef-a90a-4fc4b2350d8b'),

       (14, 'James Wilson', '321 Pine Lane', NULL, 'Chicago', 'IL', '60614', 299.00,
        '2026-01-09 10:43:18.306175', 'Amazon', false, false, NULL, NULL, '529f9e98-c8c5-4770-81ef-19f999b506ae'),

       (15, 'Emma Davis', '555 Cedar Blvd', 'Unit 12', 'Denver', 'CO', '80202', 67.20,
        '2026-01-09 10:43:18.308729', 'Shopify', false, false, NULL, NULL, '7289a477-a20f-4a07-a9e1-bbe8ed2ee0dd'),

       (16, 'Liam Martinez', '246 Birch Street', NULL, 'Miami', 'FL', '33131', 124.99,
        '2026-01-09 10:43:18.311301', 'eBay', false, false, NULL, NULL, '0d98fd31-b56d-4415-85b2-cb32c1015024'),

       (10, 'Jason Johnson', '123 Division Street', 'Apt 4B', 'Spokane', 'WA', '99207', 102.00,
        '2026-01-08 14:41:00.921710', 'Stripe', true, false, '1Z423143123', 'shipped',
        '52c09bfb-43e5-4c07-8e48-b94b690eef77'),

       (19, 'Olivia Ramirez', '1420 Sunset Boulevard', 'Apt 305', 'Los Angeles', 'CA', '90026', 78.45,
        '2026-01-09 20:21:35.233767', 'Amazon', false, false, NULL, NULL, 'bfb6afcb-8187-4364-8ba3-5a8f879ff07c'),

       (20, 'Ethan Thompson', '819 Riverfront Drive', NULL, 'Boston', 'MA', '02108', 189.99,
        '2026-01-09 20:21:35.250574', 'eBay', false, false, NULL, NULL, '5e15d690-a247-469f-983d-71c7766f2cc6'),

       (21, 'Isabella Nguyen', '6734 Peachtree Street', 'Suite 140', 'Atlanta', 'GA', '30308', 34.20,
        '2026-01-09 20:21:35.252865', 'Walmart', false, false, NULL, NULL, '6341b4e0-175a-4b9b-9b3b-d541056b3821'),

       (22, 'Noah Patel', '2910 Highland Avenue', 'Unit 7', 'Phoenix', 'AZ', '85016', 256.80,
        '2026-01-09 20:21:35.255283', 'Amazon', false, false, NULL, NULL, '38d204e5-b780-4678-9770-b3d5b7bc7dbc'),

       (23, 'Ava Kim', '4582 Lakeview Terrace', NULL, 'Las Vegas', 'NV', '89109', 112.30,
        '2026-01-09 20:21:35.257649', 'Shopify', false, false, NULL, NULL, 'd5fe1060-c73a-435e-a393-8fe899926311'),

       (24, 'Lucas Rodriguez', '305 Forest Hills Road', 'Apt 22', 'Nashville', 'TN', '37215', 95.60,
        '2026-01-09 20:21:35.260113', 'eBay', false, false, NULL, NULL, '411c1c58-498b-4509-af12-def9ad028893'),

       (25, 'Mia Anderson', '1776 Liberty Lane', NULL, 'Philadelphia', 'PA', '19103', 167.75,
        '2026-01-09 20:21:35.262460', 'Amazon', false, false, NULL, NULL, '03eb989c-1692-4072-a9ea-fe4199664f12'),

       (26, 'Benjamin Wright', '8902 Coastal Highway', 'Condo 409', 'San Diego', 'CA', '92101', 43.99,
        '2026-01-09 20:21:35.264752', 'Walmart', false, false, NULL, NULL, '194fdbbb-6442-4358-b5f6-fa3548def1fa'),

       (27, 'Alan Harper', '2320 Pacific Coast Highway', 'Beach House B', 'Malibu', 'CA', '90265', 158.40,
        '2026-01-09 20:22:16.570654', 'Amazon', true, false, '1Z5A7B9C0234567890', 'shipped',
        '3e2c7e16-7f39-4165-9bae-c88a9abadf7b'),

       (29, 'Jake Harper', '417 Palm Breeze Drive', 'Unit 12B', 'Malibu', 'CA', '90265', 20.99,
        '2026-01-10 12:45:43.980123', 'Shopify', true, false, '1Z9A7B9C5234567980', 'shipped',
        'a4a596eb-7429-46cb-986c-173b6f345125'),

       (30, 'Charlie Harper', '23850 Pacific Coast Highway', 'Suite 4', 'Malibu', 'CA', '90265', 489.99,
        '2026-01-10 12:50:26.288178', 'Shopify', false, false, NULL, NULL,
        'e02b7a37-8ce0-42f3-ad72-38159e598da6') ON CONFLICT DO NOTHING;

INSERT INTO public.privilege (id,
                              resource_name,
                              read_privilege,
                              write_privilege,
                              update_privilege,
                              delete_privilege,)
VALUES ('e5a46dec-51f2-4cf7-aafc-9b1e3d5a00f1', "Order", true, true, true, true),
       ('5915143b-a5ec-4f10-a830-478a31e73c20', "Order", true, true, true, false),
       ('76063414-b71f-42c1-9c4e-09716d35153d', "Order", true, true, false, false),
       ('011e344c-1e32-4b72-9541-51bad77458b5', "Order", true, false, false, false) ON CONFLICT DO NOTHING;

INSERT INTO public.role (id
    name)
VALUES ('ccdc3990-98b3-4022-bb4a-ca70d5d10ab7', 'admin'),
       ('94e83ffc-15d1-4498-8e96-38f0b65360d1', 'manager'),
       ('fd72b270-1b87-4a75-bc68-1ea9ff34ef32', 'employee'),
       ('586afaa4-2107-4f2b-bdb4-56c55a5f33f7', 'trainee') ON CONFLICT DO NOTHING;

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
     '$2b$12$8Kj9pL.mF7xWvQ3zT9rY/.uJ5kH8nL2pQvR6tY1wX3eZ0aB9cD8eF',
     false,
     false,
     'email',
     '2025-11-12 14:35:22',
     'system'),

    -- 2. Active normal user
    ('60559c7d-ec6b-4934-8485-0fce9c4ca4c3',
     'michael.rivera.work@proton.me',
     'mrivera',
     '{bcrypt}$2b$12$4nX7vPqR2tY9wZ1aB8cD6.eF3kH5mL0pQvT8uJ2xW4zY6aR9bN1cV',
     true,
     false,
     'authenticator',
     '2025-10-03 09:17:45',
     'system'),

    -- 3. Admin user
    ('2bfdf263-9a88-4d37-a44c-2bd9a19cd845',
     'admin.jessica@company.io',
     'jessica_admin',
     '{bcrypt}$2b$12$kP9mW3xQ8vT2rY7zA4cB6.nL1pF5uJ0wX9eD3tR6yZ2aB8cV4qN0m',
     true,
     true,
     'email',
     '2025-06-15 11:22:10',
     'system'),

    -- 4. Another regular active user (using email as username)
    ('a33cb313-11b3-4807-9bac-b9a22cbfe274',
     'david.kim1999@outlook.com',
     'david.kim1999@outlook.com',
     '{bcrypt}$2b$12$7tY2pL9xW4vR8zQ3aB6cD.eF1kH0mN5uJ9wX2tY6rZ4aP8bV3qC0n',
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
    -- Give Jessica the full Order privilege directly (in addition to role)
    -- (demonstrates override / extra power scenario)
    ('e5a46dec-51f2-4cf7-aafc-9b1e3d5a00f1', '2bfdf263-9a88-4d37-a44c-2bd9a19cd845'),

-- Give Michael one extra granular privilege (e.g. read-only on something else later)
-- ('some-other-privilege-id', '60559c7d-ec6b-4934-8485-0fce9c4ca4c3')
-- (commented out — add only if you later create more resources)
ON CONFLICT DO NOTHING;
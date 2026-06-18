INSERT INTO meal (name, description, price, category, is_available)
SELECT 'Jollof Rice', 'Classic Nigerian Jollof Rice cooked with tomatoes and spices', 15.99, 'Ready Meals', true
    WHERE NOT EXISTS (SELECT 1 FROM meal WHERE name = 'Jollof Rice');

INSERT INTO meal (name, description, price, category, is_available)
SELECT 'Egusi Soup', 'Rich melon seed soup with vegetables and assorted meat', 30.00, 'Ready Meals', true
    WHERE NOT EXISTS (SELECT 1 FROM meal WHERE name = 'Egusi Soup');

INSERT INTO meal (name, description, price, category, is_available)
SELECT 'Bitterleaf Soup', 'Traditional soup made with bitterleaf and cocoyam', 26.50, 'Ready Meals', true
    WHERE NOT EXISTS (SELECT 1 FROM meal WHERE name = 'Bitterleaf Soup');

INSERT INTO meal (name, description, price, category, is_available)
SELECT 'Nkwobi', 'Spicy cow foot delicacy served with palm oil sauce', 45.00, 'Party Menu', true
    WHERE NOT EXISTS (SELECT 1 FROM meal WHERE name = 'Nkwobi');

INSERT INTO meal (name, description, price, category, is_available)
SELECT 'Goat Peppersoup', 'Hot and spicy goat meat soup with herbs', 35.00, 'Ready Meals', true
    WHERE NOT EXISTS (SELECT 1 FROM meal WHERE name = 'Goat Peppersoup');

INSERT INTO meal (name, description, price, category, is_available)
SELECT 'Asun', 'Peppered smoked goat meat — a Nigerian party favourite', 40.00, 'Party Menu', true
    WHERE NOT EXISTS (SELECT 1 FROM meal WHERE name = 'Asun');

INSERT INTO meal (name, description, price, category, is_available)
SELECT 'Okra Soup', 'Fresh okra soup with assorted seafood and meat', 28.00, 'Ready Meals', true
    WHERE NOT EXISTS (SELECT 1 FROM meal WHERE name = 'Okra Soup');
-- Lookup tables
INSERT INTO meal_types (name) VALUES
                                  ('breakfast'), ('lunch'), ('dinner'), ('main course'),
                                  ('appetizer'), ('salad'), ('dessert'), ('drink');

INSERT INTO dish_types (name) VALUES
                                  ('soup'), ('stew'), ('pasta'), ('pizza'), ('sandwich'), ('burger'),
                                  ('risotto'), ('meat dish'), ('fish dish'), ('vegetable dish'),
                                  ('bakery product'), ('cake'), ('torte'), ('pancakes');

INSERT INTO diet_types (name) VALUES
                                  ('vegetarian'), ('vegan'), ('lenten'), ('non-lenten'), ('chrono'), ('pescatarian');

INSERT INTO ingredient_categories (name) VALUES
                                             ('vegetables'), ('fruit'), ('meat'), ('fish'), ('dairy'),
                                             ('grains'), ('spices'), ('nuts');

INSERT INTO allergens (name) VALUES
                                 ('gluten'), ('milk'), ('eggs'), ('peanuts'), ('tree nuts'),
                                 ('soy'), ('fish'), ('crustaceans'), ('sesame'), ('celery'), ('mustard');

-- ingredients
INSERT INTO ingredients (name, category_id, unit, type) VALUES
                                                            ('flour', (SELECT id FROM ingredient_categories WHERE name = 'grains'), 'GRAM', 'GENERIC'),
                                                            ('milk', (SELECT id FROM ingredient_categories WHERE name = 'dairy'),'MILLILITER', 'GENERIC'),
                                                            ('egg', (SELECT id FROM ingredient_categories WHERE name = 'dairy'), 'PIECE', 'GENERIC'),
                                                            ('peanuts',(SELECT id FROM ingredient_categories WHERE name = 'nuts'), 'GRAM', 'GENERIC'),
                                                            ('salt', (SELECT id FROM ingredient_categories WHERE name = 'spices'), 'GRAM', 'GENERIC'),
                                                            ('tomato', (SELECT id FROM ingredient_categories WHERE name = 'vegetables'), 'PIECE', 'GENERIC'),
                                                            ('chicken', (SELECT id FROM ingredient_categories WHERE name = 'meat'), 'GRAM', 'GENERIC');

-- branded ingredient
INSERT INTO ingredients (name, category_id, unit, type, brand, text_color) VALUES
    ('yogurt', (SELECT id FROM ingredient_categories WHERE name = 'dairy'), 'MILLILITER', 'BRANDED', 'Imlek', '#1E88E5');

-- ingredient and allergen links
INSERT INTO ingredient_allergens (ingredient_id, allergen_id) VALUES
                                                                  ((SELECT id FROM ingredients WHERE name = 'flour'), (SELECT id FROM allergens WHERE name = 'gluten')),
                                                                  ((SELECT id FROM ingredients WHERE name = 'milk'), (SELECT id FROM allergens WHERE name = 'milk')),
                                                                  ((SELECT id FROM ingredients WHERE name = 'egg'), (SELECT id FROM allergens WHERE name = 'eggs')),
                                                                  ((SELECT id FROM ingredients WHERE name = 'peanuts'), (SELECT id FROM allergens WHERE name = 'peanuts')),
                                                                  ((SELECT id FROM ingredients WHERE name = 'yogurt'), (SELECT id FROM allergens WHERE name = 'milk'));
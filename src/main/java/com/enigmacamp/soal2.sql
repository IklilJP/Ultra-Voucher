SELECT t.id, t.name, tc.name AS parent_name
FROM tabel t
         LEFT JOIN tabel tc ON t.parent_id = tc.id;

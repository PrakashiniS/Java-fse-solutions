SELECT
    e.event_id,
    e.title,
    COUNT(
        CASE
            WHEN r.resource_type = 'pdf' THEN 1
        END
    ) AS pdf_count,
    COUNT(
        CASE
            WHEN r.resource_type = 'image' THEN 1
        END
    ) AS image_count,
    COUNT(
        CASE
            WHEN r.resource_type = 'link' THEN 1
        END
    ) AS link_count
FROM Events e
    LEFT JOIN Resources r ON e.event_id = r.event_id
GROUP BY
    e.event_id,
    e.title
ORDER BY e.event_id;
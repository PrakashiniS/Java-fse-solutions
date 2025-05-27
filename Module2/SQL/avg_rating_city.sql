SELECT e.city, AVG(f.rating) AS average_rating
FROM Events e
    JOIN Feedback f ON e.event_id = f.event_id
GROUP BY
    e.city
ORDER BY average_rating DESC;
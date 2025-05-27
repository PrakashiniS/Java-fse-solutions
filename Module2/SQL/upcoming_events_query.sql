SELECT e.event_id, e.title, e.description, e.city, e.start_date, e.end_date, e.status
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
JOIN Users u ON r.user_id = u.user_id
WHERE u.user_id = 1
  AND e.status = 'upcoming'
  AND e.city = u.city
ORDER BY e.start_date ASC;

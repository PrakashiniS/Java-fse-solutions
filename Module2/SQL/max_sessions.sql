SELECT e.event_id, e.title, COUNT(s.session_id) AS session_count
FROM Events e
    JOIN Sessions s ON e.event_id = s.event_id
GROUP BY
    e.event_id,
    e.title
HAVING
    session_count = (
        SELECT MAX(session_counts)
        FROM (
                SELECT COUNT(session_id) AS session_counts
                FROM Sessions
                GROUP BY
                    event_id
            ) AS counts
    );
SELECT speaker_name, COUNT(*) AS session_count
FROM Sessions
GROUP BY
    speaker_name
HAVING
    COUNT(*) > 1;
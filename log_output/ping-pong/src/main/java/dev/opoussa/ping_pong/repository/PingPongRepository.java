package dev.opoussa.ping_pong.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PingPongRepository {

    private final JdbcTemplate jdbcTemplate;

    public PingPongRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer getCount() {
        return jdbcTemplate.queryForObject(
            "SELECT value FROM ping_pong_count WHERE singleton = TRUE",
            Integer.class
        );
    }

    public Integer incrementCount() {
    return jdbcTemplate.queryForObject(
        """
        UPDATE ping_pong_count
        SET value = value + 1
        WHERE singleton = TRUE
        RETURNING value
        """,
        Integer.class
    );
}

}


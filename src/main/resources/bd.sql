
CREATE TABLE IF NOT EXISTS bookings (
                                        id SERIAL PRIMARY KEY,
                                        user_id INTEGER NOT NULL,
                                        place_id INTEGER NOT NULL,
                                        time_from TIMESTAMP NOT NULL,
                                        time_to TIMESTAMP NOT NULL
);
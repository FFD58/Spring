package ru.fafurin.lesson4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.fafurin.lesson4.DBQueriesConfig;
import ru.fafurin.lesson4.mapper.UserMapper;
import ru.fafurin.lesson4.model.User;

import java.util.List;


@Repository
public class UserRepository {

    @Autowired
    private final JdbcTemplate jdbc;

    @Autowired
    private DBQueriesConfig dbQueriesConfig;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        return jdbc.query(dbQueriesConfig.getSelectAllUsers(), new UserMapper());
    }

    public User findById(int id) {
        return jdbc.queryForObject(dbQueriesConfig.getSelectUserById(), new UserMapper(), id);
    }

    public User save(User user) {
        jdbc.update(dbQueriesConfig.getInsertUser(), user.getFirstName(), user.getLastName());
        return user;
    }

    public User update(User user) {
        jdbc.update(dbQueriesConfig.getUpdateUser(), user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }

    public void deleteById(int id) {
        jdbc.update(dbQueriesConfig.getDeleteUser(), id);
    }

}
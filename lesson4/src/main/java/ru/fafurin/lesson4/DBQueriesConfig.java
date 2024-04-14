package ru.fafurin.lesson4;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("sql")
@Data
public class DBQueriesConfig {
    private String selectAllUsers;
    private String selectUserById;
    private String insertUser;
    private String updateUser;
    private String deleteUser;
}

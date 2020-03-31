package cc.webkit.guide.mapper;

import cc.webkit.guide.model.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");

        Admin admin = new Admin();
        admin.setPassword(password);
        admin.setUsername(username);
        return admin;
    }
}

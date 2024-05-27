import com.example.pojo.User;
import com.example.utils.JDBCUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class ExamTest {

    @org.junit.jupiter.api.Test
    public void test01() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM user";
        //template.queryForList(sql).forEach(System.out::println);
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void test02() {
        Date currentDate = new Date();
        System.out.println(currentDate);
        System.out.println(currentDate.toGMTString());
    }
}

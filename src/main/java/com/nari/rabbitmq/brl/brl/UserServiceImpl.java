package com.nari.rabbitmq.brl.brl;

import com.nari.rabbitmq.brl.UserService;
import com.nari.wm.entity.Sc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Sc> getAllSc() {
        StringBuffer sql = new StringBuffer("select * from SC");
        List<Sc> list = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Sc.class));
        return list;
    }
}
